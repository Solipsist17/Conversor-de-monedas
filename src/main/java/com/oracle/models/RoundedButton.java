package com.oracle.models;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedButton extends JButton {
    private static final int ARC_WIDTH = 20; // Radio horizontal del arco
    private static final int ARC_HEIGHT = 20; // Radio vertical del arco

    public RoundedButton(String text) {
        super(text);
        setFocusPainted(false); // Elimina el resaltado de enfoque al hacer click
        setContentAreaFilled(false); // Hace que el fondo del botón sea transparente
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        RoundRectangle2D.Float shape = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), ARC_WIDTH, ARC_HEIGHT);
        g2.setColor(getBackground());
        g2.fill(shape);
        g2.setColor(getForeground());
        g2.draw(shape);

        super.paintComponent(g2);
        g2.dispose();
    }
}

