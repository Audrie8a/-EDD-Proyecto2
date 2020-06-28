/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Extra.Listas;
import static Extra.Listas.arbolitoB;
import static Extra.Listas.conduc;
import static Extra.Listas.tabl;
import static Extra.Listas.vehi;
import Interfaz.Cliente;
import Nodos.nodoCaminoCorto;
import Nodos.nodoCliente;
import Nodos.nodoConductor;
import Nodos.nodoDestino;
import Nodos.nodoVehiculo;
import Nodos.nodoViaje;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JOptionPane;

//Lo que necesito para encriptar
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author Audrie
 */
public class BlockChain_Viajes {
    nodoViaje ini, fin;

    public nodoViaje getIni() {
        return ini;
    }

    public void setIni(nodoViaje ini) {
        this.ini = ini;
    }

    public nodoViaje getFin() {
        return fin;
    }

    public void setFin(nodoViaje fin) {
        this.fin = fin;
    }
    
      
      public BlockChain_Viajes(){
          ini=null;
          fin=null;
      }
    
      
    public void PrevioInsertarViaje(String Origen, String Destino, String HoraFecha, String llave,String DpiCliente, String DpiConductor, String Placa ){         
        //Encriptamos llave
        String llaveEncriptada= encodeMD5(llave, llave);        
        //Obtenemos la Ruta        
        nodoCaminoCorto Ruta= grafoRutas.CaminoCorto.BuscarVertice(Origen, Destino);
        //Otbenemos el Cliente
        nodoCliente Cliente =tabl.extraerNodo(DpiCliente);
        //Obtenemos Conductor
        nodoConductor Conductor= conduc.Buscar(DpiConductor);
        //Obtenemos Vehículo
        //nodoVehiculo Vehiculo = arbolitoB.Buscar(Placa);
        if(Ruta != null && Cliente != null && Conductor != null){
            InsertarViaje(llaveEncriptada, llave, Origen, Destino, HoraFecha, Cliente, Conductor, Ruta);
        }else{
            JOptionPane.showMessageDialog(null, "Algunos de los datos ingresados no se encuentran cargados en el sistema. Favor verificar, Gracias!");
        }
        
    }  
    public void InsertarViaje(String LLaveEncriptada, String llave,String Origen, String Destino, String HoraFecha, nodoCliente Cliente, nodoConductor Condutor, nodoCaminoCorto Ruta){

        nodoViaje Nuevo = new nodoViaje(Origen, Destino, HoraFecha);
        Nuevo.setLlave(llave);
        Nuevo.setLlaveEncriptada(LLaveEncriptada);
        Nuevo.setPtrRutaSimple(Ruta);
        Nuevo.setPtrCliente(Cliente);
        Nuevo.setPtrConductor(Condutor);

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
    
    public nodoViaje Buscar(String llave){
        String llaveEncriptada= encodeMD5(llave, llave);
        nodoViaje actual = new nodoViaje();
        nodoViaje respuesta = null;
        actual= ini;
        if(actual != null){
            do{
            if(actual.getLlaveEncriptada().equals(llaveEncriptada)){
                System.out.println(actual.toString());
                respuesta=actual;
                break;
            }
            actual=actual.Sig;
            }while(actual != ini);
        }
        
        return respuesta;
    }
    
    
    public void PrevioEditar(String llaveModificar, String llave,String Origen, String Destino, String HoraFecha, String DpiCliente, String DpiConductor){
        //Encriptamos llave
        String llaveEncriptada= encodeMD5(llave, llave);        
        //Obtenemos la Ruta        
        nodoCaminoCorto Ruta= grafoRutas.CaminoCorto.BuscarVertice(Origen, Destino);
        //Otbenemos el Cliente
        nodoCliente Cliente =tabl.extraerNodo(DpiCliente);
        //Obtenemos Conductor
        nodoConductor Conductor= conduc.Buscar(DpiConductor);
        //Obtenemos Vehículo
        
        Editar(llaveModificar, llaveEncriptada, llave, Origen, Destino, HoraFecha, Cliente, Conductor, Ruta);
    
    }
    public void  Editar(String llaveModificar,String LLaveEncriptada, String llave,String Origen, String Destino, String HoraFecha, nodoCliente Cliente, nodoConductor Condutor, nodoCaminoCorto Ruta ){
        nodoViaje actual = new nodoViaje();
        String llaveEncriptada= encodeMD5(llaveModificar, llaveModificar);
        actual= ini;
        do{
            if(actual.getLlaveEncriptada().equals(LLaveEncriptada)){
                actual.setLlave(llave);
                actual.setLlaveEncriptada(LLaveEncriptada);
                actual.setOrigen(Origen);
                actual.setDestino(Destino);
                actual.setFechaHora(HoraFecha);
                actual.setPtrCliente(Cliente);
                actual.setPtrConductor(Condutor);
                actual.setPtrRutaSimple(Ruta);
                break;
            }
            actual=actual.Sig;
        }while(actual != ini);        
    }
   
    public void Eliminar(String llave){        
        String llaveEncriptada= encodeMD5(llave, llave);
        nodoViaje anterior= new nodoViaje();
        nodoViaje actual =new nodoViaje();
        actual = ini;
        anterior= fin;
        do{
            if(actual.getLlaveEncriptada().equals(llaveEncriptada)){
             
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
        nodoViaje actual = new nodoViaje();
        actual= ini;
        do{
            System.out.println(actual.toString());
            actual= actual.Sig;
        }while(actual != ini);
    }
    
    public String encodeMD5(String llave, String texto){
        String encriptacion="";
        try {
            MessageDigest md5= MessageDigest.getInstance("MD5"); //Indico el tipo de encriptacion
            byte[] llaveArreglo = md5.digest(llave.getBytes("utf-8"));  //Primer arreglo, Se usa utf-8, en caso de que existan tildes
            byte[] byteLlaveArrglo= Arrays.copyOf(llaveArreglo, 24);    //Segundo arreglo, copia del primer arreglo a base 24
            SecretKey llaveSecreta = new SecretKeySpec(byteLlaveArrglo, "DESede");   //DESde: Es parte de la sintaxsis
            Cipher cifrado= Cipher.getInstance("DESede");
            cifrado.init(Cipher.ENCRYPT_MODE,llaveSecreta);            
            byte[] textoPlanoBytes=  texto.getBytes("utf-8");
            byte[] buffer= cifrado.doFinal(textoPlanoBytes);    //contiene el cifrado
            byte[] BytesBase64=  Base64.encodeBase64(buffer);
            encriptacion= new String(BytesBase64);
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error la encriptar");
        }
        return encriptacion;
    }
    
    public String decodeMD5(String llave, String textoEncriptado){
        String desencirptacion="";
        try {
            byte[] mensaje= Base64.decodeBase64(textoEncriptado.getBytes("utf-8"));
            MessageDigest md5= MessageDigest.getInstance("MD5");
            byte[] digestOfpassword= md5.digest(llave.getBytes("utf-8"));
            byte[] LlaveBytes= Arrays.copyOf(digestOfpassword, 24);
            SecretKey llaveSecreta=new  SecretKeySpec(LlaveBytes, "DESede");
            Cipher decifrador= Cipher.getInstance("DESede");
            decifrador.init(Cipher.DECRYPT_MODE, llaveSecreta);
            byte[] textoPlano= decifrador.doFinal(mensaje);
            desencirptacion= new String(textoPlano, "UTF-8");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error la desencriptar");
        }
        
        return desencirptacion;
    }
    
    public void Graficar(){
        try {
            String ruta = "ListaConductor.txt";
            File file = new File(ruta);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("digraph g {\n");
            bw.write(getText());
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
    public String getText(){
        nodoViaje actual = new nodoViaje();
            String label = "";
            String conexiones = "";
            actual = ini;
            do {
                label += "nodo"+actual.getLlaveEncriptada()+ "[label=\"------ " + actual.getLlaveEncriptada()+ "-------- " + actual.getPtrCliente().getDPI()+"-------- "+ actual.getPtrConductor().getDPI()+ " \",style=filled,fillcolor = orange];\n";
                
                label += "nodo"+actual.getLlaveEncriptada()+ "->" +"nodo"+actual.Sig.getLlaveEncriptada()+ "\n";
                label += "nodo"+actual.getLlaveEncriptada()+ "->" +"nodo"+actual.Ant.getLlaveEncriptada()+ "\n";
                actual=actual.Sig;
            } while (actual != ini);
    
        return label;
    }
}
