package br.com.gremio.repository;

import br.com.gremio.entity.TbAluno;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Yago Garcia
 */
public interface AlunoRepository extends JpaRepository<TbAluno, Long> {
}
