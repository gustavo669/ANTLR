package org.umg;

public class LenguajeDetector {
    public static String detectarLenguaje(String linea) {
        linea = linea.trim().toLowerCase();

        if (linea.contains("create table")) return "T-SQL";
        if (linea.contains("begin") && linea.contains("end;")) return "PL/SQL";
        if (linea.contains("<html")) return "HTML";
        if (linea.contains("function") || linea.contains("=>")) return "JavaScript";
        if (linea.contains("program") || linea.endsWith(";")) return "Pascal";
        if (linea.contains("#include") || linea.contains("std::")) return "C++";
        if (linea.contains("def ") || linea.contains("print(")) return "Python";

        return "Desconocido";
    }
}
