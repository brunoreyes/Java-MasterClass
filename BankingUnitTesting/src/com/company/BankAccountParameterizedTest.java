package com.company;

// To make class parameterized, annotate the whole class with @RunWith
// within @RunWith( type "Parameterized.class")
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;


import static junit.framework.TestCase.assertEquals;

//@RunWith(Parameterized.class)

// to ensure the Parameterized annotation worked successfully, ensure 2 green arrows are on class initiation line
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountParameterizedTest {

    private BankAccount account;

    @BeforeEach
    public void setup() {
        account = new BankAccount("Bruno", "Reyes", 1000.00, BankAccount.CHECKING);
        System.out.println("This executes before each parameterized test case.");
    }

    public static Stream<Arguments> testConditions() {
        return Stream.of(
                Arguments.of( 100.00, true, 1100.00 ),
                Arguments.of( 200.00, true, 1200.00 ),
                Arguments.of( 325.14, true, 1325.14 ),
                Arguments.of( 489.33, true, 1489.33 ),
                Arguments.of( 1000.00, true, 2000.00 )
        );
    }

    // Test 4 will fail on double precision if delta is zero.
    // So make delta 0.01
    // Expected :1325.14
    // Actual   :1325.1399999999999
    @ParameterizedTest(name = "Run {index}: deposit={0}, branch={1}, expected={2}")
    @MethodSource("testConditions")
    void deposit(double amount, boolean branch, double expected) {
        double balance = account.deposit(amount, branch);
        assertEquals(expected, balance, .01);
    }
}