package org.umg.modelo;

public class ResultadoCompilacion {
    public String lenguajeDetectado;
    public String resultado;
    public boolean hayErrores;

    public ResultadoCompilacion(String lenguajeDetectado, String resultado, boolean hayErrores) {
        this.lenguajeDetectado = lenguajeDetectado;
        this.resultado = resultado;
        this.hayErrores = hayErrores;
    }
}
