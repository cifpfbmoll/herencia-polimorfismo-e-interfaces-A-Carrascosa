/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.fp.biblioteca;

/**
 *
 * @author Karina
 */
public class Bibliotecario extends Persona {

    private String puesto;
    private int nif;
    private String passwd;

    // Constructor vacio
    public Bibliotecario() {
    }

    // Constructor entero con los atributos del padre
    public Bibliotecario(String puesto, int nif, String passwd, String nombre, String apellido1, String apellido2, Integer edad) {
        super(nombre, apellido1, apellido2, edad);
        this.setPuesto(puesto);
        this.setNif(nif);
        this.setPasswd(passwd);
    }

    // Constructor copia
    public Bibliotecario(Bibliotecario copia) {
        super(copia.getNombre(), copia.getApellido1(), copia.getApellido2(), copia.getEdad());
        this.setPuesto(copia.getPuesto());
        this.setNif(copia.getNif());
        this.setPasswd(copia.getPasswd());
    }

    // GETTERS Y SETTERS
    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    // toString SIN los datos del padre

    @Override
    public String toString() {
        return "{ Puesto de trabajo: " + puesto + " | NIF: " + nif + " }";
    }
    
}
