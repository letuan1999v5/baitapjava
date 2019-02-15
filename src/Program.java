import Game1.GamePanel;
import Game1.GameWindow;

import javax.swing.*;
import java.awt.*;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {
    public static void main(String[] args) {
        GameWindow window = new GameWindow();
        window.setSize(400, 600);
        window.setResizable(false);
        window.setTitle("TouHou");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GamePanel panel = new GamePanel();
        window.add(panel);
        panel.setBackground(Color.CYAN);
        window.setVisible(true);
        panel.gameLoop();

    }
}
