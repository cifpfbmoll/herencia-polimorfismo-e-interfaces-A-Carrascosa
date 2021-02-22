/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.fp.biblioteca;

import java.util.*;
import java.text.*;

/**
 *
 * @author Karina
 */
public class Reserva {

    private Libro libro;
    private String fecha;
    private String hora;

    SimpleDateFormat fechaActual = new SimpleDateFormat("dd.MM.yyyy");
    SimpleDateFormat horaActual = new SimpleDateFormat("hh:mm");

    // Constructor vacio
    public Reserva() {
    }

    // Constructor con todos los parametros
    public Reserva(Libro libro, String fecha, String hora) {
        this.setLibro(libro);
        this.setFecha(fecha);
        this.setHora(hora);
    }

    // Constructor copia
    public Reserva(Reserva copia) {
        this.setLibro(copia.getLibro());
        this.setFecha(copia.getFecha());
        this.setHora(copia.getHora());
    }

    // GETTERS Y SETTERS
    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    // toString
    @Override
    public String toString() {
        return "Reserva { Libro: " + libro.getTitulo() + "(" + libro.getIsbn() + ") | Fecha: " + fecha + " | Hora: " + hora + " }";
    }

}
