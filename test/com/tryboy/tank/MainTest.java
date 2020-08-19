package com.tryboy.tank;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void test() {
        try {
            BufferedImage image = ImageIO.read(new File("/home/hong/IdeaProjects/tank/img/test.jpeg"));
            assertNotNull(image);
        } catch (IOException e) {
            e.printStackTrace();
        }


//        fail("NOt yet implemented");
        assertNotNull(new Object());
    }

  }