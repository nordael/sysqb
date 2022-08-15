package app.sysqb;

import sysqb.views.fomulario.DadoAlunoView;

public class Main {
    public static void main(String[] args) {
        DadoAlunoView dadoAlunoView = new DadoAlunoView();
        System.out.println(dadoAlunoView.getAlunoController().getAlunoName());
    }
}