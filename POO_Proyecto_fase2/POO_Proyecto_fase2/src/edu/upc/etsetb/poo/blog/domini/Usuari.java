/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.blog.domini;

import edu.upc.etsetb.poo.blog.controlador.Controlador;
import edu.upc.etsetb.poo.blog.iu.Menu;

/**
 *
 * @author Gokarna Dumre & Daniel cuesta
 */
public abstract class Usuari {
    protected Controlador contr;
    protected Menu menu;
    
    public Usuari(Controlador co){
        this.contr=co;
        this.menu=null;
    }

    public Menu getMenu() {
        return menu;
    }
   
}
