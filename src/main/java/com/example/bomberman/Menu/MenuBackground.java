package com.example.bomberman.Menu;

import com.example.bomberman.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MenuBackground  {
    BufferedImage bg1,title1;
    public MenuBackground(){
        getBackGround();
    }
    public void getBackGround(){
        try{
            bg1= ImageIO.read(getClass().getResourceAsStream("/sprites/background.jpg"));
            title1=ImageIO.read(getClass().getResourceAsStream("/sprites/Logo1.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void renderMenuBackGround(Graphics2D g2){
        //g2.drawImage(bg1,0,0, GamePanel.SCALED_SIZE,GamePanel.SCALED_SIZE,null);
        g2.drawImage(bg1,0,0,GamePanel.SCREEN_WIDTH,GamePanel.SCREEN_HEIGHT,null);
        g2.drawImage(title1,GamePanel.SCALED_SIZE,GamePanel.SCALED_SIZE,GamePanel.SCALED_SIZE*5,GamePanel.SCALED_SIZE*3,null);
    }
}
