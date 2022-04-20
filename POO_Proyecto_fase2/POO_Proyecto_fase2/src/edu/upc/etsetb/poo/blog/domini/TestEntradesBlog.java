/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.blog.domini;

import java.util.ArrayList;



/**
 *
 * @author Gokarna Dumre & Daniel cuesta
 */
public class TestEntradesBlog {
    public static void main (String args[]){
       
        
        
    
        
     EntradesBlog listas =new EntradesBlog();
      
     listas.afageixOrdenat(new Entrada("pepe", "el hijo", "2020-04-22 17:17:23"));
     
     listas.afageixOrdenat(new Entrada("jose", "el abuelo", "2020-04-21 22:10:23")); 
     
     listas.afageixOrdenat(new Entrada("sofia", "la madre", "2020-04-20 21:17:23"));
     
     listas.afageixOrdenat(new Entrada("jordi", "la madre", "2020-04-19 20:17:23"));
     
     
        System.out.println(listas+"\n");
     String index= listas.index();
        System.out.println(index);
     Temps hoy= new Temps("2020-04-20 00:00:00");
     Temps manana= new Temps("2020-04-22 24:00:00");
     
        
        String intervalo=listas.entreDates(hoy, manana);
        System.out.println(intervalo);
        
        String hola=listas.toString();
        System.out.println(hola);
          
     
    }
       
     
    
    
     
    
}
