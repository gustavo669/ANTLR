package org.umg.analisis.lexico;

import org.umg.TipoToken;
import org.umg.Token;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

/**
 * Analizador léxico que convierte código fuente en una secuencia de tokens.
 */
public class AnalizadorLexico {

    private static final Map<String, TipoToken> PALABRAS_RESERVADAS = Map.ofEntries(
            Map.entry("if", TipoToken.PALABRA_RESERVADA),
            Map.entry("else", TipoToken.PALABRA_RESERVADA),
            Map.entry("for", TipoToken.PALABRA_RESERVADA),
            Map.entry("while", TipoToken.PALABRA_RESERVADA),
            Map.entry("print", TipoToken.PALABRA_RESERVADA),
            Map.entry("return", TipoToken.PALABRA_RESERVADA)
    );

    private static final Pattern TOKEN_PATTERN = Pattern.compile(
            "\"(?:\\\\.|[^\"\\\\])*\"|" +      // Strings (con soporte para escapes)
                    "\\d+\\.?\\d*|" +                  // Números (enteros y decimales)
                    "[a-zA-Z_]\\w*|" +                 // Identificadores
                    "[+\\-*/%=<>!&|^~]=?|" +          // Operadores (incluyendo compuestos)
                    "[{}\\[\\](),;.:]|" +             // Símbolos
                    "//.*|/\\*.*?\\*/|" +            // Comentarios
                    "\\S"                             // Cualquier otro carácter no espacio
    );

    private final List<Token> tokens = new ArrayList<>();
    private final List<ErrorLexico> errores = new ArrayList<>();

    /**
     * Analiza el código fuente y genera una lista de tokens.
     * @param codigo El código fuente a analizar
     * @return Lista de tokens generados
     */
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
                // Saltar comentarios
                if (valor.startsWith("//") || valor.startsWith("/*")) {
                    continue;
                }

                TipoToken tipo = identificarToken(valor);
                if (tipo == TipoToken.ERROR) {
                    errores.add(new ErrorLexico(valor, lineaNum + 1));
                }
                tokens.add(new Token(tipo, valor, lineaNum + 1));
            }
        }

        return Collections.unmodifiableList(tokens);
    }

    /**
     * Identifica el tipo de token basado en su valor.
     */
    private TipoToken identificarToken(String valor) {
        if (PALABRAS_RESERVADAS.containsKey(valor)) {
            return PALABRAS_RESERVADAS.get(valor);
        }
        if (valor.matches("[a-zA-Z_]\\w*")) {
            return TipoToken.IDENTIFICADOR;
        }
        if (valor.matches("\\d+\\.?\\d*")) {
            return valor.contains(".") ? TipoToken.CONST_DECIMAL : TipoToken.CONST_ENTERA;
        }
        if (valor.matches("\"(?:\\\\.|[^\"\\\\])*\"")) {
            return TipoToken.STRING;
        }
        if (valor.matches("[+\\-*/%=<>!&|^~]=?")) {
            return TipoToken.OPERADOR_ARITMETICO;
        }
        if (valor.matches("[{}\\[\\](),;.:]")) {
            return TipoToken.SIMBOLO;
        }
        return TipoToken.ERROR;
    }

    /**
     * Obtiene la lista de errores léxicos encontrados.
     */
    public List<ErrorLexico> getErrores() {
        return Collections.unmodifiableList(errores);
    }

    /**
     * Verifica si hubo errores durante el análisis.
     */
    public boolean tieneErrores() {
        return !errores.isEmpty();
    }

    /**
     * Obtiene un resumen de errores formateado.
     */
    public String getResumenErrores() {
        return errores.stream()
                .map(e -> String.format("Línea %d: Token no reconocido '%s'", e.getLinea(), e.getValor()))
                .collect(Collectors.joining("\n"));
    }
}