package com.talataa.apirestfull.controllers;

import com.talataa.apirestfull.models.ApiResponse;
import com.talataa.apirestfull.models.Session;
import com.talataa.apirestfull.services.interfaces.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping(value = "/guest/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getGuestSession() {

        ResponseEntity<Session> sessionResponse = sessionService.getGuestSession();

        List content = new ArrayList<>();
        content.add(sessionResponse.getBody());

        if(sessionResponse.getStatusCode().is2xxSuccessful()){

            return new ResponseEntity<>(new ApiResponse("200", "OK", content), HttpStatus.OK);

        }

        return new ResponseEntity<>(new ApiResponse("403", "Forbidden", content), HttpStatus.FORBIDDEN);

    }

}
