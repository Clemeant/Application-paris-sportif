package bts.sio.paris2024.services;

import bts.sio.paris2024.models.Pays;
import bts.sio.paris2024.repositories.PaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaysService {

    @Autowired
    private PaysRepository paysRepository;

    public Optional<Pays> getPays(final Long id) {
        return paysRepository.findById(id);
    }

    public Iterable<Pays> getLesPays() {
        return paysRepository.findAll();
    }
}
