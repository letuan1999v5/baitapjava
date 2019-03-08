package game;

import game.physics.BoxCollider;

import javax.swing.*;
import java.awt.*;
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

    public static <E extends GameObject> E find(Class<E> cls){
        E result = null;
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if(object.active
            && object.getClass().isAssignableFrom(cls)){
                result = (E) object;
            }
        }
        return result;
    }

    public static <E extends GameObject> E recycle(Class<E> cls) {
        E result = findInactive(cls);
        if (result != null) {
            result.reset();
            return result;
        }
        try {
           return cls.getConstructor().newInstance();
        } catch (Exception ex) {
            return null;
        }
    }

    public static <E extends GameObject> E findInactive(Class<E> cls) {
        E result = null;
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if (!object.active
                    && object.getClass().isAssignableFrom(cls)) {
                result = (E) object;
                break;
            }
        }
        return null;
    }

    public static <E extends GameObject> E FindIntersects(Class<E> cls,
                                                          BoxCollider collider) {
        E result = null;
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            if (object.active
                    && object.getClass().isAssignableFrom(cls)
                    && object.collider != null
                    && object.collider.intersects(collider)) {
                result = (E) object;
                break;
            }
        }
    }




    //non-static: định nghĩa đối tượng
    public Renderer renderer;
    public Vector2D position;
    public Vector2D velocity;
    public Vector2D anchor;
    public boolean active;
    public BoxCollider collider;

    public GameObject() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.anchor = new Vector2D(0.5,0.5);
        this.active = true;
        objects.add(this);
    }

    public void render(Graphics g) {
        if(renderer != null){
            renderer.render(g, this);
        }
    }

    public void run() {
        this.position.add(this.velocity.x, this.velocity.y);
    }

    public void deactive() {
        this.active = false;
    }

    public void reset() {
        this.active = true;
    }
}

