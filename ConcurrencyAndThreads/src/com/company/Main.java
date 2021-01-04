package com.company;

public class Main {

    public static void main(String[] args) {
        // Process - a unit of execution that has it's own memory space.

        // Each instance of a Java Virtual Machine (JVM) runs a process (mostly all JVMs).
        // When I run a Java console or JavaFX application, I am kicking off a process.

        // Process and application are used interchangeably in Java. Each app that's running
        // has it's own memory space of Heap, each app has it's own heap and can't access another.

        // Thread - unit of execution within a process. Each process can have multiple threads,
        // but has to have at least one thread, the main thread. (For UX apps this is called the
        // JavaFX app thread). Almost every Java process has multiple system threads that handle
        // task like memory management and I/O. As developers our codes run on the main thread or
        // in other threads we explicitly create.

        // Creating a thread requires less resources than creating a process (obviously since a process
        // is made up of thread/s). Every thread created by a process shares the process's memory and files.
        // This ability can create security problems if not properly taken care of.

        // Each process's thread contains a thread stack, containing memory that only the thread can access.
        // Every process has a heap and every thread has a thread stack.
    }
}
