package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.Artist;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;


import static spark.Spark.*;

public class ArtistsController {
    public ArtistsController() {
        path("/artists", () -> {
            get("/:id", (request, response) -> getArtist(Integer.parseInt(request.params("id"))), GsonUtil::toJson);
            post("/:id", (request, response) -> createArtist(GsonUtil.fromJson(Artist.class, request.body())), GsonUtil::toJson);
            delete("/:id", (request, response) -> deleteArtist(Integer.parseInt(request.params("id"))));
            patch("/:id", (request, response) -> updateArtist(GsonUtil.fromJson(Artist.class, request.body())), GsonUtil::toJson);
            exception(IllegalArgumentException.class, (e, request, response) -> {
                response.status(400);
            });
        });
    }

    public static Artist getArtist(int id){
        return HibernateUtil.getObjectById(Artist.class, id);
    }

    public static boolean createArtist(Artist artist) {
        return HibernateUtil.saveObject(artist);
    }

    public static boolean deleteArtist(int id){
        return HibernateUtil.deleteObject(Artist.class, id);
    }

    public static boolean updateArtist(Artist artist){
        return HibernateUtil.updateObject(artist);
    }

}
