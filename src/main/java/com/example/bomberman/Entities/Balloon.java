package com.example.bomberman.Entities;

import com.example.bomberman.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Balloon {
    GamePanel gamePanel;
    BufferedImage right1, right2, right3, left1, left2, left3;
    public Balloon(GamePanel gamePanel){
        this.gamePanel = gamePanel;
//        direction = "RIGHT";
    }
    public void setBalloonImage(){
        try{
            right1 = ImageIO.read(getClass().getResourceAsStream("/sprites/balloom_right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/sprites/balloom_right2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/sprites/balloom_right3.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/sprites/balloom_left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/sprites/balloom_left2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/sprites/balloom_left3.png"));
        } catch (IOException e){
            e.printStackTrace();
        }

    }
    public void update(){

    }
    public void render(Graphics2D g2){
//        BufferedImage image = null;
//        switch (direction){
//            case "RIGHT":{
//                image = right1;
//                break;
//            }
//            case "LEFT":{
//                image = left1;
//                break;
//            }
//        }
//        g2.drawImage(image, 100, 100,gamePanel.SCALED_SIZE, gamePanel.SCALED_SIZE, null);
    }
}
