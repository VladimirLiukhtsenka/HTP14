package com.liukhtenko.taskShape.specification;

import com.liukhtenko.taskShape.entity.Orb;

public class OrbSpecificationById implements Specification {
    private int id;

    public OrbSpecificationById(int id) {
        this.id = id;
    }

    @Override
    public boolean specified(Orb orb) {
        return orb.getOrbId() == id;
    }
}
