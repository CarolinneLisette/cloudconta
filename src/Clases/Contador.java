/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Carolinne
 */
public class Contador {

    private int  Edad;
    private String Nombre, Contraseña, Comuna, Direccion,rut;

    public Contador(int Edad, String Nombre, String Contraseña, String Comuna, String Direccion, String rut) {
        this.Edad = Edad;
        this.Nombre = Nombre;
        this.Contraseña = Contraseña;
        this.Comuna = Comuna;
        this.Direccion = Direccion;
        this.rut = rut;
    }

    public Contador() {
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getComuna() {
        return Comuna;
    }

    public void setComuna(String Comuna) {
        this.Comuna = Comuna;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

   
}