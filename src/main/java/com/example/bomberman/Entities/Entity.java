package com.example.bomberman.Entities;

import com.example.bomberman.graphics.Sprites;

import java.awt.*;
import java.util.ArrayList;


public abstract class Entity {
    Sprites sprites=new Sprites();

    public int speed;
    public String direction = "DOWN";
    public Rectangle solidArea = new Rectangle(10,10,20,28);
    public int countTime = 0, intervalToExplored = 20, timeExploring = 20;

    public int x, y;
//    public int NumOfBoom=1;
//    public boolean NumIncrease;
    public boolean collisionOn = false;
    public boolean CheckDie = false;

    public abstract void render(Graphics2D g2,String name);

    //ArrayList<Boom>boomArrayList=new ArrayList<>();


}
