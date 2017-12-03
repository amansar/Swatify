package edu.swarthmore.cs.cs71.swatify.controllers;
import edu.swarthmore.cs.cs71.swatify.models.Playlist;
import edu.swarthmore.cs.cs71.swatify.util.GsonUtil;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;

import static spark.Spark.*;

public class PlaylistController {
  public PlaylistController() {
    path("/playlists", () -> {
    });
  }
}
