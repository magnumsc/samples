package com.magnum.validators;

public class Text {
    public static boolean isEmpty(String text) {
        return text != null && !text.isEmpty();
    }
}
