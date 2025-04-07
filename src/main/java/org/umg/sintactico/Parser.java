package org.umg.sintactico;

import org.umg.Token;
import org.umg.TipoToken;
import org.umg.arbol.Nodo;
import org.umg.sintactico.contexto.ContextoAnalisis;

import java.util.List;

public class Parser {

    private final List<Token> tokens;
    private final ContextoAnalisis contexto;
    private int posicion;
    private Token actual;
    private int errores = 0;

    private static final int MAX_ERRORES = 10;

    public Parser(List<Token> tokens) {
        if (tokens == null || tokens.isEmpty()) {
            throw new IllegalArgumentException("¡La legión de tokens está vacía!");
        }
        this.tokens = tokens;
        this.contexto = new ContextoAnalisis();
        this.posicion = 0;
        this.actual = tokens.get(0);
    }

    public Nodo parse() {
        Nodo mision = new Nodo("mision", Nodo.TipoNodo.MISION,
                actual.getLinea(), actual.getColumna());

        while (!finDeTokens()) {
            try {
                Nodo orden = parseOrden();
                if (orden != null) {
                    mision.agregarHijo(orden);
                }
            } catch (ParseException e) {
                reportarError(e.getMessage());
                if (++errores > MAX_ERRORES) {
                    System.err.println("¡Demasiadas fallas! Cancelando misión...");
                    break;
                }
                sincronizar();
            }
        }

        return mision;
    }

    private Nodo parseOrden() throws ParseException {
        if (finDeTokens()) return null;

        if (actual.getTipo() == TipoToken.ORDEN_MILITAR) {
            return switch (actual.getValor()) {
                case "titan", "if" -> parseTitan();
                case "ataque", "while" -> parseAtaque();
                case "orden", "print" -> parseOrdenMilitar();
                case "muro", "for" -> parseMuro();
                default -> throw error("¡Orden militar desconocida: " + actual.getValor() + "!");
            };
        }

        return parseTactica();
    }

    private Nodo parseTitan() throws ParseException {
        Token token = actual;
        consumir(TipoToken.ORDEN_MILITAR, token.getValor());
        consumir(TipoToken.MURALLA, "(");
        Nodo condicion = parseTactica();
        consumir(TipoToken.MURALLA, ")");

        Nodo titan = new Nodo("titan", Nodo.TipoNodo.TITAN, token.getLinea(), token.getColumna());
        titan.agregarHijo(condicion);
        titan.agregarHijo(parseDistrito());

        if (coincide(TipoToken.ORDEN_MILITAR, "legion") || coincide(TipoToken.ORDEN_MILITAR, "else")) {
            avanzar();
            titan.agregarHijo(parseDistrito());
        }

        return titan;
    }

    private Nodo parseAtaque() throws ParseException {
        Token token = actual;
        consumir(TipoToken.ORDEN_MILITAR, token.getValor());
        consumir(TipoToken.MURALLA, "(");
        Nodo condicion = parseTactica();
        consumir(TipoToken.MURALLA, ")");

        Nodo ataque = new Nodo("ataque", Nodo.TipoNodo.ATAQUE, token.getLinea(), token.getColumna());
        ataque.agregarHijo(condicion);
        ataque.agregarHijo(parseDistrito());

        return ataque;
    }

    private Nodo parseMuro() throws ParseException {
        Token token = actual;
        consumir(TipoToken.ORDEN_MILITAR, token.getValor());
        consumir(TipoToken.MURALLA, "(");

        Nodo init = parseOrden();
        consumir(TipoToken.SEPARADOR, ";");

        Nodo condicion = parseTactica();
        consumir(TipoToken.SEPARADOR, ";");

        Nodo actualizacion = parseOrden();
        consumir(TipoToken.MURALLA, ")");

        Nodo cuerpo = parseDistrito();

        Nodo muro = new Nodo("muro", Nodo.TipoNodo.MURO, token.getLinea(), token.getColumna());
        muro.agregarHijo(init);
        muro.agregarHijo(condicion);
        muro.agregarHijo(actualizacion);
        muro.agregarHijo(cuerpo);

        return muro;
    }

    private Nodo parseOrdenMilitar() throws ParseException {
        Token token = actual;
        consumir(TipoToken.ORDEN_MILITAR, token.getValor());

        Nodo expresion = parseTactica();
        consumir(TipoToken.SEPARADOR, ";");

        Nodo orden = new Nodo("orden", Nodo.TipoNodo.ORDEN_MILITAR, token.getLinea(), token.getColumna());
        orden.agregarHijo(expresion);

        return orden;
    }

    private Nodo parseDistrito() throws ParseException {
        Token token = actual;
        consumir(TipoToken.MURALLA, "{");
        contexto.abrirDistrito();

        Nodo distrito = new Nodo("distrito", Nodo.TipoNodo.DISTRITO, token.getLinea(), token.getColumna());

        while (!finDeTokens() && !coincide(TipoToken.MURALLA, "}")) {
            try {
                Nodo orden = parseOrden();
                if (orden != null) distrito.agregarHijo(orden);
            } catch (ParseException e) {
                reportarError(e.getMessage());
                sincronizar();
            }
        }

        if (!finDeTokens()) {
            consumir(TipoToken.MURALLA, "}");
        } else {
            System.err.println("¡Falta cerrar la muralla '}'!");
        }

        contexto.evacuarDistrito();
        return distrito;
    }

    private Nodo parseTactica() throws ParseException {
        Nodo izquierda = parseObjetivo();
        return parseTacticaCompuesta(izquierda, 0);
    }

    private Nodo parseTacticaCompuesta(Nodo izquierda, int precedenciaActual) throws ParseException {
        while (!finDeTokens() && actual.getTipo().esTactica()) {
            int precedencia = obtenerPrecedencia(actual);
            if (precedencia <= precedenciaActual) break;

            Token operador = actual;
            avanzar();

            Nodo derecha = parseObjetivo();
            Nodo operacion = new Nodo(operador.getValor(), Nodo.TipoNodo.TACTICA,
                    operador.getLinea(), operador.getColumna());
            operacion.agregarHijo(izquierda);
            operacion.agregarHijo(derecha);
            izquierda = operacion;
        }
        return izquierda;
    }

    private Nodo parseObjetivo() throws ParseException {
        if (actual.getTipo() == TipoToken.SCOUT || actual.getTipo().esRecurso()) {
            Nodo.TipoNodo tipo = actual.getTipo() == TipoToken.SCOUT ?
                    Nodo.TipoNodo.SCOUT : Nodo.TipoNodo.RECURSO;
            Nodo nodo = new Nodo(actual.getValor(), tipo, actual.getLinea(), actual.getColumna());
            avanzar();
            return nodo;
        }

        if (coincide(TipoToken.MURALLA, "(")) {
            avanzar();
            Nodo expr = parseTactica();
            consumir(TipoToken.MURALLA, ")");
            return expr;
        }

        throw error("¡Objetivo no reconocido! Se esperaba un scout, recurso o expresión entre murallas.");
    }

    private void sincronizar() {
        while (!finDeTokens() && !esPuntoSincronizacion()) avanzar();
    }

    private boolean esPuntoSincronizacion() {
        return finDeTokens() ||
                actual.getTipo() == TipoToken.ORDEN_MILITAR ||
                actual.getValor().equals(";") ||
                actual.getValor().equals("}");
    }

    private boolean finDeTokens() {
        return posicion >= tokens.size();
    }

    private boolean coincide(TipoToken tipo, String valor) {
        return !finDeTokens() && actual.getTipo() == tipo && actual.getValor().equals(valor);
    }

    private void consumir(TipoToken tipo, String valor) throws ParseException {
        if (!coincide(tipo, valor)) throw error("Se esperaba '" + valor + "'");
        avanzar();
    }

    private void avanzar() {
        posicion++;
        actual = finDeTokens() ? null : tokens.get(posicion);
    }

    private int obtenerPrecedencia(Token token) {
        return switch (token.getValor()) {
            case "*", "/", "%" -> 4;
            case "+", "-" -> 3;
            case "<", ">", "<=", ">=", "==", "!=" -> 2;
            case "&&", "||" -> 1;
            default -> 0;
        };
    }

    private void reportarError(String mensaje) {
        System.err.println("[FALLA EN LA MISIÓN] " + mensaje);
    }

    private ParseException error(String mensaje) {
        return new ParseException(mensaje, actual.getLinea(), actual.getColumna());
    }

    public static class ParseException extends Exception {
        public final int linea;
        public final int columna;

        public ParseException(String mensaje, int linea, int columna) {
            super(String.format("Línea %d:%d - %s", linea, columna, mensaje));
            this.linea = linea;
            this.columna = columna;
        }
    }
}
