package com.tryboy.tank;

import java.awt.*;

public class Bullet {
    private static final int SPEED = 5;
    private static final int WIDTH=5, HEIGHT = 5;
    private int x,y;
    private Dir dir;
    private boolean moving = true;


    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x,y,WIDTH,HEIGHT);
        g.setColor(c);

        move();
    }

    private void move() {
        if(!moving) return;

        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case Up:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
    }
}
