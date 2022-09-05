package models.historico;

import java.util.ArrayList;
import models.aluno.AlunoModel;
import models.curso.CursoModel;
import models.disciplina.DisciplinaModel;

public class HistoricoModel {
    private AlunoModel aluno;
    private CursoModel curso;
    private SemestreTipo semestreTipo;
    private ArrayList<DisciplinaModel> disciplinasVencidas;

    public HistoricoModel() {
        this.aluno = new AlunoModel();
        this.curso = new CursoModel();
        this.semestreTipo = SemestreTipo.NONE;
        this.disciplinasVencidas = new ArrayList<DisciplinaModel>();
    }

    public AlunoModel getAluno() {
        return aluno;
    }

    public CursoModel getCurso() {
        return curso;
    }

    public SemestreTipo getSemestreTipo() {
        return semestreTipo;
    }

    public ArrayList<DisciplinaModel> getDisciplinasVencidas() {
        return disciplinasVencidas;
    }

    public void setAluno(AlunoModel aluno) {
        this.aluno = aluno;
    }

    public void setCurso(CursoModel curso) {
        this.curso = curso;
    }

    public void setSemestreTipo(SemestreTipo semestreTipo) {
        this.semestreTipo = semestreTipo;
    }

    public void setDisciplinasVencidas(ArrayList<DisciplinaModel> disciplinasVencidas) {
        if (!this.disciplinasVencidas.isEmpty()){
            this.disciplinasVencidas.clear();
        }
        this.disciplinasVencidas.addAll(disciplinasVencidas);
    }
}
