package br.edu.fei.view.battle;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author unifnavila
 */
public class LifeCard extends JPanel{
    public static int width;
    public static int height;
    
    private int x;
    private int y;
    
    private JLabel lblName;
    private JLabel lblVida;
    private JProgressBar progressLife;
    
    private String name;
    private int totalHealth;
    private int health;
    
    public LifeCard(String name, int totalHealth, int health, int x, int y){
        lblName = new JLabel();
        lblVida = new JLabel();
        progressLife = new JProgressBar(0, totalHealth);
        
        add(lblName);
        
        
    }
    
    public void setDimentions(int width, int height){
        this.width = width;
        this.height = height;
        
    }
    
    public void sethealth(int health){
        this.health = health;
    }
    
}
