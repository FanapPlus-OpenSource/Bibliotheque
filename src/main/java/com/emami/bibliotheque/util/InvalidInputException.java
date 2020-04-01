package com.emami.bibliotheque.util;

public class InvalidInputException extends RuntimeException {
    @Override
    public String getMessage() {
        return "String must start or end with an alphabet or number";
    }
}
