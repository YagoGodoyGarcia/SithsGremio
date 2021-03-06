package com.br.gremio.service;

import com.br.gremio.entity.TbAluno;
import com.br.gremio.repository.AlunoRepository;
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

    public List<TbAluno> findAllAluno() {
        return repository.findAllAluno();
    }

    public List<TbAluno> findAllAdm() {
        return repository.findAllAdm();
    }

    public TbAluno getOne(Long id) {
        return repository.findById(id).get();
    }

    public TbAluno save(TbAluno aluno) {
        return repository.save(aluno);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
