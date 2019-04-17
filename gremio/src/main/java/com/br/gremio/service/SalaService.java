package com.br.gremio.service;

import com.br.gremio.entity.TbSala;
import com.br.gremio.repository.SalaRepository;
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

    public TbSala getOne(Long id) { return repository.findById(id).get(); }

    public TbSala save(TbSala sala) {
        return repository.save(sala);
    }

    public void delete(Long sala) {
        repository.deleteById(sala);
    }
}
