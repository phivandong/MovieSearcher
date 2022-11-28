package com.example.TMDBManager.service;

import com.example.TMDBManager.entity.Movie;
import com.example.TMDBManager.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Override
    public List<String> getTypeSet() {
        return movieRepository.setOfType();
    }

    @Override
    public List<String> getCountrySet() {
        List<String> countryList = new ArrayList<>();
        movieRepository.setOfCountry().parallelStream().forEach(s -> countryList.addAll(Arrays.stream(s.split(",")).toList()));
        return countryList.parallelStream().distinct().sorted().collect(Collectors.toList());
    }

    @Override
    public List<String> getRatingSet() {
        return movieRepository.setOfRating();
    }

    @Override
    public List<String> getReleaseYearSet() {
        return movieRepository.setOfReleaseYear().parallelStream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    @Override
    public List<String> getGenreSet() {
        List<String> genreList = new ArrayList<>();
        movieRepository.setOfGenre().parallelStream().forEach(s -> genreList.addAll(Arrays.stream(s.split(",")).toList()));
        return genreList.parallelStream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<Movie> customSearch(String keyword, String type, String country, String rating, String releaseYear, String genre) {
        return movieRepository.customFilter(keyword, type, country, rating, releaseYear, genre);
    }
}
