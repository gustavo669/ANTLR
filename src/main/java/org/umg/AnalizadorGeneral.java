package org.umg;

import org.umg.analizadores.*;
import org.umg.modelo.ResultadoCompilacion;

public class AnalizadorGeneral {

    public static ResultadoCompilacion analizar(String codigo) {
        String lenguaje = LenguajeDetector.detectarLenguaje(codigo);

        switch (lenguaje) {
            case "Python":
                return PythonAnalizador.analizar(codigo);

            case "T-SQL":
                return TSQLAnalizador.analizar(codigo);

            case "HTML":
                return HTMLAnalizador.analizar(codigo);

            case "JavaScript":
                return JavaScriptAnalizador.analizar(codigo);

            case "Pascal":
                return PascalAnalizador.analizar(codigo);

            case "PL/SQL":
                return PLSQLAnalizador.analizar(codigo);

            default:
                return new ResultadoCompilacion(
                        "Desconocido",
                        "Lenguaje no reconocido o no soportado aún.",
                        true
                );
        }
    }
}