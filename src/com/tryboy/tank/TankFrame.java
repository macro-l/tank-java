package com.tryboy.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    //坦克初始大小
    final static int w = 50, h = 50;
    // 初始位置
    int x = 100, y = 100;

    // 初始行进方向
    Dir dir = Dir.DOWN;

    // 初始行进速度
    final static int SPEED = 10;


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

    // 窗口绘制（包括创建，更改）时调用
    @Override
    public void paint(Graphics g) {
        // 填充矩形
        g.fillRect(x, y, w, h);

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

        private void setMainTankDir() {
            if(bL) dir = Dir.LEFT;
            if(bU) dir = Dir.Up;
            if(bR) dir = Dir.RIGHT;
            if(bD) dir = Dir.DOWN;
        }
    }
}
