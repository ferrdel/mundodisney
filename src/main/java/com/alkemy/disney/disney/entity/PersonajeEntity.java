package com.alkemy.disney.disney.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="personaje")
@Getter
@Setter

public class PersonajeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String nombre;

    private Integer edad;

    private Long peso;

    private String historia;

    @ManyToMany(mappedBy = "personajes",cascade = CascadeType.ALL)
    private List<PeliSerieEntity> peliSerie= new ArrayList<>();

    private void addPeliSerie(PeliSerieEntity peliSeries) {this.peliSerie.add(peliSeries);}

    private void removePeliSerie(PeliSerieEntity peliSeries) {this.peliSerie.remove(peliSeries);}

}
