package com.bogdan_yanushkevich.javacore.crud.view;

import com.bogdan_yanushkevich.javacore.crud.controller.SkillController;
import com.bogdan_yanushkevich.javacore.crud.model.Skill;

import java.util.List;


public class SkillView extends GeneralView<Skill> {

    SkillController sc = new SkillController();


    @Override
    public void makeChoice() {
        menuTitle();
        Long id;
        switch (checkChoice(5, 0)) {
            case 1 -> {
                Skill skill = new Skill();
                print("Enter skill name: ");
                skill.setName(addLine());
                if (!checkForNull(sc.create(skill))) {
                    print("You added: ", skill);
                    makeChoice();
                } else {
                    print("The object already exists, please try again.");
                    makeChoice();
                }

            }
            case 2 -> {
                print("Enter ID: ");
                id = checkCorrect();

                if (checkForNull(sc.read(id))) {
                    print("Incorrect element ID, please try again.");
                    makeChoice();
                } else {
                    print(sc.read(id));
                    makeChoice();
                }

            }
            case 3 -> {


                print("Enter the ID of the element you want to change: ");
                id = checkCorrect();

                if (checkForNull(sc.read(id))) {
                    print("Incorrect element ID, please try again.");
                    makeChoice();

                } else {
                    print("Please enter new name: ");
                    print("You changed: ", sc.update(addLine()));
                    makeChoice();
                }

            }
            case 4 -> {

                print("Enter the ID of the element you want to delete: ");
                id = checkCorrect();
                if (checkForNull(sc.read(id))) {
                    print("Incorrect element ID, please try again.");
                    makeChoice();
                } else {
                    sc.delete(sc.read(id));
                    print("You deleted: ", sc.read(id));
                    makeChoice();



                }
            }
            case 5 -> {
                List<Skill> skills = sc.showAll();
                print(skills);
                makeChoice();
            }
            case 0 -> {
                ConsoleRunner cr = new ConsoleRunner();
                cr.run();
            }
        }
    }
}


