package com.bogdan_yanushkevich.javacore.crud.model;

public class Skill extends GenStatus {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Skill | " +
                "\tID: " + getId() + " \t| " +
                "Name: " + name + " \t| " +
                "Status: " + getStatus();
    }
}
