package com.rajeev.movieinfoservice.models;

public class MovieSummary {
    private String id;
    private String title;
    private String overview;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getOverview() {
        return overview;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }
    @Override
    public String toString() {
        return "MovieSummary [id=" + id + ", title=" + title + ", overview=" + overview + "]";
    }
    public MovieSummary() {
    }
    public MovieSummary(String id, String title, String overview) {
        this.id = id;
        this.title = title;
        this.overview = overview;
    }

    
}
