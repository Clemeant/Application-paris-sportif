package bts.sio.paris2024.repositories;

import bts.sio.paris2024.models.Athlete;
import bts.sio.paris2024.models.Sport;
import org.springframework.data.repository.CrudRepository;

public interface SportRepository extends CrudRepository<Sport, Long> {
}
