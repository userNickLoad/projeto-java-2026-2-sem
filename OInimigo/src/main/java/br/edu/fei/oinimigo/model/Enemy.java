/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.oinimigo.model;

import java.util.ArrayList;

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
    
    
    public ArrayList<ItemStack> dropItems(){
        ArrayList<ItemStack> drops = new ArrayList();
        
    }
}
