package com.talataa.apirestfull.controllers;

import com.talataa.apirestfull.models.Movie;
import com.talataa.apirestfull.models.MovieResponse;
import com.talataa.apirestfull.services.interfaces.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-test/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

/*
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Movie>> getMovies(){

        List<Movie> listMovies = movieService.getMovies();

        return new ResponseEntity<>(listMovies, HttpStatus.OK);

    }
*/
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getDetailsMovie(@PathVariable("id") Integer id){

        Movie movie = movieService.getDetailsMovie(id);

        if(movie == null){

            return new ResponseEntity<>(new MovieResponse("404", "Not Found", movie), HttpStatus.NOT_FOUND);

        }

        return new ResponseEntity<>(new MovieResponse("200", "OK", movie), HttpStatus.OK);
    }

}
