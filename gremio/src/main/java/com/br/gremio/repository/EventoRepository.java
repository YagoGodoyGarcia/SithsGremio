package com.br.gremio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.gremio.entity.TbAluno;
import com.br.gremio.entity.TbEventos;
import java.util.List;
import java.util.Optional;
/**
 * @author Yago Garcia
 */
@Repository
public interface EventoRepository extends JpaRepository<TbEventos, Long> {
    @Query(value = "SELECT * FROM tb_eventos", nativeQuery = true)
    List<TbEventos> findAll();
    
    @Query(value = "SELECT * FROM tb_eventos  where id_aluno = ?1", nativeQuery = true)
    List<TbEventos> eventoOneAluno(Long id_aluno);
}
