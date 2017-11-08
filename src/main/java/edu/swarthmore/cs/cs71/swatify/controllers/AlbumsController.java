package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.Album;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;


import static spark.Spark.*;

public class AlbumsController {
    public AlbumsController() {
        path("/Albums", () -> {
            get("/:id", (request, response) -> getAlbum(Integer.parseInt(request.params("id"))), GsonUtil::toJson);

            post("", (request, response) -> createAlbum(GsonUtil.fromJson(Album.class, request.body())),  GsonUtil::toJson);

            patch("/:id", (request, response) -> updateAlbum(GsonUtil.fromJson(Album.class, request.body())), GsonUtil::toJson);

            delete("/:id", (request, response) -> deleteAlbum(Integer.parseInt(request.params("id"))), GsonUtil::toJson);

            after((req, res) -> res.type("application/json"));

            exception(IllegalArgumentException.class, (e, req, res) -> {
                res.status(400);
            });
        });
    }

    public static Album getAlbum(int id) {
        return HibernateUtil.getObjectById(Album.class, id);
    }

    public static boolean createAlbum(Album Album) {
        return HibernateUtil.saveObject(Album);
    }

    public static boolean updateAlbum(Album Album) {
        return HibernateUtil.updateObject(Album);
    }

    public static boolean deleteAlbum(int id) {
        return HibernateUtil.deleteObject(Album.class, id);
    }
}
