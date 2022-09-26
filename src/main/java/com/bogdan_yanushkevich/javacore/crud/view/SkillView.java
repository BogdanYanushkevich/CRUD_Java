package com.bogdan_yanushkevich.javacore.crud.view;

import com.bogdan_yanushkevich.javacore.crud.model.Skill;

import java.util.Iterator;
import java.util.List;


public class SkillView extends GeneralView {

    @Override
    public void makeChoice(int choice) {
        switch (choice) {
            case 1 -> {
                print("Enter skill name: ");
                Skill skill = Static.skillController.create();

                if (checkForNull(skill)) {
                    print("You added: ", skill);
                    Static.skillView.checkChoice();
                } else {
                    print("The object already exists, please try again.");
                    Static.skillView.checkChoice();
                }

            }
            case 2 -> {
                print("Enter ID: ");
                print(Static.skillController.read());
                Static.skillView.checkChoice();
            }
            case 3 -> {
                print("Enter the ID of the element you want to change: ");
                Skill skill = Static.skillController.update();
                if (!checkForNull(skill)) {
                    print("Incorrect element ID, please try again.");
                    Static.skillView.checkChoice();

                } else {
                    print("You changed: ", skill);
                    Static.skillView.checkChoice();
                }

            }
            case 4 -> {
                print("Enter the ID of the element you want to delete: ");
                Skill skill = Static.skillController.delete();
                if (checkForNull(skill)) {
                    print("You deleted: ", skill);
                    Static.skillView.checkChoice();
                } else {
                    print("Incorrect element ID, please try again.");
                    Static.skillView.checkChoice();
                }
            }
            case 5 -> {
                List<Skill> skills = Static.skillController.showAll();
                print(skills);
                Static.skillView.checkChoice();
            }
            case 0 -> ConsoleRunner.run();
        }
    }


    private void print(List<Skill> skills) {
        Iterator<Skill> itr = skills.listIterator();
        itr.forEachRemaining(System.out::println);
    }

    private void print(Skill skill) {
        System.out.println(skill);
    }

    private void print(String message, Skill skill) {
        System.out.println(message + skill);
    }

    public void print(String message) {
        System.out.println(message);
    }


    public boolean checkForNull(Skill skill) {
        if (skill == null) {
            return true;
        } else {
            return true;
        }

    }

}


