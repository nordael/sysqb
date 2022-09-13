package app.sysqb;

import sysqb.views.disciplinas.DisciplinasView;
import sysqb.views.fomulario.DadoAlunoView;
import sysqb.views.guiPrincipal.GuiPrincipal;

import sysqb.views.historico.HistoricoView;

public class Main 
{
    public static void main(String[] args) {
        GuiPrincipal principal=new GuiPrincipal();
        principal.setVisible(true);
        HistoricoView historicoView = new HistoricoView();
        historicoView.printHistorico();
    }
}