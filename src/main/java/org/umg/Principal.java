package org.umg;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Código fuente de prueba
        String code = """
            if (pepe + 25) {
               print "bfhjk";
            }
            RRRRR  // Esto es un error léxico
        """;

        // Crear el analizador léxico
        LexerGramática lexer = new LexerGramática();

        // Analizar el código
        List<LexerGramática.Token> tokens = lexer.analyze(code);

        // Imprimir los tokens detectados
        System.out.println("Tokens detectados:");
        for (LexerGramática.Token token : tokens) {
            System.out.printf("Token[%s]: %s (Línea %d)\n",
                    token.getType(),
                    token.getValue(),
                    token.getLine());
        }
    }
}
