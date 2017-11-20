package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.Discussion;
import edu.swarthmore.cs.cs71.swatify.models.Post;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;

import static spark.Spark.*;

public class DiscussionsController {
    public DiscussionsController() {
        path("/discussions", () -> {
            get("/:id", (request, response) -> getDiscussion(Integer.parseInt(request.params("id"))), GsonUtil::toJson);

            post("", (request, response) -> createDiscussion(GsonUtil.fromJson(Discussion.class, request.body())),  GsonUtil::toJson);

            patch("/:id", (request, response) -> updateDiscussion(GsonUtil.fromJson(Discussion.class, request.body())), GsonUtil::toJson);

            delete("/:id", (request, response) -> deleteDiscussion(Integer.parseInt(request.params("id"))), GsonUtil::toJson);

            after((req, res) -> res.type("application/json"));

            exception(IllegalArgumentException.class, (e, req, res) -> {
                res.status(400);
            });
        });
    }

    public static Discussion getDiscussion(int id) { return HibernateUtil.getObjectById(Discussion.class, id); }

    public static boolean createDiscussion(Discussion discussion) {
        return HibernateUtil.saveObject(discussion);
    }

    public static boolean updateDiscussion(Discussion discussion) {
        return HibernateUtil.updateObject(discussion);
    }

    public static boolean deleteDiscussion(int id) {
        return HibernateUtil.deleteObject(Discussion.class, id);
    }
}
