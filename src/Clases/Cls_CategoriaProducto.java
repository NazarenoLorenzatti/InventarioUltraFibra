package Clases;

/*
@author Lorenzatti Nazareno
@version 1.0
nl.loragro@gmail.com
 */
import Conexion.Conectar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

// Clase para registrar los tecnicos de la empresa
public class Cls_CategoriaProducto {

    private PreparedStatement PS;
    private ResultSet RS;
    private final Conectar CN;
    private DefaultComboBoxModel DCB;
    private final String SQL_INSERT_CATEGORIA = "INSERT INTO categoria (pro_categoria) values (?)";
    private final String SQL_SELECT_CATEGORIA = "SELECT pro_categoria FROM categoria";
    private DefaultTableModel DT;

    public Cls_CategoriaProducto() {
        PS = null;
        CN = new Conectar();
    }

    public int registrarCategoria(String categoria) {
        int res = 0;
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT_CATEGORIA);
            PS.setString(1, categoria);
            res = PS.executeUpdate();

        } catch (SQLException e) {
            System.out.print(e.getStackTrace());
            JOptionPane.showMessageDialog(null, "No se pudo registrar el Comentario.");
            System.err.println("Error al registrar el comentario." + e.getMessage());
        } finally {
            PS = null;
            CN.desconectar();
        }
        return res;
    }

    public void eliminarCategoria(String categoria) {
        String SQL_ELIMINAR = "DELETE FROM categoria WHERE pro_categoria='" + categoria + "'";
        int res = 0;
        try {
            PS = CN.getConnection().prepareStatement(SQL_ELIMINAR);
            res = PS.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "categoria eliminado con éxito");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No es posible eliminar El comentario");
            System.err.println("Error al eliminar comentario." + e.getMessage());
        } finally {
            PS = null;
            CN.desconectar();
        }
    }

    //listar todas las categorias creadas en una tabla para poder seleccionarlas y eliminarlas. 
    public DefaultTableModel listaCategorias() {
        DT = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        DT.addColumn("Comentarios");

        try {
            PS = CN.getConnection().prepareStatement(SQL_SELECT_CATEGORIA);
            RS = PS.executeQuery();
            Object[] fila = new Object[3];
            while (RS.next()) {
                fila[0] = RS.getString(1);
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

    // Setear combo box con los comentarios
    public DefaultComboBoxModel setComboBox() {
        DCB = new DefaultComboBoxModel();
        DCB.addElement("Seleccione la categoria");

        try {

            PS = CN.getConnection().prepareStatement(SQL_SELECT_CATEGORIA);
            RS = PS.executeQuery();

            while (RS.next()) {
                DCB.addElement(RS.getString("pro_categoria"));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar los datos." + e.getMessage());
        } finally {
            PS = null;
            RS = null;
            CN.desconectar();
        }
        return DCB;
    }

}
