package br.edu.fei.view.battle;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author unifnavila
 */
public class LifeCard extends JPanel{
    private JLabel lblName;
    private JLabel lblVida;
    private JProgressBar progressLife;
    
    private String name;
    private int totalHealth;
    private int health;
    
    public LifeCard(String name, int totalHealth, int health){
        this.name = name;
        this.totalHealth = totalHealth;
        this.health = health;   
        
        progressLife = new JProgressBar(0, totalHealth);
        setHealth(health);
        progressLife.setBackground(Color.DARK_GRAY); // Fundo da barra
        progressLife.setStringPainted(true);         // Exibe o valor em texto
        
        setLayout(new GridLayout(2, 1, 5, 5));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        
        lblName = new JLabel(name);
        lblName.setFont(new Font(Font.DIALOG, Font.PLAIN, 24));
        
        add(lblName);
        add(progressLife);
        
        
        
    }
    
    public void setHealth(int health){
        this.health = health;
        Color c;
        
        if(health > this.totalHealth * .75){
            c = Color.GREEN;
        }else if(health > this.totalHealth * .25){
            c = Color.YELLOW.darker();
        }else{
            c = Color.red;
        }
        
        progressLife.setValue(health);  
        progressLife.setForeground(c);  
    }
    
}
