package Formularios;

import Clases.Cls_Tecnico;
import java.awt.Dimension;
import javax.swing.JComponent;

public class Frm_EliminarTecnico extends javax.swing.JInternalFrame {

    private Cls_Tecnico cp;
    private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension dimBarra = null;

    public Frm_EliminarTecnico() {
        initComponents();
        cp = new Cls_Tecnico();
        jTableTenicos.setModel(cp.listaComentarios());

    }

    public void ocultarBarraTituloFormulario() {
        Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
        dimBarra = Barra.getPreferredSize();
        Barra.setSize(0, 0);
        Barra.setPreferredSize(new Dimension(0, 0));
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnEliminar = new javax.swing.JButton();
        jBtnCerrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTenicos = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jBtnEliminar.setBackground(new java.awt.Color(0, 0, 0));
        jBtnEliminar.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        jBtnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        jBtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Eliminar Seleccionado.png"))); // NOI18N
        jBtnEliminar.setText("Eliminar");
        jBtnEliminar.setBorder(null);
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
        jBtnCerrar.setBorder(null);
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

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jScrollPane1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N

        jTableTenicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableTenicos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jBtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(jBtnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_jBtnCerrarActionPerformed

    private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed
        int row = jTableTenicos.getSelectedRow();
        if(row != -1){
        String tec = jTableTenicos.getValueAt(row, 0).toString();
        cp.eliminarTecnico(tec);
        jTableTenicos.setModel(cp.listaComentarios());
        Frm_Salida.jComboBoxTecnicos.setModel(cp.setComboBox()); 
        }
        
    }//GEN-LAST:event_jBtnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCerrar;
    private javax.swing.JButton jBtnEliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTenicos;
    // End of variables declaration//GEN-END:variables
}
