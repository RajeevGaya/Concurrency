package com.rajeev.ratingdataservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajeev.ratingdataservice.models.Rating;
import com.rajeev.ratingdataservice.models.UserRating;

@RestController
@RequestMapping("/movies")
public class RatingResource {
     
    
    @GetMapping("/{movieId}")
    public Rating getMovieRating(@PathVariable String movieId){
        return new Rating(movieId, 4);
    }

    @GetMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable String userId){
        List<Rating> ratings = Arrays.asList(
                new Rating("101", 4),
                new Rating("102", 5));
        UserRating userRating = new UserRating();
        userRating.setRating(ratings);
        return userRating;
        // return new Rating("101", 4);
    }

}
