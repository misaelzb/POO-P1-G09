package com.espol.vista;

import com.espol.controlador.ControladorRegistroSostenibilidad;
import com.espol.modelo.RegistroSostenibilidad;


import java.util.Scanner;

public class VistaRegistroSostenibilidad {
    private ControladorRegistroSostenibilidad controlador;
    private Scanner scanner;

    public VistaRegistroSostenibilidad() {
        this.controlador = new ControladorRegistroSostenibilidad();
        this.scanner = new Scanner(System.in);
    }

    public static void clearConsole() {
        System.out.print("\033\143");
    }

    public void menu() {
        String opcion;
        do {
            clearConsole();
            System.out.println("--- REGISTRO DIARIO DE SOSTENIBILIDAD ---");
            System.out.println("1. Registrar acciones de sostenibilidad de hoy");
            System.out.println("2. Ver mis registros");
            System.out.println("3. Volver al menú principal");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    registrarAcciones();
                    break;
                case "2":
                    verRegistros();
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (!opcion.equals("3"));
    }

    private void registrarAcciones() {
        clearConsole();
        System.out.println("--- REGISTRAR ACCIONES ---");
        System.out.println("Ingrese las acciones realizadas hoy, separadas por coma (ej: Reciclar, Usar transporte público):");
        String accionesInput = scanner.nextLine();
        String[] acciones = accionesInput.split(",");
        System.out.print("Ingrese los puntos obtenidos por estas acciones: ");
        int puntos = Integer.parseInt(scanner.nextLine());

        controlador.agregarRegistro(acciones, puntos);
        System.out.println("\n¡Registro guardado con éxito!");
        System.out.println("Presione [ENTER] para continuar...");
        scanner.nextLine();
    }

    private void verRegistros() {
        clearConsole();
        System.out.println("--- MIS REGISTROS DE SOSTENIBILIDAD ---");
        for (RegistroSostenibilidad registro : controlador.getRegistros()) {
            System.out.println("Fecha: " + registro.getFecha());
            System.out.println("Acciones: " + String.join(", ", registro.getAccionesRealizadas()));
            System.out.println("Puntos: " + registro.getPuntosObtenidos());
            System.out.println("--------------------");
        }
        System.out.println("\nPuntos totales acumulados: " + controlador.calcularPuntosTotales());
        System.out.println("\nPresione [ENTER] para volver...");
        scanner.nextLine();
    }
}