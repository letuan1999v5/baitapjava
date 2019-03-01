package Game1;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class Player extends GameObject{
    ArrayList<Rocket> rockets;
    ArrayList<SpecialBullet> specials;
    int fireCount, fireCount1, fireCount2,bulletType,changeBulletCount;
    Random random;

    public Player() {
        image = SpriteUtils.loadImage("assets/images/players/straight/2.png");
        position.set(200,500);
        rockets = new ArrayList<>();
        specials = new ArrayList<>();
        fireCount = 0;
        fireCount1 = 0;
        fireCount2 = 0;
        bulletType = 1;
        changeBulletCount = 0;
        random = new Random();
    }
    @Override
    public void render(Graphics g) {
                super.render(g);
                for (int j = 0; j < rockets.size(); j++) {
            Rocket rocket = rockets.get(j);
            rocket.render(g);
        }
        for (int k = 0; k < specials.size(); k++) {
            SpecialBullet special = specials.get(k);
            special.render(g);
        };
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
        this.velocity.set(vX,vY);
        this.velocity.setLength(1);
    }
    @Override
    public void run() {
        super.run();
        playerMove();
        playerLimit();
        playerFire();
        changeBulletType();
        rocketsRun();
        specialsRun();
    }




    private void rocketsRun() {
        for (int k = 0; k < rockets.size(); k++) {
            Rocket rocket = rockets.get(k);
            rocket.run();
        }
    }

    private void specialsRun() {
        for (int l = 0; l < specials.size(); l++) {
            SpecialBullet special = specials.get(l);
            special.run();
        }
    }


    private void playerFire() {
        fireCount++;
        fireCount1++;
        fireCount2++;
        if (GameWindow.isFirePress && fireCount > 20) {
            PlayerBullet bullet = new PlayerBullet(bulletType);
            bullet.loadImageByType(bulletType);
            bullet.position.set(this.position.x, this.position.y);
            bullet.velocity.setAngle(-Math.PI * 0.5);
            fireCount = 0;
        }
        if (GameWindow.isRocketPress && fireCount1 > 200) {
            Rocket rocket = new Rocket();
            rocket.position.set(this.position.x, this.position.y);
            rocket.velocity.setAngle(-Math.PI * 0.5);
            rockets.add(rocket);
            fireCount1 = 0;
        }

        if (GameWindow.isSpecialPress && fireCount2 > 500  ) {
            SpecialBullet special = new SpecialBullet();
            special.position.set(-170,Settings.BACKGROUND_HEIGHT);
            special.velocity.setAngle(-Math.PI * 0.5);
            specials.add(special);
            fireCount2 = 0;

            SpecialBullet special2 = new SpecialBullet();
            special2.position.set(-20, Settings.BACKGROUND_HEIGHT);
            special2.velocity.setAngle(-Math.PI * 0.5);
            specials.add(special2);
            fireCount2 = 0;

            SpecialBullet special3 = new SpecialBullet();
            special3.position.set(130, Settings.BACKGROUND_HEIGHT);
            special3.velocity.setAngle(-Math.PI * 0.5);
            specials.add(special3);
            fireCount2 = 0;
        }
    }
    private void changeBulletType() {
        changeBulletCount++;
        if(changeBulletCount > 300){
            Random random = new Random();
            bulletType = 1 + random.nextInt(3);
            changeBulletCount = 0;
        }
    }
    private void playerLimit() {
        if (position.x <= 0) {
            position.x = 0;
        }
        if (position.x >= Settings.BACKGROUND_WIDTH - Settings.PLAYER_WIDTH) {
            position.x = Settings.BACKGROUND_WIDTH - Settings.PLAYER_WIDTH;
        }
        if (position.y <= 0) {
            position.y = 0;
        }
        if (position.y >= Settings.GAME_HEIGHT - Settings.PLAYER_HEIGHT) {
            position.y = Settings.GAME_HEIGHT - Settings.PLAYER_HEIGHT;
        }
    }
}
