
package Extras;

import Interfaz.Conductor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import Nodos.nodoConductor;
import jdk.nashorn.internal.objects.NativeArray;
/**
 *
 * @author Audrie
 */
public class Metodos {
    public String LeerArchivo(String Filtro_Archivo) {
        String aux = "";
        String texto = "";
        String Ruta = "";
        try {
            /**
             * llamamos el metodo que permite cargar la ventana
             */
            JFileChooser JfC = new JFileChooser();
            JfC.setAcceptAllFileFilterUsed(false);
            JfC.setFileFilter(new FileNameExtensionFilter("Archivos con extension *." + Filtro_Archivo, Filtro_Archivo));
            JfC.setCurrentDirectory(new File("Escritorio"));
            JfC.showOpenDialog(null);
            /**
             * abrimos el archivo seleccionado
             */
            File Archivo = JfC.getSelectedFile();
            if (Archivo != null) {
                Ruta = "" + Archivo;
                FileReader FR = new FileReader(Archivo);
                try (BufferedReader Buffer = new BufferedReader(FR)) {
                    while ((aux = Buffer.readLine()) != null) {
                        texto += aux + "\n";
                    }
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + "" + "\nNo se ha podido leer el archivo", "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }
        return texto;
    }
    
    public String ObtenerContenidoArchivo(String Ruta) {
        String aux = "";
        String texto = "";
        try {
            File Archivo = new File(Ruta);
            if (Archivo != null) {
                Ruta = "" + Archivo;
                FileReader FR = new FileReader(Archivo);
                try (BufferedReader Buffer = new BufferedReader(FR)) {
                    while ((aux = Buffer.readLine()) != null) {
                        texto += aux + "\n";
                    }
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + "" + "\nNo se ha podido leer el archivo", "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }
        return texto;
    }
    
//    public String SeleccionarArchivo(String Filtro_Archivo) {
//        try {
//            JFileChooser JfC = new JFileChooser();
//            JfC.setAcceptAllFileFilterUsed(false);
//            JfC.setFileFilter(new FileNameExtensionFilter("Archivos con extension *." + Filtro_Archivo, Filtro_Archivo));
//            JfC.setCurrentDirectory(new File("Escritorio"));
//            JfC.showOpenDialog(null);
//            String ruta = JfC.getSelectedFile().getAbsolutePath();
//            return ruta;
//        } catch (Exception E) {
//            System.err.println("Error al abrir el archivo");
//            return "";
//        }
//    }
    
//    public void SepararNivelesPersonaje(String ContenidoArchivo) {
//        String[] Lineas = ContenidoArchivo.split("\n"); //Separa el contenido de la cadena cada vez que encuntre un salto de linea
//        for (String Linea : Lineas) {
//            if (!"".equalsIgnoreCase(Linea.trim())) {
//                GuardarConductor(Linea, Listas.listaConductores);
//                
//            }
//        }
//    }
    
//    public void GuardarConductor(String ParametrosPersonaje,List<Conductor> lstConductor) {
//        try {
//            nodoConductor Conductor = new nodoConductor();
//            String Parametros = ParametrosPersonaje.substring(11, ParametrosPersonaje.length());// obtenemos los parametros a partir del caracter 11
//            String separador = Pattern.quote("%");
//            String[] ValoresParametros = Parametros.split(separador);// Separamos la cadena cada vez que encuentr un "%"
//            //Guardamos los valores a la lista de conductores
//            Conductor.setDPI(ValoresParametros[0]);            
//            Conductor.setNombre(ValoresParametros[1]);
//            Conductor.setTipoLicencia(ValoresParametros[2].charAt(0));
//            Conductor.setGenero(ValoresParametros[3]);
//            Conductor.setTelefono(ValoresParametros[4]);
//            Conductor.setDirección(ValoresParametros[5]);
//            System.out.println("Conductor Guardado");
//        } catch (Exception E) {
//            System.err.println("Error al guardar el conductor...");
//        }
//    }
    
}
