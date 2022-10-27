
package Utilidades;
/*
@author Lorenzatti Nazareno
@version 1.0
nl.loragro@gmail.com
 */
import Conexion.Conectar;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Clase para guardar los PDF de los remitos en la base de datos

public class GuardarPDF {

      /*Metodo agregar*/
    public void Agregar_PdfVO(DatosPDF vo, Date fecha) {
        Conectar conec = new Conectar();
        String SQL = "INSERT INTO remitos (remito_numero, remito_fecha, remito_tecnico, remito_pdf) VALUES(?, ?, ?, ?);";
        PreparedStatement ps = null;
        try {
            ps = conec.getConnection().prepareStatement(SQL);
            ps.setString(1, vo.getCodigopdf());
            ps.setDate(2, fecha);
            ps.setString(3, vo.getTecnico());
            ps.setBytes(4, vo.getArchivopdf());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                conec.desconectar();
            } catch (Exception ex) {
            }
        }
    }

    //Permite el mostrar PDF contenido en la base de datos
    public void ejecutar_archivoPDF(String numeroRemito) {

        Conectar cn = new Conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        byte[] b = null;

        try {
            ps = cn.getConnection().prepareStatement("SELECT remito_pdf FROM remitos WHERE remito_numero = '"+numeroRemito+"'");
            rs = ps.executeQuery();
            while (rs.next()) {
                b = rs.getBytes(1);
            }
            InputStream bos = new ByteArrayInputStream(b);

            int tamanoInput = bos.available();
            byte[] datosPDF = new byte[tamanoInput];
            bos.read(datosPDF, 0, tamanoInput);

            OutputStream out = new FileOutputStream("new.pdf");
            out.write(datosPDF);

            //abrir archivo
            out.close();
            bos.close();
            ps.close();
            rs.close();
            cn.desconectar();

        } catch (IOException | NumberFormatException | SQLException ex) {
            System.out.println("Error al abrir archivo PDF " + ex.getMessage());
        }
    }

}
