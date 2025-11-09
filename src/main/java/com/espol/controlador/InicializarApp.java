package com.espol.controlador;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.espol.modelo.SesionEnfoque;

public class InicializarApp {
    public InicializarApp(){
    }
    //Para que se guarden registros al iniciar app
    public void iniciar(ControladorControlDeHidratacion controlador_Hidratacion, ControladorActividad controladorActividad, ControladorSesionEnfoque controladorSesionEnfoque1){
        controlador_Hidratacion.CrearRegistros(100, 2500, 9, 30);
        controlador_Hidratacion.CrearRegistros(100, 11, 30);
        SesionEnfoque Pomodoroact1 =new SesionEnfoque(LocalDate.of(2025,11,9), "POMODORO", 25);
        SesionEnfoque Pomodoroact2 =new SesionEnfoque(LocalDate.of(2025,11,10), "POMODORO", 25);
        ControladorSesionEnfoque controladorSesionEnfoque=new ControladorSesionEnfoque();
        controladorSesionEnfoque.getSesiones().add(Pomodoroact1);
        controladorSesionEnfoque.getSesiones().add(Pomodoroact2);
        controladorSesionEnfoque1.getSesiones().add(Pomodoroact1);
        controladorSesionEnfoque1.getSesiones().add(Pomodoroact2);
        controladorActividad.crearActividadPersonal(1, "Cita Médica", "Cita Médica muy importante", LocalDateTime.of(2025, 11, 30, 12, 00), "ALTA", 45, 0.0,"Centro Médico");
        controladorActividad.crearActividadAcademica(2, "Proyecto 1", "Proyecto a realizar",LocalDateTime.of(2025, 11, 30, 12, 00), "ALTA", 2880.0, 70, "POO", "PROYECTO", controladorSesionEnfoque);
        controladorActividad.crearActividadAcademica(3,"Tarea 1","Tarea por realizar",LocalDateTime.of(2025,12,3,23,59),"ALTA", 60.0,0.0,"POO", "TAREA");
        controladorActividad.crearActividadAcademica(4,"Examen 1","Examen pendiente",LocalDateTime.of(2025,12,10,12,30),"ALTA", 120.0,0.0,"POO", "EXAMEN");

}
}
