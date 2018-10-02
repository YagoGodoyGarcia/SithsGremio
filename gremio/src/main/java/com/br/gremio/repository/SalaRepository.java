package com.br.gremio.repository;

import com.br.gremio.entity.TbSala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author Yago Garcia
 */
public interface SalaRepository extends JpaRepository<TbSala, Long> {
    @Query(value = "SELECT * FROM tb_sala", nativeQuery = true)
    List<TbSala> findAll();

    @Query(value = "SELECT * FROM tb_sala WHERE t.id_sala = :id_sala", nativeQuery = true)
    Optional<TbSala> findById(@Param("id_sala") long id);
}
