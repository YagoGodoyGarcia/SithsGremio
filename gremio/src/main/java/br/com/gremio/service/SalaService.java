package br.com.gremio.service;

import br.com.gremio.entity.TbSala;
import br.com.gremio.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yago Garcia
 */
@Service
public class SalaService {

    @Autowired
    private SalaRepository repository;

    public List<TbSala> findAll() {
        return repository.findAll();
    }

    public TbSala getOne(Long id) {
        return repository.getOne(id);
    }

    public TbSala save(TbSala sala) {
        return repository.save(sala);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
