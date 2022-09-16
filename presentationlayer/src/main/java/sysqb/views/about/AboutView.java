/*
 * Created by JFormDesigner on Thu Sep 15 22:46:37 BRT 2022
 */

package sysqb.views.about;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author Grace Joiler
 */
public class AboutView extends JFrame {
    public AboutView() {
        initComponents();
    }

    private void closeAboutView(ActionEvent e) {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Grace Joiler
        ResourceBundle bundle = ResourceBundle.getBundle("strings");
        contentPanel = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        buttonPanelAboutView = new JPanel();
        okButton = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //======== contentPanel ========
        {
            contentPanel.setLayout(new MigLayout(
                "insets dialog,hidemode 3,alignx center",
                // columns
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]"));

            //---- label1 ----
            label1.setText("Sistema de Quebra de Barreira - SysQB");
            contentPanel.add(label1, "cell 1 0 6 1");

            //---- label2 ----
            label2.setText("Autores:");
            contentPanel.add(label2, "cell 0 1");

            //---- label3 ----
            label3.setText(bundle.getString("AboutView.label3.text"));
            contentPanel.add(label3, "cell 1 2");

            //---- label4 ----
            label4.setText(bundle.getString("AboutView.label4.text"));
            contentPanel.add(label4, "cell 1 3");

            //---- label5 ----
            label5.setText(bundle.getString("AboutView.label5.text"));
            contentPanel.add(label5, "cell 1 4");

            //---- label6 ----
            label6.setText(bundle.getString("AboutView.label6.text"));
            contentPanel.add(label6, "cell 1 5");

            //======== buttonPanelAboutView ========
            {
                buttonPanelAboutView.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]" +
                    "[fill]" +
                    "[fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]"));

                //---- okButton ----
                okButton.setText(bundle.getString("AboutView.okButton.text"));
                okButton.addActionListener(e -> closeAboutView(e));
                buttonPanelAboutView.add(okButton, "cell 3 1 3 1,alignx center,growx 0");
            }
            contentPanel.add(buttonPanelAboutView, "cell 4 9 9 1");
        }
        contentPane.add(contentPanel, "cell 0 0");
        setSize(385, 250);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Grace Joiler
    private JPanel contentPanel;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JPanel buttonPanelAboutView;
    private JButton okButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
