package Game1;

import Game1.enemy.Enemy;
import Game1.player.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Background background;
    Player player;
    Enemy enemy;

    public GamePanel() {
        background = new Background();
        player = new Player();
        enemy = new Enemy();
    }

    @Override
    public void paint(Graphics g) {
        //ve anh
        for (int i = 0; i < GameObject.objects.size(); i++) {
            GameObject object = GameObject.objects.get(i);
            if (object.active) {
                object.render(g);
            }
        }
    }


    public void gameLoop() {
        long lastTime = 0;
        long delay = 1000 / 60;
        while (true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTime >= delay) {
                //ve anh + chay logic
                System.out.println(currentTime - lastTime);
                runAll();
                renderAll();
                lastTime = currentTime;

            }
        }
    }

    private void renderAll() {
        repaint();
    }

    private void runAll() {
        for (int i = 0; i < GameObject.objects.size(); i++) {
            GameObject object = GameObject.objects.get(i);
            if (object.active) {
                object.run();
            }
        }
    }
}

