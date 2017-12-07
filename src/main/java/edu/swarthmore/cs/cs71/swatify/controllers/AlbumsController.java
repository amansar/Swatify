package edu.swarthmore.cs.cs71.swatify.controllers;

import com.wrapper.spotify.methods.AlbumRequest;
import com.wrapper.spotify.methods.ArtistRequest;
import com.wrapper.spotify.models.Artist;
import edu.swarthmore.cs.cs71.swatify.models.Album;
import edu.swarthmore.cs.cs71.swatify.models.Review;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import edu.swarthmore.cs.cs71.swatify.util.SpotifyUtil;


import static edu.swarthmore.cs.cs71.swatify.controllers.ArtistsController.getArtist;
import static spark.Spark.*;

public class AlbumsController {
    public AlbumsController() {
        path("/albums", () -> {
            get("/:id", (request, response) -> getSpotifyAlbum((request.params("id"))), GsonUtil::toJson);

            post("", (request, response) -> createAlbum(GsonUtil.fromJson(Album.class, request.body())),  GsonUtil::toJson);
            get("/artists/:id", (request, response) -> getArtist(request.params("id")), GsonUtil::toJson);

            post("/reviews", (request, response) -> createReview(GsonUtil.fromJson(Review.class, request.body())), GsonUtil::toJson);

            after((req, res) -> res.type("application/json"));

            exception(IllegalArgumentException.class, (e, req, res) -> {
                res.status(400);
            });
        });
        /*
        path("/albums/artists", () -> {
            get("albums/artists/:id", (request, response) -> getArtist(request.params("id")), GsonUtil::toJson);

        });
        */
    }

    public static com.wrapper.spotify.models.Album getSpotifyAlbum(String spotifyId){
        SpotifyUtil su = new SpotifyUtil();
        final AlbumRequest request = su.getSpotifyAPI().getAlbum(spotifyId).build();

        try {
            final com.wrapper.spotify.models.Album requestedAlbum = request.get();
            return requestedAlbum;
        } catch (Exception e) {
            System.out.println("Something went wrong!" + e.getMessage());
        }

        return new com.wrapper.spotify.models.Album();
    }

    public static Artist getArtist(String spotifyId){

        final ArtistRequest request = SpotifyUtil.getSpotifyAPI().getArtist(spotifyId).build();

        try{
            final Artist requestedArtist = request.get();

            return requestedArtist;

        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Something went wrong...");
            System.out.println(e.getMessage());
        }

        return new Artist();
    }

    public static boolean createAlbum(Album Album) {
        return HibernateUtil.saveObject(Album);
    }

    public static boolean createReview(Review review) {
        return HibernateUtil.saveObject(review);
    }
    public static boolean updateAlbum(Album Album) {
        return HibernateUtil.updateObject(Album);
    }

    public static boolean deleteAlbum(int id) {
        return HibernateUtil.deleteObject(Album.class, id);
    }
}
