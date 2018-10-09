package com.br.gremio.repository;

import com.br.gremio.entity.TbAluno;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Yago Garcia
 */
public interface AlunoRepository extends JpaRepository<TbAluno, Long> {

}
