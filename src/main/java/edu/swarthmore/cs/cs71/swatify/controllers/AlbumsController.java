package edu.swarthmore.cs.cs71.swatify.controllers;

import com.wrapper.spotify.Api;
import com.wrapper.spotify.methods.AlbumRequest;
import com.wrapper.spotify.methods.ArtistRequest;
import com.wrapper.spotify.models.Artist;
import edu.swarthmore.cs.cs71.swatify.controllers.hibernateRoutes.BaseHibernateRoute;
import edu.swarthmore.cs.cs71.swatify.controllers.hibernateRoutes.CreateObjectHibernateRoute;
import edu.swarthmore.cs.cs71.swatify.controllers.spotifyRoutes.BaseSpotifyRoute;
import edu.swarthmore.cs.cs71.swatify.models.Review;
import edu.swarthmore.cs.cs71.swatify.models.User;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import edu.swarthmore.cs.cs71.swatify.util.SpotifyUtil;
import org.hibernate.Session;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class AlbumsController {
    public AlbumsController() {
        path("/albums", () -> {
            path("/:id", () -> {
                get("", new BaseSpotifyRoute() {
                    @Override
                    protected Object doAction(Api api, Request request, Response response) throws Exception {
                        return api.getAlbum(request.params("id"));
                    }
                });

                post("/reviews", new BaseHibernateRoute() {
                    @Override
                    protected Object doAction(Session session, Request request, Response response) {
                        JSONObject jsonBody = new JSONObject(request.body());
                        User user = session.get(User.class, jsonBody.getString("userId"));
                        return new Review(jsonBody.getString("content"),
                                          user,
                                          jsonBody.getString("albumId"),
                                          Integer.parseInt(jsonBody.getString("stars")));
                    }
                });
            });
        });
    }

    public static boolean createReview(Review review) {
        return HibernateUtil.saveObject(review);
    }
}
