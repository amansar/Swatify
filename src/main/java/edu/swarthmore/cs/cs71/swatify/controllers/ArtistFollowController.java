package edu.swarthmore.cs.cs71.swatify.controllers;

import edu.swarthmore.cs.cs71.swatify.models.ArtistFollow;
import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;

public class ArtistFollowController {

    public ArtistFollowController() {

    }

    public static boolean saveArtistFollow(ArtistFollow follow) {
        return HibernateUtil.saveObject(follow);

    }

    public static boolean removeArtistFollow(ArtistFollow follow) {
        return HibernateUtil.deleteObject(ArtistFollow.class, follow.getId());
    }


    public static ArtistFollow getArtistFollow(int id) {
        return HibernateUtil.getObjectById(ArtistFollow.class, id);
    }
}
