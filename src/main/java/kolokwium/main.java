package kolokwium;

import javax.swing.*;

// funkcja main ma byc jak najmniejsza
public class main {
    public static void main(String args[]){
        SwingUtilities.invokeLater(()->{
            new MainFrame();
        });
    }
}
