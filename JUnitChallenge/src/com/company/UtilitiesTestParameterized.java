package com.company;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilitiesTestParameterized {

    private static Utilities utilities;

    @BeforeAll
    static void setup() {
        utilities = new Utilities();
    }

    static Stream<Arguments> testConditioning() {
        return Stream.of(
                Arguments.of("ABCDEFF", "ABCDEF"),
                Arguments.of("AB88EFFG", "AB8EFG"),
                Arguments.of("112233445566", "123456"),
                Arguments.of("ZYZQQB", "ZYZQB"),
                Arguments.of("A", "A")
        );
    }

    @ParameterizedTest
    @MethodSource("testConditioning")
    void removePairs(String input, String output) {
        assertEquals(output, utilities.removePairs(input));
    }

}
