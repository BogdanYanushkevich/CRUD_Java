package com.bogdan_yanushkevich.javacore.crud.controller;

import com.bogdan_yanushkevich.javacore.crud.model.Skill;
import com.bogdan_yanushkevich.javacore.crud.repository.impl.GsonSkillRepositoryImpl;


import java.util.*;


public class SkillController {

    private final GsonSkillRepositoryImpl sr = new GsonSkillRepositoryImpl();

    public Skill create(String name) {
        Skill skill = new Skill();
        skill.setName(name);
        return sr.create(skill);
    }

    public Skill read(Long id) {

        return sr.read(id);
    }

    public Skill update(String name) {
        Skill updSkill = new Skill();
        updSkill.setName(name);
        return sr.update(updSkill);
    }


    public void delete(Long id) {

        sr.delete(id);
    }

    public List<Skill> showAll() {
        return sr.getALl();
    }

}

