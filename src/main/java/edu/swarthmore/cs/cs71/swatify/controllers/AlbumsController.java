package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.Album;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import spark.Request;
import spark.Response;

public class AlbumsController {

    public static Album getAlbum(Request request, Response response) {
        int albumId = Integer.parseInt(request.params("id"));
        return HibernateUtil.getObjectById(Album.class, albumId);
    }

    public static Album createAlbum(Request request, Response response) {
        return new Album();
    }

    public static Album deleteAlbum(Request request, Response response) {
        int id = Integer.parseInt(request.params("id"));
        return new Album();
    }

    public static Album updateAlbum(Request request, Response response) {
        int id = Integer.parseInt(request.params("id"));
        return new Album();
    }
}
