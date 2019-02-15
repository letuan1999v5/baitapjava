import javax.swing.*;
import java.awt.*;

public class CuaSoGame {
    public static void main(String[] args){
        JFrame window = new JFrame();
        window.setVisible(true);
        window.setSize(800,600);
        window.setResizable(false);
        window.setTitle("TouHou");
        JPanel panel = new JPanel();
        window.add(panel);
        panel.setBackground(Color.WHITE);
    }
}
