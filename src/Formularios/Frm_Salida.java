package Formularios;

/*
@author Lorenzatti Nazareno
@version 1.0
nl.loragro@gmail.com
 */
import Clases.Cls_Salida;
import Clases.Cls_Tecnico;
import static Formularios.Frm_Principal.contenedor;
import Utilidades.CrearPDF;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.File;
import static java.lang.Integer.parseInt;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;

public class Frm_Salida extends javax.swing.JInternalFrame {

    private static String nombreArchivoPDF = "Salidas - ";
    private CrearPDF crear;

    private final Cls_Salida CP;
    private Cls_Tecnico tecnico;
    TableColumnModel columnModel;
    public static int enviar = 0;
    int num = 0;

    // Argumentos para ocultar la barra de titulos
    private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension dimBarra = null;

    public Frm_Salida() {
        initComponents();
        this.tecnico = new Cls_Tecnico();
        this.CP = new Cls_Salida();
        this.columnModel = jtb_salida.getColumnModel();
        tecnico.setComboBox();
        jComboBoxTecnicos.setModel(this.tecnico.setComboBox());

        Calendar c2 = new GregorianCalendar();
        jdc_fecha.setCalendar(c2);
        listar();
        iniciar();
        activar();
    }

    public void ocultarBarraTituloSalida() {
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
        dimBarra = Barra.getPreferredSize();
        Barra.setSize(0, 0);
        Barra.setPreferredSize(new Dimension(0, 0));
        repaint();
    }

    private void listar() {
        jtb_salida.setModel(CP.getDatosSalida());
        columnModel.getColumn(3).setPreferredWidth(350);
    }

    private void iniciar() {
        jdc_fecha.setEnabled(true);
        jbt_buscar.setEnabled(false);
        jbt_guardar.setEnabled(false);
    }

    private void activar() {

        txt_codigo.requestFocus(true);
        jdc_fecha.setEnabled(true);
        jbt_buscar.setEnabled(true);
        jbt_guardar.setEnabled(true);
        txt_codigo.requestFocus();
    }

    private void limpiar() {

        txt_codigo.setText("");
        txt_descripcion.setText("");
        jtb_salida.clearSelection();
        txt_codigo.requestFocus();
    }

    private void guardar() {
        String codigo = txt_codigo.getText();
        String tecnico = (String) jComboBoxTecnicos.getSelectedItem();
        String user = Frm_Principal.jLblUsuario.getText();

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

        int stock = CP.verificarStock(codigo);

        if (cantidad > stock) {
            JOptionPane.showMessageDialog(null, "¡No hay stock suficiente!");
        } else {
            if (num == 0) {
                int respuesta = CP.registrarSalida(codigo, fecha_sql, cantidad, tecnico, user);
                if (respuesta > 0) {
                    listar();
                    limpiar();
                }
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_descripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jdc_fecha = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_salida = new javax.swing.JTable();
        jbt_buscar = new javax.swing.JButton();
        jbt_guardar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jBtnAbrirPDf = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jTxtCantidad = new javax.swing.JTextField();
        jComboBoxTecnicos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jBtnAgregarTecnico = new javax.swing.JButton();
        jBtnEliminarTecnico = new javax.swing.JButton();
        jBtnRemito = new javax.swing.JButton();
        jBtnExportar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Salida");
        setPreferredSize(new java.awt.Dimension(1220, 720));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Código del Producto *");

        txt_codigo.setEditable(true);
        txt_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_codigoKeyTyped(evt);
            }
        });

        txt_descripcion.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Descripción del Producto *");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Fecha *");

        jdc_fecha.setDateFormatString("dd/MM/yyyy");

        jtb_salida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtb_salida);

        jbt_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/lupa.png"))); // NOI18N
        jbt_buscar.setBorderPainted(false);
        jbt_buscar.setContentAreaFilled(false);
        jbt_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbt_buscar.setFocusPainted(false);
        jbt_buscar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Lupo Roll.png"))); // NOI18N
        jbt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_buscarActionPerformed(evt);
            }
        });

        jbt_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Icono salida.png"))); // NOI18N
        jbt_guardar.setText("Registrar Salida");
        jbt_guardar.setBorderPainted(false);
        jbt_guardar.setContentAreaFilled(false);
        jbt_guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbt_guardar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Icono Salida Pressed.png"))); // NOI18N
        jbt_guardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Icono Salida Roll.png"))); // NOI18N
        jbt_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_guardarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Salida de Productos");

        jLabel7.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel7.setText("Llene la información respectiva para la salida de los productos.");

        jBtnAbrirPDf.setBackground(new java.awt.Color(255, 255, 255));
        jBtnAbrirPDf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Abrir Archivo.png"))); // NOI18N
        jBtnAbrirPDf.setText("Abrir PDF");
        jBtnAbrirPDf.setBorderPainted(false);
        jBtnAbrirPDf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnAbrirPDf.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Abrir Archivo pressed.png"))); // NOI18N
        jBtnAbrirPDf.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Abrir Archivo Roll.png"))); // NOI18N
        jBtnAbrirPDf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnAbrirPDfMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));

        jRadioButton3.setBackground(new java.awt.Color(0, 51, 102));
        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(0, 51, 102));
        jRadioButton3.setBorder(null);
        jRadioButton3.setContentAreaFilled(false);
        jRadioButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/x100.png"))); // NOI18N
        jRadioButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/x100 roll.png"))); // NOI18N
        jRadioButton3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/x100 check.png"))); // NOI18N

        jRadioButton2.setBackground(new java.awt.Color(0, 51, 102));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(0, 51, 102));
        jRadioButton2.setBorder(null);
        jRadioButton2.setContentAreaFilled(false);
        jRadioButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/x10.png"))); // NOI18N
        jRadioButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/x10 roll.png"))); // NOI18N
        jRadioButton2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/x10 check.png"))); // NOI18N

        jRadioButton1.setBackground(new java.awt.Color(0, 51, 102));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(0, 51, 102));
        jRadioButton1.setSelected(true);
        jRadioButton1.setBorder(null);
        jRadioButton1.setContentAreaFilled(false);
        jRadioButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton1.setFocusPainted(false);
        jRadioButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/x10.png"))); // NOI18N
        jRadioButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/x1 Roll.png"))); // NOI18N
        jRadioButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/x1 Check.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingrese cantidad");

        jTxtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtCantidadKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jRadioButton1)
                .addGap(106, 106, 106)
                .addComponent(jRadioButton2)
                .addGap(102, 102, 102)
                .addComponent(jRadioButton3)
                .addGap(221, 221, 221)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jComboBoxTecnicos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tecnico 1", "Tecnico 2", " " }));
        jComboBoxTecnicos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Tecnico*");

        jBtnAgregarTecnico.setBackground(new java.awt.Color(255, 255, 255));
        jBtnAgregarTecnico.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jBtnAgregarTecnico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Servicio Tecnico.png"))); // NOI18N
        jBtnAgregarTecnico.setText("Agregar Tecnico");
        jBtnAgregarTecnico.setBorderPainted(false);
        jBtnAgregarTecnico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnAgregarTecnico.setFocusPainted(false);
        jBtnAgregarTecnico.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Agregar Tecnico Pressed.png"))); // NOI18N
        jBtnAgregarTecnico.setRequestFocusEnabled(false);
        jBtnAgregarTecnico.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Agregar Tecnico Roll.png"))); // NOI18N
        jBtnAgregarTecnico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnAgregarTecnicoMouseClicked(evt);
            }
        });

        jBtnEliminarTecnico.setBackground(new java.awt.Color(255, 255, 255));
        jBtnEliminarTecnico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Eliminar Tecnico.png"))); // NOI18N
        jBtnEliminarTecnico.setBorderPainted(false);
        jBtnEliminarTecnico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnEliminarTecnico.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Eliminar Tecnico pressed.png"))); // NOI18N
        jBtnEliminarTecnico.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Eliminar Tecnico roll.png"))); // NOI18N
        jBtnEliminarTecnico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnEliminarTecnicoMouseClicked(evt);
            }
        });

        jBtnRemito.setBackground(new java.awt.Color(255, 255, 255));
        jBtnRemito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Remito.png"))); // NOI18N
        jBtnRemito.setText("Remito");
        jBtnRemito.setBorder(null);
        jBtnRemito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnRemito.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Remito Pressed.png"))); // NOI18N
        jBtnRemito.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Remito Roll.png"))); // NOI18N
        jBtnRemito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnRemitoMouseClicked(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnAgregarTecnico)
                .addGap(164, 164, 164))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdc_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbt_buscar)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(165, 165, 165))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBoxTecnicos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)))
                .addComponent(jBtnEliminarTecnico)
                .addGap(58, 58, 58))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jbt_guardar)
                        .addGap(98, 98, 98)
                        .addComponent(jBtnExportar)
                        .addGap(117, 117, 117)
                        .addComponent(jBtnAbrirPDf)
                        .addGap(165, 165, 165)
                        .addComponent(jBtnRemito))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7))
                    .addComponent(jBtnAgregarTecnico))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxTecnicos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jdc_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jbt_buscar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtnEliminarTecnico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbt_guardar)
                    .addComponent(jBtnExportar)
                    .addComponent(jBtnAbrirPDf)
                    .addComponent(jBtnRemito))
                .addGap(14, 14, 14))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAbrirPDfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnAbrirPDfMouseClicked
        this.crear.abrirArchivo();
    }//GEN-LAST:event_jBtnAbrirPDfMouseClicked

    private void jbt_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_guardarActionPerformed

        String cod = txt_codigo.getText();

        if (cod.equals("") || cod.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el codigo y la fecha para registrar una salida de producto");
        } else {
            guardar();
        }

    }//GEN-LAST:event_jbt_guardarActionPerformed

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

    private void txt_codigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoKeyTyped
        char cTeclaPresionada = evt.getKeyChar();

        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            guardar();
        }
    }//GEN-LAST:event_txt_codigoKeyTyped

    private void jBtnAgregarTecnicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnAgregarTecnicoMouseClicked
        Frm_AgregarTecnicos A = new Frm_AgregarTecnicos();
        Frm_Principal.contenedor.add(A);
        Dimension desktopSize = contenedor.getSize();
        Dimension FrameSize = A.getSize();
        A.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        A.toFront();
        A.setVisible(true);
    }//GEN-LAST:event_jBtnAgregarTecnicoMouseClicked

    private void jBtnRemitoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnRemitoMouseClicked
        Frm_Remito R = new Frm_Remito();
        R.ocultarBarraTituloRemito();
        Frm_Principal.contenedor.add(R);
        Dimension desktopSize = contenedor.getSize();
        Dimension FrameSize = R.getSize();
        R.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        R.toFront();
        R.setVisible(true);
    }//GEN-LAST:event_jBtnRemitoMouseClicked

    private void jBtnExportarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnExportarMouseClicked
        String directorio = null;
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int seleccion = fc.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {

            File fichero = fc.getSelectedFile();
            directorio = fichero.getAbsolutePath();
        }

        LocalDate fecha = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String strFecha = fecha.format(formatter);

        this.nombreArchivoPDF = this.nombreArchivoPDF + strFecha;

        this.crear = new CrearPDF(jtb_salida, this.nombreArchivoPDF, directorio);
        crear.crearPdf(jtb_salida);
    }//GEN-LAST:event_jBtnExportarMouseClicked

    private void jBtnEliminarTecnicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnEliminarTecnicoMouseClicked
        Frm_EliminarTecnico R = new Frm_EliminarTecnico();
        R.ocultarBarraTituloFormulario();
        Frm_Principal.contenedor.add(R);
        Dimension desktopSize = contenedor.getSize();
        Dimension FrameSize = R.getSize();
        R.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        R.toFront();
        R.setVisible(true);
    }//GEN-LAST:event_jBtnEliminarTecnicoMouseClicked

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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBtnAbrirPDf;
    private javax.swing.JButton jBtnAgregarTecnico;
    private javax.swing.JButton jBtnEliminarTecnico;
    private javax.swing.JButton jBtnExportar;
    private javax.swing.JButton jBtnRemito;
    public static javax.swing.JComboBox<String> jComboBoxTecnicos;
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
    private javax.swing.JTable jtb_salida;
    public static javax.swing.JTextField txt_codigo;
    public static javax.swing.JTextField txt_descripcion;
    // End of variables declaration//GEN-END:variables
}
