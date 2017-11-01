package edu.swarthmore.cs.cs71.swatify.controllers;

import spark.Request;
import spark.Response;

public class UsersController {
    public static String getUser(Request request, Response response) {
        int id = Integer.parseInt(request.params("id"));
        return "";
    }

    public static String createUser(Request request, Response response) {
        int id = Integer.parseInt(request.params("id"));
        return "";
    }

    public static String updateUser(Request request, Response response) {
        int id = Integer.parseInt(request.params("id"));
        return "";
    }

    public static String deleteUser(Request request, Response response) {
        int id = Integer.parseInt(request.params("id"));
        return "";
    }
}
