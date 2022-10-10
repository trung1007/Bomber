package com.example.bomberman.Entities;

import com.example.bomberman.GamePanel;
import com.example.bomberman.input.Keyboard;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Bomberman extends Entity{
    GamePanel gamePanel;
    Keyboard keyboard;
    public BufferedImage up1, up2, up3, down1, down2, down3, left1, left2, left3, right1, right2, right3;
    int spriteCounter = 0;
    int spriteNum = 1;

    public Bomberman(GamePanel gamePanel, Keyboard keyboard) {
        this.gamePanel = gamePanel;
        this.keyboard = keyboard;
        setDefaultValues();
        getBomberImage();
        direction = "DOWN";

        solidArea = new Rectangle();
        solidArea.x = 10;
        solidArea.y = 10;
        solidArea.width = 20;
        solidArea.height = 28;

    }

    public void setDefaultValues(){
        bomberX = 100;
        bomberY = 100;
        speed = 2;
    }

    public void getBomberImage(){
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player_up-1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player_up-2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/sprites/player_up-3.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player_down-1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player_down-2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/sprites/player_down-3.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player_left-1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player_left-2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/sprites/player_left-3.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player_right-1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player_right-2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/sprites/player_right-3.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        keyboard.update();
        if(keyboard.right || keyboard.up ||
                keyboard.down || keyboard.left) {
            if(keyboard.up){
                direction = "UP";

            }
            else if(keyboard.down){
                direction = "DOWN"; 

            }
            else if(keyboard.left){
                direction = "LEFT";

            }
            else if(keyboard.right){
                direction = "RIGHT";

            }

            //check tile collision
            collisionOn = false;
            gamePanel.checkCollision.checkTile(this);

            if(collisionOn == false) {
                switch (direction){
                    case "UP": {
                        bomberY -= speed;
                        break;
                    }
                    case "DOWN": {
                        bomberY += speed;
                        break;
                    }
                    case "LEFT": {
                        bomberX -= speed;
                        break;
                    }
                    case "RIGHT": {
                        bomberX += speed;
                        break;
                    }
                }
            }
            spriteCounter++;
            if(spriteCounter >= 6){
                if(spriteNum == 1){
                    spriteNum = 2;
                } else if(spriteNum == 2){
                    spriteNum = 3;
                } else if(spriteNum == 3){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }

    }

    public void render (Graphics2D g2){
        BufferedImage image = null;
        switch (direction) {
            case "UP" -> {
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                if (spriteNum == 3) {
                    image = up3;
                }
                break;
            }
            case "DOWN" -> {
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                if (spriteNum == 3) {
                    image = down3;
                }
                break;
            }
            case "LEFT" -> {
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                if (spriteNum == 3) {
                    image = left3;
                }
                break;
            }
            case "RIGHT" -> {
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                if (spriteNum == 3) {
                    image = right3;

                }
                break;
            }
        }
        g2.drawImage(image, bomberX, bomberY, GamePanel.SCALED_SIZE, GamePanel.SCALED_SIZE, null);
    }

}
