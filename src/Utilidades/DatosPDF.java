package Utilidades;

/*
@author Lorenzatti Nazareno
@version 1.0
nl.loragro@gmail.com
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;

// Clase que contiene toda la informacion para generar y subir los PDF a la BDD

public class DatosPDF {

    /*Todo los atributos*/
    private String codigopdf;
    private byte[] archivopdf;
    private String tecnico;
    private Date fecha;
    
    public DatosPDF(){
        
    }

    public DatosPDF(String codigo, File ruta, String tecnico, Date fecha) {
        guardar_pdf(codigo, ruta, tecnico, fecha);

    }

    public void guardar_pdf(String codigo, File ruta, String tecnico,Date fecha) {
        setCodigopdf(codigo);
        setTecnico(tecnico);
        setFecha(fecha);

        try {
            byte[] pdf = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(pdf);
            setArchivopdf(pdf);
        } catch (IOException ex) {
            setArchivopdf(null);
            //System.out.println("Error al agregar archivo pdf "+ex.getMessage());
        }
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCodigopdf() {
        return codigopdf;
    }

    public byte[] getArchivopdf() {
        return archivopdf;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setCodigopdf(String codigopdf) {
        this.codigopdf = codigopdf;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public void setArchivopdf(byte[] archivopdf) {
        this.archivopdf = archivopdf;
    }

}
