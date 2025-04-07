package org.umg.sintactico.contexto;

import org.umg.TipoToken;

import java.util.*;

public class ContextoAnalisis {

    private final Deque<NivelDistrito> pilaDistritos;
    private int nivelActual;

    public ContextoAnalisis() {
        this.pilaDistritos = new ArrayDeque<>();
        this.nivelActual = 0;
    }

    public void abrirDistrito() {
        pilaDistritos.push(new NivelDistrito(nivelActual++));
    }

    public void evacuarDistrito() {
        if (!pilaDistritos.isEmpty()) {
            pilaDistritos.pop();
            nivelActual--;
        } else {
            throw new IllegalStateException("¡La pila de distritos está vacía! La muralla ha caído.");
        }
    }

    public void declararSimbolo(String nombre, TipoToken tipo) {
        if (pilaDistritos.isEmpty()) {
            throw new IllegalStateException("¡No hay distritos activos para declarar símbolos!");
        }

        NivelDistrito distritoActual = pilaDistritos.peek();
        if (distritoActual.simbolos.containsKey(nombre)) {
            throw new IllegalStateException("¡Símbolo ya declarado en este distrito: " + nombre + "!");
        }

        distritoActual.simbolos.put(nombre, tipo);
    }

    public boolean simboloExiste(String nombre) {
        for (NivelDistrito distrito : pilaDistritos) {
            if (distrito.simbolos.containsKey(nombre)) {
                return true;
            }
        }
        return false;
    }

    public TipoToken obtenerTipoSimbolo(String nombre) {
        for (NivelDistrito distrito : pilaDistritos) {
            if (distrito.simbolos.containsKey(nombre)) {
                return distrito.simbolos.get(nombre);
            }
        }
        return null;
    }

    public static class NivelDistrito {
        private final int nivel;
        private final Map<String, TipoToken> simbolos;

        public NivelDistrito(int nivel) {
            this.nivel = nivel;
            this.simbolos = new HashMap<>();
        }
    }
}
