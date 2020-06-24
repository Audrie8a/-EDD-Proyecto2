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
import java.io.BufferedWriter;
import javafx.scene.effect.Light;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.ir.BreakNode;
/**
 *
 * @author Audrie
 */
public class grafoRutas {
    
    
    public static LS_Vertices Vertice = new LS_Vertices();
    
    //public grafoRutas(){}
    
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
    
    public void CaminoOptimo(String Origen, String Destino){
        int Peso;
        nodoOrigen nodoO = Vertice.BuscarVertice(Origen);
        nodoDestino nodoD;
        if(nodoO != null){        
            nodoD=nodoO.getLstNodosDetino().getInicio();
                if(nodoD != null){
                    Peso=nodoD.getTiempo();
                    if(nodoD.getNombreDestino().equals(Destino)){
                        
                    }
                }else{
                    System.out.println("Ruta por Ciudad: "+nodoO.getNombreOrigen()+" queda descartada");
                }
        }else{
            JOptionPane.showMessageDialog(null, "Origne no encontrado");
        }
    }
    
    public void dijkstra(String Origen, String Destino){
        nodoOrigen nodoO = Vertice.BuscarVertice(Origen);
        nodoDestino nodoD;
        
        int dist[]= new int[Vertice.getNumVertices()];      //Guarda las distancias
        Boolean leido[] = new Boolean[Vertice.getNumVertices()];    //Mira si ya se tomó su distancia
        
        for (int i=0; i<Vertice.getNumVertices(); i++) {        //Se inicializan los datos con un valor infinito
            dist[i]= Integer.MAX_VALUE;                         //y los vertices o nodos como no leidos
            leido[i]=false;
        }
        
        dist[0]=0;// No se para que sierve esto, el lo puso como     ANTTES DEL MIN 9
        
         int count=-1;
            do{
                 count++;
                int u = minDistance(dist, leido);
                leido[u]=true;
                nodoD= nodoO.getLstNodosDetino().getInicio();                
                int x=-1;
                if(nodoD != null){
                    do{
                        x++;
                        if(!leido[x] && dist[u]!= Integer.MIN_VALUE && dist[u]+nodoD.getTiempo()<dist[x]){
                            dist[x]= dist[u]+nodoD.getTiempo();
                        }
                        nodoD= nodoD.sig;
                    }while(x<Vertice.getNumVertices() && nodoD != null);
                    printGraph(dist, x);
                }                                
               nodoO=nodoO.sig;
            }while(count<Vertice.getNumVertices()&& nodoO != null);
        
    }
    
    public void CaminoMinimo(){}
    
    
    
    public void printGraph(int dist[],int x){
        System.out.println("Distancia para el elemento destino es: ");
        for(int i=0; i<Vertice.getNumVertices(); i++){
            System.out.println(i+"------"+dist[i]);
        }
        
    }
    
    public int minDistance(int dist[], Boolean leido[]){
        int min = Integer.MAX_VALUE, index=-1;
        for (int x = 0; x < Vertice.getNumVertices(); x++) {
            if(leido[x]==false && dist[x]<= min){
              min= dist[x];
              index= x;
            }
        }
        return index;           //Puede existir un problema aquí------------------------------REVISA
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
