package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.controllers.hibernateRoutes.BaseRoute;
import edu.swarthmore.cs.cs71.swatify.util.SpotifyUtil;
import org.hibernate.Session;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class SessionsController {
    public SessionsController() {
        path("/spotify-auth", () -> {
            get("/authorize-url", ((request, response) -> {
                JSONObject jsonResponseBody = new JSONObject();
                jsonResponseBody.put("authorizeUrl", SpotifyUtil.getAuthorizeUrl());
                return jsonResponseBody.toString();
            }));

            get("/callback", ((request, response) -> {
                String code = request.params("code");
                return new JSONObject().toString();
            }));
        });

        post("/login", new BaseRoute() {
            @Override
            protected Object doAction(Session session, Request request, Response response) {
                return null;
            }
        });
    }
}
