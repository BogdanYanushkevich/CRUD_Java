package com.bogdan_yanushkevich.javacore.crud.model;

import java.util.List;

public class Developer extends BaseEntity {


    private String firstName;
    private String lastName;
    List<Skill> skills;
    Specialty specialty;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void addSkills(Skill skill) {
        skills.add(skill);
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }
}
