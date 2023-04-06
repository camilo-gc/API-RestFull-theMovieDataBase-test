package com.talataa.apirestfull.services.interfaces;

import com.talataa.apirestfull.models.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface MovieService {


    List<Object> getMovies(Integer page);

    Movie getDetailsMovie(Integer id);

}
