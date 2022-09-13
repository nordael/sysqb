package models.disciplina;

public class DisciplinaModel {
    private String nome;
    private String codigo;
    private Integer periodo;
    private StatusDisciplina disponibilidade;
    private GradeType grade;
    private DisciplinaTipo disciplinaTipo;
    private Integer cargaHoraria;
    private Boolean selecionadaBarreira; 

    public DisciplinaModel() {
        nome = "";
        codigo = "";
        periodo = 0;
        disponibilidade = StatusDisciplina.NONE;
        grade = GradeType.NONE;
        disciplinaTipo = DisciplinaTipo.NONE;
        cargaHoraria = 0;
    }

    public Boolean getSelecionadaBarreira(){
        return selecionadaBarreira;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public StatusDisciplina getDisponibilidade() {
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
    
    public void setSelecionadaBarreira(Boolean novoValor) {
        this.selecionadaBarreira = novoValor;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
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

    public void setDisponibilidade(StatusDisciplina disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

}
