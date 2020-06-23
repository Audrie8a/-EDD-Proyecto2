/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodos;

import Estructuras.LS_Adyacencia;

/**
 *
 * @author Audrie
 */
public class nodoOrigen {
    
    public nodoOrigen(){}

    public nodoOrigen(String nombreOrigen, LS_Adyacencia lstNodosDetino) {
        this.nombreOrigen = nombreOrigen;
        this.lstNodosDetino = lstNodosDetino;
    }

    public String getNombreOrigen() {
        return nombreOrigen;
    }

    public void setNombreOrigen(String nombreOrigen) {
        this.nombreOrigen = nombreOrigen;
    }

    public LS_Adyacencia getLstNodosDetino() {
        return lstNodosDetino;
    }

    public void setLstNodosDetino(LS_Adyacencia lstNodosDetino) {
        this.lstNodosDetino = lstNodosDetino;
    }

    @Override
    public String toString() {
        return "nodoOrigen{" + "nombreOrigen=" + nombreOrigen + ", lstNodosDetino=" + lstNodosDetino + '}';
    }
    
    private String nombreOrigen;
    private LS_Adyacencia lstNodosDetino; 
    
    public nodoOrigen sig;
    
}
