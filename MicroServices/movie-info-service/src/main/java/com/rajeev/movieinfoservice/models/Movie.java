package com.rajeev.movieinfoservice.models;

public class Movie {
    private String movieId;
    private String movieName;
    private String description;
    
    public String getMovieId() {
        return movieId;
    }
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
    public String getMovieName() {
        return movieName;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public Movie(String movieId, String movieName, String description) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.description = description;
    }
    @Override
    public String toString() {
        return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", description=" + description + "]";
    }
    public Movie() {
    }
   
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
}
