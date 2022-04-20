/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.blog.serveis;

import java.util.Scanner;

/**
 *
 * @author Gokarna Dumre & Daniel cuesta
 */
public class IO {
   
    public IO(){
        
    }
    public static void mostraText(String text){
        System.out.println(text);
    }
    public static String llegeixText(){
        String info;
        Scanner leer= new Scanner(System.in);
        info=leer.nextLine();
        
        return info;
    }
    public static void mostraError(String texto){
        System.err.println(texto);
    }
    
}
