package com.example.TMDBManager.repository;

import com.example.TMDBManager.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {
    @Query("SELECT DISTINCT(m.type) FROM Movie m")
    List<String> setOfType();

    @Query("SELECT DISTINCT(m.country) FROM Movie m")
    List<String> setOfCountry();

    @Query("SELECT DISTINCT(m.rating) FROM Movie m")
    List<String> setOfRating();

    @Query("SELECT DISTINCT(m.release_year) FROM Movie m")
    List<String> setOfReleaseYear();

    @Query("SELECT DISTINCT(m.listed_in) FROM Movie m")
    List<String> setOfGenre();

    @Query("SELECT m FROM Movie m WHERE(:keyword IS NULL OR CONCAT(m.title, ' ', m.cast) LIKE %:keyword%) " +
            "AND (:type IS NULL OR m.type LIKE %:type%) " +
            "AND (:country IS NULL OR CONCAT(m.country) LIKE %:country%) " +
            "AND (:rating IS NULL OR m.rating LIKE %:rating%) " +
            "AND (:release_year IS NULL OR m.release_year LIKE %:release_year%) " +
            "AND (:listed_in IS NULL OR CONCAT(m.listed_in) LIKE %:listed_in%)")
    List<Movie> customFilter(@Param("keyword") String keyword, @Param("type") String type, @Param("country") String country,
                             @Param("rating") String rating, @Param("release_year") String release_year, @Param("listed_in") String listed_in);
}
