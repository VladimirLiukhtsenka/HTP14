package com.liukhtenko.taskShape.comparator;

import com.liukhtenko.taskShape.entity.Orb;

import java.util.Comparator;

public enum OrbComparator implements Comparator<Orb> {
    ID {
        @Override
        public int compare(Orb o1, Orb o2) {
            return Integer.compare(o1.getOrbId(), o2.getOrbId());
        }
    },
    RADIUS {
        @Override
        public int compare(Orb o1, Orb o2) {
            return Double.compare(o1.getRadius(), o2.getRadius());
        }
    },
    COORDINATE_X {
        @Override
        public int compare(Orb o1, Orb o2) {
            return Double.compare(o1.getCenter().getX(), o2.getCenter().getX());
        }
    },
    COORDINATE_Y {
        @Override
        public int compare(Orb o1, Orb o2) {
            return Double.compare(o1.getCenter().getY(), o2.getCenter().getY());
        }
    },
    COORDINATE_Z {
        @Override
        public int compare(Orb o1, Orb o2) {
            return Double.compare(o1.getCenter().getZ(), o2.getCenter().getZ());
        }
    }
}
