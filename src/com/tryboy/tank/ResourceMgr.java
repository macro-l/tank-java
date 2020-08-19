package com.tryboy.tank;

import jdk.jfr.consumer.RecordedClass;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    public static BufferedImage tankL, tankR, tankU, tankD;

    static {
        try {
            tankL = ImageIO.read(RecordedClass.class.getClassLoader().getResourceAsStream("img/tankL.git"));
            tankR = ImageIO.read(RecordedClass.class.getClassLoader().getResourceAsStream("img/tankR.git"));
            tankU = ImageIO.read(RecordedClass.class.getClassLoader().getResourceAsStream("img/tankU.git"));
            tankD = ImageIO.read(RecordedClass.class.getClassLoader().getResourceAsStream("img/tankD.git"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
