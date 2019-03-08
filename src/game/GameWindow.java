package game;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame {
    public static boolean isUpPress;
    public static boolean isDownPress;
    public static boolean isLeftPress;
    public static boolean isRightPress;
    public static boolean isFirePress;
    public static boolean isRocketPress;
    public static boolean isSpecialPress;

    public GameWindow(){
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //su kien giu phim
                if ( e.getKeyCode() == KeyEvent.VK_A){
                    isLeftPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    isUpPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    isDownPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    isRightPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    isFirePress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_R){
                    isRocketPress = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_E){
                    isSpecialPress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //su kien nha phim
                if(e.getKeyCode()==KeyEvent.VK_A){
                    isLeftPress=false;
                }
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    isUpPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    isDownPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    isRightPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    isFirePress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_R){
                    isRocketPress = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_E){
                    isSpecialPress = false;
                }
            }
        });

    }
}
