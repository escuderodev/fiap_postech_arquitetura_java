package br.com.escuderodev.fiap.oo.models;

public class Universidade {
    private Professor professor;
    private Aluno aluno;
    private Curso curso;

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String exibeDadosUniversidade() {
        return String.format("""
                ===== Universidade =====
                Curso: %s
                Professor: %s
                Disciplina: %s
                Aluno: %s
                Idade do Aluno: %d anos
                """, this.getCurso().getNomeCurso(), this.getProfessor().getNome(), this.getProfessor().getDisciplina(),
                     this.getAluno().getNome(), this.getAluno().getIdade());
    }
}
