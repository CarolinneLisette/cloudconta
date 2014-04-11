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
public class Contador_N {

    private Conexion cnn;

    public Contador_N() {
        cnn = new Conexion();

    }

    public void configurarConexion() {
        this.cnn.setNombreBaseDatos("cloudconta");
        this.cnn.setNombreTabla("contador");
        this.cnn.setDriver("com.mysql.jdbc.Driver");
        this.cnn.setUrl("jdbc:mysql://localhost:3306/cloudconta");
        this.cnn.setUser("root");
        this.cnn.setPassword("");

    }

    public void IngresarCliente(Contador c) {
        this.configurarConexion();
        this.cnn.setEsSelect(false);
        this.cnn.setSentenciaSQL("INSERT INTO " + this.cnn.getNombreTabla() + " VALUES('"
                + c.getRut() + "','"
                + c.getNombre() + "','"
                + c.getContraseña() + "','"
                + c.getDireccion() + "','"
                + c.getComuna() + "',"
                + c.getEdad() + ")");
        this.cnn.conectar();
        this.cnn.cerrarConexion();
    }

    public void IngresarUsuario(String rut, String Pass) {
        this.configurarConexion();
        this.cnn.setEsSelect(false);
        this.cnn.setSentenciaSQL("INSERT INTO usuario VALUES('"
                + rut + "','"
                + Pass + "')");
        this.cnn.conectar();
        this.cnn.cerrarConexion();
    }

    public Contador BuscarCliente(String rut) {
        Contador c = new Contador();
        this.configurarConexion();
        this.cnn.setEsSelect(true);
        this.cnn.setSentenciaSQL("SELECT * FROM " + this.cnn.getNombreTabla() + " WHERE rut='" + rut + "'");
        this.cnn.conectar();
        try {
            while (this.cnn.getRst().next()) {
                c.setNombre(this.cnn.getRst().getString("nombre"));
                c.setEdad(this.cnn.getRst().getInt("edad"));
                c.setDireccion(this.cnn.getRst().getString("direccion"));
                c.setContraseña(this.cnn.getRst().getString("pasword"));
                c.setComuna(this.cnn.getRst().getString("comuna"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Contador_N.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.cnn.cerrarConexion();
        return c;
    }

    public void EliminarCliente(String rut) {
        this.configurarConexion();
        this.cnn.setEsSelect(false);
        this.cnn.setSentenciaSQL("DELETE FROM " + this.cnn.getNombreTabla() + " WHERE rut='" + rut + "'");
        this.cnn.conectar();
        this.cnn.cerrarConexion();
    }

    public void eliminarUsuario(String rut) {
        this.configurarConexion();
        this.cnn.setEsSelect(false);
        this.cnn.setSentenciaSQL("DELETE FROM usuario WHERE rut='" + rut + "'");
        this.cnn.conectar();
        this.cnn.cerrarConexion();
    }

    public void ModificarCliente(Contador c, String rut) {
        this.configurarConexion();
        cnn.setEsSelect(false);
        cnn.setSentenciaSQL("Update usuario set "
                + "Nombre='" + c.getNombre() + "',"
                + "Password='" + c.getContraseña() + "',"
                + "Direccion='" + c.getDireccion() + "',"
                + "Comuna='" + c.getComuna() + "',"
                + "Edad=" + c.getEdad()
                + " where Rut='" + rut + "'");

        cnn.conectar();
        cnn.cerrarConexion();
    }

    public void ModificarUsuario(String rut, String Pass) {
        this.configurarConexion();
        cnn.setEsSelect(false);
        cnn.setSentenciaSQL("Update " + cnn.getNombreTabla() + " set "
                + "password='" + Pass
                + "' where Rut='" + rut + "'");
        cnn.conectar();
        cnn.cerrarConexion();
    }

    public Contador BuscarUsuario(String rut, String pass) {
        Contador c = new Contador();
        this.configurarConexion();
        this.cnn.setEsSelect(true);
        this.cnn.setSentenciaSQL("SELECT * FROM usuario WHERE rut='" + rut + "' and password='" + pass + "'");

        this.cnn.conectar();
        try {
            while (this.cnn.getRst().next()) {
                c.setRut(this.cnn.getRst().getString("Rut"));
                c.setContraseña(this.cnn.getRst().getString("password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Contador_N.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.cnn.cerrarConexion();
        return c;

    }
}
