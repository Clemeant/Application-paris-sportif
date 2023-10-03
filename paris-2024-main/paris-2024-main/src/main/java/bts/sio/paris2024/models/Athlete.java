package bts.sio.paris2024.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "athlete")
public class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50)
    private String nom;

    @Column(length = 50)
    private String prenom;

    @Column(name="datenaiss")
    private LocalDate dateNaiss;

    @ManyToOne
    private Sport sport;

    @ManyToOne
    private Pays pays;

    @ManyToMany
    private List<Olympiade> olympiades = new ArrayList<>();

}
