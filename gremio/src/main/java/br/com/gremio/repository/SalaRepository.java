package br.com.gremio.repository;

import br.com.gremio.entity.TbSala;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Yago Garcia
 */
public interface SalaRepository extends JpaRepository<TbSala, Long> {
}
