package bts.sio.paris2024.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sport")
public class Sport{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50)
    private String nom;

}

public void modifySport(Sport sport) {
  sport.setName("Nouveau nom du sport");
}
public void deleteSport(int idSport) {
  Sport sport = sportRepository.findById(idSport);

  sportRepository.delete(sport);
}
public List<Sport> listSports() {
  // Retourne la liste de tous les sports
  return sportRepository.findAll();
}
