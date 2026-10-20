/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.view;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Nicol
 */
public class JPanelSaveCard extends JPanel {

    private final JLabel nameLabel;
    private final JLabel dateLabel;
    private final JLabel enemyLabel;
    private final JLabel progressLabel;
    private final int id;

    public JPanelSaveCard(
            String saveName,
            String creationDate,
            String enemyName,
            int defeatedEnemies,
            int totalEnemies,
            int id) {
        
        this.id = id;
        
       setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        // Cabeçalho
        JPanel header = new JPanel(new GridLayout(2, 1));

        nameLabel = new JLabel(saveName);
        dateLabel = new JLabel(creationDate);

        nameLabel.setFont(
                nameLabel.getFont().deriveFont(Font.BOLD, 16f)
        );

        header.add(nameLabel);
        header.add(dateLabel);

        // Informações da batalha
        JPanel battleInfo = new JPanel(new GridLayout(2, 1, 0, 5));

        enemyLabel = new JLabel("Inimigo: " + enemyName);
        progressLabel = new JLabel(
                "Inimigos derrotados: "
                + defeatedEnemies + "/" + totalEnemies
        );

        battleInfo.add(enemyLabel);
        battleInfo.add(progressLabel);

        add(header, BorderLayout.NORTH);
        add(battleInfo, BorderLayout.CENTER);
        
        setAlignmentX(Component.LEFT_ALIGNMENT);
        
        setMaximumSize(new Dimension(
            Integer.MAX_VALUE,
            getPreferredSize().height
        ));
    }
    
    public JPanelSaveCard() {
    this(
        "Save_001",
        "19/10/2026 às 15:42",
        "The Skeleton King",
        3,
        5,
        0
    );
}
}
