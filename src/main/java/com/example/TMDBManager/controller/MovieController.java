package com.example.TMDBManager.controller;

import com.example.TMDBManager.dto.SearchRequest;
import com.example.TMDBManager.entity.Movie;
import com.example.TMDBManager.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @RequestMapping("/")
    public String listAll(Model model, @ModelAttribute("searchRequest") SearchRequest searchRequest) {
        List<String> typeList = movieService.getTypeSet();
        List<String> countryList = movieService.getCountrySet();
        List<String> ratingList = movieService.getRatingSet();
        List<String> releaseYearList = movieService.getReleaseYearSet();
        List<String> genreList = movieService.getGenreSet();
        List<Movie> movieList =
                movieService.customSearch(searchRequest.getKeyword(), searchRequest.getType(), searchRequest.getCountry(),
                        searchRequest.getRating(), searchRequest.getReleaseYear(), searchRequest.getGenre());

        model.addAttribute("typeList", typeList);
        model.addAttribute("countryList", countryList);
        model.addAttribute("ratingList", ratingList);
        model.addAttribute("releaseYearList", releaseYearList);
        model.addAttribute("genreList", genreList);
        model.addAttribute("movieList", movieList);
        return "index";
    }

}
