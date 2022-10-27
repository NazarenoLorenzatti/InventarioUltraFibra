package Formularios;

/*
@author Lorenzatti Nazareno
@version 1.0
nl.loragro@gmail.com
 */
import Clases.Cls_Inventario;
import Utilidades.Imprimir;
import Utilidades.CrearRemitoPDF;
import Utilidades.ExportarExcel;
import Utilidades.ResaltadorTabla;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumnModel;

// Formulario para llevar el control del inventario
public class Frm_Inventario extends javax.swing.JInternalFrame {

    private final Cls_Inventario CP;
    TableColumnModel columnModel;
    public static int enviar = 0;
    private CrearRemitoPDF crear;
    private ExportarExcel e;
    private String file;
    /*
    --
    Argumentos privados 
    necesarios para poder ocultar la barra de titulos
    --
     */
    private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension dimBarra = null;

    private String nombreArchivoPDF = " - ";
    private final Imprimir imp;

    public Frm_Inventario() {

        initComponents();
        this.imp = new Imprimir();
        this.CP = new Cls_Inventario();
        this.columnModel = jtb_inventario.getColumnModel();

        listar();
    }

    public void ocultarBarraTituloInventario() {
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
        dimBarra = Barra.getPreferredSize();
        Barra.setSize(0, 0);
        Barra.setPreferredSize(new Dimension(0, 0));
        repaint();
    }

    private void listar() {
        jtb_inventario.setModel(CP.getDatosInventario());
        columnModel.getColumn(1).setPreferredWidth(400);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_inventario = new ResaltadorTabla();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jBtnAbrirPdf = new javax.swing.JButton();
        jBtnExportar = new javax.swing.JButton();
        jBtnExportarExcel = new javax.swing.JButton();

        setClosable(true);
        setTitle("Productos");
        setPreferredSize(new java.awt.Dimension(1220, 720));
        setRequestFocusEnabled(false);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jtb_inventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtb_inventario.setGridColor(new java.awt.Color(0, 0, 0));
        jtb_inventario.setShowGrid(true);
        jScrollPane1.setViewportView(jtb_inventario);

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Inventario de Productos");

        jLabel7.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Entrada, Salida y Stock de Productos.");

        jBtnAbrirPdf.setBackground(new java.awt.Color(255, 255, 255));
        jBtnAbrirPdf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBtnAbrirPdf.setForeground(new java.awt.Color(255, 255, 255));
        jBtnAbrirPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Abrir archivo blanco.png"))); // NOI18N
        jBtnAbrirPdf.setText("Abrir Pdf");
        jBtnAbrirPdf.setBorderPainted(false);
        jBtnAbrirPdf.setContentAreaFilled(false);
        jBtnAbrirPdf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnAbrirPdf.setFocusable(false);
        jBtnAbrirPdf.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Abrir archivo blanco Pressed.png"))); // NOI18N
        jBtnAbrirPdf.setRequestFocusEnabled(false);
        jBtnAbrirPdf.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Abrir Archivo blanco roll.png"))); // NOI18N
        jBtnAbrirPdf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnAbrirPdfMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBtnAbrirPdfMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBtnAbrirPdfMouseExited(evt);
            }
        });

        jBtnExportar.setBackground(new java.awt.Color(255, 255, 255));
        jBtnExportar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBtnExportar.setForeground(new java.awt.Color(255, 255, 255));
        jBtnExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Exportar Color Blanco.png"))); // NOI18N
        jBtnExportar.setText("Exportar PDF");
        jBtnExportar.setBorderPainted(false);
        jBtnExportar.setContentAreaFilled(false);
        jBtnExportar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnExportar.setFocusable(false);
        jBtnExportar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Exportar Blanco Pressed.png"))); // NOI18N
        jBtnExportar.setRequestFocusEnabled(false);
        jBtnExportar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Exportar Blanco Roll.png"))); // NOI18N
        jBtnExportar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnExportarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBtnExportarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBtnExportarMouseExited(evt);
            }
        });

        jBtnExportarExcel.setBackground(new java.awt.Color(0, 51, 102));
        jBtnExportarExcel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBtnExportarExcel.setForeground(new java.awt.Color(255, 255, 255));
        jBtnExportarExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Exportar Excel.png"))); // NOI18N
        jBtnExportarExcel.setText("Exportar Excel");
        jBtnExportarExcel.setBorder(null);
        jBtnExportarExcel.setBorderPainted(false);
        jBtnExportarExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnExportarExcel.setFocusPainted(false);
        jBtnExportarExcel.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Exportar Excel Pressed.png"))); // NOI18N
        jBtnExportarExcel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Exportar Excel Roll.png"))); // NOI18N
        jBtnExportarExcel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnExportarExcelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBtnExportarExcelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBtnExportarExcelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(485, 485, 485)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jBtnExportar)
                        .addGap(123, 123, 123)
                        .addComponent(jBtnAbrirPdf)
                        .addGap(149, 149, 149)
                        .addComponent(jBtnExportarExcel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(434, 434, 434)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnExportar)
                    .addComponent(jBtnAbrirPdf)
                    .addComponent(jBtnExportarExcel))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAbrirPdfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnAbrirPdfMouseClicked
        this.crear.abrirArchivo();
    }//GEN-LAST:event_jBtnAbrirPdfMouseClicked

    private void jBtnExportarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnExportarMouseClicked

        String directorio = null;
        // creo el objeto JFileChooser
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        //Abro la ventana y guardo la opcion seleccionada
        int seleccion = fc.showOpenDialog(this);

        //Comprueba si se dio en aceptar
        if (seleccion == JFileChooser.APPROVE_OPTION) {

            File fichero = fc.getSelectedFile();
            directorio = fichero.getAbsolutePath();
        }
        LocalDate fecha = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-LL-yyyy");
        String strFecha = fecha.format(formatter); // le damos el formato y la convertimos a string

        this.crear = new CrearRemitoPDF(jtb_inventario, this.nombreArchivoPDF, directorio, "Almacen"); // Instanciamos la clase para exportar        
        this.crear.crearPdfInventario(jtb_inventario, "STOCK - ", strFecha);

    }//GEN-LAST:event_jBtnExportarMouseClicked

    private void jBtnExportarExcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnExportarExcelMouseClicked
        if (jtb_inventario.getRowCount() > 0) {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
            chooser.setFileFilter(filter);
            chooser.setDialogTitle("Guardar archivo");
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                List tb = new ArrayList();
                List nom = new ArrayList();
                tb.add(jtb_inventario);
                nom.add("INVENTARIO");
                this.file = chooser.getSelectedFile().toString().concat(".xls");
                try {
                    this.e = new ExportarExcel(new File(this.file), tb, nom);
                    if (e.export()) {
                        JOptionPane.showMessageDialog(null, "Los datos fueron exportados a excel en el directorio seleccionado", "Mensaje de Informacion", JOptionPane.INFORMATION_MESSAGE);
                        File path = new File(this.file);
                        Desktop.getDesktop().open(path);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Hubo un error " + e.getMessage(), " Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay datos para exportar", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jBtnExportarExcelMouseClicked

    private void jBtnExportarExcelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnExportarExcelMouseEntered
        jBtnExportarExcel.setForeground(new Color(204, 255, 204));
        jBtnExportarExcel.setFont(new Font("Segoe UI", 3, 16));
    }//GEN-LAST:event_jBtnExportarExcelMouseEntered

    private void jBtnExportarExcelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnExportarExcelMouseExited
        jBtnExportarExcel.setForeground(new Color(255, 255, 255));
        jBtnExportarExcel.setFont(new Font("Segoe UI", 1, 14));
    }//GEN-LAST:event_jBtnExportarExcelMouseExited

    private void jBtnAbrirPdfMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnAbrirPdfMouseEntered
        jBtnAbrirPdf.setForeground(new Color(255,218,210));
        jBtnAbrirPdf.setFont(new Font("Segoe UI", 3, 16));
    }//GEN-LAST:event_jBtnAbrirPdfMouseEntered

    private void jBtnAbrirPdfMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnAbrirPdfMouseExited
        jBtnAbrirPdf.setForeground(new Color(255, 255, 255));
        jBtnAbrirPdf.setFont(new Font("Segoe UI", 1, 14));
    }//GEN-LAST:event_jBtnAbrirPdfMouseExited

    private void jBtnExportarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnExportarMouseEntered
        jBtnExportar.setForeground(new Color(255,218,210));
        jBtnExportar.setFont(new Font("Segoe UI", 3, 16));
    }//GEN-LAST:event_jBtnExportarMouseEntered

    private void jBtnExportarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnExportarMouseExited
        jBtnExportar.setForeground(new Color(255, 255, 255));
        jBtnExportar.setFont(new Font("Segoe UI", 1, 14));
    }//GEN-LAST:event_jBtnExportarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAbrirPdf;
    private javax.swing.JButton jBtnExportar;
    private javax.swing.JButton jBtnExportarExcel;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtb_inventario;
    // End of variables declaration//GEN-END:variables
}
