package com.example.bomberman.input;

import com.example.bomberman.GamePanel;
import com.example.bomberman.Menu.MenuOption;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener {
    GamePanel gp;

    public Mouse(GamePanel gamePanel) {
        this.gp = gamePanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        System.out.println(mx);
        System.out.println(my);
        if (GamePanel.GameState == 1) {
            if (mx >= 96 && mx <= 96 + 196) {
                if (my >= 192 && my <= 192 + 48) {
                    System.out.println("CLICKED");
                    GamePanel.GameState = 0;
                }

            }
            if (mx >= 96 && mx <= 96 + 196) {
                if (my >= 192 + 48 && my <= 192 + 48 + 48) {
                    System.out.println("CLICKED");
                    GamePanel.GameState = 0;
                }

            }
            if (mx >= 96 && mx <= 96 + 196) {
                if (my >= 192 + 96 && my <= 192 + 48 + 96) {
                    System.out.println("CLICKED");
                    GamePanel.GameState = 0;
                }

            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (GamePanel.GameState == 1) {
            if (mx >= 96 && mx <= 96 + 196) {
                if (my >= 192 && my <= 192 + 48) {
                    System.out.println("Entered");

                    MenuOption.setColorNumOfPlay = 2;
                }
            }
            if (mx >= 96 && mx <= 96 + 196) {
                if (my >= 192 + 48 && my <= 192 + 48 + 48) {
                    System.out.println("Entered");
                    MenuOption.setColorNumOfPlay = 3;
                }

            }
            if (mx >= 96 && mx <= 96 + 196) {
                if (my >= 192 + 96 && my <= 192 + 48 + 96) {
                    System.out.println("Entered");
                    MenuOption.setColorNumOfPlay = 4;
                }

            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (GamePanel.GameState == 1) {
            if (mx < 96 || mx > 96 + 196) {
                if (my < 192 || my > 192 + 48) {
                    System.out.println("Exited");
                    MenuOption.setColorNumOfPlay = 1;
                }
            }
            if (mx < 96 || mx > 96 + 196) {
                if (my < 192 + 48 || my > 192 + 48 + 48) {
                    System.out.println("Exited");
                    MenuOption.setColorNumOfPlay = 3;
                }

            }
            if (mx < 96 || mx > 96 + 196) {
                if (my < 192 + 96 || my > 192 + 48 + 96) {
                    System.out.println("Exited");
                    MenuOption.setColorNumOfPlay = 4;
                }

            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
