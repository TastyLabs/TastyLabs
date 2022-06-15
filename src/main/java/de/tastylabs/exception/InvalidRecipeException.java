package de.tastylabs.exception;

public class InvalidRecipeException extends Exception{
    public InvalidRecipeException() {}

    public InvalidRecipeException(String message) {
        super(message);
    }

    public InvalidRecipeException(Throwable cause) {
        super(cause);
    }

    public InvalidRecipeException(String message, Throwable cause) {
        super(message, cause);
    }
}
