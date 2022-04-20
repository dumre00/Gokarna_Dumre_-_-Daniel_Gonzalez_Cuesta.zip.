/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.blog.iu;

import edu.upc.etsetb.poo.blog.controlador.Controlador;
import edu.upc.etsetb.poo.blog.domini.Entrada;
import edu.upc.etsetb.poo.blog.domini.Usuari;
import edu.upc.etsetb.poo.blog.excepcions.BlogException;
import edu.upc.etsetb.poo.blog.serveis.IO;

/**
 *
 * @author Gokarna Dumre & Daniel cuesta
 */
public class MenuRegistrat extends Menu {
       
     
    
    public MenuRegistrat(Controlador contr){
        super(contr);
    }

    @Override
    public void mostraOpcions(){
       IO.mostraText("\nBenvingut\nOpcions:\n\tindex\n\tmostra <num>\n\tnova\n\telimina <num>\n\tordena\n\tdates\n\ttotes\n\tfi\n");
        
    }
    @Override
    public void executaOpcio(String res)throws BlogException{
        
        String[] partsop=res.split(" ");
        String text=partsop[0];
       int num=0;
       try{    
        if("index".startsWith(text)&& !text.equals("")){
           cont.index();  
        }
        
        else if("mostra".startsWith(text)&& !text.equals("")){
          try{
               num=Integer.parseInt(partsop[1]);
               cont.mostraEntrada(num-1);
         }catch(Exception e){ //es por si el usuario solo pone mostra sin el numero. Lanzo la excepcion porque no es una blogexcepcion, pueder ser NumberFormatException o IndexoutofBoundExcepcion 
             IO.mostraError("No existeix aquesta entrada");
             espera(0.1);
         }
        }
         
        else if("nova".startsWith(text)&& !text.equals("")){
            cont.novaEntrada();   
        }
        
        else if("totes".startsWith(text)&& !text.equals("")){
            cont.mostraEntrades();  
        }
        
        else if("elimina".startsWith(text)&& !text.equals("")) {
        try{
            
             num=Integer.parseInt(partsop[1]);
             cont.eliminaEntrada(num-1);
         }catch(Exception e){ //es por si el usuario solo pone elimina sin el numero. lanzo la excepcion porque no es una blogexcepcion, puede ser NumberFormatException o IndexOutOfBounds.
           IO.mostraError("No exisisteix aquesta entrada\n");
           espera(0.1);
         }
        }
   
        else if("ordena".startsWith(text)&& !text.equals("")){
            cont.ordena();
        }
        
        else if("dates".startsWith(text)&& !text.equals("")){
            cont.dates();   
        }
        
        else if("fi".startsWith(text)&& !text.equals("")){
            IO.mostraText("Fins aviat\n");
        }
        
        else throw new BlogException("opcio incorrecta.\n");
       }catch( BlogException e){
           IO.mostraError(e.getMessage());
           espera(0.1);
       } 
                 
     }
    
   
    }
    