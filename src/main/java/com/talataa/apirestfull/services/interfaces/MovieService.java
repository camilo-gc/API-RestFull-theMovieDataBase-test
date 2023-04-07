package com.talataa.apirestfull.services.interfaces;

import com.talataa.apirestfull.models.GuestSessionResponse;
import com.talataa.apirestfull.models.Movie;
import com.talataa.apirestfull.models.RatingRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MovieService {


    List<Object> getMovies(Integer page);

    Movie getDetailsMovie(Integer id);

    GuestSessionResponse getSession();

    ResponseEntity setRatedMovie(RatingRequest ratingRequest, Integer id);

    List<Object> getRatedMovies(Integer page);

    ResponseEntity deleteRatedMovie(Integer id);
}
