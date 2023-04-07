package com.talataa.apirestfull.repositorys;

import com.talataa.apirestfull.models.GuestSessionResponse;
import com.talataa.apirestfull.models.Movie;
import com.talataa.apirestfull.models.RatingRequest;
import com.talataa.apirestfull.repositorys.interfaces.MovieRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepositoryImpl implements MovieRepository{

    @Value("${tmdb.api.key}")
    private String apiKey;

    @Value("${tmdb.api.url}")
    private String apiUrl;

    private String guestSessionId;

    @Autowired
    private RestTemplate restTemplate;


    public GuestSessionResponse getGuestSessionId(){

        String url = String.format("%s/authentication/guest_session/new?api_key=%s", apiUrl, apiKey);

        GuestSessionResponse guestSessionResponse = restTemplate.getForObject(url, GuestSessionResponse.class);
        guestSessionId = guestSessionResponse.getGuest_session_id();

        return guestSessionResponse;
    }


    /**
     *
     * @param page
     * @return list of movies by page
     */
    public List<Object> findAll(Integer page){

        List<Object> movies = new ArrayList<>();
        String url = String.format("%s/discover/movie?api_key=%s&page=%d", apiUrl, apiKey, page);

        try {

            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            JSONObject json = new JSONObject(response.getBody());
            JSONArray resultsArray = json.getJSONArray("results");

            movies = resultsArray.toList();

        } catch (HttpClientErrorException e) {

            System.err.println(e.getMessage());

        }

        return movies;

    }


    /**
     *
     * @return movies of all pages
     */

    public List<Object> findAll(){

        List<Object> listMovies = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {

            String url = String.format("%s/discover/movie?api_key=%s&page=%d", apiUrl, apiKey, i);
            System.err.println("URL: " + url);

            try {

                ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
                JSONObject json = new JSONObject(response.getBody());
                JSONArray resultsArray = json.getJSONArray("results");

                List movies = resultsArray.toList();

                listMovies.addAll(movies);

            } catch (HttpClientErrorException e) {

                System.err.println(e.getMessage());

            }
        }

        return listMovies;

    }


    public Movie findById(Integer id){

        Movie movie = null;
        String url = String.format("%s/movie/%d?api_key=%s", apiUrl, id, apiKey);

        try {

            movie =  restTemplate.getForEntity(url, Movie.class).getBody();

        }catch (HttpClientErrorException e) {
            System.err.println(e.getMessage());
        }

        return movie;
    }


    public ResponseEntity ratedMovie(RatingRequest ratingRequest, Integer id){

        String url = String.format("%s/movie/%d/rating?api_key=%s&guest_session_id=%s", apiUrl, id, apiKey, guestSessionId);

        try {

            return restTemplate.postForEntity(url, ratingRequest, Object.class);

        }catch (HttpClientErrorException e) {

            return new ResponseEntity<>("", e.getStatusCode());

        }

    }


    public List<Object> findAllRateds(Integer page){

        List<Object> movies = new ArrayList<>();
        String url = String.format("%s/guest_session/%s/rated/movies?api_key=%s&page=%d", apiUrl, guestSessionId, apiKey, page);
        System.err.println("URL RATEDMOVIES: " + url);
        try {

            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            JSONObject json = new JSONObject(response.getBody());
            JSONArray resultsArray = json.getJSONArray("results");

            movies = resultsArray.toList();

            System.err.println(movies.toString());

        } catch (HttpClientErrorException e) {

            System.err.println(e.getMessage());

        }

        return movies;

    }


}
