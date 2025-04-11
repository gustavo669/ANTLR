package org.umg.sintactico.contexto;

import org.umg.lexico.TipoToken;

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

    public static class NivelDistrito {
        private final int nivel;
        private final Map<String, TipoToken> simbolos;

        public NivelDistrito(int nivel) {
            this.nivel = nivel;
            this.simbolos = new HashMap<>();
        }
    }
}
