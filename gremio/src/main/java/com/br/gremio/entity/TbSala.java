package com.br.gremio.entity;

import javax.persistence.*;

/**
 * @author Yago Garcia
 */
@Entity
@Table(name = "tb_sala")
public class TbSala {
    @Id
    @SequenceGenerator(name = "id_salaSequence", sequenceName = "id_salaSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_salaSequence")
    @Column(name = "id_sala", unique = true)
    private long idSala;

    @Column(name = "numero", nullable = false)
    private int numero;

    @Column(name = "capacidade", nullable = false)
    private int capacidade;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    public long getIdSala() { return idSala; }

    public void setIdSala(long idSala) { this.idSala = idSala; }

    public int getNumero() { return numero; }

    public void setNumero(int numero) { this.numero = numero; }

    public int getCapacidade() { return capacidade; }

    public void setCapacidade(int capacidade) { this.capacidade = capacidade; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }
}
