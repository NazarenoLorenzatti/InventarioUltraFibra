package Formularios;

/*
@author Lorenzatti Nazareno
@version 1.0
nl.loragro@gmail.com
 */
import Clases.Cls_CrearAlertas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import FiveCodMover.FiveCodMoverJFrame;
import javax.swing.Icon;
import javax.swing.ImageIcon;

// Formulario principal que hace de contenedor de los demas formularios. 
public class Frm_Principal extends javax.swing.JFrame {

    public ImageIcon iconoAlerta;

    public Frm_Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        txt_menu.requestFocus();
        this.setResizable(true);

        Cls_CrearAlertas alerta = new Cls_CrearAlertas(); // Instanciamos la clase para crear alertas

        // Creamos un Ejecutable (Runable) que se ejecutara a la par del principal para mostrar las alertas cuando corresponda
        Runnable runnable = new Runnable() {

            @Override
            public void run() {

//                ImageIcon imgIcon = (ImageIcon) jLabel4.getIcon();
                Image imagenAlerta = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Multimedia/Alerta roja.png"));
                iconoAlerta = new ImageIcon(imagenAlerta);
                Image imgEscalada = iconoAlerta.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH);
                Icon alertaEscalado = new ImageIcon(imgEscalada);
                
                while (true) {
                    // hacemos un ciclo infinito
                    try {
                        // realizamos las alertas
                        alerta.mostrarAlerta(alertaEscalado);
                        //hacemos que el hilo duerma
                        Thread.sleep(180000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        // Creamos el hilo y le pasamos el runnable
        Thread hilo = new Thread(runnable);
        hilo.start();

    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Multimedia/Almacen.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelAlerta = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        contenedor = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_menu = new javax.swing.JLabel();
        jBtnProductos = new javax.swing.JButton();
        jBtnEntradas = new javax.swing.JButton();
        jBtnSalidas = new javax.swing.JButton();
        jBtnInventario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLblUsuario = new javax.swing.JLabel();
        jBtnRemitos = new javax.swing.JButton();
        jBtnCerrar = new javax.swing.JButton();
        jBtnMinimizar = new javax.swing.JButton();
        jBtnAlertas = new javax.swing.JButton();

        jLabelAlerta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Alerta roja.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Inventario");
        setIconImage(getIconImage());
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(1600, 900));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contenedor.setBackground(new java.awt.Color(255, 255, 255));
        contenedor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        contenedor.setToolTipText("");

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1218, Short.MAX_VALUE)
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );

        jPanel1.add(contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 1220, 720));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sistema de Inventario");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, -1, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/UltraFibra.png"))); // NOI18N
        jLabel3.setToolTipText("");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 130, 100));

        txt_menu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_menu.setForeground(new java.awt.Color(255, 255, 255));
        txt_menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_menu.setText("MENU PRINCIPAL");
        jPanel1.add(txt_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 170, -1));

        jBtnProductos.setBackground(new java.awt.Color(255, 255, 255));
        jBtnProductos.setFont(new java.awt.Font("Perpetua Titling MT", 1, 12)); // NOI18N
        jBtnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Icono Productos.png"))); // NOI18N
        jBtnProductos.setText("Productos");
        jBtnProductos.setToolTipText("");
        jBtnProductos.setBorder(null);
        jBtnProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnProductos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBtnProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBtnProductosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBtnProductosMouseExited(evt);
            }
        });
        jBtnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnProductosActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 150, 50));

        jBtnEntradas.setBackground(new java.awt.Color(255, 255, 255));
        jBtnEntradas.setFont(new java.awt.Font("Perpetua Titling MT", 1, 12)); // NOI18N
        jBtnEntradas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Entrada.png"))); // NOI18N
        jBtnEntradas.setText(" Entradas");
        jBtnEntradas.setBorder(null);
        jBtnEntradas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnEntradas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBtnEntradasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBtnEntradasMouseExited(evt);
            }
        });
        jBtnEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEntradasActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnEntradas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 150, 50));

        jBtnSalidas.setBackground(new java.awt.Color(255, 255, 255));
        jBtnSalidas.setFont(new java.awt.Font("Perpetua Titling MT", 1, 12)); // NOI18N
        jBtnSalidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Salida.png"))); // NOI18N
        jBtnSalidas.setText(" Salidas");
        jBtnSalidas.setBorder(null);
        jBtnSalidas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnSalidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBtnSalidasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBtnSalidasMouseExited(evt);
            }
        });
        jBtnSalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalidasActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnSalidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 150, 50));

        jBtnInventario.setBackground(new java.awt.Color(255, 255, 255));
        jBtnInventario.setFont(new java.awt.Font("Perpetua Titling MT", 1, 12)); // NOI18N
        jBtnInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/inventario.png"))); // NOI18N
        jBtnInventario.setText("Inventario");
        jBtnInventario.setBorder(null);
        jBtnInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBtnInventarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBtnInventarioMouseExited(evt);
            }
        });
        jBtnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnInventarioActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 150, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bienvenido");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 170, -1));

        jLblUsuario.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 14)); // NOI18N
        jLblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblUsuario.setText("Nombre del Usuario");
        jPanel1.add(jLblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 170, 30));

        jBtnRemitos.setBackground(new java.awt.Color(255, 255, 255));
        jBtnRemitos.setFont(new java.awt.Font("Perpetua Titling MT", 1, 12)); // NOI18N
        jBtnRemitos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Remito.png"))); // NOI18N
        jBtnRemitos.setText("Remitos");
        jBtnRemitos.setBorder(null);
        jBtnRemitos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnRemitos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnRemitosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBtnRemitosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBtnRemitosMouseExited(evt);
            }
        });
        jPanel1.add(jBtnRemitos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 640, 150, 50));

        jBtnCerrar.setBackground(new java.awt.Color(153, 0, 0));
        jBtnCerrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBtnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        jBtnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Cerrar Rojo.png"))); // NOI18N
        jBtnCerrar.setBorderPainted(false);
        jBtnCerrar.setContentAreaFilled(false);
        jBtnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnCerrar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/cerrar pressed.png"))); // NOI18N
        jBtnCerrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/cerrar roll.png"))); // NOI18N
        jBtnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnCerrarMouseClicked(evt);
            }
        });
        jPanel1.add(jBtnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 10, 50, 40));

        jBtnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Minimizar Celeste.png"))); // NOI18N
        jBtnMinimizar.setBorderPainted(false);
        jBtnMinimizar.setContentAreaFilled(false);
        jBtnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnMinimizar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/minimizar pressed.png"))); // NOI18N
        jBtnMinimizar.setRequestFocusEnabled(false);
        jBtnMinimizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/minimizar roll.png"))); // NOI18N
        jBtnMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnMinimizarMouseClicked(evt);
            }
        });
        jPanel1.add(jBtnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 10, 50, 40));

        jBtnAlertas.setBackground(new java.awt.Color(255, 255, 255));
        jBtnAlertas.setFont(new java.awt.Font("Perpetua Titling MT", 1, 12)); // NOI18N
        jBtnAlertas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/alerta.png"))); // NOI18N
        jBtnAlertas.setText("Alertas");
        jBtnAlertas.setBorder(null);
        jBtnAlertas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBtnAlertas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBtnAlertasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBtnAlertasMouseExited(evt);
            }
        });
        jBtnAlertas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlertasActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnAlertas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 150, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnProductosActionPerformed
        Frm_Productos f = new Frm_Productos();
        f.ocultarBarraTituloProductos();
        contenedor.add(f);
        f.show();
    }//GEN-LAST:event_jBtnProductosActionPerformed

    private void jBtnEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEntradasActionPerformed
        Frm_Entrada f = new Frm_Entrada();
        f.ocultarBarraTituloEntrada();
        contenedor.add(f);
        f.show();
    }//GEN-LAST:event_jBtnEntradasActionPerformed

    private void jBtnSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalidasActionPerformed
        Frm_Salida f = new Frm_Salida();
        f.ocultarBarraTituloSalida();
        contenedor.add(f);
        f.show();
    }//GEN-LAST:event_jBtnSalidasActionPerformed

    private void jBtnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jBtnCerrarMouseClicked

    private void jBtnMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnMinimizarMouseClicked
        this.setState(ICONIFIED);

    }//GEN-LAST:event_jBtnMinimizarMouseClicked

    private void jBtnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnInventarioActionPerformed
        Frm_Inventario f = new Frm_Inventario();
        f.ocultarBarraTituloInventario();
        contenedor.add(f);
        f.show();
    }//GEN-LAST:event_jBtnInventarioActionPerformed

    private void jBtnProductosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnProductosMouseEntered
        jBtnProductos.setBackground(new Color(67, 99, 190));
    }//GEN-LAST:event_jBtnProductosMouseEntered

    private void jBtnProductosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnProductosMouseExited
        jBtnProductos.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_jBtnProductosMouseExited

    private void jBtnEntradasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnEntradasMouseEntered
        jBtnEntradas.setBackground(new Color(67, 99, 190));
    }//GEN-LAST:event_jBtnEntradasMouseEntered

    private void jBtnSalidasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnSalidasMouseEntered
        jBtnSalidas.setBackground(new Color(67, 99, 190));
    }//GEN-LAST:event_jBtnSalidasMouseEntered

    private void jBtnInventarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnInventarioMouseEntered
        jBtnInventario.setBackground(new Color(67, 99, 190));
    }//GEN-LAST:event_jBtnInventarioMouseEntered

    private void jBtnRemitosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnRemitosMouseEntered
        jBtnRemitos.setBackground(new Color(67, 99, 190));
    }//GEN-LAST:event_jBtnRemitosMouseEntered

    private void jBtnEntradasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnEntradasMouseExited
        jBtnEntradas.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_jBtnEntradasMouseExited

    private void jBtnSalidasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnSalidasMouseExited
        jBtnSalidas.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_jBtnSalidasMouseExited

    private void jBtnInventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnInventarioMouseExited
        jBtnInventario.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_jBtnInventarioMouseExited

    private void jBtnRemitosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnRemitosMouseExited
        jBtnRemitos.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_jBtnRemitosMouseExited

    private void jBtnAlertasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnAlertasMouseEntered
        jBtnAlertas.setBackground(new Color(67, 99, 190));
    }//GEN-LAST:event_jBtnAlertasMouseEntered

    private void jBtnAlertasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnAlertasMouseExited
        jBtnAlertas.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_jBtnAlertasMouseExited

    private void jBtnAlertasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlertasActionPerformed
        Frm_CrearAlertas C = new Frm_CrearAlertas();
        C.ocultarBarraTituloCrearAlertas();
        Frm_Principal.contenedor.add(C);
        Dimension desktopSize = contenedor.getSize();
        Dimension FrameSize = C.getSize();
        C.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        C.toFront();
        C.setVisible(true);
    }//GEN-LAST:event_jBtnAlertasActionPerformed

    private void jBtnRemitosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnRemitosMouseClicked
        Frm_Remito R = new Frm_Remito();
        R.ocultarBarraTituloRemito();
        Frm_Principal.contenedor.add(R);
        Dimension desktopSize = contenedor.getSize();
        Dimension FrameSize = R.getSize();
        R.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        R.toFront();
        R.setVisible(true);
    }//GEN-LAST:event_jBtnRemitosMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        FiveCodMoverJFrame.MousePressed(evt);
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        FiveCodMoverJFrame.MouseDraggedFrame(evt, this);
    }//GEN-LAST:event_formMouseDragged

//    public static void main(String args[]) {
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Frm_Principal().setVisible(true);
//
//            }
//        });

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane contenedor;
    private javax.swing.JButton jBtnAlertas;
    private javax.swing.JButton jBtnCerrar;
    private javax.swing.JButton jBtnEntradas;
    private javax.swing.JButton jBtnInventario;
    private javax.swing.JButton jBtnMinimizar;
    private javax.swing.JButton jBtnProductos;
    private javax.swing.JButton jBtnRemitos;
    private javax.swing.JButton jBtnSalidas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabelAlerta;
    public static javax.swing.JLabel jLblUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txt_menu;
    // End of variables declaration//GEN-END:variables
}
