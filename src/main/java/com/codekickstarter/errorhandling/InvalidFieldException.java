package com.codekickstarter.errorhandling;

public class InvalidFieldException extends IllegalArgumentException {

    private String field;

    public InvalidFieldException(String message, String field) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
