package edu.swarthmore.cs.cs71.swatify.models;

import org.hibernate.annotations.DynamicUpdate;
import java.util.ArrayList;
import java.util.List;
import java.persistence.*;
import Track;

@Entity
@Table
@DynamicUpdate
public class Playlist{
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private String titleOfPlaylist;
  private String spotifyID;
  private int id;
  private boolean privacy;
  private int numberOfSongs;
  private Double lengthOfPlaylist;
 
  private List<Track> tracklist = new ArrayList<>();
}

public Playlist() { };

public boolean isPublic(){
  return this.privacy;
}

public void addTrack(Track track){
  if (this.tracklist.contains(track) != true) {
    this.tracklist.add(track);
    this.numberOfSongs = numberOfSongs + 1;
    this.lengthOfPlaylist = lengthOfPlaylist + track.getLengthOfTrack();
  }
}

public void removeTrack(Track track){
  if (this.tracklist.contains(track) == true) {
    this.tracklist.remove(track);
    this.numberOfSongs = numberOfSongs - 1;
    this.lengthOfPlaylist = lengthOfPlaylist - track.getLengthOfTrack();
  }
}

public ArrayList<Track> getPlaylist(){
  return tracklist;
}

public String getTitle(){
  return titleOfPlaylist;
}

public Double getLength(){
  return lengthOfPlaylist;
}

public String getSpotifyID() {
  return spotifyID;
}

public int getID() {
  return id;
}

public void setTitle(String title){
  this.titleOfPlaylist = tile;
}

public void setSpotifyID(String spotifyID){
  this.spotifyID = spotifyID;
}

public void setID(int id){
  this.id = id;
}

public void setPrivacy(boolean privacy){
  this.privacy = privacy;
}

public boolean contains(Track track){
  return tracklist.contains(track);
}

public void exportToSpotify(){
  return;
}
