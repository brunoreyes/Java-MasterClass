package com.company;

public class Main {

    public static void main(String[] args) {

        // Marked vars final to be able to utilize them in inner classes such as within run() below
        final PolitePerson jane = new PolitePerson("Jane");
        final PolitePerson john = new PolitePerson("John");

        new Thread(new Runnable() {
            @Override
            public void run() {
                jane.sayHello(john);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                john.sayHello(jane);
            }
        }).start();

        // jane.sayHello(john); // since code is currently being experienced on a single thread
        // john.sayHello(jane); // there is no way to experience a deadlock

        // Deadlock usually occurs with the order that threads are trying to acquire locks.

        // 1. Thread1 acquires the lock on the jane object and enters the sayHello() method.
        // It prints to the console, then suspends.

        // 2. Thread2 acquires the lock on the john object and enters the sayHello() method.
        // It prints to the console, then suspends.

        // 3. Thread1 runs again and wants to say hello back to the john object. It tries to call the sayHelloBack() method
        // using the john object that was passed into the sayHello() method,
        // but Thread2 is holding the john lock, so Thread1 suspends.

        // 4. Thread2 runs again and wants to say hello back to the jane object. It tries to call the sayHelloBack() method
        // using the jane object that was passed into the sayHello() method,
        // but Thread1 is holding the jane lock, so Thread2 suspends.
    }

    static class PolitePerson{
        private final String name;

        public PolitePerson(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }
        public synchronized void sayHello(PolitePerson person){
            System.out.format("%s: %s" + " has said hello to me!%n", this.name, person.getName());
            // %s: parameter given, %n: new line
            // "this.name: person.getName()" + " has said hello to me!( goes to new line)"
            person.sayHelloBack(this); // getting the other object to say: hello back
        }

        public synchronized void sayHelloBack(PolitePerson person){
            System.out.format("%s: %s" + " has said hello back to me!%n", this.name, person.getName());
        }
    }
}
