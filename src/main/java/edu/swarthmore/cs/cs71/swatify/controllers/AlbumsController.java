package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.Album;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;


import static spark.Spark.*;

public class AlbumsController {
    public AlbumsController() {
        path("/albums", () -> {
            get("/:id", (request, response) -> {
                int id = Integer.parseInt(request.params("id"));
                return HibernateUtil.getObjectById(Album.class, id);
            }, GsonUtil::toJson);

            post("", (request, response) -> {
                Album album = GsonUtil.fromJson(Album.class, request.body());
                return HibernateUtil.saveObject(album);
            }, GsonUtil::toJson);

            patch("/:id", (request, response) -> {
                Album album = GsonUtil.fromJson(Album.class, request.body());
                return HibernateUtil.updateObject(album);
            }, GsonUtil::toJson);

            delete("/:id", (request, response) -> {
                int albumId = Integer.parseInt(request.params("id"));
                return HibernateUtil.deleteObject(Album.class, albumId);
            }, GsonUtil::toJson);

            after((req, res) -> res.type("application/json"));

            exception(IllegalArgumentException.class, (e, req, res) -> {
                res.status(400);
            });

        });
    }
}
