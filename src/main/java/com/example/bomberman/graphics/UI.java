package com.example.bomberman.graphics;

import com.example.bomberman.GamePanel;

import java.awt.*;

public class UI {
    GamePanel gamePanel;
    Font arial_20;
    public UI(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        arial_20 = new Font("Arial", Font.PLAIN, 20);
    }
    public void draw(Graphics2D g2){
        g2.setFont(new Font("Arial", Font.PLAIN, 20));
        g2.setColor(Color.red);
        g2.drawString("SizeBomb: " + gamePanel.bomb.sizeBomb, 20, 20 );
    }
}
