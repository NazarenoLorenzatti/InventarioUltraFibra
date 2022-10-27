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

public class Cls_ComentarioEntrada {

    private PreparedStatement PS;
    private ResultSet RS;
    private final Conectar CN;
    private DefaultComboBoxModel DCB;
    private final String SQL_INSERT_COMENTARIO = "INSERT INTO comentarios (comentario) values (?)";
    private final String SQL_SELECT_COMENTARIO = "SELECT comentario FROM comentarios";
    private DefaultTableModel DT;

    public Cls_ComentarioEntrada() {
        PS = null;
        CN = new Conectar();
    }

    public int registrarComentario(String comentario) {
        int res = 0;
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT_COMENTARIO);
            PS.setString(1, comentario);            
            res = PS.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el Comentario.");
            System.err.println("Error al registrar el comentario." + e.getMessage());
        } finally {
            PS = null;
            CN.desconectar();
        }
        return res;
    }
    
    public void eliminarComentario(String comentario){
        String SQL_ELIMINAR = "DELETE FROM comentarios WHERE comentario='" + comentario + "'";
        int res = 0;
        try {
            PS = CN.getConnection().prepareStatement(SQL_ELIMINAR);
            res = PS.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "comentario eliminado con éxito");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No es posible eliminar El comentario");
            System.err.println("Error al eliminar comentario." + e.getMessage());
        } finally {
            PS = null;
            CN.desconectar();
        }
    }
    
    // Setear combo box con los comentarios
    public DefaultComboBoxModel setComboBox() {
        DCB = new DefaultComboBoxModel();
        DCB.addElement("Seleccione el comentario");

        try {

            PS = CN.getConnection().prepareStatement(SQL_SELECT_COMENTARIO);
            RS = PS.executeQuery();
            
            while (RS.next()) {
                DCB.addElement(RS.getString("comentario"));
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
        DT.addColumn("Comentarios");

        try {
            PS = CN.getConnection().prepareStatement(SQL_SELECT_COMENTARIO);
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
