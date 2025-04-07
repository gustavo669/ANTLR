package org.umg.sintactico;

import org.umg.Token;
import org.umg.TipoToken;
import org.umg.arbol.Nodo;
import org.umg.sintactico.contexto.ContextoAnalisis;

import java.util.List;

public class Parser {
    private final List<Token> tokens;
    private int posicionActual;
    private Token tokenActual;
    private final ContextoAnalisis contexto;

    public Parser(List<Token> tokens) {
        if (tokens == null || tokens.isEmpty()) {
            throw new IllegalArgumentException("La lista de tokens no puede ser nula o vacía");
        }
        this.tokens = List.copyOf(tokens);
        this.posicionActual = 0;
        this.tokenActual = tokens.get(0);
        this.contexto = new ContextoAnalisis();
    }

    public Nodo parse() {
        Nodo programa = new Nodo("programa");
        while (!finDeTokens()) {
            programa.agregarHijo(parseDeclaracion());
        }
        return programa;
    }

    private Nodo parseDeclaracion() {
        try {
            if (coincide(TipoToken.PALABRA_RESERVADA, "if")) {
                return parseIf();
            }
            if (coincide(TipoToken.PALABRA_RESERVADA, "print")) {
                return parsePrint();
            }
            return parseExpresion();
        } catch (ParseException e) {
            // Recuperación de errores básica
            System.err.println(e.getMessage());
            sincronizar();
            return new Nodo("error");
        }
    }

    private Nodo parseIf() {
        consumir(TipoToken.PALABRA_RESERVADA, "if");
        consumir(TipoToken.SIMBOLO, "(");

        Nodo condicion = parseExpresion();

        consumir(TipoToken.SIMBOLO, ")");
        Nodo cuerpo = parseBloque();

        Nodo nodoIf = new Nodo("if", condicion, cuerpo);

        if (coincide(TipoToken.PALABRA_RESERVADA, "else")) {
            consumir(TipoToken.PALABRA_RESERVADA, "else");
            Nodo elseCuerpo = parseBloque();
            nodoIf.agregarHijo(elseCuerpo);
        }

        return nodoIf;
    }

    private Nodo parsePrint() {
        consumir(TipoToken.PALABRA_RESERVADA, "print");
        Nodo expresion = parseExpresion();
        consumir(TipoToken.SIMBOLO, ";");
        return new Nodo("print", expresion);
    }

    private Nodo parseBloque() {
        consumir(TipoToken.SIMBOLO, "{");
        contexto.abrirAmbito();

        Nodo bloque = new Nodo("bloque");
        while (!coincide(TipoToken.SIMBOLO, "}") && !finDeTokens()) {
            bloque.agregarHijo(parseDeclaracion());
        }

        consumir(TipoToken.SIMBOLO, "}");
        contexto.cerrarAmbito();
        return bloque;
    }

    private Nodo parseExpresion() {
        Nodo izquierda = parseTermino();
        return parseExpresionBinaria(izquierda, 0);
    }

    private Nodo parseExpresionBinaria(Nodo izquierda, int precedenciaActual) {
        while (true) {
            int precedencia = obtenerPrecedencia(tokenActual);
            if (precedencia < precedenciaActual || finDeTokens()) {
                return izquierda;
            }

            Token operador = tokenActual;
            avanzar();

            Nodo derecha = parseTermino();
            izquierda = new Nodo(operador.getValor(), izquierda, derecha);
        }
    }

    private Nodo parseTermino() {
        if (coincide(TipoToken.CONST_ENTERA) || coincide(TipoToken.CONST_DECIMAL) ||
                coincide(TipoToken.IDENTIFICADOR) || coincide(TipoToken.STRING)) {

            Nodo nodo = new Nodo(tokenActual.getValor());
            avanzar();
            return nodo;
        }

        if (coincide(TipoToken.SIMBOLO, "(")) {
            avanzar();
            Nodo expresion = parseExpresion();
            consumir(TipoToken.SIMBOLO, ")");
            return expresion;
        }

        throw new ParseException("Token inesperado: " + tokenActual.getValor(),
                tokenActual.getLinea(), tokenActual.getColumna());
    }

    // Métodos auxiliares
    private boolean finDeTokens() {
        return tokenActual.getTipo() == TipoToken.EOF;
    }

    private boolean coincide(TipoToken tipo) {
        return tokenActual.getTipo() == tipo;
    }

    private boolean coincide(TipoToken tipo, String valor) {
        return tokenActual.getTipo() == tipo && tokenActual.getValor().equals(valor);
    }

    private void consumir(TipoToken tipo, String valor) {
        if (coincide(tipo, valor)) {
            avanzar();
        } else {
            throw new ParseException("Se esperaba: " + valor, tokenActual.getLinea(), tokenActual.getColumna());
        }
    }

    private int obtenerPrecedencia(Token token) {
        if (token.getTipo() != TipoToken.OPERADOR_ARITMETICO) return 0;
        return switch (token.getValor()) {
            case "+", "-" -> 1;
            case "*", "/", "%" -> 2;
            default -> 0;
        };
    }

    private void avanzar() {
        posicionActual++;
        tokenActual = posicionActual < tokens.size() ? tokens.get(posicionActual)
                : new Token(TipoToken.EOF, "", -1, -1);
    }

    private void sincronizar() {
        // Avanza hasta encontrar un punto de sincronización
        while (!finDeTokens()) {
            if (tokenActual.getTipo() == TipoToken.SIMBOLO) {
                avanzar();
                return;
            }
            if (coincide(TipoToken.PALABRA_RESERVADA, "if") ||
                    coincide(TipoToken.PALABRA_RESERVADA, "print")) {
                return;
            }
            avanzar();
        }
    }

    public static class ParseException extends RuntimeException {
        private final int linea;
        private final int columna;

        public ParseException(String mensaje, int linea, int columna) {
            super(mensaje);
            this.linea = linea;
            this.columna = columna;
        }

        @Override
        public String getMessage() {
            return String.format("Error sintáctico en línea %d, columna %d: %s",
                    linea, columna, super.getMessage());
        }
    }
}