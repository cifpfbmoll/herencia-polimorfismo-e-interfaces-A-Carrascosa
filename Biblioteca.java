/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.fp.biblioteca;

import eu.fp.biblioteca.personas.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Karina
 */
public class Biblioteca {

    public static Scanner lectorBiblioteca = new Scanner(System.in);

    private String nombreBiblioteca;
    private ArrayList<Libro> listaLibros = new ArrayList();
    private ArrayList<Persona> listaPersonas = new ArrayList();

    // Constructor vacio
    public Biblioteca() {
    }

    // Constructor con todos los parametros
    public Biblioteca(String nombreBiblioteca, ArrayList<Libro> listaLibros, ArrayList<Persona> listaPersonas) {
        this.setNombreBiblioteca(nombreBiblioteca);
        this.setListaLibros(listaLibros);
        this.setListaPersonas(listaPersonas);
    }

    // Constructor copia
    public Biblioteca(Biblioteca copia) {
        this.setNombreBiblioteca(copia.getNombreBiblioteca());
        this.setListaLibros(copia.getListaLibros());
        this.setListaPersonas(copia.getListaPersonas());
    }

    // GETTERS Y SETTERS
    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public void setNombreBiblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca.substring(0, 1).toUpperCase() + nombreBiblioteca.substring(1);
    }

    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(ArrayList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    @Override
    public String toString() {
        return "{ " + "Biblioteca: " + nombreBiblioteca + " | " + "Titulos: " + listaLibros.size() + " | " + "Tamaño personal: " + listaPersonas.size() + " }";
    }

    public static void verInfoBiblioteca(Biblioteca obj) {
        System.out.println(obj.toString());
    }

    public static void cambiarNombre(Biblioteca obj) {
        System.out.println(">>> Introduce el nuevo nombre de la biblioteca");
        String nombre = lectorBiblioteca.nextLine();
        obj.setNombreBiblioteca(nombre);
    }

    public void mostrarLibros() {
        System.out.println(">>> Enseñando todos los libros de la biblioteca");
        boolean encontrado = false;

        for (int i = 0; (i < listaLibros.size()); i++) {
            encontrado = true;
            System.out.println(listaLibros.get(i).toString());
        }
        if (encontrado == false) {
            System.out.println(">>> No se ha encontrado ningun libro en la biblioteca");
        }
    }

    public void mostrarLibrosDisponibles() {
        System.out.println(">>> Enseñando todos los libros disponibles de la biblioteca");
        boolean encontrado = false;

        for (int i = 0; (i < listaLibros.size()); i++) {
            if (listaLibros.get(i).getCopiasDisponibles() > 0) {
                encontrado = true;
                System.out.println(listaLibros.get(i).toString());
            }
        }
        if (encontrado == false) {
            System.out.println(">>> No se ha encontrado ningun libro disponible en la biblioteca");
        }
    }

    public static void mostrarLibrosConReservas(ArrayList<Libro> listaLibros) {
        System.out.println(">>> Enseñando todos los libros con reservas de la biblioteca");
        boolean encontrado = false;

        for (int i = 0; (i < listaLibros.size()); i++) {
            if (listaLibros.get(i).getCopiasDisponibles() != listaLibros.get(i).getCopias()) {
                encontrado = true;
                System.out.println(listaLibros.get(i).toString());
            }
        }
        if (encontrado == false) {
            System.out.println(">>> No se ha encontrado ningun libro con reservas en la biblioteca");
        }
    }

    public void mostrarListaPersonal() {
        System.out.println(">>> Enseñando todos los trabajadores de la biblioteca");
        boolean encontrado = false;
        for (int i = 0; (i < listaPersonas.size()); i++) {
            if (listaPersonas.get(i) instanceof Bibliotecario) {
                System.out.println(listaPersonas.get(i).toString());
                encontrado = true;
            }
        }
        if (encontrado == false) {
            System.out.println(">>> No se ha encontrado ningun trabajador en la biblioteca");
        }
    }

    public void mostrarListaUsuarios() {
        System.out.println(">>> Enseñando todos los usuarios de la biblioteca");
        boolean encontrado = false;
        for (int i = 0; (i < listaPersonas.size()); i++) {
            if (listaPersonas.get(i) instanceof Usuario) {
                System.out.println(listaPersonas.get(i).toString());
                encontrado = true;
            }
        }
        if (encontrado == false) {
            System.out.println(">>> No se ha encontrado ningun usuario en la biblioteca");
        }
    }

    public int eliminarPersonal() {
        boolean encontrado = false;
        String NIF = Lector.kString("Introduce el NIF del trabajador a eliminar");
        for (int i = 0; (i < listaPersonas.size() && encontrado == false); i++) {
            if (listaPersonas.get(i) instanceof Bibliotecario) {
                if (((Bibliotecario) listaPersonas.get(i)).getNif().equals(NIF)) {
                    encontrado = true;
                    System.out.println(">>> Se ha eliminado al trabajador con NIF '" + NIF + "'");
                    return i;
                }
            }
        }
        if (encontrado == false) {
            System.out.println(">>> No se ha encontrado ningún trabajador con el NIF '" + NIF + "'");
        }
        return -1;
    }
}
