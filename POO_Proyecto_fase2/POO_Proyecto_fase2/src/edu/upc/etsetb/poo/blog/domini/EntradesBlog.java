/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.blog.domini;

import static edu.upc.etsetb.poo.blog.domini.Entrada.compare;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Gokarna Dumre & Daniel cuesta
 */
public class EntradesBlog extends java.lang.Object {
   
   private LinkedList<Entrada> EntradesBlog;
   private String criteri;
   
   
    public EntradesBlog(){
        this.EntradesBlog= new LinkedList<Entrada>();
        this.criteri="num"; 
    }
    
     public void setCriteri(String s){
        this.criteri=s;
    }
    public boolean setcriteri(String criteri) {
        boolean crit;

        crit = "titol".startsWith(criteri) || "num".startsWith(criteri);
        return crit;
    }
    
    public void afageixOrdenat(Entrada e){
        this.EntradesBlog.addLast(e);
        ordena();
           
        
    }
    
    public Entrada agafa(int num){
        return this.EntradesBlog.get(num);
    }
    
    public Entrada elimina(int num){
        this.EntradesBlog.remove(num);
        return this.EntradesBlog.get(num);
    }
    
        
     public void ordena(){
        int i, comparador, orden = 0;
        Entrada aux;
       
        for( boolean ordenado=false; !ordenado;) {
            for (i =0; i < this.EntradesBlog.size()-1; i++) {
                comparador = compare(this.EntradesBlog.get(i), this.EntradesBlog.get(i + 1), this.criteri);
                if (comparador > 0) {
                     aux=this.EntradesBlog.get(i+1);
                     this.EntradesBlog.set(i+1, this.EntradesBlog.get(i));  
                     this.EntradesBlog.set(i, aux); 
                    orden++;
                }    
            }
            if (orden == 0) {
                ordenado = true;
            }
            orden = 0;
        }
     }
     
    public String index() {
       StringBuilder nombre= new StringBuilder();
        nombre.append("Index { ");
                
         
         for (int i = 0; i < this.EntradesBlog.size(); i++) {
            nombre.append("\n ").append(this.EntradesBlog.get(i).getId()).append(" ").append(this.EntradesBlog.get(i).getTitol());  
         }
         nombre.append("\n}");
         return nombre.toString();       
    }
    
         
     public String entreDates(Temps inicio, Temps fina) {

        StringBuilder dates=new StringBuilder(); 
        int contador=0;
        dates.append("Dates("+inicio.getDia()+","+fina.getDia()+"){");
        for (int i = 0; i < this.EntradesBlog.size(); i++) {
           // System.out.println("llegamos aqui" +inicio.getDia() +fina.getDia());
            int comparador1 = this.EntradesBlog.get(i).getQuan().comparaDia(inicio);
            int comparador2 = this.EntradesBlog.get(i).getQuan().comparaDia(fina);
            if ((comparador1>=0)&&(comparador2<=0)){
                contador=1;
                dates.append(this.EntradesBlog.get(i));
            }    
        }
        if (contador==0){
         System.out.println("no hi ha entrades");
        }
        dates.append("\n}");
        return dates.toString();
    }

        
    public String toString(){
        int i;
        StringBuilder lista=new StringBuilder();
        for (i = 0; i < this.EntradesBlog.size(); i++) {
            lista.append(this.EntradesBlog.get(i).toString());
        }
        return "Totes\n{"+"" + lista.toString()+"\n" + '}';
    }

}



   
