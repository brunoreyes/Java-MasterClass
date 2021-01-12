package com.company;

import static org.junit.jupiter.api.Assertions.*;
//import static junit.framework.TestCase.fail;
import org.junit.Test;

class BankAccountTest {

    // to get rid of errors, press on the error junit with option + enter. and add to classPath.
    // the same with jupiter for jUnit5
    @org.junit.jupiter.api.Test
    void deposit() {
        // To make sure we don't make the mistake of not having auto successes all test have to call
        // JUnit's fail method, which reports that a test has failed
        fail("This test has yet to be implemented");
        // fail method produces error: org.opentest4j.AssertionFailedError: This test has yet to be implemented

        //  I was taught that it is very good practice to start coding your program not from implementing
        //  classes and methods, but instead - writing a tests for every single method you have planned to implement in your business logic.

        // In JUnit we test output and fail if assertion isn't met
    }

    @org.junit.jupiter.api.Test
    void withdraw() {
        fail("This test has yet to be implemented");
    }

    @org.junit.jupiter.api.Test
    void getBalance() {
        fail("This test has yet to be implemented");
    }

    // To create a separate run configuration for all the test above, to test class of the application
    // and not actually run the test itself, right click anywhere outside of the testing methods
    // To be able to run the test, use right-click to open up menu and press " run BankAccount Test"

    // When running a test, the console at the bottom of IntelliJ splits into 2.
    //  On the left side there's a menu of all the test that have been run
    //  On the right side is the normal console, with a test indicator identifying how many test passed
    // and now long it too. For ex: Tests passed: 3 of 3 tests - 16ms

}