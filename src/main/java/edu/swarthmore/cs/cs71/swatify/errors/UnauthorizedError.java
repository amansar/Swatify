package edu.swarthmore.cs.cs71.swatify.errors;

import spark.Response;

public class UnauthorizedError extends Error {
    public UnauthorizedError(String message) {
        super(message);
    }

    @Override
    protected int getStatus() {
        return 401;
    }
}

