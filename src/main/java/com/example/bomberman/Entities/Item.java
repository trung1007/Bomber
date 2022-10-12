package com.example.bomberman.Entities;

import com.example.bomberman.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Item {

    GamePanel gamePanel;
    public BufferedImage item[] = new BufferedImage[5];
    public boolean collision = false;
    public Rectangle solidArea;

    public int solidAreaDefaultX;
    public int solidAreaDefaultY;

    public int itemX, itemY;
    public int mapItemNum[][];
    public Item(){
        this.gamePanel = gamePanel;
        mapItemNum = new int[gamePanel.MAX_SCREEN_COL][gamePanel.MAX_SCREEN_ROW];
        getItemImage();
        loadMap();
    }
    public void getItemImage(){
        try{
            item[0] = ImageIO.read(getClass().getResourceAsStream("/sprites/powerup_bombpass.png"));

            item[1] = ImageIO.read(getClass().getResourceAsStream("/sprites/powerup_bombs.png"));

            item[2] = ImageIO.read(getClass().getResourceAsStream("/sprites/powerup_speed.png"));


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
                    mapItemNum[j][i] = num + 5;
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
                int tileNum = mapItemNum[j][i];
                g2.drawImage(item[tileNum], x, y, gamePanel.SCALED_SIZE, gamePanel.SCALED_SIZE, null);
                x += gamePanel.SCALED_SIZE;
            }
            x = 0;
            y += gamePanel.SCALED_SIZE;
        }
    }
}
