package com.talataa.apirestfull.services;

import com.talataa.apirestfull.repositorys.interfaces.SessionRepository;
import com.talataa.apirestfull.services.interfaces.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    SessionRepository sessionRepository;

    public ResponseEntity getGuestSession(){
        return sessionRepository.getGuestSession();
    }

}
