package org.umg.modelo;

import java.util.HashMap;
import java.util.Map;

public class TablaSimbolos {
    private static final Map<String, String> simbolos = new HashMap<>();

    public static void agregar(String nombre, String tipo) {
        simbolos.put(nombre, tipo);
    }

    public static void imprimir() {
        simbolos.forEach((k, v) -> System.out.println("Nombre: " + k + " | Tipo: " + v));
    }
}
