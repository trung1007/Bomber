package com.example.bomberman.Menu;

import com.example.bomberman.GamePanel;
import com.example.bomberman.input.Mouse;

import java.awt.*;

public class MenuUI {
    GamePanel gamePanel;
    Mouse mouse;
    public MenuUI(GamePanel gamePanel,Mouse mouse){
        this.gamePanel=gamePanel;
        this.mouse=mouse;
    }
    MenuOption menuOption1=new MenuOption("START",1);
    MenuOption menuOption2=new MenuOption("OPTION",2);
    MenuOption menuOption3=new MenuOption("EXIT",3);
    MenuBackground menuBackground=new MenuBackground();

    public void update(){

    }
    public void render(Graphics2D g2){
        if(GamePanel.GameState==1){
            menuBackground.renderMenuBackGround(g2);
            menuOption1.render(g2);
            menuOption2.render(g2);
            menuOption3.render(g2);
        }

    }



}
