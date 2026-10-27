/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.model.effect;

import br.edu.fei.model.caracter.ActiveCaracter;
import br.edu.fei.model.caracter.Caracter;

/**
 *
 * @author user
 */
public class AntidoteEffect extends Effect{
    private final Effect [] cures;
    
    public AntidoteEffect(String name, int roundDuration, Effect [] cures) {
        super(name, roundDuration);
        this.cures = cures;
    }

    @Override
    public void apply(ActiveCaracter caracter) {
        for(Effect effect : this.cures){
            caracter.removeEffect(effect);
        }
    }
    
    @Override
    public ActiveEffect createActiveEffect(){
        return new ActiveEffect(this);
    }
    
}
