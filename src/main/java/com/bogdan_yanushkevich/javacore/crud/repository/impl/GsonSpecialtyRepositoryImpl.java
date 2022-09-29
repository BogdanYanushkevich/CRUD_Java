package com.bogdan_yanushkevich.javacore.crud.repository.impl;

import com.bogdan_yanushkevich.javacore.crud.model.Specialty;
import com.bogdan_yanushkevich.javacore.crud.model.Status;
import com.bogdan_yanushkevich.javacore.crud.repository.SpecialtyRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class GsonSpecialtyRepositoryImpl implements SpecialtyRepository {

    private final static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private final File file = new File("C:\\Users\\Bogdan\\IdeaProjects\\CRUD_Java\\src\\main\\resources\\specialty.json");


    public GsonSpecialtyRepositoryImpl() {
    }


    @Override
    public Specialty create(Specialty obj) {
        List<Specialty> specialties = getFromJson();

        if (!checkForRepeats(obj.getName())) {

            obj.setId(generateID(specialties));
            obj.setStatus(Status.ACTIVE);
            specialties.add(obj);
            writeToJson(specialties);

        } else {
            return null;
        }
        return obj;
    }


    @Override
    public Specialty read(Long id) {
        List<Specialty> specialties = getFromJson();
        return specialties.stream().filter(s -> s.getId().equals(id))
                .findFirst().orElse(null);
    }


    public Specialty update(Specialty obj) {

        List<Specialty> specialties = getFromJson();
        if (checkForRepeats(obj.getName())) {
            return null;
        } else {
            for (Specialty s : specialties) {

                if (s.getId().equals(obj.getId())) {
                    s.setName(obj.getName());
                    writeToJson(specialties);
                    return s;
                }
            }

        }

        return null;
    }

    @Override
    public void delete(Specialty obj) {
        List<Specialty> specialties = getFromJson();
        for (Specialty s : specialties) {
            if (s.getId().equals(obj.getId())) {
                s.setStatus(Status.DELETED);
                writeToJson(specialties);
            }
        }
    }

    @Override
    public List<Specialty> getALl() {

        return getFromJson();
    }


    private void writeToJson(List<Specialty> specialties) {

        try (FileWriter fw = new FileWriter(file)) {
            gson.toJson(specialties, fw);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Specialty> getFromJson() {

        List<Specialty> specialties = new ArrayList<>();

        try (Reader reader = new FileReader(file)) {
            Type type = new TypeToken<ArrayList<Specialty>>() {
            }.getType();

            specialties = new Gson().fromJson(reader, type);
            if (specialties == null) {
                specialties = new ArrayList<>();
                return specialties;
            }
        } catch (IOException e) {
            // Everything goes according to plan
        }
        return specialties;
    }

    private long generateID(List<Specialty> skills) {

        long id = 0;

        if (skills.size() != 0) {
            Optional<Specialty> s = skills.stream().max(Comparator.comparing(Specialty::getId));
            id = 1 + s.get().getId();
        } else return id;
        return id;
    }


    private boolean checkForRepeats(String name) {

        List<Specialty> specialties = getFromJson();

        if (file.exists() && specialties.size() != 0) {
            return specialties.stream().anyMatch(skill -> skill.getName().equals(name));
        } else return false;
    }

}
