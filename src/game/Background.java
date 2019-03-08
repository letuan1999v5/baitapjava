package game;

import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

public class Background extends GameObject {
    public Background() {
        this.renderer = new SingleImageRenderer(
                SpriteUtils.loadImage("assets/images/background/0.png")
        );
        this.position.set(0,Settings.GAME_HEIGHT - Settings.BACKGROUND_HEIGHT);
        this.velocity.set(0,Settings.BACKGROUND_SPEED);
        this.anchor.set(0,0);
    }

    @Override
    public void run() {
        super.run();
        if(position.y>0){
            position.y = 0;
        }
    }
}
