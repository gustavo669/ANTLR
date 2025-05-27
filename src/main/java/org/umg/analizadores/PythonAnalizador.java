package org.umg.analizadores;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.umg.errores.CustomErrorListener;
import org.umg.modelo.ResultadoCompilacion;

public class PythonAnalizador {
    public static ResultadoCompilacion analizar(String input) {
        CharStream cs = CharStreams.fromString(input);
        PythonLexer lexer = new PythonLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PythonParser parser = new PythonParser(tokens);

        // Opcional: personalizar errores
        parser.removeErrorListeners();
        parser.addErrorListener(new CustomErrorListener());

        try {
            ParseTree tree = parser.program(); // Suponiendo que la regla principal es 'program'
            // Aquí podrías incluir análisis semántico o ejecución
            return new ResultadoCompilacion("Python", "Análisis correcto", false);
        } catch (Exception e) {
            return new ResultadoCompilacion("Python", "Error durante el análisis: " + e.getMessage(), true);
        }
    }
}

