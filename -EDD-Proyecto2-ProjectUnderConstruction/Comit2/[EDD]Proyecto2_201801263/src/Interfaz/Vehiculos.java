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

/**
 *
 * @author Maxwellt
 */
public class Vehiculos extends javax.swing.JFrame {


    public Vehiculos() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ruta Archivo de Entrada");

        jButton1.setText("Abrir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(349, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
            jTextField1.setText(path);
            
            
            String[] linea = contenido.split("\n");
            SimpleAttributeSet attrs = new SimpleAttributeSet();
            
            for (int i = 0; i < linea.length; i++) {
                String[] linea1 = linea[i].split(";");
                for (int j = 0; j < linea1.length; j++) {
                    String[] lineaGuarda = linea1[i].split(":");
                    if (lineaGuarda.length ==7) {
                        
                        String placa = lineaGuarda[0];
                        String Nombre = lineaGuarda[1];
                        String Modelo = lineaGuarda[2];
                        int Anio = Integer.parseInt(lineaGuarda[3]);
                        String Color = lineaGuarda[4];
                        double Precio = Double.parseDouble(lineaGuarda[5]);
                        String Transmision = lineaGuarda[6];

                    }
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }                                 
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    
    
    
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
