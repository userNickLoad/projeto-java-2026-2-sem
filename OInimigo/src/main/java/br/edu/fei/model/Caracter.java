package br.edu.fei.model;


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
    private int healthTotal;
    private int health;
    private int AttackTotal;
    private int attack;
    private ArrayList<ActiveEffect> effects;
    private ArrayList<Attack> attacks;
    
    /**
     * Construtor da classe personagem onde é iniciado 
     * @param name
     * @param image
     * @param health
     * @param attack 
     */
    public Caracter(String name, String image, int health, int attack) {
        
        super(name, image);
        
        this.healthTotal = health;
        this.health = health;
        this.health = health;
        this.AttackTotal = attack;
        this.attack = attack;
        this.attacks = new ArrayList();
        this.effects = new ArrayList();
    }
    
    /**
     * Esse metodo abstrato é implementado nas classes, onde é definido as 
     * regras de ataque de cada classe
     * 
     * @param attack do tipo Attack é o ataque aplicado no inimigo
     * @param enemy do tipo Caracter é o proprio inimigo
     */
    public abstract void  attackEnemy(Attack attack, Caracter enemy);
    
    /**
     * A função garante que o limite de minimo de vida é respeitado 
     * respeitado
     * 
     * @param damage do tipo int representa o dano a ser aplicado 
     */
    public void receiveDamage(int damage){
        this.health = (this.health > damage)? this.health - damage: 0;
    }
    
    /**
     * Metodo que deve implementar a ação de morrer
     */
    public abstract void die();
    
    /**
     * A função garante que o limite de máximo de vida é respeitado 
     * respeitado
     * 
     * @param healing do tipo int representa a cura a ser aplicado 
     */
    public void receiveHealing(int healing){
        this.health = (this.health > this.healthTotal)? healthTotal: health;
    }
    
    /**
     * Adiciona um efeito apenas se um igual não tiver sido aplicado antes, 
     * caso isso ocorra, acontece apenas a subistituição pelo novo
     * 
     * @param effect do tipo Effect é o efeito a ser aplicado no personagem
     */
    protected void addEffect(Effect effect){
        ActiveEffect ae = new ActiveEffect(effect); //Inicia a contagem de rounds para expiração
        for(int i = 0; i < this.effects.size(); i++){
            if(effect.getName() == this.effects.get(i).getEffect().getName()){
                this.effects.set(i, ae); //substitui
                return;
            }
        }
        
        this.effects.add(ae); // adiciona
    }
    
    /**
     * Remove um determinado efeito
     * 
     * @param effect 
     */
    protected void removeEffect(Effect effect){
        for(int i = 0; i < this.effects.size(); i++){
            if(effect.getName().equals(this.effects.get(i).getEffect().getName())){
                this.effects.remove(i); //remove
                return;
            }
        }
    }
    
    /**
     * Esse metodo é responsavel por aplicar os efeitos no personagem, calcular
     * a duração e ainda remover caso tenham expirado;
     */
    private void apllyEffects(){
        for(int i = 0; i < this.effects.size(); i++){
            ActiveEffect effect = this.effects.get(i);
            
            effect.apply(this);
            
            effect.decrementRoundDuration();
            
            if(effect.getLastingDuration() == 0){
                this.effects.remove(i);
                i -= 1;
            }
            
        }
        
    }
    
}
