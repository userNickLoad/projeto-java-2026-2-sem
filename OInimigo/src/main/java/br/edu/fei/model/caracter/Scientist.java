/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.model.caracter;

import br.edu.fei.model.attack.Attack;

/**
 *
 * @author Nicol
 */
public class Scientist extends Caracter {
    private final int energy;

    public Scientist(String name, String image, int health, int attack, Attack [] attacks, int energy) {
        super(name, image, health, attack, attacks);
        
        this.energy = energy;
    }

    @Override
    public void die() {
         
    }

    @Override
    public void attackEnemy(Attack attack, ActiveCaracter enemy) {
        
    }
    
}
