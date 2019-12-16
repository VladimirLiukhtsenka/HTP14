package com.liukhtenko.taskShape.entity;

import com.liukhtenko.taskShape.observer.Observable;
import com.liukhtenko.taskShape.observer.Observer;
import com.liukhtenko.taskShape.observer.OrbEvent;
import com.liukhtenko.taskShape.observer.OrbObserver;

public class Orb extends Figure implements Observable {
    private Point center;
    private OrbObserver orbObserver;
    private double radius;
    private int orbId;

    public Orb() {
    }

    public Orb(int id, Point center, double radius) {
        this.orbId = id;
        this.center = center;
        this.radius = radius;
    }

    public int getOrbId() {
        return orbId;
    }

    public void setOrbId(int orbId) {
        this.orbId = orbId;
        notifyObserver();
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
        notifyObserver();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        notifyObserver();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Orb orb = (Orb) o;
        if (orbId != orb.orbId) {
            return false;
        }
        if (Double.compare(radius, orb.radius) != 0) {
            return false;
        }
        return center != null ? center.equals(orb.center) : orb.center == null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + orbId;
        result = prime * result + ((center == null) ? 0 : center.hashCode());
        result = prime * result + (int) radius;
        return result;
    }

    @Override
    public String toString() {
        return "Orb{" +
                "id=" + orbId +
                ", center=" + center +
                ", radius=" + radius +
                '}';
    }

    @Override
    public void addObserver(Observer orbObserver) {
        this.orbObserver = (OrbObserver) orbObserver;
    }

    @Override
    public void removeObserver(Observer observer) {
        orbObserver = null;
    }

    @Override
    public void notifyObserver() {
        if (orbObserver != null) {
            orbObserver.actionPerformed(new OrbEvent(this));
        }
    }
}
