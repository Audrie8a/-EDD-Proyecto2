/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.proyecto2_201801263;

import Estructuras.Conductor_LCD;
import Estructuras.LS_Vertices;
import Estructuras.grafoRutas;
import Interfaz.Cliente;
import org.w3c.dom.ls.LSException;

/**
 *
 * @author Audrie
 */
public class EDDProyecto2_201801263 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*Conductor_LCD conductor = new Conductor_LCD();
        conductor.InsertarConductor("12", "Juan", "Juárez", 'A', "Hombre", "62874-29874", "Direccion");
        conductor.InsertarConductor("14", "Danna", "Muñoz", 'B', "Mujer", "63974-9283", "Direccion2");
        conductor.MostrarC();
        conductor.Buscar("13");¨*/
        
        //Prueba Grafo
        grafoRutas Grafo = new grafoRutas();
        /*Grafo.insertarRuta("0", "1", 1);
        Grafo.insertarRuta("1", "3", 1);
        Grafo.insertarRuta("2", "1", 1);
        Grafo.insertarRuta("2", "3", 1);
        Grafo.insertarRuta("3", "0", 1);
        Grafo.insertarRuta("4", "2", 1);
        
        grafoRutas.Vertice.Mostrar();
        
        System.out.println("\n"+"\n");
        
        Grafo.EliminarRuta("2", "3");        
        grafoRutas.Vertice.Mostrar();
*/
        
        
        Cliente cli=new Cliente();
        cli.setVisible(true);
        
        
//        Interfaz.Ruta  Ruta = new Interfaz.Ruta();
//        Ruta.setVisible(true);      
//        grafoRutas.Vertice.Mostrar();
        
    }
    
}
