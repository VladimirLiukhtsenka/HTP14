package com.liukhtenko.taskShape.observer;

import com.liukhtenko.taskShape.entity.Orb;

import java.util.EventObject;

public class OrbEvent extends EventObject {

    public OrbEvent(Object source) {
        super(source);
    }

    @Override
    public Object getSource() {
        return (Orb) super.getSource();
    }
}
