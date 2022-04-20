/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.blog.iu;

import edu.upc.etsetb.poo.blog.controlador.Controlador;
import edu.upc.etsetb.poo.blog.excepcions.BlogException;
import edu.upc.etsetb.poo.blog.serveis.IO;

/**
 *
 * @author Gokarna Dumre & Daniel cuesta
 */
public abstract class Menu {
    protected Controlador cont = new Controlador();;
    
    
    public Menu(Controlador contr){
        this.cont=contr;
    }
    
    public abstract void executaOpcio(String op)throws BlogException;
    public abstract void mostraOpcions(); 
    
    public void cicle() throws BlogException{
        espera(0.1);
        mostraOpcions();
        String opcio = demanaOpcio();
        executaOpcio(opcio);
        while(!"fi".equals(opcio)&&!"f".equals(opcio)){
           mostraOpcions();
           opcio = demanaOpcio();
           executaOpcio(opcio);
            
        }
    }
    public static void espera(double segundos){//he creado esta funcion porque aveces los erroes se me mostraban dentro del cicle
        try{
        Thread.sleep((long) (segundos*1000));
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }
    
    public String demanaOpcio(){
        String opcio;
        IO.mostraText("Introdueix una opció: ");
        opcio=IO.llegeixText();
        return opcio;
    }
    
   
   
}
