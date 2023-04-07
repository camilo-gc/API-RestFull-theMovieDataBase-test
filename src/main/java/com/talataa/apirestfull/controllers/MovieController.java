package com.talataa.apirestfull.controllers;

import com.talataa.apirestfull.models.GuestSessionResponse;
import com.talataa.apirestfull.models.apiResponse;
import com.talataa.apirestfull.models.RatingRequest;
import com.talataa.apirestfull.services.interfaces.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api-test/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getMovies(@RequestParam(name = "page", defaultValue = "1", required = false) int page){

        List<Object> listMovies = movieService.getMovies(page);

        if(listMovies.isEmpty()){

            return new ResponseEntity<>(new apiResponse("404", "Not Found", listMovies), HttpStatus.NOT_FOUND);

        }

        return new ResponseEntity<>(new apiResponse("200", "OK", listMovies), HttpStatus.OK);

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getDetailsMovie(@PathVariable("id") Integer id){

        List<Object> movie = new ArrayList<>();
        movie.add(movieService.getDetailsMovie(id));

        if(movie.isEmpty()){

            return new ResponseEntity<>(new apiResponse("404", "Not Found", movie), HttpStatus.NOT_FOUND);

        }

        return new ResponseEntity<>(new apiResponse("200", "OK", movie), HttpStatus.OK);
    }


    @GetMapping(value = "/new/session", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSession(){

        GuestSessionResponse guestSessionResponse = movieService.getSession();

        List content = new ArrayList<>();
        content.add(guestSessionResponse);

        if(!guestSessionResponse.getSuccess()){

            return new ResponseEntity<>(new apiResponse("403", "Forbidden", content), HttpStatus.FORBIDDEN);

        }

        return new ResponseEntity<>(new apiResponse("200", "OK", content), HttpStatus.OK);

    }


    @PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> setRatedMovie(@RequestBody RatingRequest ratingRequest, @PathVariable("id") Integer id) throws NoSuchFieldException {

        ResponseEntity response = movieService.setRatedMovie(ratingRequest, id);

        List content = new ArrayList<>();
        content.add(response.getBody());

        if(!response.getStatusCode().is2xxSuccessful()){

            return new ResponseEntity<>(new apiResponse("403", "Forbidden", content), HttpStatus.FORBIDDEN);

        }

        return new ResponseEntity<>(new apiResponse("200", "OK", content), HttpStatus.OK);

    }


    @GetMapping(value = "/rated", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getRatedMovies(@RequestParam(name = "page", defaultValue = "1", required = false) int page){

        List<Object> listMovies = movieService.getRatedMovies(page);

        if(listMovies.isEmpty()){

            return new ResponseEntity<>(new apiResponse("404", "Not Found", listMovies), HttpStatus.NOT_FOUND);

        }

        return new ResponseEntity<>(new apiResponse("200", "OK", listMovies), HttpStatus.OK);

    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteRatedMovie(@PathVariable("id") Integer id){
        System.err.println("Eliminando por id... " + id);
        //personaService.eliminar(id);

        return new ResponseEntity<>("Eliminado", HttpStatus.OK);
    }


}
