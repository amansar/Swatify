package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.controllers.hibernateRoutes.*;
import edu.swarthmore.cs.cs71.swatify.models.Post;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class PostsController {
    public PostsController() {
        path("/posts", () -> {
            get("/:id", new GetObjectHibernateRoute() {
                @Override
                protected Class<?> getObjectClass() {
                    return Post.class;
                }
            });

            post("", new CreateObjectHibernateRoute() {
                @Override
                protected Object createObject(Request request, Response response) {
                    return GsonUtil.fromJson(Post.class, request.body());
                }
            });

            put("/:id", new UpdateObjectHibernateRoute() {
                @Override
                protected Object createUpdatedObject(Request request, Response response) {
                    return GsonUtil.fromJson(Post.class, request.body());
                }
            });

            delete("/:id", new DeleteObjectHibernateRoute() {
                @Override
                protected Class<?> getObjectClass() {
                    return Post.class;
                }
            });

            get("", new ListObjectsHibernateRoute() {
                @Override
                protected Class<?> getObjectClass() {
                    return Post.class;
                }
            });
        });
    }
}