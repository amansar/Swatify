package edu.swarthmore.cs.cs71.swatify.errors;

import spark.Response;

public abstract class Error {
    public Error(Response response, String message) {
        response.status(getStatus());
        response.body(message);
    }

    protected abstract int getStatus();
}
