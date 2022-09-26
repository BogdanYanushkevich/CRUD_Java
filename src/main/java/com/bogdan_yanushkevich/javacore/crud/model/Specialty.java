package com.bogdan_yanushkevich.javacore.crud.model;

public class Specialty extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Skill{" +
                "name='" + name + '\'' +
                "id='" + getId() + '\'' +
                "status='" + getStatus() + '\'' +
                '}';
    }
}
