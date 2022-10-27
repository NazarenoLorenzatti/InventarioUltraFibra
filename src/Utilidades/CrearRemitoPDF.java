package Utilidades;

/*
@author Lorenzatti Nazareno
@version 1.0
nl.loragro@gmail.com
 */
import Conexion.Conectar;
import Formularios.Frm_Principal;
import Formularios.Frm_Remito;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Image;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.io.IOException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

// Clase para crear los remitos de Salida
public class CrearRemitoPDF {

    // atributos para la conexion a la base de datos
    private PreparedStatement PS;
    private ResultSet RS;
    private final Conectar CN;

    // Atributos para la creacion del PDF
    protected final JTable inv;
    protected final Document documento;
    protected final Paragraph saltoDeLinea = new Paragraph("\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // Un salto de linea para ubicar la tabla ya q no se pudo setear la posicion
    protected final String directorio;
    protected final String nombreRegistro;
    private static String nombreTecnico;
    protected String nombreArchivo;
    protected LocalDate fecha;
    protected static int count = 1;
    protected static final Font fuenteTabla = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL, BaseColor.BLACK);
    private PdfWriter pdfWriter;
    private String numeroRemito = null;
    private DatosPDF dPdf;

    public CrearRemitoPDF(JTable tabla, String nombreRegistro, String directorio, String tecnico) {

        PS = null;
        CN = new Conectar();

        this.fecha = LocalDate.now();
        this.inv = tabla;
        this.nombreTecnico = tecnico;
        this.documento = new Document();
        this.nombreRegistro = getNumeroRemito() + nombreRegistro;
        this.directorio = directorio;
        this.nombreArchivo = this.directorio + System.getProperty("file.separator") + this.nombreRegistro + ".pdf";

    }

    public CrearRemitoPDF(JTable tabla, String nombreRegistro, String directorio) {

        PS = null;
        CN = new Conectar();

        this.fecha = LocalDate.now();
        this.inv = tabla;
        this.documento = new Document();
        this.nombreRegistro = getNumeroRemito() + nombreRegistro;
        this.directorio = directorio;
        this.nombreArchivo = this.directorio + System.getProperty("file.separator") + this.nombreRegistro + ".pdf";

    }

    //Metodo para ingresar un Remito en la base de dato e ir contando el numero
    public void registrarRemito(String nombreArchivo) {
        Date fecha = Date.valueOf(this.fecha);
        File path = new File(nombreArchivo);

        Date fechaSQL = Date.valueOf(this.fecha);
        this.dPdf = new DatosPDF(getNumeroRemito(), path, this.nombreTecnico, fechaSQL);
        GuardarPDF gPdf = new GuardarPDF();
        gPdf.Agregar_PdfVO(this.dPdf, fecha);
    }

    // Metodo para obtener el numero de remito desde la base de datos
    public String getNumeroRemito() {

        int contaux = 0;
        String retorno = null;

        try {
            String SQL = "SELECT Contador_remitos FROM remitos";
            PS = CN.getConnection().prepareStatement(SQL);
            RS = PS.executeQuery();

            while (RS.next()) {

                int cont = RS.getInt(1);
                cont--;
                if (cont > contaux) {
                    contaux = cont;
                }
            }

            if (contaux < 1000) {
                this.numeroRemito = "R 000-000";
                retorno = this.numeroRemito + contaux;
            }
            if (contaux < 10000) {
                this.numeroRemito = "R 000-00";
                retorno = this.numeroRemito + contaux;
            }
            if (contaux < 100000) {
                this.numeroRemito = "R 000-0";
                retorno = this.numeroRemito + contaux;
            }
            if (contaux > 100000) {
                this.numeroRemito = "R 000-";
                retorno = this.numeroRemito + contaux;
            }
            if (contaux > 1000000) {
                this.numeroRemito = "R 001-000";
                contaux = 1;
                retorno = this.numeroRemito + contaux;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar su consulta de numero de remito.");
            System.err.println("Error al listar los datos de remito." + e.getMessage());
        } finally {
            PS = null;
            RS = null;
            CN.desconectar();
        }
        return retorno;
    }

    // Metodo para crear directorios en base al mes y año en curso
    public void crearDirectorio() {
        int mesNro = fecha.getMonthValue();
        String mes = null;
        int año = fecha.getYear();

        // Elegimos el mes con un switch para que lo ponga en español
        switch (mesNro) {
            case 1:
                mes = "ENERO";
                break;
            case 2:
                mes = "FEBRERO";
                break;
            case 3:
                mes = "MARZO";
                break;
            case 4:
                mes = "ABRIL";
                break;
            case 5:
                mes = "MAYO";
                break;
            case 6:
                mes = "JUNIO";
                break;
            case 7:
                mes = "JULIO";
                break;
            case 8:
                mes = "AGOSTO";
                break;
            case 9:
                mes = "SEPTIEMBRE";
                break;
            case 10:
                mes = "OCTUBRE";
                break;
            case 11:
                mes = "NOVIEMBRE";
                break;
            case 12:
                mes = "DICIEMBRE";
                break;

        }

        File directorio = new File(this.directorio + "/" + mes + "-" + año);

        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
                this.nombreArchivo = this.directorio + System.getProperty("file.separator") + mes + "-" + año + System.getProperty("file.separator") + this.nombreRegistro + ".pdf";
            } else {
                System.out.println("Error al crear directorio");
            }
        } else {
            this.nombreArchivo = this.directorio + System.getProperty("file.separator") + mes + "-" + año + System.getProperty("file.separator") + this.nombreRegistro + ".pdf";
        }

    }

    // Metodo para crear el PDF
    public void crearPdf(JTable jTable, String numeroRemito) {
        try {

            crearDirectorio();
//            String nombreTecnico = Frm_Remito.jComboBox1.getSelectedItem().toString();
            File path = new File(this.nombreArchivo);

            // Si el archivo ya existe le cambia el nombre para q no se reemplace
            if (path.exists()) {
                this.nombreArchivo = this.directorio + System.getProperty("file.separator") + this.nombreRegistro + "(" + this.count++ + ")" + ".pdf";
            }

            // Creamos el documento e indicamos el nombre del fichero.
            try {
                this.pdfWriter = PdfWriter.getInstance(documento, new FileOutputStream(this.nombreArchivo));
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("No se encontró el fichero para generar el pdf" + fileNotFoundException);
            }

            documento.open();

            // Añadimos los metadatos del PDF
            documento.addTitle("Control De stock - Megalink SRL");
            documento.addAuthor("nazareno Lorenzatti");
            documento.addCreator("Nazareno Lorenzatti");

            documento.add(getImagen()); // Agregamos la imagen de plantilla

            FixText(numeroRemito, 445, 698, this.pdfWriter, 11); // Agregamos nro de remito

            //Formateamos la fecha actual            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
            String strFecha = this.fecha.format(formatter); // le damos el formato y la convertimos a string

            FixText(strFecha, 455, 674, this.pdfWriter, 11); // Agregamos Fecha
            FixText(nombreTecnico, 230, 620, this.pdfWriter, 12); // Agregamos Tecnico   
            FixText(Frm_Principal.jLblUsuario.getText(), 230, 598, this.pdfWriter, 12); // Agregamos Usuario

            documento.add(this.saltoDeLinea); //SALTO DE LINEA para tabla

            // Creamos la tabla
            PdfPTable tabla = new PdfPTable(jTable.getColumnCount());

            //llenamos las filas de PdfPTable
            PdfPCell columna;

            // Rellenamos las cabeceras de las columnas de la tabla.                
            for (int column = 0; column < jTable.getColumnCount(); column++) {
                columna = new PdfPCell(new Phrase(jTable.getColumnName(column)));
                columna.setHorizontalAlignment(Element.ALIGN_CENTER);
                columna.setBackgroundColor(BaseColor.GRAY);
                tabla.addCell(columna);
            }
            tabla.setHeaderRows(1);

            //  (rellenamos las filas de la tabla).                
            for (int row = 0; row < jTable.getRowCount(); row++) {
                for (int column = 0; column < jTable.getColumnCount(); column++) {
                    tabla.addCell(jTable.getValueAt(row, column).toString());
                }
            }

            documento.add(tabla);

            FixText(Frm_Remito.jTextAreaObservaciones.getText(), 65, 190, this.pdfWriter, 14); // Agregamos las observaciones

            documento.close();

            registrarRemito(this.nombreArchivo);

            JOptionPane.showMessageDialog(this.inv, "Se ha generado el PDF", "RESULTADO", JOptionPane.INFORMATION_MESSAGE);

        } catch (DocumentException documentException) {
            System.out.println("The file not exists (Se ha producido un error al generar un documento): " + documentException);
            JOptionPane.showMessageDialog(this.inv, "The file not exists (Se ha producido un error al generar un documento): " + documentException, "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    // Metodo para abrir el archivo creado
    public void abrirArchivo() {
        try {
            File path = new File(this.nombreArchivo);
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "no se pudo abrir el archivo", 2);
        }
    }

    // Metodo para obtener la imagen de plantilla desde la base de datos.
    public Image getImagen() {
        Image img = null;
        try {
            java.awt.Image awtImage = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Multimedia/Plantilla Remito.jpg"));
            img = com.itextpdf.text.Image.getInstance(awtImage, null);
            img.scaleAbsolute(600, 850);
            img.setAbsolutePosition(1, 1);
//        Image img = null;
//        try {
//            String SQL = "SELECT * FROM imagen";
//            PS = CN.getConnection().prepareStatement(SQL);
//            RS = PS.executeQuery();
//            while (RS.next()) {
//                byte[] bi = RS.getBytes(3);
//                img = Image.getInstance(bi);
//                img.scaleAbsolute(600, 850);
//                img.setAbsolutePosition(1, 1);
//            }
//        } catch (BadElementException | IOException | SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error Al obtener la imagen");
//            System.out.println(ex.getMessage());
//        } finally {
//
//            PS = null;
//            RS = null;
//            CN.desconectar();
//        }

        } catch (BadElementException ex) {
            Logger.getLogger(CrearRemitoPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CrearRemitoPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        return img;
    }

    // Metodo para setear la posicion absoluta de los textos. 
    private static void FixText(String text, int x, int y, PdfWriter writer, int size) {
        try {
            PdfContentByte cb = writer.getDirectContent();
            BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
            cb.saveState();
            cb.beginText();
            cb.moveText(x, y);
            cb.setFontAndSize(bf, size);
            cb.showText(text);
            cb.endText();
            cb.restoreState();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    // Metodo para crear el PDF
    public void crearPdfInventario(JTable jTable, String nombre, String fecha) {
        try {
            this.nombreArchivo = this.directorio + System.getProperty("file.separator") + nombre + fecha + ".pdf";
//            String nombreTecnico = Frm_Remito.jComboBox1.getSelectedItem().toString();
            File path = new File(this.nombreArchivo);

            // Si el archivo ya existe le cambia el nombre para q no se reemplace
            if (path.exists()) {
                this.nombreArchivo = this.directorio + System.getProperty("file.separator") + nombre + fecha + "(" + this.count++ + ")" + ".pdf";
            }

            // Creamos el documento e indicamos el nombre del fichero.
            try {
                this.pdfWriter = PdfWriter.getInstance(documento, new FileOutputStream(this.nombreArchivo));
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("No se encontró el fichero para generar el pdf" + fileNotFoundException);
            }

            documento.open();

            // Añadimos los metadatos del PDF
            documento.addTitle("Control De stock - Megalink SRL");
            documento.addAuthor("nazareno Lorenzatti");
            documento.addCreator("Nazareno Lorenzatti");

            documento.add(getImagen()); // Agregamos la imagen de plantilla

            FixText("STOCK", 445, 698, this.pdfWriter, 11); // Agregamos nro de remito

            //Formateamos la fecha actual            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
            String strFecha = this.fecha.format(formatter); // le damos el formato y la convertimos a string

            FixText(strFecha, 455, 674, this.pdfWriter, 11); // Agregamos Fecha
            FixText(nombreTecnico, 230, 620, this.pdfWriter, 12); // Agregamos Tecnico   
            FixText(Frm_Principal.jLblUsuario.getText(), 230, 598, this.pdfWriter, 12); // Agregamos Usuario

            documento.add(this.saltoDeLinea); //SALTO DE LINEA para tabla

            // Creamos la tabla
            PdfPTable tabla = new PdfPTable(jTable.getColumnCount());
            

            //llenamos las filas de PdfPTable
            PdfPCell columna;

            // Rellenamos las cabeceras de las columnas de la tabla.                
            for (int column = 0; column < jTable.getColumnCount(); column++) {
                columna = new PdfPCell(new Phrase(jTable.getColumnName(column)));
                columna.setHorizontalAlignment(Element.ALIGN_CENTER);
                columna.setBackgroundColor(BaseColor.GRAY);
                tabla.addCell(columna);
            }
            tabla.setHeaderRows(1);

            //  (rellenamos las filas de la tabla).                
            for (int row = 0; row < jTable.getRowCount(); row++) {
                for (int column = 0; column < jTable.getColumnCount(); column++) {
                    tabla.addCell(jTable.getValueAt(row, column).toString());
                }
            }

            documento.add(tabla);

            documento.close();
            JOptionPane.showMessageDialog(this.inv, "Se ha generado el PDF", "RESULTADO", JOptionPane.INFORMATION_MESSAGE);

        } catch (DocumentException documentException) {
            System.out.println("The file not exists (Se ha producido un error al generar un documento): " + documentException);
            JOptionPane.showMessageDialog(this.inv, "The file not exists (Se ha producido un error al generar un documento): " + documentException, "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

}
