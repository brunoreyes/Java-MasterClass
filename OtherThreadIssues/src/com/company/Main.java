package com.company;

public class Main {

    public static void main(String[] args) {
        // When a thread's running, it can be suspended in the middle of a task.

        // Or a thread can be partially completed evaluating an argument when suspended.

        // Recall, an Atomic Action cannot be suspended in the middle of being executed.
        // It either completes or doesn't occur at all like an SQL transaction.
        // Once a thread starts an Atomic Action, we can be confident it won't be suspended
        // until the action has completed.

        // Some atomic scenarios:
        // 1. Read and writing ref vars. For ex, the statement, myObject1 = myObject2, is atomic.
        // i.e the thread can't be suspended in the middle of execution.

        // 2. Reading and writing primitive vars, except longs and doubles like myInt = 10

        // 3. Reading and writing all vars declared volatile.

        // Each thread has a CPU cache, which can contain copies of values that are in the main memory.
        // So it's possible to get memory consistency errors when multiple thread read/write to same var.

        // It's faster to read from the cache, and since there are multiple CPU's, when running an app
        // each thread could be on a different CPU with it's own cache

        // Volatile variables,
    }
}
