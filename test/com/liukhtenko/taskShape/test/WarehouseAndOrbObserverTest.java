package com.liukhtenko.taskShape.test;

import com.liukhtenko.taskShape.entity.Orb;
import com.liukhtenko.taskShape.entity.Point;
import com.liukhtenko.taskShape.observer.OrbObserver;
import com.liukhtenko.taskShape.warehouse.Warehouse;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WarehouseAndOrbObserverTest {
    private Warehouse warehouse = Warehouse.getInstance();
    private OrbObserver orbObserver;
    private Orb orb1;

    @BeforeClass
    public void setup() {
        orb1 = new Orb(301, new Point(1, 3, 5), 4);
        orbObserver = new OrbObserver();
    }

    @AfterClass
    public void tearDown() {
        orb1 = null;
        orbObserver = null;
    }

    @Test
    public void actionPerformedTestTrue() {
        orb1.addObserver(orbObserver);
        orb1.setRadius(42);
        int expected = 1;
        int actual = warehouse.getMap().size();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void actionPerformedTestFalse() {
        orb1.setRadius(52);
        int expected = 1;
        int actual = warehouse.getMap().size();
        Assert.assertNotEquals(actual, expected);
    }

    @Test
    public void remove() {
        orb1.addObserver(orbObserver);
        orb1.setRadius(52);
        int expected = 0;
        warehouse.remove(301);
        int actual = warehouse.getMap().size();
        Assert.assertEquals(actual, expected);
    }
}
