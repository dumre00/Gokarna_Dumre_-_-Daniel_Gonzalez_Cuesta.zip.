/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.blog.domini;

import edu.upc.etsetb.poo.blog.controlador.Controlador;
import edu.upc.etsetb.poo.blog.iu.Menu;
import edu.upc.etsetb.poo.blog.iu.MenuVisitant;

/**
 *
 * @author Gokarna Dumre & Daniel cuesta
 */
public class Visitant extends Usuari {
    
    public Visitant(Controlador contr){
       super(contr);
       this.contr=contr;
       this.menu=new MenuVisitant(this.contr);
    }

   
    @Override
    public Menu getMenu() {
        return this.menu;
    } 
    
}
