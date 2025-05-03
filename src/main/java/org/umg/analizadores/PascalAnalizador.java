package org.umg.analizadores;


import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.umg.modelo.ResultadoCompilacion;

public class PascalAnalizador {
    public static ResultadoCompilacion analizar(String input) {
        CharStream cs = CharStreams.fromString(input);
        PascalLexer lexer = new PascalLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PascalParser parser = new PascalParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(new errores.CustomErrorListener());

        try {
            ParseTree tree = parser.program(); // Ajusta según tu regla principal
            return new ResultadoCompilacion("Pascal", "Análisis Pascal correcto", false);
        } catch (Exception e) {
            return new ResultadoCompilacion("Pascal", "Error durante el análisis: " + e.getMessage(), true);
        }
    }
}

