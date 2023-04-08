package com.talataa.apirestfull.services;

import com.talataa.apirestfull.models.Movie;
import com.talataa.apirestfull.repositorys.interfaces.MovieRepository;
import com.talataa.apirestfull.services.interfaces.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;


    public List<Object> getAll(Integer page){
        return movieRepository.findAll(page);
    }


    public Movie getDetails(Integer id){
        return movieRepository.findById(id);
    }


    public ResponseEntity setRated(Object request, Integer id, String guestSessionId) {
        return movieRepository.sendRated(request, id, guestSessionId);
    }


    public List<Object> getRatings(String guestSessionId, Integer page){
        return movieRepository.findAllRatings(guestSessionId, page);
    }


    public ResponseEntity deleteRated(Integer id, String guestSessionId) {
        return movieRepository.deleteRated(id, guestSessionId);
    }
}
