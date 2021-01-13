package com.company;

// To make class parameterized, annotate the whole class with @RunWith
// within @RunWith( type "Parameterized.class")
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
// to ensure the Parameterized annotation worked successfully, ensure 2 green arrows are on class initiation line
public class BankAccountParameterizedTest {
    private BankAccount account;
    @org.junit.jupiter.api.BeforeEach
    public void setup(){
        account = new BankAccount("Bruno", "Reyes", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test");
    }

    @Parameterized.Parameters // initiate each parameter using "@Parameterized.Parameters"
    public static List<Object[]> testConditions(){
        return Arrays.asList(new Object[][]{
                {100.00, true, 1100.00},
                {200.00, true, 1200.00},
                {325.14, true, 1325.14},
                {489.33, true, 1489.33},
                {1000.00, true, 2000.00}
        });
    }


}
