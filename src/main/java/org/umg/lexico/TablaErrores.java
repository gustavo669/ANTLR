package org.umg.lexico;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona los errores léxicos detectados durante el análisis léxico.
 */
public class TablaErrores {
    private final List<ErrorLexico> errores = new ArrayList<>();

    public void agregarError(ErrorLexico error) {
        errores.add(error);
    }

    public List<ErrorLexico> obtenerErrores() {
        return errores;
    }

    public boolean tieneErrores() {
        return !errores.isEmpty();
    }
}
