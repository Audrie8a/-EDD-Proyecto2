/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos;
import Estructuras.grafoRutas;
import static Estructuras.grafoRutas.Vertice;
import Nodos.nodoDestino;
import Nodos.nodoOrigen;
import javax.swing.JOptionPane;
/**
 *
 * @author Audrie
 */
public class CaminoMinimo {
    public final int MaxList= Vertice.getNumVertices();
    
    int numV=Vertice.getNumVertices();
    int numA;
    public static Vertex vertexLis[]; 
    
    private static final int Temporary= 1;
    private static final int Permanent= 2;
    private static final int NIL= -1;
    private static final int Infinity= Integer.MAX_VALUE;
    
    public CaminoMinimo(){
        vertexLis= new Vertex[MaxList];        
    }
    
    private void Dijkstra(int s){
        int v,c;
        for(v=0; v<numV; v++){
            //Vertex Vert= new Vertex("", Temporary,NIL, Infinity);
            vertexLis[v].setStatus(Temporary);
            vertexLis[v].setPathLenght(Infinity);
            vertexLis[v].setPrdecesor(NIL);
            
            vertexLis[s].setPathLenght(0);
            while(true){
            
                c= tempVertexMinPL();
                if(c== NIL){
                    return;
                }
                
                vertexLis[c].setStatus(Permanent);
                
                for(v=0; v<numV; v++ ){
                    if(buscarVertice(c,v) && vertexLis[v].getStatus()==Temporary ){
                        if(vertexLis[c].getPathLenght() + buscarPeso(c, v)< vertexLis[v].getPathLenght()){
                            vertexLis[v].setPrdecesor(c);
                            vertexLis[v].setPathLenght(vertexLis[c].getPathLenght() + buscarPeso(c,v));
                        }
                    }
                }
                
            }
        }
    }
    
    public void findPaths(String nameOrigen){
        nodoOrigen Origen= Vertice.BuscarVertice(nameOrigen);
        if(Origen != null){
        int s = Origen.getIndex();  //Busco el index de mi vertice
        Dijkstra(s);
        System.out.println("\n"+"Source Vertex: "+ Origen.getNombreOrigen()+"\n");
        for(int v=0; v<numV; v++){
            System.out.println("Destination vertex: "+vertexLis[v]);
            if(vertexLis[v].getPathLenght()==Infinity){
                System.out.println("There is not path from: "+Origen.getNombreOrigen()+ "to vertex"+vertexLis[v]);
            }else{
                findPath(s,v);
            }
        }
        }else{
            JOptionPane.showMessageDialog(null, "Esta Ciudad no ha sido Registrada");
        }
        
        
    }
    
    public void findPath(int s,int v){
        int i, u;
        int [] path= new int [numV];
        int sd=0;
        int count=0;
        while(v!=s){
            count++;
            path[count]=v;
            u= vertexLis[v].getPrdecesor();
            sd += buscarPeso(u, v);
            v=u;            
        }
        
        count++;
        path[count]=s;
        
        System.out.println("Shortest Path is: ");
        for(i=count; i>1; i--){
            System.out.println(path[i]+" ");
            System.out.println("\n Shortest distance is: "+ sd+ "\n");
            
        }
    }

    private int tempVertexMinPL() {
        int min= Infinity;
        int x = NIL;
        for(int v = 0; v<numV; v++){
            if(vertexLis[v].getStatus()== Temporary && vertexLis[v].getPathLenght()<min){
                min= vertexLis[v].getPathLenght();
                x=v;
            }
        }
        return x; 
    }
    
    public boolean buscarVertice(int V, int A){
        boolean condicion = false;
        nodoOrigen Origin=Vertice.BuscarPorIndex(V);
        if(Origin.getLstNodosDetino().getInicio()!= null){
            nodoDestino Destin=Origin.getLstNodosDetino().BuscarPorIndex(A);
            if(Destin != null){
                condicion= true;                
            }
        }      
        
        return condicion;
    }
    
    public int buscarPeso(int V, int A){
        int Peso=0;
        nodoOrigen Origin=Vertice.BuscarPorIndex(V);
        if(Origin.getLstNodosDetino().getInicio()!= null){
            nodoDestino Destin=Origin.getLstNodosDetino().BuscarPorIndex(A);
            if(Destin != null){
                Peso=Destin.getTiempo();
            }
        }      
        return Peso;
    }
    
}
