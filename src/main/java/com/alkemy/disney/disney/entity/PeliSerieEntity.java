package com.alkemy.disney.disney.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="pelicula_serie")
@Getter
@Setter

public class PeliSerieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String titulo;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaCreacion;

    private Integer calificacion;

    //Relacion de muchos_uno
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "genero_id", insertable = false, updatable = false)
    private GeneroEntity genero;

    @Column(name = "genero_id", nullable = false)
    private Long generoId;

    //Peliculas_Series engloba personajes
    //relacion muchos a muchos
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    //relacion de las dos tablas
    @JoinTable(
            name="personaje_peliSerie",
            joinColumns = @JoinColumn(name = "peliSerie_id"),
            inverseJoinColumns = @JoinColumn(name = "personaje_id"))
    private Set<PersonajeEntity> personajes= new HashSet<>();

    @Override
    public boolean equals(Object obj){
        if(obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final PeliSerieEntity other = (PeliSerieEntity) obj;
        return other.id == this.id;
    }

}
