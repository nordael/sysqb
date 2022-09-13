package models.historico;

import java.util.ArrayList;

public class HistoricoModel {
    private ArrayList<HistoricoDisciplinaModel> historico;

    public HistoricoModel() {
        historico = new ArrayList<>();
    }

    public ArrayList<HistoricoDisciplinaModel> getHistorico() {
        return historico;
    }

    public void addDisciplina(HistoricoDisciplinaModel histDisciplina) {
        historico.add(histDisciplina);
    }

    public void removeDisciplina(HistoricoDisciplinaModel histDisciplina) {
        historico.remove(histDisciplina);
    }

    public void setHistorico(ArrayList<HistoricoDisciplinaModel> historico) {
        this.historico.addAll(historico);
    }
}
