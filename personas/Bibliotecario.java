/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.fp.biblioteca.personas;

import eu.fp.biblioteca.Lector;

/**
 *
 * @author Karina
 */
public class Bibliotecario extends Persona {

    private String puesto;
    private String nif;
    private String passwd;

    // Constructor vacio
    public Bibliotecario() {
    }

    // Constructor entero con los atributos del padre
    public Bibliotecario(String puesto, String nif, String passwd, String nombre, String apellido1, String apellido2, int edad) {
        super(nombre, apellido1, apellido2, edad);
        this.puesto = puesto;
        this.nif = nif;
        this.passwd = passwd;
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

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {

        String confirmacion = Lector.kString("Confirma la contraseña");
        while (!passwd.equals(confirmacion) || passwd.length() < 8) {
            if (passwd.length() < 8) {
                System.out.println("<!> Esa contraseña es muy corta, introduce una de al menos 8 caracteres.");
            } else {
                System.out.println("<!> Las contraseñas no coinciden, vuelve a introducirlas!");
            }
            passwd = Lector.kString("Inserta una contraseña");
            confirmacion = Lector.kString("Confirma la contraseña");
        }

        this.passwd = passwd;
    }

    // toString SIN los datos del padre
    @Override
    public String toString() {
        return "{ Puesto de trabajo: " + puesto + " | NIF: " + nif + " }";
    }

    @Override
    public void solicitarDatosPersona() {
        super.solicitarDatosPersona(); //To change body of generated methods, choose Tools | Templates.
        setPuesto(Lector.kString("Inserta el puesto de trabajo"));
        setNif(Lector.kString("Inserta el NIF"));
        setPasswd(Lector.kString("Inserta una contraseña"));
    }

}
