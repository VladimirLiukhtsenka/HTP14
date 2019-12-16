package com.liukhtenko.taskShape.validator;

import com.liukhtenko.taskShape.entity.Orb;

import java.util.regex.Pattern;

public class OrbValidator {
    private final static int COUNT_OF_DATE = 5;
    private final static String SPACE = "\\s";
    private final static String INT = "\\d+";
    private final static String DOUBLE = "-?(\\d+)\\.?(\\d+)";

    public boolean isLineValid(String line) {
        String[] pos = line.split(SPACE);
        if (pos.length != COUNT_OF_DATE) {
            return false;
        }
        boolean ret;
        ret = isIdValid(pos[0]);
        ret = ret && isCoordinateValid(pos[1]);
        ret = ret && isCoordinateValid(pos[2]);
        ret = ret && isCoordinateValid(pos[3]);
        ret = ret && isRadiusValid(pos[4]);
        return ret;
    }

    public boolean isSquareValid(Double square) {
        return square > 0;
    }

    public boolean isVolumeValid(Double volume) {
        return volume > 0;
    }

    public boolean isOrb(Object o) {
        return o instanceof Orb;
    }

    private boolean isIdValid(String id) {
        boolean isID = Pattern.matches(INT, id);
        return isID && Integer.parseInt(id) > 0;
    }

    private boolean isCoordinateValid(String coordinate) {
        return Pattern.matches(DOUBLE, coordinate);
    }

    private boolean isRadiusValid(String radius) {
        boolean isRadius = Pattern.matches(DOUBLE, radius);
        return isRadius && Double.parseDouble(radius) > 0;
    }
}
