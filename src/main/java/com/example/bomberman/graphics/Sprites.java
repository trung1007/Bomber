package com.example.bomberman.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Sprites {
    /**
     * Load animation Bomber
     */
    public   BufferedImage Bomb1, Bomb2, Bomb3, BombCenter1, BombCenter2, BombCenter3, BombUp1,
            BombUp2, BombUp3, BombDown1, BombDown2, BombDown3, BombLeft1, BombLeft2, BombLeft3,
            BombRight1, BombRight2, BombRight3, BombVer1, BombVer2, BombVer3, BombHor1, BombHor2, BombHor3;
    public BufferedImage PlayerUp1, PlayerUp2, PlayerUp3, PlayerDown1, PlayerDown2, PlayerDown3,
            PlayerLeft1, PlayerLeft2, PlayerLeft3, PlayerRight1, PlayerRight2, PlayerRight3;



    public void getBombImage(){
        try {
            Bomb1 = ImageIO.read(getClass().getResourceAsStream("/sprites/bomb-1.png"));
            Bomb2 = ImageIO.read(getClass().getResourceAsStream("/sprites/bomb-2.png"));
            Bomb3 = ImageIO.read(getClass().getResourceAsStream("/sprites/bomb-3.png"));

            BombCenter1 = ImageIO.read(getClass().getResourceAsStream("/sprites/center-1.png"));
            BombVer1 = ImageIO.read(getClass().getResourceAsStream("/sprites/vertical-1.png"));
            BombHor1 = ImageIO.read(getClass().getResourceAsStream("/sprites/horizontal-1.png"));
            BombUp1 = ImageIO.read(getClass().getResourceAsStream("/sprites/up-last-1.png"));

            BombDown1 = ImageIO.read(getClass().getResourceAsStream("/sprites/down-last-1.png"));
            BombRight1 = ImageIO.read(getClass().getResourceAsStream("/sprites/right-last-1.png"));
            BombLeft1 = ImageIO.read(getClass().getResourceAsStream("/sprites/left-last-1.png"));

            BombCenter2 = ImageIO.read(getClass().getResourceAsStream("/sprites/center-2.png"));
            BombVer2 = ImageIO.read(getClass().getResourceAsStream("/sprites/vertical-2.png"));
            BombHor2 = ImageIO.read(getClass().getResourceAsStream("/sprites/horizontal-2.png"));
            BombUp2 = ImageIO.read(getClass().getResourceAsStream("/sprites/up-last-2.png"));
            BombDown2 = ImageIO.read(getClass().getResourceAsStream("/sprites/down-last-2.png"));
            BombRight2 = ImageIO.read(getClass().getResourceAsStream("/sprites/right-last-2.png"));
            BombLeft2 = ImageIO.read(getClass().getResourceAsStream("/sprites/left-last-2.png"));

            BombCenter3 = ImageIO.read(getClass().getResourceAsStream("/sprites/center-3.png"));
            BombVer3 = ImageIO.read(getClass().getResourceAsStream("/sprites/vertical-3.png"));
            BombHor3 = ImageIO.read(getClass().getResourceAsStream("/sprites/horizontal-3.png"));
            BombUp3 = ImageIO.read(getClass().getResourceAsStream("/sprites/up-last-3.png"));
            BombDown3 = ImageIO.read(getClass().getResourceAsStream("/sprites/down-last-3.png"));
            BombRight3 = ImageIO.read(getClass().getResourceAsStream("/sprites/right-last-3.png"));
            BombLeft3 = ImageIO.read(getClass().getResourceAsStream("/sprites/left-last-3.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void getPlayerImage(){
        try {
            PlayerUp1 = ImageIO.read(getClass().getResourceAsStream("/sprites/up-1.png"));
            PlayerUp2 = ImageIO.read(getClass().getResourceAsStream("/sprites/up-2.png"));
            PlayerUp3 = ImageIO.read(getClass().getResourceAsStream("/sprites/up-3.png"));
            PlayerDown1 = ImageIO.read(getClass().getResourceAsStream("/sprites/down-1.png"));
            PlayerDown2 = ImageIO.read(getClass().getResourceAsStream("/sprites/down-2.png"));
            PlayerDown3 = ImageIO.read(getClass().getResourceAsStream("/sprites/down-3.png"));
            PlayerLeft1 = ImageIO.read(getClass().getResourceAsStream("/sprites/left-1.png"));
            PlayerLeft2 = ImageIO.read(getClass().getResourceAsStream("/sprites/left-2.png"));
            PlayerLeft3 = ImageIO.read(getClass().getResourceAsStream("/sprites/left-3.png"));
            PlayerRight1 = ImageIO.read(getClass().getResourceAsStream("/sprites/right-1.png"));
            PlayerRight2 = ImageIO.read(getClass().getResourceAsStream("/sprites/right-2.png"));
            PlayerRight3 = ImageIO.read(getClass().getResourceAsStream("/sprites/right-3.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
