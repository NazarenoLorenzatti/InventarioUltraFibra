package Clases;

/*
@author Lorenzatti Nazareno
@version 1.0
nl.loragro@gmail.com
*/


import Conexion.Conectar;
import java.awt.Color;
import java.sql.*;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

// Clase para crear alertas de bajo stock, se guardan en la base de datos

public class Cls_CrearAlertas {

    private PreparedStatement PS;
    private ResultSet RS;
    private final Conectar CN;
    private DefaultTableModel DT;
    private UIManager ui;
    
    private final String SQL_SELECT_PRODUCTOS = "SELECT pro_codigo, pro_descripcion, inv_stock FROM producto INNER JOIN inventario ON pro_codigo = inv_pro_codigo ORDER BY pro_codigo ASC";
    private final String SQL_INSERT_ALERTAS = "INSERT INTO alertas (ale_pro_codigo,cantidad_minima,ale_des) values (?,?,?)";
    private final String SQL_SELECT_ALERTAS2 = "SELECT ale_pro_codigo, ale_des, cantidad_minima FROM alertas";

    public Cls_CrearAlertas() {
        PS = null;
        CN = new Conectar();
    }

    private DefaultTableModel setTitulosProductos() {
        DT = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        DT.addColumn("Código");
        DT.addColumn("Descripción");
        DT.addColumn("Stock Actual");

        return DT;
    }

    public DefaultTableModel getDatosProductos() {
        try {
            setTitulosProductos();
            PS = CN.getConnection().prepareStatement(SQL_SELECT_PRODUCTOS);
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

    public DefaultTableModel getDato(int crt, String inf) {
        String SQL;
        if (crt == 2) {
            SQL = "SELECT pro_codigo, pro_descripcion, inv_stock FROM producto INNER JOIN inventario ON pro_codigo = inv_pro_codigo where pro_codigo like '" + inf + "'";
        } else {
            SQL = "SELECT pro_codigo, pro_descripcion, inv_stock FROM producto INNER JOIN inventario ON pro_codigo = inv_pro_codigo where pro_descripcion like '" + inf + "%'";
        }
        try {
            setTitulosProductos();
            PS = CN.getConnection().prepareStatement(SQL);
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

    public void crearAlerta(String codigo, int cant, String descripcion) {
        int res = 0;
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT_ALERTAS);
            PS.setString(1, codigo);
            PS.setInt(2, cant);
            PS.setString(3, descripcion);
            res = PS.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Alerta Creada");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo crear la alerta.");
            System.err.println("Error al registrar la entrada." + e.getMessage());
        } finally {
            PS = null;
            CN.desconectar();
        }
    }

    public void mostrarAlerta(Icon icono) {
        String SQL_SELECT_CANTIDAD = "SELECT ale_pro_codigo, ale_des, cantidad_minima, inv_stock FROM alertas INNER JOIN inventario ON ale_pro_codigo = inv_pro_codigo";
        try {
            PS = CN.getConnection().prepareStatement(SQL_SELECT_CANTIDAD);
            RS = PS.executeQuery();
            while (RS.next()) {
                String ale_pro_codigo = RS.getString(1);
                String ale_des = RS.getString(2);
                int cantidad_minima = RS.getInt(3);
                int inv_stock = RS.getInt(4);

                if (cantidad_minima > inv_stock) {
                    this.ui = null;
                    ui.put("OptionPane.background", new Color(222,31,33));
                    ui.put("Panel.background", new Color(255,255,255));
                    JOptionPane.showMessageDialog(null, "El producto " + ale_des + " codigo: " + ale_pro_codigo + " Tiene poco Stock     ", "Alerta", JOptionPane.PLAIN_MESSAGE, icono);
                }

            }
        } catch (SQLException e) {
            System.err.println("Error al Mostrar La alerta." + e.getMessage());
        } finally {
            PS = null;
            RS = null;
            CN.desconectar();
        }
    }

    private DefaultTableModel setTitulosAlertas() {
        DT = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        DT.addColumn("Código");
        DT.addColumn("Descripción");
        DT.addColumn("Cantidad Minima");

        return DT;
    }

    public TableModel getAlertas() {
        try {
            setTitulosAlertas();
            PS = CN.getConnection().prepareStatement(SQL_SELECT_ALERTAS2);
            RS = PS.executeQuery();
            Object[] fila = new Object[4];
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

    public void eliminarAlerta(String cod) {
        String SQL_DELETE_ALERTA = "DELETE FROM alertas WHERE ale_pro_codigo='" + cod + "'";
        int res = 0;
        try {
            PS = CN.getConnection().prepareStatement(SQL_DELETE_ALERTA);
            res = PS.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Alerta eliminado con éxito");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No es posible eliminar La Alerta.");
            System.err.println("Error al eliminar Alerta." + e.getMessage());
        } finally {
            PS = null;
            CN.desconectar();
        }
    }

}
