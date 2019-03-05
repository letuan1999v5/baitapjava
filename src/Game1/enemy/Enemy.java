package Game1.enemy;

import Game1.GameObject;
import Game1.player.Player;
import Game1.Settings;
import Game1.Vector2D;
import tklibs.SpriteUtils;

public class Enemy extends GameObject {

    int fireCount;
    int bulletType;
    public Enemy()
    {
        fireCount = 0;
        image = SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png");
        position.set(-50,-50);
        velocity.set(2,2);
        velocity.setAngle(Math.PI/18);
        velocity.setLength(Settings.ENEMY_SPEED);
        bulletType = 1;
    }

    @Override
    public void run()
    {
        super.run();
        changeVelocity();
        enemyFire();
    }
    private void changeVelocity() {
        if(position.x > Settings.BACKGROUND_WIDTH-Settings.ENEMY_WIDTH && velocity.x > 0)
        {
            velocity.set(-velocity.x,velocity.y);
        }
        if(position.x < 0 && velocity.x < 0)
        {
            velocity.set(-velocity.x,velocity.y);
        }
        if(position.y> Settings.GAME_HEIGHT - Settings.ENEMY_HEIGHT && velocity.y >0)
        {
            velocity.set(velocity.x,-velocity.y);
        }
        if(position.y < 0 && velocity.y<0)
        {
            velocity.set(velocity.x,-velocity.y);
        }
    }
    private void enemyFire()
    {
        fireCount+=1;
        if(fireCount>20)
        {
            EnemyBullet bullet = new EnemyBullet();
            bullet.velocity.set(0,Settings.ENEMY_BULLET_SPEED);
            bullet.loadImageByType(1);
            bullet.position.set(this.position.x,this.position.y);
            Player player = findPlayer();
            Vector2D enemyToPlayer = player.position.clone();
            enemyToPlayer.minus(this.position.x,this.position.y);
            enemyToPlayer.setLength(4);
            bullet.velocity.set(enemyToPlayer.x,enemyToPlayer.y);
            fireCount = 0;
        }
    }

    private Player findPlayer() {
        Player player = null;
        for(int i = 0; i < GameObject.objects.size();i++){
            GameObject object = GameObject.objects.get(i);
            if(object.active&&object instanceof Player){
                player = (Player) object;
            }
        }
        return player;
    }


}