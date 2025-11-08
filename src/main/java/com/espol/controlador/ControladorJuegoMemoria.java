package com.espol.controlador;

import com.espol.modelo.Carta;
import com.espol.modelo.JuegoMemoria;

public class ControladorJuegoMemoria {
    public JuegoMemoria juego;
    private int intentos = 0;
    private int paresEncontrados = 0;

    public static class InfoTurno {
        private boolean esPar;
        private Carta carta1;
        private Carta carta2;
        private boolean valido;

        public InfoTurno(boolean esPar, Carta carta1, Carta carta2, boolean valido) {
            this.esPar = esPar;
            this.carta1 = carta1;
            this.carta2 = carta2;
            this.valido = valido;
        }

        public boolean esPar() {
            return esPar;
        }

        public Carta getCarta1() {
            return carta1;
        }

        public Carta getCarta2() {
            return carta2;
        }

        public boolean esValido() {
            return this.valido;
        }
    }

    public ControladorJuegoMemoria() {
        this.juego = new JuegoMemoria();
        this.juego.inicializarTablero();
    }

    public String getDataTablero() {
        final int CELL_WIDTH = 10;
        StringBuilder sb = new StringBuilder();
        String rowSeparator = ("+" + "-".repeat(CELL_WIDTH)).repeat(this.juego.getColumnasTablero()) + "+\n";

        sb.append(rowSeparator);

        for (int row = 0; row < this.juego.getFilasTablero(); row++) {

            for (int col = 0; col < this.juego.getColumnasTablero(); col++) {
                String content;
                Carta[][] tablero = this.juego.getTablero();

                if (!tablero[row][col].estaVolteada()) {
                    content = String.valueOf(tablero[row][col].getId());
                } else {
                    content = tablero[row][col].getContenido();
                }
                sb.append("|");

                String centeredContent;
                if (content.length() >= CELL_WIDTH) {
                    centeredContent = content.substring(0, CELL_WIDTH);
                } else {
                    int totalPadding = CELL_WIDTH - content.length();
                    int leftPadding = totalPadding / 2;
                    int rightPadding = totalPadding - leftPadding;
                    centeredContent = " ".repeat(leftPadding) + content + " ".repeat(rightPadding);
                }

                sb.append(centeredContent);
            }
            sb.append("|\n");
            sb.append(rowSeparator);
        }

        return sb.toString();
    }

    public boolean todosParesEncontrados() {
        boolean todoEncontrado = true;
        for (int r = 0; r < this.juego.getFilasTablero(); r++)
            for (int c = 0; c < this.juego.getColumnasTablero(); c++) {
                if (!this.juego.obtenerCartaPorPosicion(r, c).tieneParEncontrado())
                    todoEncontrado = false;
            }
        return todoEncontrado;
    }

    public InfoTurno jugarTurno(int numC1, int numC2) {
        Carta carta1 = this.juego.obtenerCartaPorIndice(numC1);
        Carta carta2 = this.juego.obtenerCartaPorIndice(numC2);

        if (carta1 == null || carta2 == null || carta1.estaVolteada() || carta2.estaVolteada() || carta1.tieneParEncontrado() || carta2.tieneParEncontrado())
            return new InfoTurno(false, null, null, false);

        carta1.voltear();
        carta2.voltear();

        boolean esPar = carta1.esPar(carta2);
        if (esPar) {
            this.paresEncontrados++;
            carta1.setParEncontrado(true);
            carta2.setParEncontrado(true);
            this.actualizarCartasTablero(carta1, carta2);
        }
        return new InfoTurno(esPar, carta1, carta2, true);
    }

    public int getIntentos() {
        return intentos;
    }

    public int getParesEncontrados() {
        return paresEncontrados;
    }

    public void actualizarCartasTablero(Carta... cartas) {
        for (Carta carta: cartas) this.juego.actualizarEstadoCarta(carta);
    }

    public void aumentarIntento() {
        this.intentos++;
    }
}
