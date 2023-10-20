package br.com.escuderodev.fiap.oo.models;

public class Aluno extends Pessoa {
    private String curso;

    public Aluno(String nome, int idade) {
        super(nome, idade);
    }

    public Aluno(String nome) {
        super(nome);
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String exibeDadosAluno() {
        return String.format("""
                ===== Aluno =====
                Nome: %s
                Idade: %d anos
                Curso: %s
                """, this.getNome(), this.getIdade(), this.getCurso());
    }
}
