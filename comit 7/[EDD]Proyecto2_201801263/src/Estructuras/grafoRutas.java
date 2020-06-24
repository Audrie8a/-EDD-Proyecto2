/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;
import Nodos.nodoDestino;
import Nodos.nodoOrigen;
/**
 *
 * @author Audrie
 */
public class grafoRutas {
    
    
    public static LS_Vertices Vertice = new LS_Vertices();
    
    
    public void insertarRuta(String Origen, String Destino, int tiempo){
        if(Vertice.getInicio()!= null){
            if(Vertice.BuscarVertice(Origen)== null){
            LS_Adyacencia listAdyacencia= new LS_Adyacencia();
            Vertice.insertarVertice(Origen,listAdyacencia);
            }
            if(Vertice.BuscarVertice(Destino)==null){
            LS_Adyacencia listAdyacencia= new LS_Adyacencia();
            Vertice.insertarVertice(Destino, listAdyacencia);
            }
        }else{
            LS_Adyacencia listAdyacencia, listAdyacencia1;
           Vertice.insertarVertice(Origen,listAdyacencia= new LS_Adyacencia());
            Vertice.insertarVertice(Destino, listAdyacencia1= new LS_Adyacencia());
        }
        
        
        nodoOrigen VerticeOrigen= Vertice.BuscarVertice(Origen);
        VerticeOrigen.getLstNodosDetino().insertarDestino(Destino, tiempo);        
    
    }
    
    public void EliminarRuta(String Origen, String Destino){
           nodoOrigen VerticeEliminar= Vertice.BuscarVertice(Origen);       
           VerticeEliminar.getLstNodosDetino().EliminarNodoDestino(Destino);
    }
    
    public LS_Vertices getListVertices(){
        return Vertice;
    }
   
    
}
