package com.company;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;
import static junit.framework.TestCase.fail;
import static junit.framework.TestCase.assertNull;

class UtilitiesTest {
    private  Utilities util;

    @org.junit.jupiter.api.BeforeEach
    public void setup(){
        util = new Utilities();
    }

    @org.junit.jupiter.api.Test
    void everyNthChar() {
        Utilities util = new Utilities();
        char[] output = util.everyNthChar(new char[] {'h','e','l','l','o'}, 2);
        assertArrayEquals(new char[]{'e', 'l'}, output); // should be true
        char[] output2 = util.everyNthChar(new char[] {'h','e','l','l','o'}, 8);
        // should be entire contents of array because there isn't 8 chars.
        assertArrayEquals(new char[]{'h','e','l','l','o'}, output2);
    }

    @org.junit.jupiter.api.Test
    void removePairs() {
        assertEquals("ABCDEF", util.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", util.removePairs("ABCCABDEEF"));
        assertNull("Did not get null returned when argument passed was null", util.removePairs(null));
        assertEquals("A", util.removePairs("A"));
        assertEquals("", util.removePairs(""));
    }

    @org.junit.jupiter.api.Test
    void converter() {
        assertEquals(300, util.converter(10, 5));
    }

    @org.junit.jupiter.api.Test
    public void converter_arithmeticException(){
    Assertions.assertThrows(ArithmeticException.class, () -> {
        util.converter(10,0);
    });
    }

    @org.junit.jupiter.api.Test
    void nullIfOddLength() {
        assertNull(util.nullIfOddLength("odd"));
        assertNotNull(util.nullIfOddLength("even"));
    }
}