package com.example.bomberman.Menu;

import com.example.bomberman.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MenuOption {

    BufferedImage option;
    String textOption;
    public static int setColorNum =1;
    public static int setColorNumOfHelp =1;
    public static int setColorNumOfExit =1;

    public int pos;
    public int XofOption;
    public int YofOption;

    public int XofString;
    public int YofString;
    public Color color;

    public MenuOption(String TextOption,int pos,Color color){
        this.pos=pos;
        this.textOption=TextOption;
        this.color=color;
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
        g2.drawImage(option, XofOption,YofOption,196,48,null);
        if(setColorNum ==1){
            g2.setColor(Color.BLACK);
        }
        if(setColorNum ==2){
            g2.setColor(this.color);
        }
        g2.setFont(new Font("TimesRoman",Font.PLAIN,20));
        g2.drawString(textOption,XofString,YofString);
    }


}
