/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.fp.biblioteca.libros;

import eu.fp.biblioteca.*;
import eu.fp.biblioteca.personas.*;
import java.text.*;
import java.util.Date;

/**
 *
 * @author Karina
 */
public class Reserva {

    private Libro libro;

    SimpleDateFormat fechaActual = new SimpleDateFormat("dd.MM.yyyy");
    SimpleDateFormat horaActual = new SimpleDateFormat("HH:mm");

    private String fecha = fechaActual.format(new Date());
    private String hora = horaActual.format(new Date());

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

    public void reservarLibro(Biblioteca biblio) {

        System.out.println("    Realizar una reserva...");
        System.out.println("================================================");
        Integer tlf = Lector.kInteger("Telefono del usuario");
        String email = Lector.kString("Email del usuario");

        boolean encontrado = false;
        int i = 0;

        while (!encontrado && i < biblio.getListaPersonas().size()) {
            if (biblio.getListaPersonas().get(i) instanceof Usuario) {
                if (((Usuario) biblio.getListaPersonas().get(i)).getTelefono().equals(tlf) && ((Usuario) biblio.getListaPersonas().get(i)).getEmail().equals(email)) {
                    encontrado = true;
                }
            }
            i += 1;
        }

        if (!encontrado) {
            System.out.println("<!> La información del usuario es incorrecta o no esta registrada en el sistema.");
        } else {
            Usuario user = (Usuario) biblio.getListaPersonas().get(i - 1);
            System.out.println("    Se va a reservar un libro para " + user.getNombre() + " " + user.getApellido1() + " (" + user.getTelefono() + ")");
            Integer isbn = Lector.kInt("Introduce el ISBN del libro a reservar");

            i = 0;
            encontrado = false;

            while (i < biblio.getListaLibros().size() && !encontrado) {
                if (biblio.getListaLibros().get(i).getIsbn() == isbn) {
                    encontrado = true;
                    Libro libro = biblio.getListaLibros().get(i);
                    if (libro.getCopiasDisponibles() > 0) {
                        Reserva reserva = new Reserva(libro, fecha, hora);
                        user.getListaReservas().add(reserva);
                        libro.setCopiasDisponibles(libro.getCopiasDisponibles() - 1);
                        System.out.println("Se ha reservado el libro '" + libro.getTitulo() + "' para " + user.getNombre() + " " + user.getApellido1() + " (" + user.getTelefono() + ")");
                        System.out.println(reserva.toString());
                    } else {
                        System.out.println("<!> No hay copias disponibles del libro '" + libro.getTitulo() + "'");
                    }
                }
                i += 1;
            }

        }

    }
}
