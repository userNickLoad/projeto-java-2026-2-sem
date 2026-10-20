/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fei.model;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

/**
 * Essa não é uma classe conceitual, mas sim uma classe-catalogo que possui
 * todos os objetos de Effect para facilitar o armzenamento em banco de dados e 
 * também a utilização. Por possuir os objetos já instanciados, não é preciso 
 * instanciar um efeito de cura em dois lugares diferentes, diminuindo a chance
 * de erros. 
 * 
 * Os objetos são armazenados em atributos static, então para pegar um efeito de
 * cura é necessario apenas Effects.HEALING_1 ou pegar atravéz do map
 * 
 * @author nicolas
 */
public class Effects {
    
//    public static final HEALING_1 = new 
    
    private static final Map<String, Effect> map = create();
    
    private Effects(){};
    
    private static void add(Map m, Effect effect){
        m.put(effect.getName(), effect);
    }
    
    /**
     * Cria e coloca os itens no map statico, sendo executado apenas uma vez
     */
    private static Map<String, Effect> create(){
        Map<String, Effect> m = new HashMap();
        
        return Collections.unmodifiableMap(m);
    }
    
    /**
     * unico metodo public e responsavel por procurar os effetc pelo nome.
     * Esse metodo provavelmente será utilizado para fazer a integração com o 
     * banco, pois ele permite armazenar apenas o nome do item e retira a 
     * necessidade de guardar todos os atributos e refazer a instanciação
     * 
     * @param name do tipo String, utilizado para procurar o objeto no Map
     * @return Effect, retorna o efeito desejado ou null;
     */
    public static Effect getByName(String name){        
        return map.get(name);
    }
    
}
