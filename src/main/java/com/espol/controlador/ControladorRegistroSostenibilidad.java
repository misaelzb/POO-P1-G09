package com.espol.controlador;

import com.espol.modelo.RegistroSostenibilidad;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControladorRegistroSostenibilidad {
    private List<RegistroSostenibilidad> registros;

    public ControladorRegistroSostenibilidad() {
        this.registros = new ArrayList<>();
    }

    public void agregarRegistro(String[] acciones, int puntos) {
        LocalDate fecha = LocalDate.now();
        RegistroSostenibilidad nuevoRegistro = new RegistroSostenibilidad(fecha, acciones, puntos);
        registros.add(nuevoRegistro);
    }

    public List<RegistroSostenibilidad> getRegistros() {
        return registros;
    }

    public int calcularPuntosTotales() {
        return registros.stream()
                        .mapToInt(RegistroSostenibilidad::getPuntosObtenidos)
                        .sum();
    }
}