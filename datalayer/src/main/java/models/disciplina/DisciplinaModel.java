package models.disciplina;

import models.disciplina.GradeType;
public class DisciplinaModel {
    private String codigo;
    private Integer periodo;
    private Boolean disponibilidade;
    private GradeType grade;
    private DisciplinaTipo disciplinaTipo;
    private Integer cargaHoraria;


    public String getCodigo() {
        return codigo;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public Boolean getDisponibilidade() {
        return disponibilidade;
    }

    public GradeType getGrade() {
        return grade;
    }

    public DisciplinaTipo getDisciplinaTipo() {
        return disciplinaTipo;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public void setGrade(GradeType grade) {
        this.grade = grade;
    }

    public void setDisciplinaTipo(DisciplinaTipo disciplinaTipo) {
        this.disciplinaTipo = disciplinaTipo;
    }

    public void setDisponibilidade(Boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

}
