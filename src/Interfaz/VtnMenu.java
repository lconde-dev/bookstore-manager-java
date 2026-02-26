//Paulina Vazquez - 325917
//Lucas Conde - 340100
package Interfaz;

import Modelo.Sistema;

public class VtnMenu extends javax.swing.JFrame {
    private Sistema modelo;
    
    public VtnMenu() {
        initComponents();
        setLocationRelativeTo(null);
    }
    public VtnMenu(Sistema unModelo) {
        initComponents();
        this.modelo=unModelo;
        setLocationRelativeTo(null);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar = new javax.swing.JMenuBar();
        mnuRegistros = new javax.swing.JMenu();
        itmRegistrarEditorial = new javax.swing.JMenuItem();
        itmRegistrarGenero = new javax.swing.JMenuItem();
        itmRegistrarAutor = new javax.swing.JMenuItem();
        itmRegistrarLibro = new javax.swing.JMenuItem();
        mnuVentas = new javax.swing.JMenu();
        itmRegistroDeVenta = new javax.swing.JMenuItem();
        itmAnularVenta = new javax.swing.JMenuItem();
        mnuConsultas = new javax.swing.JMenu();
        itmConsultaDeLibros = new javax.swing.JMenuItem();
        itmConsultaDeVentas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion de Librerias - Realizado por: Paulina Vazquez 325917 - Lucas Conde 340100");
        getContentPane().setLayout(null);

        mnuRegistros.setMnemonic('f');
        mnuRegistros.setText("Registros");

        itmRegistrarEditorial.setMnemonic('s');
        itmRegistrarEditorial.setText("Registrar Editorial");
        itmRegistrarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmRegistrarEditorialActionPerformed(evt);
            }
        });
        mnuRegistros.add(itmRegistrarEditorial);

        itmRegistrarGenero.setMnemonic('a');
        itmRegistrarGenero.setText("Registrar Genero");
        itmRegistrarGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmRegistrarGeneroActionPerformed(evt);
            }
        });
        mnuRegistros.add(itmRegistrarGenero);

        itmRegistrarAutor.setMnemonic('x');
        itmRegistrarAutor.setText("Registrar Autor");
        itmRegistrarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmRegistrarAutorActionPerformed(evt);
            }
        });
        mnuRegistros.add(itmRegistrarAutor);

        itmRegistrarLibro.setText("Registrar Libro");
        itmRegistrarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmRegistrarLibroActionPerformed(evt);
            }
        });
        mnuRegistros.add(itmRegistrarLibro);

        menuBar.add(mnuRegistros);

        mnuVentas.setMnemonic('e');
        mnuVentas.setText("Ventas");

        itmRegistroDeVenta.setMnemonic('t');
        itmRegistroDeVenta.setText("Registro de venta");
        itmRegistroDeVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmRegistroDeVentaActionPerformed(evt);
            }
        });
        mnuVentas.add(itmRegistroDeVenta);

        itmAnularVenta.setMnemonic('y');
        itmAnularVenta.setText("Anular venta");
        itmAnularVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmAnularVentaActionPerformed(evt);
            }
        });
        mnuVentas.add(itmAnularVenta);

        menuBar.add(mnuVentas);

        mnuConsultas.setMnemonic('h');
        mnuConsultas.setText("Consultas");

        itmConsultaDeLibros.setMnemonic('c');
        itmConsultaDeLibros.setText("Consulta de Libros");
        itmConsultaDeLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmConsultaDeLibrosActionPerformed(evt);
            }
        });
        mnuConsultas.add(itmConsultaDeLibros);

        itmConsultaDeVentas.setMnemonic('a');
        itmConsultaDeVentas.setText("Consulta de ventas");
        itmConsultaDeVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmConsultaDeVentasActionPerformed(evt);
            }
        });
        mnuConsultas.add(itmConsultaDeVentas);

        menuBar.add(mnuConsultas);

        setJMenuBar(menuBar);

        setBounds(0, 0, 414, 309);
    }// </editor-fold>//GEN-END:initComponents

    private void itmRegistrarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmRegistrarAutorActionPerformed
        VtnRegistroAutor vtnRegAut = new VtnRegistroAutor(modelo);
        vtnRegAut.setVisible(true);
    }//GEN-LAST:event_itmRegistrarAutorActionPerformed

    private void itmRegistrarGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmRegistrarGeneroActionPerformed
        VtnRegistroGenero vtnRegGen = new VtnRegistroGenero(modelo);
        vtnRegGen.setVisible(true);
    }//GEN-LAST:event_itmRegistrarGeneroActionPerformed
  
    private void itmRegistroDeVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmRegistroDeVentaActionPerformed
        VtnRegistroDeVenta vtnRegVen = new VtnRegistroDeVenta(modelo);
        vtnRegVen.setVisible(true);
    }//GEN-LAST:event_itmRegistroDeVentaActionPerformed

    private void itmConsultaDeVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmConsultaDeVentasActionPerformed
        VtnConsultaDeVentas vtnConVent = new VtnConsultaDeVentas(modelo);
        vtnConVent.setVisible(true);
    }//GEN-LAST:event_itmConsultaDeVentasActionPerformed

    private void itmRegistrarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmRegistrarEditorialActionPerformed
        VtnRegistroEditorial vtnRegEd = new VtnRegistroEditorial(modelo);
        vtnRegEd.setVisible(true);
    }//GEN-LAST:event_itmRegistrarEditorialActionPerformed

    private void itmRegistrarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmRegistrarLibroActionPerformed
        VtnRegistroLibro vtnRegLib = new VtnRegistroLibro(modelo);
        vtnRegLib.setVisible(true);
    }//GEN-LAST:event_itmRegistrarLibroActionPerformed

    private void itmAnularVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmAnularVentaActionPerformed
        VtnAnularVenta vtnAnulVen = new VtnAnularVenta(modelo);
        vtnAnulVen.setVisible(true);
    }//GEN-LAST:event_itmAnularVentaActionPerformed

    private void itmConsultaDeLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmConsultaDeLibrosActionPerformed
        VtnConsultaDeLibros vtnConLib = new VtnConsultaDeLibros(modelo);
        vtnConLib.setVisible(true);
    }//GEN-LAST:event_itmConsultaDeLibrosActionPerformed

    
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
            java.util.logging.Logger.getLogger(VtnMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VtnMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VtnMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VtnMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VtnMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itmAnularVenta;
    private javax.swing.JMenuItem itmConsultaDeLibros;
    private javax.swing.JMenuItem itmConsultaDeVentas;
    private javax.swing.JMenuItem itmRegistrarAutor;
    private javax.swing.JMenuItem itmRegistrarEditorial;
    private javax.swing.JMenuItem itmRegistrarGenero;
    private javax.swing.JMenuItem itmRegistrarLibro;
    private javax.swing.JMenuItem itmRegistroDeVenta;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu mnuConsultas;
    private javax.swing.JMenu mnuRegistros;
    private javax.swing.JMenu mnuVentas;
    // End of variables declaration//GEN-END:variables

}
