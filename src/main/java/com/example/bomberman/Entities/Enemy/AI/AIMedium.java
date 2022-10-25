package com.example.bomberman.Entities.Enemy.AI;

import com.example.bomberman.Entities.Boom;
import com.example.bomberman.Entities.Frog;
import com.example.bomberman.Entities.Bomber;

import java.util.ArrayList;
import java.util.List;

public class AIMedium extends AI {

    Bomber bomber;

    Boom boom;

    Frog frog;

    List<PathFinding> aStarList = new ArrayList<>();

    public AIMedium(Bomber bomber, Frog frog, Boom boom) {
        this.bomber = bomber;
        this.boom = boom;
        this.frog = frog;
    }

    public int calculateDirection() {
        if (bomber == null) return random.nextInt(4);
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
        if (bomber.x > frog.x) return 1;
        if (bomber.x < frog.x) return 3;
        return -1;
    }
    public int dicrectionCol(){
        if (bomber.y < frog.y) return 0;
        if (bomber.y > frog.y) return 2;
        return -1;
    }
}
