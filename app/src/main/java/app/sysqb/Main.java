package app.sysqb;


import sysqb.views.home.HomeView;

import javax.swing.*;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args) {
        HomeView homeView = new HomeView();
        homeView.setVisible(true);
        homeView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}