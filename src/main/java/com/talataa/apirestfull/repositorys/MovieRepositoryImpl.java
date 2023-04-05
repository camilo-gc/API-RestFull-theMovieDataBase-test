package com.talataa.apirestfull.repositorys;

import com.talataa.apirestfull.models.Movie;
import com.talataa.apirestfull.repositorys.interfaces.MovieRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class MovieRepositoryImpl implements MovieRepository{

    @Value("${tmdb.api.key}")
    private String apiKey;

    @Value("${tmdb.api.url}")
    private String apiUrl;

    private RestTemplate restTemplate;

    public MovieRepositoryImpl() {
        this.restTemplate = new RestTemplate();
    }

    /*
    public List<Movie> findAll(){

        List<Movie> listMovies = null;//restTemplate.getForEntity(apiUrl+)

        return listMovies;
    }
    */

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

}
