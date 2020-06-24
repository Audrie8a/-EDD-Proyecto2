/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;
import Nodos.nodoDestino;
import javax.swing.JOptionPane;
/**
 *
 * @author Audrie
 */
public class LS_Adyacencia {
    
    private nodoDestino Ini;
    private nodoDestino Fin;
    public int numAristas=0;
    public int Index=0;
    public LS_Adyacencia(){
        Ini = null;
        Fin = null;
    }
    
    public void insertarDestino(String nombreDestino, int tiempo){
        int Contador= getNumArtistas();
        nodoDestino Nuevo= new nodoDestino(nombreDestino, tiempo);
        Index=getIndex()+1;
        Nuevo.setIndex(Index);
        if(Ini==null){
            Ini= Nuevo;
            Ini.sig= null;
            Fin= Ini;
            Contador++;
            setNumAristas(Contador);
        }else{
            Fin.sig= Nuevo;
            Nuevo.sig= null;
            Fin= Nuevo;
            Contador++;
            setNumAristas(Contador);
        }
    }
    
    public void Mostrar(){
        nodoDestino actual = new nodoDestino();
        
        actual = Ini;
        while(actual != null){
            System.out.println(actual.toString());
            System.out.println("Index Vertice: "+actual.miVertice.getIndex()+" Index: Destino"+actual.getIndex());
            actual= actual.sig;
        }
    }
    
    public nodoDestino BuscarDestino(String nombreDestino){
        nodoDestino actual = new nodoDestino();
        nodoDestino aux = new nodoDestino();
        actual= Ini;
        do{
            if(actual.getNombreDestino().equals(nombreDestino)){
                System.out.println(actual.toString());
                aux=actual;
                break;
            }
            actual=actual.sig;            
            aux= null;
        }while(actual != null);
        return aux;
    }
    
    public void ModificarDestino(String nombreDestino, String nuevoNombreDestino, int nuevoTiempo){
        nodoDestino actual = new nodoDestino();
        actual = Ini;
        while(actual != null){
            if(actual.getNombreDestino().equals(nombreDestino)){
                actual.setNombreDestino(nuevoNombreDestino);
                actual.setTiempo(nuevoTiempo);              
            }
            actual = actual.sig;
        }
    }
    
    public void EliminarNodoDestino(String nombreDestino){
        nodoDestino actual = new nodoDestino();
        nodoDestino anterior = new nodoDestino();
        actual = Ini;
        anterior= null;
        while(actual != null){
            if(actual.getNombreDestino().equals(nombreDestino)){
                if(actual == Ini){
                    Ini= Ini.sig;
                }else{
                    anterior.sig= actual.sig;
                }                
            }
            anterior= actual;
            actual = actual.sig;
            if(actual==null){                
                JOptionPane.showMessageDialog(null, "Ruta eliminada correctamente");
            }
        }
    }
    
    public nodoDestino BuscarPorIndex(int index){
        nodoDestino aux=null;
        nodoDestino actual;
        if(Ini != null){            
        actual= Ini;
        do{
            if(actual.miVertice.getIndex()==index){
                //System.out.println(actual.toString());
                aux= actual;
                
                break;
            }
            actual=actual.sig;
            aux= null;
        }while(actual != null);
        }
        return aux;
    }
    
    public nodoDestino getInicio(){
        return Ini;
    }
    
    public nodoDestino getFin(){
        return Fin;
    }
    
    public void setNumAristas(int A){
        numAristas= A;
    }
    
    public int getNumArtistas(){
        return numAristas;
    }
    
    public int getIndex(){
        return Index;
    }
    
    public void setIndex(int ind){
        Index=ind;
    }
}
