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



//@RunWith(Parameterized.class)

// to ensure the Parameterized annotation worked successfully, ensure 2 green arrows are on class initiation line
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;




// JUnit 5 doesn't require @RunWith or @ExtendWith to run parameterized tests
// https://www.baeldung.com/parameterized-tests-junit-5
public class BankAccountParameterizedTest {
    private BankAccount account;

    @BeforeEach
    public void setup() {
        account = new BankAccount("Bruno", "Reyes", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    private static Stream<Arguments> depositTestParameters() {
        return Stream.of(
                Arguments.of(100.00, 1100.00),
                Arguments.of(200.00, 1200.00),
                Arguments.of(325.14, 1325.14),
                Arguments.of(489.33, 1489.33),
                Arguments.of(1000.00, 2000.00)
        );
    }

    @ParameterizedTest
    @MethodSource("depositTestParameters")
    void deposit(double deposit, double expected) {
        double balance = account.deposit(deposit, true);
        assertEquals(expected, balance, .01);
    }
}