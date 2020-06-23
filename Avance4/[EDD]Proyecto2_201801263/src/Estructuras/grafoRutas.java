/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;
import Nodos.nodoDestino;
import Nodos.nodoOrigen;
import java.io.File;
import java.io.FileWriter;
import java.math.BigInteger;
import java.io.BufferedWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
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
        try {
            nodoOrigen VerticeEliminar= Vertice.BuscarVertice(Origen);  
           if(VerticeEliminar != null){
               nodoDestino DestinoEliminar=VerticeEliminar.getLstNodosDetino().BuscarDestino(Destino);
               if(DestinoEliminar != null){
                    VerticeEliminar.getLstNodosDetino().EliminarNodoDestino(Destino);
               }
               else{
                   JOptionPane.showMessageDialog(null, "Se ha ingresado mal el dato Destino");
               }        
           }else{
               JOptionPane.showMessageDialog(null, "Se ha ingresado mal el dato Origen");
           }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El dato origen no contiene datos destinos");
        }
           
    }
    
    public LS_Vertices getListVertices(){
        return Vertice;
    }
   
    public void Graficar() {
        try {
            File file;
        file = new File("Grafo.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        
        FileWriter print = new FileWriter(file);
        BufferedWriter buffer = new BufferedWriter(print);
        buffer.write("digraph g {\n");
        String Contenido=getTxt(Vertice);
        buffer.write(Contenido);
        buffer.write("}");
        buffer.close();
        
         try {
            // Execute a command without arguments
            String command = "dot -Tjpg Grafo.txt -o Grafo.jpg";
            Process child = Runtime.getRuntime().exec(command);
            child = Runtime.getRuntime().exec(command);
            } catch (Exception e) {
                }
         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al graficar");
        }
        
        
    }
    
    public String getTxt(LS_Vertices listaV){
        String EstiloVertice =" \"width = 1 style = filled, fillcolor = lightskyblue];";
        String EstiloDestino=" \"width = 1 style = filled, fillcolor = \"#ccccff\"];";
        String EstiloArista=" \"fontsize=8] ;";
        String label="";
        nodoOrigen PruebaOrigen;
        nodoDestino PruebaDestino;
        LS_Adyacencia listaA;
        nodoOrigen Aux=listaV.getInicio();
        nodoDestino AuxDestino;
        if(Aux != null){
            do{
                label += "nodo"+Aux.getNombreOrigen()+"[label=\""+ Aux.getNombreOrigen()+EstiloVertice+"\n";
                listaA=Aux.getLstNodosDetino();
                if(listaA.getInicio() != null){
                    AuxDestino = listaA.getInicio();
                    do{
                        label += "nodo"+AuxDestino.getNombreDestino()+"[label=\""+AuxDestino.getNombreDestino()+EstiloDestino+"\n";
                        label+= "nodo"+Aux.getNombreOrigen()+"->"+"nodo"+AuxDestino.getNombreDestino()+"[label=\""+AuxDestino.getTiempo()+EstiloArista+"\n";
                        AuxDestino= AuxDestino.sig;
                    }while(AuxDestino != null);
                }   
            
                Aux= Aux.sig;
            
            }while(Aux != null);
        }else{
            label = "nodoNodo [label = \"No hay Nodos en la lista\"   width = 1 style = filled, fillcolor = \"#ccffcc\"];\n";
        }
       
        
        return label;
    }
    
}
