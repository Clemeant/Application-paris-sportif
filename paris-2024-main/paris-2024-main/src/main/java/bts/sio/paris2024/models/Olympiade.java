package bts.sio.paris2024.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "olympiade")
public class Olympiade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 8)
    private String numero ;

    private Integer annee;

    @Column(length = 60)
    private String ville ;

    private String epreuves;

    @ManyToOne
    private Pays pays;

}
