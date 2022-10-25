package com.example.bomberman.Entities;


import com.example.bomberman.Entities.Enemy.AI.AI;
import com.example.bomberman.Entities.Enemy.AI.AIMedium2;
import com.example.bomberman.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Balloon extends Enemies {
    GamePanel gamePanel;
    Bomber bomber;
    protected int directionBalloon;
    protected AI ai;

    public Balloon(Bomber bomber, GamePanel gamePanel, Boom boom) {
        this.bomber=bomber;
        this.gamePanel = gamePanel;
        setDefaultValues();
        sprites.getBalloonImage();
        ai = new AIMedium2(bomber, this, boom);

    }

    @Override
    public void setDefaultValues() {
        x = 48*20;
        y = 48*14;
        speed = 3;
    }


    @Override
    public void update(Object object) {
        if(CheckDie){
            x=-1;
            y=-1;
        }
        collisionOn = false;
        gamePanel.checkCollision.checkTile(this);
        if (collisionOn == true) {
            directionBalloon = ai.calculateDirection();
        }
        HandlePosition(directionBalloon);
        gamePanel.checkCollision.checkDieEnemy(bomber,this);
    }
}
