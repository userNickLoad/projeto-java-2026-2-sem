package br.edu.fei.model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nicolas
 */
class Attack {
    private final String name;
    private final String description;
    private final int attack;
    private final Effect [] effects;
    private final int powerPoints;
    
    public Attack(String name, String description, int attack,
            Effect [] effects, int powerPoints){
        this.name = name;
        this.description = description;
        this.attack = attack;
        this.effects = effects;
        this.powerPoints = powerPoints;
    }
    
    public void attack(Caracter me, Caracter enemy){
        
    };
    
    
}
