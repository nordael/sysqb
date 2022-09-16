/*
 * Created by JFormDesigner on Thu Sep 15 21:03:45 BRT 2022
 */

package sysqb.views.home;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import net.miginfocom.swing.*;
import sysqb.views.about.AboutView;
import sysqb.views.guiPrincipal.GuiPrincipal;
import sysqb.views.historico.HistoricoView;

public class HomeView extends JFrame {
    public HomeView() {
        String title = ResourceBundle.getBundle("strings").getString("HomeView.title");
        this.setTitle(title);
        initComponents();
    }

    private void closeApp(ActionEvent e) {
       this.dispose();
    }

    private void openFormularioView(ActionEvent e) {
        GuiPrincipal principal=new GuiPrincipal();
        principal.setVisible(true);
        principal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void openAboutView(ActionEvent e) {
        String title = ResourceBundle.getBundle("strings")
                .getString("AboutView.title.text");

        AboutView aboutView = new AboutView();
        aboutView.setTitle(title);
        aboutView.setVisible(true);
        aboutView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void openHistoricoView(ActionEvent e) {
        String title = ResourceBundle.getBundle("strings")
                .getString("HistoricoView.title.text");

        HistoricoView historicoView = new HistoricoView();
        historicoView.setTitle(title);
        historicoView.setVisible(true);
        historicoView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Grace Joiler
        ResourceBundle bundle = ResourceBundle.getBundle("strings");
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem3 = new JMenuItem();
        separator1 = new JSeparator();
        menuItem6 = new JMenuItem();
        menu3 = new JMenu();
        menuItem1 = new JMenuItem();
        menu2 = new JMenu();
        menuItem4 = new JMenuItem();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]"));

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText(bundle.getString("ConsultaMatriculaView.menu1.text"));

                //---- menuItem3 ----
                menuItem3.setText(bundle.getString("ConsultaMatriculaView.menuItem3.text"));
                menuItem3.addActionListener(e -> openFormularioView(e));
                menu1.add(menuItem3);
                menu1.add(separator1);

                //---- menuItem6 ----
                menuItem6.setText(bundle.getString("ConsultaMatriculaView.menuItem6.text"));
                menuItem6.addActionListener(e -> closeApp(e));
                menu1.add(menuItem6);
            }
            menuBar1.add(menu1);

            //======== menu3 ========
            {
                menu3.setText(bundle.getString("ConsultaMatriculaView.menu3.text"));

                //---- menuItem1 ----
                menuItem1.setText(bundle.getString("ConsultaMatriculaView.menuItem1.text"));
                menuItem1.addActionListener(e -> openHistoricoView(e));
                menu3.add(menuItem1);
            }
            menuBar1.add(menu3);

            //======== menu2 ========
            {
                menu2.setText(bundle.getString("ConsultaMatriculaView.menu2.text"));

                //---- menuItem4 ----
                menuItem4.setText(bundle.getString("ConsultaMatriculaView.menuItem4.text"));
                menuItem4.addActionListener(e -> openAboutView(e));
                menu2.add(menuItem4);
            }
            menuBar1.add(menu2);
        }
        setJMenuBar(menuBar1);
        setSize(615, 500);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Grace Joiler
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem3;
    private JSeparator separator1;
    private JMenuItem menuItem6;
    private JMenu menu3;
    private JMenuItem menuItem1;
    private JMenu menu2;
    private JMenuItem menuItem4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
