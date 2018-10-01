package com.br.gremio.repository;

import com.br.gremio.entity.TbAluno;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Yago Garcia
 */
public interface AlunoRepository extends JpaRepository<TbAluno, Long> {
}
