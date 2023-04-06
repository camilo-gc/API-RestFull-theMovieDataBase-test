package com.talataa.apirestfull.controllers;

import com.talataa.apirestfull.models.Movie;
import com.talataa.apirestfull.models.MovieResponse;
import com.talataa.apirestfull.services.interfaces.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-test/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getMovies(@RequestParam(name = "page", defaultValue = "1", required = false) int page){

        List<Object> listMovies = movieService.getMovies(page);

        if(listMovies.isEmpty()){
            return new ResponseEntity<>(new MovieResponse("404", "Not Found", listMovies), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new MovieResponse("200", "OK", listMovies), HttpStatus.OK);

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getDetailsMovie(@PathVariable("id") Integer id){

        List<Object> movie = new ArrayList<>();
        movie.add(movieService.getDetailsMovie(id));

        if(movie.isEmpty()){

            return new ResponseEntity<>(new MovieResponse("404", "Not Found", movie), HttpStatus.NOT_FOUND);

        }

        return new ResponseEntity<>(new MovieResponse("200", "OK", movie), HttpStatus.OK);
    }

}
