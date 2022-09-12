package sysqb.views.disciplinas;

import controllers.csvparser.DisciplinaCsvParserContoller;
import models.disciplina.DisciplinaModel;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class DisciplinasView extends AbstractTableModel{
    private DisciplinaCsvParserContoller disciplinaCsvParserContoller;
    private List<Integer> fields;
    private final List<DisciplinaModel> disciplinasDoPeriodo;// usamos como dados uma lista genérica de Disciplina

    private int periodo; 

    // constantes p/identificar colunas
    private final int NOME = 0;
    private final int PERIODO = 1;
    private final int CODIGO = 2;
    private final int CH = 3;
    private final String colunas[] = { "Nome:", "Período:", "Código:", "Carga Horária" };

    @Override
    public int getColumnCount() {
        // retorna o total de colunas
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        // retorna o total de linhas na tabela
        return fields.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // retorna o valor conforme a coluna e linha
        // pega o dados corrente da linha
        DisciplinaModel disciplina = disciplinasDoPeriodo.get(rowIndex);

        // retorna o valor da coluna
        switch (columnIndex) {
            case CODIGO:
                return disciplina.getCodigo();
            case CH:
                return disciplina.getCargaHoraria();
            case PERIODO:
                return disciplina.getPeriodo();
            case NOME:
                return disciplina.getNome();
            default:
                throw new IndexOutOfBoundsException("Coluna Inválida!!!");
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }
    
    public DisciplinasView(){
        this.disciplinaCsvParserContoller = new DisciplinaCsvParserContoller();
        this.fields = List.of(5,3,6,10,1,8,9);
        this.periodo = 1;
        this.disciplinasDoPeriodo = getListaDisciplinas(this.periodo);  
    }

    public DisciplinasView(List<Integer> fields){
        this.disciplinaCsvParserContoller = new DisciplinaCsvParserContoller();
        this.fields = fields;
        this.periodo = 1;
        this.disciplinasDoPeriodo = getListaDisciplinas(this.periodo); 
    }

    private List<DisciplinaModel> getListaDisciplinas(int periodo){
        List<DisciplinaModel> disciplinas = disciplinaCsvParserContoller.csvReader("disciplinas_2019.csv", this.fields);
        List<DisciplinaModel> disciplinasPaginadas = new ArrayList<DisciplinaModel>(); 

        for (DisciplinaModel disciplina : disciplinas) {
            if (disciplina.getPeriodo() == this.periodo){
                disciplinasPaginadas.add(disciplina); 
            }
        }

        return disciplinasPaginadas;
    }


    public void printDisciplinas(){
        List<DisciplinaModel> disciplinas = disciplinaCsvParserContoller.csvReader("disciplinas_2019.csv", this.fields);
        for (DisciplinaModel disciplina : disciplinas) {
            System.out.println(disciplina.getCodigo() + " - " + disciplina.getNome());
        }
    }

}
