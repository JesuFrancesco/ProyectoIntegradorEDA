package paq.ventanas;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import paq.clases.ConvolucionImagen;
import paq.clases.FiltroBoxBlur;
import paq.clases.FiltroGauss3x3;
import paq.clases.FiltroGauss5x5;
import paq.clases.FiltroSobel3x3;
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
        // No mostrar determinados botones previo a información del usuario
        campoSubGradienteRadio.setVisible(false);    campoGradienteRadio.setVisible(false); 
        campoImagenCargada.setVisible(false);   campoImagenPrevio.setVisible(false); 
        campoImagenFiltrada.setVisible(false);  campoImagenDespues.setVisible(false);
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
        campoSubGradienteRadio = new javax.swing.JLabel();
        campoGradienteRadio = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JButton();
        campoImagenPrevio = new javax.swing.JLabel();
        campoImagenDespues = new javax.swing.JLabel();
        campoSubIteraciones = new javax.swing.JLabel();
        campoIteraciones = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Filtro de imágenes");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(850, 800));
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
        rBotonSobel3x3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBotonSobel3x3ActionPerformed(evt);
            }
        });

        grupoFiltros.add(rBotonSobel5x5);
        rBotonSobel5x5.setText("Sobel 5x5");
        rBotonSobel5x5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBotonSobel5x5ActionPerformed(evt);
            }
        });

        grupoFiltros.add(rBotonGauss3x3);
        rBotonGauss3x3.setText("Gauss 3x3");
        rBotonGauss3x3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBotonGauss3x3ActionPerformed(evt);
            }
        });

        grupoFiltros.add(rBotonGauss5x5);
        rBotonGauss5x5.setText("Gauss 5x5");
        rBotonGauss5x5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBotonGauss5x5ActionPerformed(evt);
            }
        });

        grupoFiltros.add(rBotonBoxBlur);
        rBotonBoxBlur.setText("Box blur");
        rBotonBoxBlur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBotonBoxBlurActionPerformed(evt);
            }
        });

        botonFiltrar.setText("Filtrar imagen");
        botonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFiltrarActionPerformed(evt);
            }
        });

        campoSubGradienteRadio.setText("Gradiente");

        botonGuardar.setText("Guardar imagen");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        campoSubIteraciones.setText("Iteraciones");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                            .addComponent(botonBuscar)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoGradienteRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoSubGradienteRadio))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoSubIteraciones)
                                    .addComponent(campoIteraciones, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                    .addComponent(campoSubGradienteRadio)
                    .addComponent(campoSubIteraciones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rBotonSobel3x3)
                    .addComponent(rBotonSobel5x5)
                    .addComponent(rBotonGauss3x3)
                    .addComponent(rBotonGauss5x5)
                    .addComponent(rBotonBoxBlur)
                    .addComponent(campoGradienteRadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoIteraciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private int leerCampoGradienteRadio(){
        int gradiente;
        try {
            gradiente = Integer.parseInt(campoGradienteRadio.getText());
            if (gradiente < 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "No se ha ingresado una gradiente válida", "Gradiente", 0);
            return -1;
        }
        return gradiente;
    }
    
    private int leerCampoIteraciones(){
        int iteraciones;
        try {
            iteraciones = Integer.parseInt(campoIteraciones.getText());
            if (iteraciones < 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "No se ha ingresado una gradiente válida", "Gradiente", 0);
            return -1;
        }
        return iteraciones;
    }
    
    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        campoImagenCargada.setVisible(false); campoImagenPrevio.setVisible(false);
        campoImagenFiltrada.setVisible(false); campoImagenDespues.setVisible(false);
        
        // Abrir ventana de selección de archivo.
        int estado = seleccionarImagen.showOpenDialog(campoTitulo);
        if(estado == 0){
            // Colocar la ruta en el text field.
            campoRutaImagen.setText(seleccionarImagen.getSelectedFile().getAbsolutePath());
            // Obtener ruta y verificar si es .png o .jpg
            String ruta = seleccionarImagen.getSelectedFile().getAbsolutePath();
            if(!ruta.endsWith(".png") && !ruta.endsWith(".jpg")){
                JOptionPane.showMessageDialog(null, "No se ha seleccionado una imagen válida");
                return;
            }
            
            // Ubicar imagen en el campo de imagen cargada
            BufferedImage img = ConvolucionImagen.cargarImagen(ruta);
            ImageIcon icono = 
                    new ImageIcon(img.getScaledInstance(350, 350, Image.SCALE_SMOOTH))
            ;
            campoImagenCargada.setVisible(true);
            campoImagenPrevio.setIcon(icono); campoImagenPrevio.setVisible(true);
            campoImagenDespues.setIcon(null);
        } else if (estado == 1 && campoImagenPrevio.getIcon()!=null) {
            campoImagenCargada.setVisible(true); campoImagenPrevio.setVisible(true);
            if(campoImagenDespues.getIcon()!=null){
                campoImagenFiltrada.setVisible(true); campoImagenDespues.setVisible(true);
            }
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFiltrarActionPerformed
        // Eliminar filtro previo
        setImagenFiltrada(null); campoImagenFiltrada.setIcon(null);
        
        // Variables
        String ruta = campoRutaImagen.getText();
        BufferedImage img = ConvolucionImagen.cargarImagen(ruta);
        
        if(img==null) return;
        // Conjunto de filtros
        if (rBotonSobel3x3.isSelected()) {
            int g = leerCampoGradienteRadio();
            if (g == -1) {return;}
            setImagenFiltrada(
                    new FiltroSobel3x3(img).deteccionBordes(g)
            );
        } else if (rBotonSobel5x5.isSelected()) {
            int g = leerCampoGradienteRadio();
            if (g == -1) {return;}
            setImagenFiltrada(
                    new FiltroSobel5x5(img).deteccionBordes(g)
            );
        } else if (rBotonGauss3x3.isSelected()) {
            int i = leerCampoIteraciones();
            if (i == -1) {return;}
            setImagenFiltrada(
                    new FiltroGauss3x3(img).desenfoque(i)
            );
        } else if (rBotonGauss5x5.isSelected()) {
            int i = leerCampoIteraciones();
            if (i == -1) {return;}
            setImagenFiltrada(
                    new FiltroGauss5x5(img).desenfoque(i)
            );
        } else if (rBotonBoxBlur.isSelected()) {
            int i = leerCampoIteraciones();
            if (i == -1) {return;}
            int r = leerCampoGradienteRadio();
            if (r == -1) {return;}
            setImagenFiltrada(
                    new FiltroBoxBlur(img).desenfoque(r,i)
            );
        } else {
            JOptionPane.showMessageDialog(null, "¡No se ha elegido un filtro!");
        }
        // Mostrar la imagen filtrada
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
            try {
                File archivo = new File(salida);
                ImageIO.write(imagenFiltrada, "png", archivo);
            } catch(IOException e){
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void rBotonSobel3x3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBotonSobel3x3ActionPerformed
        campoSubGradienteRadio.setText("Gradiente");
        campoSubGradienteRadio.setVisible(true);
        campoGradienteRadio.setVisible(true);
        campoSubIteraciones.setVisible(false);
        campoIteraciones.setVisible(false);
    }//GEN-LAST:event_rBotonSobel3x3ActionPerformed

    private void rBotonSobel5x5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBotonSobel5x5ActionPerformed
        campoSubGradienteRadio.setText("Gradiente");
        campoSubGradienteRadio.setVisible(true);
        campoGradienteRadio.setVisible(true);
        campoSubIteraciones.setVisible(false);
        campoIteraciones.setVisible(false);
    }//GEN-LAST:event_rBotonSobel5x5ActionPerformed

    private void rBotonGauss3x3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBotonGauss3x3ActionPerformed
        campoSubGradienteRadio.setVisible(false);
        campoGradienteRadio.setVisible(false);
        campoSubIteraciones.setVisible(true);
        campoIteraciones.setVisible(true);
    }//GEN-LAST:event_rBotonGauss3x3ActionPerformed

    private void rBotonGauss5x5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBotonGauss5x5ActionPerformed
        campoSubGradienteRadio.setVisible(false);
        campoGradienteRadio.setVisible(false);
        campoSubIteraciones.setVisible(true);
        campoIteraciones.setVisible(true);
    }//GEN-LAST:event_rBotonGauss5x5ActionPerformed

    private void rBotonBoxBlurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBotonBoxBlurActionPerformed
        campoSubGradienteRadio.setText("Radio");
        campoGradienteRadio.setText("");
        campoSubGradienteRadio.setVisible(true);
        campoGradienteRadio.setVisible(true);
        campoSubIteraciones.setVisible(true);
        campoIteraciones.setVisible(true);
    }//GEN-LAST:event_rBotonBoxBlurActionPerformed

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
    private javax.swing.JTextField campoGradienteRadio;
    private javax.swing.JLabel campoImagenCargada;
    private javax.swing.JLabel campoImagenDespues;
    private javax.swing.JLabel campoImagenFiltrada;
    private javax.swing.JLabel campoImagenPrevio;
    private javax.swing.JTextField campoIteraciones;
    private javax.swing.JTextField campoRutaImagen;
    private javax.swing.JLabel campoSubFiltroImagen;
    private javax.swing.JLabel campoSubGradienteRadio;
    private javax.swing.JLabel campoSubIteraciones;
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
