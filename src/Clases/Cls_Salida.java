package Clases;

/*
@author Lorenzatti Nazareno
@version 1.0
nl.loragro@gmail.com
*/

import Conexion.Conectar;
import java.sql.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

// clase para registrar las salidas de productos

public class Cls_Salida {

    private PreparedStatement PS;
    private ResultSet RS;
    private final Conectar CN;
    private DefaultTableModel DT;
    private final String SQL_INSERT_SALIDA = "INSERT INTO salida (sal_pro_codigo, sal_fecha, sal_cantidad, nombre_tecnico, sal_usuario) values (?,?,?,?,?)";
    private final String SQL_SELECT_SALIDA = "SELECT sal_fecha, sal_pro_codigo, pro_descripcion, sal_cantidad, nombre_tecnico, sal_usuario FROM salida INNER JOIN producto ON sal_pro_codigo = pro_codigo";

    public Cls_Salida() {
        PS = null;
        CN = new Conectar();
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
        DT.addColumn("Usuario");
        return DT;
    }

    public DefaultTableModel getDatosSalida() {
        try {
            setTitulosSalida();
            PS = CN.getConnection().prepareStatement(SQL_SELECT_SALIDA);
            RS = PS.executeQuery();
            Object[] fila = new Object[6];
            while (RS.next()) {
                fila[0] = RS.getDate(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getInt(4);
                fila[4] = RS.getString(5);
                fila[5] = RS.getString(6);
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

    public int registrarSalida(String codigo, java.sql.Date fecha, int cantidad, String tecnico, String usuario) {
        int res = 0;

        try {
            int cantidadNueva;
            int cantAux = 0;
            boolean flag = false;

            PS = CN.getConnection().prepareStatement(this.SQL_SELECT_SALIDA);
            RS = PS.executeQuery();
            Object[] fila = new Object[6];

            while (RS.next()) {
                fila[0] = RS.getDate(1); // Fecha que se registro la salida
                fila[1] = RS.getString(2); // codigo del producto
                fila[2] = RS.getString(3); // descripcion del producto
                fila[3] = RS.getInt(4);  // cantidad que se retiro
                fila[4] = RS.getString(5); // tecnico
                fila[5] = RS.getString(6);  // usuario

                Date fecha2 = RS.getDate(1);

                LocalDate fechaIngresada = fecha.toLocalDate(); // para poder comparar tengo que pasar SQL date a LocalDate
                LocalDate fechaDB = fecha2.toLocalDate();

                // Comparo primero que las fechas son iguales, si las fechas son iguales despues hago todas las demas comparaciones
                if (fechaDB.equals(fechaIngresada)) {
                    if (fila[1].equals(codigo) && fila[4].equals(tecnico) && fila[5].equals(usuario)) {
                        cantAux = (int) fila[3];
                        flag = true;
                        break;
                    }
                }

            }

            if (flag) { // si el usuario fecha y codigo coincidieron ejecuta un upodate sino una entrada nueva
                cantidadNueva = cantAux + cantidad;
                String SQL = "UPDATE salida SET sal_cantidad='" + cantidadNueva + "' WHERE sal_pro_codigo='" + codigo + "' AND nombre_tecnico='" + tecnico + "' AND sal_usuario='" + usuario + "' AND sal_fecha='"+fecha+"'";
                PS = CN.getConnection().prepareStatement(SQL);
                res = PS.executeUpdate();

            } else {

                PS = CN.getConnection().prepareStatement(SQL_INSERT_SALIDA);
                PS.setString(1, codigo);
                PS.setDate(2, fecha);
                PS.setInt(3, cantidad);
                PS.setString(4, tecnico);
                PS.setString(5, usuario);
                res = PS.executeUpdate();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar la salida.");
            System.err.println("Error al registrar la salida." + e.getMessage());
        } finally {
            PS = null;
            CN.desconectar();
        }
        return res;
    }

    public int verificarStock(String codigo) {
        int res = 0;
        try {
            PS = CN.getConnection().prepareStatement("SELECT inv_stock from inventario where inv_pro_codigo='" + codigo + "'");
            RS = PS.executeQuery();

            while (RS.next()) {
                res = RS.getInt(1);
            }

        } catch (SQLException e) {
            System.err.println("Error al devolver cantidad de registros." + e.getMessage());
        } finally {
            PS = null;
            CN.desconectar();
        }
        return res;
    }
}
