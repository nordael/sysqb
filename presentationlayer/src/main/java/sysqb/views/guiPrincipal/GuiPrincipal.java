package sysqb.views.guiPrincipal;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import sysqb.views.disciplinas.DisciplinasView;

public class GuiPrincipal extends JFrame{
 
    private JTable table=new JTable();
    private DisciplinasView tableModel;
    
    private JButton btnNext=new JButton("Próximo período");
    private JButton btnPrev=new JButton("Período anterior");
    
    private int periodo = 1;
    private int grade = 2019;

    public GuiPrincipal() {
        //setando respectivamente...
        //titulo
        this.setTitle("Sistema de Quebra de Barreira");
        //layout
        this.setLayout(new FlowLayout());
        //tamanho do JFrame
        this.setSize(new Dimension(600, 400));
        //tipo de fechamento da janela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //centralizando a janela
        this.setLocationRelativeTo(null);
 
        //neste ponto é criado o modelo da JTable
        tableModel=new DisciplinasView();
 
        //setando propriedades da tabela...
        //modelo
        table.setModel(tableModel);
        //barra de rolagem
        table.setPreferredScrollableViewportSize(new Dimension(500,300));
        //auto ajuste na altura da tabela
        table.setFillsViewportHeight(true);
        //selecionar somente uma linha
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        
        //add a table ao scroll pane
        JScrollPane scrollPane=new JScrollPane(table);
        this.add(scrollPane);
        
        //add eventos aos botões
        btnNext.addActionListener(btnNextPageListener);
        btnPrev.addActionListener(btnPreviousPageListener);
       
        //add botões ao JFrame
        this.add(btnNext);
        this.add(btnPrev);
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    /*
     * Eventos do botões
     * */ 
    
     //evento p ir para periodo anterior
    private ActionListener btnPreviousPageListener=new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int curPeriod = getPeriodo(); 
            if (curPeriod > 1){
                setPeriodo(curPeriod-1);
                tableModel.handlePeriodChange(curPeriod-1, 2019);
            }
        }
    };

     //evento p ir para proximo periodo
    private ActionListener btnNextPageListener=new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int curPeriod =getPeriodo(); 
            if (curPeriod < 8){
                setPeriodo(curPeriod+1);
                tableModel.handlePeriodChange(curPeriod+1, 2019);
            }
        }
    };
    
}