package com.espol.vista;

import com.espol.controlador.ControladorActividad;
import com.espol.controlador.ControladorSesionEnfoque;
import com.espol.modelo.Actividad;
import com.espol.modelo.ActividadAcademica;
import com.espol.modelo.SesionEnfoque;
import java.time.LocalDate;
import java.util.Scanner;

public class VistaSesionEnfoque {
    private ControladorSesionEnfoque controlador;
    private Scanner scanner;

    public VistaSesionEnfoque() {
        this.scanner = new Scanner(System.in);
        controlador=new ControladorSesionEnfoque();
    }

    public static void clearConsole() {
        System.out.print("\033\143");
    }

    public void menu(VistaActividad vistaActividad, ControladorActividad controladorActividad){
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
                    registrarSesion(vistaActividad,controladorActividad, controlador);
                    break;
                case "2":
                    verHistorial(controlador);
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (!opcion.equals("3"));
    }

    private void registrarSesion(VistaActividad vistaActividad, ControladorActividad controladorActividad,ControladorSesionEnfoque controladorSesionEnfoque){
        clearConsole();
        int opcion=0;
        do{
        System.out.println("--- REGISTRAR NUEVA SESIÓN DE ENFOQUE ---");
        System.out.println("Elija el Tipo de Sesión: ");
        System.out.println("1. Iniciar Pomodoro (25 min Trabajo / 5 min Descanso)");
        System.out.println("2. Iniciar Deep Work (Sesión Larga de 90 min)");
        System.out.println("3. Volver al Menú Principal");
        opcion = scanner.nextInt();
                switch (opcion) {
                case 1:
                    Pomodoro(vistaActividad, controladorActividad);

                    break;
                case 2:
                    DeepWork(vistaActividad, controladorActividad);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion!=3);
    
    }

    private void Pomodoro(VistaActividad vistaActividad, ControladorActividad controladorActividad){
        Scanner sc=new Scanner(System.in);
        Actividad act= vistaActividad.VistaSesion(controladorActividad);
        if(act instanceof ActividadAcademica){
            ActividadAcademica actividadAcademica= (ActividadAcademica) act;
            System.out.println(">>> INICIANDO TRABAJO EN"+"'"+act.getNombre()+"' <<<");
            System.out.println(" Técnica: Pomodoro | Ciclo: 1/4");
            System.out.println("Tiempo de Trabajo: 25:00 minutos restantes");
            sc.nextLine();
            System.out.println("--- ¡TIEMPO DE TRABAJO TERMINADO! ---");
            System.out.println("Sesión registrada. (Avance de la actividad ID "+ act.getId()+" actualizado en base al tiempo). ");
            System.out.println("Ahora toma un DESCANSO: 05:00 minutos restantes\r\n" + //
                                "Presione [ENTER] para iniciar el descanso...\r\n" + //
                                "");
            
            sc.nextLine();
             sc.nextLine();
            System.out.println(">>> CONTINUANDO TRABAJO EN"+"'"+act.getNombre()+"' <<<");
            System.out.println(" Técnica: Pomodoro | Ciclo: 2/4");
            System.out.println("Tiempo de Trabajo: 25:00 minutos restantes");
            sc.nextLine();
            System.out.println("--- ¡TIEMPO DE TRABAJO TERMINADO! ---");
            System.out.println("Sesión registrada. (Avance de la actividad ID "+ act.getId()+" actualizado en base al tiempo). ");
            System.out.println("Ahora toma un DESCANSO: 05:00 minutos restantes\r\n" + //
                                "Presione [ENTER] para iniciar el descanso...\r\n" + //
                                "");
             sc.nextLine();
              sc.nextLine();
            System.out.println(">>> CONTINUANDO TRABAJO EN"+"'"+act.getNombre()+"' <<<");
            System.out.println(" Técnica: Pomodoro | Ciclo: 3/4");
            System.out.println("Tiempo de Trabajo: 25:00 minutos restantes");
            sc.nextLine();
            System.out.println("--- ¡TIEMPO DE TRABAJO TERMINADO! ---");
            System.out.println("Sesión registrada. (Avance de la actividad ID "+ act.getId()+" actualizado en base al tiempo). ");
            System.out.println("Ahora toma un DESCANSO: 05:00 minutos restantes\r\n" + //
                                "Presione [ENTER] para iniciar el descanso...\r\n" + //
                                "");
              sc.nextLine();
               sc.nextLine();
            System.out.println(">>> CONTINUANDO TRABAJO EN"+"'"+act.getNombre()+"' <<<");
            System.out.println(" Técnica: Pomodoro | Ciclo: 4/4");
            System.out.println("Tiempo de Trabajo: 25:00 minutos restantes");
            sc.nextLine();
            System.out.println("--- ¡TIEMPO DE TRABAJO TERMINADO! ---");
            System.out.println("Sesión registrada. (Avance de la actividad ID "+ act.getId()+" actualizado en base al tiempo). ");
            System.out.println("Ahora toma un DESCANSO: 05:00 minutos restantes\r\n" + //
                                "Presione [ENTER] para iniciar el descanso...\r\n" + //
                                "");
            sc.nextLine();
           int  tiempo=100;
            SesionEnfoque Pomodoroact=new SesionEnfoque(LocalDate.now(), "POMODORO", tiempo);
            controlador.getSesiones().add(Pomodoroact);
            actividadAcademica.getControladorSesionEnfoque().getSesiones().add(Pomodoroact);

        }
       

    }
    private void DeepWork(VistaActividad vistaActividad, ControladorActividad controladorActividad){
          Scanner sc=new Scanner(System.in);
           Actividad act= vistaActividad.VistaSesion(controladorActividad);
            if(act instanceof ActividadAcademica){
            ActividadAcademica actividadAcademica= (ActividadAcademica) act;
            System.out.println(">>> INICIANDO TRABAJO EN"+"'"+act.getNombre()+"' <<<");
            
            System.out.println(" Técnica: Deep Work  Ciclo: 1/1");
            System.out.println("Tiempo de Trabajo: 90:00 minutos restantes");
            sc.nextLine();
            System.out.println("--- ¡TIEMPO DE TRABAJO TERMINADO! ---");
            System.out.println("Sesión registrada. (Avance de la actividad ID "+ act.getId()+" actualizado en base al tiempo). ");
            int tiempo=90;
            SesionEnfoque Deepworkact=new SesionEnfoque(LocalDate.now(), "DEEP WORK", tiempo);
            controlador.getSesiones().add(Deepworkact);
            actividadAcademica.getControladorSesionEnfoque().getSesiones().add(Deepworkact);

            }           
    }

    private void verHistorial(ControladorSesionEnfoque controlador){
        clearConsole();
        System.out.println("--- HISTORIAL DE SESIONES DE ENFOQUE ---");
        for (SesionEnfoque sesion : controlador.getSesiones()) {
            System.out.println("Fecha: " + sesion.getFecha() + " | Técnica: " + sesion.getTecnicaAplicada() + " | Duración: " + sesion.getDuracionMinutos() + " min");
        }
        System.out.println("\nPresione [ENTER] para volver...");
        scanner.nextLine();
    }
public ControladorSesionEnfoque getControladorSesionEnfoque(){
    return controlador;
}
}