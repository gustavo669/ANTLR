package org.umg.analizadores;


import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.umg.modelo.ResultadoCompilacion;

public class PLSQLAnalizador {
    public static ResultadoCompilacion analizar(String input) {
        CharStream cs = CharStreams.fromString(input);
        PLSQLLexer lexer = new PLSQLLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PLSQLParser parser = new PLSQLParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(new errores.CustomErrorListener());

        try {
            ParseTree tree = parser.sql_script(); // Ajusta la regla inicial
            return new ResultadoCompilacion("PL/SQL", "Análisis PL/SQL correcto", false);
        } catch (Exception e) {
            return new ResultadoCompilacion("PL/SQL", "Error durante el análisis: " + e.getMessage(), true);
        }
    }
}
