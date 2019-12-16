package com.liukhtenko.taskShape.specification;

import com.liukhtenko.taskShape.entity.Orb;

public class OrbSpecificationByRadius implements Specification {
    private double radius;

    public OrbSpecificationByRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean specified(Orb orb) {
        return orb.getRadius() == radius;
    }
}
