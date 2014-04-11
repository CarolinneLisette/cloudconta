/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carolinne
 */
public class Conexion {
    
    private Statement stm;
    private Connection cnn;
    private ResultSet rst;
    
    private String url;
    private String driver;
    private String nombreBaseDatos;
    private String nombreTabla;
    private String sentenciaSQL;
    private String user;
    private String password;
    private boolean esSelect;

    public Conexion() {
    
        this.url = "";
        this.driver = "";
        this.nombreBaseDatos = "";
        this.nombreTabla = "";
        this.sentenciaSQL = "";
        this.user = "";
        this.password = "";
        this.esSelect = false;
    
    }

    public Conexion( String url, String driver, String nombreBaseDatos, String nombreTabla, String sentenciaSQL, String user, String password, boolean esSelect) {
     
        this.url = url;
        this.driver = driver;
        this.nombreBaseDatos = nombreBaseDatos;
        this.nombreTabla = nombreTabla;
        this.sentenciaSQL = sentenciaSQL;
        this.user = user;
        this.password = password;
        this.esSelect = esSelect;
    }

    /**
     * @return the stm
     */
    public Statement getStm() {
        return stm;
    }

    /**
     * @param stm the stm to set
     */
    public void setStm(Statement stm) {
        this.stm = stm;
    }

    /**
     * @return the cnn
     */
    public Connection getCnn() {
        return cnn;
    }

    /**
     * @param cnn the cnn to set
     */
    public void setCnn(Connection cnn) {
        this.cnn = cnn;
    }

    /**
     * @return the rst
     */
    public ResultSet getRst() {
        return rst;
    }

    /**
     * @param rst the rst to set
     */
    public void setRst(ResultSet rst) {
        this.rst = rst;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * @param driver the driver to set
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * @return the nombreBaseDatos
     */
    public String getNombreBaseDatos() {
        return nombreBaseDatos;
    }

    /**
     * @param nombreBaseDatos the nombreBaseDatos to set
     */
    public void setNombreBaseDatos(String nombreBaseDatos) {
        this.nombreBaseDatos = nombreBaseDatos;
    }

    /**
     * @return the nombreTabla
     */
    public String getNombreTabla() {
        return nombreTabla;
    }

    /**
     * @param nombreTabla the nombreTabla to set
     */
    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    /**
     * @return the senteciaSQL
     */
    public String getSentenciaSQL() {
        return sentenciaSQL;
    }

    /**
     * @param sentenciaSQL the senteciaSQL to set
     */
    public void setSentenciaSQL(String sentenciaSQL) {
        this.sentenciaSQL = sentenciaSQL;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the esSelect
     */
    public boolean isEsSelect() {
        return esSelect;
    }

    /**
     * @param esSelect the esSelect to set
     */
    public void setEsSelect(boolean esSelect) {
        this.esSelect = esSelect;
    }
    
    public void cerrarConexion()
    {
        try {
            this.getCnn().close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Metodo principal para la conexion
     */
    public void conectar()      
    {
        try {
            //Cargar el Driver del Motor de Datos
            Class.forName(this.getDriver());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        try {
            //Crear la nueva Conexion
        this.setCnn(DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPassword()));
            //Crear sentencia para ejecutar SQL's
            this.setStm(this.getCnn().createStatement());                                    
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        //Verificar si se ejecuta una Query o un Update
        if(this.isEsSelect() == true)
        {
            try {
                //Ejecutar una QUERY
                this.setRst(this.getStm().
                        executeQuery(this.getSentenciaSQL()));
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        else
        {
            try {
                //Ejecutar un UPDATE
                this.getStm().executeUpdate(this.getSentenciaSQL());
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                        
    }
 
}
