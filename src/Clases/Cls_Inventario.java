package Clases;

/*
@author Lorenzatti Nazareno
@version 1.0
nl.loragro@gmail.com
*/

import Conexion.Conectar;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

// Clase donde se registra el STOCK de producto tomando las entradas y salidas  de cada product, operacion que se realiza en la base 
// de datos por medio de un trigger

public class Cls_Inventario {

    private PreparedStatement PS;
    private ResultSet RS;
    private final Conectar CN;
    private DefaultTableModel DT;
    private final String SQL_SELECT_INVENTARIO = "SELECT inv_pro_codigo, pro_descripcion, inv_stock FROM inventario INNER JOIN producto ON inv_pro_codigo = pro_codigo";

    public Cls_Inventario() {
        PS = null;
        CN = new Conectar();
    }

    private DefaultTableModel setTitulosInventario() {
        DT = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        DT.addColumn("Código");
        DT.addColumn("Descripción");
        DT.addColumn("Stock");
        return DT;
    }

    public DefaultTableModel getDatosInventario() {
        try {
            setTitulosInventario();
            PS = CN.getConnection().prepareStatement(SQL_SELECT_INVENTARIO);
            RS = PS.executeQuery();
            Object[] fila = new Object[3];
            while (RS.next()) {
                fila[0] = RS.getString(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getInt(3);
                DT.addRow(fila);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar los datos." + e.getMessage());
        } finally {
            PS = null;
            RS = null;
            CN.desconectar();
        }
        return DT;
    }

}
