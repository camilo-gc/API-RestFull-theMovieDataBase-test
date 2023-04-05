package com.talataa.apirestfull.services.interfaces;

import com.talataa.apirestfull.models.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface MovieService {

    /*
    List<Movie> getMovies();
    */
    Movie getDetailsMovie(Integer id);

}
