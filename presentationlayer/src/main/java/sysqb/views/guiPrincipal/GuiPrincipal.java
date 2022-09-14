package sysqb.views.guiPrincipal;

import sysqb.views.historico.HistoricoView;
import models.historico.HistoricoModel;
import models.historico.SituacaoTipo;
import models.historico.HistoricoDisciplinaModel;

import java.util.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

import sysqb.views.disciplinas.DisciplinasView;

public class GuiPrincipal extends JFrame {

    private JTable table = new JTable();
    private DisciplinasView tableModel;

    private Hashtable<String, HistoricoDisciplinaModel> disciplinasCursadasDic = new Hashtable<String, HistoricoDisciplinaModel>();

    private JButton btnNext = new JButton("Próximo período");
    private JButton btnPrev = new JButton("Período anterior");

    private int periodo;
    private int grade;

    public GuiPrincipal() {

        Integer[] options = { 2019, 2011};
        int grade = (Integer) JOptionPane.showInputDialog(null, "Escolha sua grade curricular:",
                "Grade Curricular", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        setGrade(grade); 

        // setando respectivamente...
        // titulo
        this.setTitle("Sistema de Quebra de Barreira");
        // layout
        this.setLayout(new FlowLayout());
        // tamanho do JFrame
        this.setSize(new Dimension(1000, 600));
        // tipo de fechamento da janela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // centralizando a janela
        this.setLocationRelativeTo(null);

        // neste ponto é criado o modelo da JTable
        tableModel = new DisciplinasView();
        HistoricoView historicoView = new HistoricoView();
        setDisciplinasCursadasDic(historicoView.getListaMateriasHistorico());

        // setando propriedades da tabela...
        // modelo
        table.setModel(tableModel);
        // barra de rolagem
        table.setPreferredScrollableViewportSize(new Dimension(1000, 300));
        // auto ajuste na altura da tabela
        table.setFillsViewportHeight(true);
        // selecionar somente uma linha
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JTable table = new JTable(tableModel) {

            Hashtable<String, HistoricoDisciplinaModel> dicionarioMaterias = getDicionarioMateriasCursadas();

            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                String codigoDisci = (String) getValueAt(row, 2);

                if (dicionarioMaterias.containsKey(codigoDisci)) {
                    HistoricoDisciplinaModel disciplina = dicionarioMaterias.get(codigoDisci);
                    SituacaoTipo situacao = disciplina.getSituacao();

                    // System.out.println("PASSOU"+situacao);

                    if (situacao.getSituacao().equals("Aprovado")) {
                        c.setBackground(Color.green);
                    } else if (situacao.getSituacao().equals("Reprovado por nota")) {
                        c.setBackground(Color.red);
                    } else if (situacao.getSituacao().equals("Reprovado por frequência")) {
                        c.setBackground(Color.red);
                    } else if (situacao.getSituacao().equals("Matrícula")) {
                        c.setBackground(Color.blue);
                    }
                } else {
                    // se a disciplina nao esta no historico, entao nao foi cursada
                    c.setBackground(Color.gray);
                }

                return c;
            }
        };

        table.setPreferredScrollableViewportSize(new Dimension(900,300));

        table.getColumnModel().getColumn(0).setPreferredWidth(500);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        
        //auto ajuste na altura da tabela
        table.setFillsViewportHeight(true);
        // selecionar somente uma linha
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 
        // add a table ao scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);

        // add eventos aos botões
        btnNext.addActionListener(btnNextPageListener);
        btnPrev.addActionListener(btnPreviousPageListener);

        // add botões ao JFrame
        this.add(btnNext);
        this.add(btnPrev);
    }

    public void setDisciplinasCursadasDic(List<HistoricoDisciplinaModel> listaDisciplinasHist) {
        for (HistoricoDisciplinaModel disciplinaHistorico : listaDisciplinasHist) {
            disciplinasCursadasDic.put(disciplinaHistorico.getCodigoDisciplina(), disciplinaHistorico);
        }
    }

    public Hashtable<String, HistoricoDisciplinaModel> getDicionarioMateriasCursadas() {
        return this.disciplinasCursadasDic;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    /*
     * Eventos do botões
     */

    // evento p ir para periodo anterior
    private ActionListener btnPreviousPageListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int curPeriod = getPeriodo();
            if (curPeriod > 1) {
                setPeriodo(curPeriod - 1);
                tableModel.handlePeriodChange(curPeriod - 1, getGrade());
            }
        }
    };

    // evento p ir para proximo periodo
    private ActionListener btnNextPageListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int curPeriod = getPeriodo();
            if (curPeriod < 8) {
                setPeriodo(curPeriod + 1);
                tableModel.handlePeriodChange(curPeriod + 1, getGrade());
            }
        }
    };

}