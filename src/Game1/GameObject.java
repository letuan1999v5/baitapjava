package Game1;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    //static: quản lý đối tượng
    public static ArrayList<GameObject> objects = new ArrayList<>();
    //Nhiệm vụ: Trả ra 1 gameObject
    //1. Tìm trong objects, nếu có phần tử thỏa mãn thì reset phần tử đó rồi trả ra
    //2. Nếu không tìm thấy phần tử thỏa mãn thì tạo mới rồi trả ra
    public <E extends GameObject >E recycle(Class<E> cls){
        return null;
    }
    //non-static: định nghĩa đối tượng
    public BufferedImage image;
    public Vector2D position;
    public Vector2D velocity;
    public boolean active;
    public GameObject(){
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.active = true;
        objects.add(this);
    }
    public void render(Graphics g){
        g.drawImage(
                this.image,
                (int) this.position.x,
                (int) this.position.y,
                null
        );
    }
    public void run(){
        this.position.add(this.velocity.x,this.velocity.y);
    }

    public void deactive(){
        this.active = false;
    }
    public void reset(){
        this.active = true;
    }
}

