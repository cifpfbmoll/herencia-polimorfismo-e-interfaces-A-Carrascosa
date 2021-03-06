/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.fp.biblioteca.libros;

import eu.fp.biblioteca.*;
import java.util.ArrayList;

/**
 *
 * @author Karina
 */
public class Libro {

    private static int contadorLibros;
    private int isbn;
    private String titulo;
    private String autor;
    private String editorial;
    private int copias;
    private int copiasDisponibles;

    // Constructor vacío
    public Libro() {
        contadorLibros++;
    }

    // Constructor con todos los parametros
    public Libro(int isbn, String titulo, String autor, String editorial, int copias, int copiasDisponibles, ArrayList<Libro> listaLibros) {
        contadorLibros++;
        this.setIsbn(isbn, listaLibros);
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setEditorial(editorial);
        this.setCopias(copias);
        this.setCopiasDisponibles(copiasDisponibles);
    }

    // Constructor copia
    public Libro(Libro copia, ArrayList<Libro> listaLibros) {
        contadorLibros++;
        this.setIsbn(copia.getIsbn(), listaLibros);
        this.setTitulo(copia.getTitulo());
        this.setAutor(copia.getAutor());
        this.setEditorial(copia.getEditorial());
        this.setCopias(copia.getCopias());
        this.setCopiasDisponibles(copia.getCopiasDisponibles());
    }

    // GETTERS
    public int getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getCopias() {
        return copias;
    }

    public int getCopiasDisponibles() {
        return copiasDisponibles;
    }

    public static int getContadorLibros() {
        return contadorLibros;
    }

    // SETTERS
    public void setIsbn(int isbn, ArrayList<Libro> listaLibros) {
        for (int i = 0; i < listaLibros.size(); i++) {
            while (listaLibros.get(i).getIsbn() == isbn) {
                isbn = Lector.kInt("Este ISBN ya esta en esta biblioteca, introduce otro ISBN");
            }
        }
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setCopias(int copias) {
        while (copias < 1) {
            System.out.println(">>> No puede haber menos de 1 copia.");
            copias = Lector.kInt("Vuelve a introducir la cantidad de copias");
        }
        this.copias = copias;
    }

    public void setCopiasDisponibles(int copiasDisponibles) {
        this.copiasDisponibles = copiasDisponibles;
    }

    @Override
    public String toString() {
        return "{ " + "ISBN: " + isbn + " | " + "Titulo: " + titulo + " | " + "Autor: " + autor + " | " + "Editorial: " + editorial + " | " + "Copias: " + copias + " | " + "Copias disponibles: " + copiasDisponibles + " }";
    }

    public static Libro anadirLibro(ArrayList<Libro> listaLibros) {
        Libro libroNuevo = new Libro();
        libroNuevo.setTitulo(Lector.kString("Titulo del libro"));
        libroNuevo.setAutor(Lector.kString("Autor del libro"));
        libroNuevo.setEditorial(Lector.kString("Editorial del libro"));
        libroNuevo.setIsbn(Lector.kInt("ISBN del libro"), listaLibros);
        int copias = Lector.kInt("Copias del libro");
        libroNuevo.setCopias(copias);
        int copiasDisponibles = Lector.kInt("Copias disponibles del libro");
        while (copiasDisponibles > copias) {
            System.out.println(">>> No puede haber menos de 1 copia.");
            copiasDisponibles = Lector.kInt("Vuelve a introducir la cantidad de copias");

        }
        libroNuevo.setCopiasDisponibles(copiasDisponibles);

        return libroNuevo;
    }

    public static int eliminarLibro(ArrayList<Libro> listaLibros) {
        boolean encontrado = false;
        int ISBN = Lector.kInt("Introduce el ISBN del libro a eliminar");

        for (int i = 0; (i < listaLibros.size() && encontrado == false); i++) {
            if (listaLibros.get(i).getIsbn() == ISBN) {
                if (listaLibros.get(i).getCopiasDisponibles() == listaLibros.get(i).getCopias()) {
                    encontrado = true;
                    contadorLibros -= 1;
                    //listaLibros.remove(i);
                    System.out.println(">>> Se ha eliminado el libro con el ISBN '" + ISBN + "'");
                    return i;
                } else {
                    System.out.println(">>> No se ha podido eliminar el libro con el ISBN '" + ISBN + "' por que tiene reservas.");
                }
            }
        }
        if (encontrado == false) {
            System.out.println(">>> No se ha encontrado ningún libro con el ISBN '" + ISBN + "'");
        }
        return -1;
    }

    public static void buscarPorIsbn(ArrayList<Libro> listaLibros) {
        int ISBN = Lector.kInt("Introduce el ISBN del libro a buscar");

        boolean encontrado = false;

        for (int i = 0; (i < listaLibros.size() && encontrado == false); i++) {
            if (listaLibros.get(i).getIsbn() == ISBN) {
                encontrado = true;
                System.out.println(">>> El libro con el ISBN '" + ISBN + "' está en la posición '" + i + "'");
            }
        }
        if (encontrado == false) {
            System.out.println(">>> No se ha encontrado el libro con el ISBN '" + ISBN + "'");
        }
    }

    public static void buscarPorTitulo(ArrayList<Libro> listaLibros) {
        String busqueda = Lector.kString("Introduce el titulo del libro a buscar");
        boolean encontrado = false;

        for (int i = 0; (i < listaLibros.size()); i++) {
            if (listaLibros.get(i).getTitulo().contains(busqueda)) {
                encontrado = true;
                System.out.println(listaLibros.get(i).toString());
            }
        }
        if (encontrado == false) {
            System.out.println(">>> No se ha encontrado ninguna coincidencia con '" + busqueda + "'");
        }
    }

}
