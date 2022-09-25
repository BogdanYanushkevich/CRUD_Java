package com.bogdan_yanushkevich.javacore.crud.model;

public class GenStatus extends GenId {

    private Status status = Status.ACTIVE;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
