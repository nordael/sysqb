package sysqb.views.fomulario;

import controllers.formulario.DadoAlunoController;

public class DadoAlunoView {
    private DadoAlunoController alunoController = new DadoAlunoController();
    public DadoAlunoView() {
        alunoController.setAlunoName("Aluno");
    }

    public DadoAlunoController getAlunoController(){
        return alunoController;
    }
}