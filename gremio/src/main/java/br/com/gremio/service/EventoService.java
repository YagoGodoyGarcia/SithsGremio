package br.com.gremio.service;

import br.com.gremio.entity.TbEventos;
import br.com.gremio.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public TbEventos save(TbEventos eventos) {
        return repository.save(eventos);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
