package com.talataa.apirestfull.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GuestSessionResponse {


    Boolean success;
    String guest_session_id;
    String expires_at;



}
