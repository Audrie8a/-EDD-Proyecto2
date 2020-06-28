/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.SimpleAttributeSet;
import Nodos.nodoVehiculo;
import Estructuras.ArbolB;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author Maxwelltram
 */
public class Vehiculo extends javax.swing.JFrame {

    public Vehiculo() {
        initComponents();
    }
    nodoVehiculo vehi=new nodoVehiculo();
    ArbolB arbolitoB = new ArbolB(2);

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
        setPreferredSize(new java.awt.Dimension(1034, 485));

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(124, 124, 124)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAbrir)
                        .addGap(0, 539, Short.MAX_VALUE))
                    .addComponent(LblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAbrir))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(16, 16, 16)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addGap(0, 136, Short.MAX_VALUE)))
                .addContainerGap())
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
                    String[] lineaGuarda = linea1[j].split(":");
                    if (lineaGuarda.length == 7) {
                        String placa = lineaGuarda[0];
                        String marca = lineaGuarda[1];
                        String modelo = lineaGuarda[2];
                        String anioaux = lineaGuarda[3];
                        int anio = Integer.parseInt(anioaux);

                        String color = lineaGuarda[4];
                        String precio = lineaGuarda[5];
                        String transmision = lineaGuarda[6];
                        try {
                            nodoVehiculo Vehiculo = new nodoVehiculo(placa, marca, modelo, anio, color, precio, transmision);
                            arbolitoB.insertar(Vehiculo, "Vehiculo C:");
                            JOptionPane.showMessageDialog(null, "SE INSERTO CORRECTAMENTE:  " + placa + "  CON MARCA:   " + placa);

                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "NO SE INSERTO CORRECTAMENTE:  " + placa + " CON  MARCA  :   " + placa);
                        }
                    }
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String BuscarDpi = JOptionPane.showInputDialog("ESCRIBA EL NUMERO DE DPI");
//        if (conduc.BuscarBoolean(BuscarDpi)) {
//            nodoConductor auxMostar = conduc.Buscar(BuscarDpi);
//            JOptionPane.showMessageDialog(null, "SE ENCONTRO CORRECTAMENTE:  " + BuscarDpi + "\t" + auxMostar.getNombre() + "\t"
//                    + auxMostar.getApellidos() + "\t" + auxMostar.getTipoLicencia() + "\t" + auxMostar.getGenero() + "\t" + auxMostar.getTelefono() + "\t" + auxMostar.getDirección());
//        } else {
//            JOptionPane.showMessageDialog(null, "NO SE ENCONTRO  " + BuscarDpi, "RAYOS", JOptionPane.WARNING_MESSAGE);
//        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Toolkit toolkit=Toolkit.getDefaultToolkit();
        arbolitoB.toDotReporte();
        Image imagen=toolkit.createImage("ArbolB.jpg");
        LblImagen.setIcon(new ImageIcon(imagen.getScaledInstance(LblImagen.getWidth(), LblImagen.getHeight(), Image.SCALE_AREA_AVERAGING)));
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String AgregarPlaca = JOptionPane.showInputDialog("ESCRIBA LA PLACA");
        String AgregarMarca = JOptionPane.showInputDialog("ESCRIBA LA MARCA ");
        String AgregarModelo = JOptionPane.showInputDialog("ESCRIBA EL MODELO ");
        String AuxAnio = JOptionPane.showInputDialog("ESCRIBA EL AÑO ");
        int anio = Integer.parseInt(AuxAnio);

        String AgregarColor = JOptionPane.showInputDialog("ESCRIBA EL COLOR ");
        String AgregarPrecio = JOptionPane.showInputDialog("ESCRIBA EL PRECIO ");
        String AgregarTransmision = JOptionPane.showInputDialog("ESCRIBA LA TRANSMISION");
        try {
            nodoVehiculo Vehiculo = new nodoVehiculo(AuxAnio, AuxAnio, AuxAnio, anio, AgregarColor, AuxAnio, AgregarTransmision);
            arbolitoB.insertar(Vehiculo, "Vehiculo C:");
            JOptionPane.showMessageDialog(null, "SE INSERTO CORRECTAMENTE:  " + AgregarPlaca + "  CON MARCA:   " + AgregarMarca);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO SE INSERTO CORRECTAMENTE:  " + AgregarPlaca + " CON  MARCA  :   " + AgregarMarca);
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

//        if (conduc.Buscar(BuscarDpi) != null) {
//            conduc.Editar(BuscarDpi, ModificarNombre, ModificarApellido, ModLicencia, ModificarGenero, ModificarTelefono, ModificarDireccion);
//
//            JOptionPane.showMessageDialog(null, "SE MODIFICO CORRECTAMENTE:  " + BuscarDpi + "  CON NOMBRE:   " + ModificarNombre);
//        } else {
//            JOptionPane.showMessageDialog(null, "NO SE MODIFICO  " + BuscarDpi + "   NO SE PUDO ", "UY KIETO", JOptionPane.WARNING_MESSAGE);
//        }
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
