package com.example.bomberman.Entities;

import com.example.bomberman.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Bomb {
    public int bombX;
    public int bombY;
    public int intervalToExplored = 20; //  khoang thoi gian bom no
    public int timeExploring = 20; // khoang thoi gian ma bom dang no
    int NumOfBomb = 1;
    int[] NumOfItem = {0,0,0,0,0,0,0,5,6,7};
    public boolean collisionWallUp, collisionWallDown, collisionWallLeft, collisionWallRight;

    public boolean collisionBrickUp, collisionBrickDown, collisionBrickLeft, collisionBrickRight;
    public boolean explored = true;
    public boolean isExploring = false; // kiem tra xem bom da no hay chua
    public BufferedImage image = null;
    BufferedImage center1, center2, center3, left1, left2, left3, right1, right2, right3, up1, up2, up3, down1, down2, down3, ver1, ver2, ver3, hor1, hor2, hor3;
    int countTime = 0;
    int bomCount = 0;
    BufferedImage bom1, bom2, bom3;
    GamePanel gamePanel;
    public int rect = GamePanel.SCALED_SIZE;

    public int sizeBomb = 1;
    public int RandomNumOfObject(int[]Num){
        Random random=new Random();
        return Num[random.nextInt(Num.length-1)];
    }
    public Bomb(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        getBombImage();
    }

    public void getBombImage() {
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

    public void update(Bomber bomberman) {
        if (bomberman.keyboard.space && bomCount == 0) {
            int row = (bomberman.y + 24) / GamePanel.SCALED_SIZE * GamePanel.SCALED_SIZE;
            int col = (bomberman.x + 24) / GamePanel.SCALED_SIZE * GamePanel.SCALED_SIZE;
            bombX = col;
            bombY = row;

            explored = false;
        }

    }

    public void render(Graphics2D g2, Object object, Bomber bomber) {
        if (NumOfBomb < 1) {
            NumOfBomb = 1;
        }
        if (NumOfBomb >= 1) {
            if (!explored) {
                if (!isExploring) {
                    if (countTime <= intervalToExplored) {
                        image = bom1;
                    } else if (countTime <= intervalToExplored * 2) {
                        image = bom2;
                    } else if (countTime <= intervalToExplored * 3) {
                        image = bom3;
                    }
                    if (countTime == intervalToExplored * 3) {
                        isExploring = true;
                        image = null;
                        countTime = 0;
                    }

                }
                countTime++;
                bomCount++;
                g2.drawImage(image, bombX, bombY, rect, rect, null);

                //kiem tra bom no va load anh bom no
                if (isExploring) {
                    int size_up = GamePanel.SCALED_SIZE;
                    int size_down = GamePanel.SCALED_SIZE;
                    int size_left = GamePanel.SCALED_SIZE;
                    int size_right = GamePanel.SCALED_SIZE;

                    boolean checkWallUp =false;
                    boolean checkWallDown =false;
                    boolean checkWallLeft =false;
                    boolean checkWallRight =false;

                    if (countTime <= timeExploring) {
                        g2.drawImage(center1, bombX, bombY, rect, rect, null);
                        for (int i = 1; i <= sizeBomb; i++) {
                            gamePanel.checkCollision.checkFlameBomb(this, i);
                            if (collisionWallUp || collisionBrickUp) {
                                size_up = 0;
                                if(collisionWallUp){
                                    checkWallUp = true;
                                }
                                if(collisionBrickUp && checkWallUp == false){
                                    object.mapObjectNum[(bombY - i * rect) / rect][bombX / rect] = 3;
                                }
                            }
                            if (collisionWallDown||collisionBrickDown) {
                                size_down = 0;
                                if(collisionWallDown){
                                    checkWallDown = true;
                                }
                                if(collisionBrickDown && checkWallDown == false){
                                    object.mapObjectNum[(bombY + i * rect) / rect][bombX / rect] = 3;
                                }
                            }
                            if (collisionWallLeft||collisionBrickLeft) {
                                size_left = 0;
                                if(collisionWallLeft){
                                    checkWallLeft =true;
                                }
                                if (collisionBrickLeft && checkWallLeft == false) {
                                    object.mapObjectNum[(bombY) / rect][(bombX-i*rect) / rect] = 3;
                                }
                            }
                            if (collisionWallRight||collisionBrickRight) {
                                size_right = 0;
                                if(collisionWallRight){
                                    checkWallRight = true;
                                }
                                if(collisionBrickRight && checkWallRight == false){
                                    object.mapObjectNum[(bombY) / rect][(bombX+i*rect) / rect] = 3;
                                }

                            }

                            if (i == sizeBomb) {
                                g2.drawImage(up1, bombX, bombY - sizeBomb * rect, size_up, size_up, null);
                                g2.drawImage(down1, bombX, bombY + sizeBomb * rect, size_down, size_down, null);
                                g2.drawImage(left1, bombX - sizeBomb * rect, bombY, size_left, size_left, null);
                                g2.drawImage(right1, bombX + sizeBomb * rect, bombY, size_right, size_right, null);
                            } else {
                                g2.drawImage(ver1, bombX, bombY + (i) * rect, size_down, size_down, null);
                                g2.drawImage(ver1, bombX, bombY - (i) * rect, size_up, size_up, null);
                                g2.drawImage(hor1, bombX + (i) * rect, bombY, size_right, size_right, null);
                                g2.drawImage(hor1, bombX - (i) * rect, bombY, size_left, size_left, null);
                            }
                        }
                    } else if (countTime <= timeExploring * 2) {
                        g2.drawImage(center2, bombX, bombY, rect, rect, null);
                        for (int i = 1; i <= sizeBomb; i++) {
                            gamePanel.checkCollision.checkFlameBomb(this, i);
                            if (collisionWallUp || collisionBrickUp) {
                                size_up = 0;
                                if(collisionWallUp){
                                    checkWallUp = true;
                                }
                                if (collisionBrickUp && checkWallUp == false) {
                                    object.mapObjectNum[(bombY - i * rect) / rect][bombX / rect] = 3;
                                }
                            }
                            if (collisionWallDown||collisionBrickDown) {
                                size_down = 0;
                                if(collisionWallDown){
                                    checkWallDown = true;
                                }
                                if(collisionBrickDown && checkWallDown == false){
                                    object.mapObjectNum[(bombY + i * rect) / rect][bombX / rect] = 3;
                                }
                            }
                            if (collisionWallLeft||collisionBrickLeft) {
                                size_left = 0;
                                if(collisionWallLeft){
                                    checkWallLeft = true;
                                }
                                if(collisionBrickLeft && checkWallLeft == false){
                                    object.mapObjectNum[(bombY) / rect][(bombX-i*rect) / rect] = 3;
                                }
                            }
                            if (collisionWallRight||collisionBrickRight) {
                                size_right = 0;
                                if(collisionWallRight){
                                    checkWallRight = true;
                                }
                                if(collisionBrickRight && checkWallRight == false){
                                    object.mapObjectNum[(bombY) / rect][(bombX+i*rect) / rect] = 3;
                                }
                            }
                            if (i == sizeBomb) {
                                g2.drawImage(up2, bombX, bombY - sizeBomb * rect, size_up, size_up, null);
                                g2.drawImage(down2, bombX, bombY + sizeBomb * rect, size_down, size_down, null);
                                g2.drawImage(left2, bombX - sizeBomb * rect, bombY, size_left, size_left, null);
                                g2.drawImage(right2, bombX + sizeBomb * rect, bombY, size_right, size_right, null);
                            } else {
                                g2.drawImage(ver2, bombX, bombY - i * rect, size_up, size_up, null);
                                g2.drawImage(ver2, bombX, bombY + i * rect, size_down, size_down, null);
                                g2.drawImage(hor2, bombX - i * rect, bombY, size_left, size_left, null);
                                g2.drawImage(hor2, bombX + i * rect, bombY, size_right, size_right, null);
                            }
                        }
                    } else if (countTime <= timeExploring * 3) {
                        g2.drawImage(center3, bombX, bombY, rect, rect, null);
                        for (int i = 1; i <= sizeBomb; i++) {
                            gamePanel.checkCollision.checkFlameBomb(this, i);
                            if (collisionWallUp || collisionBrickUp) {
                                size_up = 0;
                                if(collisionWallUp){
                                    checkWallUp =true;
                                }
                                if (collisionBrickUp && countTime < timeExploring * 3 && checkWallUp == false) {
                                    object.mapObjectNum[(bombY - i * rect) / rect][bombX / rect] = 4;
                                } else if (collisionBrickUp && countTime >= timeExploring * 3 && checkWallUp == false) {
                                    int num = RandomNumOfObject(NumOfItem);
                                    object.mapObjectNum[(bombY - i * rect) / rect][bombX / rect] = num;
                                }
                            }
                            if (collisionWallDown || collisionBrickDown) {
                                size_down = 0;
                                if(collisionWallDown){
                                    checkWallDown= true;
                                }
                                if (collisionBrickDown && countTime < timeExploring * 3 && checkWallDown==false) {
                                    object.mapObjectNum[(bombY + i * rect) / rect][bombX / rect] = 4;
                                } else if (collisionBrickDown && countTime >= timeExploring * 3 && checkWallDown==false) {
                                    int num = RandomNumOfObject(NumOfItem);
                                    object.mapObjectNum[(bombY + i * rect) / rect][bombX / rect] = num;
                                }
                            }
                            if (collisionWallLeft||collisionBrickLeft) {
                                size_left = 0;
                                if(collisionWallLeft){
                                    checkWallLeft = true;
                                }
                                if (collisionBrickLeft && countTime < timeExploring * 3 && checkWallLeft ==false) {
                                    object.mapObjectNum[(bombY ) / rect][(bombX-i*rect) / rect] = 4;
                                } else if (collisionBrickLeft && countTime >= timeExploring * 3 && checkWallLeft ==false ) {
                                    int num = RandomNumOfObject(NumOfItem);
                                    object.mapObjectNum[(bombY ) / rect][(bombX-i*rect) / rect] = num;
                                }
                            }
                            if (collisionWallRight||collisionBrickRight) {
                                size_right = 0;
                                if(collisionWallRight){
                                    checkWallRight= true;
                                }
                                if (collisionBrickRight && countTime < timeExploring * 3 && checkWallRight == false) {
                                    object.mapObjectNum[(bombY ) / rect][(bombX+i*rect) / rect] = 4;
                                } else if (collisionBrickRight && countTime >= timeExploring * 3 && checkWallRight == false) {
                                    int num = RandomNumOfObject(NumOfItem);
                                    object.mapObjectNum[(bombY ) / rect][(bombX+i*rect) / rect] = num;
                                }
                            }
                            if (i == sizeBomb) {
                                g2.drawImage(up3, bombX, bombY - sizeBomb * rect, size_up, size_up, null);
                                g2.drawImage(down3, bombX, bombY + sizeBomb * rect, size_down, size_down, null);
                                g2.drawImage(left3, bombX - sizeBomb * rect, bombY, size_left, size_left, null);
                                g2.drawImage(right3, bombX + sizeBomb * rect, bombY, size_right, size_right, null);
                            } else {
                                g2.drawImage(ver3, bombX, bombY + i * rect, size_down, size_down, null);
                                g2.drawImage(ver3, bombX, bombY - i * rect, size_up, size_up, null);
                                g2.drawImage(hor3, bombX + i * rect, bombY, size_right, size_right, null);
                                g2.drawImage(hor3, bombX - i * rect, bombY, size_left, size_left, null);
                            }

                        }
                    }
                    if (countTime == timeExploring * 3) {
                        explored = true;
                        isExploring = false;
                        countTime = 0;
                        bomCount = 0;
                        NumOfBomb--;
                    }
                }
            }
        }
    }

}
