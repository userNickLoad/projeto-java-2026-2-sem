/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.oinimigo.model;

import java.util.ArrayList;

/**
 *
 * @author Nicol
 */
class Inventory {
    private ItemStack [][] grid;
    private ArrayList<ItemStack> items;
    
    public Inventory(int h, int l){
        this.grid = new ItemStack [h][l];
        this.items = new ArrayList<>();
    }
    
    public ItemStack getItem(int row, int col){
        return this.grid[row][col];
    };
    
    public ItemStack [][] getInventoryArea(int row, int col, ItemStack itemStack) throws ArrayIndexOutOfBoundsException{
        Item item = itemStack.getItem();
        
        int gridLimitX = item.getGrid().length;
        int gridLimitY = item.getGrid()[0].length;
        
        ItemStack [][] result = new ItemStack [gridLimitX][gridLimitY];
        
        for(int i = 0; i < gridLimitX; i++){
            for(int j = 0; j < gridLimitY; j++){
                result[i][j] = this.grid[i+row][j+col];
            }
        }
        
        return result;
    }
    
    public boolean isPlaceable(int row, int col, ItemStack itemStack) throws ArrayIndexOutOfBoundsException{
        Item item = itemStack.getItem();
        
        int gridLimitX = item.getGrid().length;
        int gridLimitY = item.getGrid()[0].length;
        
        for(int i = 0; i < gridLimitX; i++){
            for(int j = 0; j < gridLimitY; j++){
                if(item.getGrid()[i][j] == false)
                    continue;
                
                if(this.grid[i][j].getItem() == item)
                    return true;
                
                if(this.grid[i][j] != null)
                    return false;
            }
        }
        
        return true;
        
    }
    
    public ItemStack place(int row, int col, ItemStack itemStack) throws ArrayIndexOutOfBoundsException{
        Item item = itemStack.getItem();
        
        int gridLimitX = item.getGrid().length;
        int gridLimitY = item.getGrid()[0].length;
        
        for(int i = 0; i < gridLimitX; i++){
            for(int j = 0; j < gridLimitY; j++){
                if(item.getGrid()[i][j] == false)
                    continue;
                
                if(this.grid[i][j].getItem() == item)
                    return (this.grid[i][j].mergeStacks(itemStack))? null : itemStack;
                
                if(this.grid[i][j] != null)
                    return itemStack;
            }
        }
        
        for(int i = 0; i < gridLimitX; i++){
            for(int j = 0; j < gridLimitY; j++){
                if(item.getGrid()[i][j] == false)
                    continue;
                
                this.grid[i][j] = itemStack;
                
                if(this.grid[i][j] != null)
                    return itemStack;
            }
        }
        
        this.items.add(itemStack);
        
        return null;
    }
    
    public ItemStack moveInIventory(int row, int col){
        ItemStack itemStack = this.grid[row][col];
       
        for(InventorySlot slot: itemStack.getInventorySlots()){
            this.grid[slot.x][slot.y] = null;
        }
        
        itemStack.setInventorySlots(null);
        
        return itemStack;
    }
    
}
