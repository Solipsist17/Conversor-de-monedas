package com.oracle.views;

import com.oracle.models.RoundedButton;

import javax.swing.*;
import java.awt.*;

public class MenuView extends JFrame {

    private JPanel menuPanel, northPanel, southPanel, eastPanel, westPanel, centerPanel;
    private RoundedButton monedaButton, temperaturaButton, salirButton;

    public MenuView() {
        this.setTitle("Conversor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 700);
        this.setResizable(false);
        //this.pack();
        ImageIcon image = new ImageIcon(this.getClass().getClassLoader().getResource("images/alura-logo.png"));
        this.setIconImage(image.getImage());
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        menuPanel = new JPanel();
        menuPanel.setLayout(new BorderLayout());
        this.add(menuPanel);

        northPanel = new JPanel();
        southPanel = new JPanel();
        eastPanel = new JPanel();
        westPanel = new JPanel();

        JLabel tittleLabel = new JLabel("Elige una opción");
        tittleLabel.setVerticalAlignment(JLabel.CENTER);
        tittleLabel.setHorizontalAlignment(JLabel.CENTER);
        tittleLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        tittleLabel.setForeground(Color.WHITE);
        northPanel.setLayout(new BorderLayout());
        northPanel.add(tittleLabel, BorderLayout.CENTER);
        northPanel.setBackground(new Color(0X2A7AE4));

        //this.setLayout(new GridLayout(3, 3, 5, 5));
        centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 90));
        //centerPanel = new JPanel(new GridLayout(3, 1, 50, 50));
        //centerPanel.setBackground(Color.lightGray);
        centerPanel.setPreferredSize(new Dimension(100, 400));

        // JButton
        monedaButton = new RoundedButton("Conversor de moneda");
        temperaturaButton = new RoundedButton("Conversor de temperatura");
        salirButton = new RoundedButton("Salir");

        monedaButton.setPreferredSize(new Dimension(300, 50));
        monedaButton.setFocusable(false);
        monedaButton.setBackground(new Color(0X2A7AE4));
        monedaButton.setForeground(Color.WHITE);
        monedaButton.setFont(new Font("Arial", Font.PLAIN, 15));
        monedaButton.setBorderPainted(false);
        monedaButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        temperaturaButton.setFocusable(false);
        temperaturaButton.setPreferredSize(new Dimension(300, 50));
        temperaturaButton.setBackground(new Color(0X2A7AE4));
        temperaturaButton.setForeground(Color.WHITE);
        temperaturaButton.setFont(new Font("Arial", Font.PLAIN, 15));
        temperaturaButton.setBorderPainted(false);
        temperaturaButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        salirButton.setFocusable(false);
        salirButton.setPreferredSize(new Dimension(300, 50));
        salirButton.setBackground(new Color(0X2A7AE4));
        salirButton.setForeground(Color.WHITE);
        salirButton.setFont(new Font("Arial", Font.PLAIN, 15));
        salirButton.setBorderPainted(false);
        salirButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        centerPanel.add(monedaButton);
        centerPanel.add(temperaturaButton);
        centerPanel.add(salirButton);

        northPanel.setPreferredSize(new Dimension(100, 100));
        southPanel.setPreferredSize(new Dimension(100, 100));
        eastPanel.setPreferredSize(new Dimension(100, 100));
        westPanel.setPreferredSize(new Dimension(100, 100));

        menuPanel.add(northPanel, BorderLayout.NORTH);
        menuPanel.add(southPanel, BorderLayout.SOUTH);
        menuPanel.add(eastPanel, BorderLayout.EAST);
        menuPanel.add(westPanel, BorderLayout.WEST);
        menuPanel.add(centerPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public RoundedButton getMonedaButton() {
        return monedaButton;
    }

    public RoundedButton getTemperaturaButton() {
        return temperaturaButton;
    }

    public RoundedButton getSalirButton() {
        return salirButton;
    }

}

