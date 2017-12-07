package edu.swarthmore.cs.cs71.swatify.errors;

import spark.Response;

public abstract class Error {
    private String message;

    public Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    protected abstract int getStatus();
}
