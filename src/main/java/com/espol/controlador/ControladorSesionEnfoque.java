package com.espol.controlador;

import com.espol.modelo.SesionEnfoque;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControladorSesionEnfoque {
    private   List<SesionEnfoque> sesiones;

    public ControladorSesionEnfoque() {
        this.sesiones = new ArrayList<>();
    }

    public void agregarSesion(String tecnica, int duracion) {
        LocalDate fecha = LocalDate.now();
        SesionEnfoque nuevaSesion = new SesionEnfoque(fecha, tecnica, duracion);
        sesiones.add(nuevaSesion);
    }

    public List<SesionEnfoque> getSesiones() {
        return sesiones;
    }
}