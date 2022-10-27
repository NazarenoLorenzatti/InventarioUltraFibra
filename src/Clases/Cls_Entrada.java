package Clases;

/*
@author Lorenzatti Nazareno
@version 1.0
nl.loragro@gmail.com
*/

import Conexion.Conectar;
import java.sql.*;
import java.time.LocalDate;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

// clase para el registro de las entradas de productos

public class Cls_Entrada {

    private PreparedStatement PS;
    private ResultSet RS;
    private final Conectar CN;
    private DefaultTableModel DT;
    private DefaultComboBoxModel DCB;
    private final String SQL_INSERT_ENTRADA = "INSERT INTO entrada (ent_pro_codigo, ent_cantidad, ent_usuario, ent_fecha,ent_comentario) values (?,?,?,?,?)";
    private final String SQL_SELECT_ENTRADA = "SELECT ent_pro_codigo, pro_descripcion, ent_cantidad, ent_usuario, ent_fecha,ent_comentario FROM entrada INNER JOIN producto ON ent_pro_codigo = pro_codigo";

    public Cls_Entrada() {
        PS = null;
        CN = new Conectar();
    }

    private DefaultTableModel setTitulosEntrada() {
        DT = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        DT.addColumn("Código de Producto");
        DT.addColumn("Descripción");
        DT.addColumn("Cantidad");
        DT.addColumn("Usuario");
        DT.addColumn("Fecha");
        DT.addColumn("Comentario");
        return DT;
    }

    public DefaultTableModel getDatosEntradas() {
        try {
            setTitulosEntrada();
            PS = CN.getConnection().prepareStatement(SQL_SELECT_ENTRADA);
            RS = PS.executeQuery();
            Object[] fila = new Object[6];
            while (RS.next()) {
                fila[0] = RS.getString(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getInt(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getDate(5);
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

    public int registrarEntrada(String codigo, int cantidad, String usuario, Date fecha, String comentario) {
        int res = 0;

        try {
            int cantidadNueva;
            int cantAux = 0;
            boolean flag = false;

            PS = CN.getConnection().prepareStatement(this.SQL_SELECT_ENTRADA);
            RS = PS.executeQuery();
            Object[] fila = new Object[6];

            while (RS.next()) {
                fila[0] = RS.getString(1); // codigo
                fila[1] = RS.getString(2); // descripcion
                fila[2] = RS.getInt(3); // cantidad
                fila[3] = RS.getString(4); // usuario
                fila[4] = RS.getDate(5);  // fecha
                fila[5] = RS.getString(6); // comentario

                Date fecha2 = RS.getDate(5);

                LocalDate fechaIngresada = fecha.toLocalDate(); // para poder comparar hay que pasar SQL date a LocalDate
                LocalDate fechaDB = fecha2.toLocalDate();

                // Comparamos primero que las fechas son iguales, si las fechas son iguales despues se hacen las demas comparaciones
                if (fechaDB.equals(fechaIngresada)) {
                    if (fila[0].equals(codigo) && fila[3].equals(usuario) && fila[5].equals(comentario)) {
                        cantAux = (int) fila[2];
                        flag = true;
                        break;
                    }
                }

            }

            if (flag) { // si el usuario fecha comentario y codigo coincidieron ejecuta un update sino una entrada nueva
                cantidadNueva = cantAux + cantidad;
                String SQL = "UPDATE entrada SET ent_cantidad='" + cantidadNueva + "' WHERE ent_pro_codigo='" + codigo + "' AND ent_usuario='" + usuario + "' AND ent_fecha='" + fecha + "' AND ent_comentario='" + comentario + "'";
                PS = CN.getConnection().prepareStatement(SQL);
                res = PS.executeUpdate();

            } else {

                PS = CN.getConnection().prepareStatement(SQL_INSERT_ENTRADA);
                PS.setString(1, codigo);
                PS.setInt(2, cantidad);
                PS.setString(3, usuario);
                PS.setDate(4, fecha);
                PS.setString(5, comentario);
                res = PS.executeUpdate();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar la Entrada.");
            System.err.println("Error al registrar la Entrada." + e.getMessage());
        } finally {
            PS = null;
            CN.desconectar();
        }
        return res;
    }

    public String seleccionDescripcion(String codigo) {
        String SQL = "SELECT pro_descripcion FROM producto WHERE" + codigo + "=pro_codigo";
        String des = null;
        try {
            setTitulosEntrada();
            PS = CN.getConnection().prepareStatement(SQL);
            RS = PS.executeQuery();
            des = RS.getString(2);

        } catch (SQLException e) {
            System.err.println("Error al tomar la descripcion." + e.getMessage());
        } finally {
            PS = null;
            RS = null;
            CN.desconectar();
        }
        return des;
    }
       
}
