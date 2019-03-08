package game.Enemy;

import game.GameObject;
import game.Settings;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class EnemyBullet extends GameObject
{


    public EnemyBullet()
    {
        BufferedImage image = SpriteUtils.loadImage("assets/images/enemies/bullets/cyan.png");
        velocity.set(1,1);
        velocity.setLength(Settings.PLAYER_BULLET_SPEED);
    }

    @Override
    public void run(){
        super.run();
        this.deactiveIfNeeded();
    }

    private void deactiveIfNeeded() {
        if(this.position.y<50
        ||this.position.y>Settings.GAME_HEIGHT+30
        ||this.position.x<-30
        ||this.position.x>Settings.GAME_WIDTH){
            this.deactive();
        }
    }

}