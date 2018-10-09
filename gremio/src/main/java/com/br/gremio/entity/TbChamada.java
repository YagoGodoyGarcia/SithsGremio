package com.br.gremio.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_aluno")
public class TbChamada {
    @OneToMany
    TbAluno aluno ;
    @OneToMany
    TbEventos evento;
}
