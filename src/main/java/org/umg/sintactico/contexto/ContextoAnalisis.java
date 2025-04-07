package org.umg.sintactico.contexto;

import org.umg.TipoToken;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Mantiene el estado y contexto durante el análisis sintáctico.
 * Administra tablas de símbolos, ámbito actual y otra información contextual.
 */
public class ContextoAnalisis {
    // Pila de ámbitos para manejar bloques anidados
    private final Stack<Map<String, InformacionVariable>> tablaSimbolos;
    private TipoRetorno tipoRetornoActual;
    private boolean enEstructuraControl;

    public ContextoAnalisis() {
        this.tablaSimbolos = new Stack<>();
        this.tablaSimbolos.push(new HashMap<>()); // Ámbito global
        this.tipoRetornoActual = TipoRetorno.VOID;
        this.enEstructuraControl = false;
    }

    /**
     * Abre un nuevo ámbito (al entrar en un bloque {})
     */
    public void abrirAmbito() {
        tablaSimbolos.push(new HashMap<>());
    }

    /**
     * Cierra el ámbito actual (al salir de un bloque {})
     */
    public void cerrarAmbito() {
        if (tablaSimbolos.size() > 1) { // No permitir eliminar el ámbito global
            tablaSimbolos.pop();
        }
    }

    /**
     * Declara una nueva variable en el ámbito actual
     */
    public void declararVariable(String nombre, TipoToken tipo) {
        if (existeEnAmbitoActual(nombre)) {
            throw new RuntimeException("Variable ya declarada: " + nombre);
        }
        tablaSimbolos.peek().put(nombre, new InformacionVariable(tipo));
    }

    /**
     * Verifica si una variable existe en el ámbito actual o superiores
     */
    public boolean existeVariable(String nombre) {
        return tablaSimbolos.stream()
                .anyMatch(ambito -> ambito.containsKey(nombre));
    }

    /**
     * Verifica si una variable existe solo en el ámbito actual
     */
    public boolean existeEnAmbitoActual(String nombre) {
        return tablaSimbolos.peek().containsKey(nombre);
    }

    /**
     * Obtiene información sobre una variable
     */
    public InformacionVariable obtenerVariable(String nombre) {
        for (int i = tablaSimbolos.size() - 1; i >= 0; i--) {
            if (tablaSimbolos.get(i).containsKey(nombre)) {
                return tablaSimbolos.get(i).get(nombre);
            }
        }
        throw new RuntimeException("Variable no declarada: " + nombre);
    }

    // Getters y setters para estado del análisis
    public TipoRetorno getTipoRetornoActual() {
        return tipoRetornoActual;
    }

    public void setTipoRetornoActual(TipoRetorno tipo) {
        this.tipoRetornoActual = tipo;
    }

    public boolean isEnEstructuraControl() {
        return enEstructuraControl;
    }

    public void setEnEstructuraControl(boolean enEstructuraControl) {
        this.enEstructuraControl = enEstructuraControl;
    }

    /**
     * Clase interna para almacenar información de variables
     */
    public static class InformacionVariable {
        private final TipoToken tipo;
        private boolean inicializada;

        public InformacionVariable(TipoToken tipo) {
            this.tipo = tipo;
            this.inicializada = false;
        }

        // Getters y setters
        public TipoToken getTipo() {
            return tipo;
        }

        public boolean isInicializada() {
            return inicializada;
        }

        public void setInicializada(boolean inicializada) {
            this.inicializada = inicializada;
        }
    }

    /**
     * Enumeración para tipos de retorno
     */
    public enum TipoRetorno {
        VOID, ENTERO, DECIMAL, CADENA, BOOLEANO
    }
}