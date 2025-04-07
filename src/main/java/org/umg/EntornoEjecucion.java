package org.umg;

import org.umg.arbol.Nodo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntornoEjecucion {
    private final Map<String, Object> variables;
    private final Map<String, FuncionDefinicion> funciones;
    private EntornoEjecucion padre;

    public EntornoEjecucion() {
        this.variables = new HashMap<>();
        this.funciones = new HashMap<>();
        this.padre = null;
    }

    public EntornoEjecucion(EntornoEjecucion padre) {
        this.variables = new HashMap<>();
        this.funciones = new HashMap<>();
        this.padre = padre;
    }

    public void definirVariable(String nombre, Object valor) {
        variables.put(nombre, valor);
    }

    public void asignarVariable(String nombre, Object valor) {
        // Si la variable existe en este entorno, se actualiza
        if (variables.containsKey(nombre)) {
            variables.put(nombre, valor);
            return;
        }

        // Si no, y hay un entorno padre, se busca ahí
        if (padre != null) {
            padre.asignarVariable(nombre, valor);
            return;
        }

        // Si no existe en ningún lugar, se crea en el entorno actual
        variables.put(nombre, valor);
    }

    public Object obtenerVariable(String nombre) {
        if (variables.containsKey(nombre)) {
            return variables.get(nombre);
        }

        if (padre != null) {
            return padre.obtenerVariable(nombre);
        }

        throw new RuntimeException("Scout no encontrado: " + nombre);
    }

    public void definirFuncion(String nombre, List<String> parametros, Nodo cuerpo) {
        funciones.put(nombre, new FuncionDefinicion(parametros, cuerpo));
    }

    public FuncionDefinicion obtenerFuncion(String nombre) {
        if (funciones.containsKey(nombre)) {
            return funciones.get(nombre);
        }

        if (padre != null) {
            return padre.obtenerFuncion(nombre);
        }

        throw new RuntimeException("Estrategia no encontrada: " + nombre);
    }

    public boolean existeFuncion(String nombre) {
        return funciones.containsKey(nombre) || (padre != null && padre.existeFuncion(nombre));
    }

    public static class FuncionDefinicion {
        private final List<String> parametros;
        private final Nodo cuerpo;

        public FuncionDefinicion(List<String> parametros, Nodo cuerpo) {
            this.parametros = new ArrayList<>(parametros);
            this.cuerpo = cuerpo;
        }

        public List<String> getParametros() {
            return parametros;
        }

        public Nodo getCuerpo() {
            return cuerpo;
        }
    }
}