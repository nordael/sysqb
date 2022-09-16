package controllers.historico;

import models.historico.HistoricoDisciplinaModel;

import java.util.List;

public class HistoricoController {

    private List<HistoricoDisciplinaModel> historicoModelList;
    private List<Integer> fields;
    public HistoricoController() {
        historicoModelList = List.of();
        fields = List.of(0,1,2,3,4,5,6,7,9,10,11,12,13,14,15);
    }

    public List<HistoricoDisciplinaModel> getHistoricoModelList() {
        HistoricoCsvParserController csvController = new HistoricoCsvParserController();

        historicoModelList = csvController.csvReader("historico.csv", fields);

        return historicoModelList;
    }

    public Integer getFieldsSize(){
        return fields.size();
    }

    public Object getMember(HistoricoDisciplinaModel model, int index){

        switch (index){
            case 0:
                return model.getAnoIngresso();
            case 1:
                return model.getMediaFinal();
            case 2:
                return model.getSituacao().getSituacao();
            case 3:
                return model.getCodigoDisciplina();
            case 4:
                return model.getNomeDisciplina();
            case 5:
                return model.getCargaHoraria();
            case 6:
                return model.getDisciplinaTipo().getTipo();
            case 7:
                return model.getFrequencia();
        }

        return null;
    }
}
