package com.rajeev.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
// import org.springframework.web.reactive.function.client.WebClient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import com.rajeev.moviecatalogservice.models.CatalogItem;
import com.rajeev.moviecatalogservice.models.Movie;
import com.rajeev.moviecatalogservice.models.Rating;
import com.rajeev.moviecatalogservice.models.UserRating;
import com.rajeev.moviecatalogservice.services.MovieInfo;
import com.rajeev.moviecatalogservice.services.UserRatingInfo;

@RestController()
@RequestMapping("/catalog")
public class MovieCatalogResource {

    // @Autowired
    // private RestTemplate restTemplate;

    @Autowired
    private MovieInfo movieInfo;

    @Autowired
    private UserRatingInfo userRatingInfo;

    // @Autowired
    // private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    // @HystrixCommand(fallbackMethod = "getFallbackCatalog")
    public List<CatalogItem> gCatalogItems(@PathVariable("userId") String userId) {

        // RestTemplate restTemplate = new RestTemplate();
        // WebClient.Builder builder = WebClient.builder();
        // UserRating ratings =
        // restTemplate.getForObject("http://localhost:8088/movies/users/" + userId,
        // UserRating.class);

        // UserRating ratings =
        // restTemplate.getForObject("http://RATING-SERVICE/movies/users/" + userId,
        // UserRating.class);

        // UserRating ratings = getRatings(userId);
         UserRating ratings = userRatingInfo.getRatings(userId);

        // List<Rating> ratings = Arrays.asList(
        // new Rating("101", 4),
        // new Rating("102", 5));

        return ratings.getRating().stream().map(
                rating -> {
                    // Movie movie = restTemplate.getForObject("http://localhost:8086/movies/" +
                    // rating.getMovieId(),
                    // Movie.class);

                    // Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/" +
                    // rating.getMovieId(),
                    // Movie.class);
return  movieInfo.getMovie(rating);
                    // return getMovie(rating);
                    // return new CatalogItem(movie.getMovieName(), movie.getDescription(),
                    // rating.getRating());
                    /*
                     * Movie movie = webClientBuilder.build()
                     * .get()
                     * .uri("http://localhost:8086/movies/" + rating.getMovieId())
                     * .retrieve()
                     * .bodyToMono(Movie.class)
                     * .block();
                     */

                }).collect(Collectors.toList());
        // return Collections.singletonList(new CatalogItem("Avenger", "R001", 4));
    }

    /*
     * @HystrixCommand(fallbackMethod = "getFallbackMovieCatalog")
     * private CatalogItem getMovie(Rating rating) {
     * Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/" +
     * rating.getMovieId(),
     * Movie.class);
     * return new CatalogItem(movie.getMovieName(), movie.getDescription(),
     * rating.getRating());
     * }
     * 
     * private CatalogItem getFallbackMovieCatalog(Rating rating) {
     * 
     * return new CatalogItem("Movie Name not found ", "", rating.getRating());
     * }
     */

    /* @HystrixCommand(fallbackMethod = "getFallbackRating")
    private UserRating getRatings(String userId) {
        return restTemplate.getForObject("http://RATING-SERVICE/movies/users/" + userId,
                UserRating.class);
    }

    private UserRating getFallbackRating(String userId) {
        UserRating userRating = new UserRating();
        userRating.setUserId(userId);
        userRating.setRating(Arrays.asList(
                new Rating("0", 0)));
        return userRating;
    } */

    // public List<CatalogItem> getFallbackCatalog(@PathVariable("userId") String
    // userId) {
    // return Arrays.asList(new CatalogItem("None", "userId", 0));
    // }
}