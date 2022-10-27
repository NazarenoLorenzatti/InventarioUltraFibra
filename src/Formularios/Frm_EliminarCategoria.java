package Formularios;

import Clases.Cls_CategoriaProducto;
import static Formularios.Frm_Productos.comboBoxCategoria;
import java.awt.Dimension;
import javax.swing.JComponent;

/**
 *
 * @author nlore
 */
public class Frm_EliminarCategoria extends javax.swing.JInternalFrame {

    private Cls_CategoriaProducto cp;
    private JComponent Barra = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
    private Dimension dimBarra = null;

    public Frm_EliminarCategoria() {
        initComponents();
        cp = new Cls_CategoriaProducto();
        jTableCategorias.setModel(cp.listaCategorias());

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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCategorias = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jBtnEliminar = new javax.swing.JButton();
        jBtnCerrar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableCategorias);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        jBtnEliminar.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        jBtnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jBtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Eliminar Seleccionado.png"))); // NOI18N
        jBtnEliminar.setText("Eliminar");
        jBtnEliminar.setBorderPainted(false);
        jBtnEliminar.setContentAreaFilled(false);
        jBtnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnEliminar.setDefaultCapable(false);
        jBtnEliminar.setFocusPainted(false);
        jBtnEliminar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Eliminar Seleccionado Pressed.png"))); // NOI18N
        jBtnEliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Eliminar Seleccionado Roll.png"))); // NOI18N
        jBtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarActionPerformed(evt);
            }
        });

        jBtnCerrar.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        jBtnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        jBtnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Salir Redondeado.png"))); // NOI18N
        jBtnCerrar.setText("Cerrar");
        jBtnCerrar.setBorderPainted(false);
        jBtnCerrar.setContentAreaFilled(false);
        jBtnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnCerrar.setDefaultCapable(false);
        jBtnCerrar.setFocusPainted(false);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jBtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(jBtnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_jBtnCerrarActionPerformed

    private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed
        int row = jTableCategorias.getSelectedRow();
        if (row != -1) {
            String cat = jTableCategorias.getValueAt(row, 0).toString();
            cp.eliminarCategoria(cat);
            jTableCategorias.setModel(cp.listaCategorias());
            Frm_Productos.comboBoxCategoria.setModel(cp.setComboBox());
        }
    }//GEN-LAST:event_jBtnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCerrar;
    private javax.swing.JButton jBtnEliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCategorias;
    // End of variables declaration//GEN-END:variables
}
