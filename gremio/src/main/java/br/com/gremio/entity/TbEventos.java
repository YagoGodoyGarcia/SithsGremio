package br.com.gremio.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_eventos")
public class TbEventos {

    @Id
    @SequenceGenerator(name = "id_eventoSequence", sequenceName = "id_eventoSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_eventoSequence")
    @Column(name = "id_evento", unique = true)
    private int idEvento;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name="data", columnDefinition = "date", nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data;

    @Column(name="hora", nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private Date hora;

    @Column(name="descricao", nullable = false)
    private String descricao;

    @Column(name="palestrante", nullable = false)
    private String palestrante;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "tb_chamada",
            joinColumns = { @JoinColumn(name = "id_evento") },
            inverseJoinColumns = { @JoinColumn(name = "id_aluno") }
    )
    private
    Set<TbAluno> alunos = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="id_sala")
    private
    TbSala sala;
    public void setIdEvento(int idEvento) { this.idEvento= idEvento; }

    public void setNome(String nome) { this.nome = nome;}

    public long getIdEvento() { return idEvento; }

    public String getNome(String nome) { return this.nome; }

    public Date getData() { return data; }

    public void setData(Date data) { this.data = data; }

    public Date getHora() { return hora; }

    public void setHora(Date hora) { this.hora = hora; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getPalestrante() { return palestrante; }

    public void setPalestrante(String palestrante) { this.palestrante = palestrante; }

    public Set<TbAluno> getAlunos() { return alunos; }

    public void setAlunos(Set<TbAluno> alunos) { this.alunos = alunos; }


    public TbSala getSala() { return sala; }

    public void setSala(TbSala sala) { this.sala = sala; }
}
