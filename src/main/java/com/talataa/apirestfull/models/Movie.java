package com.talataa.apirestfull.models;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.*;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Movie {


    boolean adult;
    String backdrop_path;
    Object belongs_to_collection;
    Integer budget;
    ArrayList<Object> genres;
    String homepage;
    Integer id;
    String imdb_id;
    String original_language;
    String original_title;
    String overview;
    Number popularity;
    String poster_path;
    ArrayList<Object> production_companies;
    ArrayList<Object> production_countries;
    String release_date;
    Integer revenue;
    Integer runtime;
    ArrayList<Object> spoken_languages;
    String status;
    String tagline;
    String title;
    boolean video;
    Number  vote_average;
    Integer vote_count;

}
