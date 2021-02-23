/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.fp.biblioteca.personas;

import eu.fp.biblioteca.Lector;
import eu.fp.biblioteca.Reserva;
import java.util.ArrayList;

/**
 *
 * @author Karina
 */
public class Usuario extends Persona {

    private int telefono;
    private String direccion;
    private int codigoPostal;
    private String email;
    private ArrayList<Reserva> listaReservas = new ArrayList();

    // Constructor vacio
    public Usuario() {
    }

    // Cosntructor entero incluido atributos del padre
    public Usuario(int telefono, String direccion, int codigoPostal, String email, String nombre, String apellido1, String apellido2, Integer edad) {
        super(nombre, apellido1, apellido2, edad);
        this.setTelefono(telefono);
        this.setDireccion(direccion);
        this.setCodigoPostal(codigoPostal);
        this.setEmail(email);
    }

    // Constructor copia
    public Usuario(Usuario copia) {
        super(copia.getNombre(), copia.getApellido1(), copia.getApellido2(), copia.getEdad());
        this.setTelefono(copia.getTelefono());
        this.setDireccion(copia.getDireccion());
        this.setCodigoPostal(copia.getCodigoPostal());
        this.setEmail(copia.getEmail());
    }

    // GETTERS Y SETTERS
    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    // toString con el del padre
    @Override
    public String toString() {
        super.toString();
        return "{ Telefono: " + telefono + " | Direccion: " + direccion + " | Codigo Postal: " + codigoPostal + " | Email: " + email + "}";
    }

    @Override
    public void solicitarDatosPersona() {
        super.solicitarDatosPersona(); //To change body of generated methods, choose Tools | Templates.
        setTelefono(Lector.kInt("Inserta el numero de telefono"));
        setDireccion(Lector.kString("Inserta la direccion"));
        setCodigoPostal(Lector.kInt("Inserta el numero de telefono"));
        setEmail(Lector.kString("Inserta el email"));
    }

}
