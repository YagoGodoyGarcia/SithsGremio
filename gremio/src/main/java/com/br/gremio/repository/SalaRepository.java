package com.br.gremio.repository;

import com.br.gremio.entity.TbSala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Yago Garcia
 */
@Repository
public interface SalaRepository extends JpaRepository<TbSala, Long> {
    @Query(value = "SELECT * FROM tb_sala", nativeQuery = true)
    List<TbSala> findAll();
}
