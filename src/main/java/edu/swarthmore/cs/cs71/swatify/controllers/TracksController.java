package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.Track;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;

import static spark.Spark.*;

public class TracksController {

    public TracksController() {
        path("/Tracks", () -> {
            get("/:id", (request, response) -> getTrack(Integer.parseInt(request.params("id"))), GsonUtil::toJson);

            post("", (request, response) -> createTrack(GsonUtil.fromJson(Track.class, request.body())),  GsonUtil::toJson);

            patch("/:id", (request, response) -> updateTrack(GsonUtil.fromJson(Track.class, request.body())), GsonUtil::toJson);

            delete("/:id", (request, response) -> deleteTrack(Integer.parseInt(request.params("id"))), GsonUtil::toJson);

            after((req, res) -> res.type("application/json"));

            exception(IllegalArgumentException.class, (e, req, res) -> {
                res.status(400);
            });
        });
    }

    public static Track getTrack(int id) {
        return HibernateUtil.getObjectById(Track.class, id);
    }

    public static Track createTrack(Track Track) {
        return HibernateUtil.saveObject(Track);
    }

    public static Track updateTrack(Track Track) {
        return HibernateUtil.updateObject(Track);
    }

    public static Track deleteTrack(int id) {
        return HibernateUtil.deleteObject(Track.class, id);
    }
}
