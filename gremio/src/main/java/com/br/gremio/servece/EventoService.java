package com.br.gremio.servece;

import com.br.gremio.entity.TbEventos;
import com.br.gremio.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yago Garcia
 */
@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;

    public List<TbEventos> findAll() {
        return repository.findAll();
    }

    public TbEventos getOne(Long id) {
        return repository.getOne(id);
    }

    public TbEventos save(TbEventos eventos) { return repository.save(eventos); }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
