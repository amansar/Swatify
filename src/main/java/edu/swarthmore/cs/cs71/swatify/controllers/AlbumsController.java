package edu.swarthmore.cs.cs71.swatify.controllers;

import com.wrapper.spotify.methods.AlbumRequest;
import com.wrapper.spotify.methods.ArtistRequest;
import com.wrapper.spotify.models.Artist;
import edu.swarthmore.cs.cs71.swatify.controllers.hibernateRoutes.*;
import edu.swarthmore.cs.cs71.swatify.models.Post;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import edu.swarthmore.cs.cs71.swatify.util.SpotifyUtil;
import spark.Request;
import spark.Response;


import static spark.Spark.*;

public class AlbumsController {
    public AlbumsController() {
        //TODO make changes here
        /*
        path("/albums", () -> {
            path("/:id", () -> {
                get("", (request, response) -> getSpotifyAlbum((request.params("id"))), GsonUtil::toJson);

                path("/reviews", () -> {
                    get("/:reviewId", new GetObjectHibernateRoute() {
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

                    put("/:reviewId", new UpdateObjectHibernateRoute() {
                        @Override
                        protected Object createUpdatedObject(Request request, Response response) {
                            return GsonUtil.fromJson(Post.class, request.body());
                        }
                    });

                    delete("/:postId", new DeleteObjectHibernateRoute() {
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
            });


            post("", (request, response) -> createAlbum(GsonUtil.fromJson(Album.class, request.body())),  GsonUtil::toJson);
            get("/artists/:id", (request, response) -> getArtist(request.params("id")), GsonUtil::toJson);
            after((req, res) -> res.type("application/json"));

            exception(IllegalArgumentException.class, (e, req, res) -> {
                res.status(400);
            });


        });
        path("/albums/artists", () -> {
            get("albums/artists/:id", (request, response) -> getArtist(request.params("id")), GsonUtil::toJson);

        });
        */
    }
}
