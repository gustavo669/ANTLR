package org.umg.errores;

import java.util.Objects;

/**
 * Representa un error léxico detectado durante el análisis de código fuente.
 */
public class ErrorLexico {
    private final String valor;
    private final int linea;
    private final int columna;
    private final String mensaje;

    public ErrorLexico(String valor, int linea, int columna, String mensaje) {
        this.valor = Objects.requireNonNull(valor, "El valor no puede ser nulo").trim();
        this.mensaje = Objects.requireNonNull(mensaje, "El mensaje no puede ser nulo").trim();

        if (this.valor.isEmpty()) {
            throw new IllegalArgumentException("El valor del error no puede estar vacío");
        }
        if (this.mensaje.isEmpty()) {
            throw new IllegalArgumentException("El mensaje del error no puede estar vacío");
        }
        if (linea <= 0 || columna <= 0) {
            throw new IllegalArgumentException("La línea y columna deben ser mayores que cero");
        }

        this.linea = linea;
        this.columna = columna;
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

    public String getMensaje() {
        return mensaje;
    }

    @Override
    public String toString() {
        return String.format("⚠️ [Línea %d, Columna %d] %s → '%s'", linea, columna, mensaje, valor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ErrorLexico that)) return false;
        return linea == that.linea &&
                columna == that.columna &&
                valor.equals(that.valor) &&
                mensaje.equals(that.mensaje);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, linea, columna, mensaje);
    }
}
