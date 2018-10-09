package com.br.gremio.models;

public class Chamada {
    private long id_evento;
    private long id_aluno;

    public long getId_evento() {
        return id_evento;
    }

    public void setId_evento(long id_evento) {
        this.id_evento = id_evento;
    }

    public long getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(long id_aluno) {
        this.id_aluno = id_aluno;
    }
}
