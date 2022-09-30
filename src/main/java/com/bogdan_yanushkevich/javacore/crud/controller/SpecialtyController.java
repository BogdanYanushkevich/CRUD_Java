package com.bogdan_yanushkevich.javacore.crud.controller;


import com.bogdan_yanushkevich.javacore.crud.model.Specialty;
import com.bogdan_yanushkevich.javacore.crud.repository.impl.GsonSpecialtyRepositoryImpl;

import java.util.List;

public class SpecialtyController {
    private final GsonSpecialtyRepositoryImpl sr = new GsonSpecialtyRepositoryImpl();

    public Specialty create(String name) {
        Specialty specialty = new Specialty();
        specialty.setName(name);
        return sr.create(specialty);
    }

    public Specialty read(Long id) {

        return sr.read(id);
    }

    public Specialty update(String name) {
        Specialty updSkill = new Specialty();
        updSkill.setName(name);
        return sr.update(updSkill);
    }


    public void delete(Long id) {

        sr.delete(id);
    }

    public List<Specialty> showAll() {
        return sr.getALl();
    }

}

