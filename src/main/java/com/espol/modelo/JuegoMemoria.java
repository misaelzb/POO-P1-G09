package com.espol.modelo;
import java.util.*;

public class JuegoMemoria {
    protected int paresEncontrados;

    public static final String[][] CONTENIDOS = {
        {"♻️","RECIC"},
        {"💧","AGUAS"},
        {"☀️","SOLAR"},
        {"🌬️","EOLIC"},
        {"🦏","FAUNA"},
        {"🌿","VERDE"},
        {"🍂","CAMPO"},
        {"🚯","PLAST"},
        {"🌡️","CLIMA"},
        {"🌳","BOSQU"},
        {"🔁","REUSA"},
        {"🗑️","RESID"},
        {"🛁","AHORR"},
        {"🧼","LIMPI"},
        {"🐟","OCEAN"},
        {"🌀","GASES"},
        {"🦋","BIOMA"},
        {"📄","PAPEL"},
        {"🔆","RENOV"},
        {"🚲","BICIC"},
        {"🌱","REGEN"}
    };

    private Carta[][] tablero;

    private int filasTablero;
    private int columnasTablero;


    public JuegoMemoria() {
        this.filasTablero = 4;
        this.columnasTablero = 4;
        this.tablero = new Carta[filasTablero][columnasTablero];
        this.paresEncontrados = 0;
    }

    public void inicializarTablero() {
        // Asignación de cartas en el array multidimensional con valor null del contenido inicialmente.
        int currentId = 1;
        for (int row = 0; row < filasTablero; row++) {
            for (int col = 0; col < columnasTablero; col++) {
                establecerCarta(new Carta(currentId, null), row, col);
                currentId++;
            }
        }   

        int cartasAsignadas = 0;
        ArrayList<String> contenidoAsignado = new ArrayList<String>();
        while (cartasAsignadas < filasTablero * columnasTablero) {
            int row = (int)(Math.random() * 4);
            int col = (int)(Math.random() * 4);
            if (obtenerCartaPorPosicion(row, col).getContenido() == null) {
                int rndContentIndex = (int)(Math.random() * (CONTENIDOS.length - 1));
                String[] rndContentData = CONTENIDOS[rndContentIndex];

                // Empieza un bucle hasta encontrar un "contenido" que no haya sido asignado todavía
                while (contenidoAsignado.contains(rndContentData[1])) {
                    rndContentIndex = (int)(Math.random() * (CONTENIDOS.length - 1));
                    rndContentData = CONTENIDOS[rndContentIndex];
                }

                establecerCarta(
                    new Carta(obtenerCartaPorPosicion(row, col).getId(), 
                    rndContentData[1]), row, col);

                // Falta asignar la carta gemela
                boolean gemelaAsignada = false;
                while (!gemelaAsignada) {
                    int row2 = (int)(Math.random() * 4);
                    int col2 = (int)(Math.random() * 4);
                    Carta carta2 = obtenerCartaPorPosicion(row2, col2);
                    if (carta2.getContenido() == null) {
                        establecerCarta(new Carta(carta2.getId(), rndContentData[1]), row2, col2);
                        gemelaAsignada = true;
                    }
                }
                cartasAsignadas += 2;
                contenidoAsignado.add(rndContentData[1]);
            }
        }
    }

    public void actualizarEstadoCarta(Carta carta) {
        for (int r = 0; r < filasTablero; r++) 
            for (int c = 0; c < columnasTablero; c++) {
                Carta carta0 = obtenerCartaPorPosicion(r, c);
                if (carta0.getId() == carta.getId()) this.tablero[r][c] = carta;
            }
    }

    public Carta obtenerCartaPorPosicion(int fila, int columna) {
        return this.tablero[fila][columna];
    }

    public Carta obtenerCartaPorIndice(int id) {
        for (Carta[] fila : this.tablero) {
            for (Carta c : fila) {
                if (c != null && c.getId() == id) {
                    return c;
                }
            }
        }
        return null;
    }

    public void establecerCarta(Carta carta, int fila, int columna) {
        this.tablero[fila][columna] = carta;
    }

    public int getFilasTablero() {
        return filasTablero;
    }

    public int getColumnasTablero() {
        return columnasTablero;
    }

    public Carta[][] getTablero() {
        return this.tablero;
    }

}
