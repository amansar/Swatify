package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.Rating;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;

import static spark.Spark.*;

public class RatingsController {
    public RatingsController() {
        path("/Ratings", () -> {
            get("/:id", (request, response) -> getRating(Integer.parseInt(request.params("id"))), GsonUtil::toJson);

            post("", (request, response) -> createRating(GsonUtil.fromJson(Rating.class, request.body())),  GsonUtil::toJson);

            patch("/:id", (request, response) -> updateRating(GsonUtil.fromJson(Rating.class, request.body())), GsonUtil::toJson);

            delete("/:id", (request, response) -> deleteRating(Integer.parseInt(request.params("id"))), GsonUtil::toJson);

            after((req, res) -> res.type("application/json"));

            exception(IllegalArgumentException.class, (e, req, res) -> {
                res.status(400);
            });
        });
    }

    public static Rating getRating(int id) {
        return HibernateUtil.getObjectById(Rating.class, id);
    }

    public static boolean createRating(Rating Rating) {
        return HibernateUtil.saveObject(Rating);
    }

    public static boolean updateRating(Rating Rating) {
        return HibernateUtil.updateObject(Rating);
    }

    public static boolean deleteRating(int id) {
        return HibernateUtil.deleteObject(Rating.class, id);
    }
}
