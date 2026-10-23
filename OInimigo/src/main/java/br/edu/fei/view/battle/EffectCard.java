
package br.edu.fei.view.battle;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class EffectCard extends JPanel {

    private final JLabel nameLabel;
    private final JLabel effectLabel;
    private final JLabel durationLabel;

    public EffectCard(
        String name,
        String effect,
        String duration
    ) {
        setLayout(new GridBagLayout());

        // Labels
        nameLabel = new JLabel(name);
        effectLabel = new JLabel(effect, SwingConstants.CENTER);
        durationLabel = new JLabel(duration, SwingConstants.CENTER);

        // Nome alinhado à esquerda
        nameLabel.setHorizontalAlignment(SwingConstants.LEFT);

        // Bordas e espaçamento interno
        setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                BorderFactory.createEmptyBorder(4, 8, 4, 8)
            )
        );

        // Cor de fundo
        setBackground(Color.WHITE);
        setOpaque(true);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;

        // Espaçamento entre as colunas
        gbc.insets = new Insets(0, 3, 0, 3);

        // Nome: 50%
        gbc.gridx = 0;
        gbc.weightx = 0.50;
        add(nameLabel, gbc);

        // Efeito: 25%
        gbc.gridx = 1;
        gbc.weightx = 0.25;
        add(effectLabel, gbc);

        // Duração: 25%
        gbc.gridx = 2;
        gbc.weightx = 0.25;
        add(durationLabel, gbc);
    }
}
