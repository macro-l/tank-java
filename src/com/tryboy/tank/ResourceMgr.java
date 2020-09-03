package com.tryboy.tank;

import jdk.jfr.consumer.RecordedClass;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    public static BufferedImage tankL, tankR, tankU, tankD;
    public static BufferedImage bulletL, bulletR, bulletU, bulletD;
    // 爆炸
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {
            // 坦克皮肤
            tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/tankL.gif"));
            tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/tankR.gif"));
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/tankU.gif"));
            tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/tankD.gif"));

            // 子弹皮肤
            bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/bulletL.gif"));
            bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/bulletR.gif"));
            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/bulletU.gif"));
            bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/bulletD.gif"));

            // 爆炸特效
            for (int i=0; i<16; i++) {
                explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("img/e"+(i+1)+".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
