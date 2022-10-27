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

public class Cls_Tecnico {

    private PreparedStatement PS;
    private ResultSet RS;
    private final Conectar CN;
    private DefaultComboBoxModel DCB;
    private final String SQL_INSERT_TECNICO = "INSERT INTO tecnicos (nombre_tecnico) values (?)";
    private final String SQL_SELECT_TECNICO = "SELECT nombre_tecnico FROM tecnicos";
    private DefaultTableModel DT;

    public Cls_Tecnico() {
        PS = null;
        CN = new Conectar();
    }

    public int registrarTecnico(String nombreCompleto) {
        int res = 0;
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT_TECNICO);
            PS.setString(1, nombreCompleto);            
            res = PS.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el tecnico.");
            System.err.println("Error al registrar la salida." + e.getMessage());
        } finally {
            PS = null;
            CN.desconectar();
        }
        return res;
    }
    
    public void eliminarTecnico(String nombreCompleto){
        String SQL_ELIMINAR = "DELETE FROM tecnicos WHERE nombre_tecnico='" + nombreCompleto + "'";
        int res = 0;
        try {
            PS = CN.getConnection().prepareStatement(SQL_ELIMINAR);
            res = PS.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Tecnico eliminado con éxito");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No es posible eliminar El tecnico");
            System.err.println("Error al eliminar Tecnico." + e.getMessage());
        } finally {
            PS = null;
            CN.desconectar();
        }
    }
    
    // Setear combo box con los nombres de los tecnicos de la empresa
    public DefaultComboBoxModel setComboBox() {
        DCB = new DefaultComboBoxModel();
        DCB.addElement("Seleccione el Tecnico");

        try {

            PS = CN.getConnection().prepareStatement(SQL_SELECT_TECNICO);
            RS = PS.executeQuery();
            
            while (RS.next()) {
                DCB.addElement(RS.getString("nombre_tecnico"));
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
    
    // Listar todas los comentarios para poder eliminarlos 
       public DefaultTableModel listaComentarios() {
        DT = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        DT.addColumn("Tecnicos Registrados");

        try {
            PS = CN.getConnection().prepareStatement(SQL_SELECT_TECNICO);
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
    

}
