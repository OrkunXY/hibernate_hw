package org.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data

@Table(name = "films")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne (cascade = CascadeType.ALL)
    private Director director;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Actor> actors ;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Award> award;
    @ManyToOne(cascade = CascadeType.ALL)
    private FilmCatagory filmCatagory;

    public Film(String name, Director director, List<Actor> actors, List<Award> award) {
        this.name = name;
        this.director = director;
        this.actors = actors;
        this.award = award;
    }

    public Film(String name) {
        this.name = name;
    }

    public Film(Long id, String name, Director director, List<Actor> actors, List<Award> award, FilmCatagory filmCatagory) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.actors = actors;
        this.award = award;
        this.filmCatagory = filmCatagory;
    }

    public Film(String name, Director director, List<Actor> actors, List<Award> award, FilmCatagory filmCatagory) {
        this.name = name;
        this.director = director;
        this.actors = actors;
        this.award = award;
        this.filmCatagory = filmCatagory;
    }

}
