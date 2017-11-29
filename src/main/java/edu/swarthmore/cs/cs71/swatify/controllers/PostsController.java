package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.Post;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import spark.Request;
import spark.Response;

import java.util.List;

import static spark.Spark.*;

public class PostsController extends ControllerTemplate {
    public PostsController() {
        path("/posts", () -> {
            get("/:id", this::getObject);

            post("", this::createObject);

            patch("/:id", this::updateObject);

            delete("/:id", this::deleteObject);

            after((req, res) -> res.type("application/json"));

            exception(IllegalArgumentException.class, (e, req, res) -> res.status(400));
        });
    }

    @Override
    <T> T doCreateObject(Request request, Response response) {
        return null;
    }

    @Override
    <T> T doGetObject(Request request, Response response) {
        int id = Integer.parseInt(request.params("id"));
    }

    @Override
    <T> T doUpdateObject(Request request, Response response) {
        return null;
    }

    @Override
    void doDeleteObject(Request request, Response response) {

    }

    @Override
    <T> List<T> doListObjects(Request request, Response response) {
        return null;
    }
}