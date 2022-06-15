package de.tastylabs.exception;

public class RecipeNotFoundException extends Exception {
    public RecipeNotFoundException() {}

    public RecipeNotFoundException(String message) {
        super(message);
    }

    public RecipeNotFoundException(Throwable cause) {
        super(cause);
    }

    public RecipeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
