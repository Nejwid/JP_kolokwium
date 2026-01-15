package kolokwium;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame(){
        JFrame frame = new JFrame("kolokwium wersja 1P");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        DrawingPanel panel = new DrawingPanel(5); // dx to odleglsoc pojedynczego przemieszczenia
        frame.add(panel);
        frame.setVisible(true);
    }
}
