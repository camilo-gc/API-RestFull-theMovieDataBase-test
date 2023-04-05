package com.talataa.apirestfull.services;

import com.talataa.apirestfull.models.Movie;
import com.talataa.apirestfull.repositorys.interfaces.MovieRepository;
import com.talataa.apirestfull.services.interfaces.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    /*
    public List<Movie> getMovies(){
        System.err.println("getMovies");
        List<Movie> listMovies = movieRepository.findAll().stream().limit(20).collect(Collectors.toList());

        return listMovies;

    }
    */
    public Movie getDetailsMovie(Integer id){

        return movieRepository.findById(id);

    }

}
