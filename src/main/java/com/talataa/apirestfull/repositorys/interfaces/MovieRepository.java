package com.talataa.apirestfull.repositorys.interfaces;

import com.talataa.apirestfull.models.Movie;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface MovieRepository {

    List<Object> findAll(Integer page);


    List<Object> findAll();


    Movie findById(Integer id);


    ResponseEntity sendRated(Object ratingRequest, Integer id, String guestSessionId);


    List<Object> findAllRatings(String guestSessionId, Integer page);


    ResponseEntity deleteRated(Integer id, String guestSessionId);

}
