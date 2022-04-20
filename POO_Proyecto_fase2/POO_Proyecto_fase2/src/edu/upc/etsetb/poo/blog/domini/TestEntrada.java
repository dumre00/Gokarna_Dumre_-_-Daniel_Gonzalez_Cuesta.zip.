/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.blog.domini;

import java.util.Scanner;

/**
 *
 * @author Gokarna Dumre & Daniel cuesta
 */
public class TestEntrada {
    public static void main (String args[]){
        String titol;
        String text;
        String temps;
        System.out.println("TITOL: ");
         Scanner input = new Scanner(System.in);
         titol=input.nextLine();
         
         System.out.println("TEXT");
         text=input.nextLine();
         
         System.out.println("TEMPS");
         temps=input.nextLine();
         
         
         
         Entrada pepe= new Entrada(titol, text, temps);
          System.out.println(pepe);
          
         System.out.println("TITOL: ");
         titol=input.nextLine();
         
         System.out.println("TEXT");
         text=input.nextLine();
         
         System.out.println("TEMPS");
         temps=input.nextLine();
         
         Entrada juan = new Entrada(titol, text, temps);
         System.out.println(juan);
        
         int compare;
         compare=Entrada.compare(juan, pepe, "titol");
         
         System.out.println("ADIOS");
         System.out.println(compare);
         
         
    }
    
}
