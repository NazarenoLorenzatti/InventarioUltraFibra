package Formularios;

/*
@author Lorenzatti Nazareno
@version 1.0
nl.loragro@gmail.com
 */

import Clases.Cls_CategoriaProducto;
import Clases.Cls_Productos;
import static Formularios.Frm_Principal.contenedor;
import java.awt.Dimension;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;
import static Formularios.Frm_Entrada.jComboBoxComentarios;

// Formulario para almacenar los productos de la empresa

public class Frm_Productos extends javax.swing.JInternalFrame {

    private final Cls_Productos CP;
    TableColumnModel columnModel;
    int num = 0;
    private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension dimBarra = null;
    private Cls_CategoriaProducto CE;

    public Frm_Productos() {
        initComponents();
        CP = new Cls_Productos();
        CE = new Cls_CategoriaProducto();
        columnModel = jtb_productos.getColumnModel();
        listar();
        iniciar();
        
        comboBoxCategoria.setModel(CE.setComboBox());
        bt_actualizar.setEnabled(false);
        bt_eliminar.setEnabled(false);
        bt_guardar.setEnabled(false);
    }

    public void ocultarBarraTituloProductos() {
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
        dimBarra = Barra.getPreferredSize();
        Barra.setSize(0, 0);
        Barra.setPreferredSize(new Dimension(0, 0));
        repaint();
    }

    private void listar() {
        jtb_productos.setModel(CP.getDatosProductos());
        columnModel.getColumn(1).setPreferredWidth(600);
    }

    private void iniciar() {
        txt_codigo.setEnabled(false);
        txt_descripcion.setEnabled(false);
    }

    private void activar() {
        txt_codigo.setEnabled(true);
        txt_descripcion.setEnabled(true);
        txt_codigo.requestFocus();
    }

    private void limpiar() {
        txt_codigo.setText("");
        txt_descripcion.setText("");
        txt_codigo.requestFocus();
        jtb_productos.clearSelection();
    }

    private void guardar() {
        String codigo = txt_codigo.getText();
        String descripcion = txt_descripcion.getText();
        String categoria = (String) comboBoxCategoria.getSelectedItem();

        if (num == 0) {
            int respuesta = CP.registrarProducto(codigo, descripcion, categoria);
            if (respuesta > 0) {
                if (CP.verificarCodigoInventario(codigo) == 0) {
                    CP.insertarProductoInventario(codigo);
                }

                listar();
                limpiar();
                iniciar();
                bt_actualizar.setEnabled(false);
            }
        } else {
            int row = jtb_productos.getSelectedRow();
            String codigo_old = jtb_productos.getValueAt(row, 0).toString();

            int respuesta = CP.actualizarProducto(codigo, descripcion, codigo_old);
            if (respuesta > 0) {
                listar();
                limpiar();
                iniciar();
                num = 0;
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_productos = new javax.swing.JTable();
        bt_actualizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_descripcion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jBtnAgregarComentario = new javax.swing.JButton();
        jBtnEliminarCategoria = new javax.swing.JButton();
        bt_nuevo = new javax.swing.JButton();
        bt_guardar = new javax.swing.JButton();
        bt_eliminar = new javax.swing.JButton();
        comboBoxCategoria = new javax.swing.JComboBox<>();

        setClosable(true);
        setTitle("Productos");
        setPreferredSize(new java.awt.Dimension(1220, 720));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Código de Producto *");

        jtb_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtb_productos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtb_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_productosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtb_productos);

        bt_actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Modificar.png"))); // NOI18N
        bt_actualizar.setText("Modificar");
        bt_actualizar.setBorderPainted(false);
        bt_actualizar.setContentAreaFilled(false);
        bt_actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_actualizar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Modificar Pressed.png"))); // NOI18N
        bt_actualizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Modificar roll.png"))); // NOI18N
        bt_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_actualizarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Descripción *");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Registro de Productos");

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel3.setText("Llene la información respectiva de los productos.");

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));

        jBtnAgregarComentario.setBackground(new java.awt.Color(255, 255, 255));
        jBtnAgregarComentario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBtnAgregarComentario.setForeground(new java.awt.Color(255, 255, 255));
        jBtnAgregarComentario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Nueva categoria.png"))); // NOI18N
        jBtnAgregarComentario.setText("Nueva Categoria");
        jBtnAgregarComentario.setBorderPainted(false);
        jBtnAgregarComentario.setContentAreaFilled(false);
        jBtnAgregarComentario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnAgregarComentario.setFocusPainted(false);
        jBtnAgregarComentario.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Nueva Categorian Pressed.png"))); // NOI18N
        jBtnAgregarComentario.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Nueva categoria Roll.png"))); // NOI18N
        jBtnAgregarComentario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnAgregarComentarioMouseClicked(evt);
            }
        });

        jBtnEliminarCategoria.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jBtnEliminarCategoria.setForeground(new java.awt.Color(255, 255, 255));
        jBtnEliminarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Eliminar Categoria.png"))); // NOI18N
        jBtnEliminarCategoria.setText("Eliminar Categoria");
        jBtnEliminarCategoria.setBorderPainted(false);
        jBtnEliminarCategoria.setContentAreaFilled(false);
        jBtnEliminarCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnEliminarCategoria.setFocusPainted(false);
        jBtnEliminarCategoria.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Eliminar Categoria Pressed.png"))); // NOI18N
        jBtnEliminarCategoria.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Eliminar categoria Roll.png"))); // NOI18N
        jBtnEliminarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(361, 361, 361)
                .addComponent(jBtnAgregarComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jBtnEliminarCategoria)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAgregarComentario, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnEliminarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        bt_nuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Agregar Producto.png"))); // NOI18N
        bt_nuevo.setText("Nuevo");
        bt_nuevo.setBorderPainted(false);
        bt_nuevo.setContentAreaFilled(false);
        bt_nuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_nuevo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Agregar Producto Pressed.png"))); // NOI18N
        bt_nuevo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Agregar Producto Roll.png"))); // NOI18N
        bt_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_nuevoActionPerformed(evt);
            }
        });

        bt_guardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Guardar Producto.png"))); // NOI18N
        bt_guardar.setText("Guardar");
        bt_guardar.setBorderPainted(false);
        bt_guardar.setContentAreaFilled(false);
        bt_guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_guardar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Guardar Producto Pressed.png"))); // NOI18N
        bt_guardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Guardar Producto Roll.png"))); // NOI18N
        bt_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_guardarActionPerformed(evt);
            }
        });

        bt_eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bt_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Eliminar Producto.png"))); // NOI18N
        bt_eliminar.setText("Eliminar");
        bt_eliminar.setBorderPainted(false);
        bt_eliminar.setContentAreaFilled(false);
        bt_eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_eliminar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Eliminar Producto Pressed.png"))); // NOI18N
        bt_eliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Eliminar Producto roll.png"))); // NOI18N
        bt_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(66, 66, 66)
                                        .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(59, 59, 59)
                                        .addComponent(bt_actualizar))
                                    .addComponent(jLabel5))
                                .addGap(65, 65, 65))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(bt_nuevo)
                        .addGap(188, 188, 188)
                        .addComponent(bt_guardar)
                        .addGap(159, 159, 159)
                        .addComponent(bt_eliminar)))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel2)))
                .addGap(451, 451, 451))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_actualizar)
                    .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_eliminar)
                    .addComponent(bt_guardar)
                    .addComponent(bt_nuevo))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_guardarActionPerformed
              
        String cod = txt_codigo.getText();    
        String des = txt_descripcion.getText();
        
        if (cod.equals("") || cod.equals(" ") && des.equals("") || des.equals(" ") ){
            JOptionPane.showMessageDialog(null, "Debe ingresar el codigo y la descripcion para registrar un producto");
        } else {
            guardar();
        }

    }//GEN-LAST:event_bt_guardarActionPerformed

    private void jtb_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_productosMouseClicked
        bt_actualizar.setEnabled(true);
        bt_eliminar.setEnabled(true);

        int row = jtb_productos.getSelectedRow();
        txt_codigo.setText(jtb_productos.getValueAt(row, 0).toString());
        txt_descripcion.setText(jtb_productos.getValueAt(row, 1).toString());
    }//GEN-LAST:event_jtb_productosMouseClicked

    private void bt_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_eliminarActionPerformed
        int fila = jtb_productos.getSelectedRowCount();
        if (fila < 1) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
        } else {
            int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar?", "Eliminar Producto", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resp == 0) {
                if (CP.eliminarProducto(jtb_productos.getValueAt(jtb_productos.getSelectedRow(), 0).toString()) > 0) {
                    listar();
                    limpiar();
                    bt_eliminar.setEnabled(false);
                    bt_actualizar.setEnabled(false);
                    bt_guardar.setEnabled(false);
                }
            }
        }
    }//GEN-LAST:event_bt_eliminarActionPerformed

    private void bt_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_nuevoActionPerformed
        activar();
        limpiar();
        bt_guardar.setEnabled(true);
    }//GEN-LAST:event_bt_nuevoActionPerformed

    private void bt_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_actualizarActionPerformed
        num = 1;
        activar();
        bt_actualizar.setEnabled(false);
        bt_guardar.setEnabled(true);
        bt_eliminar.setEnabled(false);
    }//GEN-LAST:event_bt_actualizarActionPerformed

    private void jBtnAgregarComentarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnAgregarComentarioMouseClicked
        Frm_AgregarCategoria A = new Frm_AgregarCategoria();
        Frm_Principal.contenedor.add(A);
        Dimension desktopSize = contenedor.getSize();
        Dimension FrameSize = A.getSize();
        A.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        A.toFront();
        A.setVisible(true);
    }//GEN-LAST:event_jBtnAgregarComentarioMouseClicked

    private void jBtnEliminarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarCategoriaActionPerformed
        Frm_EliminarCategoria A = new Frm_EliminarCategoria();
        A.ocultarBarraTituloFormularios();
        Frm_Principal.contenedor.add(A);
        Dimension desktopSize = contenedor.getSize();
        Dimension FrameSize = A.getSize();
        A.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        A.toFront();
        A.setVisible(true);
    }//GEN-LAST:event_jBtnEliminarCategoriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_actualizar;
    private javax.swing.JButton bt_eliminar;
    private javax.swing.JButton bt_guardar;
    private javax.swing.JButton bt_nuevo;
    public static javax.swing.JComboBox<String> comboBoxCategoria;
    private javax.swing.JButton jBtnAgregarComentario;
    private javax.swing.JButton jBtnEliminarCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtb_productos;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_descripcion;
    // End of variables declaration//GEN-END:variables
}
