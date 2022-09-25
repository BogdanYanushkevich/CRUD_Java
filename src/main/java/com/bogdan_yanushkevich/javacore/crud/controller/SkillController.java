package com.bogdan_yanushkevich.javacore.crud.controller;

import com.bogdan_yanushkevich.javacore.crud.model.Skill;
import com.bogdan_yanushkevich.javacore.crud.view.Static;

import java.util.*;

public class SkillController {

    public Skill create() {

        Skill skill = new Skill();
        Scanner sc = new Scanner(System.in);
        String field = sc.nextLine();
        skill.setName(field);
        skill = Static.skillRepository.create(skill);

        return skill;
    }

    public Skill read() {
        Long field = checkCorrect();
        return Static.skillRepository.read(field);
    }

    public Skill update() {
        Scanner sc = new Scanner(System.in);
        Long field = checkCorrect();
        Skill updSkill = Static.skillRepository.read(field);

        if (updSkill == null) {
            return null;
        } else {
            Static.skillView.print("Please enter new name: ");
            String name = sc.nextLine();
            updSkill.setName(name);
            Static.skillRepository.update(updSkill);
        }
        return updSkill;
    }


    public Skill delete() {
        Long field = checkCorrect();
        Skill updSkill = Static.skillRepository.read(field);

        if (updSkill == null) {
            return null;
        } else {
            updSkill = Static.skillRepository.delete(updSkill);
        }
        return updSkill;
    }

    public List<Skill> showAll() {
        return Static.skillRepository.getALl();
    }

    private Long checkCorrect() {
        Scanner sc = new Scanner(System.in);
        long field;
        while (true) {
            try {
                field = Long.parseLong(sc.nextLine());
                break;

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Repeat entry");
                Static.skillView.checkChoice();
            }
        }
        return field;
    }

}
