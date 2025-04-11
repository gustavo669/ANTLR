package org.umg.lexico;

import java.util.*;
import java.util.regex.*;

public class AnalizadorLexico {
    private static final Map<String, TipoToken> PALABRAS_RESERVADAS = Map.ofEntries(
            Map.entry("titan", TipoToken.ORDEN_MILITAR),
            Map.entry("legion", TipoToken.ORDEN_MILITAR),
            Map.entry("ataque", TipoToken.ORDEN_MILITAR),
            Map.entry("orden", TipoToken.ORDEN_MILITAR),
            Map.entry("muro", TipoToken.ORDEN_MILITAR),
            Map.entry("humanidad", TipoToken.ORDEN_MILITAR),
            // Compatibilidad con palabras en inglés
            Map.entry("if", TipoToken.ORDEN_MILITAR),
            Map.entry("else", TipoToken.ORDEN_MILITAR),
            Map.entry("while", TipoToken.ORDEN_MILITAR),
            Map.entry("print", TipoToken.ORDEN_MILITAR),
            Map.entry("for", TipoToken.ORDEN_MILITAR),
            Map.entry("return", TipoToken.ORDEN_MILITAR)
    );

    private static final Pattern TOKEN_PATTERN = Pattern.compile(
            "\"(?:\\\\.|[^\"\\\\])*\"|" +               // Cadenas
                    "\\d+\\.?\\d*|" +                  // Números
                    "[a-zA-Z_]\\w*|" +                 // Identificadores
                    "[+\\-*/%=<>!&|^~]=?|" +           // Operadores
                    "[{}\\[\\](),;.:]|" +              // Símbolos
                    "//.*|/\\*.*?\\*/|" +              // Comentarios
                    "\\S"                              // Otros
    );

    private final List<Token> tokens = new ArrayList<>();
    private final List<ErrorLexico> errores = new ArrayList<>();

    public List<Token> analizar(String codigo) {
        tokens.clear();
        errores.clear();

        if (codigo == null || codigo.trim().isEmpty()) {
            return Collections.emptyList();
        }

        String[] lineas = codigo.split("\n");
        for (int lineaNum = 0; lineaNum < lineas.length; lineaNum++) {
            String linea = lineas[lineaNum].trim();
            if (linea.isEmpty()) continue;

            Matcher matcher = TOKEN_PATTERN.matcher(linea);
            while (matcher.find()) {
                String valor = matcher.group();
                if (valor.startsWith("//") || valor.startsWith("/*")) {
                    continue;
                }

                TipoToken tipo = identificarToken(valor);
                if (tipo == TipoToken.TITAN_DESCONOCIDO) {
                    errores.add(new ErrorLexico(
                            valor,
                            lineaNum + 1,
                            "Token no reconocido: '" + valor + "'"
                    ));
                }
                tokens.add(new Token(tipo, valor, lineaNum + 1));
            }
        }

        return Collections.unmodifiableList(tokens);
    }

    private TipoToken identificarToken(String valor) {
        if (PALABRAS_RESERVADAS.containsKey(valor)) {
            return PALABRAS_RESERVADAS.get(valor);
        }
        if (valor.matches("[a-zA-Z_]\\w*")) {
            return TipoToken.SCOUT;
        }
        if (valor.matches("\\d+\\.?\\d*")) {
            return valor.contains(".") ? TipoToken.EQUIPO : TipoToken.SOLDADOS;
        }
        if (valor.matches("\"(?:\\\\.|[^\"\\\\])*\"")) {
            return TipoToken.GRITO;
        }
        if (valor.matches("[+\\-*/%=<>!&|^~]=?")) {
            return valor.matches("==|!=|<|>|<=|>=") ? TipoToken.TACTICA_DEFENSA : TipoToken.TACTICA_ATAQUE;
        }
        if (valor.matches("[{}\\[\\](),;.:]")) {
            if (valor.matches("[{}()\\[\\]]")) {
                return TipoToken.MURALLA;
            }
            return TipoToken.SEPARADOR;
        }
        return TipoToken.TITAN_DESCONOCIDO;
    }

    public List<ErrorLexico> getErrores() {
        return Collections.unmodifiableList(errores);
    }

}
