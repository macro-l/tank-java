package com.tryboy.tank;

import java.awt.*;
import java.util.Random;

public class Tank {
    // 坦克初始化位置
    private int x, y;
    // 坦克初始化方向
    private  Dir dir;
    // 坦克初始化速度
    private static final int SPEED = 5;
    // 坦克初始大小
    final static int w = ResourceMgr.tankD.getWidth(), h = ResourceMgr.tankD.getHeight();
    // 坦克移动状态
    private boolean moving = true;
    // 坦克存活
    private boolean living = true;
    // 随机数
    private Random random = new Random();
    // 阵营
    private Group group = Group.BAD;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    // 坦克架子
    private TankFrame tf = null;

    // 坦克构造初始化
    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    // 坦克绘制
    public void paint(Graphics g) {
        // 坦克颜色
//        Color c = g.getColor();
//        g.setColor(Color.YELLOW);
//        // 填充矩形
//        g.fillRect(x, y, w, h);

        if(!living) {
            tf.tanks.remove(this);
        }

        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.tankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD, x, y, null);
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

        if (random.nextInt(10)>5) this.fire();
    }

    public void fire() {
        int bX = this.x + Tank.w/2 - Bullet.WIDTH/2;
        int bY = this.y + Tank.h/2 - Bullet.HEIGHT/6;
        tf.bullets.add(new Bullet(bX, bY, this.dir, this.group, this.tf));
    }

    public void die() {
        this.living = false;
    }
}
