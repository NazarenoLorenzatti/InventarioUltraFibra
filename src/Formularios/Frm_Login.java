package Formularios;

/*
@author Lorenzatti Nazareno
@version 1.0
nl.loragro@gmail.com
 */
//import Clases.Cls_CrearAlertas;
import Clases.Cls_Login;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

// Formulario para el login a la APP
public class Frm_Login extends javax.swing.JFrame {

    private Icon iconoAlerta;

    public Frm_Login() {
        initComponents();
        txt_usuario.setText(null);
        txt_clave.setText(null);

        this.setLocationRelativeTo(null);
        setResizable(false);

        // Escalamos la imagen del Login
        ImageIcon imgIcon = (ImageIcon) jLabel4.getIcon();
        Image imgEscalada = imgIcon.getImage().getScaledInstance(jLabel4.getWidth(), jLabel4.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);

        jLabel4.setIcon(iconoEscalado);

    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Multimedia/Almacen.png"));
        return retValue;
    }

    private void login() {
        String user = null;
        String pass = null;

        user = txt_usuario.getText();
        pass = txt_clave.getText();
        Cls_Login login = new Cls_Login(user, pass);

        if (login.getLogin()) {
            Frm_Principal ing = new Frm_Principal();
            ing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ing.setLocationRelativeTo(null);
            ing.setVisible(true);
            ing.show();

            Frm_Principal.jLblUsuario.setText(login.getNombre());
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrectos");
            txt_usuario.setText("");
            txt_clave.setText("");
            txt_usuario.requestFocus();
        }

    }

    public Icon getIconoAlerta() {
        return iconoAlerta;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jBtnIniciarSesion = new javax.swing.JButton();
        txt_usuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_clave = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jChkRecordar = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Inventario");
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jBtnIniciarSesion.setBackground(new java.awt.Color(0, 51, 153));
        jBtnIniciarSesion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jBtnIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        jBtnIniciarSesion.setText("Iniciar Sesión");
        jBtnIniciarSesion.setBorder(null);
        jBtnIniciarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnIniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBtnIniciarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBtnIniciarSesionMouseExited(evt);
            }
        });
        jBtnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIniciarSesionActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Usuario");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Contraseña");

        txt_clave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_claveKeyTyped(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/UltraFibra.png"))); // NOI18N
        jLabel4.setToolTipText("");

        jChkRecordar.setText("Recordar usuario y contraseña");
        jChkRecordar.setContentAreaFilled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(txt_clave)
                        .addComponent(txt_usuario)
                        .addComponent(jBtnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jChkRecordar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_clave, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jChkRecordar)
                .addGap(31, 31, 31)
                .addComponent(jBtnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 370, 480));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIniciarSesionActionPerformed
        login();
    }//GEN-LAST:event_jBtnIniciarSesionActionPerformed

    private void txt_claveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_claveKeyTyped
        char cTeclaPresionada = evt.getKeyChar();

        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            jBtnIniciarSesion.doClick();
        }
    }//GEN-LAST:event_txt_claveKeyTyped

    private void jBtnIniciarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnIniciarSesionMouseEntered
        jBtnIniciarSesion.setBackground(new Color(0, 51, 185));
    }//GEN-LAST:event_jBtnIniciarSesionMouseEntered

    private void jBtnIniciarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnIniciarSesionMouseExited
        jBtnIniciarSesion.setBackground(new Color(0, 51, 153));
    }//GEN-LAST:event_jBtnIniciarSesionMouseExited

    /**
     * Metodo principal (Main) para la ejecucion de la aplicacion Se ejecutan
     * los hilos correspondientes
     *
     * @param args
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Frm_Login().setVisible(true); // Ejecucion de la APP en el ejecutable principal
            }
        });
//
//        Cls_CrearAlertas alerta = new Cls_CrearAlertas(); // Instanciamos la clase para crear alertas
//
//        // Creamos un Ejecutable (Runable) que se ejecutara a la par del principal para mostrar las alertas cuando corresponda
//        Runnable runnable;
//        runnable = new Runnable() {
//
//            Frm_Login L = new Frm_Login();
//            Icon iconoAlerta = L.getIconoAlerta();
//
//            @Override
//            public void run() {
//                while (true) {
//                    // hacemos un ciclo infinito
//                    try {
//                        // realizamos las alertas
//                        alerta.mostrarAlerta(this.iconoAlerta);
//                        //hacemos que el hilo duerma
//                        Thread.sleep(10000000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//        // Creamos el hilo y le pasamos el runnable
//        Thread hilo = new Thread(runnable);
//        hilo.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnIniciarSesion;
    private javax.swing.JCheckBox jChkRecordar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txt_clave;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
