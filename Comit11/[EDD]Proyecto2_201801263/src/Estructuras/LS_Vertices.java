/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;
import Nodos.nodoOrigen;
/**
 *
 * @author Audrie
 */
public class LS_Vertices {
    private nodoOrigen Ini;
    private nodoOrigen Fin;
    public LS_Vertices(){
        Ini = null;
        Fin = null;
    }
    
    public void insertarVertice(String nombreDestino,LS_Adyacencia lista ){
        nodoOrigen Nuevo= new nodoOrigen(nombreDestino, lista);
        
        if(Ini==null){
            Ini= Nuevo;
            Ini.sig= null;
            Fin= Ini;
        }else{
            Fin.sig= Nuevo;
            Nuevo.sig= null;
            Fin= Nuevo;
        }
    }
    
    public void Mostrar(){
        nodoOrigen actual = new nodoOrigen();
        
        actual = Ini;
        while(actual != null){
            System.out.println(actual.toString());
            System.out.println("CONTAR");
            actual= actual.sig;
        }
    }
    
    public nodoOrigen BuscarVertice(String nombreOrigen){
        nodoOrigen actual = new nodoOrigen();
        nodoOrigen aux = new nodoOrigen();
        if(Ini != null){            
        actual= Ini;
        do{
            if(actual.getNombreOrigen().equals(nombreOrigen)){
                System.out.println(actual.toString());
                aux= actual;
                break;
            }
            actual=actual.sig;
            aux= null;
        }while(actual != null);
        }
        
        return aux;
    }
    
    public void ModificarVetice(String nombreOrigen, String nuevoNombreOrigen, LS_Adyacencia lista){
        nodoOrigen actual = new nodoOrigen();
        actual = Ini;
        while(actual != null){
            if(actual.getNombreOrigen().equals(nombreOrigen)){
                actual.setNombreOrigen(nuevoNombreOrigen);
                actual.setLstNodosDetino(lista);              
            }
            actual = actual.sig;
        }
    }
    
    public void EliminarNodoVertice(String nombreOrigen){
        nodoOrigen actual = new nodoOrigen();
        nodoOrigen anterior = new nodoOrigen();
        actual = Ini;
        anterior= null;
        while(actual != null){
            if(actual.getNombreOrigen().equals(nombreOrigen)){
                if(actual == Ini){
                    Ini= Ini.sig;
                }else{
                    anterior.sig= actual.sig;
                }                
            }
            anterior= actual;
            actual = actual.sig;
        }
    }
    
    public nodoOrigen getInicio(){
        return Ini;
    }
    
    public nodoOrigen getFin(){
        return Fin;
    }
}
