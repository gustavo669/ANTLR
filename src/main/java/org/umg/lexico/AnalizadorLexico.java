package org.umg.lexico;

import org.umg.errores.ErrorLexico;

import java.util.*;
import java.util.regex.*;

/**
 * Clase encargada del análisis léxico del código fuente en el lenguaje temático de Attack on Titan.
 */
public class AnalizadorLexico {
    // Definición de palabras reservadas
    private static final Map<String, TipoToken> PALABRAS_RESERVADAS = Map.ofEntries(
            Map.entry("titan", TipoToken.ORDEN_MILITAR),
            Map.entry("legion", TipoToken.ORDEN_MILITAR),
            Map.entry("ataque", TipoToken.ORDEN_MILITAR),
            Map.entry("orden", TipoToken.ORDEN_MILITAR),
            Map.entry("muro", TipoToken.ORDEN_MILITAR),
            Map.entry("humanidad", TipoToken.ORDEN_MILITAR),

            // Palabras en inglés
            Map.entry("if", TipoToken.ORDEN_MILITAR),
            Map.entry("else", TipoToken.ORDEN_MILITAR),
            Map.entry("while", TipoToken.ORDEN_MILITAR),
            Map.entry("print", TipoToken.ORDEN_MILITAR),
            Map.entry("for", TipoToken.ORDEN_MILITAR),
            Map.entry("return", TipoToken.ORDEN_MILITAR)
    );

    // Expresión regular para identificar los tokens
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
    private final TablaErrores tablaErrores = new TablaErrores();

    public List<Token> analizar(String codigo) {
        tokens.clear();

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
                    continue; // Ignorar comentarios
                }

                TipoToken tipo = identificarToken(valor);
                if (tipo == TipoToken.TITAN_DESCONOCIDO) {
                    tablaErrores.agregarError(new ErrorLexico(
                            valor,
                            lineaNum + 1,
                            matcher.start() + 1,
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
        if (valor.matches("==|!=|<|>|<=|>=")) {
            return TipoToken.TACTICA_DEFENSA;
        }
        if (valor.matches("[+\\-*/]")) {
            return TipoToken.TACTICA_ATAQUE;
        }
        if (valor.matches("=|\\+=|\\-=")) {
            return TipoToken.ASIGNACION_ORDEN;
        }
        if (valor.matches("&&|\\|\\||!")) {
            return TipoToken.ESTRATEGIA;
        }
        if (valor.matches("[{}()\\[\\]]")) {
            return TipoToken.MURALLA;
        }
        if (valor.matches("[,;:]")) {
            return TipoToken.SEPARADOR;
        }
        return TipoToken.TITAN_DESCONOCIDO;
    }

    public List<Token> getTokens() {
        return tokens;
    }

}
