package com.liukhtenko.taskShape.test;

import com.liukhtenko.taskShape.entity.Orb;
import com.liukhtenko.taskShape.entity.Point;
import com.liukhtenko.taskShape.validator.OrbValidator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrbValidatorTest {
    private OrbValidator orbValidator;

    @BeforeClass
    public void setup() {
        orbValidator = new OrbValidator();
    }

    @AfterClass
    public void tearDown() {
        orbValidator = null;
    }

    @Test
    public void isLineValidTrue() {
        Assert.assertTrue(orbValidator.isLineValid("175325 3.0 6.0 -2.0 5.0"));
    }

    @Test
    public void isLineValidFalse() {
        Assert.assertFalse(orbValidator.isLineValid("175df325 3.0 6.0 -2.0 5.0"));
    }

    @Test
    public void isSqureValidTrue() {
        Assert.assertTrue(orbValidator.isSquareValid(12.2));
    }

    @Test
    public void isSqureValidFalse() {
        Assert.assertFalse(orbValidator.isSquareValid(-1.0));
    }

    @Test
    public void isVolumeValidTrue() {
        Assert.assertTrue(orbValidator.isVolumeValid(12.2));
    }

    @Test
    public void isVolumeValiddFalse() {
        Assert.assertFalse(orbValidator.isVolumeValid(-1.0));
    }

    @Test
    public void isOrbTrue() {
        Orb orb = new Orb();
        Assert.assertTrue(orbValidator.isOrb(orb));
    }

    @Test
    public void isOrbFalse() {
        Point point = new Point();
        Assert.assertFalse(orbValidator.isOrb(point));
    }
}
