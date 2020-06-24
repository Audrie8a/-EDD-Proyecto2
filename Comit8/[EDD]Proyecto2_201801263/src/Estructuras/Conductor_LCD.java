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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Conductor_LCD {

    nodoConductor ini, fin;

    public Conductor_LCD() {
        ini = null;
        fin = null;
    }

    public void InsertarConductor(String DPI, String Nombre, String Apellido, char tipoLicencia, String genero, String Telefono, String Direccion) {
        nodoConductor Nuevo = new nodoConductor(DPI, Nombre, Apellido, tipoLicencia, genero, Telefono, Direccion);

        if (ini == null) {
            ini = Nuevo;
            ini.Sig = ini;
            Nuevo.Ant = fin;
            fin = Nuevo;
        } else {
            fin.Sig = Nuevo;
            Nuevo.Sig = ini;
            Nuevo.Ant = fin;
            fin = Nuevo;
            ini.Ant = fin;
        }

    }

    public nodoConductor Buscar(String dpi) {
        nodoConductor actual = new nodoConductor();
        actual = ini;
        if (ini!=null) {
            do {
            if (actual.getDPI() == dpi) {
                System.out.println(actual.toString());
                break;
            }
            actual = actual.Sig;
        } while (actual != ini);
        }
        return actual;
    }

    public boolean BuscarBoolean(String dpi) {
        nodoConductor actual = new nodoConductor();
        actual = ini;
        if (ini!=null) {
           do {
            if (actual.getDPI().equals(dpi)) {
                System.out.println(actual.toString());
                return true;
            }
            actual = actual.Sig;
        } while (actual != ini); 
        }
        return false;
    }

    public void Editar(String dpi, String Nombre, String Apellido, char tipoLicencia, String genero, String Telefono, String Direccion) {
        nodoConductor actual = new nodoConductor();
        actual = ini;
        do {
            if (actual.getDPI() == dpi) {
                actual.setNombre(Nombre);
                actual.setApellidos(Apellido);
                actual.setTipoLicencia(tipoLicencia);
                actual.setGenero(genero);
                actual.setTelefono(Telefono);
                actual.setDirección(Direccion);
                break;
            }
            actual = actual.Sig;
        } while (actual != ini);
    }

    public void Eliminar(String dpi) {
        nodoConductor anterior = new nodoConductor();
        nodoConductor actual = new nodoConductor();
        actual = ini;
        anterior = fin;
        do {
            if (actual.getDPI() == dpi) {

                if (actual == ini) {
                    ini = ini.Sig;
                    fin.Sig = ini;
                    ini.Ant = fin;
                } else if (actual == fin) {
                    fin = anterior;
                    ini.Ant = fin;
                    fin.Sig = ini;
                } else {
                    anterior.Sig = actual.Sig;
                    actual.Sig.Ant = anterior;
                }
            }
            anterior = actual;
            actual = actual.Sig;
        } while (actual != ini);
    }

    public void MostrarC() {
        nodoConductor actual = new nodoConductor();
        actual = ini;
        do {
            System.out.println(actual.toString());
            actual = actual.Sig;
        } while (actual != ini);
    }

    public void Graficar() {
        try {
            String ruta = "ListaConductor.txt";
            File file = new File(ruta);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("digraph g {");
            nodoConductor actual = new nodoConductor();
            String label = "";
            String conexiones = "";
            actual = ini;
            do {
                label="";
                conexiones="";
                label += actual.getDPI() + "[label=\"------ " + actual.getDPI() + "-------- " + actual.getNombre() + " \",style=filled,fillcolor = orange];\n";
                bw.write(label);
                conexiones += actual.getDPI() + "->" + actual.Sig.getDPI() + "\n";
                conexiones += actual.getDPI() + "->" + actual.Ant.getDPI() + "\n";
                bw.write(conexiones);
                actual=actual.Sig;
            } while (actual != ini);
            bw.write("}");          
           
            bw.close();
            try {
                // Execute a command without arguments
                String command = "dot -Tjpg ListaConductor.txt -o ListaConductor.jpg";
                Process child = Runtime.getRuntime().exec(command);
                child = Runtime.getRuntime().exec(command);
            } catch (Exception e) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
