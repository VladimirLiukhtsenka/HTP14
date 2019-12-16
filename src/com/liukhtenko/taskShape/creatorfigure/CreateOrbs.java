package com.liukhtenko.taskShape.creatorfigure;

import com.liukhtenko.taskShape.exeption.TypeOfFigureNotPresentExeption;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.liukhtenko.taskShape.entity.Orb;
import com.liukhtenko.taskShape.entity.Point;
import com.liukhtenko.taskShape.validator.OrbValidator;

import java.util.ArrayList;
import java.util.List;

public class CreateOrbs {
    private final static String SPACE = "\\s";
    static Logger logger = LogManager.getLogger();

    public List<Orb> createFromList(List<String> list) throws TypeOfFigureNotPresentExeption {
        OrbValidator orbValidator = new OrbValidator();
        List<Orb> orbList = new ArrayList<>();
        for (String line : list) {
            if (orbValidator.isLineValid(line)) {
                Orb orb = createFromLine(line);
                logger.log(Level.DEBUG, "Create new orb: " + orb);
                orbList.add(orb);
            }
        }
        return orbList;
    }

    public List<Orb> createFromValidList(List<String> list) throws TypeOfFigureNotPresentExeption {
        OrbValidator orbValidator = new OrbValidator();
        List<Orb> orbList = new ArrayList<>();
        for (String line : list) {
            Orb orb = createFromLine(line);
            logger.log(Level.DEBUG, "Create new orb: " + orb);
            orbList.add(orb);
        }
        return orbList;
    }

    private Orb createFromLine(String line) throws TypeOfFigureNotPresentExeption {
        String[] pos = line.split(SPACE);
        Point point = (Point) CreatorFigureWithFactory.getFigureFromFactory("point");
        point.setX(Double.parseDouble(pos[1]));
        point.setY(Double.parseDouble(pos[2]));
        point.setZ(Double.parseDouble(pos[3]));
        Orb orb = (Orb) CreatorFigureWithFactory.getFigureFromFactory("orb");
        orb.setOrbId(Integer.parseInt(pos[0]));
        orb.setCenter(point);
        orb.setRadius(Double.parseDouble(pos[4]));
        return orb;
    }
}
