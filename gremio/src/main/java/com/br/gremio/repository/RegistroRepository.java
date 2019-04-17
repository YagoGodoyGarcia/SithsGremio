package com.br.gremio.repository;

import com.br.gremio.entity.TbRegistro;
import com.sun.rowset.internal.Row;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Yago Garcia
 */
@Repository
public interface RegistroRepository extends JpaRepository<TbRegistro, Long> {
    @Query(value  = "SELECT * FROM tb_registros WHERE data =:data and sala =:idSala",nativeQuery = true)
    TbRegistro verificarDisponibilidade(@Param("idSala") long idSala, @Param("data") String data);
}
