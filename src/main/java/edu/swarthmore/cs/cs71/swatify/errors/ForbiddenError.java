package edu.swarthmore.cs.cs71.swatify.errors;

public class NotFoundError extends Error {
    private String message;

    public NotFoundError(String message) {
        super(404, message);
    }
}
