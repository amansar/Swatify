package edu.swarthmore.cs.cs71.swatify.models;

import edu.swarthmore.cs.cs71.swatify.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArtistTest {

    @Test
    public void createArtist() throws Exception {
        Artist tribeCalledQuest = new Artist("A Tribe Called Quest", "09hVIj6vWgoCDtT03h8ZCa");
        assertEquals("A Tribe Called Quest", tribeCalledQuest.getName());
        assertEquals("09hVIj6vWgoCDtT03h8ZCa", tribeCalledQuest.getSpotifyId());
    }

    @Test
    public void addArtistsToDatabase() throws Exception {

        Artist tribeCalledQuest = new Artist("A Tribe Called Quest", "09hVIj6vWgoCDtT03h8ZCa");
        HibernateUtil.saveObject(tribeCalledQuest);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Artist retrievedArtist = (Artist) session.get(Artist.class, 1);

        assertEquals(tribeCalledQuest.getName(), retrievedArtist.getName());
        assertEquals(tribeCalledQuest.getSpotifyId(), retrievedArtist.getSpotifyId());

    }
}
