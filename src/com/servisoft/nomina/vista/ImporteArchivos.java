package com.servisoft.nomina.vista;

import com.servisoft.nomina.controlador.ControladorImporteArchivos;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImporteArchivos extends javax.swing.JFrame {

    private ControladorImporteArchivos controlador;
    private JFileChooser selecArchivoExcel;
    private Map<Integer, List<String>> prenomina, novedades;
    private List<String> cedulasPrenomina, cedulasNovedades, 
            nombreEmpleadoPrenomina, nombreEmpleadoNovedades, 
            datosCedulasPrenomina, datosNombresPrenomina,
            codigoConcepto, descripcionConcepto, diferencia;
    private List<Integer> posicionCedulaPrenomina, posicionCedulaNovedades, 
            tiempoPrenomina, tiempoNovedades;
    private Alerta alerta;
    ReporteFinal reporteFinal;
    FondoPanel fondo = new FondoPanel();

    public ImporteArchivos() {

        this.setContentPane(fondo);
        selecArchivoExcel = new JFileChooser();
        selecArchivoExcel.setFileFilter(new FileNameExtensionFilter("Excel (*.xlsx)", "xlsx"));
        initComponents();
        this.setLocationRelativeTo(null);
        controlador = new ControladorImporteArchivos();
        reporteFinal = new ReporteFinal();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnImportarNovedades = new javax.swing.JButton();
        btnImportarPrenomina = new javax.swing.JButton();
        txtArchivoNovedades = new javax.swing.JTextField();
        lblImportarNovedades = new javax.swing.JLabel();
        txtArchivoPrenomina = new javax.swing.JTextField();
        lblImportarPrenomina = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nomina App");
        setUndecorated(true);

        btnCerrar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCerrar.setText("X");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(9, 0, 123));
        jLabel1.setText("Validador Novedades");

        btnMinimizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnMinimizar.setText("_");
        btnMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 554, Short.MAX_VALUE)
                .addComponent(btnMinimizar)
                .addGap(0, 0, 0)
                .addComponent(btnCerrar))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnCerrar)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnMinimizar))
        );

        jPanel2.setBackground(new java.awt.Color(230, 230, 230));

        btnImportarNovedades.setForeground(new java.awt.Color(9, 0, 123));
        btnImportarNovedades.setText("Examinar");
        btnImportarNovedades.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImportarNovedades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarNovedadesActionPerformed(evt);
            }
        });

        btnImportarPrenomina.setForeground(new java.awt.Color(9, 0, 123));
        btnImportarPrenomina.setText("Examinar");
        btnImportarPrenomina.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImportarPrenomina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarPrenominaActionPerformed(evt);
            }
        });

        txtArchivoNovedades.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtArchivoNovedades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArchivoNovedadesActionPerformed(evt);
            }
        });

        lblImportarNovedades.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblImportarNovedades.setForeground(new java.awt.Color(9, 0, 123));
        lblImportarNovedades.setText("Importar Archivo Novedades");

        txtArchivoPrenomina.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtArchivoPrenomina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArchivoPrenominaActionPerformed(evt);
            }
        });

        lblImportarPrenomina.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblImportarPrenomina.setForeground(new java.awt.Color(9, 0, 123));
        lblImportarPrenomina.setText("Importar Archivo Prenomina");

        btnAtras.setForeground(new java.awt.Color(9, 0, 123));
        btnAtras.setText("Atrás");
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnSiguiente.setForeground(new java.awt.Color(9, 0, 123));
        btnSiguiente.setText("Siguiente");
        btnSiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblImportarPrenomina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtArchivoPrenomina)
                            .addComponent(lblImportarNovedades, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtArchivoNovedades, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAtras)
                        .addGap(257, 257, 257)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnImportarNovedades, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnImportarPrenomina, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(60, 60, 60))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(lblImportarPrenomina)
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtArchivoPrenomina, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImportarPrenomina))
                .addGap(20, 20, 20)
                .addComponent(lblImportarNovedades)
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtArchivoNovedades, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImportarNovedades))
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSiguiente)
                    .addComponent(btnAtras))
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtArchivoNovedadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArchivoNovedadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtArchivoNovedadesActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizarActionPerformed

    private void btnImportarPrenominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarPrenominaActionPerformed
        if (selecArchivoExcel.showDialog(null, "Seleccionar Archivo") == JFileChooser.APPROVE_OPTION) {
            File archivo = selecArchivoExcel.getSelectedFile();
            if (archivo.getName().endsWith("xlsx")) {
                boolean exito = controlador.importarPrenomina(archivo);
                txtArchivoPrenomina.setText(archivo.getName());
                if (!exito) {
                    JOptionPane.showMessageDialog(this, "El archivo no pudo ser leido");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Elija un formato Valido.");
            }
        }
    }//GEN-LAST:event_btnImportarPrenominaActionPerformed

    private void btnImportarNovedadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarNovedadesActionPerformed
        if (selecArchivoExcel.showDialog(null, "Seleccionar Archivo") == JFileChooser.APPROVE_OPTION) {
            File archivo = selecArchivoExcel.getSelectedFile();
            if (archivo.getName().endsWith("xlsx")) {
                boolean exito = controlador.importarNovedades(archivo);
                txtArchivoNovedades.setText(archivo.getName());
                if (!exito) {
                    JOptionPane.showMessageDialog(this, "El archivo no pudo ser leido");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Elija un formato Valido.");
            }
        }
    }//GEN-LAST:event_btnImportarNovedadesActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        prenomina = controlador.getPrenomina();
        novedades = controlador.getNovedades();
        if ((prenomina.get(2) != null) && (novedades.get(1) != null)) {
            controlador.validarFormatoPrenomina(prenomina);
            controlador.validarFormatoNovedades(novedades);
            if ((controlador.getFormatoPrenomina() == true) && (controlador.getFormatoNovedades() == true)) {

                controlador.validarCedulas(prenomina, novedades);
                if (controlador.getValidacionCedulas() == true) {
                    controlador.obtenerDatosPrenomina(prenomina);
                    datosCedulasPrenomina = controlador.getDatosCedulasPrenomina();
                    datosNombresPrenomina = controlador.getDatosNombresPrenomina();
                    codigoConcepto = controlador.getCodigoConcepto();
                    descripcionConcepto = controlador.getDescripcionConcepto();
                    tiempoPrenomina = controlador.getTiempoPrenomina();
                    controlador.obtenerDatosNovedades(novedades, datosCedulasPrenomina, codigoConcepto, tiempoPrenomina);
                    tiempoNovedades = controlador.getTiempoNovedades();
                    diferencia = controlador.getDiferencia();
                    if (datosCedulasPrenomina.size() == datosNombresPrenomina.size()
                            && datosCedulasPrenomina.size() == codigoConcepto.size()
                            && datosCedulasPrenomina.size() == descripcionConcepto.size()
                            && datosCedulasPrenomina.size() == tiempoPrenomina.size()) {
                        reporteFinal.obtenerDatos(datosCedulasPrenomina,
                                datosNombresPrenomina, codigoConcepto,
                                descripcionConcepto, tiempoPrenomina, tiempoNovedades, diferencia);
                        JOptionPane.showMessageDialog(this, "Archivos Importados con Éxito");
                        reporteFinal.setVisible(true);
                        this.dispose();
                    }

                } else {
                    alerta = new Alerta();
                    cedulasPrenomina = controlador.getCedulasPrenomina();
                    cedulasNovedades = controlador.getCedulasNovedades();
                    nombreEmpleadoPrenomina = controlador.getNombreEmpleadoPrenomina();
                    nombreEmpleadoNovedades = controlador.getNombreEmpleadoNovedades();
                    posicionCedulaPrenomina = controlador.getPosicionCedulaPrenomina();
                    posicionCedulaNovedades = controlador.getPosicionCedulaNovedades();
                    alerta.exponerdatos(cedulasPrenomina, cedulasNovedades,
                            nombreEmpleadoPrenomina, nombreEmpleadoNovedades,
                            posicionCedulaPrenomina, posicionCedulaNovedades, prenomina, novedades);
                    JOptionPane.showMessageDialog(this, "Alerta, los archivos importados presentan diferencias en los registros");
                    alerta.setVisible(true);
                    this.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error");
                Error btnSalir = new Error();
                btnSalir.setVisible(true);
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error");
            Error btnSalir = new Error();
            btnSalir.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void txtArchivoPrenominaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArchivoPrenominaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtArchivoPrenominaActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        IngresoApp validarNovedades = new IngresoApp();
        validarNovedades.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnImportarNovedades;
    private javax.swing.JButton btnImportarPrenomina;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblImportarNovedades;
    private javax.swing.JLabel lblImportarPrenomina;
    private javax.swing.JTextField txtArchivoNovedades;
    private javax.swing.JTextField txtArchivoPrenomina;
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
