/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.blog.domini;
import edu.upc.etsetb.poo.blog.serveis.IO;

import java.time.LocalDateTime;


/**
 *
 * @author gokarnaDumre @ Daniel Gonzalez
 */
public class Temps extends java.lang.Object {
    
     private String hora;
     private String  dia;
     
     
     
     
     public Temps(){
         this.dia="";
         this.hora="";
     }
     
   
     
    public Temps(String temps){
           
        if(comparaFormat(temps)) //he creado un metodo que compara el formato de tiempo 
        {
          IO.mostraText("Data incorrecte\n");
        }
        
        else{
        String[] parts; 
         if(temps.contains(" ")){
           parts = temps.split(" ");      //queda un vector de strings asi: ["aaa-mm-dd","hh:mm:ss"]
           this.dia = parts[0]; 
           this.hora=  parts[1];   
         }
         else if(temps.length()>3) {
          this.dia = temps; 
         }     
        }    
    }
   
     
    
     public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

     
    public void ara() {
        String tempsActual = LocalDateTime.now().toString();
             
        
        String[] parts;
        parts = tempsActual.split("T");     
        
        this.dia=parts[0];
        this.hora=parts[1].substring(0,8);
        
    }
    public boolean comparaFormat(String temps){
        int any, mes, dia, hora, min, seg;
        boolean fallofecha=true;
        boolean fallohora=true;
        boolean fallo=true;

        if(temps.equals("")){
            
            this.ara();
            return fallo=false;
        }
        else {
        try{
        String[] parts;
        
        parts = temps.split(" ");    
      
        
        String []dias;
        String []horas;
        
        dias=parts[0].split("-");// separo anyo, mes, dia;
        any=Integer.parseInt(dias[0]); 
        mes=Integer.parseInt(dias[1]);
        dia=Integer.parseInt(dias[2]);
        if((any >=2020)&&((0<mes)&&(mes<=12))&&((1<=dia)&&(dia<=30))){
             fallofecha=false;
                   return fallofecha;

         }
        horas=parts[1].split(":");//separo hora, min, seg
        hora=Integer.parseInt(horas[0]); 
        min=Integer.parseInt(horas[1]);
        seg=Integer.parseInt(horas[2]);
        
         if(((0<=hora)&&(hora<=24)) && ((0<=min)&&(min<=59)) && ((0<=seg)&&(seg<=59))){
             fallohora=false;
              return fallohora;
         }
        
        } catch(Exception e){
               fallo=true;
        }
        
        }
        return fallo;
    }   
   
    public int comparaDia (Temps altre) {
        int posterior;
        
        String[] partsAltre;
        
        partsAltre=altre.dia.split("-");
         //partsaltre[0])=anyo;
        //partsaltre[1])=mes;
        //partsaltre[2])=dia;
        
        String[] partsThis;
        partsThis=this.dia.split("-");
        //partsThis[0])=anyo;
        //partsThis[1])=mes;
        //partsThis[2])=dia;
        
       posterior= partsThis[0].compareTo(partsAltre[0]);
       if (posterior==0){
           posterior=partsThis[1].compareTo(partsAltre[1]);
           if(posterior==0){
               posterior=partsThis[2].compareTo(partsAltre[2]);
               if(posterior==0){
                   return posterior=0;
               }
           }
        }
              
       if(posterior<1){
            return posterior=-1;
            
        }
        else if(posterior>=1){
            return posterior=1;
        }
        
       
       return posterior;
  
    }
    
    
    public int comparaTemps(Temps altre) {
     
        String[] partshoraAltre;
        partshoraAltre=altre.hora.split(":");
        //partshoraThis[0])=hora;
        //partshoraThis[1])=min;
        //partshoraThis[2])=seg;
        
        String[] partshoraThis;
        partshoraThis=this.hora.split(":");
        //partshoraThis[0])=hora;
        //partshoraThis[1])=min;
        //partshoraThis[2])=seg;
         
       int comparador=this.comparaDia(altre);
        
        if(comparador==0){//si dia son iguales
           comparador=partshoraThis[0].compareTo(partshoraAltre[0]);
           if(comparador==0){ //si las horas son iguales
               comparador=partshoraThis[1].compareTo(partshoraAltre[1]);
               if(comparador==0){ //si los min son iguales
                   comparador=partshoraThis[2].compareTo(partshoraAltre[2]);
                     if(comparador==0){ //si los seg son iguales
                        return comparador=0;
                     }
               }
           }
        }
        
        if(comparador<1){
            comparador=-1;
        }
        else if(comparador>=1){
            comparador=1;
        }
       

       return comparador;
  
    }     
             
    
    
    @Override
    public java.lang.String toString() {
	String diahora=this.dia+" "+this.hora;
        return diahora;
    }
        
        
    
}
    
   


    

 
    
    
