/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.view.battle;
import br.edu.fei.view.Colors;
import br.edu.fei.view.WindowSize;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JLayeredPane;

public class BattleCanvas extends JLayeredPane {

    public BattleCanvas() {
        setPreferredSize(new Dimension(
            WindowSize.WIDTH,
            WindowSize.HEIGHT
        ));

        setLayout(null);
        setOpaque(true);
        setBackground(Colors.deep);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Colors.deep);
        g.fillRect(
            0,
            0,
            getWidth(),
            getHeight()
        );
    }
}

