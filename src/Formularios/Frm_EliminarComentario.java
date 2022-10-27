package Formularios;

import Clases.Cls_ComentarioEntrada;
import java.awt.Dimension;
import javax.swing.JComponent;

public class Frm_EliminarComentario extends javax.swing.JInternalFrame {

    private Cls_ComentarioEntrada cp;
    private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension dimBarra = null;

    public Frm_EliminarComentario() {
        initComponents();
        cp = new Cls_ComentarioEntrada();
        jTableComentarios.setModel(cp.listaComentarios());

    }

    public void ocultarBarraTituloFormularios() {
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
        dimBarra = Barra.getPreferredSize();
        Barra.setSize(0, 0);
        Barra.setPreferredSize(new Dimension(0, 0));
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableComentarios = new javax.swing.JTable();
        jBtnEliminar = new javax.swing.JButton();
        jBtnCerrar = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 51, 102));
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTableComentarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableComentarios);

        jBtnEliminar.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        jBtnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        jBtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Eliminar Seleccionado.png"))); // NOI18N
        jBtnEliminar.setText("Eliminar");
        jBtnEliminar.setBorderPainted(false);
        jBtnEliminar.setContentAreaFilled(false);
        jBtnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnEliminar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Eliminar Seleccionado Pressed.png"))); // NOI18N
        jBtnEliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Eliminar Seleccionado Roll.png"))); // NOI18N
        jBtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarActionPerformed(evt);
            }
        });

        jBtnCerrar.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        jBtnCerrar.setForeground(new java.awt.Color(0, 0, 0));
        jBtnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Salir Redondeado.png"))); // NOI18N
        jBtnCerrar.setText("Cerrar");
        jBtnCerrar.setBorderPainted(false);
        jBtnCerrar.setContentAreaFilled(false);
        jBtnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnCerrar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Salir Redondeado pressed.png"))); // NOI18N
        jBtnCerrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Salir Redondeado roll.png"))); // NOI18N
        jBtnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jBtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(jBtnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_jBtnCerrarActionPerformed

    private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed
        int row = jTableComentarios.getSelectedRow();
        if (row != -1) {
            String com = jTableComentarios.getValueAt(row, 0).toString();
            cp.eliminarComentario(com);
            jTableComentarios.setModel(cp.listaComentarios());
            Frm_Entrada.jComboBoxComentarios.setModel(cp.setComboBox());
        }

    }//GEN-LAST:event_jBtnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCerrar;
    private javax.swing.JButton jBtnEliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableComentarios;
    // End of variables declaration//GEN-END:variables
}
