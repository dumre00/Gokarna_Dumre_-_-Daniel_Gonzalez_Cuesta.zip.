/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.blog.domini;

import java.time.LocalDateTime;

/**
 *
 * @author Gokarna Dumre & Daniel cuesta
 */
public class TestTemps {
    
   
   
  
     public static void main (String args[]){
        Temps hoy = new Temps();
        hoy.ara();
        int comparadordia;
        int comparadortemps;
        String adios= "2020-03-09 13:52:10.825405500";
        Temps ayer =new Temps(adios);
        
        comparadordia=hoy.comparaDia(ayer);
        
        comparadortemps=hoy.comparaTemps(ayer);
        
         System.out.println("tiempo this: "+hoy);
         System.out.println("tiempo altre: "+adios);
         
         System.out.println("comparacion tiempo: "+comparadortemps);
         System.out.println("comparacion dia: "+comparadordia);
         
         
         System.out.println();
       
         
         
         
        
       
        
     }
    
    
    
    
    
}
