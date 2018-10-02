package com.br.gremio.models;

import com.br.gremio.entity.TbSala;

/**
 * @author Yago Garcia
 */
public class Eventos {
    private String nome;
    private String data;
    private String hora;
    private String descricao;
    private String palestrante;
    private int sala;

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

    public int getSala() { return sala; }

    public void setSala(int sala) { this.sala = sala; }
}
