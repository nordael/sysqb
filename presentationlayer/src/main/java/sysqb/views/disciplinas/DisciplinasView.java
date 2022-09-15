package sysqb.views.disciplinas;

import controllers.disciplina.DisciplinaCsvParserContoller;
import models.disciplina.DisciplinaModel;
import java.util.List;
import java.util.ArrayList;
//import java.awt.*;

//import javax.print.DocFlavor.STRING;
//import javax.swing.*;
import javax.swing.table.*;

public class DisciplinasView extends AbstractTableModel {
    private DisciplinaCsvParserContoller disciplinaCsvParserContoller;
    private List<Integer> fields;
    private List<DisciplinaModel> disciplinasDoPeriodo;// usamos como dados uma lista genérica de Disciplina
    private List<String> disciplinasSelecionadas = new ArrayList<String>();// usamos como dados uma lista genérica de Disciplina

    private int periodo;

    // constantes p/identificar colunas
    private final int NOME = 0;
    private final int PERIODO = 1;
    private final int CODIGO = 2;
    private final int CH = 3;
    private final int SELECIONADA_QUEBRA = 4;

    private final String colunas[] = { "Nome:", "Período:", "Código:", "Carga Horária", "Selecionada" };

    public List<String> getDisciplinasSelecionadas() {
        return this.disciplinasSelecionadas;
    }

    public void setDisciplinasSelecionadas(List<String> listaSelecionadas) {
        this.disciplinasSelecionadas = listaSelecionadas;
    }

    @Override
    public int getColumnCount() {
        // retorna o total de colunas
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        // retorna o total de linhas na tabela
        return disciplinasDoPeriodo.size();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        // retorna o tipo de dado, para cada coluna
        switch (columnIndex) {
            case CODIGO:
                return String.class;
            case CH:
                return int.class;
            case PERIODO:
                return int.class;
            case NOME:
                return String.class;
            case SELECIONADA_QUEBRA:
                return Boolean.class;
            default:
                throw new IndexOutOfBoundsException("Coluna Inv�lida!!!");
        }

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
            case SELECIONADA_QUEBRA:
                List<String> disciplinas = getDisciplinasSelecionadas();
                if (disciplinas.contains(disciplina.getCodigo()))
                    return true;
                return false; 
            default:
                throw new IndexOutOfBoundsException("Coluna Inválida!!!");
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // metodo identifica qual coluna � editavel

        // s� iremos editar a coluna BENEFICIO,
        // que ser� um checkbox por ser boolean
        if (columnIndex == SELECIONADA_QUEBRA)
            return true;

        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        DisciplinaModel disciplina = disciplinasDoPeriodo.get(rowIndex);

        if (columnIndex == SELECIONADA_QUEBRA) {
            List<String> disciplinas = getDisciplinasSelecionadas();
            if (disciplinas.contains(disciplina.getCodigo())){
                disciplinas.remove(disciplina.getCodigo());
            }else{
                disciplinas.add(disciplina.getCodigo());
            }
            setDisciplinasSelecionadas(disciplinas);
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    public DisciplinasView() {
        this.disciplinaCsvParserContoller = new DisciplinaCsvParserContoller();
        this.fields = List.of(5, 3, 6, 10, 1, 8, 9);
        this.periodo = 1;
        this.disciplinasDoPeriodo = getListaDisciplinas(this.periodo, 2011);
    }

    public DisciplinasView(int periodo, int grade) {
        this.disciplinaCsvParserContoller = new DisciplinaCsvParserContoller();
        this.disciplinasDoPeriodo = getListaDisciplinas(periodo, grade);
    }

    private List<DisciplinaModel> getListaDisciplinas(int periodo, int grade) {
        List<DisciplinaModel> disciplinas = new ArrayList<DisciplinaModel>();

        if (grade == 2011) {
            disciplinas = disciplinaCsvParserContoller.csvReader("disciplinas_2011.csv", this.fields);
        } else {
            disciplinas = disciplinaCsvParserContoller.csvReader("disciplinas_2019.csv", this.fields);
        }

        List<DisciplinaModel> disciplinasPaginadas = new ArrayList<DisciplinaModel>();

        for (DisciplinaModel disciplina : disciplinas) {

            if (disciplina.getPeriodo() == periodo) {
                disciplinasPaginadas.add(disciplina);
            }
        }

        return disciplinasPaginadas;
    }

    // funcao para lidar com mudanca de periodo
    public void handlePeriodChange(int periodo, int grade) {
        this.disciplinasDoPeriodo = getListaDisciplinas(periodo, grade);
        fireTableDataChanged();
    }

    public void printDisciplinas() {
        List<DisciplinaModel> disciplinas = disciplinaCsvParserContoller.csvReader("disciplinas_2019.csv", this.fields);
        for (DisciplinaModel disciplina : disciplinas) {
            System.out.println(disciplina.getCodigo() + " - " + disciplina.getNome());
        }
    }

}
