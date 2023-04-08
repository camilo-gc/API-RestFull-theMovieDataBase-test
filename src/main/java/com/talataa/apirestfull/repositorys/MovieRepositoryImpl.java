package com.talataa.apirestfull.repositorys;

import com.talataa.apirestfull.models.Movie;
import com.talataa.apirestfull.repositorys.interfaces.MovieRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
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

    @Autowired
    private RestTemplate restTemplate;


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

        String url = String.format("%s/movie/%d?api_key=%s", apiUrl, id, apiKey);

        try {

            return restTemplate.getForEntity(url, Movie.class).getBody();

        }catch (HttpClientErrorException e) {

            System.err.println(e.getMessage());
            return null;
        }
    }


    public ResponseEntity sendRated(Object ratingRequest, Integer id, String guestSessionId){

        String url = String.format("%s/movie/%d/rating?api_key=%s&guest_session_id=%s", apiUrl, id, apiKey, guestSessionId);

        try {

            return restTemplate.postForEntity(url, ratingRequest, Object.class);

        }catch (HttpClientErrorException e) {

            return new ResponseEntity<>("", e.getStatusCode());

        }
    }


    public List<Object> findAllRatings(String guestSessionId, Integer page){

        String url = String.format("%s/guest_session/%s/rated/movies?api_key=%s&page=%d", apiUrl, guestSessionId, apiKey, page);

        try {

            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            JSONObject json = new JSONObject(response.getBody());
            JSONArray resultsArray = json.getJSONArray("results");

            return resultsArray.toList();

        } catch (HttpClientErrorException e) {

            System.err.println(e.getMessage());
            return new ArrayList<>();
        }
    }


    public ResponseEntity deleteRated(Integer id, String guestSessionId){

        String url = String.format("%s/movie/%d/rating?api_key=%s&guest_session_id=%s", apiUrl, id, apiKey, guestSessionId);

        try {

            return restTemplate.exchange(url, HttpMethod.DELETE, null, Object.class);

        }catch (HttpClientErrorException e) {

            return new ResponseEntity<>("", e.getStatusCode());

        }
    }

}
