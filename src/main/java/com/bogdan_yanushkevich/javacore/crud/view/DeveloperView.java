package com.bogdan_yanushkevich.javacore.crud.view;

import com.bogdan_yanushkevich.javacore.crud.controller.DeveloperController;
import com.bogdan_yanushkevich.javacore.crud.controller.SkillController;
import com.bogdan_yanushkevich.javacore.crud.controller.SpecialtyController;
import com.bogdan_yanushkevich.javacore.crud.model.Developer;
import com.bogdan_yanushkevich.javacore.crud.model.Skill;
import com.bogdan_yanushkevich.javacore.crud.model.Specialty;
import com.bogdan_yanushkevich.javacore.crud.model.Status;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeveloperView extends GeneralView<Developer> {

    private Long id;

    DeveloperController dc = new DeveloperController();


    @Override
    public void makeChoice() {
        menuTitle();
        switch (checkChoice(5, 0)) {
            case 1 -> {
                Developer dev = new Developer();
                print("Enter developer firstname: ");
                dev.setName(addLine());
                print("Enter developer lastname: ");
                dev.setLastName(addLine());
                List<Skill> skills = new ArrayList<>();
                dev.addSkills(skills);
                dev.addSkill(skillReturner());
                print("Success added.");
                dev.setSpecialty(specialtyReturner());
                print("Success added.");
                print("You added: ", dc.create(dev));
                makeChoice();
            }

            case 2 -> {
                print("Enter ID: ");
                id = checkCorrect();
                if (checkForNull(dc.read(id))) {
                    print("Incorrect element ID, please try again.");
                    makeChoice();
                } else {
                    print(dc.read(id));
                    makeChoice();
                }

            }
            case 3 -> {
                print("Enter the ID of the element you want to change: ");
                id = checkCorrect();
                Developer dev = dc.read(id);
                if (checkForNull(dev)) {
                    print("Incorrect element ID, please try again.");
                    makeChoice();
                } else {
                    print(dev);
                    dev = updateMenu(dev);
                    print("You changed: ");
                    print(dc.update(dev));
                    makeChoice();
                }

            }
            case 4 -> {

                print("Enter the ID of the element you want to delete: ");
                id = checkCorrect();
                Developer dev = dc.read(id);

                if (!checkForNull(dev)) {
                    dc.delete(dev);
                    dev = dc.read(id);
                    print("You deleted: ", dev);
                    makeChoice();

                } else {
                    print("Incorrect element ID, please try again.");
                    makeChoice();
                }
            }
            case 5 -> {
                List<Developer> developers = dc.showAll();
                print(developers);
                makeChoice();
            }
            case 0 -> {
                ConsoleRunner cr = new ConsoleRunner();
                cr.run();
            }
        }

    }


    public Skill skillReturner() {
        print("Skill Selection.");
        subCreateMenu();
        SkillController sc = new SkillController();


        switch (checkChoice(5, 0)) {
            case 1 -> {
                (sc.showAll()).forEach(System.out::println);
                print("Select skill enter ID:");
                id = checkCorrect();
                Skill skill = sc.read(id);
                if (skill == null) {
                    print("There is no such skill, add a new one.");
                    skillReturner();
                } else {
                    return skill;
                }
            }
            case 2 -> {
                Skill skill = new Skill();
                print("Enter skill name: ");
                skill.setName(addLine());
                skill = sc.create(skill);
                if (skill != null) {
                    return skill;
                } else {
                    print("The object already exists, please try again.");
                    skillReturner();
                }


            }
        }
        return null;
    }

    public Specialty specialtyReturner() {
        print("Specialty Selection.");
        subCreateMenu();
        SpecialtyController spc = new SpecialtyController();


        switch (checkChoice(2, 1)) {
            case 1 -> {
                (spc.showAll()).forEach(System.out::println);
                print("Select skill enter ID:");
                id = checkCorrect();
                Specialty specialty = spc.read(id);
                if (specialty == null) {
                    print("There is no such skill, add a new one.");
                    specialtyReturner();
                } else {
                    return specialty;
                }
            }
            case 2 -> {
                Specialty specialty = new Specialty();
                print("Enter specialty name: ");
                specialty.setName(addLine());
                specialty = spc.create(specialty);
                if (specialty != null) {
                    return specialty;
                } else {
                    print("The object already exists, please try again.");
                    specialtyReturner();
                }
            }
        }
        return null;
    }

    public Developer updateMenu(Developer dev) {
        subUpdateMenu();
        switch (checkChoice(4, 0)) {
            case 1 -> {
                print("Enter developer firstname: ");
                dev.setName(addLine());
                print("Successful changed\n", dev);
                updateMenu(dev);
            }
            case 2 -> {
                print("Enter developer lastname: ");
                dev.setLastName(addLine());
                print("Successful changed\n", dev);
                updateMenu(dev);
            }
            case 3 -> {
                dev = updateSkillMenu(dev);
                print("Successful changed\n", dev);
                updateMenu(dev);
            }
            case 4 -> {
                dev.setSpecialty(specialtyReturner());
                print("Successful changed\n", dev);
                updateMenu(dev);
            }
            case 0 -> {
                return dev;
            }
        }
        return dev;
    }

    public Developer updateSkillMenu(Developer dev) {
        subUpdateSkillsMenu();
        switch (checkChoice(2, 0)) {
            case 1 -> {
                Iterator<Skill> itr = dev.getSkills().listIterator();
                itr.forEachRemaining(System.out::println);
                print("Enter ID of element you want to delete: ");
                id = checkCorrect();
                for (Skill s : dev.getSkills()) {
                    if (s.getId().equals(id)) {
                        s.setStatus(Status.DELETED);
                    }
                }
            }

            case 2 -> dev.addSkill(skillReturner());
            case 0 -> updateMenu(dev);

        }
        return dev;
    }

    public void subCreateMenu() {
        System.out.println("""
                                
                Make your choice:
                                
                1. Choose from existing.
                2. Create new.
                               
                                
                """);
    }

    public void subUpdateSkillsMenu() {
        System.out.println("""
                                
                Make your choice:
                                
                1. Delete.
                2. Add new.
                                 
                0. Exit.
                                
                """);
    }

    public void subUpdateMenu() {
        System.out.println("""
                                
                You want to change:
                                
                1. First name.
                2. Last name.
                3. SKills.
                4. Specialty.
                                
                0. Save/Exit.
                            
                            
                """);
    }
}
