package edu.swarthmore.cs.cs71.swatify.controllers;

import com.wrapper.spotify.methods.AlbumRequest;
import edu.swarthmore.cs.cs71.swatify.models.Album;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import edu.swarthmore.cs.cs71.swatify.util.SpotifyUtil;


import static spark.Spark.*;

public class AlbumsController {
    public AlbumsController() {
        path("/albums", () -> {
            get("/:id", (request, response) -> getSpotifyAlbum((request.params("id"))), GsonUtil::toJson);

            post("", (request, response) -> createAlbum(GsonUtil.fromJson(Album.class, request.body())),  GsonUtil::toJson);

            patch("/:id", (request, response) -> updateAlbum(GsonUtil.fromJson(Album.class, request.body())), GsonUtil::toJson);

            delete("/:id", (request, response) -> deleteAlbum(Integer.parseInt(request.params("id"))), GsonUtil::toJson);

            after((req, res) -> res.type("application/json"));

            exception(IllegalArgumentException.class, (e, req, res) -> {
                res.status(400);
            });
        });
    }

    public static com.wrapper.spotify.models.Album getSpotifyAlbum(String spotifyId){
        SpotifyUtil su = new SpotifyUtil();
        final AlbumRequest request = su.getSpotifyAPI().getAlbum(spotifyId).build();
        System.out.println("ASDASDASDAS");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        com.wrapper.spotify.models.Album testAlbum = null;

        try {
            final com.wrapper.spotify.models.Album requestedAlbum = request.get();
            System.out.println(requestedAlbum);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            testAlbum = requestedAlbum;
            return requestedAlbum;
        } catch (Exception e) {
            System.out.println("Something went wrong!" + e.getMessage());
        }

        return testAlbum;
    }
    /*may not need this if we decide not to use album model
    public static Album getAlbum(int id) {
        return HibernateUtil.getObjectById(Album.class, id);
    }
    */

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
