package Clases;

/*
@author Lorenzatti Nazareno
@version 1.0
nl.loragro@gmail.com
 */
import Conexion.Conectar;
import Utilidades.DatosPDF;
import Utilidades.GuardarPDF;
import Utilidades.TablaPDF;
import java.awt.Color;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//Clase para crear remitos con las salidas realizadas Filtrando por Tecnico y fecha
public class Cls_Remito {

    private GuardarPDF gpdf;
    private PreparedStatement PS;
    private ResultSet RS;
    private final Conectar CN;
    private DefaultTableModel DT;
    private ImageIcon icono = null;

    public Cls_Remito() {
        PS = null;
        CN = new Conectar();
        this.gpdf = new GuardarPDF();
    }

    private DefaultTableModel setTitulosSalida() {
        DT = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        DT.addColumn("Fecha");
        DT.addColumn("Código de Producto");
        DT.addColumn("Descripción");
        DT.addColumn("Cantidad");
        DT.addColumn("Tecnico");
        return DT;
    }

    public DefaultTableModel getDatosRemito(Date fechaInicio, Date fechaFin, String nombreTecnico) {
        String SQL = "SELECT sal_fecha, sal_pro_codigo, pro_descripcion, sal_cantidad, nombre_tecnico FROM salida INNER JOIN producto ON sal_pro_codigo = pro_codigo WHERE sal_fecha>='" + fechaInicio + "' AND sal_fecha<='" + fechaFin + "' AND nombre_tecnico='" + nombreTecnico + "'";
        try {
            setTitulosSalida();
            PS = CN.getConnection().prepareStatement(SQL);
            RS = PS.executeQuery();
            Object[] fila = new Object[5];
            while (RS.next()) {
                fila[0] = RS.getDate(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getInt(4);
                fila[4] = RS.getString(5);
                DT.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar su consulta.");
            System.err.println("Error al listar los datos." + e.getMessage());
        } finally {
            PS = null;
            RS = null;
            CN.desconectar();
        }
        return DT;
    }

    //  Metodo para buscar los remitos por rango de fecha y tecnico y visualizarlos en la tabla. 
    public ArrayList<DatosPDF> getRemitos(Date fechaInicio, Date fechaFin, String nombreTecnico) {
        String SQL = "SELECT remito_numero, remito_fecha, remito_tecnico, remito_pdf FROM remitos WHERE remito_fecha>='" + fechaInicio + "' AND remito_fecha<='" + fechaFin + "' AND remito_tecnico='" + nombreTecnico + "'";
        ArrayList<DatosPDF> list = new ArrayList<DatosPDF>();
        try {
            PS = CN.getConnection().prepareStatement(SQL);
            RS = PS.executeQuery();

            while (RS.next()) {
                DatosPDF dPDF = new DatosPDF();
                dPDF.setCodigopdf(RS.getString(1));
                dPDF.setFecha(RS.getDate(2));
                dPDF.setTecnico(RS.getString(3));
                dPDF.setArchivopdf(RS.getBytes(4));
                list.add(dPDF);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar su consulta.");
            System.err.println("Error al listar los datos." + e.getMessage());
        } finally {
            PS = null;
            RS = null;
            CN.desconectar();
        }
        return list;
    }
    
    // Metodo que trae al buscador el remito segun corresponda el numero de remito
     public ArrayList<DatosPDF> getRemitos(String nroRemito) {
        String SQL = "SELECT remito_numero, remito_fecha, remito_tecnico, remito_pdf FROM remitos WHERE remito_numero ='" + nroRemito + "'";
        ArrayList<DatosPDF> list = new ArrayList<DatosPDF>();
        try {
            PS = CN.getConnection().prepareStatement(SQL);
            RS = PS.executeQuery();

            while (RS.next()) {
                DatosPDF dPDF = new DatosPDF();
                dPDF.setCodigopdf(RS.getString(1));
                dPDF.setFecha(RS.getDate(2));
                dPDF.setTecnico(RS.getString(3));
                dPDF.setArchivopdf(RS.getBytes(4));
                list.add(dPDF);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar su consulta.");
            System.err.println("Error al listar los datos." + e.getMessage());
        } finally {
            PS = null;
            RS = null;
            CN.desconectar();
        }
        return list;
    }
     
     // Metodo para traer todos los remitos al buscador
          public ArrayList<DatosPDF> getRemitos() {
        String SQL = "SELECT remito_numero, remito_fecha, remito_tecnico, remito_pdf FROM remitos";
        ArrayList<DatosPDF> list = new ArrayList<DatosPDF>();
        try {
            PS = CN.getConnection().prepareStatement(SQL);
            RS = PS.executeQuery();

            while (RS.next()) {
                DatosPDF dPDF = new DatosPDF();
                dPDF.setCodigopdf(RS.getString(1));
                dPDF.setFecha(RS.getDate(2));
                dPDF.setTecnico(RS.getString(3));
                dPDF.setArchivopdf(RS.getBytes(4));
                list.add(dPDF);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar su consulta.");
            System.err.println("Error al listar los datos." + e.getMessage());
        } finally {
            PS = null;
            RS = null;
            CN.desconectar();
        }
        return list;
    }

          // Visualiza los remitos en la Jtable, segun el rango de fecha y tecnico seleccionado
    public void visualizarDatosPDF(Date fechaInicio, Date fechaFin, String nombreTecnico, JTable tabla) {
        tabla.setDefaultRenderer(Object.class, new TablaPDF());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("codigopdf");
        dt.addColumn("nombrepdf");
        dt.addColumn("archivopdf");
        dt.addColumn("archivopdf");

        ImageIcon icono = null;
        if (get_Image("/Multimedia/PdfTabla.png") != null) {
            icono = new ImageIcon(get_Image("/Multimedia/PdfTabla.png"));
        }

        DatosPDF dPDF = new DatosPDF();
        ArrayList<DatosPDF> list = getRemitos(fechaInicio, fechaFin, nombreTecnico);
        
        JButton jb = new JButton(icono);
        jb.setBorderPainted(false);
        jb.setSize(30, 30);
        jb.setContentAreaFilled(false);
        jb.setBackground(Color.white);

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[4];
                dPDF = list.get(i);
                fila[0] = dPDF.getCodigopdf();
                fila[1] = dPDF.getFecha();
                fila[2] = dPDF.getTecnico();

                if (dPDF.getArchivopdf() != null) {
                    fila[3] = jb;
                } else {
                    fila[3] = "Vacio";
                }

                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(45);
        }
    }
    
    //visualiza el remito que coincida con el numero de remito en la Jtable
    public void visualizarDatosPDF(String nroRemito, JTable tabla) {
        tabla.setDefaultRenderer(Object.class, new TablaPDF());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("codigopdf");
        dt.addColumn("nombrepdf");
        dt.addColumn("archivopdf");
        dt.addColumn("archivopdf");

        ImageIcon icono = null;
        if (get_Image("/Multimedia/PdfTabla.png") != null) {
            icono = new ImageIcon(get_Image("/Multimedia/PdfTabla.png"));
        }
        
        JButton jb = new JButton(icono);
        jb.setBorderPainted(false);
        jb.setSize(10, 10);
        jb.setContentAreaFilled(false);
        jb.setBackground(Color.white);

        DatosPDF dPDF = new DatosPDF();
        ArrayList<DatosPDF> list = getRemitos(nroRemito);

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[4];
                dPDF = list.get(i);
                fila[0] = dPDF.getCodigopdf();
                fila[1] = dPDF.getFecha();
                fila[2] = dPDF.getTecnico();

                if (dPDF.getArchivopdf() != null) {
                    fila[3] = jb;
                } else {
                    fila[3] = "Vacio";
                }
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(45);            
        }
    }
    
    // Visualiza todos los remitos en la Jtable
    public void visualizarDatosPDF(JTable tabla) {
        tabla.setDefaultRenderer(Object.class, new TablaPDF());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("codigopdf");
        dt.addColumn("nombrepdf");
        dt.addColumn("archivopdf");
        dt.addColumn("archivopdf");

        ImageIcon icono = null;
        if (get_Image("/Multimedia/PdfTabla.png") != null) {
            icono = new ImageIcon(get_Image("/Multimedia/PdfTabla.png"));
        }
        
        JButton jb = new JButton(icono);
        jb.setBorderPainted(false);
        jb.setSize(10, 10);
        jb.setContentAreaFilled(false);
        jb.setBackground(Color.white);

        DatosPDF dPDF = new DatosPDF();
        ArrayList<DatosPDF> list = getRemitos();

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[4];
                dPDF = list.get(i);
                fila[0] = dPDF.getCodigopdf();
                fila[1] = dPDF.getFecha();
                fila[2] = dPDF.getTecnico();

                if (dPDF.getArchivopdf() != null) {
                    fila[3] = jb;
                } else {
                    fila[3] = "Vacio";
                }
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(45);            
        }
    }


    public Image get_Image(String ruta) {
        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(ruta));
            Image mainIcon = imageIcon.getImage();
            return mainIcon;
        } catch (Exception e) {
        }
        return null;
    }

    //Permite mostrar PDF contenido en la base de datos
    public void ejecutar_archivoPDF(String directorio, String nroRemito) throws SQLException {
        byte[] b = null;
        try {
            PS = CN.getConnection().prepareStatement("SELECT remito_pdf FROM remitos WHERE remito_numero = '" + nroRemito + "'");
            RS = PS.executeQuery();
            while (RS.next()) {
                b = RS.getBytes(1);
            }
            InputStream bos = new ByteArrayInputStream(b);

            int tamanoInput = bos.available();
            byte[] datosPDF = new byte[tamanoInput];
            bos.read(datosPDF, 0, tamanoInput);

            OutputStream out = new FileOutputStream(directorio+System.getProperty("file.separator")+nroRemito + ".pdf");
            out.write(datosPDF);

            //abrir archivo
            out.close();
            bos.close();

        } catch (IOException | NumberFormatException | SQLException ex) {
            System.out.println("Error al abrir archivo PDF " + ex.getMessage());
        } finally {
            PS.close();
            RS.close();
            CN.desconectar();
        }
    }

}
