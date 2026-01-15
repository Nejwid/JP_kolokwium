package kolokwium;

import javax.swing.*;
import java.awt.*;

public class Rectangle implements Runnable{
    private int x1, y1, x2, y2, w, h; // punkt poczatkowy i szerokosc/wysokosc bo takie parametry potrzebne są do funkcji rysowania
    private final int speed; // predkosc przemieszczania
    private JPanel panel; // potrzebny do sprawdzenia prawej krawędzi i do odswiezenia panelu

    public Rectangle(Point p1, Point p2, int speed, JPanel panel) {
        this.x1 = p1.x;
        this.y1 = p1.y;
        this.x2 = p2.x;
        this.y2 = p2.y;
        this.w = Math.abs(p1.x-p2.x);
        this.h = Math.abs(p1.y-p2.y);
        this.speed = speed;
        this.panel = panel;
    }

    // prostokąt działa w wątku wywolanym w panelu tak dlugo jak dlugo wykonuje sie jego metoda run()
    @Override
    public void run() {
        while(true){ // prawa krawedz to szerokosc panelu (punkt 0,0 to lewy gorny róg)
            if(x1 + w + speed < panel.getWidth()) {
                x1 += speed;
            } else {
                x1 = 0;
            }
            panel.repaint();
            try{
                Thread.sleep(50);
            } catch(InterruptedException e){
                throw new RuntimeException("thread failed");
            }
        }
    }

    // prostokat sam wie jak ma wygladac, ale metode rysowania wywoluje panel
    public void draw(Graphics g){
        g.fillRect(x1, y1, w, h);
    }
}
