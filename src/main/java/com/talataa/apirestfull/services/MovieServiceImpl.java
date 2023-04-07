package com.talataa.apirestfull.services;

import com.talataa.apirestfull.models.GuestSessionResponse;
import com.talataa.apirestfull.models.Movie;
import com.talataa.apirestfull.models.RatingRequest;
import com.talataa.apirestfull.repositorys.interfaces.MovieRepository;
import com.talataa.apirestfull.services.interfaces.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<Object> getMovies(Integer page){

        List<Object> listMovies = movieRepository.findAll(page);

        return listMovies;

    }

    public Movie getDetailsMovie(Integer id){

        return movieRepository.findById(id);

    }

    public GuestSessionResponse getSession(){
        return movieRepository.getGuestSessionId();
    }

    public ResponseEntity setRatedMovie(RatingRequest ratingRequest, Integer id) {
        System.err.println("service");
        return movieRepository.ratedMovie(ratingRequest, id);

    }

    public List<Object> getRatedMovies(Integer page){

        List<Object> listMovies = movieRepository.findAllRateds(page);

        return listMovies;

    }
}
