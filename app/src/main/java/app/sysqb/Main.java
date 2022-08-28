package app.sysqb;

import sysqb.views.disciplinas.DisciplinasView;
import sysqb.views.fomulario.DadoAlunoView;

public class Main {
    public static void main(String[] args) {
        DisciplinasView disciplinasView = new DisciplinasView();
        disciplinasView.printDisciplinas();
    }
}