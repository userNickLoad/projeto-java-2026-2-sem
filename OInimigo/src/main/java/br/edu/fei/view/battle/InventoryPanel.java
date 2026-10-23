package br.edu.fei.view.battle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import br.edu.fei.view.Colors;

public class InventoryPanel extends JPanel {

    private static final int SLOT_SIZE = 100;
    private static final int SLOT_GAP = 4;
    private static final int PADDING = 10;

    private final int rows;
    private final int columns;

    public InventoryPanel(int rows, int columns) {
        if (rows <= 0 || columns <= 0) {
            throw new IllegalArgumentException(
                "A quantidade de linhas e colunas deve ser positiva."
            );
        }

        this.rows = rows;
        this.columns = columns;

        // Fundo do inventário
        setBackground(Colors.primary);
        setOpaque(true);

        // Espaçamento entre os slots e nas bordas
        setBorder(
            BorderFactory.createEmptyBorder(
                PADDING, PADDING, PADDING, PADDING
            )
        );

        // Grade de slots
        setLayout(
            new GridLayout(rows, columns, SLOT_GAP, SLOT_GAP)
        );

        // Cria os slots vazios
        for (int i = 0; i < rows * columns; i++) {
            JPanel slot = new JPanel();

            slot.setBackground(Color.WHITE);
            slot.setOpaque(true);

            slot.setPreferredSize(
                new Dimension(SLOT_SIZE, SLOT_SIZE)
            );

            slot.setMinimumSize(
                new Dimension(SLOT_SIZE, SLOT_SIZE)
            );

            slot.setMaximumSize(
                new Dimension(SLOT_SIZE, SLOT_SIZE)
            );

            add(slot);
        }

        // Calcula o tamanho total da grade
        int width = columns * SLOT_SIZE
            + (columns - 1) * SLOT_GAP
            + 2 * PADDING;

        int height = rows * SLOT_SIZE
            + (rows - 1) * SLOT_GAP
            + 2 * PADDING;

        Dimension inventorySize = new Dimension(width, height);

        setPreferredSize(inventorySize);
        setMinimumSize(inventorySize);
        setMaximumSize(inventorySize);
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}