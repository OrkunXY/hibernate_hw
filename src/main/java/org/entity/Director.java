package org.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "directors")
@NoArgsConstructor
@Data
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Film> film;
    @OneToOne(cascade = CascadeType.ALL)
    private Award award;

    public Director(String name, List<Film> film, Award award) {
        this.name = name;
        this.film = film;
        this.award = award;
    }

    public Director(String name) {
        this.name = name;
    }

    public Director(Long id, String name, List<Film> film, Award award) {
        this.id = id;
        this.name = name;
        this.film = film;
        this.award = award;
    }
}

