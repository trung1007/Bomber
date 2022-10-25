package com.example.bomberman.graphics;

import com.example.bomberman.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class UI {
    GamePanel gamePanel;
    Font arial_20;
    BufferedImage gui;
    public UI(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        arial_20 = new Font("Arial", Font.PLAIN, 20);
        getDashBoard();
    }
    public void getDashBoard(){
        try{
            gui= ImageIO.read(getClass().getResourceAsStream("/sprites/dashboard.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){
        g2.drawImage(gui,0,0,48*22,GamePanel.SCALED_SIZE*2,null);
        g2.setFont(new Font("Arial", Font.PLAIN, 20));
        g2.setColor(Color.red);
        g2.drawString("SizeBomb: " + gamePanel.boom.sizeBoom, 20, 20 );
        g2.drawString("Speed: " + gamePanel.bomber.speed, 40, 40 );
    }
}