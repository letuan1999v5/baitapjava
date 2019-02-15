package Game1;

import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {
    BufferedImage backgroundImage;
    BufferedImage playerImage;
    int backgroundX;
    int backgroundY;
    int playerX;
    int playerY;

    public GamePanel() {
        backgroundImage = SpriteUtils.loadImage("assets/images/background/0.png");
        playerImage = SpriteUtils.loadImage("assets/images/players/straight/2.png");
        backgroundX = 0;
        backgroundY = 600 - 3109;
        playerX = 200;
        playerY = 500;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(backgroundImage, backgroundX, backgroundY, null);
        g.drawImage(playerImage, playerX, playerY, null);
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
        if (backgroundY <= 0) {
            backgroundY += 2;
        }
        if (playerX==31) {
            playerX+=1  ;
        }
        if (playerX==400-31){
            playerX-=1;
        }
        if (playerY==47){
            playerY+=1;
        }
        if (playerY==600-47) {
            playerY -= 1;
        }
        if (GameWindow.isUpPress) {
            playerY -= 2;
        }
        if (GameWindow.isDownPress) {
            playerY += 2;
        }
        if (GameWindow.isLeftPress) {
            playerX -= 2;
        }
        if (GameWindow.isRightPress) {
            playerX += 2;
        }
    }
}

