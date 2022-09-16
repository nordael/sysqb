/*
 * Created by JFormDesigner on Thu Sep 15 23:36:19 BRT 2022
 */

package sysqb.views.historico;

import java.awt.*;
import java.util.*;
import java.util.List;

import controllers.historico.HistoricoController;
import models.historico.HistoricoDisciplinaModel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.*;


public class HistoricoView extends JFrame {

    private final HistoricoController controller = new HistoricoController();
    private final List<HistoricoDisciplinaModel> historicoDisciplinaModelList = controller.getHistoricoModelList();

    private TableModel tableModel = new AbstractTableModel() {
        private final HistoricoController controller = new HistoricoController();
        private final List<HistoricoDisciplinaModel> historicoDisciplinaModelList = controller.getHistoricoModelList();

        @Override
        public int getRowCount() {
            return historicoDisciplinaModelList.size();
        }

        @Override
        public int getColumnCount() {
            return controller.getFieldsSize()-8;
        }

        @Override
        public Object getValueAt(int i, int i1) {
            return controller.getMember(historicoDisciplinaModelList.get(i), i1);
        }
    };

    public HistoricoView() {
        initComponents();
        initTable();

        nomeAluno.setText(historicoDisciplinaModelList.get(0).getNomeAluno());
        grrAluno.setText(historicoDisciplinaModelList.get(0).getGrr());
        nomeCurso.setText(historicoDisciplinaModelList.get(0).getNomeCurso());
        gradeValue.setText(historicoDisciplinaModelList.get(0).getVersaoGrade().getGrade());
    }

    public void initTable() {

        historicoTable.setModel(tableModel);
        historicoTable.setFillsViewportHeight(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Grace Joiler
        ResourceBundle bundle = ResourceBundle.getBundle("strings");
        panel1 = new JPanel();
        alunoLabel = new JLabel();
        nomeAluno = new JLabel();
        matriculaLabel = new JLabel();
        grrAluno = new JLabel();
        cursoLabel = new JLabel();
        nomeCurso = new JLabel();
        gradeLabel = new JLabel();
        gradeValue = new JLabel();
        scrollPane1 = new JScrollPane();
        historicoTable = new JTable();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "insets 0,hidemode 3",
            // columns
            "[fill]" +
            "[grow,fill]",
            // rows
            "[grow,fill]"));

        //======== panel1 ========
        {
            panel1.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                "[fill]",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //---- alunoLabel ----
            alunoLabel.setText(bundle.getString("HistoricoView.alunoLabel.text"));
            panel1.add(alunoLabel, "cell 0 0");

            //---- nomeAluno ----
            nomeAluno.setText(bundle.getString("HistoricoView.nomeAluno.text"));
            panel1.add(nomeAluno, "cell 1 0");

            //---- matriculaLabel ----
            matriculaLabel.setText(bundle.getString("HistoricoView.matriculaLabel.text"));
            panel1.add(matriculaLabel, "cell 0 1");

            //---- grrAluno ----
            grrAluno.setText(bundle.getString("HistoricoView.grrAluno.text"));
            panel1.add(grrAluno, "cell 1 1");

            //---- cursoLabel ----
            cursoLabel.setText(bundle.getString("HistoricoView.cursoLabel.text"));
            panel1.add(cursoLabel, "cell 0 2");

            //---- nomeCurso ----
            nomeCurso.setText(bundle.getString("HistoricoView.nomeCurso.text"));
            panel1.add(nomeCurso, "cell 1 2");

            //---- gradeLabel ----
            gradeLabel.setText(bundle.getString("HistoricoView.gradeLabel.text"));
            panel1.add(gradeLabel, "cell 0 3");

            //---- gradeValue ----
            gradeValue.setText(bundle.getString("HistoricoView.gradeValue.text"));
            panel1.add(gradeValue, "cell 1 3");
        }
        contentPane.add(panel1, "cell 0 0");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(historicoTable);
        }
        contentPane.add(scrollPane1, "cell 1 0");
        setSize(1040, 485);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Grace Joiler
    private JPanel panel1;
    private JLabel alunoLabel;
    private JLabel nomeAluno;
    private JLabel matriculaLabel;
    private JLabel grrAluno;
    private JLabel cursoLabel;
    private JLabel nomeCurso;
    private JLabel gradeLabel;
    private JLabel gradeValue;
    private JScrollPane scrollPane1;
    private JTable historicoTable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
