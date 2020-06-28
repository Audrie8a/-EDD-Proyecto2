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
public class Vehiculo {

    public Vehiculo(String Placa, String Marca, String Modelo, String Anio, String Color, float Precio, String tipoTrnasmision) {
        this.Placa = Placa;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Anio = Anio;
        this.Color = Color;
        this.Precio = Precio;
        this.tipoTrnasmision = tipoTrnasmision;
    }

    public Vehiculo() {
    }
    public String Placa;
    public String Marca;
    public String Modelo;
    public String Anio;
    public String Color;
    public float Precio;
    public String tipoTrnasmision;

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
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

    public String getAnio() {
        return Anio;
    }

    public void setAnio(String Anio) {
        this.Anio = Anio;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    public String getTipoTrnasmision() {
        return tipoTrnasmision;
    }

    public void setTipoTrnasmision(String tipoTrnasmision) {
        this.tipoTrnasmision = tipoTrnasmision;
    }
}
