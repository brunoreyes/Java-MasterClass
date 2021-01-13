package com.company;

import static org.junit.jupiter.api.Assertions.*;
import static junit.framework.TestCase.fail;
import static junit.framework.TestCase.assertNull;

class UtilitiesTest {

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
        Utilities util = new Utilities();
        assertEquals("ABCDEF", util.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", util.removePairs("ABCCABDEEF"));
        assertNull("Did not get null returned when argument passed was null", util.removePairs(null));
        assertEquals("A", util.removePairs("A"));
        assertEquals("", util.removePairs(""));
    }

    @org.junit.jupiter.api.Test
    void converter() {
        Utilities util = new Utilities();
        assertEquals(300, util.converter(10, 5));
    }

    @org.junit.jupiter.api.Test
    void nullIfOddLength() {
        Utilities util = new Utilities();
        assertNull(util.nullIfOddLength("odd"));
        assertNotNull(util.nullIfOddLength("even"));
    }
}