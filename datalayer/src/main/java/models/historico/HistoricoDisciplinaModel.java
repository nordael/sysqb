package models.historico;

import models.disciplina.DisciplinaTipo;
import models.disciplina.GradeType;

public class HistoricoDisciplinaModel {
    private String nomeAluno;
    private String grr;
    private String nomeCurso;
    private String codigoCurso;
    private GradeType versaoGrade;
    private Integer anoIngresso;
    private Double mediaFinal;
    private SemestreTipo semestre;
    private SituacaoTipo situacao;
    private String nomeDisciplina;
    private Integer cargaHoraria;
    private String codigoDisciplina;
    private DisciplinaTipo disciplinaTipo;
//    private String getNomeDisciplina;
    private Integer frequencia;
    private StatusAprovacao statusAprovacao;


    public HistoricoDisciplinaModel() {
        nomeAluno = "";
        grr = "";
        nomeCurso = "";
        codigoCurso = "";
        versaoGrade = GradeType.NONE;
        anoIngresso = 0;
        mediaFinal = 0.0;
        semestre = SemestreTipo.NONE;
        situacao = SituacaoTipo.NONE;
        nomeDisciplina = "";
        cargaHoraria = 0;
        codigoDisciplina = "";
        disciplinaTipo = DisciplinaTipo.NONE;
        frequencia = 0;
        statusAprovacao = StatusAprovacao.NONE;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }
    public String getGrr() {
        return grr;
    }
    public String getNomeCurso() {
        return nomeCurso;
    }
    public String getCodigoCurso() {
        return codigoCurso;
    }
    public GradeType getVersaoGrade() {
        return versaoGrade;
    }
    public Integer getAnoIngresso() {
        return anoIngresso;
    }
    public Double getMediaFinal() {
        return mediaFinal;
    }
    public SemestreTipo getSemestre() {
        return semestre;
    }
    public SituacaoTipo getSituacao() {
        return situacao;
    }
    public String getNomeDisciplina() {
        return nomeDisciplina;
    }
    public Integer getCargaHoraria() {
        return cargaHoraria;
    }
    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }
    public DisciplinaTipo getDisciplinaTipo() {
        return disciplinaTipo;
    }
    public Integer getFrequencia() {
        return frequencia;
    }
    public StatusAprovacao getStatusAprovacao() {
        return statusAprovacao;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }
    public void setGrr(String grr) {
        this.grr = grr;
    }
    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }
    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }
    public void setVersaoGrade(GradeType versaoGrade) {
        this.versaoGrade = versaoGrade;
    }
    public void setAnoIngresso(Integer anoIngresso) {
        this.anoIngresso = anoIngresso;
    }
    public void setMediaFinal(Double mediaFinal) {
        this.mediaFinal = mediaFinal;
    }
    public void setSemestre(SemestreTipo semestre) {
        this.semestre = semestre;
    }
    public void setSituacao(SituacaoTipo situacao) {
        this.situacao = situacao;
    }
    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }
    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    public void setCodigoDisciplina(String codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }
    public void setDisciplinaTipo(DisciplinaTipo disciplinaTipo) {
        this.disciplinaTipo = disciplinaTipo;
    }
    public void setFrequencia(Integer frequencia) {
        this.frequencia = frequencia;
    }
    public void setStatusAprovacao(StatusAprovacao statusAprovacao) {
        this.statusAprovacao = statusAprovacao;
    }

}
