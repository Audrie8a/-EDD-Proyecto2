/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos;

/**
 *
 * @author Audrie
 */
public class Vertex {

    public Vertex(String name, int status, int prdecesor, int pathLenght) {
        this.name = name;
        this.status = status;
        this.prdecesor = prdecesor;
        this.pathLenght = pathLenght;
    }
    public Vertex(){}
    
    private String name;
    private int status;
    private int prdecesor;
    private int pathLenght;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPrdecesor() {
        return prdecesor;
    }

    public void setPrdecesor(int prdecesor) {
        this.prdecesor = prdecesor;
    }

    public int getPathLenght() {
        return pathLenght;
    }

    public void setPathLenght(int pathLenght) {
        this.pathLenght = pathLenght;
    }

    public Vertex(String name) {
        this.name=name;
    }
    public String toString(){
        return name;
    }
    
    
    
}
