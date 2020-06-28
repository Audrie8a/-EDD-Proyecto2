/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import static Extra.Listas.conduc;
import static Extra.Listas.tabl;
import Interfaz.Cliente;
import Nodos.nodoCaminoCorto;
import Nodos.nodoCliente;
import Nodos.nodoConductor;
import Nodos.nodoDestino;
import Nodos.nodoViaje;
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
      
      public BlockChain_Viajes(){
          ini=null;
          fin=null;
      }
    
      
    public void PrevioInsertarViaje(String Origen, String Destino, String HoraFecha, String llave,String DpiCliente, String DpiConductor/*, String Placa */){         
        //Encriptamos llave
        String llaveEncriptada= encodeMD5(llave, llave);        
        //Obtenemos la Ruta        
        nodoCaminoCorto Ruta= grafoRutas.CaminoCorto.BuscarVertice(Origen, Destino);
        //Otbenemos el Cliente
        nodoCliente Cliente =tabl.extraerNodo(DpiCliente);
        //Obtenemos Conductor
        nodoConductor Conductor= conduc.Buscar(DpiConductor);
        //Obtenemos Vehículo
    
        InsertarViaje(llaveEncriptada, llave, Origen, Destino, HoraFecha, Cliente, Conductor, Ruta);
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
        actual= ini;
        do{
            if(actual.getLlave()==llaveEncriptada){
                System.out.println(actual.toString());
                break;
            }
            actual=actual.Sig;
        }while(actual != ini);
        return actual;
    }
    
    public boolean BuscarBoolean(String llave) {
        nodoViaje actual = new nodoViaje();
        actual = ini;
        if (ini!=null) {
           do {
            if (actual.getLlave().equals(llave)) {
                System.out.println(actual.toString());
                return true;
            }
            actual = actual.Sig;
        } while (actual != ini); 
        }
        return false;
    }
    
  /*  public void  Editar(String llave,  String Nombre, String Apellido, char tipoLicencia, String genero, String Telefono, String Direccion ){
        nodoViaje actual = new nodoViaje();
        actual= ini;
        do{
            if(actual.getLlave()==llave){
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
   */ 
    public void Eliminar(String llave){        
        String llaveEncriptada= encodeMD5(llave, llave);
        nodoViaje anterior= new nodoViaje();
        nodoViaje actual =new nodoViaje();
        actual = ini;
        anterior= fin;
        do{
            if(actual.getLlave()==llaveEncriptada){
             
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
}
