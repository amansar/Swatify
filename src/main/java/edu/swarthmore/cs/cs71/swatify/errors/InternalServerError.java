package edu.swarthmore.cs.cs71.swatify.errors;

import spark.Response;

public class InternalServerError extends Error {
    public InternalServerError(String message) {
        super(message);
    }

    @Override
    protected int getStatus() {
        return 500;
    }
}

