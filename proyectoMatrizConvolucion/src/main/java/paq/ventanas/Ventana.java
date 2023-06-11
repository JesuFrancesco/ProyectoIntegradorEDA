package paq.ventanas;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import paq.clases.FiltroGauss3x3;
import paq.clases.FiltroGauss5x5;
import paq.clases.FiltroSobel5x5;

/**
 *
 * @author Jesu
 */
public class Ventana extends javax.swing.JFrame {
    private final JFileChooser seleccionarImagen = new JFileChooser();
    private final JFileChooser guardarImagen = new JFileChooser();
    private BufferedImage imagenFiltrada = null;
    
    // Constructor de la ventana
    public Ventana() {
        initComponents();
        campoImagenCargada.setVisible(false); campoImagenPrevio.setVisible(false);
        campoImagenFiltrada.setVisible(false); campoImagenDespues.setVisible(false);
        botonGuardar.setVisible(false);
    }

    // Inicialización de componentes (realizado por Netbeans IDE)
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoFiltros = new javax.swing.ButtonGroup();
        campoTitulo = new javax.swing.JLabel();
        campoRutaImagen = new javax.swing.JTextField();
        campoSubRutaImagen = new javax.swing.JLabel();
        botonBuscar = new javax.swing.JButton();
        campoImagenCargada = new javax.swing.JLabel();
        campoImagenFiltrada = new javax.swing.JLabel();
        campoSubFiltroImagen = new javax.swing.JLabel();
        rBotonSobel3x3 = new javax.swing.JRadioButton();
        rBotonSobel5x5 = new javax.swing.JRadioButton();
        rBotonGauss3x3 = new javax.swing.JRadioButton();
        rBotonGauss5x5 = new javax.swing.JRadioButton();
        rBotonBoxBlur = new javax.swing.JRadioButton();
        botonFiltrar = new javax.swing.JButton();
        campoSubGradiente = new javax.swing.JLabel();
        campoGradiente = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JButton();
        campoImagenPrevio = new javax.swing.JLabel();
        campoImagenDespues = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Filtro de imágenes");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(800, 800));
        setPreferredSize(new java.awt.Dimension(800, 800));

        campoTitulo.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 36)); // NOI18N
        campoTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        campoTitulo.setText("Filtro de imágenes");

        campoSubRutaImagen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoSubRutaImagen.setText("Ruta de la imagen");

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

        campoSubFiltroImagen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoSubFiltroImagen.setText("Filtro de imagen");

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

        campoSubGradiente.setText("Gradiente");

        botonGuardar.setText("Guardar imagen");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonFiltrar)
                            .addComponent(campoSubRutaImagen)
                            .addComponent(campoRutaImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rBotonSobel3x3)
                                        .addGap(18, 18, 18)
                                        .addComponent(rBotonSobel5x5)
                                        .addGap(18, 18, 18)
                                        .addComponent(rBotonGauss3x3)
                                        .addGap(18, 18, 18)
                                        .addComponent(rBotonGauss5x5)
                                        .addGap(18, 18, 18)
                                        .addComponent(rBotonBoxBlur))
                                    .addComponent(campoSubFiltroImagen))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoGradiente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botonBuscar)
                                    .addComponent(campoSubGradiente))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoImagenCargada, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(campoImagenPrevio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoImagenFiltrada, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(campoImagenDespues, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(341, 341, 341))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(campoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(campoSubRutaImagen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoRutaImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoSubFiltroImagen)
                    .addComponent(campoSubGradiente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rBotonSobel3x3)
                    .addComponent(rBotonSobel5x5)
                    .addComponent(rBotonGauss3x3)
                    .addComponent(rBotonGauss5x5)
                    .addComponent(rBotonBoxBlur)
                    .addComponent(campoGradiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botonFiltrar)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(campoImagenPrevio, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoImagenCargada))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(campoImagenDespues, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoImagenFiltrada)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonGuardar)
                .addGap(145, 145, 145))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        int estado = seleccionarImagen.showOpenDialog(campoTitulo);
        if(estado == 0){
            File archivo = seleccionarImagen.getSelectedFile();
            campoRutaImagen.setText(seleccionarImagen.getSelectedFile().getAbsolutePath());
            ImageIcon imagenCargada = new ImageIcon (
                    new ImageIcon(archivo.toString()).
                            getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH)
            );
            campoImagenCargada.setVisible(true);
            campoImagenPrevio.setIcon(imagenCargada); campoImagenPrevio.setVisible(true);
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFiltrarActionPerformed
        // Variables
        String ruta = campoRutaImagen.getText();
        int gradiente;
        try {
            gradiente = Integer.parseInt(campoGradiente.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "No se ha ingresado una gradiente válida", "Gradiente", 0);
            return;
        }
        
        // Conjunto de filtros
        if (rBotonSobel3x3.isSelected()) {
            // Código para filtro sobel 3x3
            
            
            
        } else if (rBotonSobel5x5.isSelected()) {
            setImagenFiltrada(
                    new FiltroSobel5x5(ruta).deteccionBordes(gradiente)
            );
        } else if (rBotonGauss3x3.isSelected()) {
            setImagenFiltrada(
                    new FiltroGauss3x3(ruta).desenfoque()
            );
        } else if (rBotonGauss5x5.isSelected()) {
            setImagenFiltrada(
                    new FiltroGauss5x5(ruta).desenfoque()
            );
        } else if (rBotonBoxBlur.isSelected()) {
            // Código para filtro box blur
            
            
            
        } else {
            JOptionPane.showMessageDialog(null, "¡No se ha elegido un filtro!");
        }
        // Opción a guardar
        if (getImagenFiltrada() != null) {
            campoImagenFiltrada.setVisible(true);
            Image imagenDespues = getImagenFiltrada().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
            campoImagenDespues.setIcon(new ImageIcon(imagenDespues)); campoImagenDespues.setVisible(true);
            botonGuardar.setVisible(true);
        }
    }//GEN-LAST:event_botonFiltrarActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        int estado = guardarImagen.showSaveDialog(campoTitulo);
        if(estado == 0){
            String salida = guardarImagen.getSelectedFile().getAbsolutePath();
            if(!salida.endsWith(".png") && !salida.endsWith(".PNG")) salida += ".png";
            try{
                File archivo = new File(salida);
                ImageIO.write(imagenFiltrada, "png", archivo);
            } catch(IOException e){
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    public BufferedImage getImagenFiltrada() {
        return imagenFiltrada;
    }

    public void setImagenFiltrada(BufferedImage imagenFiltrada) {
        this.imagenFiltrada = imagenFiltrada;
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
    private javax.swing.JLabel campoSubFiltroImagen;
    private javax.swing.JLabel campoSubGradiente;
    private javax.swing.JLabel campoSubRutaImagen;
    private javax.swing.JLabel campoTitulo;
    private javax.swing.ButtonGroup grupoFiltros;
    private javax.swing.JRadioButton rBotonBoxBlur;
    private javax.swing.JRadioButton rBotonGauss3x3;
    private javax.swing.JRadioButton rBotonGauss5x5;
    private javax.swing.JRadioButton rBotonSobel3x3;
    private javax.swing.JRadioButton rBotonSobel5x5;
    // End of variables declaration//GEN-END:variables
}
