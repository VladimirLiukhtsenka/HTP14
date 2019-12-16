package com.liukhtenko.taskShape.creatorfigure;

import com.liukhtenko.taskShape.entity.Figure;
import com.liukhtenko.taskShape.entity.Orb;
import com.liukhtenko.taskShape.entity.Point;
import com.liukhtenko.taskShape.exeption.TypeOfFigureNotPresentExeption;

public class CreatorFigureWithFactory {
    private enum TypeOfFigure {FIGURE, POINT, ORB}

    public static Figure getFigureFromFactory(String type) throws TypeOfFigureNotPresentExeption {
        TypeOfFigure typeOfFigure = TypeOfFigure.valueOf(type.toUpperCase());
        switch (typeOfFigure) {
            case POINT:
                return new Point();
            case ORB:
                return new Orb();
            default:
                throw new TypeOfFigureNotPresentExeption(type + ": this type of figure does not exist");
        }
    }
}
