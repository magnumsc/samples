package com.magnum.validators;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextTest {
    @Test
    void isEmpty_returnsTrue_whenTextIsNull() {
        assertTrue(Text.isEmpty(null));
    }

    @Test
    void isEmpty_returnsTrue_whenTextIsEmpty() {
        assertFalse(Text.isEmpty(""));
    }

    @Test
    void isEmpty_returnsFalse_whenTextIsNotEmpty() {
        assertTrue(Text.isEmpty("Hello"));
    }
}
