/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;
import Nodos.nodoCliente;
import Nodos.nodoClienteLista;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.math.BigInteger;
import javax.swing.JOptionPane;

/**
 *
 * @author Maxwelltram
 */


public class TablaHash {
    private int tamanio;
    private static int tamanioss[];
    private int indiceTam;
    private int ocupados;
    private float porcentajeUtil;
    private float factorUtil;
    private nodoCliente [] vectorHash;
    
    public TablaHash(){
            this.tamanioss = new int[]{37,73,145,293,577,1153,2309};
            this.indiceTam = 0;
            this.ocupados = 0;
            this.factorUtil=75.0f;
            this.tamanio=tamanioss[indiceTam];
            this.vectorHash= new nodoCliente[tamanio];
            this.porcentajeUtil = calcularPorcentajeUtil();
    }
    
    private int funcion1(int clave){
        return clave%tamanio;
    }
    
    private float calcularPorcentajeUtil(){
        return (ocupados*100)/tamanio;
    }
    
    public void Insertar(String DPI, String Nombre,String Apellidos, String Genero, String Fecha, int Telefono, String Direccion){
        boolean insertado=false;
        
        
        BigInteger bigIntegerCasteo=new BigInteger(DPI);
        int CasteoDPIPosicion = bigIntegerCasteo.mod(BigInteger.valueOf(tamanio)).intValue();     
        if (porcentajeUtil<=75.0f) {
            for (int i = 0; i < tamanio; i++) {
                if (CasteoDPIPosicion>tamanio) {
                    CasteoDPIPosicion-=tamanio;
                }
                if (vectorHash[CasteoDPIPosicion]==null || vectorHash[CasteoDPIPosicion].estado=='b') {
                    LS_Cliente listaCliente=new LS_Cliente();
                    vectorHash[CasteoDPIPosicion]=new nodoCliente(DPI,Nombre,Apellidos, Genero, Fecha, Telefono, Direccion, listaCliente);
                    ocupados+=1;
                    porcentajeUtil=calcularPorcentajeUtil();
                    insertado=true;
                    break;
                }else if (vectorHash[CasteoDPIPosicion]!=null) {
                    vectorHash[CasteoDPIPosicion].getListaDeCliente().InsertarCliente(DPI, Nombre,Apellidos, Genero, Fecha, Telefono, Direccion);
                    insertado=true;
                    JOptionPane.showMessageDialog(null, "SE INSERTO CORRECTAMENTE EN LA LISTA SIMPLE:  "+DPI+"  CON NOMBRE:   "+Nombre);
                    break;
                }
                else{
                    if (vectorHash[CasteoDPIPosicion].DPI.equals(DPI)) {
                        JOptionPane.showMessageDialog(null,"YA EXISTE ESTE DATO DENTRO DE LA TABLA","CUIDADO",JOptionPane.ERROR_MESSAGE);
                        
                        break;
                    }else{
                        JOptionPane.showMessageDialog(null,"COLISION EN:  "+CasteoDPIPosicion,"RAYOS",JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            if (insertado==true) {
                JOptionPane.showMessageDialog(null, "SE INSERTO CORRECTAMENTE:  "+DPI+"  CON NOMBRE:   "+Nombre);
            }else{
                JOptionPane.showMessageDialog(null,"NO SE INSERTO   "+DPI+"CON NOMBRE:   "+Nombre,"RAYOS",JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null,"SE NECESITA HACER UN REHASHING  "+porcentajeUtil,"UY KIETO",JOptionPane.WARNING_MESSAGE);
            Rehashing();
            Insertar(DPI, Nombre,Apellidos, Genero, Fecha, Telefono, Direccion);
        }
        
    }
    
    private void Rehashing(){
        nodoCliente[] tmp=vectorHash;
        int tamanioTmp=tamanio;
        if (indiceTam<tamanioss.length) {
            indiceTam+=1;
            if (indiceTam==tamanioss.length-1) {
                JOptionPane.showMessageDialog(null,"SE ALCANZO EL VALOR MAXIMO DEL ARREGLO HASH D:" ,"UY KIETO",JOptionPane.WARNING_MESSAGE);
            }
        }
        tamanio=tamanioss[indiceTam];
        vectorHash=new nodoCliente[tamanio];
        ocupados=0;
        porcentajeUtil=calcularPorcentajeUtil();
        for (int i = 0; i < tamanioTmp; i++) {
            if (tmp[i]!=null) {
                Insertar(tmp[i].DPI, tmp[i].Nombre, tmp[i].Apellidos, tmp[i].Genero, tmp[i].Fecha,  tmp[i].Telefono, tmp[i].Direccion);
            }
        }
        JOptionPane.showMessageDialog(null, "REHASHING CORRECTAMENTE  ", "TODO SALIO BIEN" ,JOptionPane.OK_OPTION);
    }
    
    
    public nodoCliente extraerNodo(String ModificarDPI){
        boolean encontrado=false;
        nodoCliente tmp=null;
        int pos=0;
        BigInteger bigIntegerCasteo=new BigInteger(ModificarDPI);
        int CasteoDPIPosicion = bigIntegerCasteo.mod(BigInteger.valueOf(tamanio)).intValue();
        for (int i = 0; i < tamanio; i++) {
            if (CasteoDPIPosicion>=tamanio) {
                CasteoDPIPosicion-=tamanio;
                pos=CasteoDPIPosicion;
            }
            if (vectorHash[CasteoDPIPosicion]!=null) {
                if (vectorHash[CasteoDPIPosicion].DPI.equals(ModificarDPI)) {
                    tmp=vectorHash[CasteoDPIPosicion];
                    encontrado=true;
                    break;
                }else if (vectorHash[CasteoDPIPosicion].getListaDeCliente()!=null) {
                    if (vectorHash[CasteoDPIPosicion].getListaDeCliente().Buscar(ModificarDPI)) {
                        tmp=vectorHash[CasteoDPIPosicion];
                        encontrado = true;
                        break;
                    }
                }
            }
        }
        if (encontrado) {
            JOptionPane.showMessageDialog(null, "SE ENCONTRO   "+ModificarDPI);
        }else{
            JOptionPane.showMessageDialog(null,"NO SE ENCONTRO   "+ModificarDPI,"RAYOS",JOptionPane.WARNING_MESSAGE);
        }
        return tmp;
    }
    public void Imprimir(){
        for (int i = 0; i < tamanio; i++) {
                         int k = i+1;
                        if (vectorHash[i]!=null) {
                            String DPI= vectorHash[i].DPI;
                            String Nombre = vectorHash[i].Nombre;
                            System.out.println(i+" [label=\"numero ------- "+i+"----- Usuario - "+DPI+"  contraseña - "+Nombre+" \"];");
                        }else{
                            System.out.println(i+" [label=\"numero ------- "+i+"----- Usuario - vacio  contraseña - vacio \"];");                          
                              
                        }                     
                       
                    }
        System.out.println("**************************************************************************************************************+");
    }
    
    public void Graficar(){
                try {
            String ruta = "tablahash.txt";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("digraph g {");
            bw.write("node[shape=record]");
            String conexiones="";
                    for (int i = 0; i < tamanio; i++) {
                         int k = i+1;
                        if (vectorHash[i]!=null) {
                           String us= vectorHash[i].DPI;
                           String contra = vectorHash[i].Nombre;
                           bw.write(i+" [label=\"numero ------- "+i+"----- Usuario - "+us+"  contraseña - "+contra+" \",style= filled,fillcolor = green];");
                          
                           if (i<tamanio-1) {
                            
                            conexiones+=i+"->"+k+";\n";
                        } 
                        }else{
                               bw.write(i+" [label=\"numero ------- "+i+"----- Usuario - vacio  contraseña - vacio \",style= filled,fillcolor = red];");                          
                              conexiones+=i+"->"+k+";\n";
                        }                     
                       
                    }
            bw.write(conexiones);
            bw.write("}");          
           
            bw.close();
            try {
    // Execute a command without arguments
                    String command = "dot -Tjpg tablahash.txt -o HashTable.jpg";
                     Process child = Runtime.getRuntime().exec(command);
                     child = Runtime.getRuntime().exec(command);
                } catch (Exception e) {
                }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
                
    }
}
