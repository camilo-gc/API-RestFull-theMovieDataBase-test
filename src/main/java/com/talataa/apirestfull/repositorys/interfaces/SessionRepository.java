package com.talataa.apirestfull.repositorys.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;


public interface SessionRepository {

    ResponseEntity getGuestSession();
}
