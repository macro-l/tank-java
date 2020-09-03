package com.tryboy.tank;

import java.awt.*;

public class Explode {
    // 子弹的宽高
    public static int WIDTH=ResourceMgr.explodes[0].getWidth(), HEIGHT = ResourceMgr.explodes[0].getHeight();
    private int x,y;
    private TankFrame tf = null;

    private boolean live = true;

    // 绘画步骤
    private int step = 0;


    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++],x,y,null);
        if(step >= ResourceMgr.explodes.length)
            step = 0;
    }

    private void die() {
        this.live = false;
    }
}
