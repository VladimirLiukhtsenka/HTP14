package com.liukhtenko.taskShape.observer;

import com.liukhtenko.taskShape.entity.Orb;
import com.liukhtenko.taskShape.logic.OrbLogic;
import com.liukhtenko.taskShape.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrbObserver implements Observer {
    static Logger logger = LogManager.getLogger();
    private double areaSurface;
    private double volume;

    @Override
    public void actionPerformed(OrbEvent orbEvent) {
        Warehouse instance = Warehouse.getInstance();
        OrbLogic orbLogic = new OrbLogic();
        volume = orbLogic.volume((Orb) orbEvent.getSource());
        areaSurface = orbLogic.areaSurface((Orb) orbEvent.getSource());
        instance.add(((Orb) orbEvent.getSource()).getOrbId(), this);
        logger.log(Level.INFO, "The OrbObserver:" + this + "was added to the warehouse with Id: " +
                ((Orb) orbEvent.getSource()).getOrbId());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrbObserver{areaSurface=" + areaSurface);
        sb.append(", volume=").append(volume).append("}");
        return sb.toString();
    }
}
