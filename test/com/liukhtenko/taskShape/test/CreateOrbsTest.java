package com.liukhtenko.taskShape.test;

import com.liukhtenko.taskShape.creatorfigure.CreateOrbs;
import com.liukhtenko.taskShape.entity.Orb;
import com.liukhtenko.taskShape.entity.Point;
import com.liukhtenko.taskShape.exeption.TypeOfFigureNotPresentExeption;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateOrbsTest {
    @Test
    public void createFromListTestTrue() throws TypeOfFigureNotPresentExeption {
        CreateOrbs createOrbs = new CreateOrbs();
        List<String> list = new ArrayList<>();
        list.add("175325 3.0 6.0 -2.0 5.0");
        list.add("232657 7.0 5.0 -20.0 53.0");
        List<Orb> expected = new ArrayList<>();
        expected.add(new Orb(175325, new Point(3, 6, -2), 5.0));
        expected.add(new Orb(232657, new Point(7, 5, -20), 53.0));
        List<Orb> actual = createOrbs.createFromList(list);
        Assert.assertEquals(actual, expected);
    }
}
