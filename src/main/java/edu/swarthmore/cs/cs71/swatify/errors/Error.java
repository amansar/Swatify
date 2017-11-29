package edu.swarthmore.cs.cs71.swatify.errors;

public class Error {
    private int status;
    private String message;

    public Error(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
