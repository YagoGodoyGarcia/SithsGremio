package br.com.gremio.entity;

import javax.persistence.*;

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
}
