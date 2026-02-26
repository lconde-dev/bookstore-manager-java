//Paulina Vazquez - 325917
//Lucas Conde - 340100
package Interfaz;

import Modelo.*;
import java.awt.Color;
import java.awt.Dimension;
import java.util.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class VtnConsultaDeVentas extends javax.swing.JFrame implements Observer {

    private Sistema modelo;
    private boolean listaVisible;
    private JList lstLibros;
    private JScrollPane scrollPane;

    public VtnConsultaDeVentas() {
        initComponents();

    }

    public VtnConsultaDeVentas(Sistema unModelo) {
        this.modelo = unModelo;
        this.modelo.addObserver(this);
        initComponents();
        lstLibros = null;
        scrollPane = null;
        this.listaVisible = false;

        setLocationRelativeTo(null);
        setSize(710, 400);
        update(null, null);

    }

    public void update(Observable o, Object obj) {
        this.lblTitulo.setText("");
        this.lblTitulo.setForeground(Color.BLUE);
        this.lblTotGan.setText("");
        this.lblTotGan.setForeground(Color.BLUE);
        this.lblTotRecaud.setText("");
        this.lblTotRecaud.setForeground(Color.BLUE);
        this.lblEjVendidos.setText("");
        this.lblEjVendidos.setForeground(Color.BLUE);

        DefaultListModel<Libro> listModel = new DefaultListModel<>();
        for (Libro libro : modelo.getListaLibros().values()) {
            listModel.addElement(libro);
        }

        if (lstLibros != null) {
            lstLibros.setModel(listModel);
            jLayeredPane1.revalidate();
            jLayeredPane1.repaint();
        }

        DefaultTableModel mdl = (DefaultTableModel) this.tblVentas.getModel();
        mdl.setRowCount(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        txtIsbn = new javax.swing.JTextField();
        btnConsultar1 = new javax.swing.JButton();
        btnAyudaIsbn = new javax.swing.JButton();
        lblIsbn = new javax.swing.JLabel();
        btnExportar1 = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        lblEjemplares = new javax.swing.JLabel();
        lblEjVendidos = new javax.swing.JLabel();
        lblTotGan = new javax.swing.JLabel();
        lblTotRecaud = new javax.swing.JLabel();
        lblGanancia = new javax.swing.JLabel();
        lblRecaudado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Ventas");
        getContentPane().setLayout(null);

        jLayeredPane1.add(txtIsbn);
        txtIsbn.setBounds(60, 30, 110, 22);

        btnConsultar1.setText("Consultar");
        btnConsultar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultar1ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnConsultar1);
        btnConsultar1.setBounds(290, 30, 110, 23);

        btnAyudaIsbn.setText("jButton1");
        btnAyudaIsbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaIsbnActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnAyudaIsbn);
        btnAyudaIsbn.setBounds(180, 30, 40, 20);

        lblIsbn.setText("Isbn");
        jLayeredPane1.add(lblIsbn);
        lblIsbn.setBounds(20, 30, 50, 16);

        btnExportar1.setText("Exportar");
        btnExportar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportar1ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnExportar1);
        btnExportar1.setBounds(460, 30, 120, 23);

        lblTitulo.setText("-");
        jLayeredPane1.add(lblTitulo);
        lblTitulo.setBounds(20, 70, 280, 16);

        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Cliente", "Factura", "Cantidad", "Precio", "Importe"
            }
        ));
        jScrollPane2.setViewportView(tblVentas);

        jLayeredPane1.add(jScrollPane2);
        jScrollPane2.setBounds(20, 100, 660, 200);

        lblEjemplares.setText("Ejemplares vendidos");
        jLayeredPane1.add(lblEjemplares);
        lblEjemplares.setBounds(50, 310, 130, 16);

        lblEjVendidos.setText("-");
        jLayeredPane1.add(lblEjVendidos);
        lblEjVendidos.setBounds(90, 330, 37, 16);

        lblTotGan.setText("-");
        jLayeredPane1.add(lblTotGan);
        lblTotGan.setBounds(610, 330, 37, 16);

        lblTotRecaud.setText("-");
        jLayeredPane1.add(lblTotRecaud);
        lblTotRecaud.setBounds(340, 330, 37, 16);

        lblGanancia.setText("Total ganancia");
        jLayeredPane1.add(lblGanancia);
        lblGanancia.setBounds(570, 310, 90, 16);

        lblRecaudado.setText("Total recaudado");
        jLayeredPane1.add(lblRecaudado);
        lblRecaudado.setBounds(300, 310, 110, 16);

        getContentPane().add(jLayeredPane1);
        jLayeredPane1.setBounds(0, 0, 690, 410);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAyudaIsbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaIsbnActionPerformed
        if (listaVisible) { // Eliminar la JList si es visible 
            jLayeredPane1.remove(scrollPane);
            lstLibros = null;
            scrollPane = null;
            listaVisible = false;

        } else { // Crear y mostrar la JList si no es visible
            DefaultListModel<Libro> listModel = new DefaultListModel<>();

            for (Libro l : this.modelo.getListaLibros().values()) {
                listModel.addElement(l);
            }

            lstLibros = new JList<>(listModel);
            lstLibros.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent evt) {
                    lstLibrosValueChanged(evt);
                }
            });
            scrollPane = new JScrollPane(lstLibros);
            scrollPane.setBounds(460, 30, 220, 320);
            jLayeredPane1.add(scrollPane, JLayeredPane.PALETTE_LAYER);
            listaVisible = true;
        }
        jLayeredPane1.revalidate();
        jLayeredPane1.repaint();
    }//GEN-LAST:event_btnAyudaIsbnActionPerformed

    private void btnConsultar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultar1ActionPerformed

        String isbn = this.txtIsbn.getText().trim();
        
        if (this.modelo.getListaLibros().containsKey(isbn)) {
            Libro l = this.modelo.getListaLibros().get(isbn);
            this.lblTitulo.setText(l.getTitulo());

            cargarDatosLibros(l);
        } else {
            if (isbn.length() == 0) {
                JOptionPane.showMessageDialog(this, "No ha ingresado ningun ISBN", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo encontrar ningun libro con el ISBN indicado", "Error", JOptionPane.ERROR_MESSAGE);
            }
            vaciarTablaLibros();

        }

    }//GEN-LAST:event_btnConsultar1ActionPerformed

    private void btnExportar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportar1ActionPerformed
        String isbn = this.txtIsbn.getText().trim();
        if (this.modelo.getListaLibros().containsKey(isbn)) {
            Libro l = this.modelo.getListaLibros().get(isbn);
            this.modelo.exportarDatos(l);
            JOptionPane.showMessageDialog(this, "Datos guardados correctamente");

        } else {
            if (isbn.length() == 0) {
                JOptionPane.showMessageDialog(this, "No ha ingresado ningun ISBN", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo encontrar ningun libro con el ISBN indicado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnExportar1ActionPerformed

    private void cargarDatosLibros(Libro l) {
        DefaultTableModel mdl = (DefaultTableModel) this.tblVentas.getModel();
        mdl.setRowCount(0);
        Venta[] ventasDelLibro = this.modelo.obtenerVentasLibro(l);
        int ejemplaresVendidos = 0;
        int totalRecaudado = 0;
        int totalGanacia = 0;
        for (Venta v : ventasDelLibro) {
            mdl.addRow(new Object[]{v.getFecha(), v.getNombreCliente(), v.getNumFactura(), v.getLibrosSeleccionados().get(l).getCantidad(), l.getPrecioDeVenta(), v.getLibrosSeleccionados().get(l).getCantidad() * l.getPrecioDeVenta()});
            ejemplaresVendidos += v.getLibrosSeleccionados().get(l).getCantidad();
            totalRecaudado += l.getPrecioDeVenta() * v.getLibrosSeleccionados().get(l).getCantidad();
            totalGanacia += (totalRecaudado - l.getPrecioDeCosto() * v.getLibrosSeleccionados().get(l).getCantidad());
        }
        this.lblEjVendidos.setText(ejemplaresVendidos + "");
        this.lblTotRecaud.setText(totalRecaudado + "");
        this.lblTotGan.setText(totalGanacia + "");

    }

    private void vaciarTablaLibros() {
        DefaultTableModel mdl = (DefaultTableModel) this.tblVentas.getModel();
        mdl.setRowCount(0); //Limpio antes de cargar
    }

    private void lstLibrosValueChanged(javax.swing.event.ListSelectionEvent evt) {
        this.txtIsbn.setText(lstLibros.getSelectedValue().toString().split(" - ")[0]);
        jLayeredPane1.remove(scrollPane);
        lstLibros = null;
        scrollPane = null;
        listaVisible = false;
        jLayeredPane1.revalidate();
        jLayeredPane1.repaint();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VtnConsultaDeVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAyudaIsbn;
    private javax.swing.JButton btnConsultar1;
    private javax.swing.JButton btnExportar1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEjVendidos;
    private javax.swing.JLabel lblEjemplares;
    private javax.swing.JLabel lblGanancia;
    private javax.swing.JLabel lblIsbn;
    private javax.swing.JLabel lblRecaudado;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotGan;
    private javax.swing.JLabel lblTotRecaud;
    private javax.swing.JTable tblVentas;
    private javax.swing.JTextField txtIsbn;
    // End of variables declaration//GEN-END:variables
}
