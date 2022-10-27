package Formularios;
/*
@author Lorenzatti Nazareno
@version 1.0
nl.loragro@gmail.com
*/

import Clases.Cls_Tecnico;
import javax.swing.JOptionPane;

// Formulario para registrar tecnicos en la base de datos

public class Frm_AgregarTecnicos extends javax.swing.JInternalFrame {

    private Cls_Tecnico tecnico;

    public Frm_AgregarTecnicos() {
        initComponents();
        this.tecnico = new Cls_Tecnico();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTxtNombre = new javax.swing.JTextField();
        jBtnAgregar = new javax.swing.JButton();
        jBtnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTxtApellido = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setTitle("Agregar Tecnico");

        jTxtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtNombreKeyTyped(evt);
            }
        });

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
        jLabel1.setText("Ingrese el Nombre del Tecnico");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addComponent(jBtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jBtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTxtNombre)
                .addGap(6, 6, 6)
                .addComponent(jTxtApellido)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(104, 104, 104))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Boton para registrar Tecnico
    private void jBtnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnAgregarMouseClicked
        
        String nombreTecnico = jTxtNombre.getText();
        String apellidoTecnico = jTxtApellido.getText();

        if (!nombreTecnico.equals(" ") && !apellidoTecnico.equals(" ")) {
            String nombreCompleto = nombreTecnico + " " + apellidoTecnico;

            this.tecnico.registrarTecnico(nombreCompleto);
            jTxtNombre.setText(null);
            jTxtApellido.setText(null);
            Frm_Salida.jComboBoxTecnicos.setModel(tecnico.setComboBox());
            
        } else {
            JOptionPane.showMessageDialog(null, "Debe Ingresar el Nombre y apellido del Tecnico");
        }
    }//GEN-LAST:event_jBtnAgregarMouseClicked

    private void jBtnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnSalirMouseClicked
        dispose();
    }//GEN-LAST:event_jBtnSalirMouseClicked

    // Solo permite ecribir letras
    private void jTxtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtNombreKeyTyped

        int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean espacio = key == 32;

        if (!(minusculas || mayusculas || espacio)) {
            evt.consume();
        }

    }//GEN-LAST:event_jTxtNombreKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAgregar;
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTxtApellido;
    private javax.swing.JTextField jTxtNombre;
    // End of variables declaration//GEN-END:variables
}
