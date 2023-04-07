package com.talataa.apirestfull.repositorys.interfaces;

import com.talataa.apirestfull.models.GuestSessionResponse;
import com.talataa.apirestfull.models.Movie;
import com.talataa.apirestfull.models.RatingRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository {

    List<Object> findAll(Integer page);

    List<Object> findAll();

    Movie findById(Integer id);

    GuestSessionResponse getGuestSessionId();


    ResponseEntity ratedMovie(RatingRequest ratingRequest, Integer id);

    List<Object> findAllRateds(Integer page);
}
