package models.aluno;

import models.curso.CursoModel;

public class AlunoModel {
    private String grr;
    private String nome;
    private CursoModel curso;
    private String telefone;
    private String email;

    public AlunoModel() {

    }

    public String getGrr() {
        return this.grr;
    }

    public String getNome() {
        return nome;
    }

    public CursoModel getCurso() {
        return curso;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setGrr(String grr) {
        this.grr = grr;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCurso(CursoModel curso) {
        this.curso = curso;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
