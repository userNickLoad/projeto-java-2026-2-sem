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
public class ScientistAttack extends Attack{
    private final int energyCost;
    
    public ScientistAttack(String name, String description, int attack, Effect[] effects, int powerPoints, int energyCost) {
        super(name, description, attack, effects, powerPoints);
        
        this.energyCost = energyCost;
    }
    
    public int getEnergyCost(){
        return this.energyCost;
    }

    @Override
    public void attack(ActiveCaracter me, ActiveCaracter enemy) {
        me.receiveHealing(this.getAttack());
        enemy.receiveDamage(this.getAttack() + me.getAttack());
    }
}
