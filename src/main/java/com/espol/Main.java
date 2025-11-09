package com.espol;
import com.espol.controlador.ControladorActividad;
import com.espol.controlador.InicializarApp;
import com.espol.vista.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean done = false;
        //Se crea el objeto para el control de las actividades
        ControladorActividad controlGestionActividad= new ControladorActividad();
        VistaActividad Vistacontrol=new VistaActividad();
        //Se crean los objetos encargados de la parte de hidratacion
        VistaControlDeHidratacion vistaControlDeHidratacion = new VistaControlDeHidratacion();
        //Se crea el objeto inicio para crear los registros que aparecen al iniciar la app.
        InicializarApp inicio = new InicializarApp();
        inicio.iniciar(vistaControlDeHidratacion.getControladorControlDeHidratacion(),controlGestionActividad);
        

        while (!done) {
            clearConsole();
            mostrarMenuSeleccion();
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    Vistacontrol.menu_GestiónActividades(controlGestionActividad);
                    break;
                case 2:
                    // No implementado todavía
                    break;
                case 3:
                    vistaControlDeHidratacion.menu_ControlDeHidratacion();
                    break;
                case 4:
                    // No implementado todavía
                    break;
                case 5:
                    // Se inicializa la clase VistaJuegoMemoria desde aquí para procurar tener tableros diferentes cada partida.
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