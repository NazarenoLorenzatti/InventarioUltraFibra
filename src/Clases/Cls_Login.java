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
import javax.swing.JOptionPane;

// clase para el control del login de usuarios registrados. Los usuarios registrados se guardan en la bbdd

public class Cls_Login {

    private PreparedStatement PS;
    private ResultSet RS;
    private final Conectar CN;
    private static String u;
    private static String p;
    private static String nombre;

    public Cls_Login(String user, String pass) {
        PS = null;
        CN = new Conectar();
        this.u = user;
        this.p = pass;
    }

    //Si el usuario y contraseña que se ingresa al momento de instanciar la clase coinciden con lo obtenido de la base de datos
    // entonces el metodo deuelve true. 
    public boolean getLogin() {
        boolean ret = false;
        try {

            PS = CN.getConnection().prepareStatement("SELECT * FROM usuarios");
            RS = PS.executeQuery();

            while (RS.next()) {
                String user = RS.getString(2);
                String pass = RS.getString(3);

                if (user.equals(this.u) && pass.equals(this.p)) {
                    ret = true;
                    this.nombre = RS.getString("nombre_usuarios");
                    break;
                }                     
                
            }

        } catch (SQLException e) {
            System.err.println("Error al listar los datos." + e.getMessage());
        } finally {

            PS = null;
            RS = null;
            CN.desconectar();
        }
        return ret;
    }

    public static String getNombre() {
        return nombre;
    }

}
