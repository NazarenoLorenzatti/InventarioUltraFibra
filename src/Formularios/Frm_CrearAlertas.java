package Formularios;

/*
@author Lorenzatti Nazareno
@version 1.0
nl.loragro@gmail.com
*/

import Clases.Cls_CrearAlertas;
import java.awt.Dimension;
import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

// Formulario para crear alertas de poco stock

public class Frm_CrearAlertas extends javax.swing.JInternalFrame {

    private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension dimBarra = null;

    private final Cls_CrearAlertas CP;
    TableColumnModel columnModel;

    DefaultTableModel DT = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }

    };

    public Frm_CrearAlertas() {
        initComponents();
        CP = new Cls_CrearAlertas();
        this.columnModel = tabla.getColumnModel();
        listar();
    }

    public void ocultarBarraTituloCrearAlertas() {
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
        dimBarra = Barra.getPreferredSize();
        Barra.setSize(0, 0);
        Barra.setPreferredSize(new Dimension(0, 0));
        repaint();
    }

    private void listar() {
        tabla.setModel(CP.getDatosProductos());
        tablaAlertas.setModel(CP.getAlertas());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg_busqueda = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jrb_nombre = new javax.swing.JRadioButton();
        jrb_codigo = new javax.swing.JRadioButton();
        txt_busqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jTxtCod = new javax.swing.JTextField();
        jTxtDes = new javax.swing.JTextField();
        jTxtCant = new javax.swing.JTextField();
        jBtnCrearAlerta = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAlertas = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jBtnEliminarAlerta = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 51, 102));
        setClosable(true);
        setTitle("Lista de Productos");
        setPreferredSize(new java.awt.Dimension(720, 720));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Búsqueda por:");

        jrb_nombre.setBackground(new java.awt.Color(0, 51, 102));
        bg_busqueda.add(jrb_nombre);
        jrb_nombre.setForeground(new java.awt.Color(255, 255, 255));
        jrb_nombre.setText("Descripción");
        jrb_nombre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jrb_nombre.setFocusPainted(false);

        jrb_codigo.setBackground(new java.awt.Color(0, 51, 102));
        bg_busqueda.add(jrb_codigo);
        jrb_codigo.setForeground(new java.awt.Color(255, 255, 255));
        jrb_codigo.setText("Código");
        jrb_codigo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txt_busqueda.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_busquedaCaretUpdate(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jBtnCrearAlerta.setBackground(new java.awt.Color(255, 255, 255));
        jBtnCrearAlerta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBtnCrearAlerta.setForeground(new java.awt.Color(255, 255, 255));
        jBtnCrearAlerta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Agregar Alerta.png"))); // NOI18N
        jBtnCrearAlerta.setText("Crear Alerta");
        jBtnCrearAlerta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnCrearAlerta.setBorderPainted(false);
        jBtnCrearAlerta.setContentAreaFilled(false);
        jBtnCrearAlerta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnCrearAlerta.setHideActionText(true);
        jBtnCrearAlerta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnCrearAlerta.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Agregar alerta Pressed.png"))); // NOI18N
        jBtnCrearAlerta.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Agregar alerta Roll.png"))); // NOI18N
        jBtnCrearAlerta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnCrearAlerta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnCrearAlertaMouseClicked(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 153));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Cerrar Rojo.png"))); // NOI18N
        jButton2.setText("Cerrar");
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/cerrar pressed.png"))); // NOI18N
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/cerrar roll.png"))); // NOI18N
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Codigo");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel3.setFont(new java.awt.Font("Perpetua Titling MT", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Descripcion");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel4.setFont(new java.awt.Font("Perpetua Titling MT", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cantidad Minima");

        tablaAlertas.setBackground(new java.awt.Color(204, 255, 204));
        tablaAlertas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaAlertas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAlertasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaAlertas);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ALERTAS CREADAS");

        jBtnEliminarAlerta.setBackground(new java.awt.Color(255, 255, 255));
        jBtnEliminarAlerta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBtnEliminarAlerta.setForeground(new java.awt.Color(255, 255, 255));
        jBtnEliminarAlerta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Eliminar Alerta.png"))); // NOI18N
        jBtnEliminarAlerta.setText("Eliminar Alerta");
        jBtnEliminarAlerta.setBorderPainted(false);
        jBtnEliminarAlerta.setContentAreaFilled(false);
        jBtnEliminarAlerta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnEliminarAlerta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnEliminarAlerta.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Eliminar Alerta Pressed.png"))); // NOI18N
        jBtnEliminarAlerta.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Eliminar alerta Roll.png"))); // NOI18N
        jBtnEliminarAlerta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnEliminarAlerta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnEliminarAlertaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jrb_codigo)
                        .addGap(46, 46, 46)
                        .addComponent(jrb_nombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(txt_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(144, 144, 144))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jTxtCod)
                            .addGap(20, 20, 20)))
                    .addComponent(jTxtCant, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jTxtDes, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBtnCrearAlerta, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBtnEliminarAlerta)
                        .addGap(137, 137, 137)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(149, 149, 149))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(300, 300, 300))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrb_codigo)
                    .addComponent(jrb_nombre)
                    .addComponent(txt_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTxtCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnCrearAlerta)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addComponent(jBtnEliminarAlerta))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_busquedaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_busquedaCaretUpdate
        if (jrb_nombre.isSelected()) {
            String inf = txt_busqueda.getText();
            tabla.setModel(CP.getDato(1, inf));
        }

        if (jrb_codigo.isSelected()) {
            String inf = txt_busqueda.getText();
            tabla.setModel(CP.getDato(2, inf));
        }

        if (txt_busqueda.getText().isEmpty()) {
            tabla.setModel(CP.getDatosProductos());
        }
    }//GEN-LAST:event_txt_busquedaCaretUpdate

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked

        int row = tabla.getSelectedRow();
        jTxtCod.setText(tabla.getValueAt(row, 0).toString());
        jTxtDes.setText(tabla.getValueAt(row, 1).toString());

    }//GEN-LAST:event_tablaMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jBtnCrearAlertaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnCrearAlertaMouseClicked

        String cod = jTxtCod.getText();
        String des = jTxtDes.getText();
        String can = jTxtCant.getText();
        int cant = Integer.parseInt(can);       
        

        CP.crearAlerta(cod, cant, des);
        tablaAlertas.setModel(CP.getAlertas());
    }//GEN-LAST:event_jBtnCrearAlertaMouseClicked

    private void tablaAlertasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAlertasMouseClicked

    }//GEN-LAST:event_tablaAlertasMouseClicked

    private void jBtnEliminarAlertaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnEliminarAlertaMouseClicked

        if (tablaAlertas.getSelectedRow() > -1) {

            int row = tablaAlertas.getSelectedRow();
            String cod = tablaAlertas.getValueAt(row, 0).toString();
            CP.eliminarAlerta(cod);
            tablaAlertas.setModel(CP.getAlertas());
        }
    }//GEN-LAST:event_jBtnEliminarAlertaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bg_busqueda;
    private javax.swing.JButton jBtnCrearAlerta;
    private javax.swing.JButton jBtnEliminarAlerta;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTxtCant;
    private javax.swing.JTextField jTxtCod;
    private javax.swing.JTextField jTxtDes;
    private javax.swing.JRadioButton jrb_codigo;
    private javax.swing.JRadioButton jrb_nombre;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tablaAlertas;
    private javax.swing.JTextField txt_busqueda;
    // End of variables declaration//GEN-END:variables
}
