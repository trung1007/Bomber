package com.example.bomberman.Entities;

import com.example.bomberman.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Tile {
    GamePanel gamePanel;
    public BufferedImage image[] = new BufferedImage[10];
    public boolean collision[] = new boolean[10];
    public int mapTileNum[][];
    public Bomb bomb;

    public Tile(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        mapTileNum = new int[gamePanel.MAX_SCREEN_COL][gamePanel.MAX_SCREEN_ROW];
        getTileImage();
        loadMap();
    }
    public void getTileImage(){
        try{
            image[0] = ImageIO.read(getClass().getResourceAsStream("/sprites/grass.png"));// grass
            collision[0] = false;
            image[1] = ImageIO.read(getClass().getResourceAsStream("/sprites/wall.png")); // wall
            collision[1] = true;
            image[2] = ImageIO.read(getClass().getResourceAsStream("/sprites/brick.png")); // wall
            collision[2] = true;

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
                    mapTileNum[j][i] = num;
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
                int tileNum = mapTileNum[j][i];
                g2.drawImage(image[tileNum], x, y, gamePanel.SCALED_SIZE, gamePanel.SCALED_SIZE, null);
                x += gamePanel.SCALED_SIZE;
            }
            x = 0;
            y += gamePanel.SCALED_SIZE;
        }
    }
}
