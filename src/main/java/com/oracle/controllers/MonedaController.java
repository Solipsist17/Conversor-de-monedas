package com.oracle.controllers;

import com.oracle.models.MonedaModel;
import com.oracle.views.MenuView;
import com.oracle.views.MonedaView;

import javax.swing.*;
import java.io.IOException;

public class MonedaController {

    private final MonedaView monedaView;
    private final MonedaModel monedaModel;

    public MonedaController(MonedaView monedaView, MonedaModel monedaModel) {
        this.monedaView = monedaView;
        this.monedaModel = monedaModel;

        this.monedaView.getAceptarBtn().addActionListener((e) -> {
            String txtValue = this.monedaView.getValorTxt().getText();
            // validate
            if (!isValidValue(txtValue)) {
                JOptionPane.showConfirmDialog(this.monedaView, "El valor ' "+ txtValue + " ' no es válido", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                return;
            }

            double inValue = Double.parseDouble(txtValue);
            int selectedIndex = this.monedaView.getOpcionesCmb().getSelectedIndex();

            try {
                double outValue = this.monedaModel.convertir(inValue, selectedIndex);
                JOptionPane.showConfirmDialog(this.monedaView, "El resultado es: " + outValue, "Mensaje", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(this.getClass().getClassLoader().getResource("images/cambio-de-divisas.png")));
            } catch (RuntimeException | IOException ex) {
                JOptionPane.showConfirmDialog(null, "Error con el servidor: " + ex.getMessage(), "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            }
        });

        this.monedaView.getVolverBtn().addActionListener((e) -> {
            new MenuController(new MenuView());
            this.monedaView.dispose();
        });
    }

    private boolean isValidValue(String valorTxt) {
        try {
            Double.parseDouble(valorTxt);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
