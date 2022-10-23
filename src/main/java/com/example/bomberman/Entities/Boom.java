package com.example.bomberman.Entities;

import com.example.bomberman.CheckCollision;
import com.example.bomberman.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Boom extends Entity {
    GamePanel gamePanel;
    Object object;
    int SIZE = GamePanel.SCALED_SIZE;
    public int frameUp, frameDown, frameLeft, frameRight;

    boolean checkCollisionBrickUp;

     public int sizeBomb = 1;

    int NumOfBomb = 0;

    int boomCount =0;

    public Boom(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        sprites.getBombImage();
    }


    private int FrameUp() {
        int frame = 0;
        for (int i = 1; i <= sizeBomb; i++) {
            if (object.mapObjectNum[(y - i * SIZE)/SIZE][x / SIZE] == 1
                    || object.mapObjectNum[(y - i * SIZE)/SIZE][x / SIZE] ==2) {
                if(object.mapObjectNum[(y - i * SIZE)/SIZE][x / SIZE] ==2) {
                    checkCollisionBrickUp = true;
                    break;
                }
                break;
            }else {
                frame++;
            }
        }
        frameUp = frame;
        return frameUp;
    }

    private int FrameDown() {
        int frame = 0;
        for (int i = 1; i <= sizeBomb; i++) {
            if (object.mapObjectNum[(y + i * SIZE)/SIZE][x / SIZE] == 1
                    || object.mapObjectNum[(y + i * SIZE)/SIZE][x / SIZE] == 2) {
                if(object.mapObjectNum[(y + i * SIZE)/SIZE][x / SIZE] == 2){

                }
                break;
            }else {
                frame++;
            }
        }
        frameDown = frame;
        return frameDown;
    }

    private int FrameLeft() {
        int frame = 0;
        for (int i = 1; i <= sizeBomb; i++) {
            if (object.mapObjectNum[y/SIZE][(x - i * SIZE) / SIZE] == 1
                    || object.mapObjectNum[y/SIZE][(x - i * SIZE) / SIZE] == 2) {
                break;
            }else {
                frame++;
            }
        }
        frameLeft = frame;
        return frameLeft;
    }

    private int FrameRight() {
        int frame = 0;
        for (int i = 1; i <= sizeBomb; i++) {
            if (object.mapObjectNum[y/SIZE][(x + i * SIZE) / SIZE] == 1
                    || object.mapObjectNum[y/SIZE][(x + i * SIZE) / SIZE] == 2) {
                break;
            }else {
                frame++;
            }
        }
        frameRight = frame;
        return frameRight;
    }
    public void update(Bomber bomber) {
        if (bomber.keyboard.space){
            //gamePanel.playSE(1);
            int row = (bomber.y + GamePanel.SCALED_SIZE / 2) / GamePanel.SCALED_SIZE * GamePanel.SCALED_SIZE;
            int col = (bomber.x + GamePanel.SCALED_SIZE / 2) / GamePanel.SCALED_SIZE * GamePanel.SCALED_SIZE;
            x = col;
            y = row;
            explored = false;
            FrameUp();
            FrameDown();
            FrameLeft();
            FrameRight();
            checkCollisionBrickUp=false;
        }
    }
    public void drawFrame(Graphics2D g2,BufferedImage image1,BufferedImage image2,int x, int y, int frame, String direction){
        for(int i =1; i <= frame; i++){
            if(i!= frame){
                switch (direction){
                    case "Up":
                        g2.drawImage(image1,x,y - i *SIZE ,SIZE,SIZE,null);
                        break;
                    case "Down":
                        g2.drawImage(image1,x,y + i*SIZE ,SIZE,SIZE,null);
                        break;
                    case "Left":
                        g2.drawImage(image1,x-i*SIZE,y ,SIZE,SIZE,null);
                        break;
                    case "Right":
                        g2.drawImage(image1,x+i*SIZE,y ,SIZE,SIZE,null);
                        break;
                }
            }else {
                switch (direction) {
                    case "Up":
                        g2.drawImage(image2, x, y - i * SIZE, SIZE, SIZE, null);
                        break;
                    case "Down":
                        g2.drawImage(image2, x, y + i * SIZE, SIZE, SIZE, null);
                        break;
                    case "Left":
                        g2.drawImage(image2, x - i * SIZE, y, SIZE, SIZE, null);
                        break;
                    case "Right":
                        g2.drawImage(image2, x + i * SIZE, y, SIZE, SIZE, null);
                        break;
                }
            }
        }
    }
    public void render(Graphics2D g2, Bomber bomber) {
        if (!explored) {
            BufferedImage image = null;
            if (!isExploring) {
                if (countTime <= intervalToExplored) {
                    image = sprites.Bomb1;
                } else if (countTime <= intervalToExplored * 2) {
                    image = sprites.Bomb2;
                } else if (countTime < intervalToExplored * 3) {
                    image = sprites.Bomb3;
                }
                if (countTime == intervalToExplored * 3) {
                    isExploring = true;
                    image = null;
                    countTime = 0;
                }
            }
            countTime++;
            boomCount++;
            g2.drawImage(image, x, y, SIZE, SIZE, null);
            if(isExploring){
                if (countTime <= timeExploring) {
                    gamePanel.checkCollision.checkFlameBomb(this,countTime,timeExploring);
                    gamePanel.checkCollision.checkDie(bomber, this);
                    g2.drawImage(sprites.BombCenter1, x, y, SIZE, SIZE, null);
                    drawFrame(g2,sprites.BombVer1,sprites.BombUp1,x,y,frameUp,"Up");
                    drawFrame(g2,sprites.BombVer1,sprites.BombDown1,x,y,frameDown,"Down");
                    drawFrame(g2,sprites.BombHor1,sprites.BombLeft1,x,y,frameLeft,"Left");
                    drawFrame(g2,sprites.BombHor1,sprites.BombRight1,x,y,frameRight,"Right");

                } else if (countTime <= timeExploring * 2) {
                    gamePanel.checkCollision.checkFlameBomb(this,countTime,timeExploring);
                    gamePanel.checkCollision.checkDie(bomber, this);
                    g2.drawImage(sprites.BombCenter2, x, y, SIZE, SIZE, null);
                    drawFrame(g2,sprites.BombVer2,sprites.BombUp2,x,y,frameUp,"Up");
                    drawFrame(g2,sprites.BombVer2,sprites.BombDown2,x,y,frameDown,"Down");
                    drawFrame(g2,sprites.BombHor2,sprites.BombLeft2,x,y,frameLeft,"Left");
                    drawFrame(g2,sprites.BombHor2,sprites.BombRight2,x,y,frameRight,"Right");
                } else if (countTime <= timeExploring * 3) {
                    gamePanel.checkCollision.checkFlameBomb(this,countTime,timeExploring);
                    gamePanel.checkCollision.checkDie(bomber, this);
                    g2.drawImage(sprites.BombCenter3, x, y, SIZE, SIZE, null);
                    drawFrame(g2, sprites.BombVer3, sprites.BombUp3, x, y, frameUp, "Up");
                    drawFrame(g2, sprites.BombVer3, sprites.BombDown3, x, y, frameDown, "Down");
                    drawFrame(g2, sprites.BombHor3, sprites.BombLeft3, x, y, frameLeft, "Left");
                    drawFrame(g2, sprites.BombHor3, sprites.BombRight3, x, y, frameRight, "Right");
                }if (countTime == timeExploring * 3) {
                    explored = true;
                    isExploring = false;
                    countTime = 0;
                    boomCount =0;
                }
            }
        }
    }
}