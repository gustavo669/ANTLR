package org.umg.analizadores;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.umg.modelo.ResultadoCompilacion;

public class JavaScriptAnalizador {
    public static ResultadoCompilacion analizar(String input) {
        CharStream cs = CharStreams.fromString(input);
        JavaScriptLexer lexer = new JavaScriptLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaScriptParser parser = new JavaScriptParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(new errores.CustomErrorListener());

        try {
            ParseTree tree = parser.program(); // Ajusta si es otra regla inicial
            return new ResultadoCompilacion("JavaScript", "Análisis JavaScript correcto", false);
        } catch (Exception e) {
            return new ResultadoCompilacion("JavaScript", "Error durante el análisis: " + e.getMessage(), true);
        }
    }
}
