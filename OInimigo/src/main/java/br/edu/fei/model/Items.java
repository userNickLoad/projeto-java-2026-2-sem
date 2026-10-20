/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.model;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author user
 */
public class Items {
    
    // public static final Item GRENADE = new Item("grenade");
    // public static final Item MOLOTOV = new Item("molotov");
    
    private static final Map<String, Item> map = create();
    
    private Items(){};
    
    private static void add(Map m,Item item){
        m.put(item.getName(), item);
    }
    
    /**
     * Cria e coloca os itens no map statico, sendo executado apenas uma vez
     */
    private static Map<String, Item> create(){
        Map<String, Item> m = new HashMap();
        
        // add(m, Items.GRANADE);
        // add(m, Items.MOLOTOV);
        
        return Collections.unmodifiableMap(m);
    }
    
    /**
     * unico metodo public e responsavel por procurar os items pelo nome.
     * Esse metodo provavelmente será utilizado para fazer a integração com o 
     * banco, pois ele permite armazenar apenas o nome do item e retira a 
     * necessidade de guardar todos os atributos e refazer a instanciação
     * 
     * @param name do tipo String, utilizado para procurar o objeto no Map
     * @return Item, retorna o item desejado ou null;
     */
    public static Item getByName(String name){        
        return map.get(name);
    }
    
}
