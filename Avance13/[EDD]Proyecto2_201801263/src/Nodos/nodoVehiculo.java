/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodos;
import Extra.Ordenar;
/**
 *
 * @author Audrie
 */
public class nodoVehiculo extends Ordenar {
    private String placa;
    private String Marca;
    private String Modelo;
    private int anio;
    private String Color;
    private String Precio;
    private String Transmision;

    public nodoVehiculo() {
    }

    public nodoVehiculo(String placa, String Marca, String Modelo, int anio, String Color, String Precio, String Transmision) {
        this.placa = placa;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.anio = anio;
        this.Color = Color;
        this.Precio = Precio;
        this.Transmision = Transmision;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public int getAnio() {
        return anio;
    }
         public Object getClave()
    {
        return placa;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }

    public String getTransmision() {
        return Transmision;
    }

    public void setTransmision(String Transmision) {
        this.Transmision = Transmision;
    }

    @Override
    public String toString() {
        return "nodoVehiculo{" + "placa=" + placa + ", Marca=" + Marca + ", Modelo=" + Modelo + ", anio=" + anio + ", Color=" + Color + ", Precio=" + Precio + ", Transmision=" + Transmision + '}';
    }
    public nodoVehiculo getVehiculo(){
        nodoVehiculo n=new nodoVehiculo(placa, Marca, Modelo, anio, Color, Precio, Transmision);
        return n;
    }
}
