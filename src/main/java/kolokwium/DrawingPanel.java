package kolokwium;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

public class DrawingPanel extends JPanel {
    private Point x1y1, x2y2;
    private List<Rectangle> rectangles = new ArrayList<>();
    private final int speed;

    private void createNewRectangle(Point p1, Point p2, int speed) {
        Rectangle temp = new Rectangle(p1, p2, speed, this);
        rectangles.add(temp);
        Thread t = new Thread(temp);
        t.start(); // kazdy prostokąt dostaje swoj wlasny wątek
    }

    public DrawingPanel(int dx){
        //setFocusable(true); // focus na panel
        this.speed = dx;
    // funkcje mouse pressed i mouse released nasluchują na zdarzenia myszy
        // jest to zamiast jawnej implementacji interfejsu mouselistener prostsza forma nadpisania tych metod poprzez użycie MouseAdapter
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x1y1 = e.getPoint(); // zbieramy pierwszy punkt
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                x2y2 = e.getPoint(); // zbieramy drugi punkt i tworzymy prostokąt
                createNewRectangle(x1y1, x2y2, speed); // prędkość prostokąta
            }
        });
        setBackground(Color.GRAY);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        for(Rectangle temp : rectangles){
            temp.draw(g);
        }
    }
}
