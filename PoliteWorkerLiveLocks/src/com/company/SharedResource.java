package com.company;

public class SharedResource {
    private Worker owner;

    public SharedResource(Worker owner) {
        this.owner = owner;
    }

    public Worker getOwner() {
        return owner;
    }

    // Since I will be changing data, I want the setOwner method to be synchronized
    public synchronized void setOwner(Worker owner) {
        this.owner = owner;
    }




}
