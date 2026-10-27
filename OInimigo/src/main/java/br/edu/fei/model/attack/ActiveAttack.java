/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.model.attack;

import br.edu.fei.model.caracter.ActiveCaracter;

/**
 *
 * @author Nicol
 */
public class ActiveAttack {
    private final Attack attack;
    private int powerPoints;
    
    public ActiveAttack(Attack attack){
        this.attack = attack;
        this.powerPoints = attack.getPowerPoints();
    }
    
    public void attack(ActiveCaracter me, ActiveCaracter enemy){
        this.attack.attack(me, enemy);
    };
}
