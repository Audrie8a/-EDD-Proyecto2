/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;
import Nodos.nodoDestino;
/**
 *
 * @author Audrie
 */
public class LS_Adyacencia {
    
    private nodoDestino Ini;
    private nodoDestino Fin;
    public LS_Adyacencia(){
        Ini = null;
        Fin = null;
    }
    
    public void insertarDestino(String nombreDestino, int tiempo){
        nodoDestino Nuevo= new nodoDestino(nombreDestino, tiempo);
        
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
        nodoDestino actual = new nodoDestino();
        
        actual = Ini;
        while(actual != null){
            System.out.println(actual.toString());
            actual= actual.sig;
        }
    }
    
    public nodoDestino BuscarDestino(String nombreDestino){
        nodoDestino actual = new nodoDestino();
        nodoDestino aux = new nodoDestino();
        actual= Ini;
        do{
            if(actual.getNombreDestino()==nombreDestino){
                System.out.println(actual.toString());                
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
            if(actual.getNombreDestino()==nombreDestino){
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
            if(actual.getNombreDestino()== nombreDestino){
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
}
