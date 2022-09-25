package com.bogdan_yanushkevich.javacore.crud.view;

import java.util.Scanner;

public class GeneralView {

    public void menuTitle() {
        System.out.println("""
                                
                Make your choice:
                                
                1. Create.
                2. Read.
                3. Update.
                4. Delete.
                5. Show all variants.
                0. Exit.
                                
                """);

    }

    public void makeChoice(int choice) {
        switch (choice) {
            case 1 -> {

            }
            case 2 -> {

            }
            case 3 -> {

            }
            case 4 -> {

            }
            case 5 -> {

            }
            case 0 -> {

            }
        }
    }

    public void checkChoice() {

        menuTitle();
        int choice;
        Scanner sc = new Scanner(System.in);
        try {
            choice = Integer.parseInt(sc.nextLine());
            if (choice > 5 || choice < 0) {
                System.out.println("Invalid option. Try again.\n");
                checkChoice();
            }
            makeChoice(choice);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Repeat entry");
            checkChoice();
        }
    }
}
