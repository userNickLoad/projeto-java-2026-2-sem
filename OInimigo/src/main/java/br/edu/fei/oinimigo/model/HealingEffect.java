/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.oinimigo.model;

/**
 *
 * @author nicolas
 */
public class HealingEffect extends Effect{
    private final int healing;

    public HealingEffect(String name, int roundDuration, int healing) {
        super(name, roundDuration);
        
        this.healing = healing;
    }

    @Override
    public void apply(Caracter caracter) {
        caracter.receiveHealing(this.healing);
    }
    
    @Override
    public ActiveEffect createActiveEffect(){
        return new ActiveEffect(this);
    }
    
}
