package com.example.TMDBManager.service;

import com.example.TMDBManager.entity.Movie;

import java.util.List;

public interface MovieService {
    List<String> getTypeSet();
    List<String> getCountrySet();
    List<String> getRatingSet();
    List<String> getReleaseYearSet();
    List<String> getGenreSet();
    List<Movie> customSearch(String keyword, String type, String country, String rating, String releaseDate, String genre);
}
