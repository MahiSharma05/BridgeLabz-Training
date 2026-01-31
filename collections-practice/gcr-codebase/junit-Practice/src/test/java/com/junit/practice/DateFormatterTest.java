package com.junit.practice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DateFormatterTest {

    DateFormatter formatter = new DateFormatter();

    // Valid date
    @Test
    void testValidDate() {
        String result = formatter.formatDate("2024-01-15");
        assertEquals("15-01-2024", result);
    }

    // Invalid format
    @Test
    void testInvalidFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatDate("15-01-2024");
        });
    }

    // Invalid date value
    @Test
    void testInvalidDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatDate("2024-13-40");
        });
    }
}
