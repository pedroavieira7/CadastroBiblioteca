package br.com.tech4me.model;


import java.text.SimpleDateFormat;

public class Autores {
    
    private String nome;
    private String id;
    private SimpleDateFormat nascimento;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public SimpleDateFormat getNascimento() {
        return nascimento;
    }
    public void setNascimento(SimpleDateFormat nascimento) {
        this.nascimento = nascimento;
    }

}
