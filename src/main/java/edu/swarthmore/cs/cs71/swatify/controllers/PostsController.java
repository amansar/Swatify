package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.Post;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class PostsController {
    public PostsController() {
        path("/posts", () -> {
            get("/:id", (request, response) -> getPost(Integer.parseInt(request.params("id"))), GsonUtil::toJson);

            post("", (request, response) -> createPost(GsonUtil.fromJson(Post.class, request.body())),  GsonUtil::toJson);

            patch("/:id", (request, response) -> updatePost(GsonUtil.fromJson(Post.class, request.body())), GsonUtil::toJson);

            delete("/:id", (request, response) -> deletePost(Integer.parseInt(request.params("id"))), GsonUtil::toJson);

            after((req, res) -> res.type("application/json"));

            exception(IllegalArgumentException.class, (e, req, res) -> {
                res.status(400);
            });
        });
    }

    public static Post getPost(int id) {
        return HibernateUtil.getObjectById(Post.class, id);
    }

    public static boolean createPost(Post post) {
        return HibernateUtil.saveObject(post);
    }

    public static boolean updatePost(Post post) {
        return HibernateUtil.updateObject(post);
    }

    public static boolean deletePost(int id) {
        return HibernateUtil.deleteObject(Post.class, id);
    }
}