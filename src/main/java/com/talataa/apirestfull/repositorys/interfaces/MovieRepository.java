package com.talataa.apirestfull.repositorys.interfaces;

import com.talataa.apirestfull.models.Movie;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository {
    /*
    List<Movie> findAll();
    */
    Movie findById(Integer id);
}
