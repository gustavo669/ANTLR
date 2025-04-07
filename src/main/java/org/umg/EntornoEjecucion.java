package org.umg;

import org.umg.arbol.Nodo;

import java.util.HashMap;
import java.util.Map;

public class EntornoEjecucion {
    private final Map<String, Object> variables;
    private EntornoEjecucion padre;

    public EntornoEjecucion() {
        this.variables = new HashMap<>();
        this.padre = null;
    }

    public EntornoEjecucion(EntornoEjecucion padre) {
        this.variables = new HashMap<>();
        this.padre = padre;
    }

    public void definirVariable(String nombre, Object valor) {
        variables.put(nombre, valor);
    }

    public void asignarVariable(String nombre, Object valor) {
        if (variables.containsKey(nombre)) {
            variables.put(nombre, valor);
        } else if (padre != null) {
            padre.asignarVariable(nombre, valor);
        } else {
            throw new RuntimeException("Variable no definida: " + nombre);
        }
    }

    public Object obtenerVariable(String nombre) {
        if (variables.containsKey(nombre)) {
            return variables.get(nombre);
        } else if (padre != null) {
            return padre.obtenerVariable(nombre);
        } else {
            throw new RuntimeException("Variable no encontrada: " + nombre);
        }
    }
}
