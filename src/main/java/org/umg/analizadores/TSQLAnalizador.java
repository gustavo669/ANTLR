package org.umg.analizadores;


import org.antlr.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.umg.modelo.ResultadoCompilacion;

public class TSQLAnalizador {
    public static ResultadoCompilacion analizar(String input) {
        CharStream cs = CharStreams.fromString(input);
        TSQLLexer lexer = new TSQLLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TSQLParser parser = new TSQLParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(new errores.CustomErrorListener());

        try {
            ParseTree tree = parser.statement(); // Ajusta si es otra regla inicial
            return new ResultadoCompilacion("T-SQL", "Se creó la tabla llamada " + input.split(" ")[2], false);
        } catch (Exception e) {
            return new ResultadoCompilacion("T-SQL", "Error durante el análisis: " + e.getMessage(), true);
        }
    }
}