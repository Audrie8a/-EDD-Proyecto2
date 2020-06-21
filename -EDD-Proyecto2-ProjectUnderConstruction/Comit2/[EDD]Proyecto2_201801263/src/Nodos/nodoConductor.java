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
public class nodoConductor {    

    //nodo Lista Circular doblemente enlazada
    
    
    private String DPI;
    private String Nombre;
    private String Apellidos;
    private String tipoLicencia;
    private String Genero;
    private String Fecha;
    private int telefono;
    private String Dirección;
    public nodoConductor Sig;
    public nodoConductor Ant;
    
    public nodoConductor(){}
    
    public nodoConductor(String DPI, String Nombre, String Apellidos, String tipoLicencia, String Genero,String Fecha, int telefono, String Dirección) {
        this.DPI = DPI;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.tipoLicencia = tipoLicencia;
        this.Genero = Genero;
        this.telefono = telefono;
        this.Dirección = Dirección;
        Ant=null;
        Sig=null;
    }

    public String getDPI() {
        return DPI;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public String getGenero() {
        return Genero;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getDirección() {
        return Dirección;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setDirección(String Dirección) {
        this.Dirección = Dirección;
    }
    
    @Override public String toString() {
        return "nodoConductor{" + "DPI=" + DPI + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", tipoLicencia=" + tipoLicencia + ", Genero=" + Genero + ", telefono=" + telefono + ", Direcci\u00f3n=" + Dirección + '}';
    }
    
}
