package com.example.bomberman.Menu;

import com.example.bomberman.GamePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MenuOption {
    BufferedImage option;
    String textOption;

    int pos;
    public int XofOption;
    public int YofOption;

    public int XofString;
    public int YofString;

    public MenuOption(String TextOption,int pos){
        this.pos=pos;
        this.textOption=TextOption;
        GetMenuOption();
        SetDefault();

    }
    public void SetDefault(){
        XofOption=GamePanel.SCALED_SIZE*2;
        YofOption=GamePanel.SCALED_SIZE*(pos+3);
        XofString=GamePanel.SCALED_SIZE*3;
        YofString=GamePanel.SCALED_SIZE*(pos+4)-20;

    }
    public void GetMenuOption(){
        try{
            option= ImageIO.read(getClass().getResourceAsStream("/sprites/play8.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public void render(Graphics2D g2){
        g2.drawImage(option, XofOption,YofOption,GamePanel.SCALED_SIZE*4,GamePanel.SCALED_SIZE,null);
        g2.setFont(new Font("TimesRoman",Font.PLAIN,20));
        g2.drawString(textOption,XofString,YofString);
    }


}
