package com.liukhtenko.taskShape.repository;

import com.liukhtenko.taskShape.comparator.OrbComparator;
import com.liukhtenko.taskShape.entity.Orb;
import com.liukhtenko.taskShape.specification.Specification;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    static Logger logger = LogManager.getLogger();
    private static Repository instance = null;
    private List<Orb> repositoryList = new ArrayList<>();

    private Repository() {
    }

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public void add(Orb orb) {
        repositoryList.add(orb);
        logger.log(Level.INFO, "The ball was added to the repository: " + orb);
    }

    public void remove(Orb orb) {
        repositoryList.remove(orb);
        logger.log(Level.INFO, "The ball was deleted from the repository: " + orb);
    }

    public List<Orb> query(Specification specification) {
        List<Orb> orbList = new ArrayList<>();
        for (Orb orb : repositoryList) {
            if (specification.specified(orb)) {
                orbList.add(orb);
            }
        }
        return orbList;
    }

    public List<Orb> sort(OrbComparator orbComparator) {
        repositoryList.sort(orbComparator);
        return repositoryList;
    }
}
