package com.br.gremio.repository;

import com.br.gremio.entity.TbAluno;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Yago Garcia
 */
public interface AlunoRepository extends JpaRepository<TbAluno, Long> {
	@Query(value ="SELECT * FROM tb_aluno WHERE id_evento = '%id_aluno%'", nativeQuery = true)
    TbAluno findById(int id_aluno);
}
