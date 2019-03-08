package game.player;

import game.GameObject;
import game.renderer.AnimationRenderer;
import game.GameWindow;
import java.util.Random;
import game.Settings;

public class Player extends GameObject {
    int fireCount, fireCount1, fireCount2, bulletType, changeBulletCount;
    Random random;

    public Player() {
//        image = SpriteUtils.loadImage("assets/images/players/straight/2.png");
        renderer = new AnimationRenderer("assets/images/players/straight",10);
        position.set(200, 500);
        fireCount = 0;
        bulletType = 1;
        changeBulletCount = 0;
        random = new Random();
    }


    private void playerMove() {
        int vX = 0;
        int vY = 0;
        if (GameWindow.isUpPress) {
            vY--;
        }
        if (GameWindow.isDownPress) {
            vY++;
        }
        if (GameWindow.isLeftPress) {
            vX--;
        }
        if (GameWindow.isRightPress) {
            vX++;
        }
        this.velocity.set(vX, vY);
        this.velocity.setLength(Settings.PLAYER_SPEED);
    }

    @Override
    public void run() {
        super.run();
        playerMove();
        playerLimit();
        playerFire();
        changeBulletType();
    }

    private void playerFire() {
        fireCount++;
        fireCount1++;
        fireCount2++;
        if (GameWindow.isFirePress && fireCount > 20) {
            for (int i = 0; i < 1; i++) {
                PlayerBullet bullet = GameObject.recycle(PlayerBullet.class);
                bullet.position.set(this.position.x, this.position.y);
                bullet.velocity.setAngle(-Math.PI * 0.5);
            }
            fireCount = 0;
        }
    }

    private void changeBulletType() {
        changeBulletCount++;
        if (changeBulletCount > 300) {
            Random random = new Random();
            bulletType = 1 + random.nextInt(3);
            changeBulletCount = 0;
        }
    }

    private void playerLimit() {
        double offsetWidth = anchor.x * Settings.PLAYER_WIDTH;
        double offsetHeight = anchor.y * Settings.PLAYER_HEIGHT;
        if (position.x <= offsetWidth) {
            position.x = offsetWidth;
        }
        if (position.x >= Settings.BACKGROUND_WIDTH - offsetWidth) {
            position.x = Settings.BACKGROUND_WIDTH - offsetWidth;
        }\
        if (position.y <= offsetHeight) {
            position.y = offsetHeight;
        }
        if (position.y >= Settings.GAME_HEIGHT - offsetHeight) {
            position.y = Settings.GAME_HEIGHT - offsetHeight;
        }
    }
}
