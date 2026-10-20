/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.model;

/**
 *
 * @author user
 */
public class Item extends GameObject{
    private final boolean [][] grid; 
    private final int stackLimit;
    private final String description;
    private final ItemStack [] craftingItems;
    private final Effect [] effects;

    public Item(String name, String image, String description, int stackLimit, 
            boolean [][] grid, ItemStack [] craftingItems, Effect [] effects) {
        super(name, image);
        
        this.description = description;
        this.stackLimit = stackLimit;
        this.grid = grid;
        this.craftingItems = craftingItems;
        this.effects = effects;
    }
    
    public void useItem(Caracter caracter){
        for(Effect effect: this.effects){
            caracter.addEffect(effect);
        }
    }
    
    public boolean [][] getGrid(){
        return this.grid;
    }
    
    public int getStackLimit(){
        return this.stackLimit;
    }
    
    public ItemStack [] craftingItems(){
        return this.craftingItems;
    }
    
    public Effect [] getEffects(){
        return this.effects;
    }
    
    public ItemStack createItemStack(int amount){
        return new ItemStack(this, amount);
    }
}
