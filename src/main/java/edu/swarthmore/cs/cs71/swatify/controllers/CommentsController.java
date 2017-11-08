package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.Comment;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class CommentsController {
    public CommentsController() {
        path("/comments", () -> {
            get("/:id", (request, response) -> getComment(Integer.parseInt(request.params("id"))), GsonUtil::toJson);

            post("", (request, response) -> createComment(GsonUtil.fromJson(Comment.class, request.body())),  GsonUtil::toJson);

            patch("/:id", (request, response) -> updateComment(GsonUtil.fromJson(Comment.class, request.body())), GsonUtil::toJson);

            delete("/:id", (request, response) -> deleteComment(Integer.parseInt(request.params("id"))), GsonUtil::toJson);

            after((req, res) -> res.type("application/json"));

            exception(IllegalArgumentException.class, (e, req, res) -> {
                res.status(400);
            });
        });
    }

    public static Comment getComment(int id) {
        return HibernateUtil.getObjectById(Comment.class, id);
    }

    public static Comment createComment(Comment comment) {
        return HibernateUtil.saveObject(comment);
    }

    public static Comment updateComment(Comment comment) {
        return HibernateUtil.updateObject(comment);
    }

    public static Comment deleteComment(int id) {
        return HibernateUtil.deleteObject(Comment.class, id);
    }

}