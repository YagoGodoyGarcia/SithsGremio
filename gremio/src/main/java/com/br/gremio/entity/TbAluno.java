package com.br.gremio.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Yago Garcia
 */

@Entity
@Table(name = "tb_aluno")
public class TbAluno {
    @Id
    @SequenceGenerator(name = "id_alunoSequence", sequenceName = "id_alunoSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_alunoSequence")
    @Column(name = "id_aluno", unique = true)
    private long idAluno;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name ="ra", nullable = false)
    private int ra;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "nivel_permissao", nullable = false)
    private int nivelPermissao;

    public long getIdAluno() { return idAluno; }

    public void setIdAluno(long idAluno) { this.idAluno = idAluno; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public int getRa() { return ra; }

    public void setRa(int ra) { this.ra = ra; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getSenha() {  return senha; }

    public void setSenha(String senha) { this.senha = senha; }

    public int getNivelPermissao() { return nivelPermissao; }

    public void setNivelPermissao(int nivelPermissao) { this.nivelPermissao = nivelPermissao; }

}
