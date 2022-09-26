package com.bogdan_yanushkevich.javacore.crud.view;

import com.bogdan_yanushkevich.javacore.crud.model.Skill;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class SkillView extends GeneralView {

    private final Scanner sc = new Scanner(System.in);
    private Long id;


    @Override
    public void makeChoice(int choice) {
        switch (choice) {
            case 1 -> {
                Skill skill = new Skill();
                print("Enter skill name: ");
                String name = sc.nextLine();
                skill.setName(name);

                if (!checkForNull(Static.skillController.create(skill))) {
                    print("You added: ", skill);
                    Static.skillView.checkChoice();
                } else {
                    print("The object already exists, please try again.");
                    Static.skillView.checkChoice();
                }

            }
            case 2 -> {
                print("Enter ID: ");
                id = checkCorrect();

                if (checkForNull(Static.skillController.read(id))) {
                    print("Incorrect element ID, please try again.");
                    Static.skillView.checkChoice();
                } else {
                    print(Static.skillController.read(id));
                    Static.skillView.checkChoice();
                }

            }
            case 3 -> {


                print("Enter the ID of the element you want to change: ");
                id = checkCorrect();
                Skill skill = Static.skillController.read(id);

                if (checkForNull(skill)) {
                    print("Incorrect element ID, please try again.");
                    Static.skillView.checkChoice();

                } else {

                    print("Please enter new name: ");
                    String name = sc.nextLine();
                    skill.setName(name);
                    skill = Static.skillController.update(skill);

                    print("You changed: ", skill);
                    Static.skillView.checkChoice();
                }

            }
            case 4 -> {

                print("Enter the ID of the element you want to delete: ");
                id = checkCorrect();
                Skill skill = Static.skillController.read(id);

                if (!checkForNull(skill)) {
                    Static.skillController.delete(skill);
                    skill = Static.skillController.read(id);
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
            return false;
        }
    }


    private Long checkCorrect() {
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


