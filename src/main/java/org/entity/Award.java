package org.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "awards")
@Data
@NoArgsConstructor
public class Award {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    //getters and setters
    @ManyToOne(cascade = CascadeType.ALL)
    private Director director;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Actor> actors;

    public Award(String name) {
        this.name = name;
    }

    public Award(String name, Director director) {
        this.name = name;
        this.director = director;
    }
}

