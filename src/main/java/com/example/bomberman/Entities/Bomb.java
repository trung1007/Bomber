package com.example.bomberman.Entities;

import com.example.bomberman.GamePanel;
import com.example.bomberman.input.Keyboard;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Bomb {
    public int bombX;
    public int bombY;
    public int intervalToExplored = 20; //  khoang thoi gian bom no
    public int isExploring = 10; // khoang thoi gian ma bom dang no

    int x,y;
    public double lasttime=(System.nanoTime()/1000000000)/1000;

    public boolean explored = true;
    public boolean isExplored = false; // kiem tra xem bom da no hay chua
    public BufferedImage image = null;
    int countExplore = 0;
    BufferedImage center1, center2, center3, left1, left2, left3, right1, right2, right3, up1, up2, up3, down1, down2, down3, ver1, ver2, ver3, hor1, hor2, hor3;

    int countTime = 0;
    BufferedImage bom1, bom2, bom3;
    GamePanel gamePanel;
    Keyboard keyboard;
    public int rec = gamePanel.SCALED_SIZE;

    int sizeBomb = 1;

    public Bomb(GamePanel gamePanel, Keyboard keyboard) {
        this.gamePanel = gamePanel;
        this.keyboard = keyboard;
        getBombImage();
    }

    public Bomb() {

    }

    public void getBombImage() {
        try {
            bom1 = ImageIO.read(getClass().getResourceAsStream("/sprites/bomb.png"));
            bom2 = ImageIO.read(getClass().getResourceAsStream("/sprites/bomb_1.png"));
            bom3 = ImageIO.read(getClass().getResourceAsStream("/sprites/bomb_2.png"));

            center1 = ImageIO.read(getClass().getResourceAsStream("/sprites/bomb_exploded.png"));
            ver1 = ImageIO.read(getClass().getResourceAsStream("/sprites/explosion_vertical.png"));
            hor1 = ImageIO.read(getClass().getResourceAsStream("/sprites/explosion_horizontal.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/sprites/explosion_vertical_top_last.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/sprites/explosion_vertical_down_last.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/sprites/explosion_horizontal_right_last.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/sprites/explosion_horizontal_left_last.png"));

            center2 = ImageIO.read(getClass().getResourceAsStream("/sprites/bomb_exploded1.png"));
            ver2 = ImageIO.read(getClass().getResourceAsStream("/sprites/explosion_vertical1.png"));
            hor2 = ImageIO.read(getClass().getResourceAsStream("/sprites/explosion_horizontal1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/sprites/explosion_vertical_top_last1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/sprites/explosion_vertical_down_last1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/sprites/explosion_horizontal_right_last1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/sprites/explosion_horizontal_left_last1.png"));

            center3 = ImageIO.read(getClass().getResourceAsStream("/sprites/bomb_exploded2.png"));
            ver3 = ImageIO.read(getClass().getResourceAsStream("/sprites/explosion_vertical2.png"));
            hor3 = ImageIO.read(getClass().getResourceAsStream("/sprites/explosion_horizontal2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/sprites/explosion_vertical_top_last2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/sprites/explosion_vertical_down_last2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/sprites/explosion_horizontal_right_last2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/sprites/explosion_horizontal_left_last2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(Bomber bomberman) {
       /* keyboard.update();*/
        if (bomberman.keyboard.space) {
            x = bomberman.bomberX ;
            y = bomberman.bomberY ;
            bombX = x;
            bombY = y;
            explored = false;
        }

    }

    public void render(Graphics2D g2) {

        if (!explored) {
            if(!isExplored){
                if (countTime <= intervalToExplored) {
                    image = bom1;
                } else if (countTime <= intervalToExplored * 2) {
                    image = bom2;
                } else if (countTime <= intervalToExplored * 3) {
                    image = bom3;
                }
                if (countTime == intervalToExplored * 3) {
                    isExplored = true;
                    image = null;
                    countTime = 0;
                }

            }
            countTime++;
            g2.drawImage(image, bombX, bombY, rec, rec, null);

            //kiem tra bom no va load anh bom no
            if (isExplored) {
                if(image==null){
                    if (countTime <= isExploring) {
                        g2.drawImage(center1, bombX, bombY, rec, rec, null);
                        for(int i = 1; i <= sizeBomb; i++) {
                            g2.drawImage(ver1, bombX, bombY + i * rec, rec, rec, null);
                            g2.drawImage(ver1, bombX, bombY - i * rec, rec, rec, null);
                            g2.drawImage(hor1, bombX + i * rec, bombY, rec, rec, null);
                            g2.drawImage(hor1, bombX - i * rec, bombY, rec, rec, null);

                        }
                        g2.drawImage(up1, bombX, bombY - sizeBomb * rec, rec, rec, null);
                        g2.drawImage(down1, bombX, bombY + sizeBomb * rec, rec, rec, null);
                        g2.drawImage(left1, bombX - sizeBomb * rec, bombY, rec, rec, null);
                        g2.drawImage(right1, bombX + sizeBomb * rec, bombY, rec, rec, null);

                    } else if (countTime <= isExploring * 2) {

                        for(int i = 1; i <= sizeBomb; i++) {
                            g2.drawImage(center2,bombX,bombY,rec,rec,null);
                            g2.drawImage(ver2, bombX, bombY + i * rec, rec, rec, null);
                            g2.drawImage(ver2, bombX, bombY - i * rec, rec, rec, null);
                            g2.drawImage(hor2, bombX + i * rec, bombY, rec, rec, null);
                            g2.drawImage(hor2, bombX - i * rec, bombY, rec, rec, null);

                        }
                        g2.drawImage(up2, bombX, bombY - sizeBomb * rec, rec, rec, null);
                        g2.drawImage(down2, bombX, bombY + sizeBomb * rec, rec, rec, null);
                        g2.drawImage(left2, bombX - sizeBomb * rec, bombY, rec, rec, null);
                        g2.drawImage(right2, bombX + sizeBomb * rec, bombY, rec, rec, null);

                    } else if (countTime <= isExploring * 3) {
                        g2.drawImage(center3,bombX,bombY,rec,rec,null);
                        for(int i = 1; i <= sizeBomb; i++) {
                            g2.drawImage(center2,bombX,bombY,rec,rec,null);
                            g2.drawImage(ver3, bombX, bombY + i * rec, rec, rec, null);
                            g2.drawImage(ver3, bombX, bombY - i * rec, rec, rec, null);
                            g2.drawImage(hor3, bombX + i * rec, bombY, rec, rec, null);
                            g2.drawImage(hor3, bombX - i * rec, bombY, rec, rec, null);

                        }
                        g2.drawImage(up3, bombX, bombY - sizeBomb * rec, rec, rec, null);
                        g2.drawImage(down3, bombX, bombY + sizeBomb * rec, rec, rec, null);
                        g2.drawImage(left3, bombX - sizeBomb * rec, bombY, rec, rec, null);
                        g2.drawImage(right3, bombX + sizeBomb * rec, bombY, rec, rec, null);
                    }
                    if (countTime == isExploring * 3) {
                        explored=true;
                        isExplored = false;
                        countTime=0;
                    }
                }
            }
        }
    }
}