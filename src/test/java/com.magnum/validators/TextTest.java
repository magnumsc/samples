package com.magnum.validators;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextTest {
    @Test
    void isEmptyReturnsTrueWhenTextIsNull() {
        assertTrue(Text.isEmpty(null));
    }

    @Test
    void isEmptyReturnsTrueWhenTextIsEmpty() {
        assertFalse(Text.isEmpty(""));
    }

    @Test
    void isEmptyReturnsFalseWhenTextIsNotEmpty() {
        assertTrue(Text.isEmpty("Hello"));
    }
}
