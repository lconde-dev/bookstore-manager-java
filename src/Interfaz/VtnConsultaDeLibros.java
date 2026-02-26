//Paulina Vazquez - 325917
//Lucas Conde - 340100
package Interfaz;

import Modelo.Libro;
import Modelo.Sistema;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class VtnConsultaDeLibros extends javax.swing.JFrame implements Observer{

    private Sistema modelo;
    private JPanel panelLibros;

    public VtnConsultaDeLibros() {
        initComponents();
        setLocationRelativeTo(null);
        panelLibros = new JPanel();
        panelLibros.setLayout(new GridLayout(0, 3, 5, 5));
        panelLibros.setBounds(60, 100, 400, 200);
        getContentPane().add(panelLibros); 
    }

    public VtnConsultaDeLibros(Sistema unModelo) {
        this();
        this.modelo = unModelo;
        this.modelo.addObserver(this);
        update(null,null);   
    }
    @Override
    public void update(Observable o, Object arg) {
        panelLibros.removeAll();
        panelLibros.setLayout(new GridLayout(0, 3, 5, 5));
        for (Libro libro : modelo.getListaLibros().values()) {
            JButton nuevo = new JButton();
            if (!libro.getTapaPath().equals("Sin imagen")) {
                ImageIcon icon = new ImageIcon(libro.getTapa());
                Image image = icon.getImage();
                Image resizedImage = image.getScaledInstance(128, 95, Image.SCALE_SMOOTH);
                nuevo.setIcon(new ImageIcon(resizedImage));
            } else {
                nuevo.setText(libro.getTitulo());
            }
            nuevo.addActionListener(new LibroListener(libro));
            panelLibros.add(nuevo);
        }
        panelLibros.revalidate();
        panelLibros.repaint();
    }
    
    public void MostrarLibros(){
            java.util.List<Libro> resultados = new java.util.ArrayList<>();
            for (Libro libro : modelo.getListaLibros().values()) {
                resultados.add(libro);
            }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTitulo = new javax.swing.JTextField();
        txtAutor = new javax.swing.JTextField();
        txtGenero = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        lblGenero = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblAutor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Libros");
        getContentPane().setLayout(null);
        getContentPane().add(txtTitulo);
        txtTitulo.setBounds(220, 50, 64, 22);
        getContentPane().add(txtAutor);
        txtAutor.setBounds(360, 50, 64, 22);

        txtGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGeneroActionPerformed(evt);
            }
        });
        getContentPane().add(txtGenero);
        txtGenero.setBounds(90, 50, 64, 22);

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(btnConsultar);
        btnConsultar.setBounds(380, 330, 100, 23);

        lblGenero.setText("Genero");
        getContentPane().add(lblGenero);
        lblGenero.setBounds(90, 30, 70, 16);

        lblTitulo.setText("Titulo");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(220, 30, 60, 16);

        lblAutor.setText("Autor");
        getContentPane().add(lblAutor);
        lblAutor.setBounds(360, 30, 37, 16);

        setBounds(0, 0, 532, 397);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        String genero = txtGenero.getText().trim();
        String titulo = txtTitulo.getText().trim();
        String autor = txtAutor.getText().trim();

        // Verificar que al menos un campo tenga datos
        if (genero.isEmpty() && titulo.isEmpty() && autor.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese al menos un criterio de búsqueda.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Filtrar resultados
            java.util.List<Libro> resultados = this.modelo.filtrarResultados(genero, titulo, autor);
            
            // Actualizar el panel con los resultados
            panelLibros.removeAll();
            panelLibros.setLayout(new GridLayout(0, 3, 5, 5));  // Ajustar a una grilla de 3 columnas
            for (Libro libro : resultados) {
                JButton nuevo = new JButton();
                if (!libro.getTapaPath().equals("Sin imagen")) {
                    ImageIcon icon = new ImageIcon(libro.getTapa());
                    Image image = icon.getImage();
                    Image resizedImage = image.getScaledInstance(128, 95, Image.SCALE_SMOOTH); // Ajusta el tamaño
                    nuevo.setIcon(new ImageIcon(resizedImage));
                } else {
                    nuevo.setText(libro.getTitulo());
                }
                nuevo.addActionListener(new LibroListener(libro));
                panelLibros.add(nuevo);
            }

            panelLibros.revalidate();
            panelLibros.repaint();

            // Limpiar campos de texto
            txtGenero.setText("");
            txtTitulo.setText("");
            txtAutor.setText("");
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void txtGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGeneroActionPerformed

    public static void main(String args[]) {
        Sistema modelo = new Sistema();  // Crear el modelo y cargar datos
        new VtnConsultaDeLibros(modelo).setVisible(true);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VtnConsultaDeLibros().setVisible(true);
            }
        });
    }

    private class LibroListener implements ActionListener {

        private Libro libro;

        public LibroListener(Libro libro) {
            this.libro = libro;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Mostrar información del libro en un cuadro de diálogo
            JOptionPane.showMessageDialog(
                    VtnConsultaDeLibros.this,
                    "Título: " + libro.getTitulo() + "\n"
                    + "Editorial: " + libro.getEditorial().getNombre() + "\n"        
                    + "Autor: " + libro.getAutor().getNombre() + "\n"
                    + "Género: " + libro.getGenero().getNombre() + "\n"
                    + "ISBN: " + libro.getIsbn() + "\n"
                    + "Precio de costo: " + libro.getPrecioDeCosto() + "\n"
                    + "Precio de venta: " + libro.getPrecioDeVenta(),
                    "Información del Libro",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
