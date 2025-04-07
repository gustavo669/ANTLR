package org.umg.lexico;

import java.util.ArrayList;
import java.util.List;

public class TablaErrores {
    private final List<ErrorLexico> errores;

    public TablaErrores() {
        this.errores = new ArrayList<>();
    }


    public void agregarError(ErrorLexico error) {
        errores.add(error);
    }


    public void mostrarErrores() {
        if (errores.isEmpty()) {
            System.out.println("No se detectaron errores léxicos.");
            return;
        }

        System.out.println("\n===== TABLA DE ERRORES LÉXICOS =====");
        System.out.printf("%-20s %-10s %-10s %s\n", "VALOR", "LÍNEA", "COLUMNA", "MENSAJE");
        System.out.println("------------------------------------------------------------");

        for (ErrorLexico error : errores) {
            System.out.printf("%-20s %-10d %-10d %s\n",
                    truncar(error.getValor(), 18),
                    error.getLinea(),
                    error.getColumna(),
                    error.getMensaje()
            );
        }
    }

    private String truncar(String valor, int maxLength) {
        return valor.length() > maxLength ? valor.substring(0, maxLength) + "..." : valor;
    }
}
