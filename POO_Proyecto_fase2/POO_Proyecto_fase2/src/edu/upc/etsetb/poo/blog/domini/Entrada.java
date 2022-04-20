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
public class Entrada extends java.lang.Object {
    private int id;
    private String titol;
    private String text;
    private Temps data;
    private static int nEntrades=0;
    
     public Entrada(String titol, String text, String temps){
        nEntrades++;  
        this.id=nEntrades;
        this.titol=titol;
        this.text=text;
        /*if(temps.equals("")){
            this.data.ara();  //si hacemos esto nos da error, por eso lo hemos hecho en clase Temps
        }*/
        /*else*/ this.data=new Temps(temps);
    }


    public int getId() {
        return id;
    }

    public String getTitol() {
        return titol;
    }

    public Temps getQuan() {
        return data;
    }
    
    public static int compare (Entrada una, Entrada altra, String criteri){
        int comp;
        if("titol".startsWith(criteri)){
           comp= una.titol.compareTo(altra.titol);
          
            return comp;   
        }
        else if("num".startsWith(criteri)){
            int num;
            num=una.id-altra.id;
            return num;
           
        }
        return Integer.parseInt("criteri no valid");
    }
    
    
    
    @Override
    public String toString() {
        return  "\n" + id  +" "+ titol +" " + text +" "+ data;
    }
}
      
       
    
    
