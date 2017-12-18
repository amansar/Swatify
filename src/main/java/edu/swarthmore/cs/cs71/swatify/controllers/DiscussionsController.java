package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.controllers.hibernateRoutes.*;
import edu.swarthmore.cs.cs71.swatify.models.Discussion;
import edu.swarthmore.cs.cs71.swatify.models.Post;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class DiscussionsController {
    public DiscussionsController() {
        path("/discussions", () -> {
            path("/:id", () -> {
                get("", new GetObjectRoute() {
                    @Override
                    protected Class<?> getObjectClass() {
                        return Discussion.class;
                    }
                });

                put("", new UpdateObjectRoute() {
                    @Override
                    protected Object createUpdatedObject(Request request, Response response) {
                        return GsonUtil.fromJson(Discussion.class, request.body());
                    }
                });

                delete("", new DeleteObjectRoute() {
                    @Override
                    protected Class<?> getObjectClass() {
                        return Discussion.class;
                    }
                });

                // /:id/posts
                // "" getAll
                //
                path("/posts", () -> {
                    get("/:postId", new GetObjectRoute() {
                        @Override
                        protected Class<?> getObjectClass() {
                            return Post.class;
                        }
                        @Override
                        protected String getIdParamName() {
                            return "postId";
                        }

                    });

                    post("", new CreateObjectRoute() {
                        @Override
                        protected Object createObject(Request request, Response response) {
                            return GsonUtil.fromJson(Post.class, request.body());
                        }
                    });

                    put("/:postId", new UpdateObjectRoute() {
                        @Override
                        protected Object createUpdatedObject(Request request, Response response) {
                            return GsonUtil.fromJson(Post.class, request.body());
                        }
                    });

                    delete("/:postId", new DeleteObjectRoute() {
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

            });
        });

        post("", new CreateObjectRoute() {
            @Override
            protected Object createObject(Request request, Response response) {
                return GsonUtil.fromJson(Discussion.class, request.body());
            }
        });

        get("", new ListObjectsRoute() {
            @Override
            protected Class<?> getObjectClass() {
                return Discussion.class;
            }
        });

        exception(IllegalArgumentException.class, (e, req, res) -> {
            res.status(400);
        });
    }

}
