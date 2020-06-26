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
public class nodoArbol {
    private int Grado= 5;
    private int n;  //número de claves en el nodo 
    public int arreglo_claves[]= new int[Grado-1];
    public nodoArbol hijo[]= new nodoArbol[Grado];

    public int getGrado() {
        return Grado;
    }

    public void setGrado(int Grado) {
        this.Grado = Grado;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    
    
    
}
