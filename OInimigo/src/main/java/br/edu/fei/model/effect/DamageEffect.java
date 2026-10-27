/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.model.effect;

import br.edu.fei.model.caracter.ActiveCaracter;
import br.edu.fei.model.caracter.Caracter;

/**
 *
 * @author user
 */
public class DamageEffect extends Effect{
    private final int damage;

    public DamageEffect(String name, int roundDuration, int damage) {
        super(name, roundDuration);
        this.damage = damage;
    }

    @Override
    public void apply(ActiveCaracter caracter) {
        caracter.receiveDamage(damage);
    }
    
    @Override
    public ActiveEffect createActiveEffect(){
        return new ActiveEffect(this);
    }
    
}
