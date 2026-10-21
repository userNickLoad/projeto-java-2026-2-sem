/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.view.battle;

/**
 *
 * @author nicolas
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class JPanelBattleInfo extends JPanel {

    public JPanelBattleInfo() {
        setOpaque(true);
        setBackground(new Color(245, 245, 245, 230));

        // Borda temporária de 1 pixel.
        setBorder(
            BorderFactory.createLineBorder(Color.BLACK, 1, true)
        );

        setPreferredSize(new Dimension(0, 100));
    }
    
    public JPanelBattleInfo(LayoutManager lm) {
        super(lm);
        
        setOpaque(true);
        setBackground(new Color(245, 245, 245, 230));

        // Borda temporária de 1 pixel.
        setBorder(
            BorderFactory.createLineBorder(Color.BLACK, 1, true)
        );

        setPreferredSize(new Dimension(0, 100));
    }
}
