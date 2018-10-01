package br.com.gremio.service;

import br.com.gremio.entity.TbAluno;
import br.com.gremio.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yago Garcia
 */
@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public List<TbAluno> findAll() {
        return repository.findAll();
    }

    public TbAluno getOne(Long id) {
        return repository.getOne(id);
    }

    public TbAluno save(TbAluno aluno) {
        return repository.save(aluno);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}