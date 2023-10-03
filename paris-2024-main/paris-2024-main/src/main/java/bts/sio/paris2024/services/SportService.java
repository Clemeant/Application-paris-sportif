package bts.sio.paris2024.services;

import bts.sio.paris2024.models.Pays;
import bts.sio.paris2024.models.Sport;
import bts.sio.paris2024.repositories.PaysRepository;
import bts.sio.paris2024.repositories.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SportService {

    @Autowired
    private SportRepository sportRepository;

    public Optional<Sport> getSport(final Long id) { return sportRepository.findById(id); }

    public Iterable<Sport> getLesSports() {
        return sportRepository.findAll();
    }

}
