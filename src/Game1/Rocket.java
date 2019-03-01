package Game1;

import tklibs.SpriteUtils;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Rocket {
    BufferedImage image;
    Vector2D position;
    Vector2D velocity;

    public Rocket() {
        image = SpriteUtils.loadImage("assets/images/player-bullets/rocket4.png");
        position = new Vector2D();
        velocity = new Vector2D(7, 7);
    }


    public void render(Graphics g) {
        g.drawImage(image,
                (int) position.x,
                (int) position.y,
                null);
    }

    public void run() {
        this.position.add(velocity.x, velocity.y);
    }
}
