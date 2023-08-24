package com.oracle.views;

import javax.swing.*;
import java.awt.*;

public class TemperaturaView extends JFrame {

    private JPanel mainPanel, northPanel, southPanel, eastPanel, westPanel, centerPanel;

    public TemperaturaView() {
        this.setTitle("Conversor de temperatura");
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

}
