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
public class nodoViaje {
    
    private String llave;
    private String llaveEncriptada;
    private nodoCliente ptrCliente;
    private nodoConductor ptrConductor;
    private nodoCaminoCorto ptrRutaSimple;
    
    private String origen;
    private String Destino;
    private String FechaHora;

    @Override
    public String toString() {
        return "nodoViaje{" + "Identificacion=" + llaveEncriptada +", llave=" + llave +  " Cliente={" + ptrCliente.getNombre()+ ptrCliente.getApellidos()+ptrCliente.getDPI()+ptrCliente.getDireccion()+ptrCliente.getGenero() +"}, "+ " Conductor={ " + ptrConductor.getDPI()+ptrCliente.getNombre()+ptrCliente.getGenero()+"}, " + " CaminoCorto={ Inicio: " +ptrRutaSimple.getNombreOrigen()+ ptrRutaSimple.getNombreDestino()+ptrRutaSimple.getPesoCamino()+"}" + ", origen=" + origen + ", Destino=" + Destino + ", FechaHora=" + FechaHora + '}';
    }
    
    
    public nodoViaje Sig;
    public nodoViaje Ant;

    public nodoViaje(){}
    public nodoViaje( String origen, String Destino, String FechaHora) {
        this.ptrCliente = null;
        this.ptrConductor = null;
        this.ptrRutaSimple = null;
        this.origen = origen;
        this.Destino = Destino;
        this.FechaHora = FechaHora;
        this.Sig=null;
        this.Ant=null;
        this.llave="";
        this.llaveEncriptada="";
    }


    

    public String getLlaveEncriptada() {
        return llaveEncriptada;
    }

    public void setLlaveEncriptada(String llaveEncriptada) {
        this.llaveEncriptada = llaveEncriptada;
    }
    
    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }
    
    public nodoCaminoCorto getPtrRutaSimple() {
        return ptrRutaSimple;
    }

    public void setPtrRutaSimple(nodoCaminoCorto ptrRutaSimple) {
        this.ptrRutaSimple = ptrRutaSimple;
    }
    
     public nodoCliente getPtrCliente() {
        return ptrCliente;
    }

    public void setPtrCliente(nodoCliente ptrCliente) {
        this.ptrCliente = ptrCliente;
    }

    public nodoConductor getPtrConductor() {
        return ptrConductor;
    }

    public void setPtrConductor(nodoConductor ptrConductor) {
        this.ptrConductor = ptrConductor;
    }
        
    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String Destino) {
        this.Destino = Destino;
    }

    public String getFechaHora() {
        return FechaHora;
    }

    public void setFechaHora(String FechaHora) {
        this.FechaHora = FechaHora;
    }
    
   
    
}
