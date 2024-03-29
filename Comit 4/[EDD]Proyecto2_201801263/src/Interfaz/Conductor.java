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

/**
 *
 * @author Audrie
 */
public class Conductor extends javax.swing.JFrame {

    /**
     * Creates new form Conductor
     */
    public Conductor() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TxtRuta = new javax.swing.JTextField();
        btnAbrir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ruta Archivo de Entrada:");

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
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
                .addComponent(TxtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbrir)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAbrir))
                .addContainerGap(330, Short.MAX_VALUE))
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
                    String[] lineaGuarda = linea1[i].split("%");
                    if (lineaGuarda.length ==8) {
                        String dpi = lineaGuarda[0];
                        String Nombre = lineaGuarda[1];
                        String Apellidos = lineaGuarda[2];
                        String Licencia = lineaGuarda[3];
                        String Genero = lineaGuarda[4];
                        String Fecha = lineaGuarda[5];
                        int Telefono = Integer.parseInt(lineaGuarda[6]);
                        String Direccion = lineaGuarda[7];
                        Conductor_LCD conduc=new Conductor_LCD();
                        
                    }
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

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
    private javax.swing.JTextField TxtRuta;
    private javax.swing.JButton btnAbrir;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
