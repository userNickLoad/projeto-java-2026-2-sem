/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.oinimigo.model;

/**
 *
 * @author nicolas
 */
public class ActiveEffect {
    private final Effect effect;
    private int lastingDuration;
    
    public ActiveEffect(Effect effect){
        this.effect = effect;
        this.lastingDuration = effect.getRoundDuration();
    }
    
    public void decrementRoundDuration(){
        this.lastingDuration -= (this.lastingDuration > 0)? 1: 0;
    }
    
    public Effect getEffect(){
        return this.effect;
    }
    
    public int getLastingDuration(){
        return this.lastingDuration;
    }
    
    public void apply(Caracter caracter){
        this.effect.apply(caracter);
    }
    
}
