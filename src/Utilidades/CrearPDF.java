package Utilidades;

/*
@author Lorenzatti Nazareno
@version 1.0
nl.loragro@gmail.com
 */

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.JTable;

// Clase para crear PDF con datos de entrada, Salida, Inventario

public class CrearPDF extends CrearRemitoPDF{
    
    public CrearPDF (JTable tabla, String nombreRegistro, String directorio){
        super(tabla, nombreRegistro, directorio);
    }    
    
     public void crearPdf(JTable jTable) {
        try {

            File path = new File(this.nombreArchivo);
            
            // Si el archivo existe le cambia el nombre para que no se reemplace
            if (path.exists()) {
                this.nombreArchivo = this.directorio + this.nombreRegistro + "(" + this.count++ + ")" + ".pdf";
            }

            // Creamos el documento e indicamos el nombre del fichero.
            try {
                PdfWriter.getInstance(documento, new FileOutputStream(this.nombreArchivo));
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("No se encontró el fichero para generar el pdf" + fileNotFoundException);
            }
            documento.open();
            
            
            // Añadimos los metadatos del PDF
            documento.addTitle("Control De stock - Megalink SRL");
            documento.addAuthor("nazareno Lorenzatti");
            documento.addCreator("Nazareno Lorenzatti");

            //obtenemos la fecha actual
            this.fecha = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
            String strFecha = this.fecha.format(formatter); // le damos el formato y la convertimos a string

            Paragraph fa = new Paragraph(strFecha); // creamos el titulo con la fecha
            fa.setAlignment(2);
            fa.setFont(this.fuenteTabla);

            documento.add(fa);
            documento.add(Chunk.NEWLINE); //SALTO DE LINEA
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);

            // Creamos la tabla
            PdfPTable tabla = new PdfPTable(jTable.getColumnCount());

            // Ahora llenamos las filas de PdfPTable
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
            JOptionPane.showMessageDialog(this.inv, "The file not exists (Se ha producido un error al generar un documento): " + documentException,"ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }
}
