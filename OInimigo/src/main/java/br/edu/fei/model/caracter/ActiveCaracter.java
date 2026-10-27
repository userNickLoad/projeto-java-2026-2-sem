package br.edu.fei.model.caracter;

import br.edu.fei.model.attack.ActiveAttack;
import br.edu.fei.model.attack.Attack;
import br.edu.fei.model.effect.ActiveEffect;
import br.edu.fei.model.effect.Effect;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nicol
 */
public class ActiveCaracter {
    private final Caracter caracter;
    private int health;
    private int attack;
    private ArrayList<ActiveEffect> effects;
    private ArrayList<ActiveAttack> attacks;
    
    public ActiveCaracter(Caracter caracter){
        this.caracter = caracter;
        this.health = caracter.getTotalHealth();
        this.attack = caracter.getTotalAttack();
        this.attacks = new ArrayList();
        this.effects = new ArrayList();
        
        for(Attack attack: caracter.ActiveAttacks())
            this.attacks.add(attack.activeAttack());
        
    }
    
    public ActiveCaracter(Caracter caracter, int health, int attack, ArrayList<ActiveEffect> effects, ArrayList<ActiveAttack> attacks){
        this.caracter = caracter;
        this.health = health;
        this.attack = attack;
        this.effects = effects;
        this.attacks = attacks;
    }
    
    /**
     * A função garante que o limite de minimo de vida é respeitado 
     * respeitado
     * 
     * @param damage do tipo int representa o dano a ser aplicado 
     */
    public void receiveDamage(int damage){
        this.health = (this.getHealth() > damage)? this.getHealth() - damage: 0;
    }
    
    /**
     * A função garante que o limite de máximo de vida é respeitado 
     * respeitado
     * 
     * @param healing do tipo int representa a cura a ser aplicado 
     */
    public void receiveHealing(int healing){
        this.health = (this.getHealth() > this.getCaracter().getTotalHealth())? this.getCaracter().getTotalHealth(): getHealth();
    }
    
    /**
     * Adiciona um efeito apenas se um igual não tiver sido aplicado antes, 
     * caso isso ocorra, acontece apenas a subistituição pelo novo
     * 
     * @param effect do tipo Effect é o efeito a ser aplicado no personagem
     */
    public void addEffect(Effect effect){
        ActiveEffect ae = new ActiveEffect(effect); //Inicia a contagem de rounds para expiração
        for(int i = 0; i < this.getEffects().size(); i++){
            if(effect.getName() == this.getEffects().get(i).getEffect().getName()){
                this.getEffects().set(i, ae); //substitui
                return;
            }
        }
        
        this.getEffects().add(ae); // adiciona
    }
    
    /**
     * Remove um determinado efeito
     * 
     * @param effect 
     */
    public void removeEffect(Effect effect){
        for(int i = 0; i < this.getEffects().size(); i++){
            if(effect.getName().equals(this.getEffects().get(i).getEffect().getName())){
                this.getEffects().remove(i); //remove
                return;
            }
        }
    }
    
    /**
     * Esse metodo é responsavel por aplicar os efeitos no personagem, calcular
     * a duração e ainda remover caso tenham expirado;
     */
    private void apllyEffects(){
        for(int i = 0; i < this.getEffects().size(); i++){
            ActiveEffect effect = this.getEffects().get(i);
            
            effect.apply(this);
            
            effect.decrementRoundDuration();
            
            if(effect.getLastingDuration() == 0){
                this.getEffects().remove(i);
                i -= 1;
            }
            
        }
    }

    /**
     * @return the caracter
     */
    public Caracter getCaracter() {
        return caracter;
    }

    /**
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * @return the attack
     */
    public int getAttack() {
        return attack;
    }

    /**
     * @return the effects
     */
    public ArrayList<ActiveEffect> getEffects() {
        return effects;
    }

    /**
     * @return the attacks
     */
    public ArrayList<ActiveAttack> getAttacks() {
        return attacks;
    }
    
    
}
