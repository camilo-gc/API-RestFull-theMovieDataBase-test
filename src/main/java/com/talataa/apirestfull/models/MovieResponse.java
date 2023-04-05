package com.talataa.apirestfull.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieResponse {

    private String statusCode;
    private String description;
    private Object content;

}
