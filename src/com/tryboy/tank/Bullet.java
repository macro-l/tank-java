package com.tryboy.tank;

import java.awt.*;

public class Bullet {
    private static final int SPEED = 10;
    // 子弹的宽高
    public static int WIDTH=ResourceMgr.bulletD.getWidth(), HEIGHT = ResourceMgr.bulletD.getHeight();
    private int x,y;
    private Dir dir;
    private boolean moving = true;
    private TankFrame tf = null;

    private boolean live = true;

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if(!live) {
            tf.bullets.remove(this);
        }

//        Color c = g.getColor();
//        g.setColor(Color.RED);
//        g.fillOval(x,y,WIDTH,HEIGHT);
//        g.setColor(c);

        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;

        }

        move();
    }

    private void move() {
        if(!moving) return;

        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
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

        if(x<0 || y <0 || x>TankFrame.GAME_WIDTH || y>TankFrame.GAME_HEIGHT) live=false;


    }

    public void collideWith(Tank tank) {
        Rectangle rect1 = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
        Rectangle rect2 = new Rectangle(tank.getX(), tank.getY(), tank.w, tank.h);
        if (rect1.intersects(rect2)) {
            tank.die();
            this.die();
        }
    }

    private void die() {
        this.live = false;
    }
}
