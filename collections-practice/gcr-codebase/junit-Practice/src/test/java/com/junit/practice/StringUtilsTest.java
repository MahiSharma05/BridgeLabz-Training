package com.junit.practice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringUtilsTest {

    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    void testReverse() {
        assertEquals("olleh", stringUtils.reverse("hello"));
    }

    @Test
    void testIsPalindrome_True() {
        assertTrue(stringUtils.isPalindrome("madam"));
    }

    @Test
    void testIsPalindrome_False() {
        assertFalse(stringUtils.isPalindrome("hello"));
    }

    @Test
    void testToUpperCase() {
        assertEquals("HELLO", stringUtils.toUpperCase("hello"));
    }
}