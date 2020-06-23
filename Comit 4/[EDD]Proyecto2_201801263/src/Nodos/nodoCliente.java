/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodos;
import Estructuras.LS_Cliente;
/**
 *
 * @author Maxwelltram
 */
public class nodoCliente {
    public nodoCliente siguiente;
    private LS_Cliente ListaDeCliente;
    public char estado;
    public String DPI;
    public String Nombre;
    
    public nodoCliente(String DPI, String Nombre,LS_Cliente ListaCliente) {
        this.DPI = DPI;
        this.Nombre = Nombre;
        this.ListaDeCliente=ListaCliente;
    }

    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public nodoCliente getSiguiente() {
        return siguiente;
    }


    public LS_Cliente getListaDeCliente() {
        return ListaDeCliente;
    }

    public void setListaDeCliente(LS_Cliente ListaDeCliente) {
        this.ListaDeCliente = ListaDeCliente;
    }
    
}
