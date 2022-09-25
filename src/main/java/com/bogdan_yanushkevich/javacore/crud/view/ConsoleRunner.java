package com.bogdan_yanushkevich.javacore.crud.view;

import com.bogdan_yanushkevich.javacore.crud.controller.SkillController;
import com.bogdan_yanushkevich.javacore.crud.repository.impl.GsonSkillRepositoryImpl;

import java.util.Scanner;

public class ConsoleRunner {


    private static String menuTitle() {
        return """
                Make your choice.
                1. Developers.
                2. Skills.
                3. Specialties.
                0. Exit.
                """;
    }


    public static void run() {

        System.out.println(menuTitle());
        Scanner sc = new Scanner(System.in);
        int choice;
        try {
            choice = Integer.parseInt(sc.nextLine());
            if (choice > 3 || choice < 0) {
                System.out.println("Invalid option. Try again.");
                run();
            }
            switch (choice) {
                case 1 -> {
                    DeveloperView dv = new DeveloperView();
                    dv.menuTitle();
                    dv.checkChoice();
                }
                case 2 -> {
                    Static.skillView.checkChoice();
                }
                case 3 -> {
                    SpecialtyView spv = new SpecialtyView();
                    spv.menuTitle();
                    spv.checkChoice();
                }
                case 0 -> {
                    break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Repeat entry");
            run();
        }
    }
}
