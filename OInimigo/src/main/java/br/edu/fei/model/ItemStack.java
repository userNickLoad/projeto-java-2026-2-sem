/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.model;

import java.util.ArrayList;

/**
 * Essa classe implementa Stacks responsaveis por ter um item e guarda a sua 
 * quantidade
 * @author user
 */
class ItemStack {
    private Item item;
    private int amount;
    private ArrayList<InventorySlot> inventorySlots;
    
    public ItemStack(Item item){
        this.item = item;
        this.amount = 1;
    }
    
    public ItemStack(Item item, int amount){
        this.item = item;
        this.amount = amount;
    }
    
    /**
     * Aplica o item da stack em um personagem, decrementa a sua contagem e 
     * retorna se a stack continua valida ou não
     * 
     * @param caracter do tipo Caracter, personagem que terá o efeito aplicado
     * @return boolean true caso a stack se torne invalida
     */
    public boolean useItem(Caracter caracter){
        this.item.useItem(caracter);
        
        this.amount--;
        return this.amount <= 0;
    }
    
    /**
     * 
     * @return boolean confirmando se há espaço para adicionar na stack
     */
    public boolean isStackFull(){
        return item.getStackLimit() == this.amount;
    }
    
    /**
     * 
     * @param item do tipo Item
     * @return boolean confirmando se os items são do mesmo tipo
     */
    public boolean isStackable(Item item){
        return item == this.item;
    }
    
    /**
     * Esse metodo adiciona quantias de items para a stack e retorna o resto 
     * caso a quantia a ser adicionada + a quantia que já estava na stack 
     * superem o limite.
     * 
     * @param amount do tipo int, quantidade a ser adicionada a stack
     * @return int representando o resto que não pode ser adicionado
     */
    public int addToStack(int amount){
        int limit = this.item.getStackLimit();
        
        // calcula a quantia que pode ser adicionada
        int addable = limit - this.amount;  
        
        //calcula o resto que sobrara
        int rest = amount - addable;
        rest = (rest < 0)? 0: rest;
        
        //adiciona a stack de forma que ela não exceda seu limite
        this.amount += amount - rest;
        
        return rest;
    }
    
    /**
     * Adiciona a quantia de um stack a outro e sinaliza se esse outro pode ser 
     * deletado
     * 
     * @param s2 do tipo ItemStack, a stack a ser mergeada
     * @return boolean true quando o stack mergeado pode ser deletado
     */
    public boolean mergeStacks(ItemStack s2){
        // certifica se a operação pode ocorrer
        if(this.isStackFull() || !this.isStackable(s2.item))
            return false;
        
        // adiciona a quantia do s2 neste stack e atualiza a quantidade do s2
        s2.amount = addToStack(s2.amount);
        
        // retorna true caso o s2 não seja mais util
        return s2.amount <= 0;
    }
    
    public Item getItem(){
        return this.item;
    }
    
    public int getLimit(){
        return this.item.getStackLimit();
    }
    
    public int getAmount(){
        return this.amount;
    }
    
    public ArrayList<InventorySlot> getInventorySlots(){
        return this.inventorySlots;
    }
    
    public void setInventorySlots(ArrayList<InventorySlot> slots){
        this.inventorySlots = slots;
    }
}
