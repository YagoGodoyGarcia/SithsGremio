package com.br.gremio.repository;

import com.br.gremio.entity.TbAluno;
import com.br.gremio.entity.TbEventos;
import com.br.gremio.entity.TbSala;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Yago Garcia
 */
@Repository
public interface AlunoRepository extends JpaRepository<TbAluno, Long> {
	@Query(value = "SELECT * FROM tb_aluno order by id_aluno", nativeQuery = true)
    List<TbAluno> findAll();

    @Query(value = "SELECT * FROM tb_aluno where nivel_permissao = 1", nativeQuery = true)
    List<TbAluno> findAllAluno();

    @Query(value = "SELECT * FROM tb_aluno where nivel_permissao in (2,3)", nativeQuery = true)
    List<TbAluno> findAllAdm();
	
	@Query(value = "SELECT * FROM tb_aluno u WHERE u.email = ?1 and u.senha = ?2", nativeQuery = true)
    TbAluno authLogin(String email, String senha );
	
}
