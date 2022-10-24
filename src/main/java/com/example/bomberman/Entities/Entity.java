package com.example.bomberman.Entities;

import com.example.bomberman.graphics.Sprites;

import java.awt.*;
import java.util.ArrayList;


public  class Entity {
    Sprites sprites=new Sprites();

    public int speed;
    public String direction;

    public Rectangle solidArea;


    public int countTime = 0, intervalToExplored = 20, timeExploring = 20;

    public int x, y;
//    public int NumOfBoom=1;
//    public boolean NumIncrease;
    public boolean collisionOn = false;

    public int solidAreaDefaultX;
    public int solidAreaDefaultY;
    //ArrayList<Boom>boomArrayList=new ArrayList<>();


}
