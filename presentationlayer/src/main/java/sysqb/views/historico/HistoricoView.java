package sysqb.views.historico;

import controllers.historico.HistoricoCsvParserController;
import models.disciplina.DisciplinaModel;
import models.historico.HistoricoDisciplinaModel;
import models.historico.HistoricoModel;

import java.util.List;

public class HistoricoView {
    private HistoricoCsvParserController csvParserController;

    private List<Integer> fields;

    public HistoricoView(){
        csvParserController = new HistoricoCsvParserController();
        fields = List.of(0,1,2,3,4,5,6,7,9,10,11,12,13,14,15,16);
    }

    public HistoricoView(List<Integer> fields) {
        csvParserController = new HistoricoCsvParserController();
        this.fields = fields;
    }

    public List<HistoricoDisciplinaModel> getListaMateriasHistorico(){
        List<HistoricoDisciplinaModel> historicoDisciplina = csvParserController
                .csvReader("historico.csv", this.fields);
        return historicoDisciplina; 
    }

    public void printHistorico(){
        List<HistoricoDisciplinaModel> historicoDisciplina = csvParserController
                .csvReader("historico.csv", this.fields);

        for (HistoricoDisciplinaModel historico : historicoDisciplina) {
            System.out.println(historico.getCodigoDisciplina() + " - " + historico.getGrr());
        }
    }
    public void writeHistorico(){
        List<HistoricoDisciplinaModel> historicoDisciplina = csvParserController
                .csvReader("historico.csv", this.fields);

        csvParserController.csvWriter("historico_tmp.csv", this.fields, historicoDisciplina);
    }
}
