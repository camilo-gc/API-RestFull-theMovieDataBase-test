package com.talataa.apirestfull.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Session {

    private Boolean success;
    private String guest_session_id;
    private String expires_at;

}
