/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.model.effect;

/**
 *
 * @author Nicol
 */
public class ProtectionActiveEffect extends ActiveEffect{
    private int health = 0;

    public ProtectionActiveEffect(Effect effect) {
        super(effect);
        
        this.health = ((ProtectionEffect) this.getEffect()).getHealth();
    }
    
    public int getHealth(){
        return this.health;
    }
    
    protected boolean isUp(){
        return health > 0;
    }
    
    protected int absorbDamage(int damage){
        ProtectionEffect pe = (ProtectionEffect) this.getEffect();
        
        this.receiveDamage(damage);
        
        return pe.absorveDamage(damage);
    }
    
    protected void receiveDamage(int damage){
        this.health = (this.health > damage)? this.health - damage: 0;
    }
    
}
