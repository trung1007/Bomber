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

    public BufferedImage bombSize, bombs,speed;
    public boolean collision = false;
    public int worldX, worldY;

    public Item(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        getItemImage();
    }
    public void getItemImage(){
        try{
            bombSize = ImageIO.read(getClass().getResourceAsStream("/sprites/powerup_bombpass.png"));

            bombs = ImageIO.read(getClass().getResourceAsStream("/sprites/powerup_bombs.png"));

            speed = ImageIO.read(getClass().getResourceAsStream("/sprites/powerup_speed.png"));


        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void render(Graphics2D g2){
        g2.drawImage(bombSize, 50, 50, gamePanel.SCALED_SIZE, gamePanel.SCALED_SIZE, null);
    }

}
