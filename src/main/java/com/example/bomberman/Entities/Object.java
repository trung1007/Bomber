package com.example.bomberman.Entities;

import com.example.bomberman.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Object {
    GamePanel gamePanel;
    public BufferedImage object[] = new BufferedImage[10];

//    public BufferedImage item[] = new BufferedImage[5];
    public boolean collision[] = new boolean[10];
    public int mapObjectNum[][];
//    public int mapItemNum[][];

//    public Bomb bomb;

    public Object(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        mapObjectNum = new int[gamePanel.MAX_SCREEN_ROW][gamePanel.MAX_SCREEN_COL];
//        mapItemNum = new int[gamePanel.MAX_SCREEN_COL][gamePanel.MAX_SCREEN_ROW];
        getObjectImage();
        loadMap();
    }
    public void getObjectImage(){
        try{

            //get tile image

            object[0] = ImageIO.read(getClass().getResourceAsStream("/sprites/grass.png"));// grass
            collision[0] = false;
            object[1] = ImageIO.read(getClass().getResourceAsStream("/sprites/wall.png")); // wall
            collision[1] = true;
            object[2] = ImageIO.read(getClass().getResourceAsStream("/sprites/brick.png")); // wall
            collision[2] = true;


            //get item image

            object[5] = ImageIO.read(getClass().getResourceAsStream("/sprites/powerup_bombpass.png")); //size bomb
            collision[5] = false;
            object[6] = ImageIO.read(getClass().getResourceAsStream("/sprites/powerup_bombs.png"));//bombs
            collision[6] = false;
            object[7] = ImageIO.read(getClass().getResourceAsStream("/sprites/powerup_speed.png"));//speed
            collision[7] = false;

//            item[0] = ImageIO.read(getClass().getResourceAsStream("/sprites/powerup_bombpass.png"));
//
//            item[1] = ImageIO.read(getClass().getResourceAsStream("/sprites/powerup_bombs.png"));
//
//            item[2] = ImageIO.read(getClass().getResourceAsStream("/sprites/powerup_speed.png"));
//


        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void loadMap(){
        try{
            InputStream is = getClass().getResourceAsStream("/levels/map.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            for(int i = 0; i < gamePanel.MAX_SCREEN_ROW; i++){
                String line = bufferedReader.readLine();
                for(int j = 0; j < gamePanel.MAX_SCREEN_COL; j++){
//                    String line = bufferedReader.readLine();
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[j]);
                    mapObjectNum[i][j] = num;
                }
            }
            bufferedReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void render(Graphics2D g2){
        int x = 0;// vi tri x
        int y = 0; // vi tri y
        for(int i = 0; i < gamePanel.MAX_SCREEN_ROW; i++){
            for(int j = 0; j < gamePanel.MAX_SCREEN_COL; j++){
                int tileNum = mapObjectNum[i][j];
                g2.drawImage(object[tileNum], x, y, gamePanel.SCALED_SIZE, gamePanel.SCALED_SIZE, null);
                x += gamePanel.SCALED_SIZE;
            }
            x = 0;
            y += gamePanel.SCALED_SIZE;
        }
    }
}
