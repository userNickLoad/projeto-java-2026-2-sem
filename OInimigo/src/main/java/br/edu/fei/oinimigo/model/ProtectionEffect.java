/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.oinimigo.model;
/**
 *
 * @author user
 */
public class ProtectionEffect extends Effect{
    private final int health;
    private final double absorption;

    public ProtectionEffect(String name, int roundDuration, int health,
            float absorption) {
        super(name, roundDuration);
        
        this.health = health;
        this.absorption = absorption;
    }

    @Override
    public void apply(Caracter caracter) {
        // faz nada
    }
    
    public int getHealth(){
        return this.health;
    }
    
    public int absorveDamage(int damage){
        return (int) Math.ceil(damage * this.absorption);
    }
    
}
