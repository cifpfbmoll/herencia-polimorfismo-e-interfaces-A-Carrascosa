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
public abstract class Persona {

    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;

    // Constructor vacio
    public Persona() {
    }

    // Constructor entero
    public Persona(String nombre, String apellido1, String apellido2, int edad) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
    }

// Constructor copia
    public Persona(Persona copia) {
        this.setNombre(copia.getNombre());
        this.setApellido1(copia.getApellido1());
        this.setApellido2(copia.getApellido2());
        this.setEdad(copia.getEdad());
    }

    // GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    // toString
    @Override
    public String toString() {
        return "{ Nombre: " + nombre + " | Apellidos: " + apellido1 + " " + apellido2 + " | Edad: " + edad + " }";
    }

    public void solicitarDatosPersona() {
        setNombre(Lector.kString("Escribe el nombre"));
        setApellido1(Lector.kString("Escribe el apellido 1"));
        setApellido1(Lector.kString("Escribe el apellido 2"));
        setEdad(Lector.kInt("Escribe la edad"));
    }
}
