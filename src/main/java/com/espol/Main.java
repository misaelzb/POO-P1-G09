package com.espol;
import com.espol.vista.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean done = false;
        while (!done) {
            clearConsole();
            mostrarMenuSeleccion();
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    // No implementado todavía
                    break;
                case 2:
                    // No implementado todavía
                    break;
                case 3:
                    // No implementado todavía
                    break;
                case 4:
                    // No implementado todavía
                    break;
                case 5:
                    VistaJuegoMemoria juegoMemoria = new VistaJuegoMemoria();
                    juegoMemoria.iniciarVista();
                    break;
                case 6:
                    done = true;
                    break;
                default:
                    // (no hace nada y vuelve a mostrar el menú)
                    break;
            }
        }
        sc.close();
    } 
    public static void clearConsole() {
        System.out.print("\033\143");
    }

    public static void mostrarMenuSeleccion() {
        System.out.println(
            "1. Gestión de Actividades\n" +
            "2. Técnicas de Enfoque (Manejo de tiempo)\n" +
            "3. Control de hidratación\n" +
            "4. Registro diario de Sostenibilidad\n" +
            "5. Juego de memoria\n" +
            "6. Salir"
        );
        System.out.print("Ingrese el número del programa a ejecutar: ");
    }
}