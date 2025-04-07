package org.umg;

import java.util.Objects;

public class Token {
    private final TipoToken tipo;
    private final String valor;
    private final int linea;
    private final int columna;

    public Token(TipoToken tipo, String valor, int linea, int columna) {
        this.tipo = Objects.requireNonNull(tipo, "El tipo de token no puede ser nulo");
        this.valor = Objects.requireNonNull(valor, "El valor del token no puede ser nulo");

        if (linea <= 0) {
            throw new IllegalArgumentException("El número de línea debe ser positivo");
        }
        if (columna <= 0) {
            throw new IllegalArgumentException("El número de columna debe ser positivo");
        }

        this.linea = linea;
        this.columna = columna;
    }

    public Token(TipoToken tipo, String valor, int linea) {
        this(tipo, valor, linea, 1);
    }

    public TipoToken getTipo() {
        return tipo;
    }

    public String getValor() {
        return valor;
    }

    public int getLinea() {
        return linea;
    }

    public int getColumna() {
        return columna;
    }

    public String getPosicion() {
        return linea + ":" + columna;
    }

    @Override
    public String toString() {
        return String.format("Token[%s: '%s' @ %s]", tipo, valor, getPosicion());
    }
}