
package br.edu.fei.view.battle;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AttackCard extends JPanel {

    private final JLabel nameLabel;
    private final JLabel diceLabel;
    private final JLabel effectsLabel;

    public AttackCard(String name, String dice, String effects) {

        setLayout(new GridBagLayout());

        nameLabel = new JLabel(name);
        diceLabel = new JLabel(dice, SwingConstants.CENTER);
        effectsLabel = new JLabel(effects, SwingConstants.CENTER);

        nameLabel.setHorizontalAlignment(SwingConstants.LEFT);

        setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                BorderFactory.createEmptyBorder(4, 8, 4, 8)
            )
        );

        setBackground(Color.WHITE);
        setOpaque(true);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(0, 3, 0, 3);

        // Nome: 40%
        gbc.gridx = 0;
        gbc.weightx = 0.40;
        add(nameLabel, gbc);

        // Quantidade de dados: 25%
        gbc.gridx = 1;
        gbc.weightx = 0.25;
        add(diceLabel, gbc);

        // Efeitos: 35%
        gbc.gridx = 2;
        gbc.weightx = 0.35;
        add(effectsLabel, gbc);
    }
}
