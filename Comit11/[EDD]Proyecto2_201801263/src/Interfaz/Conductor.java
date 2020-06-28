/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Estructuras.Conductor_LCD;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.SimpleAttributeSet;
import Nodos.nodoConductor;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author Audrie
 */
public class Conductor extends javax.swing.JFrame {

    public Conductor() {
        initComponents();
    }

    Conductor_LCD conduc = new Conductor_LCD();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TxtRuta = new javax.swing.JTextField();
        btnAbrir = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        LblImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Ruta Archivo de Entrada:");

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        jButton4.setText("ELIMINAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("MOSTRAR INFO");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("GRAFICAR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton2.setText("AGREGAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("MODIFICAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAbrir)
                    .addComponent(LblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(188, 188, 188)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(713, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAbrir))
                .addGap(18, 18, 18)
                .addComponent(LblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(94, 94, 94)
                    .addComponent(jButton2)
                    .addGap(18, 18, 18)
                    .addComponent(jButton3)
                    .addGap(18, 18, 18)
                    .addComponent(jButton4)
                    .addGap(16, 16, 16)
                    .addComponent(jButton5)
                    .addGap(18, 18, 18)
                    .addComponent(jButton6)
                    .addContainerGap(196, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        JFileChooser select = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Solo TXT", "txt");

        select.setFileFilter(filtro);

        select.setDialogTitle("SOLO TXT");
        select.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        select.showOpenDialog(this);
        File archivo = select.getSelectedFile();
        if ((archivo == null) || (archivo.getName().equals(""))) {
            JOptionPane.showMessageDialog(rootPane, "Archivo invalido");
        }
        try {
            String path = archivo.getAbsolutePath();
            String contenido = getArchivo(path);
            TxtRuta.setText(path);

            String[] linea = contenido.split("\n");
            SimpleAttributeSet attrs = new SimpleAttributeSet();

            for (int i = 0; i < linea.length; i++) {
                String[] linea1 = linea[i].split(";");
                for (int j = 0; j < linea1.length; j++) {
                    String[] lineaGuarda = linea1[j].split("%");
                    if (lineaGuarda.length == 8) {
                        String dpi = lineaGuarda[0];
                        String Nombre = lineaGuarda[1];
                        String Apellidos = lineaGuarda[2];
                        String Licencia = lineaGuarda[3];
                        char Lice = Licencia.charAt(0);
                        String Genero = lineaGuarda[4];
                        String Fecha = lineaGuarda[5];
                        String Telefono = lineaGuarda[6];
                        String Direccion = lineaGuarda[7];
                        try {
                            if (conduc.BuscarBoolean(dpi) == true) {
                            JOptionPane.showMessageDialog(null, "NO SE INSERTO  " + dpi + "   SE ENCUENTRA GUARDADO YA", "UY KIETO", JOptionPane.WARNING_MESSAGE);
                        } else if (conduc.BuscarBoolean(dpi) == false) {
                            conduc.InsertarConductor(dpi, Nombre, Apellidos, Lice, Genero, Telefono, Direccion);
                            JOptionPane.showMessageDialog(null, "SE INSERTO CORRECTAMENTE:  " + dpi + "  CON NOMBRE:   " + Nombre);
                        }
                        } catch (Exception e) {
                        }
                    }
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String BuscarDpi = JOptionPane.showInputDialog("ESCRIBA EL NUMERO DE DPI");
        if (conduc.BuscarBoolean(BuscarDpi)) {
            conduc.Eliminar(BuscarDpi);
            JOptionPane.showMessageDialog(null, "SE INSERTO CORRECTAMENTE:  " + BuscarDpi );
        }else{
            JOptionPane.showMessageDialog(null, "NO SE ELIMINO  " + BuscarDpi, "RAYOS", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String BuscarDpi = JOptionPane.showInputDialog("ESCRIBA EL NUMERO DE DPI");
        if (conduc.BuscarBoolean(BuscarDpi)) {
            nodoConductor auxMostar=conduc.Buscar(BuscarDpi);
            JOptionPane.showMessageDialog(null, "SE ENCONTRO CORRECTAMENTE:  " + BuscarDpi +"\t"+auxMostar.getNombre()+"\t"+
            auxMostar.getApellidos()+"\t"+auxMostar.getTipoLicencia()+"\t"+auxMostar.getGenero()+"\t"+auxMostar.getTelefono()+"\t"+auxMostar.getDirección());
        }else{
            JOptionPane.showMessageDialog(null, "NO SE ENCONTRO  " + BuscarDpi, "RAYOS", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        conduc.Graficar();
        Toolkit toolkit=Toolkit.getDefaultToolkit();
        Image imagen=toolkit.createImage("ListaConductor.jpg");
        LblImagen.setIcon(new ImageIcon(imagen.getScaledInstance(LblImagen.getWidth(), LblImagen.getHeight(), Image.SCALE_AREA_AVERAGING)));
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String AgregarDpi = JOptionPane.showInputDialog("ESCRIBA EL NUMERO DE DPI");
        String AgregarNombre = JOptionPane.showInputDialog("ESCRIBA EL NOMBRE ");
        String AgregarApellido = JOptionPane.showInputDialog("ESCRIBA EL APELLIDO ");
        String AuxLicencia = JOptionPane.showInputDialog("ESCRIBA LA LICENCIA ");
        char AgregarLicencia = AuxLicencia.charAt(0);
        String AgregarGenero = JOptionPane.showInputDialog("ESCRIBA EL GENERO ");
        String AgregarTelefono = JOptionPane.showInputDialog("ESCRIBA EL TELEFONO ");
        String AgregarDireccion = JOptionPane.showInputDialog("ESCRIBA LA DIRECCION");
        if (conduc.BuscarBoolean(AgregarDpi) == true) {
            JOptionPane.showMessageDialog(null, "NO SE INSERTO  " + AgregarDpi + "   SE ENCUENTRA GUARDADO YA", "UY KIETO", JOptionPane.WARNING_MESSAGE);
        } else if (conduc.BuscarBoolean(AgregarDpi) == false) {
            conduc.InsertarConductor(AgregarDpi, AgregarNombre, AgregarApellido, AgregarLicencia, AgregarGenero, AgregarTelefono, AgregarDireccion);
            JOptionPane.showMessageDialog(null, "SE INSERTO CORRECTAMENTE:  " + AgregarDpi + "  CON NOMBRE:   " + AgregarNombre);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String BuscarDpi = JOptionPane.showInputDialog("ESCRIBA EL NUMERO DE DPI");
        String ModificarNombre = JOptionPane.showInputDialog("ESCRIBA EL NOMBRE");
        String ModificarApellido = JOptionPane.showInputDialog("ESCRIBA EL APELLIDO ");
        String ModificarLicencia = JOptionPane.showInputDialog("ESCRIBA LA LICENCIA ");
        char ModLicencia = ModificarApellido.charAt(0);
        String ModificarGenero = JOptionPane.showInputDialog("ESCRIBA EL GENERO ");
        String ModificarTelefono = JOptionPane.showInputDialog("ESCRIBA EL TELEFONO ");
        String ModificarDireccion = JOptionPane.showInputDialog("ESCRIBA LA DIRECCION");

        if (conduc.Buscar(BuscarDpi)!=null) {
            conduc.Editar(BuscarDpi, ModificarNombre, ModificarApellido, ModLicencia, ModificarGenero, ModificarTelefono, ModificarDireccion);
            
            JOptionPane.showMessageDialog(null, "SE MODIFICO CORRECTAMENTE:  " + BuscarDpi + "  CON NOMBRE:   " +ModificarNombre);
        }else{
            JOptionPane.showMessageDialog(null, "NO SE MODIFICO  " + BuscarDpi + "   NO SE PUDO ", "UY KIETO", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    public String getArchivo(String ruta) {

        FileReader fr = null;
        BufferedReader br = null;
        String contenido = "";
        try {
            fr = new FileReader(ruta);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido += linea + "\n";
            }
        } catch (Exception ex) {

        } finally {
            try {
                br.close();
            } catch (Exception ex) {

            }
        }
        return contenido;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblImagen;
    private javax.swing.JTextField TxtRuta;
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
