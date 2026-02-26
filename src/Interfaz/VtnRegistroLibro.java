//Paulina Vazquez - 325917
//Lucas Conde - 340100
package Interfaz;

import Modelo.*;
import java.awt.Image;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class VtnRegistroLibro extends javax.swing.JFrame implements Observer {

    private Sistema modelo;
    private File imagenSeleccionada;

    public VtnRegistroLibro() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public VtnRegistroLibro(Sistema unModelo) {
        initComponents();
        this.modelo = unModelo;
        this.modelo.addObserver(this);
        setLocationRelativeTo(null);
        update(null, null);
    }

    public void update(Observable o, Object obj) {
        this.lstGeneros.setListData(this.modelo.getArrayGeneros());
        this.lstEditoriales.setListData(this.modelo.getArrayEditoriales());
        this.txtIsbn.setText("");
        this.txtPrecioDeCosto.setText("");
        this.txtPrecioDeVenta.setText("");
        this.txtTitulo.setText("");
        this.txtCantidad.setText("");
        this.lstAutores.setListData(new Autor[0]);
        this.lblImagen.setText("Sin imagen");
        this.lblImagen.setIcon(null);
        this.imagenSeleccionada =null;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstEditoriales = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstAutores = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstGeneros = new javax.swing.JList();
        lblRegistrarLibro = new javax.swing.JLabel();
        lblEditorial = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        lblAutor = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        txtIsbn = new javax.swing.JTextField();
        txtPrecioDeCosto = new javax.swing.JTextField();
        txtPrecioDeVenta = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblISBN = new javax.swing.JLabel();
        lblPrecioDeCosto = new javax.swing.JLabel();
        lblPrecioDeVenta = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        lblImagen = new javax.swing.JLabel();
        btnSeleccionarPortada = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro Libro");
        getContentPane().setLayout(null);

        jScrollPane2.setViewportView(lstEditoriales);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(50, 140, 89, 113);

        jScrollPane3.setViewportView(lstAutores);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(310, 140, 89, 113);

        lstGeneros.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstGenerosValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(lstGeneros);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(180, 140, 89, 113);

        lblRegistrarLibro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegistrarLibro.setText("Registrar Libro");
        getContentPane().add(lblRegistrarLibro);
        lblRegistrarLibro.setBounds(180, 10, 87, 16);

        lblEditorial.setText("Editorial");
        getContentPane().add(lblEditorial);
        lblEditorial.setBounds(70, 120, 50, 16);

        lblGenero.setText("Genero");
        getContentPane().add(lblGenero);
        lblGenero.setBounds(200, 120, 50, 16);

        lblAutor.setText("Autor");
        getContentPane().add(lblAutor);
        lblAutor.setBounds(340, 120, 40, 16);
        getContentPane().add(txtTitulo);
        txtTitulo.setBounds(60, 40, 71, 22);
        getContentPane().add(txtIsbn);
        txtIsbn.setBounds(200, 40, 71, 22);

        txtPrecioDeCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioDeCostoKeyTyped(evt);
            }
        });
        getContentPane().add(txtPrecioDeCosto);
        txtPrecioDeCosto.setBounds(120, 80, 71, 22);

        txtPrecioDeVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioDeVentaActionPerformed(evt);
            }
        });
        txtPrecioDeVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioDeVentaKeyTyped(evt);
            }
        });
        getContentPane().add(txtPrecioDeVenta);
        txtPrecioDeVenta.setBounds(310, 80, 71, 22);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar);
        btnAgregar.setBounds(170, 420, 100, 23);

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Titulo");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(10, 40, 40, 16);

        lblISBN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblISBN.setText("ISBN");
        getContentPane().add(lblISBN);
        lblISBN.setBounds(150, 40, 30, 16);

        lblPrecioDeCosto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrecioDeCosto.setText("Precio de Costo");
        getContentPane().add(lblPrecioDeCosto);
        lblPrecioDeCosto.setBounds(10, 80, 110, 16);

        lblPrecioDeVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrecioDeVenta.setText("Precio de Venta");
        getContentPane().add(lblPrecioDeVenta);
        lblPrecioDeVenta.setBounds(200, 80, 100, 16);

        jLabel1.setText("Cantidad");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(290, 40, 60, 16);

        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        getContentPane().add(txtCantidad);
        txtCantidad.setBounds(350, 40, 64, 22);

        lblImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagen.setText("Sin Imagen");
        getContentPane().add(lblImagen);
        lblImagen.setBounds(260, 270, 120, 140);

        btnSeleccionarPortada.setText("Seleccionar Portada");
        btnSeleccionarPortada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarPortadaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSeleccionarPortada);
        btnSeleccionarPortada.setBounds(50, 330, 170, 23);

        setBounds(0, 0, 443, 501);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String titulo = this.txtTitulo.getText().trim();
        String isbn = this.txtIsbn.getText().trim();

        String cantidad = this.txtCantidad.getText().trim();
        String precioCosto = this.txtPrecioDeCosto.getText().trim();
        String precioVenta = this.txtPrecioDeVenta.getText().trim();

        if (titulo.length() == 0) {
            JOptionPane.showMessageDialog(this, "El nombre del libro está vacío", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (isbn.length() == 0) {
                JOptionPane.showMessageDialog(this, "El ISBN del libro está vacío", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (this.modelo.getListaLibros().containsKey(isbn)) {
                    JOptionPane.showMessageDialog(this, "El isbn del libro ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (cantidad.length() == 0) {
                        JOptionPane.showMessageDialog(this, "La cantidad está vacía", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (precioCosto.length() == 0) {
                            JOptionPane.showMessageDialog(this, "El precio de costo está vacío", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            if (precioVenta.length() == 0) {
                                JOptionPane.showMessageDialog(this, "El precio de venta está vacío", "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                if (this.lstEditoriales.getSelectedValue() == null) {
                                    JOptionPane.showMessageDialog(this, "No se ha seleccionado una Editorial", "Error", JOptionPane.ERROR_MESSAGE);

                                } else {
                                    if (this.lstGeneros.getSelectedValue() == null) {
                                        JOptionPane.showMessageDialog(this, "No se ha seleccionado un Genero", "Error", JOptionPane.ERROR_MESSAGE);

                                    } else {
                                        if (this.lstAutores.getSelectedValue() == null) {
                                            JOptionPane.showMessageDialog(this, "No se ha seleccionado un Autor", "Error", JOptionPane.ERROR_MESSAGE);

                                        } else {
                                            int cant = Integer.parseInt(cantidad);
                                            int precioCost = Integer.parseInt(precioCosto);
                                            int precioVent = Integer.parseInt(precioVenta);
                                            Editorial ed = (Editorial) this.lstEditoriales.getSelectedValue();
                                            Genero g = (Genero) this.lstGeneros.getSelectedValue();
                                            Autor aut = (Autor) this.lstAutores.getSelectedValue();

                                            if (imagenSeleccionada != null) {
                                                this.modelo.guardarImagen(imagenSeleccionada, isbn);
                                                Libro l = new Libro(ed, g, aut, titulo, isbn, precioCost, precioVent, cant, imagenSeleccionada.getPath());
                                                this.modelo.agregarLibro(l);
                                            } else {
                                                Libro l = new Libro(ed, g, aut, titulo, isbn, precioCost, precioVent, cant, "Sin imagen");
                                                this.modelo.agregarLibro(l);
                                            }
                                            JOptionPane.showMessageDialog(this, "Libro agregado correctamente");

                                        }

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtPrecioDeVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioDeVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioDeVentaActionPerformed

    private void lstGenerosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstGenerosValueChanged
        Genero gen = (Genero) lstGeneros.getSelectedValue();
        this.lstAutores.setListData(this.modelo.getArrayAutores(gen));

    }//GEN-LAST:event_lstGenerosValueChanged

    private void txtPrecioDeCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioDeCostoKeyTyped
        //Obtengo que letra se presiono
        int key = evt.getKeyChar();
        //Indica si el codigo ascii es de un numero
        boolean num = key >= 48 && key <= 57;
        if (!num) {
            //Si no es, no deja que se escriba ese caracter
            evt.consume();
        }
        //Limita el largo de la entrada
        if (txtPrecioDeCosto.getText().trim().length() > 8) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioDeCostoKeyTyped

    private void txtPrecioDeVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioDeVentaKeyTyped
        //Obtengo que letra se presiono
        int key = evt.getKeyChar();
        //Indica si el codigo ascii es de un numero
        boolean num = key >= 48 && key <= 57;
        if (!num) {
            //Si no es, no deja que se escriba ese caracter
            evt.consume();
        }
        //Limita el largo de la entrada
        if (txtPrecioDeVenta.getText().trim().length() > 8) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioDeVentaKeyTyped

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        //Obtengo que letra se presiono
        int key = evt.getKeyChar();
        //Indica si el codigo ascii es de un numero
        boolean num = key >= 48 && key <= 57;
        if (!num) {
            //Si no es, no deja que se escriba ese caracter
            evt.consume();
        }
        //Limita el largo de la entrada
        if (txtCantidad.getText().trim().length() > 8) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void btnSeleccionarPortadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarPortadaActionPerformed
        //Creo una ventana emergente para seleccionar archivos
        JFileChooser fileChooser = new JFileChooser();
        //Hago que solo se puedan seleccionar archivos
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        //Solo permito agregar extensiones de imagenes
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imágenes", "jpg", "png", "jpeg"));

        int resultado = fileChooser.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            //Me quedo con la imagen
            imagenSeleccionada = fileChooser.getSelectedFile();

            ImageIcon imagen = new ImageIcon(imagenSeleccionada.getAbsolutePath());
            Image imagenAEscala = imagen.getImage().getScaledInstance(this.lblImagen.getWidth(), this.lblImagen.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imagenRedimensionada = new ImageIcon(imagenAEscala);
            this.lblImagen.setIcon(imagenRedimensionada);
            this.lblImagen.setText("");

        }
    }//GEN-LAST:event_btnSeleccionarPortadaActionPerformed

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
            java.util.logging.Logger.getLogger(VtnRegistroLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VtnRegistroLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VtnRegistroLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VtnRegistroLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VtnRegistroLibro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnSeleccionarPortada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblEditorial;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblISBN;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblPrecioDeCosto;
    private javax.swing.JLabel lblPrecioDeVenta;
    private javax.swing.JLabel lblRegistrarLibro;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList lstAutores;
    private javax.swing.JList lstEditoriales;
    private javax.swing.JList lstGeneros;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtIsbn;
    private javax.swing.JTextField txtPrecioDeCosto;
    private javax.swing.JTextField txtPrecioDeVenta;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
