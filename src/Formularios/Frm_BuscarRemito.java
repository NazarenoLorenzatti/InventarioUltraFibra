package Formularios;

/*
@author Lorenzatti Nazareno
@version 1.0
nl.loragro@gmail.com
 */
import Clases.Cls_Remito;
import Clases.Cls_Tecnico;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.io.File;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

// formulario para buscar Remitos por fecha y tecnico o por numero de remito.
public class Frm_BuscarRemito extends javax.swing.JInternalFrame {

    private final Cls_Remito CP;
    private final Cls_Tecnico tecnico;
    private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension dimBarra = null;
    private String nroRemito;

    public Frm_BuscarRemito() {
        initComponents();
        this.CP = new Cls_Remito();
        this.tecnico = new Cls_Tecnico();
        tecnico.setComboBox();
        jComboBox1.setModel(this.tecnico.setComboBox());
        CP.visualizarDatosPDF(tabla);

        if (jRbnFechayTecnico.isSelected()) {
            jTxtNroRemito.setEnabled(false);
            jTxtNroRemito.setBackground(new java.awt.Color(215, 219, 219));
            jdc_fechaDesde.setEnabled(true);
            jdc_fechaHasta.setEnabled(true);
            jComboBox1.setEnabled(true);
        } else {
            jTxtNroRemito.setEnabled(true);
            jTxtNroRemito.setBackground(Color.white);
            jdc_fechaDesde.setEnabled(false);
            jdc_fechaHasta.setEnabled(false);
            jComboBox1.setEnabled(false);
        }
    }

    public void ocultarBarraTituloBuscarRemito() {
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
        dimBarra = Barra.getPreferredSize();
        Barra.setSize(0, 0);
        Barra.setPreferredSize(new Dimension(0, 0));
        repaint();
    }

    // Listar por rango de fechas y tecnico
    private void listar() {
        Date fechaDesde = jdc_fechaDesde.getDate();
        Date fechaHasta = jdc_fechaHasta.getDate();
        String nombreTecnico = jComboBox1.getSelectedItem().toString();

        //convertimos la Fecha que obtengo de tipo Date a tipo Date SQL ya q no son el mismo tipo.        
        long d = fechaDesde.getTime();
        java.sql.Date fecha_sql_desde = new java.sql.Date(d);
        long c = fechaHasta.getTime();
        java.sql.Date fecha_sql_hasta = new java.sql.Date(c);

//        tabla.setModel(CP.visualizarDatosPDF(fecha_sql_desde, fecha_sql_hasta, nombreTecnico, tabla));
        CP.visualizarDatosPDF(fecha_sql_desde, fecha_sql_hasta, nombreTecnico, tabla);
    }

    // Listar por numero de remito
    private void listarPorNro() {

        String nroRemito = jTxtNroRemito.getText();
        CP.visualizarDatosPDF(nroRemito, tabla);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg_busqueda = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jdc_fechaDesde = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jdc_fechaHasta = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jRbnNroRemito = new javax.swing.JRadioButton();
        jRbnFechayTecnico = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jTxtNroRemito = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setTitle("Lista de Productos");

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));

        jdc_fechaDesde.setDateFormatString("dd/MM/yyyy");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha Desde");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Fecha Hasta");

        jdc_fechaHasta.setDateFormatString("dd/MM/yyyy");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tecnico 1", "Tecnico 2", " " }));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tecnico*");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdc_fechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdc_fechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdc_fechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdc_fechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tabla.setFont(tabla.getFont());
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        bg_busqueda.add(jRbnNroRemito);
        jRbnNroRemito.setText("Nro de remito");
        jRbnNroRemito.setContentAreaFilled(false);
        jRbnNroRemito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRbnNroRemito.setFocusPainted(false);
        jRbnNroRemito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/nroRemito.png"))); // NOI18N
        jRbnNroRemito.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/nroRemito Roll.png"))); // NOI18N
        jRbnNroRemito.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/nroRemito pressed.png"))); // NOI18N
        jRbnNroRemito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRbnNroRemitoActionPerformed(evt);
            }
        });

        bg_busqueda.add(jRbnFechayTecnico);
        jRbnFechayTecnico.setSelected(true);
        jRbnFechayTecnico.setText("Fecha y Tecnico");
        jRbnFechayTecnico.setContentAreaFilled(false);
        jRbnFechayTecnico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRbnFechayTecnico.setFocusPainted(false);
        jRbnFechayTecnico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/calendario.png"))); // NOI18N
        jRbnFechayTecnico.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/nroRemito Roll.png"))); // NOI18N
        jRbnFechayTecnico.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/calendario pressed.png"))); // NOI18N
        jRbnFechayTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRbnFechayTecnicoActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jTxtNroRemito.setForeground(new java.awt.Color(0, 0, 0));
        jTxtNroRemito.setCaretColor(new java.awt.Color(255, 255, 255));
        jTxtNroRemito.setDisabledTextColor(new java.awt.Color(153, 153, 153));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Numero de remito");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jTxtNroRemito, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jTxtNroRemito, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/lupa.png"))); // NOI18N
        jButton4.setText("Buscar");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/pressed.png"))); // NOI18N
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Lupo Roll.png"))); // NOI18N
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Cerrar Rojo.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/cerrar pressed.png"))); // NOI18N
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/cerrar roll.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("BUSCAR REMITOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jRbnFechayTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jRbnNroRemito, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(174, 174, 174))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(314, 314, 314)
                .addComponent(jButton3)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRbnFechayTecnico, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jRbnNroRemito, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRbnFechayTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRbnFechayTecnicoActionPerformed
        jTxtNroRemito.setEnabled(false);
        jTxtNroRemito.setBackground(new java.awt.Color(215, 219, 219));
        jdc_fechaDesde.setEnabled(true);
        jdc_fechaHasta.setEnabled(true);
        jComboBox1.setEnabled(true);
    }//GEN-LAST:event_jRbnFechayTecnicoActionPerformed

    private void jRbnNroRemitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRbnNroRemitoActionPerformed
        jTxtNroRemito.setEnabled(true);
        jTxtNroRemito.setBackground(Color.white);
        jdc_fechaDesde.setEnabled(false);
        jdc_fechaHasta.setEnabled(false);
        jComboBox1.setEnabled(false);
    }//GEN-LAST:event_jRbnNroRemitoActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        if (jRbnFechayTecnico.isSelected()) {
            listar();
        } else {
            listarPorNro();
        }
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        
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
        
        int column = tabla.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tabla.getRowHeight();
        if (row < tabla.getRowCount() && row >= 0 && column < tabla.getColumnCount() && column >= 0) {
            this.nroRemito = (String) tabla.getValueAt(row, 0);
            Object value = tabla.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;

                if (boton.getText().equals("Vacio")) {
                    JOptionPane.showMessageDialog(null, "No hay archivo");
                } else {
                    try {
                        Cls_Remito pd = new Cls_Remito();
                        pd.ejecutar_archivoPDF(directorio, this.nroRemito);
                        try {
                            Desktop.getDesktop().open(new File(directorio+System.getProperty("file.separator")+this.nroRemito+".pdf"));
                        } catch (Exception ex) {
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Frm_BuscarRemito.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            } else {
                String name = "" + tabla.getValueAt(row, 1);                
            }
        }
    }//GEN-LAST:event_tablaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bg_busqueda;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    public static javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRbnFechayTecnico;
    private javax.swing.JRadioButton jRbnNroRemito;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTxtNroRemito;
    public static com.toedter.calendar.JDateChooser jdc_fechaDesde;
    public static com.toedter.calendar.JDateChooser jdc_fechaHasta;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
