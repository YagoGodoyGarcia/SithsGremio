package com.br.gremio.repository;

import com.br.gremio.entity.TbSala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

/**
 * @author Yago Garcia
 */
public interface SalaRepository extends JpaRepository<TbSala, Long> {
    @Query(value = "SELECT * FROM tb_sala", nativeQuery = true)
    List<TbSala> findAll();
}
