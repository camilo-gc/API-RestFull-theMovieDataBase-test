package com.talataa.apirestfull.repositorys;

import com.talataa.apirestfull.models.Session;
import com.talataa.apirestfull.repositorys.interfaces.SessionRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Repository
public class SessionRepositoryImpl implements SessionRepository {

    @Value("${tmdb.api.key}")
    private String apiKey;

    @Value("${tmdb.api.url}")
    private String apiUrl;

    @Autowired
    RestTemplate restTemplate;

    public ResponseEntity getGuestSession(){

        String url = String.format("%s/authentication/guest_session/new?api_key=%s", apiUrl, apiKey);

        try {

            return restTemplate.getForEntity(url, Session.class);

        }catch (HttpClientErrorException e) {

            return new ResponseEntity<>("", e.getStatusCode());

        }
    }


}
