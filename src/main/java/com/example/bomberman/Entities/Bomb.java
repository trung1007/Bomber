package com.example.bomberman.Entities;

import com.example.bomberman.CheckCollision;
import com.example.bomberman.GamePanel;
import com.example.bomberman.input.Keyboard;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Bomb {
    public int bombX;
    public int bombY;
    public int intervalToExplored = 20; //  khoang thoi gian bom no
    public int isExploring = 20; // khoang thoi gian ma bom dang no
    int NumOfBomb = 1;
    int[] NumOfItem = {0,0,0,0,0,0,0,5,6,7};


    public boolean collisionWallUp, collisionWallDown, collisionWallLeft, collisionWallRight;

    public boolean collisionBrickUp, collisionBrickDown, collisionBrickLeft, collisionBrickRight;
    public boolean explored = true;
    public boolean isExplored = false; // kiem tra xem bom da no hay chua
    public BufferedImage image = null;
    BufferedImage center1, center2, center3, left1, left2, left3, right1, right2, right3, up1, up2, up3, down1, down2, down3, ver1, ver2, ver3, hor1, hor2, hor3;


    int countTime = 0;
    int bomCount = 0;
    BufferedImage bom1, bom2, bom3;
    GamePanel gamePanel;
    Keyboard keyboard;
    Bomb bomb;
    public int rect = GamePanel.SCALED_SIZE;

    public int sizeBomb = 1;
    public int RandomNumOfObject(int[]Num){
        Random random=new Random();
        return Num[random.nextInt(Num.length-1)];
    }
    public Bomb(GamePanel gamePanel, Keyboard keyboard) {
        this.gamePanel = gamePanel;
        this.keyboard = keyboard;
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
            int row = (bomberman.Y + 24) / GamePanel.SCALED_SIZE * GamePanel.SCALED_SIZE;
            int col = (bomberman.X + 24) / GamePanel.SCALED_SIZE * GamePanel.SCALED_SIZE;
            bombX = col;
            bombY = row;

            explored = false;
        }

    }

    public void render(Graphics2D g2, Object object) {
        if (NumOfBomb < 1) {
            NumOfBomb = 1;
        }
        if (NumOfBomb >= 1) {
            if (!explored) {
                if (!isExplored) {
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
                bomCount++;
                g2.drawImage(image, bombX, bombY, rect, rect, null);

                //kiem tra bom no va load anh bom no
                if (isExplored) {
                    int size_up = GamePanel.SCALED_SIZE;
                    int size_down = GamePanel.SCALED_SIZE;
                    int size_left = GamePanel.SCALED_SIZE;
                    int size_right = GamePanel.SCALED_SIZE;

                    if (countTime <= isExploring) {
                        g2.drawImage(center1, bombX, bombY, rect, rect, null);
                        for (int i = 1; i <= sizeBomb; i++) {
                            gamePanel.checkCollision.checkFlameBomb(this, i);
                            if (collisionWallUp || collisionBrickUp) {
                                size_up = 0;
                            }
                            if (collisionWallDown||collisionBrickDown) {
                                size_down = 0;
                            }
                            if (collisionWallLeft||collisionBrickLeft) {
                                size_left = 0;
                            }
                            if (collisionWallRight||collisionBrickRight) {
                                size_right = 0;
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
                    } else if (countTime <= isExploring * 2) {
                        g2.drawImage(center2, bombX, bombY, rect, rect, null);
                        for (int i = 1; i <= sizeBomb; i++) {
                            gamePanel.checkCollision.checkFlameBomb(this, i);
                            if (collisionWallUp || collisionBrickUp) {
                                size_up = 0;
                                if (collisionBrickUp) {
                                    object.mapObjectNum[(bombY - i * rect) / rect][bombX / rect] = 3;
                                }
                            }
                            if (collisionWallDown||collisionBrickDown) {
                                size_down = 0;
                                if(collisionBrickDown){
                                    object.mapObjectNum[(bombY + i * rect) / rect][bombX / rect] = 3;
                                }
                            }
                            if (collisionWallLeft||collisionBrickLeft) {
                                size_left = 0;
                                if(collisionBrickLeft){
                                    object.mapObjectNum[(bombY) / rect][(bombX-i*rect) / rect] = 3;
                                }
                            }
                            if (collisionWallRight||collisionBrickRight) {
                                size_right = 0;
                                if(collisionBrickRight){
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
                    } else if (countTime <= isExploring * 3) {
                        g2.drawImage(center3, bombX, bombY, rect, rect, null);
                        for (int i = 1; i <= sizeBomb; i++) {
                            gamePanel.checkCollision.checkFlameBomb(this, i);
                            if (collisionWallUp || collisionBrickUp) {
                                size_up = 0;
                                if (collisionBrickUp && countTime < isExploring * 3) {
                                    object.mapObjectNum[(bombY - i * rect) / rect][bombX / rect] = 4;
                                } else if (collisionBrickUp && countTime >= isExploring * 3) {
                                    int num = RandomNumOfObject(NumOfItem);
                                    object.mapObjectNum[(bombY - i * rect) / rect][bombX / rect] = num;
                                }
                            }
                            if (collisionWallDown || collisionBrickDown) {
                                size_down = 0;
                                if (collisionBrickDown && countTime < isExploring * 3) {
                                    object.mapObjectNum[(bombY + i * rect) / rect][bombX / rect] = 4;
                                } else if (collisionBrickDown && countTime >= isExploring * 3 ) {
                                    int num = RandomNumOfObject(NumOfItem);
                                    object.mapObjectNum[(bombY + i * rect) / rect][bombX / rect] = num;
                                }
                            }
                            if (collisionWallLeft||collisionBrickLeft) {
                                size_left = 0;
                                if (collisionBrickLeft && countTime < isExploring * 3) {
                                    object.mapObjectNum[(bombY ) / rect][(bombX-i*rect) / rect] = 4;
                                } else if (collisionBrickLeft && countTime >= isExploring * 3 ) {
                                    int num = RandomNumOfObject(NumOfItem);
                                    object.mapObjectNum[(bombY ) / rect][(bombX-i*rect) / rect] = num;
                                }
                            }
                            if (collisionWallRight||collisionBrickRight) {
                                size_right = 0;
                                if (collisionBrickRight && countTime < isExploring * 3) {
                                    object.mapObjectNum[(bombY ) / rect][(bombX+i*rect) / rect] = 4;
                                } else if (collisionBrickRight && countTime >= isExploring * 3 ) {
                                    int num = RandomNumOfObject(NumOfItem);
                                    object.mapObjectNum[(bombY ) / rect][(bombX+i*rect) / rect] = num;
                                }
                            }

                            /*int pos_bomb_up = (bombY - (i) * rect) / GamePanel.SCALED_SIZE;
                            int pos_bomb_down = (bombY + (i) * rect) / GamePanel.SCALED_SIZE;
                            int pos_bomb_right = (bombX + (i) * rect) / GamePanel.SCALED_SIZE;
                            int pos_bomb_left = (bombX - (i) * rect) / GamePanel.SCALED_SIZE;
                            if (pos_bomb_left < 0) {
                                pos_bomb_left = 0;
                            }
                            if (pos_bomb_right >= GamePanel.MAX_SCREEN_COL) {
                                pos_bomb_right = GamePanel.MAX_SCREEN_COL - 1;
                            }
                            if (pos_bomb_up < 0) {
                                pos_bomb_up = 0;
                            }
                            if (pos_bomb_down >= GamePanel.MAX_SCREEN_ROW) {
                                pos_bomb_down = GamePanel.MAX_SCREEN_ROW - 1;
                            }
                            if (object.mapObjectNum[pos_bomb_up][(bombX) / GamePanel.SCALED_SIZE] == 1 || object.mapObjectNum[pos_bomb_up][(bombX) / GamePanel.SCALED_SIZE] == 2 || object.mapObjectNum[pos_bomb_up][(bombX) / GamePanel.SCALED_SIZE] == 3) {
                                size_up = 0;
                                if (object.mapObjectNum[pos_bomb_up][(bombX) / GamePanel.SCALED_SIZE] == 2 && countTime == isExploring * 3) {
                                    object.mapObjectNum[pos_bomb_up][(bombX) / GamePanel.SCALED_SIZE] = 0;
//                                        System.out.println(size_up);

                                }
                                if (object.mapObjectNum[pos_bomb_up][(bombX) / GamePanel.SCALED_SIZE] == 3 && countTime == isExploring * 3) {
                                    object.mapObjectNum[pos_bomb_up][(bombX) / GamePanel.SCALED_SIZE] = 5;
//                                        System.out.println(size_up);

                                }
                            }
                            if (object.mapObjectNum[pos_bomb_down][(bombX) / GamePanel.SCALED_SIZE] == 1 || object.mapObjectNum[pos_bomb_down][(bombX) / GamePanel.SCALED_SIZE] == 2 || object.mapObjectNum[pos_bomb_down][(bombX) / GamePanel.SCALED_SIZE] == 3) {
                                size_down = 0;
                                if (object.mapObjectNum[pos_bomb_down][(bombX) / GamePanel.SCALED_SIZE] == 2 && countTime == isExploring * 3) {
                                    object.mapObjectNum[pos_bomb_down][(bombX) / GamePanel.SCALED_SIZE] = 0;
                                    //System.out.println(size_down);
                                }
                                if (object.mapObjectNum[pos_bomb_down][(bombX) / GamePanel.SCALED_SIZE] == 3 && countTime == isExploring * 3) {
                                    object.mapObjectNum[pos_bomb_down][(bombX) / GamePanel.SCALED_SIZE] = 5;
                                    //System.out.println(size_down);
                                }
                            }

                            if (object.mapObjectNum[(bombY) / GamePanel.SCALED_SIZE][pos_bomb_left] == 1 || object.mapObjectNum[(bombY) / GamePanel.SCALED_SIZE][pos_bomb_left] == 2 || object.mapObjectNum[(bombY) / GamePanel.SCALED_SIZE][pos_bomb_left] == 3) {
                                size_left = 0;
                                if (object.mapObjectNum[(bombY) / GamePanel.SCALED_SIZE][pos_bomb_left] == 2 && countTime == isExploring * 3) {
                                    object.mapObjectNum[(bombY) / GamePanel.SCALED_SIZE][pos_bomb_left] = 0;
                                    //System.out.println(size_left);
                                }
                                if (object.mapObjectNum[(bombY) / GamePanel.SCALED_SIZE][pos_bomb_left] == 3 && countTime == isExploring * 3) {
                                    object.mapObjectNum[(bombY) / GamePanel.SCALED_SIZE][pos_bomb_left] = 5;
                                    //System.out.println(size_left);
                                }
                            }
                            if (object.mapObjectNum[(bombY) / GamePanel.SCALED_SIZE][pos_bomb_right] == 1 || object.mapObjectNum[(bombY) / GamePanel.SCALED_SIZE][pos_bomb_right] == 2 || object.mapObjectNum[(bombY) / GamePanel.SCALED_SIZE][pos_bomb_right] == 3) {
                                size_right = 0;
                                if (object.mapObjectNum[(bombY) / GamePanel.SCALED_SIZE][pos_bomb_right] == 2 && countTime == isExploring * 3) {
                                    object.mapObjectNum[(bombY) / GamePanel.SCALED_SIZE][pos_bomb_right] = 0;
                                    //System.out.println(size_right);
                                }
                                if (object.mapObjectNum[(bombY) / GamePanel.SCALED_SIZE][pos_bomb_right] == 3 && countTime == isExploring * 3) {
                                    object.mapObjectNum[(bombY) / GamePanel.SCALED_SIZE][pos_bomb_right] = 5;
                                    //System.out.println(size_right);

                                }
                            }
*/
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
                        System.out.println(size_down);
                        System.out.println(countTime);

                    }
                    if (countTime == isExploring * 3) {
                        explored = true;
                        isExplored = false;
                        countTime = 0;
                        bomCount = 0;
                        NumOfBomb--;
                    }
                }
            }
        }
    }
}
