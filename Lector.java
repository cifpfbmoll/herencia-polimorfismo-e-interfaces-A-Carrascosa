/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.fp.biblioteca;

import java.util.Scanner;

/**
 *
 * @author Karina
 */
public class Lector {

    public static Scanner lector = new Scanner(System.in); // Establecer el objeto scanner

    public static String kString(String texto) {
        System.out.println(">>> " + texto + ": ");
        String valor = lector.nextLine();
        return valor;
    }

    public static String kString() {
        String valor = lector.nextLine();
        return valor;
    }

    public static Integer kInteger(String texto) {
        System.out.println(">>> " + texto + ": ");
        Integer valor = lector.nextInt();
        lector.nextLine(); // Limpiar buffer dentro del input
        return valor;
    }

    public static Integer kInteger() {
        Integer valor = lector.nextInt();
        lector.nextLine(); // Limpiar buffer dentro del input
        return valor;
    }

    public static int kInt(String texto) {
        System.out.println(">>> " + texto + ": ");
        int valor = lector.nextInt();
        lector.nextLine(); // Limpiar buffer dentro del input
        return valor;
    }

    public static int kInt() {
        int valor = lector.nextInt();
        lector.nextLine(); // Limpiar buffer dentro del input
        return valor;
    }

    public static Float kFloat(String texto) {
        System.out.println(">>> " + texto + ": ");
        Float valor = lector.nextFloat();
        lector.nextLine(); // Limpiar buffer dentro del input
        return valor;
    }

    public static Float kFloat() {
        Float valor = lector.nextFloat();
        lector.nextLine(); // Limpiar buffer dentro del input
        return valor;
    }
}
