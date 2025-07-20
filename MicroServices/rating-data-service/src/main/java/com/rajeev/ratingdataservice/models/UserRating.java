package com.rajeev.ratingdataservice.models;

import java.util.List;

public class UserRating {
    private List<Rating> rating;
    private String userId;

    public List<Rating> getRating() {
        return rating;
    }

    public void setRating(List<Rating> rating) {
        this.rating = rating;
    }

    public UserRating(List<Rating> rating, String userId) {
        this.rating = rating;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserRating [rating=" + rating + ", userId=" + userId + "]";
    }

    public UserRating() {
    }

    public UserRating(List<Rating> rating) {
        this.rating = rating;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
}
