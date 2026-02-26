//Paulina Vazquez - 325917
//Lucas Conde - 340100
package Interfaz;

import Modelo.*;
import java.util.*;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class VtnRegistroAutor extends javax.swing.JFrame implements Observer {

    private Sistema modelo;
    private ArrayList<Genero> generosSeleccionados;

    public VtnRegistroAutor() {
        initComponents();
    }

    public VtnRegistroAutor(Sistema unModelo) {
        this.modelo = unModelo;
        this.modelo.addObserver(this);
        this.generosSeleccionados = new ArrayList<Genero>();
        initComponents();
        update(null, null);
        setLocationRelativeTo(null);

    }

    public void update(Observable o, Object obj) {
        this.lstAutores.setListData(this.modelo.getArrayAutores(null));
        this.txtNombre.setText("");
        this.txtNacionalidad.setText("");
        this.lstGeneros.setListData(this.modelo.getArrayGeneros());
        this.generosSeleccionados = new ArrayList<Genero>();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblNacionalidad = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstAutores = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstGeneros = new javax.swing.JList();
        btnAgregar = new javax.swing.JButton();
        lblGeneros = new javax.swing.JLabel();
        lblAutores = new javax.swing.JLabel();
        txtNacionalidad = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstGenerosSeleccionados = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        btnDeseleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro Autor");
        getContentPane().setLayout(null);

        lblTitulo.setText("Registrar Autor");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(160, 20, 90, 16);

        lblNombre.setText("Nombre");
        getContentPane().add(lblNombre);
        lblNombre.setBounds(40, 50, 60, 20);

        lblNacionalidad.setText("Nacionalidad");
        getContentPane().add(lblNacionalidad);
        lblNacionalidad.setBounds(210, 50, 110, 20);
        getContentPane().add(txtNombre);
        txtNombre.setBounds(100, 50, 70, 20);

        jScrollPane1.setViewportView(lstAutores);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(90, 250, 230, 60);

        lstGeneros.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstGenerosValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstGeneros);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(50, 110, 90, 70);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar);
        btnAgregar.setBounds(150, 200, 100, 23);

        lblGeneros.setText("Generos Disponibles");
        getContentPane().add(lblGeneros);
        lblGeneros.setBounds(40, 90, 150, 16);

        lblAutores.setText("Autores ingresados");
        getContentPane().add(lblAutores);
        lblAutores.setBounds(140, 230, 120, 16);
        getContentPane().add(txtNacionalidad);
        txtNacionalidad.setBounds(300, 50, 70, 20);

        jScrollPane3.setViewportView(lstGenerosSeleccionados);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(260, 110, 90, 70);

        jLabel1.setText("Generos Seleccionados");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(240, 90, 150, 16);

        btnSeleccionar.setText("->");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSeleccionar);
        btnSeleccionar.setBounds(170, 120, 60, 23);

        btnDeseleccionar.setText("<-");
        btnDeseleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeseleccionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeseleccionar);
        btnDeseleccionar.setBounds(170, 150, 60, 23);

        setBounds(0, 0, 414, 356);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String nombreAutor = this.txtNombre.getText().trim();
        String nacionalidad = this.txtNacionalidad.getText();

        if (nombreAutor.length() == 0) {
            JOptionPane.showMessageDialog(this, "El nombre del autor está vacío", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (nacionalidad.length() == 0) {
                JOptionPane.showMessageDialog(this, "La nacionalidad está vacía", "Error", JOptionPane.ERROR_MESSAGE);

            } else {
                if (this.modelo.existeAutor(nombreAutor)) {
                    JOptionPane.showMessageDialog(this, "El autor ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (this.generosSeleccionados.size() == 0) {
                        JOptionPane.showMessageDialog(this, "No se ha seleccionado ningun genero", "Error", JOptionPane.ERROR_MESSAGE);

                    } else {
                        Autor autor = new Autor(nombreAutor, nacionalidad, generosSeleccionados);
                        this.modelo.agregarAutor(autor);
                        JOptionPane.showMessageDialog(this, "Autor agregado correctamente");

                    }
                }
            }


    }//GEN-LAST:event_btnAgregarActionPerformed
    }
    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        Genero g = (Genero) lstGeneros.getSelectedValue();
        if (g == null) {
            JOptionPane.showMessageDialog(this, "No hay ningun genero seleccionado", "Error", JOptionPane.ERROR_MESSAGE);

        } else {
            if (this.generosSeleccionados.contains(g)) {
                JOptionPane.showMessageDialog(this, "El autor ya existe", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                this.generosSeleccionados.add(g);
                Genero[] arrayGen = new Genero[this.generosSeleccionados.size()];
                arrayGen = this.generosSeleccionados.toArray(arrayGen);

                this.lstGenerosSeleccionados.setListData(arrayGen);
            }

        }

    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnDeseleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeseleccionarActionPerformed
        Genero g = (Genero) lstGenerosSeleccionados.getSelectedValue();
        if (g == null) {
            JOptionPane.showMessageDialog(this, "No hay ningun genero seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            this.generosSeleccionados.remove(g);
            Genero[] arrayGen = new Genero[this.generosSeleccionados.size()];
            arrayGen = this.generosSeleccionados.toArray(arrayGen);

            this.lstGenerosSeleccionados.setListData(arrayGen);
        }

    }//GEN-LAST:event_btnDeseleccionarActionPerformed

    private void lstGenerosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstGenerosValueChanged

    }//GEN-LAST:event_lstGenerosValueChanged

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VtnRegistroAutor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnDeseleccionar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAutores;
    private javax.swing.JLabel lblGeneros;
    private javax.swing.JLabel lblNacionalidad;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList lstAutores;
    private javax.swing.JList lstGeneros;
    private javax.swing.JList lstGenerosSeleccionados;
    private javax.swing.JTextField txtNacionalidad;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
