package com.oracle.controllers;

import com.oracle.models.MonedaModel;
import com.oracle.views.MenuView;
import com.oracle.views.MonedaView;
import com.oracle.views.TemperaturaView;

import javax.swing.*;

public class MenuController {

    private final MenuView menuView;

    public MenuController(MenuView menuView) {
        this.menuView = menuView;

        this.menuView.getMonedaButton().addActionListener((e) -> {
            new MonedaController(new MonedaView(), new MonedaModel());
            this.menuView.dispose();
        });

        this.menuView.getTemperaturaButton().addActionListener((e) -> {
            //new TemperaturaView();
            //this.menuView.dispose();
            JOptionPane.showMessageDialog(null, "Work in progress");
        });

        this.menuView.getSalirButton().addActionListener((e) -> {
            this.menuView.dispose();
        });
    }

}
