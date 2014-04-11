/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Conexion.Conexion;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carolinne
 */
public class Empresa_N {

    private Conexion cnn;

    public Empresa_N() {
        cnn = new Conexion();
        
    }

    public void configurarConexion() {
        this.cnn.setNombreBaseDatos("cloudconta");
        this.cnn.setNombreTabla("Empresa");
        this.cnn.setDriver("com.mysql.jdbc.Driver");
        this.cnn.setUrl("jdbc:mysql://localhost:3306/cloudconta");
        this.cnn.setUser("root");
        this.cnn.setPassword("");

    }

    public void IngresarBanco(Empresa b) {
        this.configurarConexion();
        this.cnn.setEsSelect(false);
        this.cnn.setSentenciaSQL("INSERT INTO " + this.cnn.getNombreTabla() + " VALUES("
                + b.getCodigo()+ ",'"
                + b.getNombre() + "','"
                + b.getSucursal()+ "','"
                + b.getDireccion()+ "','"
                + b.getComuna()+ "')");
        this.cnn.conectar();
        this.cnn.cerrarConexion();
    }
    

    public Empresa BuscarBanco(String Codigo) {
        Empresa b = new Empresa();
        this.configurarConexion();
        this.cnn.setEsSelect(true);
        this.cnn.setSentenciaSQL("SELECT * FROM " + this.cnn.getNombreTabla() + " WHERE codigo=" + Codigo);
        this.cnn.conectar();
        try {
            while (this.cnn.getRst().next()) {
                b.setCodigo(this.cnn.getRst().getInt("codigo"));
                b.setNombre(this.cnn.getRst().getString("nombre"));
                b.setSucursal(this.cnn.getRst().getString("Sucursal"));
                b.setDireccion(this.cnn.getRst().getString("direccion"));
                b.setComuna(this.cnn.getRst().getString("comuna"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Empresa_N.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.cnn.cerrarConexion();
        return b;
    }

    public void EliminarBanco(String Codigo) {
        this.configurarConexion();
        this.cnn.setEsSelect(false);
        this.cnn.setSentenciaSQL("DELETE FROM " + this.cnn.getNombreTabla() + " WHERE Codigo=" + Codigo );
        this.cnn.conectar();
        this.cnn.cerrarConexion();
    }
    
   
    public void ModificarBanco(Empresa b, String codigo) {
        this.configurarConexion();
        cnn.setEsSelect(false);
        cnn.setSentenciaSQL("Update Empresa set "
                + "Nombre='" + b.getNombre() + "',"
                + "sucursal='" + b.getSucursal()+ "',"
                + "Direccion='" + b.getDireccion()+ "',"
                + "Comuna='" + b.getComuna()+ "'"
                + " where codigo="+codigo+"");
        cnn.conectar();
        cnn.cerrarConexion();
    }
    
    
}
