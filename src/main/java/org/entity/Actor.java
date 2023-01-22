package org.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "actors")
@NoArgsConstructor
@Data
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Film> film;
    @OneToOne(cascade = CascadeType.ALL)
    private Award award;


    public Actor(String name, List<Film> film, Award award) {
        this.name = name;
        this.film = film;
        this.award = award;
    }

    public Actor(String name) {
        this.name = name;
    }

    public Actor(Long id, String name, List<Film> film, Award award) {
        this.id = id;
        this.name = name;
        this.film = film;
        this.award = award;
    }
}

