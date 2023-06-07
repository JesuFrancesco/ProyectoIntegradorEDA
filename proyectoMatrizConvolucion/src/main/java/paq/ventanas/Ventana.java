package paq.ventanas;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import paq.clases.FiltroSobel5x5;

/**
 *
 * @author Jesu
 */
public class Ventana extends javax.swing.JFrame {
    private final JFileChooser seleccionarImagen = new JFileChooser();
    private final JFileChooser guardarImagen = new JFileChooser();
    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
        campoImagenCargada.setVisible(false); campoImagenPrevio.setVisible(false);
        campoImagenFiltrada.setVisible(false); campoImagenDespues.setVisible(false);
        botonGuardar.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoFiltros = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        campoRutaImagen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        botonBuscar = new javax.swing.JButton();
        campoImagenCargada = new javax.swing.JLabel();
        campoImagenFiltrada = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rBotonSobel3x3 = new javax.swing.JRadioButton();
        rBotonSobel5x5 = new javax.swing.JRadioButton();
        rBotonGauss3x3 = new javax.swing.JRadioButton();
        rBotonGauss5x5 = new javax.swing.JRadioButton();
        rBotonBoxBlur = new javax.swing.JRadioButton();
        botonFiltrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        campoGradiente = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JButton();
        campoImagenPrevio = new javax.swing.JLabel();
        campoImagenDespues = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Filtro de imágenes");
        setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Filtro de imágenes");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Ruta de la imagen");

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        campoImagenCargada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        campoImagenCargada.setText("Imagen cargada");

        campoImagenFiltrada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        campoImagenFiltrada.setText("Imagen filtrada");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Filtro de imagen");

        grupoFiltros.add(rBotonSobel3x3);
        rBotonSobel3x3.setText("Sobel 3x3");

        grupoFiltros.add(rBotonSobel5x5);
        rBotonSobel5x5.setText("Sobel 5x5");

        grupoFiltros.add(rBotonGauss3x3);
        rBotonGauss3x3.setText("Gauss 3x3");

        grupoFiltros.add(rBotonGauss5x5);
        rBotonGauss5x5.setText("Gauss 5x5");

        grupoFiltros.add(rBotonBoxBlur);
        rBotonBoxBlur.setText("Box blur");

        botonFiltrar.setText("Filtrar imagen");
        botonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFiltrarActionPerformed(evt);
            }
        });

        jLabel6.setText("Gradiente");

        botonGuardar.setText("Guardar imagen");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonFiltrar)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(campoRutaImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(campoImagenCargada, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoImagenFiltrada, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(rBotonSobel3x3)
                                    .addGap(18, 18, 18)
                                    .addComponent(rBotonSobel5x5)
                                    .addGap(18, 18, 18)
                                    .addComponent(rBotonGauss3x3)
                                    .addGap(18, 18, 18)
                                    .addComponent(rBotonGauss5x5))
                                .addComponent(campoImagenPrevio, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(rBotonBoxBlur)
                                    .addGap(48, 48, 48)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(campoGradiente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botonBuscar))
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(campoImagenDespues, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))))))
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoRutaImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rBotonSobel3x3)
                    .addComponent(rBotonSobel5x5)
                    .addComponent(rBotonGauss3x3)
                    .addComponent(rBotonGauss5x5)
                    .addComponent(rBotonBoxBlur)
                    .addComponent(campoGradiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botonFiltrar)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoImagenDespues, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoImagenPrevio, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoImagenCargada)
                    .addComponent(campoImagenFiltrada))
                .addGap(18, 18, 18)
                .addComponent(botonGuardar)
                .addGap(65, 65, 65))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:
        int estado = seleccionarImagen.showOpenDialog(jLabel1);
        if(estado == 0){
            File archivo = seleccionarImagen.getSelectedFile();
            campoRutaImagen.setText(seleccionarImagen.getSelectedFile().getAbsolutePath());
            ImageIcon x = new ImageIcon (new ImageIcon(archivo.toString()).getImage().getScaledInstance(350, 400, Image.SCALE_SMOOTH));
            campoImagenCargada.setVisible(true);
            campoImagenPrevio.setIcon(x); campoImagenPrevio.setVisible(true);
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFiltrarActionPerformed
        // Validaciones
        try {
            int x = Integer.parseInt(campoGradiente.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "No se ha ingresado una gradiente válida", "Gradiente", 0);
            return;
        }
        if (rBotonSobel3x3.isSelected()) {
            
        } else if (rBotonSobel5x5.isSelected()) {
            BufferedImage imagen = new FiltroSobel5x5(campoRutaImagen.getText()).deteccionBordes(Integer.parseInt(campoGradiente.getText()));
            if(imagen!=null){
                campoImagenFiltrada.setVisible(true);
                Image x = imagen.getScaledInstance(350, 400, Image.SCALE_SMOOTH);
                campoImagenFiltrada.setIcon(new ImageIcon(x));
            }
        } else if (rBotonGauss3x3.isSelected()) {
            
        } else if (rBotonGauss5x5.isSelected()) {
            
        } else if (rBotonBoxBlur.isSelected()) {
            
        } else {
            JOptionPane.showMessageDialog(null, "¡No has elegido un filtro!");
        }
    }//GEN-LAST:event_botonFiltrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonFiltrar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JTextField campoGradiente;
    private javax.swing.JLabel campoImagenCargada;
    private javax.swing.JLabel campoImagenDespues;
    private javax.swing.JLabel campoImagenFiltrada;
    private javax.swing.JLabel campoImagenPrevio;
    private javax.swing.JTextField campoRutaImagen;
    private javax.swing.ButtonGroup grupoFiltros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton rBotonBoxBlur;
    private javax.swing.JRadioButton rBotonGauss3x3;
    private javax.swing.JRadioButton rBotonGauss5x5;
    private javax.swing.JRadioButton rBotonSobel3x3;
    private javax.swing.JRadioButton rBotonSobel5x5;
    // End of variables declaration//GEN-END:variables
}
