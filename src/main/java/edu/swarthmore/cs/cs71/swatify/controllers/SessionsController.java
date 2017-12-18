package edu.swarthmore.cs.cs71.swatify.controllers;

import com.wrapper.spotify.models.AuthorizationCodeCredentials;
import edu.swarthmore.cs.cs71.swatify.controllers.hibernateRoutes.BaseRoute;
import edu.swarthmore.cs.cs71.swatify.errors.UnauthorizedError;
import edu.swarthmore.cs.cs71.swatify.models.User;
import edu.swarthmore.cs.cs71.swatify.util.SpotifyUtil;
import javafx.scene.effect.Light;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import static spark.Spark.*;

public class SessionsController {
    public SessionsController() {
        path("/spotify-auth", () -> {
            get("/authorize-url", ((request, response) -> {
                JSONObject jsonResponseBody = new JSONObject();
                jsonResponseBody.put("authorizeUrl", SpotifyUtil.getAuthorizeUrl());
                return jsonResponseBody.toString();
            }));

            get("/callback", new BaseRoute() {
                @Override
                protected Object doAction(Session session, Request request, Response response) {
                    String code = request.params("code");
                    AuthorizationCodeCredentials credentials = SpotifyUtil.getAcessCredentials(code);
                    if (credentials == null) {
                        return new UnauthorizedError("Unable to connect to Spotify");
                    }

                    CriteriaBuilder builder = session.getCriteriaBuilder();
                    CriteriaQuery<User> query = builder.createQuery(User.class);
                    Root<User> root = query.from(User.class);
                    query.select(root).where(builder.equal(root.get("spotifyRefreshToken"),
                                                           credentials.getRefreshToken()));
                    Query<User> q = session.createQuery(query);
                    User user = q.getSingleResult();

                    if (user == null) {
                    }
                    else {
                        request.session(true).attribute("user", user);
                    }

                    return null;
                }
            });
        });

        post("/logout", (request, response) -> {
            request.session().removeAttribute("user");
            return null;
        });
    }
}
