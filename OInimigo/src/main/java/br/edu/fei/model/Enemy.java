/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.model;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author user
 */
public class Enemy {
    
    private Item [] drops;
    private Caracter caracter;
    
    public Enemy(Caracter caracter, Item [] drops){
        this.caracter = caracter;
        this.drops = drops;
    }
    
    /**
     * Essa função sortea até 10 variedades de itens para serem dropados quando
     * o inimigo morre, também é sorteada a quantidade de itens que são dropados
     * 
     * @return ArrayList<ItemStack> contendo os itens e suas quantidades 
     * sorteadas
     */
    public ArrayList<ItemStack> dropItems(){
        ArrayList<ItemStack> drops = new ArrayList();
        
        Random random = new Random();
        
        // garante que a chance de nenhum item ser sorteado para aquela posição
        // seja de 25%
        int amount = this.drops.length;
        int amostralSpace = (amount + ((int)(amount * .5)));
        
        for(int i = 0; i < 10; i++){
            int num = random.nextInt(amostralSpace);
            
            // se nenhum item for sorteado, pula a inserção
            if(num >= amount) continue;
            
            Item item = this.drops[i];
            
            // cria uma stack com num items que nunca vai estar cheia ou ter 0
            // itens
            num = random.nextInt(((int)(item.getStackLimit() * .75)));
            num = (num == 0)? 1: num;
            drops.add(this.drops[i].createItemStack(num));
        }
        
        return drops;
    }
}
