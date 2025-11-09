package com.espol;

import com.espol.controlador.ControladorActividad;
import com.espol.controlador.InicializarApp;
import com.espol.helpers.Consola;
import com.espol.vista.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean done = false;
        // Se crean los objetos para el control de las actividades
        ControladorActividad controlGestionActividad = new ControladorActividad();
        VistaActividad Vistacontrol = new VistaActividad();
        // Se crea el objetos para la sesion de enfoque
        VistaSesionEnfoque VistaSesion = new VistaSesionEnfoque();
        // Se crea el objeto para el control del registro de sostenibilidad
        VistaRegistroSostenibilidad VistaRegistroSostenibilidad = new VistaRegistroSostenibilidad();
        // Se crean los objetos encargados de la parte de hidratacion
        VistaControlDeHidratacion vistaControlDeHidratacion = new VistaControlDeHidratacion();
        // Se crea el objeto inicio para crear los registros que aparecen al iniciar la
        // app.
        InicializarApp inicio = new InicializarApp();
        inicio.iniciar(vistaControlDeHidratacion.getControladorControlDeHidratacion(), controlGestionActividad,
                VistaSesion.getControladorSesionEnfoque());

        while (!done) {
            Consola.limpiar();
            mostrarMenuSeleccion();
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    Vistacontrol.menu_GestiónActividades(controlGestionActividad);
                    break;
                case 2:
                    VistaSesion.menu(Vistacontrol, controlGestionActividad);
                    break;
                case 3:
                    vistaControlDeHidratacion.menu_ControlDeHidratacion();
                    break;
                case 4:
                    VistaRegistroSostenibilidad.menu();
                    break;
                case 5:
                    // Se inicializa la clase VistaJuegoMemoria desde aquí para procurar tener
                    // tableros diferentes cada partida.
                    VistaJuegoMemoria juegoMemoria = new VistaJuegoMemoria();
                    juegoMemoria.iniciarJuego();
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

    public static void mostrarMenuSeleccion() {
        System.out.println(
                "1. Gestión de Actividades\n" +
                        "2. Técnicas de Enfoque (Manejo de tiempo)\n" +
                        "3. Control de hidratación\n" +
                        "4. Registro diario de Sostenibilidad\n" +
                        "5. Juego de memoria\n" +
                        "6. Salir");
        System.out.print("Ingrese el número del programa a ejecutar: ");
    }
}