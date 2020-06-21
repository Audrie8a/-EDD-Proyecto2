/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author Audrie
 */
import Nodos.nodoConductor;

public class Conductor_LCD {
    
      nodoConductor ini, fin;
      
      public Conductor_LCD(){
          ini=null;
          fin=null;
      }
    
    public void InsertarConductor(String DPI, String Nombre, String Apellido, char tipoLicencia, String genero, String Telefono, String Direccion){
        nodoConductor Nuevo = new nodoConductor(DPI, Nombre, Apellido, tipoLicencia, genero, Telefono, Direccion);
        
        if(ini==null){
            ini=Nuevo;
            ini.Sig= ini;
            Nuevo.Ant= fin;
            fin= Nuevo;
        }else{
            fin.Sig= Nuevo;
            Nuevo.Sig= ini;
            Nuevo.Ant=fin;
            fin= Nuevo;
            ini.Ant=fin;
        }
        
    }
    
    public nodoConductor Buscar(String dpi){
        nodoConductor actual = new nodoConductor();
        actual= ini;
        do{
            if(actual.getDPI()==dpi){
                System.out.println(actual.toString());
                break;
            }
            actual=actual.Sig;
        }while(actual != ini);
        return actual;
    }
    void  Editar(String dpi,  String Nombre, String Apellido, char tipoLicencia, String genero, String Telefono, String Direccion ){
        nodoConductor actual = new nodoConductor();
        actual= ini;
        do{
            if(actual.getDPI()==dpi){
                actual.setNombre(Nombre);
                actual.setApellidos(Apellido);
                actual.setTipoLicencia(tipoLicencia);
                actual.setGenero(genero);
                actual.setTelefono(Telefono);
                actual.setDirección(Direccion);
                break;
            }
            actual=actual.Sig;
        }while(actual != ini);        
    }
    
    public void Eliminar(String dpi){
        nodoConductor anterior= new nodoConductor();
        nodoConductor actual =new nodoConductor();
        actual = ini;
        anterior= fin;
        do{
            if(actual.getDPI()==dpi){
             
                if(actual==ini){
                    ini= ini.Sig;
                    fin.Sig=ini;
                    ini.Ant= fin;
                }else if(actual==fin){
                    fin= anterior;
                    ini.Ant=fin;
                    fin.Sig= ini;
                }else{
                    anterior.Sig= actual.Sig;
                    actual.Sig.Ant= anterior;
                }
            }            
            anterior=actual;
            actual = actual.Sig;
        }while(actual != ini);
    }
    
    public void MostrarC(){
        nodoConductor actual = new nodoConductor();
        actual= ini;
        do{
            System.out.println(actual.toString());
            actual= actual.Sig;
        }while(actual != ini);
    }
    
    
    
}
