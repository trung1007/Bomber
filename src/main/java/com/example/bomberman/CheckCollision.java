package com.example.bomberman;

import com.example.bomberman.Entities.Boom;
import com.example.bomberman.Entities.Enemies;
import com.example.bomberman.Entities.Entity;

import java.util.Random;

public class CheckCollision {
    GamePanel gamePanel;
    Boom boom;
    int[] RandomItem = {0, 0, 0, 0, 0, 0, 0, 5, 6, 7};

    public CheckCollision(GamePanel gamePanel,Boom boom) {
        this.gamePanel = gamePanel;
        this.boom = boom;
    }
    public int RandomNumOfObject(int[] Num) {
        Random random = new Random();
        return Num[random.nextInt(Num.length - 1)];
    }

    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.x + entity.solidArea.x;
        int entityRightWorldX = entity.x + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.y + entity.solidArea.y;
        int entityBotWorldY = entity.y + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / GamePanel.SCALED_SIZE;
        int entityRightCol = entityRightWorldX / GamePanel.SCALED_SIZE;
        int entityTopRow = entityTopWorldY / GamePanel.SCALED_SIZE;
        int entityBotRow = entityBotWorldY / GamePanel.SCALED_SIZE;

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
//                System.out.println(entityLeftWorldX);
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


    public void checkFlameBomb(Boom boom, int countTime, int timeExploring) {
        if(countTime <= timeExploring){
            if(boom.frameUp < boom.sizeBoom){
                if(gamePanel.object.mapObjectNum[boom.y/48 - boom.frameUp -1][boom.x/48] == 2){
                    gamePanel.object.mapObjectNum[boom.y/48 - boom.frameUp -1][boom.x/48] = 3;
                }
            }
            if(boom.frameDown < boom.sizeBoom){
                if(gamePanel.object.mapObjectNum[boom.y/48 + boom.frameDown +1][boom.x/48] == 2){
                    gamePanel.object.mapObjectNum[boom.y/48 + boom.frameDown +1][boom.x/48] = 3;
                }
            }
            if(boom.frameLeft < boom.sizeBoom){
                if(gamePanel.object.mapObjectNum[boom.y/48 ][boom.x/48 - boom.frameLeft - 1] == 2){
                    gamePanel.object.mapObjectNum[boom.y/48 ][boom.x/48 - boom.frameLeft - 1] = 3;
                }
            }
            if(boom.frameRight < boom.sizeBoom){
                if(gamePanel.object.mapObjectNum[boom.y/48 ][boom.x/48 + boom.frameRight +1] == 2){
                    gamePanel.object.mapObjectNum[boom.y/48 ][boom.x/48 + boom.frameRight +1] = 3;
                }
            }
        }else if(countTime <= timeExploring * 2) {
            if(boom.frameUp < boom.sizeBoom) {
                if (gamePanel.object.mapObjectNum[boom.y / 48 - boom.frameUp - 1][boom.x / 48] == 3) {
                    gamePanel.object.mapObjectNum[boom.y / 48 - boom.frameUp - 1][boom.x / 48] = 3;
                }
            }
            if (boom.frameDown < boom.sizeBoom) {
                if (gamePanel.object.mapObjectNum[boom.y / 48 + boom.frameDown + 1][boom.x / 48] == 3) {
                    gamePanel.object.mapObjectNum[boom.y / 48 + boom.frameDown + 1][boom.x / 48] = 3;
                }
            }
            if (boom.frameLeft < boom.sizeBoom) {
                if (gamePanel.object.mapObjectNum[boom.y / 48][boom.x / 48 - boom.frameLeft - 1] == 3) {
                    gamePanel.object.mapObjectNum[boom.y / 48][boom.x / 48 - boom.frameLeft - 1] = 3;
                }
            }
            if (boom.frameRight < boom.sizeBoom) {
                if (gamePanel.object.mapObjectNum[boom.y / 48][boom.x / 48 + boom.frameRight + 1] == 3) {
                    gamePanel.object.mapObjectNum[boom.y / 48][boom.x / 48 + boom.frameRight + 1] = 4;
                }
            }
        } else if(countTime < timeExploring * 3){
            if(boom.frameUp < boom.sizeBoom) {
                if (gamePanel.object.mapObjectNum[boom.y / 48 - boom.frameUp - 1][boom.x / 48] == 3) {
                    gamePanel.object.mapObjectNum[boom.y / 48 - boom.frameUp - 1][boom.x / 48] = 4;
                }
            }
            if (boom.frameDown < boom.sizeBoom) {
                if (gamePanel.object.mapObjectNum[boom.y / 48 + boom.frameDown + 1][boom.x / 48] == 3) {
                    gamePanel.object.mapObjectNum[boom.y / 48 + boom.frameDown + 1][boom.x / 48] = 4;
                }
            }
            if (boom.frameLeft < boom.sizeBoom) {
                if (gamePanel.object.mapObjectNum[boom.y / 48][boom.x / 48 - boom.frameLeft - 1] == 3) {
                    gamePanel.object.mapObjectNum[boom.y / 48][boom.x / 48 - boom.frameLeft - 1] = 4;
                }
            }
            if (boom.frameRight < boom.sizeBoom) {
                if (gamePanel.object.mapObjectNum[boom.y / 48][boom.x / 48 + boom.frameRight + 1] == 3) {
                    gamePanel.object.mapObjectNum[boom.y / 48][boom.x / 48 + boom.frameRight + 1] = 4;
                }
            }
        } else if (countTime == 20 * 3) {
            if(boom.frameUp < boom.sizeBoom) {
                if (gamePanel.object.mapObjectNum[boom.y / 48 - boom.frameUp - 1][boom.x / 48] == 4) {
                    int random = RandomNumOfObject(RandomItem);
                    gamePanel.object.mapObjectNum[boom.y / 48 - boom.frameUp - 1][boom.x / 48] = random;
                }
            }
            if (boom.frameDown < boom.sizeBoom) {
                if (gamePanel.object.mapObjectNum[boom.y / 48 + boom.frameDown + 1][boom.x / 48] == 4) {
                    int random = RandomNumOfObject(RandomItem);
                    gamePanel.object.mapObjectNum[boom.y / 48 + boom.frameDown + 1][boom.x / 48] = random;
                }
            }
            if (boom.frameLeft < boom.sizeBoom) {
                if (gamePanel.object.mapObjectNum[boom.y / 48][boom.x / 48 - boom.frameLeft - 1] == 4) {
                    int random = RandomNumOfObject(RandomItem);
                    gamePanel.object.mapObjectNum[boom.y / 48][boom.x / 48 - boom.frameLeft - 1] = random;
                }
            }
            if (boom.frameRight < boom.sizeBoom) {
                if (gamePanel.object.mapObjectNum[boom.y / 48][boom.x / 48 + boom.frameRight + 1] == 4) {
                    int random = RandomNumOfObject(RandomItem);
                    gamePanel.object.mapObjectNum[boom.y / 48][boom.x / 48 + boom.frameRight + 1] = random;
                }
            }
        }
    }
    public void checkDie(Entity entity, Boom boom) {
        int entityLeftWorldX = entity.x + entity.solidArea.x;
        int entityRightWorldX = entity.x + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.y + entity.solidArea.y;
        int entityBotWorldY = entity.y + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / GamePanel.SCALED_SIZE;
        int entityRightCol = entityRightWorldX / GamePanel.SCALED_SIZE;
        int entityTopRow = entityTopWorldY / GamePanel.SCALED_SIZE;
        int entityBotRow = entityBotWorldY / GamePanel.SCALED_SIZE;

        //up
        for (int i = 0; i <= boom.frameUp; i++) {
            if (boom.x / GamePanel.SCALED_SIZE == entityRightCol || boom.x / GamePanel.SCALED_SIZE == entityLeftCol) {
                if ((boom.y - i * GamePanel.SCALED_SIZE) / 48 == entityBotRow) {
                    entity.CheckDie = true;
                    System.out.println("Die Up");
                }
            }
        }
        //down
        for (int i = 0; i <= boom.frameDown; i++) {
            if (boom.x / GamePanel.SCALED_SIZE == entityRightCol || boom.x / GamePanel.SCALED_SIZE == entityLeftCol) {
                if ((boom.y + i * GamePanel.SCALED_SIZE) / 48 == entityTopRow) {
                    entity.CheckDie = true;
                    System.out.println("Die Up");
                }
            }
        }
        // left
        for (int i = 0; i <= boom.frameLeft; i++) {
            if (boom.y / GamePanel.SCALED_SIZE == entityTopRow || boom.y / GamePanel.SCALED_SIZE == entityBotRow) {
                if ((boom.x - i * GamePanel.SCALED_SIZE) / 48 == entityRightCol) {
                    entity.CheckDie = true;
                    System.out.println("Die Up");
                }
            }
        }
        //right
        for (int i = 0; i <= boom.frameRight; i++) {
            if (boom.y / GamePanel.SCALED_SIZE == entityTopRow || boom.y / GamePanel.SCALED_SIZE == entityBotRow) {
                if ((boom.x + i * GamePanel.SCALED_SIZE) / 48 == entityLeftCol) {
                    entity.CheckDie = true;
                    System.out.println("Die Up");
                }
            }
        }
    }
    public boolean checkDieEnemy(Entity entity, Enemies enemies) {
        if (entity.x + entity.solidArea.x+entity.solidArea.width >= enemies.x
                && enemies.x + enemies.solidArea.x+enemies.solidArea.width >= entity.x
                && entity.y + entity.solidArea.y+entity.solidArea.height >= enemies.y
                && enemies.y + enemies.solidArea.y+enemies.solidArea.height >= entity.y) {
            entity.CheckDie=true;
        }
        return entity.CheckDie;
    }
}

