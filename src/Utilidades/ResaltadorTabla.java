package Utilidades;

/*
@author Lorenzatti Nazareno
@version 1.0
nl.loragro@gmail.com
 */
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

// Clase para resaltar la tabla de inventario cuando hay bajo stock
public class ResaltadorTabla extends JTable {

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int columnIndex) {

        Component componente = super.prepareRenderer(renderer, rowIndex, columnIndex);

        if (getValueAt(rowIndex, columnIndex).getClass().equals(Integer.class)) {

            int valor = Integer.parseInt(this.getValueAt(rowIndex, columnIndex).toString());

            if (valor <= 50) {
                componente.setBackground(Color.RED);
                componente.setForeground(Color.WHITE);
            }
             if (valor > 50 && valor <= 150) {
                componente.setBackground(Color.ORANGE);
                componente.setForeground(Color.WHITE);
            }
              if (valor > 150) {
                componente.setBackground(Color.GREEN);
                componente.setForeground(Color.BLACK);
            }
        } else {
            componente.setBackground(Color.WHITE);
            componente.setForeground(Color.BLACK);
        }

        return componente;
    }

}
