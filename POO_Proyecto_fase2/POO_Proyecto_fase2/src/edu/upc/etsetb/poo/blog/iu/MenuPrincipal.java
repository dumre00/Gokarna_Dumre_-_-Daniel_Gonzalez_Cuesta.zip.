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
 public class MenuPrincipal extends Menu {
       
    public MenuPrincipal(Controlador contr){
        super(contr);
    }
    
    @Override
    public  void mostraOpcions(){
        IO.mostraText("Opcions:\n   visitant\n   inicia sessio\n   registra't\n   fi");
        
    }
    
    
    @Override
    public void executaOpcio(String text) throws BlogException{
      
        try{  
        if("visitant".startsWith(text)&& !text.equals("")){
            this.cont.visitant();
           
            
        }
        else if("inicia sessio".startsWith(text)&&!text.equals("")){
           this.cont.sessio();
           
          
        }
        else if("registrat".startsWith(text)&&!text.equals("")){
            this.cont.registre();
            
        }
        else if("fi".startsWith(text)&&!text.equals("")){
             IO.mostraText("Adeu");     
        }            
        else throw new BlogException("opcio incorrecta.\n");
       }catch( BlogException e){
           IO.mostraError(e.getMessage());
           espera(0.1);
           this.cicle();
       }
    }
    
    
} 
