/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.blog.controlador;

/**
 *
 * @author Gokarna Dumre & Daniel cuesta
 */
public class  ControladorTest {
        public static void main (String args[]){
    
    Controlador cont= new Controlador();
    cont.mostraEntrades();
   cont.ordena();
   cont.mostraEntrada(2);
   
    cont.index();
    cont.dates();
       
   
        
    }
   
}
