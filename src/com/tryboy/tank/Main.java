package com.tryboy.tank;

public class Main {
    public static void main(String[] args) {
        TankFrame tf = new TankFrame();

    }

}

/**
 * V.1版本
 */
/*
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class T {
    public static void main(String[] args) {
        // 实例窗口类
        Frame f = new Frame();

        // 设置窗口大小
        f.setSize(800, 600);

        // 设置自适应窗口
        f.setResizable(false);

        // 设置标题
        f.setTitle("tank war");

        // 窗口显示
        f.setVisible(true);

        // 监听窗口
        // WindowAdapter 是 WindowListener 的子类
        f.addWindowListener(new WindowAdapter() {
            // 实现窗口关闭
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }


        });
    }
}
*/