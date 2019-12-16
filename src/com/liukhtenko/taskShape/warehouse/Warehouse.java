package com.liukhtenko.taskShape.warehouse;

import com.liukhtenko.taskShape.observer.OrbObserver;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class Warehouse {
    static Logger logger = LogManager.getLogger();
    private static Warehouse instance = null;
    private HashMap<Integer, OrbObserver> map = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public void add(int id, OrbObserver orbObserver) {
        map.put(id, orbObserver);
        logger.log(Level.INFO, "The OrbObserver:" + orbObserver + "was added to the warehouse with Id: " + id);
    }

    public void remove(int id) {
        map.remove(id);
        logger.log(Level.INFO, "The OrbObserver with Id: " + id + "was deleted from the warehouse");
    }

    public HashMap<Integer, OrbObserver> getMap() {
        return map;
    }
}
