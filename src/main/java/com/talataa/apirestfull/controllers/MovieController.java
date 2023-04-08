package com.talataa.apirestfull.controllers;

import com.talataa.apirestfull.models.ApiResponse;
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
    public ResponseEntity<?> getAll(@RequestParam(name = "page", defaultValue = "1", required = false) int page){

        List<Object> listMovies = movieService.getAll(page);

        if(listMovies.isEmpty()){

            return new ResponseEntity<>(new ApiResponse("404", "Not Found", listMovies), HttpStatus.NOT_FOUND);

        }

        return new ResponseEntity<>(new ApiResponse("200", "OK", listMovies), HttpStatus.OK);

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getDetails(@PathVariable("id") Integer id){

        List<Object> content = new ArrayList<>();
        content.add(movieService.getDetails(id));

        if(content.isEmpty()){

            return new ResponseEntity<>(new ApiResponse("404", "Not Found", content), HttpStatus.NOT_FOUND);

        }

        return new ResponseEntity<>(new ApiResponse("200", "OK", content), HttpStatus.OK);
    }


    @PostMapping(value = "/rated/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> setRated(@RequestBody Object ratingRequest,
                                      @PathVariable("id") Integer id,
                                      @RequestParam("guest_session_id") String guestSessionId) {

        ResponseEntity response = movieService.setRated(ratingRequest, id, guestSessionId);

        List content = new ArrayList<>();
        content.add(response.getBody());

        if(response.getStatusCode().is2xxSuccessful()){

            return new ResponseEntity<>(new ApiResponse("200", "OK", content), HttpStatus.OK);

        }

        return new ResponseEntity<>(new ApiResponse("403", "Forbidden", content), HttpStatus.FORBIDDEN);

    }


    @GetMapping(value = "/ratings", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getRatings(@RequestParam("guest_session_id") String guestSessionId,
                                        @RequestParam(name = "page", defaultValue = "1", required = false) Integer page){

        List<Object> listMovies = movieService.getRatings(guestSessionId, page);

        if(listMovies.isEmpty()){

            return new ResponseEntity<>(new ApiResponse("404", "Not Found", listMovies), HttpStatus.NOT_FOUND);

        }

        return new ResponseEntity<>(new ApiResponse("200", "OK", listMovies), HttpStatus.OK);

    }

    @DeleteMapping(value = "/rated/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteRated(@PathVariable("id") Integer id,
                                         @RequestParam("guest_session_id") String guestSessionId){

        ResponseEntity response = movieService.deleteRated(id, guestSessionId);

        List content = new ArrayList<>();
        content.add(response.getBody());

        if(!response.getStatusCode().is2xxSuccessful()){

            return new ResponseEntity<>(new ApiResponse("403", "Forbidden", content), HttpStatus.FORBIDDEN);

        }

        return new ResponseEntity<>(new ApiResponse("200", "OK", content), HttpStatus.OK);
    }

}
