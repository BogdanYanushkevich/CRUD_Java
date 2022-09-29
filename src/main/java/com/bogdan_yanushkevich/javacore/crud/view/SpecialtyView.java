package com.bogdan_yanushkevich.javacore.crud.view;

import com.bogdan_yanushkevich.javacore.crud.controller.SpecialtyController;

import com.bogdan_yanushkevich.javacore.crud.model.Specialty;

import java.util.List;

public class SpecialtyView extends GeneralView<Specialty> {

    SpecialtyController sc = new SpecialtyController();


    @Override
    public void makeChoice() {
        menuTitle();

        Long id;
        switch (checkChoice(5,0)) {
            case 1 -> {
                Specialty specialty = new Specialty();
                print("Enter the name: ");
                specialty.setName(addLine());
                if (!checkForNull(sc.create(specialty))) {
                    print("You added: ", specialty);
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
                Specialty specialty = sc.read(id);

                if (checkForNull(specialty)) {
                    print("Incorrect element ID, please try again.");
                    makeChoice();

                } else {

                    print("Please enter new name: ");
                    specialty.setName(addLine());
                    specialty = sc.update(specialty);

                    print("You changed: ", specialty);
                    makeChoice();
                }

            }
            case 4 -> {

                print("Enter the ID of the element you want to delete: ");
                id = checkCorrect();
                Specialty specialty = sc.read(id);

                if (!checkForNull(specialty)) {
                    sc.delete(specialty);
                    specialty = sc.read(id);
                    print("You deleted: ", specialty);
                    makeChoice();

                } else {
                    print("Incorrect element ID, please try again.");
                    makeChoice();
                }
            }
            case 5 -> {
                List<Specialty> specialty = sc.showAll();
                print(specialty);
                makeChoice();
            }
            case 0 -> {
                ConsoleRunner cr = new ConsoleRunner();
                cr.run();
            }
        }
    }
}
