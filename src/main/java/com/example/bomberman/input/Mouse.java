package com.example.bomberman.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener {
    public boolean[]mouse=new boolean[100];
    public boolean clicked,pressed,released,entered,exited;
    public void update(){
        clicked=mouse[MouseEvent.MOUSE_CLICKED];
        pressed=mouse[MouseEvent.MOUSE_PRESSED];
        released=mouse[MouseEvent.MOUSE_RELEASED];
        entered=mouse[MouseEvent.MOUSE_ENTERED];
        exited=mouse[MouseEvent.MOUSE_EXITED];
    }
    @Override
    public void mouseClicked(MouseEvent e) {

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
}
