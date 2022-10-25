package com.example.bomberman.Entities;

import com.example.bomberman.Entities.Enemy.AI.AI;
import com.example.bomberman.Entities.Enemy.AI.AIMedium;
import com.example.bomberman.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Frog extends Enemies{
    GamePanel gamePanel;

    Bomber bomber;

    Boom boom;

    protected int directionFrog;



    protected AI ai;

    public Frog(Bomber bomber, GamePanel gamePanel, Boom boom){

        this.gamePanel = gamePanel;
        setDefaultValues();
        sprites.getFrogImage();
        ai = new AIMedium(bomber, this , boom);
        this.bomber = bomber;
    }

@Override
    public void setDefaultValues(){
        x = 200;
        y = 300;
        speed = 3;
    }
    @Override
    public void update(Object object){
        if(CheckDie){
            x=-1;
            y=-1;
        }
        if((bomber.x-this.x)*(bomber.x-this.x)
                + (bomber.y-this.y)*(bomber.y-this.y) <= 30000) {
            speed = 5;
            directionFrog = ai.calculateDirection();
        } else {
            speed = 3;
        }

        System.out.println("+++" + speed);

        if(collisionOn == true) {
            directionFrog = ai.calculateDirection();
        }
        collisionOn = false;
        gamePanel.checkCollision.checkTile(this);
        HandlePosition(directionFrog);
    }

}

