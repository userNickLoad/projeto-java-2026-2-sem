package br.edu.fei.model.effect;

import br.edu.fei.model.caracter.ActiveCaracter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nicolas
 */
public abstract class Effect {
    private final String name;
    private final int roundDuration;
    
    public Effect(String name, int roundDuration){
        this.name = name;
        this.roundDuration = roundDuration;
    }
            
    public String getName(){
        return this.name;
    }
    
    public int getRoundDuration(){
        return this.roundDuration;
    }
    
    public abstract void apply(ActiveCaracter caracter);
    
    public abstract ActiveEffect createActiveEffect();

}
