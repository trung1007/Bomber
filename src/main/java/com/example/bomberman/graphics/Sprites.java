package com.example.bomberman.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Sprites {
    /**
     * Load animation Bomber
     */
    public BufferedImage up1, up2, up3, down1, down2, down3, left1, left2, left3, right1, right2, right3;
    public void getBomberImage(){
        try {
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/player_up.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/player_up_1.png")));
            up3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/player_up_2.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/player_down.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/player_down_1.png")));
            down3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/player_down_2.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/player_left.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/player_left_1.png")));
            left3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/player_left_2.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/player_right.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/player_right_1.png")));
            right3 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/player_right_2.png")));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
