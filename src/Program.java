import Game1.GamePanel;
import Game1.GameWindow;
import Game1.Settings;

import javax.swing.*;
import java.awt.*;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {
    public static void main(String[] args) {
        GameWindow window = new GameWindow();
        //window.setSize(400, Settings.GAME_HEIGHT);
        window.setResizable(false);
        window.setTitle("TouHou");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GamePanel panel = new GamePanel();
        panel.setPreferredSize(new Dimension(Settings.GAME_WIDTH,Settings.GAME_HEIGHT));
        window.add(panel);
        window.pack();
        panel.setBackground(Color.CYAN);
        window.setVisible(true);
        panel.gameLoop();
//        ArrayList<Vector2D> vectors = new ArrayList<>();
//        Vector2D v1 = new Vector2D(1,1);
//        Vector2D v2 = new Vector2D(2,2);
//        Vector2D v3 = new Vector2D(4,1);
//        vectors.add(v1);
//        vectors.add(v2);
//        vectors.add(v3);
//        int Max = 0;
//        int count=0;
//        for(int i = 0;i<vectors.size();i++){
//            Vector2D vector = vectors.get(i);
//            if(vector.x+vector.y>Max){
//                count = i;
//            }
//        }
//        Vector2D vectorMax = vectors.get(count);
//        System.out.println("Vector co tong x+y lon nhat la "+(int)vectorMax.x + " " + (int)vectorMax.y);
    }
}
