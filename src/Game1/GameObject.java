package Game1;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    //static: quản lý đối tượng
    public static ArrayList<GameObject> objects = new ArrayList<>();
    public static void addGameObject(GameObject object) {
        objects.add(object);
    }
    //Nhiệm vụ: Trả ra 1 gameObject
    //1. Tìm trong objects, nếu có phần tử thỏa mãn thì reset phần tử đó rồi trả ra
    //2. Nếu không tìm thấy phần tử thỏa mãn thì tạo mới rồi trả ra
    public <E extends GameObject> E findInactive(Class<E> cls){
        for (int i = 0; i < objects.size() ; i++) {
            GameObject object = objects.get(i);
            if(!object.active
            && cls.isAssignableFrom(object.getClass())){
                return (E) object;
            }
        }
        return null;
    }


    public <E extends GameObject >E recycle(Class<E> cls){
        E find = findInactive(cls);
        if (find!=null){
            find.reset();
        }
        try{
            E newInstance = cls.newInstance();
            addGameObject(newInstance);
            return newInstance;
        }catch (Exception ex){
            return null;
        }
    }
    //non-static: định nghĩa đối tượng
    public BufferedImage image;
    public ArrayList<BufferedImage> images;
    public int currentImageIndex;
    public int changeImageCount;
    public Vector2D position;
    public Vector2D velocity;
    public boolean active;
    public GameObject(){
        this.currentImageIndex = 0;
        this.changeImageCount = 0;
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.active = true;
        objects.add(this);
    }
    public void render(Graphics g){
        if(this.image != null) {
            this.renderSingleImage(g);
        }
        else if (this.images != null){
            this.renderAnimation(g);
        }
    }

    private void renderAnimation(Graphics g) {
        BufferedImage currentImage = images.get(currentImageIndex);
        g.drawImage(
                currentImage,
                (int) position.x,
                (int) position.y,
                null
        );
        changeImageCount++;
        if(changeImageCount > 10){
            currentImageIndex++;
            if(currentImageIndex >= images.size()){
                currentImageIndex = 0;
            }
            changeImageCount = 0;
        }
    }

    private void renderSingleImage(Graphics g) {
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

    public void destroy(){
        this.active = false;
    }
    public void reset(){
        this.active = true;
    }
}

