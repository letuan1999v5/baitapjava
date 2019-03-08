package game.Enemy;

import game.GameObject;
import game.physics.BoxCollider;
import game.player.Player;
import game.Settings;
import game.Vector2D;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;
import java.awt.*;

public class Enemy extends GameObject {

    int fireCount;
    int hp;

    public Enemy(){
        this.renderer = new SingleImageRenderer(SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png"));
        position.set(-50,-50);
        velocity.set(2,2);
        velocity.setAngle(Math.PI/18);
        velocity.setLength(Settings.ENEMY_SPEED);
        fireCount = 0;
        collider = new BoxCollider(this,28,28);
        hp = 3;
    }

    @Override
    public void run()
    {
        super.run();
        changeVelocity();
        fire();
    }

    private void changeVelocity() {
        double offsetWidth = anchor.x*Settings.ENEMY_WIDTH;
        double offsetHeight = anchor.y*Settings.ENEMY_HEIGHT;
        if(position.x > Settings.BACKGROUND_WIDTH-offsetWidth && velocity.x > 0)
        {
            velocity.set(-velocity.x,velocity.y);
        }
        if(position.x < offsetWidth && velocity.x < 0)
        {
            velocity.set(-velocity.x,velocity.y);
        }
        if(position.y> Settings.GAME_HEIGHT - offsetHeight && velocity.y >0)
        {
            velocity.set(velocity.x,-velocity.y);
        }
        if(position.y < offsetHeight && velocity.y<0)
        {
            velocity.set(velocity.x,-velocity.y);
        }
    }
    private void fire()
    {
        fireCount+=1;
        if(fireCount>20)
        {
            EnemyBullet bullet = GameObject.recycle(EnemyBullet.class);
            bullet.position.set(this.position);

//            EnemyBullet bullet = new EnemyBullet();
//            bullet.velocity.set(0,Settings.ENEMY_BULLET_SPEED);
//            bullet.loadImageByType(1);
            Player player = findPlayer();
            Vector2D enemyToPlayer = player.position.clone();
            enemyToPlayer.minus(this.position);
            enemyToPlayer.setLength(4);

            bullet.velocity.set(enemyToPlayer);
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

    public void takeDamage(int damage){
        hp -= damage;
        if(hp <= 0){
            this.deactive();
            hp = 0;
        }
    }
    static Font font = new Font("Verdana", Font.ITALIC, 40);
    @Override
    public void render(Graphics g){
        super.render(g);
        g.setColor(Color.GREEN);
        g.drawRect((int) collider.left(), (int) collider.top(),
                (int) collider.width, (int) collider.height);
        g.setFont(font);
        g.drawString(hp +"",
                (int) collider.left(),
                (int) collider.top());
    }
}