/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.model.caracter;

import br.edu.fei.model.item.ItemStack;

/**
 *
 * @author Nicol
 */
public class InventorySlot {
    public int x;
    public int y;
    
    public InventorySlot(int x, int y,  ItemStack itemStack){
        this.x = x;
        this.y = y;
    }
}
