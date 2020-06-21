/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.proyecto2_201801263;

import Estructuras.Conductor_LCD;
import Interfaz.Conductor;

/**
 *
 * @author Audrie
 */
public class EDDProyecto2_201801263 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conductor conduc=new Conductor();
        conduc.setVisible(true);
        
          Conductor_LCD conductor = new Conductor_LCD();
//        conductor.InsertarConductor("12", "Juan", "Juárez", 'A', "Hombre", "62874-29874", "Direccion");
//        conductor.InsertarConductor("14", "Danna", "Muñoz", 'B', "Mujer", "63974-9283", "Direccion2");
        conductor.MostrarC();
        
//        conductor.Buscar("12");
    }
    
}
