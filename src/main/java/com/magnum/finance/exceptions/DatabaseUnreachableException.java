package com.magnum.finance.exceptions;

public class DatabaseUnreachableException extends Exception {
    public DatabaseUnreachableException(String message) {
        super(message);
    }
    public DatabaseUnreachableException(String message, Throwable cause) {
        super(message, cause);
    }
}
