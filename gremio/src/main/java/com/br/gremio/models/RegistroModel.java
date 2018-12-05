package com.br.gremio.models;

import javax.persistence.Column;

public class RegistroModel {
    private String data;
    private long idSala;

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
