package com.example.bomberman.Entities;

import com.example.bomberman.graphics.Sprites;

import java.awt.*;


public  class Entity {
    Sprites sprites=new Sprites();

    public int speed;
    public String direction;

    public Rectangle solidArea;
    boolean explored = true; // kiem tra xem da no hay chua
    boolean isExploring = false; // kiem tra xem co dang no hay khong
    public int countTime = 0, intervalToExplored = 20, timeExploring = 20;

    public int x, y;
    public boolean collisionOn = false;

}
