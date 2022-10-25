package com.example.bomberman.input;

import com.example.bomberman.GamePanel;
import com.example.bomberman.Menu.MenuOption;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class Mouse implements MouseListener {
    GamePanel gp;

    public Mouse(GamePanel gamePanel) {
        this.gp = gamePanel;
    }
    public void HelpWindow(){
        JFrame frameHelp=new JFrame("Help!");
        try {
            frameHelp.setContentPane(new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/sprites/game_over.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        frameHelp.setLocationRelativeTo(null);
        frameHelp.setLocation(300,100);
        frameHelp.pack();
        frameHelp.setVisible(true);
    }
    public void GameOverWindow(){
        JFrame frameExit=new JFrame("Exit!");
        try {
            frameExit.setContentPane(new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/sprites/game_over.png")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        frameExit.setResizable(true);
        frameExit.setLocation(300,100);
        frameExit.pack();
        frameExit.setVisible(true);
        frameExit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
                    //GamePanel.GameState = 2;
                    HelpWindow();
                }

            }
            if (mx >= 96 && mx <= 96 + 196) {
                if (my >= 192 + 96 && my <= 192 + 48 + 96) {
                    System.out.println("CLICKED");
                    //ExitWindow();
                    GamePanel.GameState=3;
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

                    MenuOption.setColorNum = 2;
                }
            }
            if (mx >= 96 && mx <= 96 + 196) {
                if (my >= 192 + 48 && my <= 192 + 48 + 48) {
                    System.out.println("Entered");
                    MenuOption.setColorNum = 2;
                }

            }
            if (mx >= 96 && mx <= 96 + 196) {
                if (my >= 192 + 96 && my <= 192 + 48 + 96) {
                    System.out.println("Entered");
                    MenuOption.setColorNum = 2;
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
                    MenuOption.setColorNum = 1;
                }
            }
            if (mx < 96 || mx > 96 + 196) {
                if (my < 192 + 48 || my > 192 + 48 + 48) {
                    System.out.println("Exited");
                    MenuOption.setColorNum = 1;
                }

            }
            if (mx < 96 || mx > 96 + 196) {
                if (my < 192 + 96 || my > 192 + 48 + 96) {
                    System.out.println("Exited");
                    MenuOption.setColorNum = 1;
                }

            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        int mx = e.getX();
//        int my = e.getY();
//        if (GamePanel.GameState == 1) {
//            if (mx >= 96 && mx <= 96 + 196) {
//                if (my >= 192 && my <= 192 + 48) {
//                    System.out.println("Entered");
//                    MenuOption.setColorNumOfPlay = 2;
//                }
//            }
//            if (mx >= 96 && mx <= 96 + 196) {
//                if (my >= 192 + 48 && my <= 192 + 48 + 48) {
//                    System.out.println("Entered");
//                    MenuOption.setColorNumOfPlay = 3;
//                }
//
//            }
//            if (mx >= 96 && mx <= 96 + 196) {
//                if (my >= 192 + 96 && my <= 192 + 48 + 96) {
//                    System.out.println("Entered");
//                    MenuOption.setColorNumOfPlay = 4;
//                }
//
//            }
//        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        int mx = e.getX();
//        int my = e.getY();
//        if (GamePanel.GameState == 1) {
//            if (mx < 96 || mx > 96 + 196) {
//                if (my < 192 || my > 192 + 48) {
//                    System.out.println("Exited");
//                    MenuOption.setColorNumOfPlay = 1;
//                }
//            }
//            if (mx < 96 || mx > 96 + 196) {
//                if (my < 192 + 48 || my > 192 + 48 + 48) {
//                    System.out.println("Exited");
//                    MenuOption.setColorNumOfPlay = 1;
//                }
//
//            }
//            if (mx < 96 || mx > 96 + 196) {
//                if (my < 192 + 96 || my > 192 + 48 + 96) {
//                    System.out.println("Exited");
//                    MenuOption.setColorNumOfPlay = 1;
//                }
//
//            }
//        }
    }
}
