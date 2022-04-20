/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.blog.domini;

import edu.upc.etsetb.poo.blog.controlador.Controlador;
import edu.upc.etsetb.poo.blog.iu.Menu;
import edu.upc.etsetb.poo.blog.iu.MenuRegistrat;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gokarna Dumre & Daniel cuesta
 */
public class Registrat extends Usuari {
    private String nom, password;
    private EntradesBlog entradas;
   
    
    public Registrat(Controlador cont, String nom, String passwd){
        super(cont);
        this.nom=nom;
        this.password=passwd;
        this.menu=new MenuRegistrat(this.contr); 
        this.entradas= new EntradesBlog();
        
    }
    
    public void AfageixEntrada(Entrada e){
     this.entradas.afageixOrdenat(e);
    }
    
    public EntradesBlog getBlog() {
        return this.entradas;
    }
    
    public boolean verificaPassword(String pass){
        boolean correcto;
        if(this.password.equals(pass)){
           correcto=true;
        }else correcto=false;
        return correcto;
    }
    
    
    
     public Menu getMenu() {
        return this.menu;
    } 
    
}


