package com.example.bomberman.Menu;

import com.example.bomberman.GamePanel;
import com.example.bomberman.input.Keyboard;
import com.example.bomberman.input.Mouse;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Menu extends JPanel implements Runnable{
    public static final int DEFAULT_SIZE = 16;//16x16tile
    public static final int SCALE = 3;
    public static final int SCALED_SIZE = DEFAULT_SIZE * SCALE;// 48x48tile
    public static final int MAX_SCREEN_COL = 16;
    public static final int MAX_SCREEN_ROW = 12;
    public static final int SCREEN_WIDTH = SCALED_SIZE * MAX_SCREEN_COL; // 768 pixel
    public static final int SCREEN_HEIGHT = SCALED_SIZE * MAX_SCREEN_ROW; //576 pixel
    MenuOption menuOption1=new MenuOption("START",1);
    MenuOption menuOption2=new MenuOption("OPTION",2);
    MenuOption menuOption3=new MenuOption("EXIT",3);
    Thread gameThread;
    Keyboard keyboard = new Keyboard();
    Mouse mouse=new Mouse();
    MenuBackground menuBackground=new MenuBackground();

    public Menu(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyboard);
        this.setFocusable(true);

    }
    public void start() {
        gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    public void run(){
        while (gameThread!=null){
            repaint();
        }

    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        menuBackground.renderMenuBackGround(g2);
        menuOption1.render(g2);
        menuOption2.render(g2);
        menuOption3.render(g2);
        g2.dispose();
    }

    MouseListener mouseListener=new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("CLICKED");
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    };
}
