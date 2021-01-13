package com.company;

import static org.junit.jupiter.api.Assertions.*;
import static junit.framework.TestCase.fail;
import static junit.framework.TestCase.assertEquals;
//import org.junit.Test;

public class BankAccountTest {

    // to get rid of errors, press on the error junit with option + enter. and add to classPath.
    // the same with jupiter for jUnit5
    @org.junit.jupiter.api.Test
    public void deposit() {
        BankAccount account = new BankAccount("Bruno", "Reyes", 1000.00);
        double balance = account.deposit(200.00, true);
        // the assertEquals method uses the equals method
        assertEquals(1200, balance, 0);// third param is delta, allows le-way in comparison
        // as long as the difference between the expected and actual values is within the delta specified,
        // then the assertion will pass
        assertEquals(1200, account.getBalance(), 0);
        // Every test method should start fresh, running independently of other test methods

        // When writing a test the test should run and pass on it's own

        // To make sure we don't make the mistake of not having auto successes all test have to call
        // JUnit's fail method, which reports that a test has failed
//        fail("This test has yet to be implemented");
        // fail method produces error: "org.opentest4j.AssertionFailedError: This test has yet to be implemented"

        //  Student's Comment: I was taught that it is very good practice to start coding your program
        //  not from implementing classes and methods, but instead - writing a tests for every single
        //  method you have planned to implement in your business logic.

        // In JUnit we test output and fail if assertion isn't met
    }

    @org.junit.jupiter.api.Test
    public void withdraw() {
        fail("This test has yet to be implemented");
    }

    @org.junit.jupiter.api.Test
    public void getBalance() {
        fail("This test has yet to be implemented");
    }

    // To create a separate run configuration for all the test above, to test class of the application
    //  and not actually run the test itself, right click anywhere outside of the testing methods
    //  To be able to run the test, use right-click to open up menu and press " run BankAccount Test"

    // When running a test, the console at the bottom of IntelliJ splits into 2.
    //  On the left side there's a menu of all the test that have been run
    //  On the right side is the normal console, with a test indicator identifying how many test passed
    // and now long it too. For ex: Tests passed: 3 of 3 tests - 16ms

//    @org.junit.jupiter.api.Test // Must annotate each test with "@org.junit.jupiter.api.Test" to make it valid.
//    public void dummyTest(){
//        // Important rule of thumb, the test I write will only cover against assertions
//        assertEquals(20,21); // 1st parameter: expected & 2nd parameter: actual value
//
//    }
    // When getting rid of test remember to press edit configuration in the menu next to the "run" button and
    // remove any inactive test
}