package br.edu.fei.model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * 
 * Classe fundamental para objetos visiveis no jogo como personagem e itens
 *
 * @author nicolas
 */
abstract class GameObject {
    private String name;
    private String image;
    
    /**
     * @param name Representa o nome do objeto 
     * @param image Recebe o path da imagem que representa o objeto
     */
    
    public GameObject(String name, String image){
        this.name = name;
        this.image = image;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getImage(){
        return this.image;
    }
    
    public void setImage(String image){
        this.image = image;
    }
    
}
