package sysqb.views.guiPrincipal;

import java.awt.Dimension;
import java.awt.FlowLayout;
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
    
 
    public GuiPrincipal() {
        //setando respectivamente...
        //titulo
        this.setTitle("Exemplo de Table Model");
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
    }
}