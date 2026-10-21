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
    private final LifeCard enemy;
    private final LifeCard hero;

    public JPanelBattle() {
        scene = new JPanelBattleScene();
        infoPanel = new JPanelBattleInfo();
        actionsPanel = new JPanelBattleInfo();
        enemy = new LifeCard("inimigo", 100, 25);
        hero = new LifeCard("eu", 200, 100);
        
        add(scene, JLayeredPane.DEFAULT_LAYER);
        add(infoPanel, JLayeredPane.PALETTE_LAYER);
        add(actionsPanel, JLayeredPane.PALETTE_LAYER);
        add(enemy, JLayeredPane.PALETTE_LAYER);
        add(hero, JLayeredPane.PALETTE_LAYER);

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
        
        int lifeCardWidth = 200;
        int lifeCardHeight = 80;

        int x_hero = 3*width/10;
        int y_hero = 6*height/10;
     
        hero.setBounds(x_hero, y_hero, lifeCardWidth, lifeCardHeight);
        
        int x_enemy = 6*width/10;
        int y_enemy = 3*height/10;
        
        enemy.setBounds(x_enemy, y_enemy, lifeCardWidth, lifeCardHeight);
        
    }
}

