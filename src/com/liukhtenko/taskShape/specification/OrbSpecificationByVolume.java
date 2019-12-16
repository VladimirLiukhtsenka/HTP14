package com.liukhtenko.taskShape.specification;

import com.liukhtenko.taskShape.entity.Orb;
import com.liukhtenko.taskShape.logic.OrbLogic;

public class OrbSpecificationByVolume implements Specification {
    private double minVolume;
    private double maxVolume;

    public OrbSpecificationByVolume(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specified(Orb orb) {
        OrbLogic orbLogic = new OrbLogic();
        double volume = orbLogic.volume(orb);
        return volume >= minVolume && volume <= maxVolume;
    }
}
