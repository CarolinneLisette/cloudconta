/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Carolinne
 */
public class Empresa {
    
    
    private int Codigo;
    private String Nombre,Sucursal, Direccion, Comuna;

    public Empresa(int Codigo, String Nombre, String Sucursal, String Direccion, String Comuna) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Sucursal = Sucursal;
        this.Direccion = Direccion;
        this.Comuna = Comuna;
    }
    
    public Empresa(){
        this.Codigo=0;
        this.Comuna="";
        this.Direccion="";
        this.Nombre="";
        this.Sucursal="";
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getSucursal() {
        return Sucursal;
    }

    public void setSucursal(String Sucursal) {
        this.Sucursal = Sucursal;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getComuna() {
        return Comuna;
    }

    public void setComuna(String Comuna) {
        this.Comuna = Comuna;
    }

}
