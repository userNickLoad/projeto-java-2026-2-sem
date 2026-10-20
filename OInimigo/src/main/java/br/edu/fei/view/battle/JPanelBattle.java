/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.view.battle;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JLayeredPane;

/**
 *
 * @author nicolas
 */
public class JPanelBattle extends JLayeredPane {

    private final JPanelBattleScene scene;
    private final JPanelBattleInfo infoPanel;
    private final JPanelBattleInfo actionsPanel;
    private final JPanelBattleInfo enemy;
    private final JPanelBattleInfo hero;

    public JPanelBattle() {
        scene = new JPanelBattleScene();
        infoPanel = new JPanelBattleInfo();
        actionsPanel = new JPanelBattleInfo();
        enemy = new JPanelBattleInfo();
        hero = new JPanelBattleInfo();
        
        add(scene, JLayeredPane.DEFAULT_LAYER);
        add(infoPanel, JLayeredPane.PALETTE_LAYER);
        add(actionsPanel, JLayeredPane.PALETTE_LAYER);

        setPreferredSize(
            new Dimension(
                JPanelBattleScene.WIDTH,
                JPanelBattleScene.HEIGHT
            )
        );
    }

    @Override
    public void doLayout() {
        int width = getWidth();
        int height = getHeight();

        // O cenário ocupa toda a área.
        scene.setBounds(0, 0, width, height);
        
        int padding = 12;
        int border = 1;

        // Barra com 95% da largura, centralizada horizontalmente.
        int panelWidth = (int) (width * 0.98);
        int panelHeight = 200;

        int x_info = (width - panelWidth) / 2;
        int y_info = (height - panelHeight - padding);

        infoPanel.setBounds(
            x_info,
            y_info,
            panelWidth,
            panelHeight
        );
        
        int actionsWidth = (int)(panelHeight * 1.5);
        int actionsHeight = height - (panelHeight + 3*(padding));
        
        int x_actions = width - actionsWidth - padding;
        int y_actions = padding;
        
        actionsPanel.setBounds(
                x_actions,
                y_actions,
                actionsWidth,
                actionsHeight
        );
        
//        int lifeCard = 
//        
//        int x_hero = 6*height/10;
//        int y_hero = 4*width/10;
        
    }
}

