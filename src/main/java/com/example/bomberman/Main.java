package com.example.bomberman;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

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

//                JFrame Window = new JFrame();
//                Window.setTitle("Bomberman");
//                Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                Window.setResizable(false);
//
//                Menu menu=new Menu();
//                Window.add(menu);
//                Window.pack();
//                Window.setLocationRelativeTo(null);
//                Window.setVisible(true);
//                menu.start();


    }

}