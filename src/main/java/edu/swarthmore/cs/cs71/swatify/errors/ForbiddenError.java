package edu.swarthmore.cs.cs71.swatify.errors;

public class ForbiddenError extends Error {
    private String message;

    public ForbiddenError(String message) {
        super(403, message);
    }
}
