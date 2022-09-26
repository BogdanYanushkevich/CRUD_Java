package com.bogdan_yanushkevich.javacore.crud.controller;

import com.bogdan_yanushkevich.javacore.crud.model.Skill;
import com.bogdan_yanushkevich.javacore.crud.view.Static;

import java.util.*;

public class SkillController {

    public Skill create(Skill skill) {

        skill = Static.skillRepository.create(skill);

        return skill;
    }

    public Skill read(Long field) {

        return Static.skillRepository.read(field);
    }

    public Skill update(Skill updSkill) {

        updSkill.setName(updSkill.getName());
        Static.skillRepository.update(updSkill);

        return updSkill;
    }


    public void delete(Skill updSkill) {

        Static.skillRepository.delete(updSkill);

    }

    public List<Skill> showAll() {
        return Static.skillRepository.getALl();
    }

}

