package br.edu.fei.view.battle;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JPanelBattle extends JLayeredPane {

    private final JPanelBattleScene scene;
    private final JPanelBattleInfo infoPanel;
    private final LifeCard enemy;
    private final LifeCard hero;
    private final BtnAction btnAtaque;
    private final BtnAction btnInventory;

    private final JPanel actionsPanel;

    // Container central e seu layout de alternância
    private final JPanel centerContainer;
    private final CardLayout centerLayout;

    // Lista de efeitos
    private final JPanel centerPanel;
    private final JScrollPane centerScrollPane;

    // Lista de ataques
    private final JPanel attacksPanel;
    private final JScrollPane attacksScrollPane;

    // Histórico de mensagens
    private final JTextArea messagesArea;
    private final JScrollPane logScrollPane;

    private boolean showingAttacks = false;

    private final String originalAttackText = "ATACAR";

    public static final int ATTACK = 1;
    public static final int INVENTORY = 2;
    
        // Inventário exibido sobre a batalha
    private final InventoryPanel inventoryPanel;
    private boolean showingInventory = false;

    public int mode;

    public JPanelBattle() {
        scene = new JPanelBattleScene();
        infoPanel = new JPanelBattleInfo();

        enemy = new LifeCard("inimigo", 100, 25);
        hero = new LifeCard("eu", 200, 100);

        btnAtaque = new BtnAction(originalAttackText);
        btnInventory = new BtnAction("INVENTARIO");
        
        // Inventário de teste: 5 linhas e 8 colunas
        inventoryPanel = new InventoryPanel(5, 8);
        inventoryPanel.setVisible(false);

        // O painel inferior não usará um layout automático.
        // As dimensões das colunas serão definidas no doLayout().
        infoPanel.setLayout(null);

        // Coluna esquerda: botões
        actionsPanel = new JPanel(new GridLayout(2, 1, 0, 10));
        actionsPanel.add(btnAtaque);
        actionsPanel.add(btnInventory);

        // Container central: tamanho independente das listas
        centerLayout = new CardLayout();
        centerContainer = new JPanel(centerLayout);

        centerPanel = new JPanel();
        centerPanel.setLayout(
            new BoxLayout(centerPanel, BoxLayout.Y_AXIS)
        );

        centerScrollPane = new JScrollPane(centerPanel);
        configureScrollPane(centerScrollPane);

        attacksPanel = new JPanel();
        attacksPanel.setLayout(
            new BoxLayout(attacksPanel, BoxLayout.Y_AXIS)
        );

        attacksScrollPane = new JScrollPane(attacksPanel);
        configureScrollPane(attacksScrollPane);

        centerContainer.add(centerScrollPane, "EFFECTS");
        centerContainer.add(attacksScrollPane, "ATTACKS");

        // Coluna direita: logs
        messagesArea = new JTextArea();
        messagesArea.setEditable(false);
        messagesArea.setLineWrap(true);
        messagesArea.setWrapStyleWord(true);

        logScrollPane = new JScrollPane(messagesArea);

        // Componentes do painel inferior
        infoPanel.add(actionsPanel);
        infoPanel.add(centerContainer);
        infoPanel.add(logScrollPane);

        // Alternância do botão
        btnAtaque.addActionListener(e -> toggleAttack());
        
        btnInventory.addActionListener(e -> toggleInventory());

        // Componentes da batalha
        add(scene, JLayeredPane.DEFAULT_LAYER);
        add(infoPanel, JLayeredPane.PALETTE_LAYER);
        add(enemy, JLayeredPane.PALETTE_LAYER);
        add(hero, JLayeredPane.PALETTE_LAYER);
        // Inventário acima dos demais componentes
        add(inventoryPanel, JLayeredPane.MODAL_LAYER);

        setPreferredSize(
            new Dimension(
                JPanelBattleScene.WIDTH,
                JPanelBattleScene.HEIGHT
            )
        );
    }

    private void configureScrollPane(JScrollPane scrollPane) {
        scrollPane.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );

        scrollPane.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        );

        // O conteúdo não determina as dimensões externas
        scrollPane.setMinimumSize(new Dimension(0, 0));
        scrollPane.setPreferredSize(new Dimension(0, 0));
    }

    @Override
    public void doLayout() {
        int width = getWidth();
        int height = getHeight();

        // Cenário ocupa toda a área
        scene.setBounds(0, 0, width, height);

        // Painel inferior
        int padding = 12;
        int panelWidth = (int) (width * 0.98);
        int panelHeight = 200;

        int xInfo = (width - panelWidth) / 2;
        int yInfo = height - panelHeight - padding;

        infoPanel.setBounds(
            xInfo,
            yInfo,
            panelWidth,
            panelHeight
        );

        // Define manualmente as dimensões das três colunas
        int infoWidth = infoPanel.getWidth();
        int infoHeight = infoPanel.getHeight();

        int outerPadding = 5;
        int gap = 10;

        int availableWidth =
            infoWidth - 2 * outerPadding - 2 * gap;

        int leftWidth = availableWidth / 4;
        int centerWidth = availableWidth / 2;
        int rightWidth = availableWidth
            - leftWidth
            - centerWidth;

        int contentHeight = infoHeight - 2 * outerPadding;
        int contentY = outerPadding;

        // Coluna esquerda: botões
        actionsPanel.setBounds(
            outerPadding,
            contentY,
            leftWidth,
            contentHeight
        );

        // Coluna central: mantém sempre a mesma largura
        int centerX = outerPadding + leftWidth + gap;

        centerContainer.setBounds(
            centerX,
            contentY,
            centerWidth,
            contentHeight
        );

        // Coluna direita: logs
        int rightX = centerX + centerWidth + gap;

        logScrollPane.setBounds(
            rightX,
            contentY,
            rightWidth,
            contentHeight
        );

        // Card do herói
        int lifeCardWidth = 200;
        int lifeCardHeight = 80;

        hero.setBounds(
            3 * width / 10,
            6 * height / 10,
            lifeCardWidth,
            lifeCardHeight
        );

        // Card do inimigo
        enemy.setBounds(
            6 * width / 10,
            3 * height / 10,
            lifeCardWidth,
            lifeCardHeight
        );
        
        // Centraliza o inventário na tela
        Dimension inventorySize = inventoryPanel.getPreferredSize();

        int inventoryX = (width - inventorySize.width) / 2;
        int inventoryY = (height - inventorySize.height) / 2;

        inventoryPanel.setBounds(
            inventoryX,
            inventoryY,
            inventorySize.width,
            inventorySize.height
        );
    }

    private void toggleAttack() {
        if (showingAttacks) {
            openEffects();
        } else {
            openAttack();
        }
    }

    public void openAttack() {
        showingAttacks = true;

        centerLayout.show(centerContainer, "ATTACKS");

        btnAtaque.setText("VOLTAR");
        btnAtaque.setBackground(Color.RED);
        btnAtaque.setForeground(Color.WHITE);
        btnAtaque.setOpaque(true);
        btnAtaque.setContentAreaFilled(true);
        btnAtaque.setBorderPainted(false);
    }

    public void openEffects() {
        showingAttacks = false;

        centerLayout.show(centerContainer, "EFFECTS");

        btnAtaque.setText(originalAttackText);

        // Restaura a aparência padrão do botão
        btnAtaque.setBackground(null);
        btnAtaque.setForeground(null);
        btnAtaque.setOpaque(false);
        btnAtaque.setContentAreaFilled(true);
        btnAtaque.setBorderPainted(true);
    }

    public void addEffect(
        String name,
        String effect,
        String duration
    ) {
        EffectCard card = new EffectCard(name, effect, duration);

        card.setAlignmentX(Component.LEFT_ALIGNMENT);
        card.setPreferredSize(new Dimension(0, 40));
        card.setMinimumSize(new Dimension(0, 40));
        card.setMaximumSize(
            new Dimension(Integer.MAX_VALUE, 40)
        );

        centerPanel.add(card);
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    public void addAttack(
        String name,
        String dice,
        String effects
    ) {
        AttackCard card = new AttackCard(name, dice, effects);

        card.setAlignmentX(Component.LEFT_ALIGNMENT);
        card.setPreferredSize(new Dimension(0, 40));
        card.setMinimumSize(new Dimension(0, 40));
        card.setMaximumSize(
            new Dimension(Integer.MAX_VALUE, 40)
        );

        attacksPanel.add(card);
        attacksPanel.revalidate();
        attacksPanel.repaint();
    }

    public void addLog(String message) {
        messagesArea.append(message + "\n");

        messagesArea.setCaretPosition(
            messagesArea.getDocument().getLength()
        );
    }
    
    private void toggleInventory() {
        if (showingInventory) {
            closeInventory();
        } else {
            openInventory();
        }
    }
    

    public void openInventory() {
        showingInventory = true;

        inventoryPanel.setVisible(true);

        btnInventory.setBackground(Color.RED);
        btnInventory.setForeground(Color.WHITE);
        btnInventory.setOpaque(true);
        btnInventory.setContentAreaFilled(true);
        btnInventory.setBorderPainted(false);

        // Garante que o inventário continue na camada superior
        setLayer(inventoryPanel, JLayeredPane.MODAL_LAYER);
        repaint();
    }

    public void closeInventory() {
        showingInventory = false;

        inventoryPanel.setVisible(false);

        // Restaura a aparência padrão do botão
        btnInventory.setBackground(null);
        btnInventory.setForeground(null);
        btnInventory.setOpaque(false);
        btnInventory.setContentAreaFilled(true);
        btnInventory.setBorderPainted(true);

        repaint();
    }
}