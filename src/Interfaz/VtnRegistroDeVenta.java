//Paulina Vazquez - 325917
//Lucas Conde - 340100

package Interfaz;

import Modelo.*;
import java.util.*;
import javax.swing.JOptionPane;

public class VtnRegistroDeVenta extends javax.swing.JFrame implements Observer {

    private Sistema modelo;
    private Venta venta;

    public VtnRegistroDeVenta() {
        initComponents();

    }

    public VtnRegistroDeVenta(Sistema unModelo) {
        this.modelo = unModelo;
        this.modelo.addObserver(this);
        this.venta = new Venta();
        this.venta.addObserver(this);
        initComponents();
        setLocationRelativeTo(null);
        update(null, null);

    }

    public void update(Observable o, Object obj) {
        this.lblNumFactura.setText(this.modelo.getNumFactura() + "");
        this.lstLibros.setListData(this.modelo.getArrayLibros());
        this.lblPrecioTotal.setText(this.venta.getPrecioVentaTotal() + "");
        this.lstVenta.setListData(this.venta.getListaVenta());
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFactura = new javax.swing.JLabel();
        lblNumFactura = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblLibros = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        lblCliente = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        lblVenta = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstLibros = new javax.swing.JList();
        lblTotal = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnDeseleccionar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstVenta = new javax.swing.JList();
        btnSeleccionar = new javax.swing.JButton();
        txtFecha = new javax.swing.JTextField();
        lblPrecioTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Venta");
        getContentPane().setLayout(null);

        lblFactura.setText("Factura:");
        getContentPane().add(lblFactura);
        lblFactura.setBounds(10, 20, 50, 16);

        lblNumFactura.setText(".");
        getContentPane().add(lblNumFactura);
        lblNumFactura.setBounds(70, 20, 100, 16);

        lblFecha.setText("Fecha");
        getContentPane().add(lblFecha);
        lblFecha.setBounds(10, 50, 50, 16);

        lblLibros.setText("Libros");
        getContentPane().add(lblLibros);
        lblLibros.setBounds(10, 100, 50, 16);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar);
        btnRegistrar.setBounds(150, 260, 100, 23);

        lblCliente.setText("Cliente");
        getContentPane().add(lblCliente);
        lblCliente.setBounds(410, 40, 50, 40);

        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });
        getContentPane().add(txtCliente);
        txtCliente.setBounds(470, 50, 200, 20);

        lblVenta.setText("Venta");
        getContentPane().add(lblVenta);
        lblVenta.setBounds(410, 96, 50, 20);

        lstLibros.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstLibros);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 120, 280, 110);

        lblTotal.setText("Total: $");
        getContentPane().add(lblTotal);
        lblTotal.setBounds(410, 240, 50, 16);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(490, 260, 90, 23);

        btnDeseleccionar.setText("<-");
        btnDeseleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeseleccionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeseleccionar);
        btnDeseleccionar.setBounds(310, 190, 80, 30);

        jScrollPane3.setViewportView(lstVenta);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(410, 120, 280, 110);

        btnSeleccionar.setText("->");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSeleccionar);
        btnSeleccionar.setBounds(310, 140, 80, 30);

        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });
        getContentPane().add(txtFecha);
        txtFecha.setBounds(50, 50, 200, 20);

        lblPrecioTotal.setText(".");
        getContentPane().add(lblPrecioTotal);
        lblPrecioTotal.setBounds(460, 240, 80, 16);

        setBounds(0, 0, 715, 339);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        if (this.venta.getLibrosSeleccionados().size() == 0) {
            JOptionPane.showMessageDialog(this, "No hay ningun libro seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String fecha = this.txtFecha.getText();

            if (fecha.length() == 0) {
                JOptionPane.showMessageDialog(this, "No se ha ingresado la fecha", "Error", JOptionPane.ERROR_MESSAGE);

            } else {
                String cliente = this.txtCliente.getText();

                if (cliente.length() > 0) {
                    this.venta.setNombreCliente(cliente);
                }
                this.venta.setFecha(fecha);
                this.venta.setNumFactura(this.modelo.getNumFactura());

                this.modelo.agregarVenta(this.venta);
                this.venta = new Venta();
                JOptionPane.showMessageDialog(this, "Compra realizada correctamente");

            }

        }
        this.txtFecha.setText("");
        this.txtCliente.setText("");
        update(null, null);

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.venta = new Venta();
        update(null, null);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnDeseleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeseleccionarActionPerformed
        LineaDeVenta ldv = (LineaDeVenta) lstVenta.getSelectedValue();
        Libro l = ldv.getLib();
        if (l == null) {
            JOptionPane.showMessageDialog(this, "No hay ningun libro seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (this.venta.getLibrosSeleccionados().get(l).getCantidad() == 1) {
                this.venta.getLibrosSeleccionados().remove(l);
            } else {
                int cant = this.venta.getLibrosSeleccionados().get(l).getCantidad();
                this.venta.getLibrosSeleccionados().get(l).setCantidad(cant - 1);
            }
            this.venta.calcularPreciosTotales();
            update(null, null);
        }
    }//GEN-LAST:event_btnDeseleccionarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        Libro l = (Libro) lstLibros.getSelectedValue();

        if (l == null) {
            JOptionPane.showMessageDialog(this, "No hay ningun libro seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (this.venta.getLibrosSeleccionados().containsKey(l)) {
                int cant = this.venta.getLibrosSeleccionados().get(l).getCantidad();
                if (cant < l.getCantidadEjemplares()) {
                    this.venta.getLibrosSeleccionados().get(l).setCantidad(cant + 1);

                } else {
                    JOptionPane.showMessageDialog(this, "No hay stock del libro seleccionado " + l.getTitulo(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                LineaDeVenta ldv = new LineaDeVenta(l, 1);
                this.venta.getLibrosSeleccionados().put(l, ldv);
            }
            this.venta.calcularPreciosTotales();
            update(null, null);
        }

    }//GEN-LAST:event_btnSeleccionarActionPerformed


    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VtnRegistroDeVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDeseleccionar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblFactura;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblLibros;
    private javax.swing.JLabel lblNumFactura;
    private javax.swing.JLabel lblPrecioTotal;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblVenta;
    private javax.swing.JList lstLibros;
    private javax.swing.JList lstVenta;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}
