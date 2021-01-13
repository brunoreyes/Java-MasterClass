package com.company;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;
import static junit.framework.TestCase.fail;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
//import org.junit.Test;

public class BankAccountTest {

    private BankAccount account;
    private static int count;

    @org.junit.jupiter.api.BeforeAll // runs before all methods run
    public static void BeforeClass() {
        System.out.println("This executes before any test class. Count = " + count++);
    }


    @org.junit.jupiter.api.BeforeEach // annotating with "@org.junit.Before" to ensure it runs before each method runs
    public void setup(){
        account = new BankAccount("Bruno", "Reyes", 1000.00, BankAccount.CHECKING);
        System.out.println("Running setup() test...");
    }

    // to get rid of errors, press on the error junit with option + enter. and add to classPath.
    // the same with jupiter for jUnit5
    @org.junit.jupiter.api.Test
    public void deposit() { // test method names should give some indication of the actual condition they are testing.
        double balance = account.deposit(200.00, true);
        // the assertEquals method uses the equals method
        assertEquals(1200.00, balance, 0);// third param is delta, allows le-way in comparison
        // as long as the difference between the expected and actual values is within the delta specified,
        // then the assertion will pass
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
    public void withdraw_branch() {
        double balance = account.withdraw(600.00, true);
        assertEquals(400.00, balance, 0);
    }

    @org.junit.jupiter.api.Test
    public void withdraw_ATM() {
        // when expecting an exception to be thrown, use   Assertions.assertThrows(IllegalArgumentException.class, () -> {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//        double balance = account.withdraw(600.00, true); // removed local var instance to solely test exception
        account.withdraw(600.00, false);
        fail("Should have thrown an IllegalArgumentException");
//            assertEquals(400.00, account.getBalance(), 0); // removed to just see if exception is thrown

            // old way to preform test on JUnit3
//            try {
//                account.withdraw(600.00, false);
//                fail("Should have thrown an illegal argument exception");
//            } catch (IllegalArgumentException e){
//
//            }
        });


    }

    @org.junit.jupiter.api.Test
    public void getBalance_deposit() {
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    public void getBalance_withdraw() {
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    public void isChecking_true(){
        assertTrue("This test has yet to be implemented", account.isChecking());
        // assertTrue("failure message", is a boolean returning true if the parameter is true, else false)
        // if assert true's 2nd param is false than the failure message will occur
    }

    @org.junit.jupiter.api.AfterAll // runs after all methods run
    public static void afterClass(){
        System.out.println("This executes after any test cases. Count = " + count++);
    }

    @org.junit.jupiter.api.AfterEach // runs after each methods run
    public void tearDown(){
        System.out.println("Count = " + count++);
    }


    // Assertion Methods
    // assertNotEquals() used to make sure two variables don;t have the same value aka not equal

    // assertArrayEquals() used to verify that the two values of each array and the array lengths are equal.
    // Remember not to compare array values using assertEquals() b/c it'll return true if they are the same instance

    // assertNull(), assertNotNull()
    // assertSame(), assertNotSame(), checking if two instances are the exact same instances, comparing object refs only
    // assertThat() comparing the actual value against a matcher


    // The Check box shown on the right within the specialized bottom left side of the terminal is a
    // toggles between showing all test or just the failed test

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