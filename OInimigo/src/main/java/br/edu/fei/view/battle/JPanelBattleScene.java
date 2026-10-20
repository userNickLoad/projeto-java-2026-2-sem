package br.edu.fei.view.battle;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import javax.swing.JPanel;


/**
 *
 * @author nicolas
 */
public class JPanelBattleScene extends JPanel {

    public static final int WIDTH = 960;
    public static final int HEIGHT = 540;

    public JPanelBattleScene() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(new Color(190, 210, 180));
        setOpaque(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();

        // Céu
        g2.setColor(new Color(190, 210, 180));
        g2.fillRect(0, 0, getWidth(), getHeight());

        // Área de batalha
        g2.setColor(new Color(120, 155, 100));
        g2.fillOval(500, 100, 350, 120);

        g2.setColor(new Color(120, 155, 100));
        g2.fillOval(80, 320, 400, 140);

        // Inimigo: marcador temporário
        g2.setColor(new Color(90, 60, 100));
        g2.fillOval(620, 110, 70, 70);

        // Jogador visto de costas: marcador temporário
        g2.setColor(new Color(60, 80, 130));
        g2.fillRect(220, 350, 45, 65);

        g2.setColor(new Color(40, 50, 80));
        g2.fillOval(215, 330, 55, 45);

        g2.dispose();
    }
}

