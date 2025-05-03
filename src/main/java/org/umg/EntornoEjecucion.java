package org.umg;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa un entorno de ejecución o "formación" en el que los scouts operan.
 * Soporta jerarquías entre entornos como en una cadena de mando.
 */
public class EntornoEjecucion {
    private final Map<String, Object> formacion; // Variables en este entorno
    private final EntornoEjecucion comandante;   // Entorno superior (padre)

    public EntornoEjecucion() {
        this.formacion = new HashMap<>();
        this.comandante = null;
    }

    public EntornoEjecucion(EntornoEjecucion comandante) {
        this.formacion = new HashMap<>();
        this.comandante = comandante;
    }

    /**
     * Declara o crea una nueva variable en el entorno actual.
     */
    public void setVariable(String nombre, Object valor) {
        formacion.put(nombre, valor);
    }

    /**
     * Asigna un valor a una variable ya existente en la jerarquía de entornos.
     */
    public void asignarVariable(String nombre, Object valor) {
        if (formacion.containsKey(nombre)) {
            formacion.put(nombre, valor);
        } else if (comandante != null) {
            comandante.asignarVariable(nombre, valor);
        } else {
            throw new RuntimeException("⚠ Scout '" + nombre + "' no ha sido enlistado en ninguna formación.");
        }
    }


    /**
     * Obtiene el valor de una variable buscándola en el entorno actual y ascendiendo si es necesario.
     */
    public Object obtenerVariable(String nombre) {
        if (formacion.containsKey(nombre)) {
            return formacion.get(nombre);
        } else if (comandante != null) {
            return comandante.obtenerVariable(nombre);
        } else {
            throw new RuntimeException("Scout '" + nombre + "' no ha sido encontrado en la cadena de mando.");
        }

    }
}
