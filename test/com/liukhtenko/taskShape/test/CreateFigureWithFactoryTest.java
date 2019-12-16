package com.liukhtenko.taskShape.test;

import com.liukhtenko.taskShape.creatorfigure.CreatorFigureWithFactory;
import com.liukhtenko.taskShape.entity.Figure;
import com.liukhtenko.taskShape.entity.Orb;
import com.liukhtenko.taskShape.exeption.TypeOfFigureNotPresentExeption;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateFigureWithFactoryTest {
    @Test
    public void getFigureFromFactoryTestTrue() throws TypeOfFigureNotPresentExeption {
        Orb expected = new Orb();
        Figure actual = CreatorFigureWithFactory.getFigureFromFactory("orb");
        Assert.assertEquals(expected, actual);
    }

    @Test(expectedExceptions = TypeOfFigureNotPresentExeption.class)
    public void getFigureFromFactoryTestFalse() throws TypeOfFigureNotPresentExeption {
        Figure actual = CreatorFigureWithFactory.getFigureFromFactory("figure");
    }
}
