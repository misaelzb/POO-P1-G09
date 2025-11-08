package com.espol.modelo;

public class Carta {
    private int id;
    private String contenido;
    private boolean volteada;
    private boolean parEncontrado;

    public Carta(int id, String contenido) {
        this.id = id;
        this.contenido = contenido;
        this.volteada = false;
        this.parEncontrado = false;
    }

    public void voltear() {
        this.volteada = !this.volteada;
    }

    public boolean esPar(Carta carta) {
        // En caso de que los dos coincidan, retorna true
        return carta.getContenido().equals(this.getContenido());
    }

    public int getId() {
        return id;
    }
    public String getContenido() {
        return contenido;
    }

    public boolean tieneParEncontrado() {
        return parEncontrado;
    }

    public boolean estaVolteada() {
        return volteada;
    }

    public void setParEncontrado(boolean parEncontrado) {
        this.parEncontrado = parEncontrado;
    }

    public String getEmoji() {
        for (String[] contentData : JuegoMemoria.CONTENIDOS) {
            if (contentData[1].equals(this.contenido))
                return contentData[0];
        }
        return null;
    }
}
