package com.emami.bibliotheque.util;

import org.junit.jupiter.api.Test;

import static com.emami.bibliotheque.util.StringUtil.REGEX;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringUtilTest {

    @Test
    void should_return_false_with_valid_input() {
        String valid = "Hello Boys";
        assertFalse(StringUtil.checkIfStringBoundariesAreInvalid(valid));
    }

    @Test
    void should_return_true_with_invalid_input_at_start() {
        String invalidStart = REGEX + "Hello";
        assertTrue(StringUtil.checkIfStringBoundariesAreInvalid(invalidStart));
    }

    @Test
    void should_return_true_with_invalid_input_at_end() {
        String invalidEnd = "Hello" + REGEX;
        assertTrue(StringUtil.checkIfStringBoundariesAreInvalid(invalidEnd));
    }

    @Test
    void should_return_true_with_invalid_input_at_sides() {
        String invalidOnSides = REGEX + "Hello" + REGEX;
        assertTrue(StringUtil.checkIfStringBoundariesAreInvalid(invalidOnSides));
    }
}