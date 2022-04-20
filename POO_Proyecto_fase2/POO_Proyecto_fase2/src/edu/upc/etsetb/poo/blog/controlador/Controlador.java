/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.blog.controlador;

import edu.upc.etsetb.poo.blog.domini.Entrada;
import edu.upc.etsetb.poo.blog.domini.EntradesBlog;
import edu.upc.etsetb.poo.blog.domini.Registrat;
import edu.upc.etsetb.poo.blog.domini.Temps;
import edu.upc.etsetb.poo.blog.domini.Usuari;
import edu.upc.etsetb.poo.blog.domini.Visitant;
import edu.upc.etsetb.poo.blog.excepcions.BlogException;
import static edu.upc.etsetb.poo.blog.iu.Menu.espera;
import edu.upc.etsetb.poo.blog.serveis.IO;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gokarna Dumre & Daniel cuesta
 */
public class Controlador extends java.lang.Object {
  
    private EntradesBlog blogactual;
    private Usuari usuariactual;
    private Map<String, Registrat>registrats;
    public static final String ANSI_RED = "\u001B[31m";//color rojo
    

    public Controlador() {
        blogactual= new EntradesBlog();
        this.registrats=new HashMap<String, Registrat>();
    }

    public void index() {
        IO.mostraText(this.blogactual.index());
    }

    public void novaEntrada() {

        String titol, text, temps;
        IO.mostraText("Nova Entrada");

        System.out.println("Titol?: ");
        titol = IO.llegeixText();
        System.out.println("Text?: ");
        text = IO.llegeixText();
        IO.mostraText("Dia i hora? (aaaa-mm-dd< hh:mm:ss>, Return=Ara)?: ");
        temps = IO.llegeixText();
        Temps ahora = new Temps(temps);
        while (ahora.comparaFormat(temps)) {
            IO.mostraText("Dia i hora? (aaaa-mm-dd< hh:mm:ss>, Return=Ara)?: ");
            temps = IO.llegeixText();
        }
        Entrada nova = new Entrada(titol, text, temps);
        Registrat r= (Registrat)this.usuariactual;
        r.AfageixEntrada(nova);

    }

    public void ordena() {
        System.out.println("criteri? (num/titol): ");
        String Criterio = IO.llegeixText();
        this.blogactual.setCriteri(Criterio);
        this.blogactual.ordena();
        
    }

    public void dates() {
        String ini, fin, intervalo;
        IO.mostraText("Dia inicial?(aaaa-mm-dd): ");
        ini = IO.llegeixText();
       
        Temps inicio = new Temps(ini);
        while (inicio.comparaFormat(ini)) {

            IO.mostraText("Dia inicial?(aaaa-mm-dd):");
            ini = IO.llegeixText();
        }
        

       IO.mostraText("Dia final?(aaaa-mm-dd):");
        try{
        fin = IO.llegeixText();

        Temps fina = new Temps(fin);
        intervalo = blogactual.entreDates(inicio, fina);
        IO.mostraText(intervalo);
        }catch(Exception e){
            IO.mostraText("Introduiex be la data (aaaa-mm-dd< hh:mm:ss>, Return=Ara)");
        }
        
    }

    public void mostraEntrades() {
        IO.mostraText(this.blogactual.toString());
    }
    
    public void mostraUsuaris(){
       StringBuilder noms= new StringBuilder();
       noms.append("[");
       for(String n: this.registrats.keySet()){
           noms.append(" "+n+" ");
       }
       noms.append("]");
       if(noms.toString().equals("[]")){
           IO.mostraError("\nllista buida\n");
           espera(0.2);
       }
       else IO.mostraText(noms.toString()+"\n");
    }
        
  
    public void visitant() throws BlogException{ 
        Visitant vis= new Visitant(this);
        this.usuariactual=vis;
        this.usuariactual.getMenu().cicle();
     }
    
    public void sessio() throws BlogException{
      IO.mostraText("Usuari? ");
      String usu=IO.llegeixText();
      IO.mostraText("Password? ");
      String pass=IO.llegeixText();
      Registrat u= new Registrat(this, usu, pass);
      u= this.registrats.get(usu);
       
        if(u!=null){
            if(u.verificaPassword(pass)){
                this.usuariactual=u;
                this.blogactual=u.getBlog();
                this.usuariactual.getMenu().cicle(); 
                 
            }
            else throw new BlogException("password incorrecte, prova altre cop");
        }
        else throw new BlogException("Usuari o password incorrecte");
    }        
    
    public void registre()throws BlogException{
      IO.mostraText("Alta usuari:\n");
      IO.mostraText("Nom Usuari? ");
      String usu=IO.llegeixText();
      IO.mostraText("Password? ");
      String pass=IO.llegeixText();
      IO.mostraText("Repeteix password: ");
      String pass1=IO.llegeixText();
      
      if(pass.equals(pass1)){
         Registrat p= new Registrat(this,usu,pass);
          this.registrats.put(usu,p);
          this.usuariactual=p;
          
      }
      else throw new BlogException("password incorrecte");
    
    }
     
    

    public void eliminaEntrada(int num) {
        Entrada aux = blogactual.agafa(num-1);
        if (aux == null) {
            IO.mostraText("Entrada vacia");
        } else {
            blogactual.elimina(num-1);
            IO.mostraText("Elimino: " + aux.toString());
        }
    }

    public void mostraEntrada(int num) {
        Entrada nou = this.blogactual.agafa(num);
        if (nou == null) {
            IO.mostraText("No existeix");
        } else {
            IO.mostraText(nou.toString());
        }

    }
    public void mostraBlog(java.lang.String nom) throws BlogException{
      Registrat u= this.registrats.get(nom);
        
        if(u!=null){
        
            IO.mostraText(u.getBlog().toString());
        }
        else throw new BlogException("Usuari desconegut\n");
       
     }
        
    
    

    
}
