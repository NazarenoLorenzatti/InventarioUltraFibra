package Formularios;

/*
@author Lorenzatti Nazareno
@version 1.0
nl.loragro@gmail.com
 */
import Clases.Cls_ComentarioEntrada;
import Clases.Cls_Entrada;
import static Formularios.Frm_Principal.contenedor;
import Utilidades.CrearPDF;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.File;
import static java.lang.Integer.parseInt;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JComponent;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

// Formulario para registrar las entradas de productos
public class Frm_Entrada extends javax.swing.JInternalFrame {

    private static String nombreArchivoPDF = "Entradas - ";
    private CrearPDF crear;
    private Cls_ComentarioEntrada CE;

    private final Cls_Entrada CP;
    public static int enviar = 0;
    private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension dimBarra = null;

    public Frm_Entrada() {
        initComponents();
        this.CP = new Cls_Entrada();
        listar();
        iniciar();
        activar();
        txt_codigo.requestFocus();
      
        this.CE = new Cls_ComentarioEntrada();
        this.CE.setComboBox();
        jComboBoxComentarios.setModel(this.CE.setComboBox());

        Calendar c2 = new GregorianCalendar();
        jdc_fecha.setCalendar(c2); // seteamos el Date Chose con la fecha actual

    }

    public void ocultarBarraTituloEntrada() {
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
        dimBarra = Barra.getPreferredSize();
        Barra.setSize(0, 0);
        Barra.setPreferredSize(new Dimension(0, 0));
        repaint();
    }

    private void listar() {
        jtb_entrada.setModel(CP.getDatosEntradas());
    }

    private void iniciar() {
        txt_codigo.setEnabled(true);
        jbt_buscar.setEnabled(false);
        jbt_guardar.setEnabled(false);
    }

    private void activar() {

        jbt_buscar.setEnabled(true);
        jbt_guardar.setEnabled(true);
        jbt_guardar.setEnabled(true);
        txt_codigo.setEnabled(true);
        txt_codigo.requestFocus();
    }

    private void limpiar() {

        txt_codigo.setText("");
        txt_descripcion.setText("");
        txt_codigo.requestFocus();
    }

    private void guardar() {

        String codigo = txt_codigo.getText();

        String strCantidad = jTxtCantidad.getText();
        int cantidad = 1;

        if (strCantidad.equals("") || strCantidad.equals(" ")) {
            if (jRadioButton1.isSelected()) {
                cantidad = 1;
            }
            if (jRadioButton2.isSelected()) {
                cantidad = 10;
            }
            if (jRadioButton3.isSelected()) {
                cantidad = 100;
            }
        } else {
            cantidad = parseInt(jTxtCantidad.getText());
        }

        Date fechaa = jdc_fecha.getDate();
        long d = fechaa.getTime();
        java.sql.Date fecha_sql = new java.sql.Date(d);

        String comentario = (String) jComboBoxComentarios.getSelectedItem();
        int respuesta = CP.registrarEntrada(codigo, cantidad, Frm_Principal.jLblUsuario.getText(), fecha_sql, comentario);
        if (respuesta > 0) {
            listar();
            limpiar();
        }

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RaBtnGrupo1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_descripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_entrada = new javax.swing.JTable();
        jbt_buscar = new javax.swing.JButton();
        jbt_guardar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jTxtCantidad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jBtnExportar = new javax.swing.JButton();
        jdc_fecha = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jBtnAbrirPdf = new javax.swing.JButton();
        jComboBoxComentarios = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jBtnAgregarComentario = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 51, 102));
        setClosable(true);
        setTitle("Entrada");
        setPreferredSize(new java.awt.Dimension(1220, 720));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 640));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Código del Producto *");

        txt_descripcion.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Descripción del Producto *");

        jtb_entrada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtb_entrada);

        jbt_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/lupa.png"))); // NOI18N
        jbt_buscar.setBorderPainted(false);
        jbt_buscar.setContentAreaFilled(false);
        jbt_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbt_buscar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/pressed.png"))); // NOI18N
        jbt_buscar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Lupo Roll.png"))); // NOI18N
        jbt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_buscarActionPerformed(evt);
            }
        });

        jbt_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Registrar Entrada.png"))); // NOI18N
        jbt_guardar.setText("Registrar Entrada");
        jbt_guardar.setBorderPainted(false);
        jbt_guardar.setContentAreaFilled(false);
        jbt_guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbt_guardar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Registrar entrada Pressed.png"))); // NOI18N
        jbt_guardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Registrar Entrada Roll.png"))); // NOI18N
        jbt_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbt_guardarMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Entrada de Productos");

        jLabel7.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel7.setText("Llene la información respectiva para la entrada de los productos.");

        txt_codigo.setEditable(true);
        txt_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_codigoKeyTyped(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));

        RaBtnGrupo1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        jRadioButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.black));
        jRadioButton2.setContentAreaFilled(false);
        jRadioButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/x10.png"))); // NOI18N
        jRadioButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/x10 roll.png"))); // NOI18N
        jRadioButton2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/x10 check.png"))); // NOI18N

        RaBtnGrupo1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        jRadioButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.black));
        jRadioButton3.setContentAreaFilled(false);
        jRadioButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/x100.png"))); // NOI18N
        jRadioButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/x100 roll.png"))); // NOI18N
        jRadioButton3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/x100 check.png"))); // NOI18N

        RaBtnGrupo1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        jRadioButton1.setSelected(true);
        jRadioButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.black));
        jRadioButton1.setContentAreaFilled(false);
        jRadioButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/x1.png"))); // NOI18N
        jRadioButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/x1 Roll.png"))); // NOI18N
        jRadioButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/x1 Check.png"))); // NOI18N

        jTxtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtCantidadKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingrese cantidad");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(jRadioButton1)
                .addGap(158, 158, 158)
                .addComponent(jRadioButton2)
                .addGap(184, 184, 184)
                .addComponent(jRadioButton3)
                .addGap(91, 91, 91)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jTxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jBtnExportar.setBackground(new java.awt.Color(255, 255, 255));
        jBtnExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Exportar.png"))); // NOI18N
        jBtnExportar.setText("Exportar");
        jBtnExportar.setBorderPainted(false);
        jBtnExportar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnExportar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Exportar Pressed.png"))); // NOI18N
        jBtnExportar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Exportar Roll.png"))); // NOI18N
        jBtnExportar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnExportarMouseClicked(evt);
            }
        });

        jdc_fecha.setDateFormatString("dd/MM/yyyy");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Fecha");

        jBtnAbrirPdf.setBackground(new java.awt.Color(255, 255, 255));
        jBtnAbrirPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Abrir Archivo.png"))); // NOI18N
        jBtnAbrirPdf.setText("Abrir PDF");
        jBtnAbrirPdf.setBorderPainted(false);
        jBtnAbrirPdf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnAbrirPdf.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Abrir Archivo pressed.png"))); // NOI18N
        jBtnAbrirPdf.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Abrir Archivo Roll.png"))); // NOI18N
        jBtnAbrirPdf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnAbrirPdfMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Comentario");

        jBtnAgregarComentario.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jBtnAgregarComentario.setForeground(new java.awt.Color(0, 0, 0));
        jBtnAgregarComentario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Agregar Comentario.png"))); // NOI18N
        jBtnAgregarComentario.setText("Nuevo Comentario");
        jBtnAgregarComentario.setBorderPainted(false);
        jBtnAgregarComentario.setContentAreaFilled(false);
        jBtnAgregarComentario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnAgregarComentario.setFocusPainted(false);
        jBtnAgregarComentario.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Agregar comentario pressed.png"))); // NOI18N
        jBtnAgregarComentario.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Agregar Comentario Roll.png"))); // NOI18N
        jBtnAgregarComentario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnAgregarComentarioMouseClicked(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Eliminar comentario.png"))); // NOI18N
        jButton1.setText("Eliminar Comentario");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setDefaultCapable(false);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Eliminar comentario Pressed.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Eliminar comentario Roll.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jbt_guardar)
                .addGap(145, 145, 145)
                .addComponent(jBtnExportar)
                .addGap(155, 155, 155)
                .addComponent(jBtnAbrirPdf)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel6))
                    .addComponent(jLabel7))
                .addGap(143, 143, 143)
                .addComponent(jBtnAgregarComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton1)
                .addGap(105, 105, 105))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdc_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(28, 28, 28)
                        .addComponent(jbt_buscar)
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(91, 91, 91))
                            .addComponent(jComboBoxComentarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jBtnAgregarComentario, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)))
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdc_fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_codigo)
                            .addComponent(txt_descripcion)
                            .addComponent(jComboBoxComentarios)))
                    .addComponent(jbt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbt_guardar)
                    .addComponent(jBtnExportar)
                    .addComponent(jBtnAbrirPdf))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1208, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAbrirPdfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnAbrirPdfMouseClicked
        this.crear.abrirArchivo();
    }//GEN-LAST:event_jBtnAbrirPdfMouseClicked

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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String strFecha = fecha.format(formatter); // le damos el formato y la convertimos a string

        // Mandamos todo como argumento a la clase correspondiente para crear el archivo
        this.nombreArchivoPDF = this.nombreArchivoPDF + strFecha;
        this.crear = new CrearPDF(jtb_entrada, this.nombreArchivoPDF, directorio);
        crear.crearPdf(jtb_entrada);

    }//GEN-LAST:event_jBtnExportarMouseClicked

    private void txt_codigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoKeyTyped
        char cTeclaPresionada = evt.getKeyChar();
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            txt_descripcion.setText(CP.seleccionDescripcion(txt_codigo.getText()));
            guardar();
        }
    }//GEN-LAST:event_txt_codigoKeyTyped

    private void jbt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_buscarActionPerformed
        enviar = 1;
        Frm_BuscarProductos C = new Frm_BuscarProductos();
        Frm_Principal.contenedor.add(C);
        Dimension desktopSize = contenedor.getSize();
        Dimension FrameSize = C.getSize();
        C.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        C.toFront();
        C.setVisible(true);
    }//GEN-LAST:event_jbt_buscarActionPerformed

    private void jbt_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbt_guardarMouseClicked

        String cod = txt_codigo.getText();

        if (cod.equals("") || cod.equals(" ")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el codigo y la fecha para registrar una entrada de producto");
        } else {
            guardar();
        }

    }//GEN-LAST:event_jbt_guardarMouseClicked

    private void jBtnAgregarComentarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnAgregarComentarioMouseClicked
        Frm_AgregarComentario A = new Frm_AgregarComentario();
        Frm_Principal.contenedor.add(A);
        Dimension desktopSize = contenedor.getSize();
        Dimension FrameSize = A.getSize();
        A.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        A.toFront();
        A.setVisible(true);
    }//GEN-LAST:event_jBtnAgregarComentarioMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Frm_EliminarComentario A = new Frm_EliminarComentario();
        A.ocultarBarraTituloFormularios();
        Frm_Principal.contenedor.add(A);
        Dimension desktopSize = contenedor.getSize();
        Dimension FrameSize = A.getSize();
        A.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        A.toFront();
        A.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTxtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtCantidadKeyTyped
         char c = evt.getKeyChar();
                if (!Character.isDigit(c) && c != '.') {
                    evt.consume();
                }
                if (c == '.' && jTxtCantidad.getText().contains(".")) {
                    evt.consume();
                }
    }//GEN-LAST:event_jTxtCantidadKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup RaBtnGrupo1;
    private javax.swing.JButton jBtnAbrirPdf;
    private javax.swing.JButton jBtnAgregarComentario;
    private javax.swing.JButton jBtnExportar;
    private javax.swing.JButton jButton1;
    public static javax.swing.JComboBox<String> jComboBoxComentarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTxtCantidad;
    private javax.swing.JButton jbt_buscar;
    private javax.swing.JButton jbt_guardar;
    public static com.toedter.calendar.JDateChooser jdc_fecha;
    private javax.swing.JTable jtb_entrada;
    public static javax.swing.JTextField txt_codigo;
    public static javax.swing.JTextField txt_descripcion;
    // End of variables declaration//GEN-END:variables
}
