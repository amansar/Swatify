package edu.swarthmore.cs.cs71.swatify.errors;

import spark.Response;

public class InternalServerError extends Error {
    public InternalServerError(Response response, String message) {
        super(response, message);
    }

    @Override
    protected int getStatus() {
        return 500;
    }
}

