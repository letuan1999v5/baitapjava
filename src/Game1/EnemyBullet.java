package game;

import Game1.GameObject;
import Game1.Settings;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject
{
    static BufferedImage type1Image = SpriteUtils.loadImage("assets/images/enemies/bullets/cyan.png");
    static BufferedImage type2Image = SpriteUtils.loadImage("assets/images/enemies/bullets/green.png");

    public EnemyBullet()
    {
        velocity.set(1,1);
        velocity.setLength(Settings.PLAYER_BULLET_SPEED);
    }

    public void loadImageByType(int type) {
        switch (type)
        {
            case 1:
                this.image = type1Image;
                break;
            case 2:
                this.image = type2Image;
                break;
            default:
                this.image = type1Image;
        }
    }
}