package br.com.escuderodev.fiap.oo.models;

public class Pessoa {
    private String nome;
    private int idade;

//    constructor

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Pessoa(String nome) {
        this.nome = nome;
        this.idade = 0;
    }

//    getters and setters


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String exibeDadosPessoas() {
        return String.format("""
                ===== Pessoa =====
                Nome: %s
                Idade: %d anos
                """, this.getNome(), this.getIdade());
    }
}
