package controllers.formulario;

import models.formulario.DadoAlunoModel;

public class DadoAlunoController {

    private DadoAlunoModel alunoModel = new DadoAlunoModel();

    public String getAlunoName(){
        return alunoModel.getName();
    }

    public void setAlunoName(String name){
        alunoModel.setNome(name);
    }
}
