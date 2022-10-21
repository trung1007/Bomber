package com.example.bomberman;

import com.example.bomberman.Menu.Menu;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        if(GamePanel.GameState==0){
            JFrame Window = new JFrame();
            Window.setTitle("Bomberman");
            Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Window.setResizable(false);


            GamePanel gamePanel = new GamePanel();
            Window.add(gamePanel);

            Window.pack();
            Window.setLocationRelativeTo(null);
            Window.setVisible(true);

            gamePanel.start();
        }
        if(GamePanel.GameState==1){
            JFrame Window = new JFrame();
            Window.setTitle("Bomberman");
            Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Window.setResizable(false);


//            GamePanel gamePanel = new GamePanel();
//            Window.add(gamePanel);
            Menu menu=new Menu();
            Window.add(menu);
            Window.pack();
            Window.setLocationRelativeTo(null);
            Window.setVisible(true);
            menu.start();
            //gamePanel.start();
        }
    }

}