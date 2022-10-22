package com.example.bomberman.Entities;

import com.example.bomberman.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Boom extends Entity {
    GamePanel gamePanel;
    Object object;
    int SIZE = GamePanel.SCALED_SIZE;
    BufferedImage bom1, bom2, bom3;
    BufferedImage center1, center2, center3, up1, up2, up3, down1, down2, down3, left1, left2, left3, right1, right2, right3, ver1, ver2, ver3, hor1, hor2, hor3;
    public int frameUp, frameDown, frameLeft, frameRight;
    boolean explored = true; // kiem tra xem da no hay chua
    boolean isExploring = false; // kiem tra xem co dang no hay khong
    public int countTime = 0, intervalToExplored = 20, timeExploring = 20;
    public int sizeBomb = 1;
    int NumOfBomb = 0;
    public Boom(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        getBoomImage();
    }

    public void getBoomImage() {
        try {
            bom1 = ImageIO.read(getClass().getResourceAsStream("/sprites/bomb-1.png"));
            bom2 = ImageIO.read(getClass().getResourceAsStream("/sprites/bomb-2.png"));
            bom3 = ImageIO.read(getClass().getResourceAsStream("/sprites/bomb-3.png"));

            center1 = ImageIO.read(getClass().getResourceAsStream("/sprites/center-1.png"));
            ver1 = ImageIO.read(getClass().getResourceAsStream("/sprites/vertical-1.png"));
            hor1 = ImageIO.read(getClass().getResourceAsStream("/sprites/horizontal-1.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/sprites/up-last-1.png"));

            down1 = ImageIO.read(getClass().getResourceAsStream("/sprites/down-last-1.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/sprites/right-last-1.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/sprites/left-last-1.png"));

            center2 = ImageIO.read(getClass().getResourceAsStream("/sprites/center-2.png"));
            ver2 = ImageIO.read(getClass().getResourceAsStream("/sprites/vertical-2.png"));
            hor2 = ImageIO.read(getClass().getResourceAsStream("/sprites/horizontal-2.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/sprites/up-last-2.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/sprites/down-last-2.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/sprites/right-last-2.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/sprites/left-last-2.png"));

            center3 = ImageIO.read(getClass().getResourceAsStream("/sprites/center-3.2.png"));
            ver3 = ImageIO.read(getClass().getResourceAsStream("/sprites/vertical-3.png"));
            hor3 = ImageIO.read(getClass().getResourceAsStream("/sprites/horizontal-3.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/sprites/up-last-3.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/sprites/down-last-3.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/sprites/right-last-3.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/sprites/left-last-3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private int FrameUp() {
        int frame = 0;
        for (int i = 1; i <= sizeBomb; i++) {
            if (object.mapObjectNum[(y - i * SIZE)/SIZE][x / SIZE] == 1
                    || object.mapObjectNum[(y - i * SIZE)/SIZE][x / SIZE] ==2
                    || object.mapObjectNum[(y - i * SIZE)/SIZE][x / SIZE] ==3
                    || object.mapObjectNum[(y - i * SIZE)/SIZE][x / SIZE] ==4) {

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
                    || object.mapObjectNum[(y + i * SIZE)/SIZE][x / SIZE] == 2
                    || object.mapObjectNum[(y + i * SIZE)/SIZE][x / SIZE] == 3
                    || object.mapObjectNum[(y + i * SIZE)/SIZE][x / SIZE] == 4) {
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
                    || object.mapObjectNum[y/SIZE][(x - i * SIZE) / SIZE] == 2
                    || object.mapObjectNum[y/SIZE][(x - i * SIZE) / SIZE] == 3
                    || object.mapObjectNum[y/SIZE][(x - i * SIZE) / SIZE] == 4) {
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
                    || object.mapObjectNum[y/SIZE][(x + i * SIZE) / SIZE] == 2
                    || object.mapObjectNum[y/SIZE][(x + i * SIZE) / SIZE] == 3
                    || object.mapObjectNum[y/SIZE][(x + i * SIZE) / SIZE] == 4) {
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
            gamePanel.playSE(1);
            int row = (bomber.y + GamePanel.SCALED_SIZE / 2) / GamePanel.SCALED_SIZE * GamePanel.SCALED_SIZE;
            int col = (bomber.x + GamePanel.SCALED_SIZE / 2) / GamePanel.SCALED_SIZE * GamePanel.SCALED_SIZE;
            x = col;
            y = row;
            explored = false;
            FrameUp();
            FrameDown();
            FrameLeft();
            FrameRight();
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
    public void render(Graphics2D g2) {
        if (!explored) {
            BufferedImage image = null;
            if (!isExploring) {
                if (countTime <= intervalToExplored) {
                    image = bom1;
                } else if (countTime <= intervalToExplored * 2) {
                    image = bom2;
                } else if (countTime < intervalToExplored * 3) {
                    image = bom3;
                }
                if (countTime == intervalToExplored * 3) {
                    isExploring = true;
                    image = null;
                    countTime = 0;
                }
                g2.drawImage(image, x, y, SIZE, SIZE, null);
            } else {
                if (countTime <= timeExploring) {
                    gamePanel.checkCollision.checkFlameBomb(this,countTime, timeExploring);
                    g2.drawImage(center1, x, y, SIZE, SIZE, null);
                    drawFrame(g2,ver1,up1,x,y,frameUp,"Up");
                    drawFrame(g2,ver1,down1,x,y,frameDown,"Down");
                    drawFrame(g2,hor1,left1,x,y,frameLeft,"Left");
                    drawFrame(g2,hor1,right1,x,y,frameRight,"Right");
                } else if (countTime <= timeExploring * 2) {
                    gamePanel.checkCollision.checkFlameBomb(this,countTime, timeExploring);
                    g2.drawImage(center2, x, y, SIZE, SIZE, null);
                    drawFrame(g2,ver2,up2,x,y,frameUp,"Up");
                    drawFrame(g2,ver2,down2,x,y,frameDown,"Down");
                    drawFrame(g2,hor2,left2,x,y,frameLeft,"Left");
                    drawFrame(g2,hor2,right2,x,y,frameRight,"Right");
                } else if (countTime <= timeExploring * 3) {
                    gamePanel.checkCollision.checkFlameBomb(this,countTime,timeExploring);
                    g2.drawImage(center3, x, y, SIZE, SIZE, null);
                    drawFrame(g2,ver3,up3,x,y,frameUp,"Up");
                    drawFrame(g2,ver3,down3,x,y,frameDown,"Down");
                    drawFrame(g2,hor3,left3,x,y,frameLeft,"Left");
                    drawFrame(g2,hor3,right3,x,y,frameRight,"Right");
                }

                if (countTime == timeExploring * 3) {
                    explored = true;
                    isExploring = false;
                    countTime = 0;

                }
            }
            countTime++;
        }
    }
}
