package com.espol.controlador;

import com.espol.modelo.Carta;
import com.espol.modelo.JuegoMemoria;

public class ControladorJuegoMemoria {
    public JuegoMemoria juego;
    private int intentos = 0;
    private int paresEncontrados = 0;

    // Esta clase solo tiene el propósito de poder acceder a información del turno en el controlador de forma que sea fácil de leer.
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
        final int ANCHO_CELDA = 10;
        // Uso de StringBuilder para facilidad de modificar la cadena continuamente.
        StringBuilder sb = new StringBuilder();

        // Se crea el separador de entre filas, adaptado a la cantidad de columnas.
        String rowSeparator = ("+" + "-".repeat(ANCHO_CELDA)).repeat(this.juego.getColumnasTablero()) + "+\n";
        sb.append(rowSeparator);

        for (int row = 0; row < this.juego.getFilasTablero(); row++) {

            for (int col = 0; col < this.juego.getColumnasTablero(); col++) {
                String content;
                Carta[][] tablero = this.juego.getTablero();

                // Lógica para que en cada columna se agregue el contenido respectivo, ya sea que la carta esté volteada o no.
                if (!tablero[row][col].estaVolteada()) {
                    content = String.valueOf(tablero[row][col].getId());
                } else {
                    content = tablero[row][col].getContenido();
                }
                sb.append("|");

                // Lógica para que lograr que el contenido esté centrado en la celda actual.
                String centeredContent;
                if (content.length() >= ANCHO_CELDA) {
                    // Recortar en caso que el contenido sea demasiado largo.
                    centeredContent = content.substring(0, ANCHO_CELDA);
                } else {
                    // Separa con espacios (padding) por izquierda y por derecha para lograr el efecto de centrado
                    int totalPadding = ANCHO_CELDA - content.length();
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
        // Una vez que encuentre una carta cuyo par esté encontrado, retorna falso.
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

        // En caso de que esto se cumpla, retorna una instancia de la clase InfoTurno con datos vacios y 'válido' en false.
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

    public String getDataCartasVolteadas_Debug() {
        // Muestra todas las cartas como si fuese un mini tablero pero con el contenido revelado para facilitar el testeo del juego
        // usa el formato de [A][B][C][B] ...
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < this.juego.getFilasTablero(); r++) {
            for (int c = 0; c < this.juego.getColumnasTablero(); c++) {
                Carta carta = this.juego.obtenerCartaPorPosicion(r, c);
                sb.append("[" + carta.getContenido() + "]");
            }
            sb.append("\n");
        }
        return sb.toString();
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
