package com.bogdan_yanushkevich.javacore.crud.controller;

import com.bogdan_yanushkevich.javacore.crud.model.Developer;
import com.bogdan_yanushkevich.javacore.crud.model.Skill;
import com.bogdan_yanushkevich.javacore.crud.model.Specialty;
import com.bogdan_yanushkevich.javacore.crud.repository.impl.GsonDeveloperRepositoryImpl;

import java.util.List;

public class DeveloperController {

    private final GsonDeveloperRepositoryImpl dr = new GsonDeveloperRepositoryImpl();

    public Developer create(String firtsname, String lastname, List<Skill> skills, Specialty specialty) {
        Developer dev = new Developer();
        dev.setName(firtsname);
        dev.setLastName(lastname);
        dev.addSkills(skills);
        dev.setSpecialty(specialty);
        return dr.create(dev);
    }

    public Developer read(Long field) {

        return dr.read(field);
    }

    public Developer update(Long id, String firtsname, String lastname, List<Skill> skills, Specialty specialty) {
        Developer dev = new Developer();
        return dr.update(dev);
    }


    public void delete(Long id) {

        dr.delete(id);
    }

    public List<Developer> showAll() {
        return dr.getALl();
    }

}
