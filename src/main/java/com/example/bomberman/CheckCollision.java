package com.example.bomberman;

import com.example.bomberman.Entities.Entity;

public class CheckCollision {
    GamePanel gamePanel;

    public CheckCollision(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void checkTile(Entity entity) {
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
                }
                break;
            case "DOWN":
                entityBotRow = (entityBotWorldY + entity.speed) / gamePanel.SCALED_SIZE;
                tileNum1 = gamePanel.object.mapObjectNum[entityBotRow][entityLeftCol];
                tileNum2 = gamePanel.object.mapObjectNum[entityBotRow][entityRightCol];

                if (gamePanel.object.collision[tileNum1] == true || gamePanel.object.collision[tileNum2] == true) {
                    entity.collisionOn = true;
                }
                break;
            case "LEFT":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gamePanel.SCALED_SIZE;
                tileNum1 = gamePanel.object.mapObjectNum[entityTopRow][entityLeftCol];
                tileNum2 = gamePanel.object.mapObjectNum[entityBotRow][entityLeftCol];
                System.out.println(entityLeftWorldX);
                if (gamePanel.object.collision[tileNum1] == true || gamePanel.object.collision[tileNum2] == true) {
                    entity.collisionOn = true;
                }
                break;
            case "RIGHT":
                entityRightCol = (entityRightWorldX + entity.speed) / gamePanel.SCALED_SIZE;
                tileNum1 = gamePanel.object.mapObjectNum[entityTopRow][entityRightCol];
                tileNum2 = gamePanel.object.mapObjectNum[entityBotRow][entityRightCol];

                if (gamePanel.object.collision[tileNum1] == true || gamePanel.object.collision[tileNum2] == true) {
                    entity.collisionOn = true;
                }
                break;
        }
    }
  /*  public int checkItem(Entity entity, boolean bomber){
        int index = 999;
        for(int i = 0; i < gamePanel.item.length; i++){
            if(gamePanel.item[i] != null){
                // set entity solid area
                entity.solidArea.x = entity.bomberX + entity.solidArea.x;
                entity.solidArea.y = entity.bomberY + entity.solidArea.y;
                // set item solid area
                gamePanel.item[i].solidArea.x = gamePanel.item[i].itemX + gamePanel.item[i].solidArea.x;
                gamePanel.item[i].solidArea.y = gamePanel.item[i].itemY + gamePanel.item[i].solidArea.y;

                switch (entity.direction){
                    case "UP":
                        entity.solidArea.y = entity.solidArea.y - entity.speed;
                        if(entity.solidArea.intersects(gamePanel.item[i].solidArea)){
                            System.out.println("up collision");
                        }
                        break;
                    case "DOWN":
                        entity.solidArea.y = entity.solidArea.y + entity.speed;
                        if(entity.solidArea.intersects(gamePanel.item[i].solidArea)) {
                            System.out.println("down collision");
                        }
                        break;
                    case "LEFT":
                        entity.solidArea.x = entity.solidArea.x - entity.speed;
                        if(entity.solidArea.intersects(gamePanel.item[i].solidArea)) {
                            System.out.println("left collision");
                        }
                        break;
                    case "RIGHT":
                        entity.solidArea.x = entity.solidArea.x + entity.speed;
                        if(entity.solidArea.intersects(gamePanel.item[i].solidArea)) {
                            System.out.println("right collision");
                        }
                        break;
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gamePanel.item[i].solidArea.x = gamePanel.item[i].solidAreaDefaultX;
                gamePanel.item[i].solidArea.y = gamePanel.item[i].solidAreaDefaultY;
            }
        }

        return index;

    }*/
}
