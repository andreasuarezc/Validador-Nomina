/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servisoft.nomina.vista;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.List;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import com.servisoft.nomina.controlador.ControladorImporteArchivos;

public class ReporteFinal extends javax.swing.JFrame {

    private FondoPanel fondo = new FondoPanel();
    private JFileChooser selecArchivoExcel;
    private ControladorImporteArchivos controlador;
    private List<String> datosCedulasPrenomina, datosNombresPrenomina,
            codigoConcepto, descripcionConcepto, diferencia;
    private List<Integer> tiempoPrenomina, tiempoNovedades;

    public ReporteFinal() {
        this.setContentPane(fondo);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        btnCerrar3 = new javax.swing.JButton();
        btnMinimizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblValidacion = new javax.swing.JLabel();
        btnDescarga3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtReporteFinal = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        lblImportarPrenomina = new javax.swing.JLabel();
        btnInicio = new javax.swing.JButton();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nomina App");
        setUndecorated(true);

        btnCerrar3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCerrar3.setText("X");
        btnCerrar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrar3ActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 556, Short.MAX_VALUE)
                .addComponent(btnMinimizar)
                .addGap(0, 0, 0)
                .addComponent(btnCerrar3))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnCerrar3)
                .addComponent(btnMinimizar)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblValidacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/validación-128.png"))); // NOI18N

        btnDescarga3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDescarga3.setForeground(new java.awt.Color(9, 0, 123));
        btnDescarga3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/descarga-64.png"))); // NOI18N
        btnDescarga3.setText("Descargar Reporte");
        btnDescarga3.setBorder(null);
        btnDescarga3.setBorderPainted(false);
        btnDescarga3.setContentAreaFilled(false);
        btnDescarga3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDescarga3.setMinimumSize(new java.awt.Dimension(117, 117));
        btnDescarga3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/descarga-64.png"))); // NOI18N
        btnDescarga3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/descarga-72.png"))); // NOI18N
        btnDescarga3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnDescarga3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDescarga3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescarga3ActionPerformed(evt);
            }
        });

        jtReporteFinal.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jtReporteFinal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CEDULA", "NOMBRE EMPLEADO", "CONCEPTO", "NOMBRE CONCEPTO", "TIEMPO PRENOMINA", "TIEMPO NOVEDADES", "DIFERENCIA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtReporteFinal.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtReporteFinal);
        if (jtReporteFinal.getColumnModel().getColumnCount() > 0) {
            jtReporteFinal.getColumnModel().getColumn(0).setResizable(false);
            jtReporteFinal.getColumnModel().getColumn(0).setPreferredWidth(50);
            jtReporteFinal.getColumnModel().getColumn(1).setResizable(false);
            jtReporteFinal.getColumnModel().getColumn(1).setPreferredWidth(150);
            jtReporteFinal.getColumnModel().getColumn(2).setResizable(false);
            jtReporteFinal.getColumnModel().getColumn(2).setPreferredWidth(40);
            jtReporteFinal.getColumnModel().getColumn(3).setResizable(false);
            jtReporteFinal.getColumnModel().getColumn(4).setPreferredWidth(50);
            jtReporteFinal.getColumnModel().getColumn(5).setPreferredWidth(50);
            jtReporteFinal.getColumnModel().getColumn(6).setPreferredWidth(40);
        }

        btnSalir.setForeground(new java.awt.Color(9, 0, 123));
        btnSalir.setText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblImportarPrenomina.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblImportarPrenomina.setForeground(new java.awt.Color(9, 0, 123));
        lblImportarPrenomina.setText("Validación");

        btnInicio.setForeground(new java.awt.Color(9, 0, 123));
        btnInicio.setText("Inicio");
        btnInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblValidacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addComponent(lblImportarPrenomina)
                .addGap(160, 160, 160)
                .addComponent(btnDescarga3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblValidacion)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnDescarga3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(lblImportarPrenomina)))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnInicio))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDescarga3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescarga3ActionPerformed
        selecArchivoExcel = new JFileChooser();
        selecArchivoExcel.setFileFilter(new FileNameExtensionFilter("Excel (*.xlsx)", "xlsx"));
        selecArchivoExcel.setDialogTitle("Descargar Archivo");
        selecArchivoExcel.setSelectedFile(new File("C:\\ReporteFinal"));
        if (selecArchivoExcel.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            controlador = new ControladorImporteArchivos();
            String ruta = selecArchivoExcel.getSelectedFile().toString().concat(".xlsx");
            controlador.exportarReporteFinal(ruta, datosCedulasPrenomina,
                    datosNombresPrenomina, codigoConcepto,
                    descripcionConcepto, tiempoPrenomina, tiempoNovedades, diferencia);
            JOptionPane.showMessageDialog(this, "Descarga Exitosa");
        } else {
            JOptionPane.showMessageDialog(null,
                    "El archivo no se ha descargado",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDescarga3ActionPerformed

    private void btnCerrar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrar3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCerrar3ActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        IngresoApp inicio = new IngresoApp();
        inicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnInicioActionPerformed

    public void obtenerDatos(List<String> datosCedulasPrenomina,
            List<String> datosNombresPrenomina,
            List<String> codigoConcepto,
            List<String> descripcionConcepto,
            List<Integer> tiempoPrenomina,
            List<Integer> tiempoNovedades,
            List<String> diferencia) {
        this.datosCedulasPrenomina = datosCedulasPrenomina;
        this.datosNombresPrenomina = datosNombresPrenomina;
        this.codigoConcepto = codigoConcepto;
        this.descripcionConcepto = descripcionConcepto;
        this.tiempoPrenomina = tiempoPrenomina;
        this.tiempoNovedades = tiempoNovedades;
        this.diferencia = diferencia;

        jtReporteFinal.setEnabled(false);

        int cantidad = datosCedulasPrenomina.size();
        for (int i = 0; i < cantidad; i++) {
            Vector datos = new Vector();
            datos.add(datosCedulasPrenomina.get(i));
            datos.add(datosNombresPrenomina.get(i));
            datos.add(codigoConcepto.get(i));
            datos.add(descripcionConcepto.get(i));
            datos.add(tiempoPrenomina.get(i));
            datos.add(tiempoNovedades.get(i));
            datos.add(diferencia.get(i));
            DefaultTableModel dt = (DefaultTableModel) jtReporteFinal.getModel();
            dt.addRow(datos);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar3;
    private javax.swing.JButton btnDescarga3;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtReporteFinal;
    private javax.swing.JLabel lblImportarPrenomina;
    private javax.swing.JLabel lblValidacion;
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
