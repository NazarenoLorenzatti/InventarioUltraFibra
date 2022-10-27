package Formularios;
/*
@author Lorenzatti Nazareno
@version 1.0
nl.loragro@gmail.com
*/

import Clases.Cls_CategoriaProducto;
import javax.swing.JOptionPane;

// Formulario para registrar tecnicos en la base de datos

public class Frm_AgregarCategoria extends javax.swing.JInternalFrame {

    private Cls_CategoriaProducto CE;

    public Frm_AgregarCategoria() {
        initComponents();
        this.CE = new Cls_CategoriaProducto();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnAgregar = new javax.swing.JButton();
        jBtnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTxtAreaComentario = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setTitle("Agregar Tecnico");

        jBtnAgregar.setBackground(new java.awt.Color(255, 255, 255));
        jBtnAgregar.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        jBtnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Agregar.png"))); // NOI18N
        jBtnAgregar.setText("Agregar");
        jBtnAgregar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnAgregar.setBorderPainted(false);
        jBtnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnAgregar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Agregar pressed.png"))); // NOI18N
        jBtnAgregar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Agregar Roll.png"))); // NOI18N
        jBtnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnAgregarMouseClicked(evt);
            }
        });

        jBtnSalir.setBackground(new java.awt.Color(255, 255, 255));
        jBtnSalir.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jBtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Cerrar Rojo.png"))); // NOI18N
        jBtnSalir.setText("Salir");
        jBtnSalir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBtnSalir.setBorderPainted(false);
        jBtnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnSalir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/cerrar pressed.png"))); // NOI18N
        jBtnSalir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/cerrar roll.png"))); // NOI18N
        jBtnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnSalirMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel1.setText("Ingrese La categoria");

        jTxtAreaComentario.setColumns(20);
        jTxtAreaComentario.setRows(5);
        jScrollPane1.setViewportView(jTxtAreaComentario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 43, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jBtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addComponent(jBtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(226, 226, 226))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Boton para registrar Tecnico
    private void jBtnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnAgregarMouseClicked
        
        String comentario = jTxtAreaComentario.getText();
        

        if (!comentario.equals("") || !comentario.equals("")) {
            
            this.CE.registrarCategoria(comentario);
            Frm_Productos.comboBoxCategoria.setModel(CE.setComboBox());
            jTxtAreaComentario.setText(null);
            
        } else {
            JOptionPane.showMessageDialog(null, "Debe Ingresar un comentario para poder registrarlo");
        }
        
    }//GEN-LAST:event_jBtnAgregarMouseClicked

    private void jBtnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnSalirMouseClicked
        dispose();
    }//GEN-LAST:event_jBtnSalirMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAgregar;
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTxtAreaComentario;
    // End of variables declaration//GEN-END:variables
}
