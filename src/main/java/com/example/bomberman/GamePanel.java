package com.example.bomberman;

import com.example.bomberman.Entities.*;
import com.example.bomberman.Entities.Object;
import com.example.bomberman.Menu.MenuUI;
import com.example.bomberman.input.Keyboard;
import com.example.bomberman.input.Mouse;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {
    public static final int DEFAULT_SIZE = 16;//16x16tile
    public static final int SCALE = 3;
    public static final int SCALED_SIZE = DEFAULT_SIZE * SCALE;// 48x48tile
    public static final int MAX_SCREEN_COL = 16;
    public static final int MAX_SCREEN_ROW = 12;
    public static final int SCREEN_WIDTH = SCALED_SIZE * MAX_SCREEN_COL; // 768 pixel
    public static final int SCREEN_HEIGHT = SCALED_SIZE * MAX_SCREEN_ROW; //576 pixel
    Graphics2D g2;
    double FPS = 60;

    public final double ns = 1000000000.0 / FPS;


    public static int GameState = 0;
    public Thread gameThread;
    Keyboard keyboard = new Keyboard();
    Mouse mouse = new Mouse(this);

    public Bomber bomber = new Bomber(this, keyboard);
    public Bomb bomb = new Bomb(this);
    public Boom boom = new Boom(this,bomber);
    public Balloon balloon = new Balloon(bomber, this, boom);
    public Frog frog=new Frog(bomber, this, boom);
    Object object = new Object(this);
    MenuUI menuUI = new MenuUI(this, mouse);

    public CheckCollision checkCollision = new CheckCollision(this,boom);
    public ArrayList<Boom> boomArrayList = new ArrayList<>();

    public void AddBoom() {
        if (boomArrayList.size() == 0) {
            boomArrayList.add(boom);
        } else {
            Boom boom1 = new Boom(this,bomber);
            boomArrayList.add(boom1);
        }
    }

    public void RemoveBoom() {
        boomArrayList.remove(boomArrayList.size() - 1);
    }

    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyboard);
        this.addMouseListener(mouse);
        this.setFocusable(true);
        AddBoom();
    }

    public void start() {
        gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    public void run() {
        long timer = 0;
        long drawCount = 0;
        long lastTime = System.nanoTime();
        double delta = 0;
        long now;
        while (gameThread != null) {
            now = System.nanoTime();
            delta += (now - lastTime) / ns;
            timer += (now - lastTime);
            lastTime = now;
            while (delta >= 0) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) {
                System.out.println("FPS:" + drawCount);
                System.out.println("BoomList:" + boomArrayList.size());
                System.out.println("PosBoom1x:" + boomArrayList.get(0).x);
                System.out.println("PosBoom1y:" + boomArrayList.get(0).y);
//                System.out.println("x:"+boomArrayList.get(0).bomX);
//                System.out.println("y:"+boomArrayList.get(0).bomY);
                if (boomArrayList.size() >= 2) {
                    for (int i = 1; i < boomArrayList.size(); i++) {
                        System.out.println("PosBoom" + (i + 1) + "x:" + boomArrayList.get(i).x);
                        System.out.println("PosBoom" + (i + 1) + "y:" + boomArrayList.get(i).y);
                    }
                }

                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        bomber.update(object, boom);
        balloon.update(object);
        frog.update(object);

        // bomber.update(object, boomArrayList.get(j));
        for (int j = 0; j < boomArrayList.size(); j++) {
            boomArrayList.get(j).update(bomber);
        }

//        }
        menuUI.update();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (GamePanel.GameState == 0) {
            object.render(g2);
            bomber.render(g2,"Bomber");
            balloon.render(g2,"Balloon");
            frog.render(g2,"Frog");
            for (int i = 0; i < boomArrayList.size(); i++) {
                boomArrayList.get(i).render(g2,"boom");
            }

        }
        if (GamePanel.GameState == 1) {
            menuUI.render(g2);
        }
        if (GameState == 3) {
            gameThread = null;
            System.exit(1);
        }
        g2.dispose();
    }
}


