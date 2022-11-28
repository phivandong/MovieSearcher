package com.example.TMDBManager.dto;

import lombok.Data;

@Data
public class SearchRequest {
    String keyword;
    String type;
    String country;
    String rating;
    String releaseYear;
    String genre;
}
