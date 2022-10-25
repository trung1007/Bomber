package com.example.bomberman.Entities.Enemy.AI;

import java.util.Random;

public abstract class AI {

    protected Random random = new Random();

    /**
     * Thuật toán tìm đường đi
     */
    public abstract int calculateDirection();

}
