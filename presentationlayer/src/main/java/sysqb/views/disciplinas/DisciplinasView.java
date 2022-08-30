package sysqb.views.disciplinas;

import controllers.csvparser.DisciplinaCsvParserContoller;
import models.disciplina.DisciplinaModel;

import java.util.List;

public class DisciplinasView {
    private DisciplinaCsvParserContoller disciplinaCsvParserContoller;
    private List<Integer> fields;

    public DisciplinasView(){
        this.disciplinaCsvParserContoller = new DisciplinaCsvParserContoller();
        this.fields = List.of(5,3,6,10,1,8,9);
    }

    public DisciplinasView(List<Integer> fields){
        this.disciplinaCsvParserContoller = new DisciplinaCsvParserContoller();
        this.fields = fields;
    }

    public void printDisciplinas(){
<<<<<<< HEAD
        List<DisciplinaModel> disciplinas = disciplinaCsvParserContoller.csvReader("disciplinas_2019.csv", this.fields);
=======
        List<DisciplinaModel> disciplinas = disciplinaCsvParserContoller.csvReader("app/resources/disciplinas_2019.csv", this.fields);
>>>>>>> Feat/implementing csv io (#4)
        for (DisciplinaModel disciplina : disciplinas) {
            System.out.println(disciplina.getCodigo() + " - " + disciplina.getNome());
        }
    }
}
