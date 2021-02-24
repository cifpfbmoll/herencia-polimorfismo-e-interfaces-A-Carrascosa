/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.fp.biblioteca;

import eu.fp.biblioteca.libros.*;
import eu.fp.biblioteca.personas.*;

/**
 *
 * @author Karina
 */
public class Main {

    public static void main(String[] args) {

        int opcion = 99;
        Biblioteca biblio = new Biblioteca();
        crearPersonas(biblio);
        crearLibros(biblio);

        while (opcion != 0) {
            separar();
            System.out.println("    Menú de biblioteca");
            System.out.println("================================================");
            System.out.println(" 1 > Gestionar Libros");
            System.out.println(" 2 > Gestionar Reservas");
            System.out.println(" 3 > Gestionar Biblioteca");
            System.out.println(" ");
            System.out.println(" 0 > Cerrar programa");

            opcion = Lector.kInt();

            switch (opcion) {
                case 1:
                    gestLibros(biblio);
                    break;

                case 2:
                    gestReservas(biblio);
                    break;

                case 3:
                    gestBiblioteca(biblio);
                    break;

            }
        }

    }

    private static void gestLibros(Biblioteca biblio) {
        int opcion2 = 99;
        while (opcion2 != 0) {

            Libro libroNuevo;
            separar();
            System.out.println("    Gestionar Libros");
            System.out.println("================================================");
            System.out.println(" 1 > Añadir libro");
            System.out.println(" 2 > Eliminar libro");
            System.out.println(" 3 > Buscar libro por ISBN");
            System.out.println(" 4 > Buscar libro por titulo");
            System.out.println(" 5 > Mostrar libros");
            System.out.println(" 6 > Mostrar libros disponibles");
            System.out.println(" ");
            System.out.println(" 0 > Volver al menú principal");

            opcion2 = Lector.kInt();

            switch (opcion2) {
                case 1: // Añadir libros
                    libroNuevo = Libro.anadirLibro(biblio.getListaLibros());
                    biblio.getListaLibros().add(libroNuevo);
                    break;

                case 2: // Eliminar libros
                    int isbn = Libro.eliminarLibro(biblio.getListaLibros());
                    if (isbn != -1) {
                        biblio.getListaLibros().remove(isbn);
                    }
                    break;

                case 3: // Buscar libro por ISBN y devolver la posicion
                    Libro.buscarPorIsbn(biblio.getListaLibros());
                    break;

                case 4: // Buscar libro por titulo
                    Libro.buscarPorTitulo(biblio.getListaLibros());
                    break;

                case 5: // Mostrar todos los libros
                    biblio.mostrarLibros();
                    break;

                case 6: // Mostrar los libros disponibles
                    biblio.mostrarLibrosDisponibles();
                    break;
            }
        }
    }

    private static void gestReservas(Biblioteca biblio) {

        boolean loged = loginBibliotecario(biblio);
        Reserva reserva = new Reserva();
        
        int opcion2 = 99;
        while (opcion2 != 0 && loged) {
            separar();
            System.out.println("    Gestionar Reservas");
            System.out.println("================================================");
            System.out.println(" 1 > Añadir reserva");
            System.out.println(" 2 > Eliminar reserva");
            System.out.println(" 3 > Ver libros con reservas");
            System.out.println(" 4 > Ver libros disponibles");
            System.out.println(" ");
            System.out.println(" 0 > Volver al menú principal");

            opcion2 = Lector.kInt();

            switch (opcion2) {
                case 1: // Añadir reserva
                    reserva.reservarLibro(biblio);
                    break;

                case 2: // Eliminar reserva
                    Libro.eliminarReserva(biblio.getListaLibros());
                    break;

                case 3: // Mostrar los libros con reservas
                    Biblioteca.mostrarLibrosConReservas(biblio.getListaLibros());
                    break;

                case 4: // Mostrar los libros disponibles
                    biblio.mostrarLibrosDisponibles();
                    break;

            }
        }
    }

    private static void gestBiblioteca(Biblioteca biblio) {
        int opcion2 = 99;
        while (opcion2 != 0) {
            separar();
            System.out.println("    Gestionar Biblioteca");
            System.out.println("================================================");
            System.out.println(" 1 > Añadir trabajador");
            System.out.println(" 2 > Eliminar trabajador");
            System.out.println(" 3 > Mostrar trabajadores registrados");
            System.out.println(" ");
            System.out.println(" 4 > Ver información de la biblioteca");
            System.out.println(" 5 > Cambiar nombre de la biblioteca");
            System.out.println(" ");
            System.out.println(" 6 > Añadir usuario");
            System.out.println(" 7 > Eliminar usuario");
            System.out.println(" 8 > Mostrar usuarios registrados");
            System.out.println(" ");
            System.out.println(" 0 > Volver al menú principal");

            opcion2 = Lector.kInt();

            Bibliotecario trabajador = new Bibliotecario();
            Usuario cliente = new Usuario();
            int id;

            switch (opcion2) {
                case 1: // Añadir una persona al personal
                    trabajador.solicitarDatosPersona();
                    biblio.getListaPersonas().add(trabajador);
                    break;

                case 2: // Eliminar un trabajador del personal
                    id = biblio.eliminarPersonal();
                    if (id != -1) {
                        biblio.getListaPersonas().remove(id);
                    }
                    break;

                case 3: // Consultar lista del personal
                    biblio.mostrarListaPersonal();
                    break;

                case 4: // Ver informacion de la biblioteca
                    Biblioteca.verInfoBiblioteca(biblio);
                    break;

                case 5: // Cambiar nombre de la biblioteca
                    Biblioteca.cambiarNombre(biblio);
                    break;

                case 6: // Añadir un usuario
                    cliente.solicitarDatosPersona();
                    biblio.getListaPersonas().add(cliente);
                    break;

                case 7: // Eliminar un usuario
                    id = biblio.eliminarPersonal();
                    if (id != -1) {
                        biblio.getListaPersonas().remove(id);
                    }
                    break;

                case 8: // Consultar lista de usuarios
                    biblio.mostrarListaUsuarios();
                    break;

            }
        }
    }

    public static void separar() {
        for (int i = 0; i < 3; i++) {
            System.out.println(" ");
        }
    }

    private static boolean loginBibliotecario(Biblioteca biblio) {
        System.out.println("    Gestionar Reservas");
        System.out.println("================================================");
        System.out.println(" > Control de seguridad.");

        String nif = Lector.kString("Inserta tu NIF");
        String passwd = Lector.kString("Inserta tu contraseña");

        boolean encontrado = false;
        int i = 0;

        while (!encontrado && i < biblio.getListaPersonas().size()) {
            if (biblio.getListaPersonas().get(i) instanceof Bibliotecario) {
                if (((Bibliotecario) biblio.getListaPersonas().get(i)).getNif().equals(nif) && ((Bibliotecario) biblio.getListaPersonas().get(i)).getPasswd().equals(passwd)) {
                    encontrado = true;
                }
            }
            i += 1;
        }

        if (!encontrado) {
            System.out.println("<!> El NIF no ha sido encontrado o la contraseña es incorrecta.");
            return false;
        }

        return true;
    }

    private static void crearPersonas(Biblioteca biblio) {
        for (Integer i = 0; i < 5; i++) {
            String k = i.toString();
            Bibliotecario p1 = new Bibliotecario("dependiente".concat(k), "43322".concat(k), "patatauwu".concat(k), "Juan".concat(k), "Garcia".concat(k), "Lopez".concat(k), 40 - i);
            biblio.getListaPersonas().add(p1);
            Usuario p2 = new Usuario(625 + i * 50, k, 0 + i * 3, k, "Juan".concat(k), "Garcia".concat(k), "Lopez".concat(k), 19 + i);
            biblio.getListaPersonas().add(p2);

        }
    }

    private static void crearLibros(Biblioteca biblio) {
        for (Integer i = 0; i < 5; i++) {
            String k = i.toString();
            Libro libro = new Libro((i+1)*50, "Marmota feliz ".concat(k), "alex", "Tornillo y tuerca", 20, 20-i*3, biblio.getListaLibros());
            biblio.getListaLibros().add(libro);

        }
    }

}
