package com.bogdan_yanushkevich.javacore.crud.controller;

import com.bogdan_yanushkevich.javacore.crud.model.Developer;
import com.bogdan_yanushkevich.javacore.crud.repository.impl.GsonDeveloperRepositoryImpl;

import java.util.List;

public class DeveloperController {

    private final GsonDeveloperRepositoryImpl dr = new GsonDeveloperRepositoryImpl();

    public Developer create(Developer dev) {

        return dr.create(dev);
    }

    public Developer read(Long field) {

        return dr.read(field);
    }

    public Developer update(Developer updSkill) {

        return dr.update(updSkill);
    }


    public void delete(Developer updSkill) {

        dr.delete(updSkill);
    }

    public List<Developer> showAll() {
        return dr.getALl();
    }

}
