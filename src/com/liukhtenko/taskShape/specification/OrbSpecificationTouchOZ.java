package com.liukhtenko.taskShape.specification;

import com.liukhtenko.taskShape.entity.Orb;
import com.liukhtenko.taskShape.logic.OrbLogic;

public class OrbSpecificationTouchOZ implements Specification {
    @Override
    public boolean specified(Orb orb) {
        OrbLogic orbLogic = new OrbLogic();
        return orbLogic.isTouchOZ(orb);
    }
}