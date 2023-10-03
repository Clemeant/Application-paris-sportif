package bts.sio.paris2024.repositories;

import bts.sio.paris2024.models.Athlete;
import org.springframework.data.repository.CrudRepository;

public interface AthleteRepository extends CrudRepository<Athlete, Long> {
}
