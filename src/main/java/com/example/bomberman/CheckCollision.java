package com.example.bomberman;

import com.example.bomberman.Entities.Bomb;
import com.example.bomberman.Entities.Bomber;
import com.example.bomberman.Entities.Entity;

public class CheckCollision {
    GamePanel gamePanel;

    public CheckCollision(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void checkObject(Entity entity) {
        int entityLeftWorldX = entity.bomberX + entity.solidArea.x;
        int entityRightWorldX = entity.bomberX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.bomberY + entity.solidArea.y;
        int entityBotWorldY = entity.bomberY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / gamePanel.SCALED_SIZE;
        int entityRightCol = entityRightWorldX / gamePanel.SCALED_SIZE;
        int entityTopRow = entityTopWorldY / gamePanel.SCALED_SIZE;
        int entityBotRow = entityBotWorldY / gamePanel.SCALED_SIZE;

        int tileNum1, tileNum2;
        switch (entity.direction) {
            case "UP":
                entityTopRow = (entityTopWorldY - entity.speed) / gamePanel.SCALED_SIZE;
                tileNum1 = gamePanel.object.mapObjectNum[entityTopRow][entityLeftCol];
                tileNum2 = gamePanel.object.mapObjectNum[entityTopRow][entityRightCol];
                if (gamePanel.object.collision[tileNum1] == true || gamePanel.object.collision[tileNum2] == true) {
                    entity.collisionOn = true;
                    /*if(tileNum1 >=5){
                        gamePanel.object.mapObjectNum[entityTopRow][entityLeftCol] = 0;
                    }
                    if(tileNum2 >=5){
                        gamePanel.object.mapObjectNum[entityTopRow][entityRightCol] = 0;
                    }*/
                }
                break;
            case "DOWN":
                entityBotRow = (entityBotWorldY + entity.speed) / gamePanel.SCALED_SIZE;
                tileNum1 = gamePanel.object.mapObjectNum[entityBotRow][entityLeftCol];
                tileNum2 = gamePanel.object.mapObjectNum[entityBotRow][entityRightCol];

                if (gamePanel.object.collision[tileNum1] == true || gamePanel.object.collision[tileNum2] == true) {
                    entity.collisionOn = true;
                    /*if(tileNum1 >=5 ){
                        gamePanel.object.mapObjectNum[entityBotRow][entityLeftCol] = 0;
                    }
                    if(tileNum2 >=5){
                        gamePanel.object.mapObjectNum[entityBotRow][entityRightCol] = 0;
                    }*/
                }
                break;
            case "LEFT":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gamePanel.SCALED_SIZE;
                tileNum1 = gamePanel.object.mapObjectNum[entityTopRow][entityLeftCol];
                tileNum2 = gamePanel.object.mapObjectNum[entityBotRow][entityLeftCol];
                if (gamePanel.object.collision[tileNum1] == true || gamePanel.object.collision[tileNum2] == true) {
                    entity.collisionOn = true;
//                    if(tileNum1 >=5 ){
//                        gamePanel.object.mapObjectNum[entityTopRow][entityLeftCol] = 0;
//                    }
//                    if(tileNum2 >=5){
//                        gamePanel.object.mapObjectNum[entityBotRow][entityLeftCol] = 0;
//                    }
                }
                break;
            case "RIGHT":
                entityRightCol = (entityRightWorldX + entity.speed) / gamePanel.SCALED_SIZE;
                tileNum1 = gamePanel.object.mapObjectNum[entityTopRow][entityRightCol];
                tileNum2 = gamePanel.object.mapObjectNum[entityBotRow][entityRightCol];
//                System.out.println("TileNum1 : " + tileNum1);
//                System.out.println("TileNum2 : " + tileNum2);
                if (gamePanel.object.collision[tileNum1] == true || gamePanel.object.collision[tileNum2] == true) {
                    entity.collisionOn = true;
                    /*if(tileNum1 >=5){
                        gamePanel.object.mapObjectNum[entityTopRow][entityRightCol] = 0;

                    }
                    if(tileNum2 >=5){
                        gamePanel.object.mapObjectNum[entityBotRow][entityRightCol] = 0;
                    }*/
                }
                break;
        }
    }


}
