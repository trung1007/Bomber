package com.example.bomberman;

import com.example.bomberman.Entities.Entity;

public class CheckCollision {
    GamePanel gamePanel;
    public CheckCollision(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    public void checkTile(Entity entity){
        int entityLeftWorldX = entity.bomberX+ entity.solidArea.x;
        int entityRightWorldX = entity.bomberX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.bomberY + entity.solidArea.y;
        int entityBotWorldY = entity.bomberY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX/ gamePanel.SCALED_SIZE;
        int entityRightCol = entityRightWorldX /gamePanel.SCALED_SIZE;
        int entityTopRow = entityTopWorldY/gamePanel.SCALED_SIZE;
        int entityBotRow = entityBotWorldY/gamePanel.SCALED_SIZE;

        int tileNum1, tileNum2;
        switch (entity.direction){
            case "UP":
                entityTopRow = (entityTopWorldY - entity.speed)/ gamePanel.SCALED_SIZE;
                tileNum1 = gamePanel.tile.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gamePanel.tile.mapTileNum[entityRightCol][entityTopRow];
                if(gamePanel.tile.collision[tileNum1] == true || gamePanel.tile.collision[tileNum2] == true){
                    entity.collisionOn = true;
                }
                break;
            case "DOWN":
                entityBotRow = (entityBotWorldY + entity.speed)/ gamePanel.SCALED_SIZE;
                tileNum1 = gamePanel.tile.mapTileNum[entityLeftCol][entityBotRow];
                tileNum2 = gamePanel.tile.mapTileNum[entityRightCol][entityBotRow];
                if(gamePanel.tile.collision[tileNum1] == true || gamePanel.tile.collision[tileNum2] == true){
                    entity.collisionOn = true;
                }
                break;
            case "LEFT" :
                entityLeftCol = (entityLeftWorldX - entity.speed)/ gamePanel.SCALED_SIZE;
                tileNum1 = gamePanel.tile.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gamePanel.tile.mapTileNum[entityLeftCol][entityBotRow];
                if(gamePanel.tile.collision[tileNum1] == true || gamePanel.tile.collision[tileNum2] == true){
                    entity.collisionOn = true;
                }
                break;
            case "RIGHT":
                entityRightCol = (entityRightWorldX+ entity.speed)/ gamePanel.SCALED_SIZE;
                tileNum1 = gamePanel.tile.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gamePanel.tile.mapTileNum[entityRightCol][entityBotRow];
                if(gamePanel.tile.collision[tileNum1] == true || gamePanel.tile.collision[tileNum2] == true){
                    entity.collisionOn = true;
                }
                break;
        }
    }
}
