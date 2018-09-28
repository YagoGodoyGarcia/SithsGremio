package br.com.gremio.models;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author Yago Garcia
 */
public class Eventos {
    private String nome;
    private Date data;
    private Date hora;
    private String descricao;
    private String palestrante;

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public Date getData() { return data; }

    public void setData(Date data) { this.data = data; }

    public Date getHora() { return hora; }

    public void setHora(Date hora) { this.hora = hora; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getPalestrante() { return palestrante; }

    public void setPalestrante(String palestrante) { this.palestrante = palestrante; }
}
