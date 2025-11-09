package com.espol.vista;

import com.espol.controlador.ControladorSesionEnfoque;
import com.espol.modelo.SesionEnfoque;

import java.util.Scanner;

public class VistaSesionEnfoque {
    private ControladorSesionEnfoque controlador;
    private Scanner scanner;

    public VistaSesionEnfoque() {
        this.controlador = new ControladorSesionEnfoque();
        this.scanner = new Scanner(System.in);
    }

    public static void clearConsole() {
        System.out.print("\033\143");
    }

    public void menu() {
        String opcion;
        do {
            clearConsole();
            System.out.println("--- TÉCNICAS DE ENFOQUE (MANEJO DE TIEMPO) ---");
            System.out.println("1. Registrar nueva sesión de enfoque");
            System.out.println("2. Ver historial de sesiones");
            System.out.println("3. Volver al menú principal");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    registrarSesion();
                    break;
                case "2":
                    verHistorial();
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (!opcion.equals("3"));
    }

    private void registrarSesion() {
        clearConsole();
        System.out.println("--- REGISTRAR NUEVA SESIÓN DE ENFOQUE ---");
        System.out.print("Ingrese la técnica aplicada (ej: Pomodoro, Eisenhower): ");
        String tecnica = scanner.nextLine();
        System.out.print("Ingrese la duración en minutos: ");
        int duracion = Integer.parseInt(scanner.nextLine());

        controlador.agregarSesion(tecnica, duracion);
        System.out.println("\n¡Sesión registrada con éxito!");
        System.out.println("Presione [ENTER] para continuar...");
        scanner.nextLine();
    }

    private void verHistorial() {
        clearConsole();
        System.out.println("--- HISTORIAL DE SESIONES DE ENFOQUE ---");
        for (SesionEnfoque sesion : controlador.getSesiones()) {
            System.out.println("Fecha: " + sesion.getFecha() + " | Técnica: " + sesion.getTecnicaAplicada() + " | Duración: " + sesion.getDuracionMinutos() + " min");
        }
        System.out.println("\nPresione [ENTER] para volver...");
        scanner.nextLine();
    }
}