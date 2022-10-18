package com.example.bomberman;

import com.example.bomberman.Entities.*;
import com.example.bomberman.Entities.Object;
import com.example.bomberman.input.Keyboard;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    public static final int DEFAULT_SIZE = 16;//16x16tile
    public static final int SCALE = 3;
    public static final int SCALED_SIZE = DEFAULT_SIZE * SCALE;// 48x48tile
    public static final int MAX_SCREEN_COL = 16;
    public static final int MAX_SCREEN_ROW = 12;
    public static final int SCREEN_WIDTH = SCALED_SIZE * MAX_SCREEN_COL; // 768 pixel
    public static final int SCREEN_HEIGHT = SCALED_SIZE * MAX_SCREEN_ROW; //576 pixel
    int FPS = 60;
    public long lastTime = System.nanoTime();
    public final double ns = 1000000000.0 / FPS;
    public double delta = 0;
    public double delta1 = 0;
    Thread gameThread;
    Keyboard keyboard = new Keyboard();

    public Bomber bomber = new Bomber(this, keyboard);
    public Bomb bomb = new Bomb(this, keyboard);
    public Balloon balloon = new Balloon(this);
    Object object = new Object(this);

    public CheckCollision checkCollision = new CheckCollision(this);

    public GamePanel() {
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
    public void run() {
        long timer = 0;
        long drawCount = 0;

        while (gameThread != null) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            delta1 += (now - lastTime) / ns;
            timer += (now - lastTime);
            lastTime = now;
            while (delta >= 0) {

                update();
                repaint();
                delta--;

                drawCount++;
            }
            if (timer >= 1000000000) {
//                System.out.println(drawCount);
                drawCount = 0;
                timer = 0;
            }

        }
    }

    public void update() {
        bomber.update(object, bomb);
        //bomb_caoTrung.update(bomber);
        bomb.update(bomber);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        object.render(g2);
        bomber.render(g2);
        //bomb_caoTrung.render(g2);
        bomb.render(g2,object);
        g2.dispose();
    }
}


