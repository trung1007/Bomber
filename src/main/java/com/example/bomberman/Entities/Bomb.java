package com.example.bomberman.Entities;

import com.example.bomberman.GamePanel;
import com.example.bomberman.input.Keyboard;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bomb {
    GamePanel gamePanel;
    Keyboard keyboard;
    public int bombX;
    public int bombY;
    public int intervalToExplored = 20; //  khoang thoi gian bom no
    public int timeExploring = 10; // khoang thoi gian ma bom dang no

    public boolean explored = true; // kiem tra xem bom da no hay chua
    public boolean isEXploring = false; // kiem tra xem cos dang trong tinh trang no hay khong
    public BufferedImage image = null;
    public int rect = gamePanel.SCALED_SIZE;
    int bombCount = 0;
    int NumOfBomb = 2;
    int sizeBomb = 1;

    int countTime = 0;
    BufferedImage center1, center2, center3, left1, left2, left3, right1, right2, right3, up1, up2, up3, down1, down2, down3, ver1, ver2, ver3, hor1, hor2, hor3;

    BufferedImage bom1, bom2, bom3;


    public Bomb(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
//        this.keyboard = keyboard;
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
        if (bomberman.keyboard.space && bombCount == 0) {
            gamePanel.playSE(1);
            int row = (bomberman.bomberY + rect / 2) / rect * rect;
                int col = (bomberman.bomberX + rect / 2) / rect * rect;
                bombX = col;
                bombY = row;
                explored = false;
                NumOfBomb--;
                bombCount++;

            }
        /*if(NumOfBomb==1){
            if (bomberman.keyboard.space&&bombCount==0 ) {
                int row = (bomberman.bomberY + rect / 2) / rect * rect;
                int col = (bomberman.bomberX + rect / 2) / rect * rect;
                bombX = col;
                bombY = row;
                explored = false;
                bombCount++;
            }
        }*/
    }

    public void render(Graphics2D g2, Object object) {
        // load anh bomb truoc khi no
        if (!explored) {
            if (!isEXploring) {
                if (countTime <= intervalToExplored) {
                    image = bom1;
                } else if (countTime <= intervalToExplored * 2) {
                    image = bom2;
                } else if (countTime <= intervalToExplored * 3) {
                    image = bom3;
                }
                if (countTime == intervalToExplored * 3) {
                    isEXploring = true;
                    image = null;
                    countTime = 0;
                }

            }
            countTime++;
            g2.drawImage(image, bombX, bombY, rect, rect, null);

            //kiem tra bom no va load anh bom no
            if (isEXploring) {
                gamePanel.playSE(2);
                int size_Up = GamePanel.SCALED_SIZE;
                int size_Down = GamePanel.SCALED_SIZE;
                int size_Right = GamePanel.SCALED_SIZE;
                int size_Left = GamePanel.SCALED_SIZE;
                if (countTime <= timeExploring) {
                    g2.drawImage(center1, bombX, bombY, rect, rect, null);
                  /*  System.out.println("bomX : " + bombX);
                    System.out.println("bomY : " + bombY);*/
                    for (int i = 1; i <= sizeBomb; i++) {

                        int row_bomb_up = (bombY - i * rect)/rect;
                        int row_bomb_down = (bombY + i * rect) / rect;
                        int col_bomb_right = (bombX + i * rect) / rect;
                        int col_bomb_left = (bombX - i * rect) / rect;
                        if(row_bomb_up < 0){
                            row_bomb_up = 0;
                        }
                        if(row_bomb_down >= GamePanel.MAX_SCREEN_ROW){
                            row_bomb_down = GamePanel.MAX_SCREEN_ROW -1;
                        }
                        if(col_bomb_right >= GamePanel.MAX_SCREEN_COL){
                            col_bomb_right = GamePanel.MAX_SCREEN_COL-1;
                        }
                        if(col_bomb_left < 0){
                            col_bomb_left = 0;
                        }

                        //check no tren
                        if (object.mapObjectNum[row_bomb_up][bombX / rect] == 1) {
                            size_Up = 0;
                        }
                        //check no duoi
                        if (object.mapObjectNum[row_bomb_down][bombX / rect] == 1) {
                            size_Down = 0;
                        }
                        //check no phai
                        if (object.mapObjectNum[(bombY) / rect][col_bomb_right] == 1) {
                            size_Right = 0;
                        }
                        // check no trai
                        if (object.mapObjectNum[(bombY) / rect][col_bomb_left] == 1) {
                            size_Left = 0;
                        }
                        g2.drawImage(ver1, bombX, bombY + i * rect, size_Down, size_Down, null);
                        g2.drawImage(ver1, bombX, bombY - i * rect, size_Up, size_Up, null);
                        g2.drawImage(hor1, bombX + i * rect, bombY, size_Right, size_Right, null);
                        g2.drawImage(hor1, bombX - i * rect, bombY, size_Left, size_Left, null);

                    }
                    g2.drawImage(up1, bombX, bombY - sizeBomb * rect, size_Up, size_Up, null);
                    g2.drawImage(down1, bombX, bombY + sizeBomb * rect, size_Down, size_Down, null);
                    g2.drawImage(left1, bombX - sizeBomb * rect, bombY, size_Left, size_Left, null);
                    g2.drawImage(right1, bombX + sizeBomb * rect, bombY, size_Right, size_Right, null);

                } else if (countTime <= timeExploring * 2) {
                    g2.drawImage(center2, bombX, bombY, rect, rect, null);
                    for (int i = 1; i <= sizeBomb; i++) {

                        int row_bomb_up = (bombY - i * rect)/rect;
                        int row_bomb_down = (bombY + i * rect) / rect;
                        int col_bomb_right = (bombX + i * rect) / rect;
                        int col_bomb_left = (bombX - i * rect) / rect;
                        if(row_bomb_up < 0){
                            row_bomb_up = 0;
                        }
                        if(row_bomb_down >= GamePanel.MAX_SCREEN_ROW){
                            row_bomb_down = GamePanel.MAX_SCREEN_ROW -1;
                        }
                        if(col_bomb_right >= GamePanel.MAX_SCREEN_COL){
                            col_bomb_right = GamePanel.MAX_SCREEN_COL-1;
                        }
                        if(col_bomb_left < 0){
                            col_bomb_left = 0;
                        }

                        //check no tren
                        if (object.mapObjectNum[row_bomb_up][bombX / rect] == 1) {
                            size_Up = 0;
                        }
                        //check no duoi
                        if (object.mapObjectNum[row_bomb_down][bombX / rect] == 1) {
                            size_Down = 0;
                        }
                        //check no phai
                        if (object.mapObjectNum[(bombY) / rect][col_bomb_right] == 1) {
                            size_Right = 0;
                        }
                        // check no trai
                        if (object.mapObjectNum[(bombY) / rect][col_bomb_left] == 1) {
                            size_Left = 0;
                        }
                        g2.drawImage(ver2, bombX, bombY + i * rect, size_Down, size_Down, null);
                        g2.drawImage(ver2, bombX, bombY - i * rect, size_Up, size_Up, null);
                        g2.drawImage(hor2, bombX + i * rect, bombY, size_Right, size_Right, null);
                        g2.drawImage(hor2, bombX - i * rect, bombY, size_Left, size_Left, null);

                    }
                    g2.drawImage(up2, bombX, bombY - sizeBomb * rect, size_Up, size_Up, null);
                    g2.drawImage(down2, bombX, bombY + sizeBomb * rect, size_Down, size_Down, null);
                    g2.drawImage(left2, bombX - sizeBomb * rect, bombY, size_Left, size_Left, null);
                    g2.drawImage(right2, bombX + sizeBomb * rect, bombY, size_Right, size_Right, null);

                } else if (countTime <= timeExploring * 3) {
                    g2.drawImage(center3, bombX, bombY, rect, rect, null);
                    for (int i = 1; i <= sizeBomb; i++) {

                        int row_bomb_up = (bombY - i * rect)/rect;
                        int row_bomb_down = (bombY + i * rect) / rect;
                        int col_bomb_right = (bombX + i * rect) / rect;
                        int col_bomb_left = (bombX - i * rect) / rect;
                        if(row_bomb_up < 0){
                            row_bomb_up = 0;
                        }
                        if(row_bomb_down >= GamePanel.MAX_SCREEN_ROW){
                            row_bomb_down = GamePanel.MAX_SCREEN_ROW -1;
                        }
                        if(col_bomb_right >= GamePanel.MAX_SCREEN_COL){
                            col_bomb_right = GamePanel.MAX_SCREEN_COL-1;
                        }
                        if(col_bomb_left < 0){
                            col_bomb_left = 0;
                        }

                        //check no tren
                        if (object.mapObjectNum[row_bomb_up][bombX / rect] == 1) {
                            size_Up = 0;
                        }
                        //check no duoi
                        if (object.mapObjectNum[row_bomb_down][bombX / rect] == 1) {
                            size_Down = 0;
                        }
                        //check no phai
                        if (object.mapObjectNum[(bombY) / rect][col_bomb_right] == 1) {
                            size_Right = 0;
                        }
                        // check no trai
                        if (object.mapObjectNum[(bombY) / rect][col_bomb_left] == 1) {
                            size_Left = 0;
                        }
                        g2.drawImage(ver3, bombX, bombY + i * rect, size_Down, size_Down, null);
                        g2.drawImage(ver3, bombX, bombY - i * rect, size_Up, size_Up, null);
                        g2.drawImage(hor3, bombX + i * rect, bombY, size_Right, size_Right, null);
                        g2.drawImage(hor3, bombX - i * rect, bombY, size_Left, size_Left, null);

                    }
                    g2.drawImage(up3, bombX, bombY - sizeBomb * rect, size_Up, size_Up, null);
                    g2.drawImage(down3, bombX, bombY + sizeBomb * rect, size_Down, size_Down, null);
                    g2.drawImage(left3, bombX - sizeBomb * rect, bombY, size_Left, size_Left, null);
                    g2.drawImage(right3, bombX + sizeBomb * rect, bombY, size_Right, size_Right, null);
                }
                if (countTime == timeExploring * 3) {
                    explored = true;
                    isEXploring = false;
                    countTime = 0;
                    bombCount = 0;
                    NumOfBomb ++;
                }

            }
        }
    }
}