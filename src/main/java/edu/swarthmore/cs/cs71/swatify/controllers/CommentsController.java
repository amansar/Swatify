package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.PublicActions.Comment;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class CommentsController {
//    public static Comment getComment(Request request, Response response) {
//        int id = Integer.parseInt(request.params("id"));
//        return HibernateUtil.getObjectById(Comment.class, id);
//    }
//
//    public static Comment createComment(Request request, Response response) {
//        String content = request.params("content");
//        int userId = Integer.parseInt(request.params("userId"));
//        int parentActionId = Integer.parseInt(request.params("parentActionId"));
//        Comment newComment = new Comment(content, userId, parentActionId);
//        HibernateUtil.saveObject(newComment);
//        return newComment;
//    }
//
//    public static void updateComment(Request request, Response response) {
//        int id = Integer.parseInt(request.params("id"));
//        String newContent = request.params("content");
//        Comment updatedComment = new Comment();
//        updatedComment.setContent(newContent);
//        updatedComment.setId(id);
//        HibernateUtil.updateObject( updatedComment );
//    }
//
//    public static void deleteComment(Request request, Response response) {
//        int id = Integer.parseInt(request.params("id"));
//        //TODO how to delete using hibernate?
//    }

    public CommentsController() {
        path("comments", () -> {
            get("/:id", (request, response) -> {
                int id = Integer.parseInt(request.params("id"));
                return HibernateUtil.getObjectById(Comment.class, id);
            }, GsonUtil::toJson);

            post("", (request, response) -> {
                Comment comment = GsonUtil.fromJson(Comment.class, request.body());
                return HibernateUtil.saveObject(comment);
            }, GsonUtil::toJson);

            patch("/:id", (request, response) -> {
                Comment comment = GsonUtil.fromJson(Comment.class, request.body());
                return HibernateUtil.updateObject(comment);
            }, GsonUtil::toJson);

            delete("/:id", (request, response) -> {
                int id = Integer.parseInt(request.params("id"));
                return HibernateUtil.deleteObject(Comment.class, id);
            }, GsonUtil::toJson);

            after((req, res) -> res.type("application/json"));

            exception(IllegalArgumentException.class, (e, req, res) -> {
                res.status(400);
            });

        });
    }
}