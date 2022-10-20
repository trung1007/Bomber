package com.example.bomberman;

import com.example.bomberman.Entities.Bomb;
import com.example.bomberman.Entities.Bomber;

public class CheckCollision {
    GamePanel gamePanel;

    public CheckCollision(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void checkTile(Bomber bomber) {
        int entityLeftWorldX = bomber.x + bomber.solidArea.x;
        int entityRightWorldX = bomber.x + bomber.solidArea.x + bomber.solidArea.width;
        int entityTopWorldY = bomber.y + bomber.solidArea.y;
        int entityBotWorldY = bomber.y + bomber.solidArea.y + bomber.solidArea.height;

        int entityLeftCol = entityLeftWorldX / GamePanel.SCALED_SIZE;
        int entityRightCol = entityRightWorldX / GamePanel.SCALED_SIZE;
        int entityTopRow = entityTopWorldY / GamePanel.SCALED_SIZE;
        int entityBotRow = entityBotWorldY / GamePanel.SCALED_SIZE;

        int tileNum1, tileNum2;
        switch (bomber.direction) {
            case "UP":
                entityTopRow = (entityTopWorldY - bomber.speed) / gamePanel.SCALED_SIZE;
                tileNum1 = gamePanel.object.mapObjectNum[entityTopRow][entityLeftCol];
                tileNum2 = gamePanel.object.mapObjectNum[entityTopRow][entityRightCol];
                if (gamePanel.object.collision[tileNum1] == true || gamePanel.object.collision[tileNum2] == true) {
                    bomber.collisionOn = true;
                }
                break;
            case "DOWN":
                entityBotRow = (entityBotWorldY + bomber.speed) / gamePanel.SCALED_SIZE;
                tileNum1 = gamePanel.object.mapObjectNum[entityBotRow][entityLeftCol];
                tileNum2 = gamePanel.object.mapObjectNum[entityBotRow][entityRightCol];

                if (gamePanel.object.collision[tileNum1] == true || gamePanel.object.collision[tileNum2] == true) {
                    bomber.collisionOn = true;
                }
                break;
            case "LEFT":
                entityLeftCol = (entityLeftWorldX - bomber.speed) / gamePanel.SCALED_SIZE;
                tileNum1 = gamePanel.object.mapObjectNum[entityTopRow][entityLeftCol];
                tileNum2 = gamePanel.object.mapObjectNum[entityBotRow][entityLeftCol];
                System.out.println(entityLeftWorldX);
                if (gamePanel.object.collision[tileNum1] == true || gamePanel.object.collision[tileNum2] == true) {
                    bomber.collisionOn = true;
                }
                break;
            case "RIGHT":
                entityRightCol = (entityRightWorldX + bomber.speed) / gamePanel.SCALED_SIZE;
                tileNum1 = gamePanel.object.mapObjectNum[entityTopRow][entityRightCol];
                tileNum2 = gamePanel.object.mapObjectNum[entityBotRow][entityRightCol];

                if (gamePanel.object.collision[tileNum1] == true || gamePanel.object.collision[tileNum2] == true) {
                    bomber.collisionOn = true;
                }
                break;
        }
    }

    public void checkFlameBomb(Bomb bomb, int i) {
        bomb.collisionWallUp = false;
        bomb.collisionWallDown = false;
        bomb.collisionWallLeft = false;
        bomb.collisionWallRight = false;

        bomb.collisionBrickUp = false;
        bomb.collisionBrickDown=false;
        bomb.collisionBrickLeft = false;
        bomb.collisionBrickRight = false;

        int row_bomb_up = (bomb.bombY - i * GamePanel.SCALED_SIZE) / GamePanel.SCALED_SIZE;
        int row_bomb_down = (bomb.bombY + i * GamePanel.SCALED_SIZE) / GamePanel.SCALED_SIZE;
        int col_bomb_right = (bomb.bombX + i * GamePanel.SCALED_SIZE) / GamePanel.SCALED_SIZE;
        int col_bomb_left = (bomb.bombX - i * GamePanel.SCALED_SIZE) / GamePanel.SCALED_SIZE;

        if (col_bomb_left < 0) {
            col_bomb_left = 0;
        }
        if (col_bomb_right >= GamePanel.MAX_SCREEN_COL) {
            col_bomb_right = GamePanel.MAX_SCREEN_COL - 1;
        }
        if (row_bomb_up < 0) {
            row_bomb_up = 0;
        }
        if (row_bomb_down >= GamePanel.MAX_SCREEN_ROW) {
            row_bomb_down = GamePanel.MAX_SCREEN_ROW - 1;
        }
        int CollisionUp = gamePanel.object.mapObjectNum[row_bomb_up][(bomb.bombX) / GamePanel.SCALED_SIZE];
        int CollisionDown = gamePanel.object.mapObjectNum[row_bomb_down][(bomb.bombX) / GamePanel.SCALED_SIZE];
        int CollisionLeft = gamePanel.object.mapObjectNum[(bomb.bombY) / GamePanel.SCALED_SIZE][col_bomb_left];
        int CollisionRight = gamePanel.object.mapObjectNum[(bomb.bombY) / GamePanel.SCALED_SIZE][col_bomb_right];
        // va cham tren
        if (CollisionUp == 1) {
            bomb.collisionWallUp = true;
        }
        if (CollisionUp <= 4 && CollisionUp > 1) {
            bomb.collisionBrickUp = true;
        }
        // va cham duoi
        if (CollisionDown == 1) {
            bomb.collisionWallDown = true;
        }
        if (CollisionDown <= 4 && CollisionDown > 1) {
            bomb.collisionBrickDown = true;
        }
        // va cham trai
        if (CollisionLeft == 1) {
            bomb.collisionWallLeft = true;
        }
        if (CollisionLeft <= 4 && CollisionLeft > 1) {
            bomb.collisionBrickLeft = true;
        }
        // va cham phai
        if (CollisionRight == 1) {
            bomb.collisionWallRight = true;
        }
        if (CollisionRight <= 4 && CollisionRight > 1) {
            bomb.collisionBrickRight = true;
        }
    }
    public void checkDie(Bomber bomber, Bomb bomb){
        int entityLeftWorldX = bomber.x + bomber.solidArea.x;
        int entityRightWorldX = bomber.x + bomber.solidArea.x + bomber.solidArea.width;
        int entityTopWorldY = bomber.y + bomber.solidArea.y;
        int entityBotWorldY = bomber.y + bomber.solidArea.y + bomber.solidArea.height;

        int entityLeftCol = entityLeftWorldX / GamePanel.SCALED_SIZE;
        int entityRightCol = entityRightWorldX / GamePanel.SCALED_SIZE;
        int entityTopRow = entityTopWorldY / GamePanel.SCALED_SIZE;
        int entityBotRow = entityBotWorldY / GamePanel.SCALED_SIZE;

        for(int i = 0; i <= bomb.sizeBomb; i++){
            //up
            if((bomb.bombY / GamePanel.SCALED_SIZE) == entityTopRow ){
                if((bomb.bombX + i * GamePanel.SCALED_SIZE)/48 == entityLeftCol || (bomb.bombX - i * GamePanel.SCALED_SIZE)/48 == entityRightCol ){
                    bomber.checkDie = true;
                    System.out.println("Die Up");
                }
            }
            //down
            if((bomb.bombY / GamePanel.SCALED_SIZE) == entityBotRow ){
                if((bomb.bombX + i * GamePanel.SCALED_SIZE)/48 == entityLeftCol || (bomb.bombX - i * GamePanel.SCALED_SIZE)/48 == entityRightCol ){
                    bomber.checkDie = true;
                    System.out.println("Die Down");
                }
            }
            // left
            if((bomb.bombX / GamePanel.SCALED_SIZE) == entityLeftCol ){
                if((bomb.bombY - i * GamePanel.SCALED_SIZE)/48 == entityBotRow || (bomb.bombX + i * GamePanel.SCALED_SIZE)/48 == entityTopRow){
                    bomber.checkDie = true;
                    System.out.println("Die left");
                }
            }
            //right
            if((bomb.bombX / GamePanel.SCALED_SIZE) == entityRightCol ){
                if((bomb.bombY - i * GamePanel.SCALED_SIZE)/48 == entityBotRow || (bomb.bombX + i * GamePanel.SCALED_SIZE)/48 == entityTopRow){
                    bomber.checkDie = true;
                    System.out.println("Die right");
                }
            }
        }

    }
}

