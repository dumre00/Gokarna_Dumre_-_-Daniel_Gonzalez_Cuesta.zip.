/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.blog.iu;

import edu.upc.etsetb.poo.blog.controlador.Controlador;
import edu.upc.etsetb.poo.blog.excepcions.BlogException;
import static edu.upc.etsetb.poo.blog.iu.Menu.espera;
import edu.upc.etsetb.poo.blog.serveis.IO;

/**
 *
 * @author Gokarna Dumre & Daniel cuesta
 */
public class InterficieUsuari extends java.lang.Object {
   
   Controlador cont;
   private Menu menu;
   
    
    public InterficieUsuari(){
        this.cont=new Controlador();
        this.menu=new MenuPrincipal(this.cont); 
    }
    
    
    public void cicle() throws BlogException{ 
        espera(0.1);        
        this.menu.mostraOpcions();         
        String op=this.menu.demanaOpcio();              
        this.menu.executaOpcio(op);             
                 
     
    }
    
    public static void main(java.lang.String[] args) throws BlogException{
        InterficieUsuari iu=new InterficieUsuari();
        IO.mostraText("Hola!");
        iu.menu.cicle();
    }

}

    

