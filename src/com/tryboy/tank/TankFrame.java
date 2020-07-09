package com.tryboy.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    int x = 200, y = 200;

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
        // 测试调用
//        System.out.println("paint");
        // 填充矩形
        g.fillRect(x, y, 100, 100);
        x += 10;
        y += 10;
    }

    // 键盘监听事件处理实例类
    class MykeyListener extends KeyAdapter {

        // 键位弹起效果
        @Override
        public void keyReleased(KeyEvent e) {
//            x += 20;
//            repaint();
        }

        // 键位按压处理
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("key pressed");
        }
    }
}
