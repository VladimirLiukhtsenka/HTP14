package com.liukhtenko.taskShape.test;

import com.liukhtenko.taskShape.comparator.OrbComparator;
import com.liukhtenko.taskShape.entity.Orb;
import com.liukhtenko.taskShape.entity.Point;
import com.liukhtenko.taskShape.repository.Repository;
import com.liukhtenko.taskShape.specification.OrbSpecificationShowAll;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class RepositoryTest {
    private Repository repository = Repository.getInstance();
    private Orb orb1;
    private Orb orb2;
    private Orb orb3;

    @BeforeClass
    public void setup() {
        orb1 = new Orb(301, new Point(1, 3, 5), 4);
        orb2 = new Orb(302, new Point(5, 4, 7), 3);
        orb3 = new Orb(303, new Point(4, 8, 9), 2);
    }

    @AfterClass
    public void tearDown() {
        orb1 = null;
        orb2 = null;
        orb3 = null;
    }

    @Test
    public void addTest() {
        List<Orb> expected = new ArrayList<>();
        expected.add(orb1);
        expected.add(orb2);
        expected.add(orb3);
        repository.add(orb1);
        repository.add(orb2);
        repository.add(orb3);
        OrbSpecificationShowAll orbSpecificationShowAll = new OrbSpecificationShowAll();
        List<Orb> actual = repository.query(orbSpecificationShowAll);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sortTestFalse() {
        List<Orb> expected = new ArrayList<>();
        expected.add(orb1);
        expected.add(orb2);
        expected.add(orb3);
        OrbComparator orbComparator = OrbComparator.RADIUS;
        List<Orb> actual = repository.sort(orbComparator);
        Assert.assertNotEquals(expected, actual);
    }

    @Test(dependsOnMethods = {"addTest","removeTest","sortTestFalse"})
    public void sortTestTrue() {
        List<Orb> expected = new ArrayList<>();
        expected.add(orb2);
        expected.add(orb1);
        OrbComparator orbComparator = OrbComparator.RADIUS;
        List<Orb> actual = repository.sort(orbComparator);
        Assert.assertEquals(expected, actual);
    }

    @Test(dependsOnMethods = {"addTest","sortTestFalse"})
    public void removeTest() {
        List<Orb> expected = new ArrayList<>(3);
        expected.add(orb2);
        expected.add(orb1);
        repository.remove(orb3);
        OrbSpecificationShowAll orbSpecificationShowAll = new OrbSpecificationShowAll();
        List<Orb> actual = repository.query(orbSpecificationShowAll);
        Assert.assertEquals(expected, actual);
    }
}
