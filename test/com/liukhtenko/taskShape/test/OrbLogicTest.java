package com.liukhtenko.taskShape.test;

import com.liukhtenko.taskShape.entity.Orb;
import com.liukhtenko.taskShape.entity.Point;
import com.liukhtenko.taskShape.logic.OrbLogic;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrbLogicTest {
    private OrbLogic orbLogic;
    private Orb orb;

    @BeforeClass
    public void setup() {
        orbLogic = new OrbLogic();
        orb = new Orb(231, new Point(1, 3, 4), 3);
    }

    @AfterClass
    public void tearDown() {
        orbLogic = null;
        orb = null;
    }

    @Test
    public void areaSurfaceTest() {
        double expected = 113.097;
        double actual = orbLogic.areaSurface(orb);
        Assert.assertEquals(expected, actual, 0.1);
    }

    @Test
    public void volumeTest() {
        double expected = 84.82;
        double actual = orbLogic.volume(orb);
        Assert.assertEquals(expected, actual, 0.1);
    }

    @Test
    public void isTouchOXYZTest() {
        Assert.assertTrue(orbLogic.isTouchOXYZ(orb));
    }

    @Test
    public void volumeRatioByOXTest() {
        double expected = 0.35;
        double actual = orbLogic.volumeRatioByOX(orb);
        Assert.assertEquals(expected, actual, 0.1);
    }

    @Test
    public void volumeRatioByOYTest() {
        double expected = 0.0;
        double actual = orbLogic.volumeRatioByOY(orb);
        Assert.assertEquals(expected, actual, 0.1);
    }

    @Test
    public void volumeRatioByOZTest() {
        double expected = 0.0;
        double actual = orbLogic.volumeRatioByOZ(orb);
        Assert.assertEquals(expected, actual, 0.1);
    }
}
