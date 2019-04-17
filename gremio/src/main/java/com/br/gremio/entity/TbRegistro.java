package com.br.gremio.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_registros")
public class TbRegistro {
    @Id
    @SequenceGenerator(name = "id_registroSequence", sequenceName = "id_registroSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_registroSequence")
    @Column(name = "id_registro", unique = true)
    private long idRegistro;

    @Column(name = "data", unique = false)
    private String data;

    @Column(name = "sala", unique = false)
    private long idSala;

    public long getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(long idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getIdSala() {
        return idSala;
    }

    public void setIdSala(long idSala) {
        this.idSala = idSala;
    }
}
