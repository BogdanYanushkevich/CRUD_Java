package com.bogdan_yanushkevich.javacore.crud.model;

public class BaseEntity<T> {


    private T id;
    private Status status = Status.ACTIVE;


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}