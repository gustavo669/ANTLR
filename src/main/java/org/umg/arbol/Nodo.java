package org.umg.arbol;

import java.util.*;

/**
 * Representa un nodo dentro del árbol de derivación para el análisis sintáctico.
 * Cada nodo puede tener hijos y un tipo específico asociado a la gramática de la aplicación.
 */
public class Nodo {
    private final String valor;
    private final List<Nodo> hijos;
    private TipoNodo tipo;
    private final int linea;
    private final int columna;

    // Enum que representa los tipos de nodos en el árbol de derivación
    public enum TipoNodo {
        MISION("Misión principal"),
        DISTRITO("Distrito/bloque de código"),
        TACTICA("Táctica/operación"),
        SCOUT("Scout/identificador"),
        RECURSO("Recurso numérico"),
        GRITO("Grito de batalla/cadena"),
        TITAN("Estructura titan (if)"),
        LEGION("Cláusula legion (else)"),
        ATAQUE("Estructura ataque (while)"),
        MURO("Estructura muro (for)"),
        ORDEN_MILITAR("Orden militar (print)"),
        EQUIPO("Equipo de maniobras");

        private final String descripcion;

        TipoNodo(String descripcion) {
            this.descripcion = descripcion;
        }

        @Override
        public String toString() {
            return descripcion;
        }
    }

    public Nodo getHijo(int index) {
        return hijos.get(index);
    }

    /**
     * Constructor para crear un nodo con valor y tipo específico, además de su línea y columna de origen.
     */
    public Nodo(String valor, TipoNodo tipo, int linea, int columna) {
        this.valor = Objects.requireNonNull(valor, "¡El valor del nodo no puede ser nulo!");
        this.tipo = Objects.requireNonNull(tipo, "¡El tipo de nodo no puede ser nulo!");
        this.linea = linea;
        this.columna = columna;
        this.hijos = new ArrayList<>();
    }

    /**
     * Agrega un hijo al nodo actual.
     */
    public void agregarHijo(Nodo hijo) {
        if (hijo == null) {
            throw new IllegalArgumentException("¡Un scout no puede estar ausente en la formación!");
        }
        hijos.add(hijo);
    }

    // Getters para los atributos privados
    public String getValor() {
        return valor;
    }

    public List<Nodo> getHijos() {
        return Collections.unmodifiableList(hijos);
    }

    public TipoNodo getTipo() {
        return tipo;
    }

    /**
     * Imprime el árbol de manera visualmente estructurada.
     */
    public void imprimirArbol() {
        imprimirArbol("", true);
    }

    /**
     * Imprime el árbol con los nodos de forma jerárquica.
     * @param prefijo Cadena que se usa para las ramas del árbol.
     * @param esUltimo Indica si el nodo actual es el último en la lista de hijos.
     */
    private void imprimirArbol(String prefijo, boolean esUltimo) {
        // Imprime la información del nodo (tipo y valor)
        System.out.println(prefijo + (esUltimo ? "└── " : "├── ") +
                tipo + ": " + valor + " [Línea " + linea + ", Columna " + columna + "]");

        // Imprime todos los hijos de este nodo
        for (int i = 0; i < hijos.size(); i++) {
            hijos.get(i).imprimirArbol(
                    prefijo + (esUltimo ? "    " : "│   "),
                    i == hijos.size() - 1
            );
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %s (Línea %d, Columna %d)", tipo, valor, linea, columna);
    }
}
