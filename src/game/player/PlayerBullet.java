package game.player;

import game.Enemy.Enemy;
import game.GameObject;
import game.Settings;
import game.physics.BoxCollider;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject {
    static BufferedImage type1Image = SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
    static BufferedImage type2Image = SpriteUtils.loadImage("assets/images/enemies/bullets/cyan.png");
    static BufferedImage type3Image = SpriteUtils.loadImage("assets/images/enemies/bullets/yellow.png");
    public int damage;

    public PlayerBullet() {
        collider = new BoxCollider(Settings.PLAYER_BULLET_SPEED);
        velocity.set(1, 1);
        velocity.setLength(Settings.PLAYER_BULLET_SPEED);
        damage = 1;
    }

    @Override
    public void run() {
        super.run();
        this.deactiveIfNeeded();
        checkIntersects();
        }

    private void checkIntersects() {
        Enemy enemy = GameObject.findIntersects(Enemy.class, this.collider);
        if(enemy != null){
            //TODO: da va cham
            deactive();
            enemy.takeDamage(damage);
        }
    }

    private void deactiveIfNeeded(){
        if(this.position.y < -30){
            this.deactive();
        }
    }

}