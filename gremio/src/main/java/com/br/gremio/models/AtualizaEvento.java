package com.br.gremio.models;

public class AtualizaEvento {
	private Long id_evento;
	private String nome;
    private String data;
    private String hora;
    private String descricao;
    private String palestrante;
    private long sala;
	public Long getId_evento() {
		return id_evento;
	}
	public void setId_evento(Long id_evento) {
		this.id_evento = id_evento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPalestrante() {
		return palestrante;
	}
	public void setPalestrante(String palestrante) {
		this.palestrante = palestrante;
	}
	public long getSala() {
		return sala;
	}
	public void setSala(long sala) {
		this.sala = sala;
	}
	
}
