
package Nodos;
import Nodos.nodoCliente;
/**
 *
 * @author Maxwelltram
 */
public class nodoClienteLista {
   public nodoClienteLista Siguiente;
   private String DPI;
   private String Nombre;
   
    public nodoClienteLista (String Dpi, String nombre) {
        this.DPI=Dpi;
        this.Nombre=nombre;
        Siguiente=null;
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
   
    
}
