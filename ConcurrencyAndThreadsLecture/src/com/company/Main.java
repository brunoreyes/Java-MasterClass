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

        // We want to have separate threads that take on separate thread stacks because:
        // -  Preforming a task that'll take longer like querying a database or fetching data on internet
        //    This shouldn't be done on the main thread, because it runs code in a linear fashion and the
        //    main thread wouldn't be able to do anything else while waiting for the data request to finish.
        //    I.e. the execution of the main thread will be suspended, having to wait for task to complete,
        //    before it can execute the next line of code. In the user's view this could appear as if the app
        //    has died/frozen especially when dealing with a UI app.
        //
        // -  Rather than tying up the main thread, we create another thread so the main can continue executing.
        //    For instance, the main can report progress or accept user input, while long task continues to
        //    execute on another thread in the background.
        //
        // -  Another reason is bc an API requires us to provide one. Sometimes providing code that'll
        //    run when a method called reaches a certain point in execution.

        // Concurrency refers to an app doing more than one thing at a time (doing things simultaneously).
        // Not meaning it's happening, but that it's possible to make progress on more than one task.
        // Like downloading data and drawing a shape on a screen. In a concurrent app it can switch between processes.
        // Concurrency - one task doesn't have to complete for another task to start.

        // Java provides thread-related classes so that we can create Java concurrent apps

        // Be weary when working with threads, I'm at the mercy of the JVM and OS (Operating System)
        // when it comes to when threads are scheduled to run.

    }
}
