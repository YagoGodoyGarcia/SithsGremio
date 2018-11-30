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
    
    @Query(value  ="SELECT * FROM tb_eventos AS A "
    		+ "INNER JOIN tb_eventos_x_aluno AS B ON A.id_evento = B.id_evento "
    		+ "INNER JOIN tb_aluno AS C ON B.id_aluno = C.id_aluno "
    		+ "WHERE C.id_aluno =:idAluno", 
    		nativeQuery = true)
    List<TbEventos> eventoPorAluno(@Param("idAluno") long idAluno);
    
    @Query(value  ="SELECT * FROM tb_eventos AS A "
    		+ "INNER JOIN tb_eventos_x_aluno AS B ON A.id_evento = B.id_evento "
    		+ "INNER JOIN tb_aluno AS C ON B.id_aluno = C.id_aluno "
    		+ "WHERE C.id_aluno !=:idAluno", 
    		nativeQuery = true)
    List<TbEventos> eventoDisponivelPorAluno(@Param("idAluno") long idAluno);
    
    @Query(value  ="DELETE FROM tb_eventos_x_aluno" + 
    		"WHERE id_evento = ?1 AND id_aluno = ?2", 
    		nativeQuery = true)
    List<TbEventos> deletarAlunoDoEvento(@Param("idEvento") long idEvento,@Param("idAluno") long idAluno);
}
