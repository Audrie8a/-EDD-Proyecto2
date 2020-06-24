/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodos;

/**
 *
 * @author Audrie
 */
public class nodoDestino {
    
    private String nombreDestino;
    private int tiempo;
    
    public nodoDestino sig;  
    
    
    public nodoDestino(){}
    
    public nodoDestino(String nombreDestino, int tiempo) {
        this.nombreDestino = nombreDestino;
        this.tiempo = tiempo;
        this.sig = null;
    }
    
    public String getNombreDestino() {
        return nombreDestino;
    }

    public void setNombreDestino(String nombreDestino) {
        this.nombreDestino = nombreDestino;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
     @Override
    public String toString() {
        return "nodoDestino{" + "nombreDestino=" + nombreDestino + ", tiempo=" + tiempo + '}';
    }
}
