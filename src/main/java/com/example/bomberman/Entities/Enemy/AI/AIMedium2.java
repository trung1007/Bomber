package com.example.bomberman.Entities.Enemy.AI;

import com.example.bomberman.Entities.Balloon;
import com.example.bomberman.Entities.Bomber;
import com.example.bomberman.Entities.Boom;

public class AIMedium2 extends AI{

    Balloon balloon;
    Bomber bomber;
    Boom boom;

    public AIMedium2(Bomber bomber, Balloon balloon, Boom boom) {
        this.bomber = bomber;
        this.balloon = balloon;
        this.boom = boom;
    }

    @Override
    public int calculateDirection() {
        return findDirection();
    }

    public int findDirection() {

        int way = random.nextInt(10);
        if (way % 2 == 0) {
            int _dir = dicrectionRow();
            if (_dir != - 1) {
                return _dir;
            }
            return dicrectionCol();
        } else {
            int _dir = dicrectionCol();
            if (_dir != - 1) {
                return _dir;
            }
            return dicrectionRow();
        }
    }

    public int dicrectionRow() {
        if (bomber.x > balloon.x) return 1;
        if (bomber.x < balloon.x) return 3;
        return -1;
    }
    public int dicrectionCol(){
        if (bomber.y < balloon.y) return 0;
        if (bomber.y > balloon.y) return 2;
        return -1;
    }
}