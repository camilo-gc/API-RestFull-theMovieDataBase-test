package com.talataa.apirestfull.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieResponse {

    private String statusCode;
    private String description;
    private List<Object> content;

}
