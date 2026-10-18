/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.oinimigo.model;

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
    public void apply(Caracter caracter) {
        caracter.receiveDamage(damage);
    }
    
}
