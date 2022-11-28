package com.example.TMDBManager.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "master_dataset")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Movie implements Serializable {
    @Id
    private String show_id;
    private String type;
    private String title;
    private String director;
    private String cast;
    private String country;
    private String date_added;
    private String release_year;
    private String rating;
    private String duration;
    private String listed_in;
    private String description;
}
