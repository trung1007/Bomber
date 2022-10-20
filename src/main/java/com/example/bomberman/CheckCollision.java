package com.example.bomberman;

import com.example.bomberman.Entities.Bomb;
import com.example.bomberman.Entities.Bomber;
import com.example.bomberman.Entities.Boom;

import java.util.Random;

public class CheckCollision {
    GamePanel gamePanel;

    int[] RandomItem = {0, 0, 0, 0, 0, 0, 0, 5, 6, 7};

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

    public int RandomNumOfObject(int[] Num) {
        Random random = new Random();
        return Num[random.nextInt(Num.length - 1)];
    }
    public void checkFlameBomb(Boom boom, int countTime, int timeExploring) {
        if(countTime <= timeExploring){
            if(boom.frameUp < boom.sizeBomb){
                if(gamePanel.object.mapObjectNum[boom.y/48 - boom.frameUp -1][boom.x/48] == 2){
                    gamePanel.object.mapObjectNum[boom.y/48 - boom.frameUp -1][boom.x/48] = 3;
                }
            }
            if(boom.frameDown < boom.sizeBomb){
                if(gamePanel.object.mapObjectNum[boom.y/48 + boom.frameDown +1][boom.x/48] == 2){
                    gamePanel.object.mapObjectNum[boom.y/48 + boom.frameDown +1][boom.x/48] = 3;
                }
            }
            if(boom.frameLeft < boom.sizeBomb){
                if(gamePanel.object.mapObjectNum[boom.y/48 ][boom.x/48 - boom.frameLeft - 1] == 2){
                    gamePanel.object.mapObjectNum[boom.y/48 ][boom.x/48 - boom.frameLeft - 1] = 3;
                }
            }
            if(boom.frameRight < boom.sizeBomb){
                if(gamePanel.object.mapObjectNum[boom.y/48 ][boom.x/48 + boom.frameRight +1] == 2){
                    gamePanel.object.mapObjectNum[boom.y/48 ][boom.x/48 + boom.frameRight +1] = 3;
                }
            }
        }else if(countTime <= timeExploring * 2) {
            if(boom.frameUp < boom.sizeBomb) {
                if (gamePanel.object.mapObjectNum[boom.y / 48 - boom.frameUp - 1][boom.x / 48] == 3) {
                    gamePanel.object.mapObjectNum[boom.y / 48 - boom.frameUp - 1][boom.x / 48] = 3;
                }
            }
            if (boom.frameDown < boom.sizeBomb) {
                if (gamePanel.object.mapObjectNum[boom.y / 48 + boom.frameDown + 1][boom.x / 48] == 3) {
                    gamePanel.object.mapObjectNum[boom.y / 48 + boom.frameDown + 1][boom.x / 48] = 3;
                }
            }
            if (boom.frameLeft < boom.sizeBomb) {
                if (gamePanel.object.mapObjectNum[boom.y / 48][boom.x / 48 - boom.frameLeft - 1] == 3) {
                    gamePanel.object.mapObjectNum[boom.y / 48][boom.x / 48 - boom.frameLeft - 1] = 3;
                }
            }
            if (boom.frameRight < boom.sizeBomb) {
                if (gamePanel.object.mapObjectNum[boom.y / 48][boom.x / 48 + boom.frameRight + 1] == 3) {
                    gamePanel.object.mapObjectNum[boom.y / 48][boom.x / 48 + boom.frameRight + 1] = 4;
                }
            }
        } else if(countTime < timeExploring * 3){
            if(boom.frameUp < boom.sizeBomb) {
                if (gamePanel.object.mapObjectNum[boom.y / 48 - boom.frameUp - 1][boom.x / 48] == 3) {
                    gamePanel.object.mapObjectNum[boom.y / 48 - boom.frameUp - 1][boom.x / 48] = 4;
                }
            }
            if (boom.frameDown < boom.sizeBomb) {
                if (gamePanel.object.mapObjectNum[boom.y / 48 + boom.frameDown + 1][boom.x / 48] == 3) {
                    gamePanel.object.mapObjectNum[boom.y / 48 + boom.frameDown + 1][boom.x / 48] = 4;
                }
            }
            if (boom.frameLeft < boom.sizeBomb) {
                if (gamePanel.object.mapObjectNum[boom.y / 48][boom.x / 48 - boom.frameLeft - 1] == 3) {
                    gamePanel.object.mapObjectNum[boom.y / 48][boom.x / 48 - boom.frameLeft - 1] = 4;
                }
            }
            if (boom.frameRight < boom.sizeBomb) {
                if (gamePanel.object.mapObjectNum[boom.y / 48][boom.x / 48 + boom.frameRight + 1] == 3) {
                    gamePanel.object.mapObjectNum[boom.y / 48][boom.x / 48 + boom.frameRight + 1] = 4;
                }
            }
        } else if (countTime == 20 * 3) {
            if(boom.frameUp < boom.sizeBomb) {
                if (gamePanel.object.mapObjectNum[boom.y / 48 - boom.frameUp - 1][boom.x / 48] == 4) {
                    int random = RandomNumOfObject(RandomItem);
                    gamePanel.object.mapObjectNum[boom.y / 48 - boom.frameUp - 1][boom.x / 48] = random;
                }
            }
            if (boom.frameDown < boom.sizeBomb) {
                if (gamePanel.object.mapObjectNum[boom.y / 48 + boom.frameDown + 1][boom.x / 48] == 4) {
                    int random = RandomNumOfObject(RandomItem);
                    gamePanel.object.mapObjectNum[boom.y / 48 + boom.frameDown + 1][boom.x / 48] = random;
                }
            }
            if (boom.frameLeft < boom.sizeBomb) {
                if (gamePanel.object.mapObjectNum[boom.y / 48][boom.x / 48 - boom.frameLeft - 1] == 4) {
                    int random = RandomNumOfObject(RandomItem);
                    gamePanel.object.mapObjectNum[boom.y / 48][boom.x / 48 - boom.frameLeft - 1] = random;
                }
            }
            if (boom.frameRight < boom.sizeBomb) {
                if (gamePanel.object.mapObjectNum[boom.y / 48][boom.x / 48 + boom.frameRight + 1] == 4) {
                    int random = RandomNumOfObject(RandomItem);
                    gamePanel.object.mapObjectNum[boom.y / 48][boom.x / 48 + boom.frameRight + 1] = random;
                }
            }
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
            if((bomb.bombY / GamePanel.SCALED_SIZE) == entityTopRow){
                if((bomb.bombX + i * GamePanel.SCALED_SIZE)/48 == entityLeftCol || (bomb.bombX - i * GamePanel.SCALED_SIZE)/48 == entityRightCol ){
                    bomber.checkDie = true;
                    System.out.println("Die Up");
                }
            }
            //down
            if((bomb.bombY / GamePanel.SCALED_SIZE) == entityBotRow){
                if((bomb.bombX + i * GamePanel.SCALED_SIZE)/48 == entityLeftCol || (bomb.bombX - i * GamePanel.SCALED_SIZE)/48 == entityRightCol ){
                    bomber.checkDie = true;
                    System.out.println("Die Down");
                }
            }
            // left
            if((bomb.bombX / GamePanel.SCALED_SIZE) == entityLeftCol){


                if((bomb.bombY - i * GamePanel.SCALED_SIZE)/48 == entityBotRow || (bomb.bombY + i * GamePanel.SCALED_SIZE)/48 == entityTopRow){
                    bomber.checkDie = true;
                    System.out.println("Die left");
                }
            }
            //right
            if((bomb.bombX / GamePanel.SCALED_SIZE) == entityRightCol ){
                if((bomb.bombY - i * GamePanel.SCALED_SIZE)/48 == entityBotRow || (bomb.bombY + i * GamePanel.SCALED_SIZE)/48 == entityTopRow){
                    bomber.checkDie = true;
                    System.out.println("Die right");
                }
            }
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
                if((bomb.bombY - i * GamePanel.SCALED_SIZE)/48 == entityBotRow || (bomb.bombY + i * GamePanel.SCALED_SIZE)/48 == entityTopRow){
                    bomber.checkDie = true;
                    System.out.println("Die left");
                }
            }
            //right
            if((bomb.bombX / GamePanel.SCALED_SIZE) == entityRightCol ){
                if((bomb.bombY - i * GamePanel.SCALED_SIZE)/48 == entityBotRow || (bomb.bombY + i * GamePanel.SCALED_SIZE)/48 == entityTopRow){
                    bomber.checkDie = true;
                    System.out.println("Die right");
                }
            }
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
                if((bomb.bombY - i * GamePanel.SCALED_SIZE)/48 == entityBotRow || (bomb.bombY + i * GamePanel.SCALED_SIZE)/48 == entityTopRow){
                    bomber.checkDie = true;
                    System.out.println("Die left");
                }
            }
            //right
            if((bomb.bombX / GamePanel.SCALED_SIZE) == entityRightCol ){
                if((bomb.bombY - i * GamePanel.SCALED_SIZE)/48 == entityBotRow || (bomb.bombY + i * GamePanel.SCALED_SIZE)/48 == entityTopRow){
                    bomber.checkDie = true;
                    System.out.println("Die right");
                }
            }
        }

    }
}

