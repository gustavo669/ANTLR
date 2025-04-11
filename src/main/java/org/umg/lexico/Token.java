package org.umg.lexico;

public class Token {
    private final TipoToken tipo;
    private final String valor;
    private final int linea;
    private final int columna;

    /**
     * Constructor completo para un token.
     *
     * @param tipo Tipo del token según la enumeración TipoToken
     * @param valor Valor textual del token
     * @param linea Número de línea donde aparece el token
     * @param columna Número de columna donde aparece el token
     */
    public Token(TipoToken tipo, String valor, int linea, int columna) {
        this.tipo = tipo;
        this.valor = valor;
        this.linea = linea;
        this.columna = columna;
    }

    /**
     * Constructor simplificado que asume columna 1.
     */
    public Token(TipoToken tipo, String valor, int linea) {
        this(tipo, valor, linea, 1);
    }

    public TipoToken getTipo() {
        return tipo;
    }

    public String getValor() {
        return valor;
    }

    public int getLinea() {
        return linea;
    }

    public int getColumna() {
        return columna;
    }

    @Override
    public String toString() {
        return String.format("Token[%s]: '%s' en línea %d, columna %d",
                tipo, valor, linea, columna);
    }
}