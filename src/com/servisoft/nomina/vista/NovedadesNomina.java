package com.servisoft.nomina.vista;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import com.servisoft.nomina.modelo.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXML;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NovedadesNomina extends javax.swing.JFrame {

    private FondoPanel fondo = new FondoPanel();
    private Conexion conexion = new Conexion();

    public NovedadesNomina() {
        this.setContentPane(fondo);
        initComponents();
        this.setLocationRelativeTo(null);
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnNuevo.setEnabled(false);
        conexion.establecerConexion();
        mostrarDatos();
        conexion.cerrarConexion();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        btnMinimizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConceptosNovedades = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lblDescripcionConcepto = new javax.swing.JLabel();
        lblSigla = new javax.swing.JLabel();
        lblSignificado = new javax.swing.JLabel();
        txtDescripcionConcepto = new javax.swing.JTextField();
        txtSigla = new javax.swing.JTextField();
        txtSignificado = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        lblCodigo1 = new javax.swing.JLabel();
        cmbCodigo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(800, 500));

        btnCerrar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCerrar.setText("X");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnMinimizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnMinimizar.setText("_");
        btnMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(9, 0, 123));
        jLabel1.setText("Validador Novedades");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMinimizar)
                .addGap(0, 0, 0)
                .addComponent(btnCerrar))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnCerrar)
                .addComponent(btnMinimizar)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jSplitPane1.setDividerLocation(280);
        jSplitPane1.setResizeWeight(0.5);
        jSplitPane1.setPreferredSize(new java.awt.Dimension(754, 300));

        tblConceptosNovedades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblConceptosNovedades.getTableHeader().setReorderingAllowed(false);
        tblConceptosNovedades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblConceptosNovedadesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblConceptosNovedades);

        jSplitPane1.setRightComponent(jScrollPane1);

        jPanel4.setPreferredSize(new java.awt.Dimension(310, 300));

        lblDescripcionConcepto.setForeground(new java.awt.Color(9, 0, 123));
        lblDescripcionConcepto.setText("Descripción Concepto");

        lblSigla.setForeground(new java.awt.Color(9, 0, 123));
        lblSigla.setText("Sigla");

        lblSignificado.setForeground(new java.awt.Color(9, 0, 123));
        lblSignificado.setText("Significado");

        txtDescripcionConcepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionConceptoActionPerformed(evt);
            }
        });

        txtSignificado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSignificadoActionPerformed(evt);
            }
        });

        btnGuardar.setForeground(new java.awt.Color(9, 0, 123));
        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnActualizar.setForeground(new java.awt.Color(9, 0, 123));
        btnActualizar.setText("Actualizar");
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setForeground(new java.awt.Color(9, 0, 123));
        btnEliminar.setText("Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAtras.setForeground(new java.awt.Color(9, 0, 123));
        btnAtras.setText("Atrás");
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnNuevo.setForeground(new java.awt.Color(9, 0, 123));
        btnNuevo.setText("Nuevo");
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        lblCodigo1.setForeground(new java.awt.Color(9, 0, 123));
        lblCodigo1.setText("código");

        cmbCodigo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "001", "031", "015", "052", "036", "016", "017", "067", "033" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescripcionConcepto)
                            .addComponent(lblSigla)
                            .addComponent(lblSignificado))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblCodigo1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevo)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnActualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar))
                            .addComponent(txtDescripcionConcepto, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSigla, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSignificado)
                            .addComponent(btnAtras, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 38, Short.MAX_VALUE))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addGap(20, 20, 20)
                .addComponent(lblCodigo1)
                .addGap(5, 5, 5)
                .addComponent(cmbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lblDescripcionConcepto)
                .addGap(5, 5, 5)
                .addComponent(txtDescripcionConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lblSigla)
                .addGap(5, 5, 5)
                .addComponent(txtSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lblSignificado)
                .addGap(5, 5, 5)
                .addComponent(txtSignificado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(btnAtras)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(jPanel4);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        IngresoApp atras = new IngresoApp();
        atras.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed
    public void mostrarDatos() {
        String[] titulos = {"Id", "Código", "Descripción Concepto", "Sigla", "Sgnificado"};
        String[] registros = new String[6];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                return false;
            }
        };

        String SQL = "SELECT * FROM tbl_novedades_nomina";
        conexion.establecerConexion();
        try {
            Statement instruccion = conexion.getConexion().createStatement();
            ResultSet resultado = instruccion.executeQuery(SQL);

            while (resultado.next()) {
                registros[0] = resultado.getString("id");
                registros[1] = resultado.getString("codigo_concepto");
                registros[2] = resultado.getString("descripcion_concepto");
                registros[3] = resultado.getString("sigla");
                registros[4] = resultado.getString("significado");

                modelo.addRow(registros);
            }
            tblConceptosNovedades.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al mostrar Datos" + e.getMessage());
        }
        conexion.cerrarConexion();
    }

    @FXML

    public void actualizarDatos() {
        conexion.establecerConexion();
        try {
            String SQL = "UPDATE tbl_novedades_nomina SET codigo_concepto = ?, descripcion_concepto = ?, sigla = ?, significado = ? WHERE id = ?";
            PreparedStatement instruccion = conexion.getConexion().prepareStatement(SQL);
            int filaSaleccionada = tblConceptosNovedades.getSelectedRow();
            String dao = (String) tblConceptosNovedades.getValueAt(filaSaleccionada, 0);

            instruccion.setString(1, cmbCodigo.getSelectedItem().toString());
            instruccion.setString(2, txtDescripcionConcepto.getText());
            instruccion.setString(3, txtSigla.getText());
            instruccion.setString(4, txtSignificado.getText());
            instruccion.setInt(5, Integer.valueOf(dao));

            instruccion.execute();

            JOptionPane.showMessageDialog(this, "Registro actualizado exitosamente");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar Registro" + e.getMessage());
        }
        conexion.cerrarConexion();
    }

    public void eliminarRegistro() {
        int filaSeleccionada = tblConceptosNovedades.getSelectedRow();
        try {
            conexion.establecerConexion();
            String SQL = "DELETE FROM tbl_novedades_nomina WHERE id =" + tblConceptosNovedades.getValueAt(filaSeleccionada, 0);
            Statement instruccion = conexion.getConexion().createStatement();
            int n = instruccion.executeUpdate(SQL);
            if (n >= 0) {

            }
            JOptionPane.showMessageDialog(this, "Registro eliminado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar Registro" + e.getMessage());
        }

        conexion.cerrarConexion();
    }

    public void limpiarComponentes() {;
        cmbCodigo.setSelectedIndex(0);
        txtDescripcionConcepto.setText(null);
        txtSigla.setText(null);
        txtSignificado.setText(null);

        btnGuardar.setEnabled(true);
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnNuevo.setEnabled(false);
    }

    public void guardarRegistro() {
        conexion.establecerConexion();
        try {
            PreparedStatement instruccion = conexion.getConexion().prepareStatement("INSERT INTO tbl_novedades_nomina"
                    + "(codigo_concepto,descripcion_concepto,sigla,significado)"
                    + " VALUES (?,?,?,?)");
            instruccion.setString(1, cmbCodigo.getSelectedItem().toString());
            instruccion.setString(2, txtDescripcionConcepto.getText());
            instruccion.setString(3, txtSigla.getText());
            instruccion.setString(4, txtSignificado.getText());

            instruccion.executeUpdate();

            JOptionPane.showMessageDialog(this, "Registro guardado Exitosamente");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al gusradra Registro" + e.getMessage());
        }
        conexion.cerrarConexion();
    }
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizarDatos();
        limpiarComponentes();
        mostrarDatos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardarRegistro();
        limpiarComponentes();
        mostrarDatos();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(this, "Desea eliminar este concepto?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION) {
            eliminarRegistro();
            limpiarComponentes();
            mostrarDatos();
        } else {
            mostrarDatos();
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtDescripcionConceptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionConceptoActionPerformed

    }//GEN-LAST:event_txtDescripcionConceptoActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarComponentes();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtSignificadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSignificadoActionPerformed

    }//GEN-LAST:event_txtSignificadoActionPerformed

    private void tblConceptosNovedadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblConceptosNovedadesMouseClicked
        int filaSeleccionada = tblConceptosNovedades.rowAtPoint(evt.getPoint());

        cmbCodigo.setSelectedItem(tblConceptosNovedades.getValueAt(filaSeleccionada, 1).toString());
        txtDescripcionConcepto.setText(tblConceptosNovedades.getValueAt(filaSeleccionada, 2).toString());
        txtSigla.setText(tblConceptosNovedades.getValueAt(filaSeleccionada, 3).toString());
        txtSignificado.setText(tblConceptosNovedades.getValueAt(filaSeleccionada, 4).toString());

        btnActualizar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnNuevo.setEnabled(true);
        btnGuardar.setEnabled(false);

    }//GEN-LAST:event_tblConceptosNovedadesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cmbCodigo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lblCodigo1;
    private javax.swing.JLabel lblDescripcionConcepto;
    private javax.swing.JLabel lblSigla;
    private javax.swing.JLabel lblSignificado;
    private javax.swing.JTable tblConceptosNovedades;
    private javax.swing.JTextField txtDescripcionConcepto;
    private javax.swing.JTextField txtSigla;
    private javax.swing.JTextField txtSignificado;
    // End of variables declaration//GEN-END:variables
     class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/imagenes/background.jpg")).getImage();

            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);

            super.paint(g);
        }
    }
}
