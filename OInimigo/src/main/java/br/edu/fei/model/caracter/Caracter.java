package br.edu.fei.model.caracter;


import br.edu.fei.model.attack.Attack;
import br.edu.fei.model.GameObject;
import br.edu.fei.model.effect.ActiveEffect;
import br.edu.fei.model.effect.Effect;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nicolas
 */
public abstract class Caracter  extends GameObject{
    private final int healthTotal;
    private final int health;
    private final int AttackTotal;
    private final int attack;
    private final Attack [] attacks;
    
    /**
     * Construtor da classe personagem onde é iniciado 
     * @param name
     * @param image
     * @param health
     * @param attack 
     */
    public Caracter(String name, String image, int health, int attack, Attack [] attacks) {
        
        super(name, image);
        
        this.healthTotal = health;
        this.health = health;
        this.AttackTotal = attack;
        this.attack = attack;
        this.attacks = attacks;
    }
    
    public int getTotalHealth(){
        return this.health;
    }
    
    public int getTotalAttack(){
        return this.attack;
    }
    
    public Attack [] ActiveAttacks(){
        return this.attacks;
    }
    
    /**
     * Esse metodo abstrato é implementado nas classes, onde é definido as 
     * regras de ataque de cada classe
     * 
     * @param attack do tipo Attack é o ataque aplicado no inimigo
     * @param enemy do tipo Caracter é o proprio inimigo
     */
    public abstract void attackEnemy(Attack attack, ActiveCaracter enemy);
    
    /**
     * Metodo que deve implementar a ação de morrer
     */
    public abstract void die();
    
}
