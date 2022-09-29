package com.bogdan_yanushkevich.javacore.crud.repository.impl;

import com.bogdan_yanushkevich.javacore.crud.model.Developer;
import com.bogdan_yanushkevich.javacore.crud.model.Status;
import com.bogdan_yanushkevich.javacore.crud.repository.DeveloperRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class GsonDeveloperRepositoryImpl implements DeveloperRepository {


    private final static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private final File file = new File("C:\\Users\\Bogdan\\IdeaProjects\\CRUD_Java\\src\\main\\resources\\developer.json");


    public GsonDeveloperRepositoryImpl() {
    }


    @Override
    public Developer create(Developer obj) {
        List<Developer> developers = getFromJson();
        obj.setId(generateID(developers));
        obj.setStatus(Status.ACTIVE);
        developers.add(obj);
        writeToJson(developers);


        return obj;
    }


    @Override
    public Developer read(Long id) {
        List<Developer> developers = getFromJson();
        return developers.stream().filter(d -> d.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public Developer update(Developer obj) {
        Developer d = null;
        List<Developer> developers = getFromJson();

        for (Developer s : developers) {
            if (s.getId().equals(obj.getId())) {
                s.setName(obj.getName());
                s.setLastName(obj.getLastName());
                s.addSkills(obj.getSkills());
                s.setSpecialty(obj.getSpecialty());
                writeToJson(developers);
                d = s;
            }
        }

        return d;
    }

    @Override
    public void delete(Developer obj) {
        List<Developer> developers = getFromJson();
        for (Developer s : developers) {
            if (s.getId().equals(obj.getId())) {
                s.setStatus(Status.DELETED);
                writeToJson(developers);
            }
        }
    }

    @Override
    public List<Developer> getALl() {

        return getFromJson();
    }


    private void writeToJson(List<Developer> developers) {

        try (FileWriter fw = new FileWriter(file)) {
            gson.toJson(developers, fw);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Developer> getFromJson() {

        List<Developer> developers = new ArrayList<>();

        try (Reader reader = new FileReader(file)) {
            Type type = new TypeToken<ArrayList<Developer>>() {
            }.getType();

            developers = new Gson().fromJson(reader, type);
            if (developers == null) {
                developers = new ArrayList<>();
                return developers;
            }
        } catch (IOException e) {
            // Everything goes according to plan
        }
        return developers;
    }

    private long generateID(List<Developer> developers) {

        long id = 0;

        if (developers.size() != 0) {
            Optional<Developer> s = developers.stream().max(Comparator.comparing(Developer::getId));
            id = 1 + s.get().getId();
        } else return id;
        return id;
    }
}
