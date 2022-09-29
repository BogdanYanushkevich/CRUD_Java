package com.bogdan_yanushkevich.javacore.crud.controller;

import com.bogdan_yanushkevich.javacore.crud.model.Specialty;
import com.bogdan_yanushkevich.javacore.crud.repository.impl.GsonSpecialtyRepositoryImpl;

import java.util.List;

public class SpecialtyController {
    private final GsonSpecialtyRepositoryImpl sr = new GsonSpecialtyRepositoryImpl();

    public Specialty create(Specialty specialty) {

        return sr.create(specialty);
    }

    public Specialty read(Long field) {

        return sr.read(field);
    }

    public Specialty update(Specialty updSkill) {

        return sr.update(updSkill);
    }


    public void delete(Specialty updSkill) {

        sr.delete(updSkill);
    }

    public List<Specialty> showAll() {
        return sr.getALl();
    }

}

