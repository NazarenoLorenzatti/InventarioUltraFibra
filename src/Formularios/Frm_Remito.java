package Formularios;

/*
@author Lorenzatti Nazareno
@version 1.0
nl.loragro@gmail.com
 */

import Clases.Cls_Remito;
import Clases.Cls_Tecnico;
import static Formularios.Frm_Principal.contenedor;
import Utilidades.CrearRemitoPDF;
import java.awt.Dimension;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.table.TableColumnModel;

// Formulario para la creacion de Remitos de salida

public class Frm_Remito extends javax.swing.JInternalFrame {

    private final Cls_Remito CP;
    private CrearRemitoPDF crear;
    private Cls_Tecnico tecnico;
    TableColumnModel columnModel;
    public static int enviar = 0;
    private static String nombreArchivoPDF = " - ";

    //Atributos para ocultar la barra de titulos
    private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension dimBarra = null;

    public Frm_Remito() {
        initComponents();
        this.tecnico = new Cls_Tecnico();
        this.CP = new Cls_Remito();
        this.columnModel = jtb_Remito.getColumnModel();
        tecnico.setComboBox();
        jComboBox1.setModel(this.tecnico.setComboBox());
        
        // Seteamos el Date Chose con la fecha actual
        Calendar c2 = new GregorianCalendar(); 
        jdc_fechaDesde.setCalendar(c2);              
        jdc_fechaHasta.setCalendar(c2);

        listar();
        iniciar();
        activar();
    }

    public void ocultarBarraTituloRemito() {
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
        dimBarra = Barra.getPreferredSize();
        Barra.setSize(0, 0);
        Barra.setPreferredSize(new Dimension(0, 0));
        repaint();
    }

    private void listar() {
        Date fechaDesde = jdc_fechaDesde.getDate();
        Date fechaHasta = jdc_fechaHasta.getDate();
        String nombreTecnico = jComboBox1.getSelectedItem().toString();

        
        //convertimos la Fecha que obtengo de tipo Date a tipo Date SQL ya q no son el mismo tipo.        
        long d = fechaDesde.getTime();
        java.sql.Date fecha_sql_desde = new java.sql.Date(d);
        long c = fechaHasta.getTime();
        java.sql.Date fecha_sql_hasta = new java.sql.Date(c);

        jtb_Remito.setModel(CP.getDatosRemito(fecha_sql_desde, fecha_sql_hasta, nombreTecnico));
        columnModel.getColumn(3).setPreferredWidth(350);
    }

    private void iniciar() {
        jdc_fechaDesde.setEnabled(true);
    }

    private void activar() {
        jdc_fechaDesde.setEnabled(true);
    }

    private void limpiar() {
        jtb_Remito.clearSelection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jdc_fechaDesde = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_Remito = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jdc_fechaHasta = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaObservaciones = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jBtnExportar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jBtnBuscarRemito = new javax.swing.JButton();

        setClosable(true);
        setTitle("Salida");
        setPreferredSize(new java.awt.Dimension(1220, 720));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Fecha Desde");

        jdc_fechaDesde.setDateFormatString("dd/MM/yyyy");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("REMITOS");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Abrir Archivo.png"))); // NOI18N
        jButton1.setText("Abrir Pdf");
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Abrir Archivo pressed.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Abrir Archivo Roll.png"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));

        jtb_Remito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtb_Remito);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tecnico 1", "Tecnico 2", " " }));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Tecnico*");

        jdc_fechaHasta.setDateFormatString("dd/MM/yyyy");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Fecha Hasta");

        jTextAreaObservaciones.setColumns(20);
        jTextAreaObservaciones.setRows(5);
        jScrollPane2.setViewportView(jTextAreaObservaciones);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Observaciones");

        jBtnExportar.setBackground(new java.awt.Color(255, 255, 255));
        jBtnExportar.setForeground(new java.awt.Color(0, 0, 0));
        jBtnExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Exportar.png"))); // NOI18N
        jBtnExportar.setText("Exportar");
        jBtnExportar.setBorderPainted(false);
        jBtnExportar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnExportar.setFocusable(false);
        jBtnExportar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Exportar Pressed.png"))); // NOI18N
        jBtnExportar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Exportar Roll.png"))); // NOI18N
        jBtnExportar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnExportarMouseClicked(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Cerrar Rojo.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/cerrar pressed.png"))); // NOI18N
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/cerrar roll.png"))); // NOI18N
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/lupa.png"))); // NOI18N
        jButton4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/pressed.png"))); // NOI18N
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Lupo Roll.png"))); // NOI18N
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jBtnBuscarRemito.setBackground(new java.awt.Color(255, 255, 255));
        jBtnBuscarRemito.setForeground(new java.awt.Color(0, 0, 0));
        jBtnBuscarRemito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Buscar Remito.png"))); // NOI18N
        jBtnBuscarRemito.setText("Buscar Remito");
        jBtnBuscarRemito.setBorderPainted(false);
        jBtnBuscarRemito.setContentAreaFilled(false);
        jBtnBuscarRemito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnBuscarRemito.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnBuscarRemito.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Buscar Remito Pressed.png"))); // NOI18N
        jBtnBuscarRemito.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Buscar Remito Roll.png"))); // NOI18N
        jBtnBuscarRemito.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnBuscarRemito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBuscarRemitoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(jLabel7)))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jBtnExportar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnBuscarRemito, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jdc_fechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdc_fechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(159, 159, 159)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(45, 45, 45)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(173, 173, 173))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(580, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(478, 478, 478)
                        .addComponent(jButton3)))
                .addGap(14, 14, 14))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdc_fechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jdc_fechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel6)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtnExportar)
                        .addGap(37, 37, 37)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jBtnBuscarRemito)
                                .addGap(39, 39, 39))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.crear.abrirArchivo();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        dispose();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        listar();
    }//GEN-LAST:event_jButton4MouseClicked

    private void jBtnExportarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnExportarMouseClicked

        String directorio = null;
        // creamos el objeto JFileChooser
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        //Abrimos la ventana y guardamos la opcion seleccionada
        int seleccion = fc.showOpenDialog(this);

        //Comprueba si se dio en aceptar
        if (seleccion == JFileChooser.APPROVE_OPTION) {

            File fichero = fc.getSelectedFile();
            directorio = fichero.getAbsolutePath();
        }

        LocalDate fecha = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LL yyyy");
        String strFecha = fecha.format(formatter); // le damos el formato y la convertimos a string
        String nombreTecnico = jComboBox1.getSelectedItem().toString();

        this.nombreArchivoPDF = this.nombreArchivoPDF + strFecha;

        this.crear = new CrearRemitoPDF(jtb_Remito, this.nombreArchivoPDF, directorio,nombreTecnico); // Instanciamos la clase para exportar
        String numRem = this.crear.getNumeroRemito(); // obtengo el numero de remito
        this.crear.crearPdf(jtb_Remito, numRem); // Creo el PDF
    }//GEN-LAST:event_jBtnExportarMouseClicked

    private void jBtnBuscarRemitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarRemitoActionPerformed
        Frm_BuscarRemito R = new Frm_BuscarRemito ();
        R.ocultarBarraTituloBuscarRemito();
        Frm_Principal.contenedor.add(R);
        Dimension desktopSize = contenedor.getSize();
        Dimension FrameSize = R.getSize();
        R.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        R.toFront();
        R.setVisible(true); 
    }//GEN-LAST:event_jBtnBuscarRemitoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBuscarRemito;
    private javax.swing.JButton jBtnExportar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    public static javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextArea jTextAreaObservaciones;
    public static com.toedter.calendar.JDateChooser jdc_fechaDesde;
    public static com.toedter.calendar.JDateChooser jdc_fechaHasta;
    private javax.swing.JTable jtb_Remito;
    // End of variables declaration//GEN-END:variables
}
