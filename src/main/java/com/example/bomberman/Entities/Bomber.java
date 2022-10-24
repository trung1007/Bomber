package com.example.bomberman.Entities;

import com.example.bomberman.GamePanel;
import com.example.bomberman.input.Keyboard;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Bomber extends Entity{
    GamePanel gamePanel;
    Keyboard keyboard;
    public BufferedImage up1, up2, up3, down1, down2, down3, left1, left2, left3, right1, right2, right3;
    int spriteCounter = 0;
    int spriteNum = 1;
    public boolean CheckDie=false;

    public Bomber(GamePanel gamePanel, Keyboard keyboard) {
        this.gamePanel = gamePanel;
        this.keyboard = keyboard;
        setDefaultValues();
        sprites.getPlayerImage();
        direction = "DOWN";
        solidArea = new Rectangle();
        solidArea.x = 10;
        solidArea.y = 10;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 20;
        solidArea.height = 28;

    }

    public void setDefaultValues(){
        x = 48;
        y = 48;
        speed = 8;
    }



    public void update(Object object, Boom boom){
        keyboard.update();
        if(CheckDie){
            x=48;
            y=48;
            CheckDie=false;
        }
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
            collisionOn = false;
            gamePanel.checkCollision.checkTile(this);
            if(collisionOn == false) {
                switch (direction){
                    case "UP": {
                        y -= speed;
                        if(object.mapObjectNum[(y)/ GamePanel.SCALED_SIZE][(x + GamePanel.SCALED_SIZE /2)/ GamePanel.SCALED_SIZE] == 5){
                            object.mapObjectNum[(y)/gamePanel.SCALED_SIZE][(x + gamePanel.SCALED_SIZE/2)/gamePanel.SCALED_SIZE] = 0;

                            boom.sizeBomb++;
                        }
                        if(object.mapObjectNum[y /gamePanel.SCALED_SIZE][(x + gamePanel.SCALED_SIZE /2)/gamePanel.SCALED_SIZE] == 6){
                            object.mapObjectNum[y /gamePanel.SCALED_SIZE][(x + gamePanel.SCALED_SIZE /2)/gamePanel.SCALED_SIZE] = 0;
                            //boom.NumOfBomb++;
//                            NumOfBoom++;
                            //boom.NumOfBoom++;
                            gamePanel.AddBoom();

                        }
                        if(object.mapObjectNum[y /gamePanel.SCALED_SIZE][(x + gamePanel.SCALED_SIZE /2)/gamePanel.SCALED_SIZE] == 7){
                            object.mapObjectNum[y /gamePanel.SCALED_SIZE][(x + gamePanel.SCALED_SIZE /2)/gamePanel.SCALED_SIZE] = 0;
                            speed += 2;
                        }
                        break;
                    }
                    case "DOWN": {
                        y += speed;
                        if(object.mapObjectNum[(y + gamePanel.SCALED_SIZE)/gamePanel.SCALED_SIZE][(x + gamePanel.SCALED_SIZE/2 )/gamePanel.SCALED_SIZE] == 5){
                            object.mapObjectNum[(y + gamePanel.SCALED_SIZE)/gamePanel.SCALED_SIZE][(x + gamePanel.SCALED_SIZE/2 )/gamePanel.SCALED_SIZE] = 0;

                            boom.sizeBomb++;
                        }
                        if(object.mapObjectNum[(y + gamePanel.SCALED_SIZE)/gamePanel.SCALED_SIZE][(x + gamePanel.SCALED_SIZE /2)/gamePanel.SCALED_SIZE] == 6){
                            object.mapObjectNum[(y + gamePanel.SCALED_SIZE)/gamePanel.SCALED_SIZE][(x + gamePanel.SCALED_SIZE /2)/gamePanel.SCALED_SIZE] = 0;
//                            boom.NumOfBomb++;
//                            NumOfBoom++;
                            //boom.NumOfBoom++;
                            gamePanel.AddBoom();
                        }
                        if(object.mapObjectNum[(y + gamePanel.SCALED_SIZE)/gamePanel.SCALED_SIZE][(x + gamePanel.SCALED_SIZE /2)/gamePanel.SCALED_SIZE] == 7){
                            object.mapObjectNum[(y + gamePanel.SCALED_SIZE)/gamePanel.SCALED_SIZE][(x + gamePanel.SCALED_SIZE /2)/gamePanel.SCALED_SIZE] = 0;
                            speed += 2;
                        }
                        break;
                    }
                    case "LEFT": {
                        x -= speed;
                        if(object.mapObjectNum[(y + gamePanel.SCALED_SIZE/2)/gamePanel.SCALED_SIZE][(x)/gamePanel.SCALED_SIZE] == 5){
                            object.mapObjectNum[(y + gamePanel.SCALED_SIZE/2)/gamePanel.SCALED_SIZE][(x)/gamePanel.SCALED_SIZE] = 0;

                            boom.sizeBomb++;

                        }
                        if(object.mapObjectNum[(y + gamePanel.SCALED_SIZE/2)/gamePanel.SCALED_SIZE][(x)/gamePanel.SCALED_SIZE]== 6){
                            object.mapObjectNum[(y + gamePanel.SCALED_SIZE/2)/gamePanel.SCALED_SIZE][(x)/gamePanel.SCALED_SIZE] = 0;
//                            boom.NumOfBomb++;
//                            NumOfBoom++;
                            //boom.NumOfBoom++;
                            gamePanel.AddBoom();
                        }
                        if(object.mapObjectNum[(y + gamePanel.SCALED_SIZE/2)/gamePanel.SCALED_SIZE][(x)/gamePanel.SCALED_SIZE] == 7){
                            object.mapObjectNum[(y + gamePanel.SCALED_SIZE/2)/gamePanel.SCALED_SIZE][(x)/gamePanel.SCALED_SIZE] = 0;
                            speed += 2;;
                        }
                        break;
                    }
                    case "RIGHT": {
                        x += speed;
                        if(object.mapObjectNum[(y + gamePanel.SCALED_SIZE/2)/gamePanel.SCALED_SIZE][(x + gamePanel.SCALED_SIZE)/gamePanel.SCALED_SIZE] == 5){
                            object.mapObjectNum[(y + gamePanel.SCALED_SIZE/2)/gamePanel.SCALED_SIZE][(x + gamePanel.SCALED_SIZE)/gamePanel.SCALED_SIZE] = 0;
                            boom.sizeBomb++;
                        }
                        if(object.mapObjectNum[(y + gamePanel.SCALED_SIZE/2)/gamePanel.SCALED_SIZE][(x + gamePanel.SCALED_SIZE)/gamePanel.SCALED_SIZE]== 6){
                            object.mapObjectNum[(y + gamePanel.SCALED_SIZE/2)/gamePanel.SCALED_SIZE][(x + gamePanel.SCALED_SIZE)/gamePanel.SCALED_SIZE] = 0;
//                            boom.NumOfBomb++;
//                            NumOfBoom++;
                            //boom.NumOfBoom++;
                            gamePanel.AddBoom();

                        }
                        if(object.mapObjectNum[(y + gamePanel.SCALED_SIZE/2)/gamePanel.SCALED_SIZE][(x + gamePanel.SCALED_SIZE)/gamePanel.SCALED_SIZE] == 7){
                            object.mapObjectNum[(y + gamePanel.SCALED_SIZE/2)/gamePanel.SCALED_SIZE][(x + gamePanel.SCALED_SIZE)/gamePanel.SCALED_SIZE] = 0;
                            speed += 2;
                        }
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
                    image = sprites.PlayerUp1;
                }
                if (spriteNum == 2) {
                    image = sprites.PlayerUp2;
                }
                if (spriteNum == 3) {
                    image = sprites.PlayerUp3;
                }
                break;
            }
            case "DOWN" -> {
                if (spriteNum == 1) {
                    image = sprites.PlayerDown1;
                }
                if (spriteNum == 2) {
                    image = sprites.PlayerDown2;
                }
                if (spriteNum == 3) {
                    image = sprites.PlayerDown3;
                }
                break;
            }
            case "LEFT" -> {
                if (spriteNum == 1) {
                    image =sprites.PlayerLeft1 ;
                }
                if (spriteNum == 2) {
                    image =sprites.PlayerLeft2 ;
                }
                if (spriteNum == 3) {
                    image = sprites.PlayerLeft3;
                }
                break;
            }
            case "RIGHT" -> {
                if (spriteNum == 1) {
                    image =sprites.PlayerRight1 ;
                }
                if (spriteNum == 2) {
                    image =sprites.PlayerRight2  ;
                }
                if (spriteNum == 3) {
                    image = sprites.PlayerRight3 ;

                }
                break;
            }
        }
        g2.drawImage(image, x, y, GamePanel.SCALED_SIZE, GamePanel.SCALED_SIZE, null);
    }

}
