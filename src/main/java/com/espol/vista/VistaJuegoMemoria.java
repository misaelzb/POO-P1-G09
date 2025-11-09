package com.espol.vista;
import com.espol.controlador.ControladorJuegoMemoria;
import com.espol.controlador.ControladorJuegoMemoria.InfoTurno;
import com.espol.modelo.Carta;
import com.espol.helpers.Consola;

import java.util.Scanner;
public class VistaJuegoMemoria {
    public static Scanner sc = new Scanner(System.in);
    private ControladorJuegoMemoria controlador;

    public VistaJuegoMemoria() {
        this.controlador = new ControladorJuegoMemoria();
    }
    
    public void mostrarInfoTablero() {
        mostrarInfoTablero(true);
    }

    public void mostrarInfoTablero(boolean mostrarEncabezado) {
        if (mostrarEncabezado) System.out.println("--- INFORMACIÓN ACTUAL DEL TABLERO ---");
        System.out.println(controlador.getDataTablero());
        System.out.println("Total de intentos: " + controlador.getIntentos() + " | Pares encontrados: " + controlador.getParesEncontrados() + "/8");
        System.out.println();
    }

    public void iniciarVista() {
        Consola.limpiar();
        
        System.out.println("--- JUEGO DE MEMORIA ECOLÓGICO ---");
        System.out.println("¡Encuentra los 8 pares en menos de 20 intentos!");
        
        mostrarInfoTablero(false);

        
        System.out.print("Presione [ENTER] para comenzar el primer intento...");
        sc.nextLine();
        System.out.println(controlador.todosParesEncontrados());
        while(controlador.getIntentos() < 20 && !controlador.todosParesEncontrados()) {
            Consola.limpiar();
            int intentoActual = controlador.getIntentos();
            
            mostrarInfoTablero(false);

            System.out.println("--- TURNO " + (intentoActual + 1) + " | SELECCIÓN ---");
            System.out.print("Ingrese el número de la PRIMERA carta: ");
            int numC1 = sc.nextInt();

            sc.nextLine(); 
            System.out.print("Ingrese el número de la SEGUNDA carta: ");
            int numC2 = sc.nextInt();
            sc.nextLine();

            // los sc.nextLine() son para evitar que intervenga el salto de linea con el "Presione [ENTER]"

            InfoTurno turno = controlador.jugarTurno(numC1, numC2);
            if (!turno.esValido()) {
                System.out.println("❌ ¡Selección de cartas inválidas, recuerda elegir los números que se muestran disponibles!");
                System.out.print("Presione [ENTER] para volver a intentarlo...");
                sc.nextLine();
                continue;
            }
            boolean esPar = turno.esPar();
            Consola.limpiar();
            Carta c1 = turno.getCarta1();
            Carta c2 = turno.getCarta2();
            mostrarInfoTablero(false);
            // Mostrar mensajes respectivos para los resultados del turno
            if (esPar) {
                System.out.println(
                    "✅ ¡PAR ENCONTRADO! " + c1.getEmoji() + " El par \"" + c1.getContenido() + "\" (Cartas " + c1.getId() + " y " + c2.getId() + ") se mantendrán visibles." 
                );
            } else {
                System.out.println(
                    "❌ ¡Error! " + c1.getContenido() + " y " + c2.getContenido() + " no coinciden. " +
                    "Las cartas " + c1.getId() + " y " + c2.getId() + " serán cubiertas de nuevo.");
            }
            if (!esPar) {
                c1.voltear();
                c2.voltear();

                controlador.actualizarCartasTablero(c1, c2);
            }
            controlador.aumentarIntento();

            if (controlador.todosParesEncontrados()) {
                Consola.limpiar();
                mostrarInfoTablero(false);
                System.out.println("🎉 ¡FELICIDADES! ¡Has encontrado todos los pares en " + controlador.getIntentos() + " intentos! 🎉");
                break;
            }

            System.out.println("Presione [ENTER] para continuar al siguiente intento...");
            sc.nextLine();
        }

        if (!controlador.todosParesEncontrados()) {
            Consola.limpiar();
            mostrarInfoTablero(false);
            System.out.println("☹️ ¡LO SIENTO! No lograste encontrar todos los pares en menos de 20 intentos ¡inténtalo de nuevo!");
        }

        System.out.println("\nPresiona [ENTER] para volver al menú de selección");
        sc.nextLine();
    }
}
