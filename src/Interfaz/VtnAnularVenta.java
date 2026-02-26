//Paulina Vazquez - 325917
//Lucas Conde - 340100
package Interfaz;

import Modelo.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VtnAnularVenta extends javax.swing.JFrame implements Observer {

    private Sistema modelo;
    private int numVentaAAnular;

    public VtnAnularVenta() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public VtnAnularVenta(Sistema unModelo) {
        this.modelo = unModelo;
        this.modelo.addObserver(this);
        this.numVentaAAnular = 0;
        initComponents();
        setLocationRelativeTo(null);
    }

    public void update(Observable o, Object obj) {
        this.numVentaAAnular=0;
        this.txtNumFactura.setText("");
        vaciarTablaVenta();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNumDeFactura = new javax.swing.JLabel();
        txtNumFactura = new javax.swing.JTextField();
        btnAnular = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetalleFactura = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Anular Venta");
        getContentPane().setLayout(null);

        lblNumDeFactura.setText("Numero de factura");
        getContentPane().add(lblNumDeFactura);
        lblNumDeFactura.setBounds(20, 20, 110, 16);

        txtNumFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumFacturaActionPerformed(evt);
            }
        });
        txtNumFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumFacturaKeyTyped(evt);
            }
        });
        getContentPane().add(txtNumFactura);
        txtNumFactura.setBounds(140, 20, 64, 22);

        btnAnular.setText("Anular");
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnular);
        btnAnular.setBounds(300, 260, 75, 23);

        tblDetalleFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "Nombre", "Cantidad", "Precio"
            }
        ));
        jScrollPane2.setViewportView(tblDetalleFactura);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 90, 360, 150);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(220, 20, 75, 23);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Detalle de la Factura:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(120, 60, 170, 16);

        setBounds(0, 0, 414, 335);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumFacturaActionPerformed
        
    }//GEN-LAST:event_txtNumFacturaActionPerformed

    private void txtNumFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumFacturaKeyTyped
        //Obtengo que letra se presiono
        int key = evt.getKeyChar();
        //Indica si el codigo ascii es de un numero
        boolean num = key >= 48 && key <= 57;
        if (!num) {
            //Si no es, no deja que se escriba ese caracter
            evt.consume();
        }
        //Limita el largo de la entrada
        if (txtNumFactura.getText().trim().length() > 8) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNumFacturaKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        int numFact = Integer.parseInt(this.txtNumFactura.getText().trim());

        if (this.modelo.getListaVentas().containsKey(numFact)) {
            this.numVentaAAnular = numFact;

            cargarTablaVenta(this.modelo.getListaVentas().get(numFact));

        } else {
            vaciarTablaVenta();
            JOptionPane.showMessageDialog(this, "La factura que busca no existe", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        if (this.numVentaAAnular > 0) {
            this.modelo.anularVenta(this.numVentaAAnular);
            JOptionPane.showMessageDialog(this, "Venta anulada correctamente");
            
        } else {
            JOptionPane.showMessageDialog(this, "No ha seleccionado factura para anular", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAnularActionPerformed

    private void vaciarTablaVenta() {
        DefaultTableModel mdl = (DefaultTableModel) this.tblDetalleFactura.getModel();
        mdl.setRowCount(0); //Limpio antes de cargar

    }

    private void cargarTablaVenta(Venta v) {
        DefaultTableModel mdl = (DefaultTableModel) this.tblDetalleFactura.getModel();
        mdl.setRowCount(0); //Limpio antes de cargar
        for (Libro l : v.getLibrosSeleccionados().keySet()) {
            int ejemplaresComprados = v.getLibrosSeleccionados().get(l).getCantidad();
            mdl.addRow(new Object[]{l.getIsbn(), l.getTitulo(), ejemplaresComprados, l.getPrecioDeVenta()});
        }
    }

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
            java.util.logging.Logger.getLogger(VtnAnularVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VtnAnularVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VtnAnularVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VtnAnularVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VtnAnularVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNumDeFactura;
    private javax.swing.JTable tblDetalleFactura;
    private javax.swing.JTextField txtNumFactura;
    // End of variables declaration//GEN-END:variables
}
