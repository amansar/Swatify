package edu.swarthmore.cs.cs71.swatify.errors;

import spark.Response;

public abstract class Error {
    private String message;

    public Error(Response response, String message) {
        response.status(getStatus());
        this.message = message;
        response.body(message);
    }

    public String getMessage() {
        return this.message;
    }

    protected abstract int getStatus();
}
