package org.umg.analizadores;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.umg.modelo.ResultadoCompilacion;

public class HTMLAnalizador {
    public static ResultadoCompilacion analizar(String input) {
        CharStream cs = CharStreams.fromString(input);
        HTMLLexer lexer = new HTMLLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        HTMLParser parser = new HTMLParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(new errores.CustomErrorListener());

        try {
            ParseTree tree = parser.htmlDocument(); // o la regla principal de tu gramática
            return new ResultadoCompilacion("HTML", "Análisis HTML correcto", false);
        } catch (Exception e) {
            return new ResultadoCompilacion("HTML", "Error durante el análisis: " + e.getMessage(), true);
        }
    }
}
