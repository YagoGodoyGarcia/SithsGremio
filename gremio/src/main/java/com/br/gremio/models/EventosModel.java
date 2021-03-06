package com.br.gremio.models;

import java.util.HashSet;
import java.util.Set;

import com.br.gremio.entity.TbAluno;
import com.br.gremio.entity.TbSala;

/**
 * @author Yago Garcia
 */
public class EventosModel {
    private String nome;
    private String data;
    private String horaTermino;
    private String hora;
    private String descricao;
    private String palestrante;
    private long sala;

	public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getData() { return data; }

    public void setData(String data) { this.data = data; }

    public String getHora() { return hora; }

    public void setHora(String hora) { this.hora = hora; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getPalestrante() { return palestrante; }

    public void setPalestrante(String palestrante) { this.palestrante = palestrante; }

    public long getSala() { return sala; }

    public void setSala(long sala) { this.sala = sala; }

    public String getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(String horaTermino) {
        this.horaTermino = horaTermino;
    }
}
