//package edu.swarthmore.cs.cs71.swatify.controllers;
//import edu.swarthmore.cs.cs71.swatify.models.Playlist;
//import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
//import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
//
//import static spark.Spark.*;
//
//public class PlaylistController {
//  public PlaylistController() {
//    path("/playlist", () -> {
//      get("/:id", (request, response) -> getTrack(Integer.parseInt(request.params("id"))), GsonUtil::toJson);
//
//      post("", (request, response) -> createPlaylist(Playlist.class, request.body()), GsonUtil::toJson);
//
//      patch("/:id", (request, response) -> updatePlaylist(GsonUtil.fromJson(Playlist.class, request.body())), GsonUtil::toJson);
//
//      delete("/:id", (request, response) -> deletePlaylist(Integer.parseInt(request.params("id"))), GsonUtil::toJson);
//
//      after((req, res) -> res.type("application/json"));
//
//      exception(IllegalArgumentException.class, (e, req, res) -> {
//        res.status(400);
//      });
//    });
//  }
//
//  public static Playlist getPlaylist(int id) {
//    return HibernateUtil.getObjectById(Playlist.class, id);
//  }
//
//  public static boolean createPlaylist(Playlist Playlist){
//    return HibernateUtil.saveObject(Playlist);
//  }
//
//  public static boolean updatePlaylist(Playlist Playlist){
//    return HibernateUtil.updateObject(Playlist);
//  }
//
//  public static boolean deletePlaylist(int id){
//    return HibernateUtil.deleteObject(Playlist.class, id);
//  }
//}
