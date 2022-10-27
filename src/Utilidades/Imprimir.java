package Utilidades;

/*
@author Lorenzatti Nazareno
@version 1.0
nl.loragro@gmail.com
 */

import java.awt.print.PrinterException;
import java.text.MessageFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;

// Clase para Imprimir, No se usa

public class Imprimir {

    public Imprimir() {
        
    }
    
    public void imprimirTabla(JTable jTable, String header, String footer, boolean showPrintDialog) {

        boolean fitWidth = true;
        boolean interactive = true;

        // Definimos el modo de impresión
        JTable.PrintMode mode = fitWidth ? JTable.PrintMode.FIT_WIDTH : JTable.PrintMode.NORMAL;
        try {
            //Imprimo la tabla             
            boolean complete = jTable.print(mode,
                    new MessageFormat(header),
                    new MessageFormat(footer),
                    showPrintDialog,
                    null,
                    interactive);
            if (complete) {                
                JOptionPane.showMessageDialog(jTable,"Print complete (Impresión completa)","Print result (Resultado de la impresión)",JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Mostramos un mensaje indicando que la impresión fue cancelada                 
                JOptionPane.showMessageDialog(jTable,"Print canceled (Impresión cancelada)","Print result (Resultado de la impresión)",JOptionPane.WARNING_MESSAGE);
            }
        } catch (PrinterException pe) {
            JOptionPane.showMessageDialog(jTable,
                    "Print fail (Fallo de impresión): " + pe.getMessage(),"Print result (Resultado de la impresión)",JOptionPane.ERROR_MESSAGE);
        }
    }

}
