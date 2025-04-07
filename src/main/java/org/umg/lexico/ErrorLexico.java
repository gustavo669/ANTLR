package org.umg.analisis.lexico;

import java.util.Objects;

/**
 * Representa un error léxico encontrado durante el análisis de código fuente.
 * Contiene información sobre el valor problemático y su ubicación.
 */
public class ErrorLexico {
    private final String valor;
    private final int linea;
    private final int columna;
    private final String mensaje;

    /**
     * Crea un nuevo error léxico.
     *
     * @param valor El token o valor que causó el error
     * @param linea El número de línea donde ocurrió el error (1-based)
     * @param columna El número de columna donde ocurrió el error (1-based)
     * @param mensaje Mensaje descriptivo del error
     * @throws IllegalArgumentException si los parámetros no son válidos
     */
    public ErrorLexico(String valor, int linea, int columna, String mensaje) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El valor del error no puede ser nulo o vacío");
        }
        if (linea <= 0) {
            throw new IllegalArgumentException("El número de línea debe ser positivo");
        }
        if (columna <= 0) {
            throw new IllegalArgumentException("El número de columna debe ser positivo");
        }
        if (mensaje == null || mensaje.trim().isEmpty()) {
            throw new IllegalArgumentException("El mensaje de error no puede ser nulo o vacío");
        }

        this.valor = valor;
        this.linea = linea;
        this.columna = columna;
        this.mensaje = mensaje;
    }

    /**
     * Versión simplificada del constructor para compatibilidad.
     */
    public ErrorLexico(String valor, int linea) {
        this(valor, linea, 1, "Token no reconocido");
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

    /**
     * Obtiene la posición del error en formato "línea:columna".
     */
    public String getPosicion() {
        return linea + ":" + columna;
    }

    @Override
    public String toString() {
        return String.format("Error léxico en %s - %s: '%s'",
                getPosicion(), mensaje, valor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorLexico that = (ErrorLexico) o;
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