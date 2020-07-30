package com.tryboy.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.ArrayList;

public class TankFrame extends Frame {
    // 主坦克
    Tank myTank = new Tank(200, 200, Dir.DOWN, this);
    // 主坦克子弹容器
    List<Bullet> bullets = new ArrayList<>();
//    // 主坦克子弹
//    Bullet b = new Bullet(300, 300, Dir.DOWN);

    // 窗口长宽
    static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;

    public TankFrame() {
        // 设置窗口大小
        setSize(800, 600);

        // 设置自适应窗口
        setResizable(false);

        // 设置标题
        setTitle("tank war");

        // 窗口显示
        setVisible(true);

        // 键盘监听
        addKeyListener(new MykeyListener());

        // 监听窗口
        // WindowAdapter 是 WindowListener 的子类
        addWindowListener(new WindowAdapter() {
            // 实现窗口关闭
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // 双缓冲 -- 图片先在内存画好,在由内存复制到显存
    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if(offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
       Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0,0,GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    // 窗口绘制（包括创建，更改）时调用
    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹数量:"+bullets.size(),10,60);
        g.setColor(c);

        myTank.paint(g);

        // for-each 无法删除容器 - 锁
//        for (Bullet b : bullets) {
//            b.paint(g);
//        }

        // 普通循环可以删除容器
        for (int i=0; i<bullets.size(); i++) {
            bullets.get(i).paint(g);
        }
    }

    // 键盘监听事件处理实例类
    class MykeyListener extends KeyAdapter {

        // 键盘按压布尔值
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        // 键位弹起效果
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                    break;
                default:
                    break;
            }

            // 设置主坦克方向
            setMainTankDir();
        }

        // 键位按压处理
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }

            // 设置主坦克方向
            setMainTankDir();
        }

        // 设置坦克方向
        private void setMainTankDir() {
            if(!bL && !bU && !bR && !bD) myTank.setMoving(false);
            else
            myTank.setMoving(true);
            if(bL) myTank.setDir(Dir.LEFT);
            if(bU) myTank.setDir(Dir.Up);
            if(bR) myTank.setDir(Dir.RIGHT);
            if(bD) myTank.setDir(Dir.DOWN);

        }
    }
}
