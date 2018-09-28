package br.com.gremio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.gremio.entity.TbEventos;

import java.util.List;
/**
 * @author Yago Garcia
 */
@Repository
public interface EventoRepository extends JpaRepository<TbEventos, Long> {
    @Query(value = "SELECT * FROM tb_eventos", nativeQuery = true)
    List<TbEventos> findAll();
}
