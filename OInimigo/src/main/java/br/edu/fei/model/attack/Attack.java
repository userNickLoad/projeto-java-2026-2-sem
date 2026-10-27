package br.edu.fei.model.attack;

import br.edu.fei.model.caracter.ActiveCaracter;
import br.edu.fei.model.caracter.Caracter;
import br.edu.fei.model.effect.Effect;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nicolas
 */
public abstract class Attack {
    private final String name;
    private final String description;
    private final int attack;
    private final Effect [] effects;
    private final int powerPoints;
    
    public Attack(String name, String description, int attack,
            Effect [] effects, int powerPoints){
        this.name = name;
        this.description = description;
        this.attack = attack;
        this.effects = effects;
        this.powerPoints = powerPoints;
    }
    
    public abstract void attack(ActiveCaracter me, ActiveCaracter enemy);
    
    public ActiveAttack activeAttack(){
        return new ActiveAttack(this);
    }
    
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
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
    public Effect[] getEffects() {
        return effects;
    }

    /**
     * @return the powerPoints
     */
    public int getPowerPoints() {
        return powerPoints;
    }
}
