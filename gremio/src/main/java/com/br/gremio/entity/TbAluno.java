package com.br.gremio.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

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
    private int idAluno;

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
   
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
    		name = "tb_chamada",
            joinColumns = { @JoinColumn(name = "id_evento") },
            inverseJoinColumns = { @JoinColumn(name = "id_aluno") }
    )
    private Set<TbEventos> Eventos;
	
    public Set<TbEventos> getEventos() {
		return Eventos;
	}

	public void setEventos(Set<TbEventos> eventos) {
		Eventos = eventos;
	}

	public void adicionarEvento(TbEventos evento) {
		if(this.Eventos == null ) {
			this.Eventos = new HashSet<>();
		}
		this.Eventos.add(evento);
	}
	
	public int getIdAluno() { return idAluno; }

    public void setIdAluno(int idAluno) { this.idAluno = idAluno; }

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
