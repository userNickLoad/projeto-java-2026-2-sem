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
    private int health = 0;
    
    public ActiveEffect(Effect effect){
        this.effect = effect;
        this.lastingDuration = effect.getRoundDuration();
        
        if(effect instanceof ProtectionEffect){
            this.health = ((ProtectionEffect) effect).getHealth();
        }
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
    
    public int getHealth(){
        return this.health;
    }
    
    public void apply(Caracter caracter){
        this.effect.apply(caracter);
    }
    
    protected int absorbDamage(int damage){
        if(!(effect instanceof ProtectionEffect))
            return 0;
        
        ProtectionEffect pe = (ProtectionEffect) effect;
        
        this.receiveDamage(damage);
        
        return pe.absorveDamage(damage);
    }
    
    protected boolean isUp(){
        return health > 0;
    }
    
    protected void receiveDamage(int damage){
        if(!(effect instanceof ProtectionEffect))
            return;
        
        this.health = (this.health > damage)? this.health - damage: 0;
    }
    
}
