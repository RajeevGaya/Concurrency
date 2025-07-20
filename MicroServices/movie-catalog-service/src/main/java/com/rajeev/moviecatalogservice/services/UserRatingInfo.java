package com.rajeev.moviecatalogservice.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rajeev.moviecatalogservice.models.Rating;
import com.rajeev.moviecatalogservice.models.UserRating;

@Service
public class UserRatingInfo {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackRating")
    public UserRating getRatings(String userId) {
        return restTemplate.getForObject("http://RATING-SERVICE/movies/users/" + userId,
                UserRating.class);
    }

    public UserRating getFallbackRating(String userId) {
        UserRating userRating = new UserRating();
        userRating.setUserId(userId);
        userRating.setRating(Arrays.asList(
                new Rating("0", 0)));
        return userRating;
    }
}
