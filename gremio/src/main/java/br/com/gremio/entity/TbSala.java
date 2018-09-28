package br.com.gremio.entity;

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
    private int idSala;

    @Column(name = "numero", nullable = false)
    private int numero;

    @Column(name = "capacidade", nullable = false)
    private int capacidade;

    @Column(name = "disponibilidade", nullable = false)
    private Boolean disponibilidade;

    public int getIdSala() { return idSala; }

    public void setIdSala(int idSala) { this.idSala = idSala; }

    public int getNumero() { return numero; }

    public void setNumero(int numero) { this.numero = numero; }

    public int getCapacidade() { return capacidade; }

    public void setCapacidade(int capacidade) { this.capacidade = capacidade; }

    public Boolean getDisponibilidade() { return disponibilidade; }

    public void setDisponibilidade(Boolean disponibilidade) { this.disponibilidade = disponibilidade; }
}
