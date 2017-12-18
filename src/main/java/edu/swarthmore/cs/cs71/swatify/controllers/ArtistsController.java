package edu.swarthmore.cs.cs71.swatify.controllers;

import com.wrapper.spotify.Api;
import edu.swarthmore.cs.cs71.swatify.controllers.spotifyRoutes.BaseSpotifyRoute;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class ArtistsController {
    public ArtistsController() {
        path("/artists", () -> {
            path("/:id", () -> {
                get("", new BaseSpotifyRoute() {
                    @Override
                    protected Object doAction(Api api, Request request, Response response) throws Exception {
                        return api.getArtist(request.params("id")).build().get();
                    }
                });
            });
        });
    }
}
