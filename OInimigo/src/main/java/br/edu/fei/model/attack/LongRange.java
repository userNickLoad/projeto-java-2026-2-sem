/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.model.attack;

import br.edu.fei.model.caracter.ActiveCaracter;
import br.edu.fei.model.effect.Effect;

/**
 *
 * @author Nicol
 */
public class LongRange extends Attack{
    private final int ammunationCost;

    public LongRange(String name, String description, int attack, Effect[] effects, int powerPoints, int ammunationCost) {
        super(name, description, attack, effects, powerPoints);
        
        this.ammunationCost = ammunationCost;
    }

    @Override
    public void attack(ActiveCaracter me, ActiveCaracter enemy) {
        enemy.receiveDamage(this.getAttack() + me.getAttack());
    }
    
}
