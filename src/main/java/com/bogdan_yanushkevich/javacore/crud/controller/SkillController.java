package com.bogdan_yanushkevich.javacore.crud.controller;

import com.bogdan_yanushkevich.javacore.crud.model.Skill;
import com.bogdan_yanushkevich.javacore.crud.repository.impl.GsonSkillRepositoryImpl;


import java.util.*;


public class SkillController {

    private final GsonSkillRepositoryImpl sr = new GsonSkillRepositoryImpl();

    public Skill create(Skill skill) {

        return sr.create(skill);
    }

    public Skill read(Long field) {

        return sr.read(field);
    }

    public Skill update(Skill updSkill) {

        return sr.update(updSkill);
    }


    public void delete(Skill updSkill) {

        sr.delete(updSkill);
    }

    public List<Skill> showAll() {
        return sr.getALl();
    }

}

