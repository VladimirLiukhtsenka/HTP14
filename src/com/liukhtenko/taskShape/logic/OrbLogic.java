package com.liukhtenko.taskShape.logic;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.liukhtenko.taskShape.entity.Orb;

public class OrbLogic {
    static Logger logger = LogManager.getLogger();

    public double areaSurface(Orb orb) {
        double areaSurface = 4 * Math.PI * Math.pow(orb.getRadius(), 2);
        logger.log(Level.INFO, "The surface area of " + orb + " is equal: " + areaSurface);
        return areaSurface;
    }

    public double volume(Orb orb) {
        double volume = 4 / 3 * Math.PI * Math.pow(orb.getRadius(), 3);
        logger.log(Level.INFO, "The volume of " + orb + " is equal: " + volume);
        return volume;
    }

    public boolean isTouchOXYZ(Orb orb) {
        return isTouchOX(orb) || isTouchOY(orb) || isTouchOZ(orb);
    }

    public boolean isTouchOX(Orb orb) {
        return orb.getRadius() >= Math.abs(orb.getCenter().getX());
    }

    public boolean isTouchOY(Orb orb) {
        return orb.getRadius() >= Math.abs(orb.getCenter().getY());
    }

    public boolean isTouchOZ(Orb orb) {
        return orb.getRadius() >= Math.abs(orb.getCenter().getZ());
    }

    private double volumeRatioByCoordinate(Orb orb, double coordinate) {
        double heightFirstSegm = Math.abs(orb.getRadius() - Math.abs(coordinate));
        double heightSecondSegm = 2 * orb.getRadius() - heightFirstSegm;
        double volumeOfFirstSegment = (Math.PI * Math.pow(heightFirstSegm, 2) * (3 * orb.getRadius() - heightFirstSegm)) / 3;
        double volumeOfSecondSegment = (Math.PI * Math.pow(heightSecondSegm, 2) * (3 * orb.getRadius() - heightSecondSegm)) / 3;
        return volumeOfFirstSegment / volumeOfSecondSegment;
    }

    public double volumeRatioByOX(Orb orb) {
        double ret = 0;
        if (isTouchOX(orb)) {
            ret = volumeRatioByCoordinate(orb, orb.getCenter().getX());
            logger.log(Level.INFO, "Orb: " + orb + " cross OX in ratio: " + ret);
        }
        return ret;
    }

    public double volumeRatioByOY(Orb orb) {
        double ret = 0;
        if (isTouchOY(orb)) {
            ret = volumeRatioByCoordinate(orb, orb.getCenter().getY());
            logger.log(Level.INFO, "Orb: " + orb + " cross OY in ratio: " + ret);
        }
        return ret;
    }

    public double volumeRatioByOZ(Orb orb) {
        double ret = 0;
        if (isTouchOZ(orb)) {
            ret = volumeRatioByCoordinate(orb, orb.getCenter().getZ());
            logger.log(Level.INFO, "Orb: " + orb + " cross OZ in ratio: " + ret);
        }
        return ret;
    }
}
