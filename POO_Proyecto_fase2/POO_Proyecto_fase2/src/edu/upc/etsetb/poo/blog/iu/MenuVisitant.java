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
public class MenuVisitant extends Menu {
    public MenuVisitant(Controlador contr){
        super(contr);
    }

    @Override
    public void mostraOpcions(){
       IO.mostraText("Usuari Visitant:\n   llistaUsuaris\n   mostraBlogs nomUsuari\n   fi\n");
    }
    @Override
    
    public void executaOpcio(java.lang.String text) throws BlogException{
    try{
    String [] partstext = text.split(" ");
    if("llistausuaris".startsWith(text)&&!text.equals("")){
        this.cont.mostraUsuaris();
        
    }
    else if("mostrablog".startsWith(partstext[0])&&!text.equals("")){
        try{
           this.cont.mostraBlog(partstext[1]);
         }catch(ArrayIndexOutOfBoundsException e){//es por si el ususario solo pone mostrablog sin el usuario. lannzo la excepcion general porque no es una blogexcepcion sino de exepcion indexoutofbound
            IO.mostraError("Prova altre num\n");
            espera(0.2);
         } 
    }

    else if("fi".startsWith(text)&&!text.equals("")){
         IO.mostraText("Fins aviat\n");
    }
    else throw new BlogException("opcio incorrecta.\n");
   }catch( BlogException e){
       IO.mostraError(e.getMessage());
       espera(0.2);
   }
    }
}

