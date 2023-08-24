package com.oracle.views;

import com.oracle.models.RoundedButton;

import javax.swing.*;
import java.awt.*;

public class MonedaView extends JFrame {

    private JPanel mainPanel, northPanel, southPanel, eastPanel, westPanel, centerPanel;
    private JComboBox<String> opcionesCmb;
    private JTextField valorTxt;
    private RoundedButton aceptarBtn, volverBtn;

    public MonedaView() {
        this.setTitle("Conversor de moneda");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 700);
        this.setResizable(false);
        //this.pack();
        ImageIcon image = new ImageIcon(this.getClass().getClassLoader().getResource("images/alura-logo.png"));
        this.setIconImage(image.getImage());
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        this.add(mainPanel);

        northPanel = new JPanel();
        southPanel = new JPanel();
        eastPanel = new JPanel();
        westPanel = new JPanel();
        centerPanel = new JPanel();

        //northPanel.setBackground(Color.RED);
        //centerPanel.setBackground(Color.lightGray);

        centerPanel.setLayout(new GridLayout(8, 1, 0, 20));
        //centerPanel.setPreferredSize(new Dimension(100, 100));

        JLabel cantidadLbl = new JLabel("Ingrese la cantidad a convertir");
        cantidadLbl.setFont(new Font("Arial", Font.PLAIN, 15));
        centerPanel.add(cantidadLbl);

        valorTxt = new JTextField("1");
        valorTxt.setFont(new Font("Arial", Font.BOLD, 15));
        centerPanel.add(valorTxt);
        JLabel conversionLbl = new JLabel("Elija la moneda a la que desea convertir su dinero");
        conversionLbl.setFont(new Font("Arial", Font.PLAIN, 15));
        centerPanel.add(conversionLbl);

        opcionesCmb = new JComboBox<>(new String[]{
                "De Sol a Dólar", "De Sol a Euro", "De Sol a Libra esterlina", "De Sol a Yen japonés", "De Sol a Won surcoreano",
                "De Dólar a Sol", "De Euro a Sol", "De Libra esterlina Sol", "De Yen japonés a Sol", "De Won surcoreano a Sol"
        });
        centerPanel.add(opcionesCmb);
        centerPanel.add(new JLabel(""));
        centerPanel.add(new JLabel(""));
        aceptarBtn = new RoundedButton("Aceptar");
        aceptarBtn.setFocusable(false);
        aceptarBtn.setBackground(new Color(0X2A7AE4));
        aceptarBtn.setForeground(Color.WHITE);
        aceptarBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        aceptarBtn.setBorderPainted(false);
        aceptarBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        /*aceptarBtn.addActionListener((e) -> {
            String opcionSeleccionada = (String) opcionesCmb.getSelectedItem();
            JOptionPane.showConfirmDialog(this, "El valor es: " + opcionSeleccionada, "De ´ ´ a ´ ´", JOptionPane.DEFAULT_OPTION);
        });*/

        centerPanel.add(aceptarBtn);
        volverBtn = new RoundedButton("Volver");
        volverBtn.setFocusable(false);
        volverBtn.setBackground(new Color(0X2A7AE4));
        volverBtn.setForeground(Color.WHITE);
        volverBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        volverBtn.setBorderPainted(false);
        volverBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        centerPanel.add(volverBtn);

        northPanel.setPreferredSize(new Dimension(100, 100));
        southPanel.setPreferredSize(new Dimension(100, 100));
        eastPanel.setPreferredSize(new Dimension(100, 100));
        westPanel.setPreferredSize(new Dimension(100, 100));

        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        mainPanel.add(eastPanel, BorderLayout.EAST);
        mainPanel.add(westPanel, BorderLayout.WEST);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }


    public RoundedButton getAceptarBtn() {
        return aceptarBtn;
    }

    public RoundedButton getVolverBtn() {
        return volverBtn;
    }

    public JComboBox<String> getOpcionesCmb() {
        return opcionesCmb;
    }

    public JTextField getValorTxt() {
        return valorTxt;
    }
}
