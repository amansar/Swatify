package edu.swarthmore.cs.cs71.swatify.models;

import java.util.List;

public interface SearchResults {
    public abstract int numberOfResults();
    public abstract void printResults();
    public abstract List<TrackSearchResult> getResults();
}
