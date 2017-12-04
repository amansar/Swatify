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
            get("/:id", new GetObjectRoute() {
                @Override
                protected Class<?> getObjectClass() {
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("doing action");
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    return Post.class;
                }
            });

            post("", new CreateObjectRoute() {
                @Override
                protected Object createObject(Request request, Response response) {
                    return GsonUtil.fromJson(Post.class, request.body());
                }
            });

            patch("/:id", new UpdateObjectRoute() {
                @Override
                protected Object createUpdatedObject(Request request, Response response) {
                    return GsonUtil.fromJson(Post.class, request.body());
                }
            });

            delete("/:id", new DeleteObjectRoute() {
                @Override
                protected Class<?> getObjectClass() {
                    return Post.class;
                }
            });

            get("", new ListObjectsRoute() {
                @Override
                protected Class<?> getObjectClass() {
                    return Post.class;
                }
            });
        });
    }
}