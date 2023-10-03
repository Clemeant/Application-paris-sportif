package bts.sio.paris2024.services;

import bts.sio.paris2024.models.Olympiade;
import bts.sio.paris2024.repositories.OlympiadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OlympiadeService {
    @Autowired
    private OlympiadeRepository olympiadeRepository;

    public Optional<Olympiade> getOlympiade(final Long id) {
        return olympiadeRepository.findById(id);
    }

    public Iterable<Olympiade> getLesOlympiades() {
        return olympiadeRepository.findAll();
    }
}
