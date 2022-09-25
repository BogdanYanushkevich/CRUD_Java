package com.bogdan_yanushkevich.javacore.crud.repository.impl;

import com.bogdan_yanushkevich.javacore.crud.model.Skill;
import com.bogdan_yanushkevich.javacore.crud.model.Status;
import com.bogdan_yanushkevich.javacore.crud.repository.SkillRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;


public class GsonSkillRepositoryImpl implements SkillRepository {


    private final static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private final File file = new File("C:\\Users\\Bogdan\\IdeaProjects\\CRUD_Java\\src\\main\\resources\\skill.json");


    public GsonSkillRepositoryImpl() {
    }


    @Override
    public Skill create(Skill obj) {
        List<Skill> skills = getFromJson();

        if (!checkForRepeats(obj.getName())) {

            obj.setId(generateID());
            skills.add(obj);
            addToJson(skills);

        } else {
            return null;
        }
        return obj;
    }


    @Override
    public Skill read(Long id) {
        List<Skill> skills = getFromJson();
        return skills.stream().filter(s -> s.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public Skill update(Skill obj) {

        List<Skill> skills = getFromJson();
        if (checkForRepeats(obj.getName())) {
            return null;
        } else {
            for (Skill s : skills) {

                if (s.getId().equals(obj.getId())) {
                    s.setName(obj.getName());
                    addToJson(skills);
                    return s;
                }
            }

        }

        return null;
    }

    @Override
    public Skill delete(Skill obj) {
        List<Skill> skills = getFromJson();
        for (Skill s : skills) {
            if (s.getId().equals(obj.getId())) {
                s.setStatus(Status.DELETED);
                addToJson(skills);
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Skill> getALl() {

        return getFromJson();
    }


    private void addToJson(List<Skill> skills) {

        try (FileWriter fw = new FileWriter(file)) {
            gson.toJson(skills, fw);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Skill> getFromJson() {

        List<Skill> skills = new ArrayList<>();

        try (Reader reader = new FileReader(file)) {
            Type type = new TypeToken<ArrayList<Skill>>() {
            }.getType();

            skills = new Gson().fromJson(reader, type);
            if (skills == null) {
                skills = new ArrayList<>();
                return skills;
            }
        } catch (IOException e) {
            // Everything goes according to plan
        }
        return skills;
    }

    private long generateID() {

        List<Skill> skills = getFromJson();
        long id = 0;

        if (skills.size() != 0) {
            Optional<Skill> s = skills.stream().max(Comparator.comparing(Skill::getId));
            id = s.get().getId() + 1;
        } else return id;
        return id;
    }


    private boolean checkForRepeats(String name) {

        List<Skill> skills = getFromJson();

        if (file.exists() && skills.size() != 0) {
            return skills.stream().anyMatch(skill -> skill.getName().equals(name));
        } else return false;
    }

}
