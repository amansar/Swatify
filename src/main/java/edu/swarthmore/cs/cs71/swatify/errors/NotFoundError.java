package edu.swarthmore.cs.cs71.swatify.errors;

import spark.Response;

public class NotFoundError extends Error {
    public NotFoundError(String message) {
        super(message);
    }

    @Override
    protected int getStatus() {
        return 404;
    }
}
