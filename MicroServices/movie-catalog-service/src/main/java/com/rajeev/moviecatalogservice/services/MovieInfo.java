package com.rajeev.moviecatalogservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rajeev.moviecatalogservice.models.CatalogItem;
import com.rajeev.moviecatalogservice.models.Movie;
import com.rajeev.moviecatalogservice.models.Rating;

@Service
public class MovieInfo {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackMovieCatalog")
    public CatalogItem getMovie(Rating rating) {
        Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/" + rating.getMovieId(),
                Movie.class);
        return new CatalogItem(movie.getMovieName(), movie.getDescription(), rating.getRating());
    }

    public CatalogItem getFallbackMovieCatalog(Rating rating) {

        return new CatalogItem("Movie Name not found ", "", rating.getRating());
    }

}
