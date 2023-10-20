package br.com.escuderodev.fiap.oo.models;

public class Professor extends Pessoa {
    private String disciplina;

    public Professor(String nome, int idade) {
        super(nome, idade);
    }

    public Professor(String nome) {
        super(nome);
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String exibeDadosProfessor() {
        return String.format("""
                ===== Professor =====
                Nome: %s
                Idade: %d anos
                Disciplina: %s
                """, this.getNome(), this.getIdade(), this.getDisciplina());
    }
}
