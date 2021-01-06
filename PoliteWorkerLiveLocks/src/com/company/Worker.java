package com.company;

public class Worker {
    private String name;
    private boolean active;

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public Worker(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public synchronized void work(SharedResource sharedResource, Worker otherWorker){
        // The thread will see if it owns the shared resource, if it doesn't, the thread
        // will wait 10 milliseconds, loop back, and try again.

        // Once the condition evaluates to true, it will continue on and see if the otherWorker
        // (the other thread) is active, if so it will politely give the shared resource to that thread,
        // and turn back to the beginning of the loop.

        // Now if the other thread isn't active, it'll use the shared resource and loop back to the beginning
        while (active){
            if (sharedResource.getOwner() != this){
                try {
                    wait(10);
                } catch (InterruptedException e){

                }
                continue;
            }
            if (otherWorker.isActive()){
                System.out.println(getName() +": give the resource to the worker: "+ otherWorker.getName());
                sharedResource.setOwner(otherWorker);
                continue;
            }
            System.out.println(getName() + ": working on the common resource");
            active = false;
            sharedResource.setOwner(otherWorker);
        }
    }
}
