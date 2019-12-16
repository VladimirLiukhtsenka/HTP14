package com.liukhtenko.taskShape.specification;

import com.liukhtenko.taskShape.entity.Orb;
import com.liukhtenko.taskShape.logic.OrbLogic;

public class OrbSpecificationByAreaSurface implements Specification {
    private double minAreaSurface;
    private double maxAreaSurface;

    public OrbSpecificationByAreaSurface(double minAreaSurface, double maxAreaSurface) {
        this.minAreaSurface = minAreaSurface;
        this.maxAreaSurface = maxAreaSurface;
    }

    @Override
    public boolean specified(Orb orb) {
        OrbLogic orbLogic = new OrbLogic();
        double areaSurface = orbLogic.areaSurface(orb);
        return areaSurface >= minAreaSurface && areaSurface <= maxAreaSurface;
    }
}
