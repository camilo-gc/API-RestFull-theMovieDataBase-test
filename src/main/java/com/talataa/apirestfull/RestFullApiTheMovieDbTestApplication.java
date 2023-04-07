package com.talataa.apirestfull;


import com.talataa.apirestfull.repositorys.MovieRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestFullApiTheMovieDbTestApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {

        SpringApplication.run(RestFullApiTheMovieDbTestApplication.class, args);
        //MovieRepositoryImpl.getGuestSessionId();

    }



}
