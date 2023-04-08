package com.talataa.apirestfull.services.interfaces;

import com.talataa.apirestfull.models.Movie;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface MovieService {


    List<Object> getAll(Integer page);


    Movie getDetails(Integer id);


    ResponseEntity setRated(Object ratingRequest, Integer id, String guestSessionId);


    List<Object> getRatings(String guestSessionId, Integer page);


    ResponseEntity deleteRated(Integer id, String guestSessionId);
}
