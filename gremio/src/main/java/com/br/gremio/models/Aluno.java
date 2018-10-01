package com.br.gremio.models;

public class Aluno {
    private String nome;
    private int ra;
    private String email;
    private String senha;
    private int nivelPermissao;

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public int getRa() {return ra; }

    public void setRa(int ra) { this.ra = ra; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }

    public void setSenha(String senha) { this.senha = senha; }

    public int getNivelPermissao() { return nivelPermissao; }

    public void setNivelPermissao(int nivelPermissao) { this.nivelPermissao = nivelPermissao; }
}
