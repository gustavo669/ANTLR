package org.umg.lexico;

public enum TipoToken {

    ORDEN_MILITAR("Orden militar", "Instrucciones clave"),

    SCOUT("Scout", "Identificadores"),

    SOLDADOS("Soldados", "Números enteros"),

    EQUIPO("Equipo de maniobras", "Números decimales"),

    GRITO("Grito de batalla", "Texto"),

    TACTICA_ATAQUE("Táctica de ataque", "Operadores aritméticos"),

    TACTICA_DEFENSA("Táctica defensiva", "Operadores relacionales"),

    ESTRATEGIA("Estrategia", "Operadores lógicos"),

    ASIGNACION_ORDEN("Asignación de orden", "Operadores de asignación"),

    MURALLA("Muralla", "Símbolos de agrupación"),

    SEPARADOR("Separador de misiones", "Separadores"),

    INFORME("Informe de cuartel", "Comentario de línea"),

    INFORME_SECRETO("Informe clasificado", "Comentario multilinea"),

    FIN_EXPEDICION("Fin de expedición", "Fin del código"),

    TITAN_DESCONOCIDO("Titán no identificado", "Token no válido");

    private final String descripcion;
    private final String resumen;

    TipoToken(String descripcion, String resumen) {
        this.descripcion = descripcion;
        this.resumen = resumen;
    }

    public boolean esTactica() {
        return this == TACTICA_ATAQUE ||
                this == TACTICA_DEFENSA ||
                this == ESTRATEGIA ||
                this == ASIGNACION_ORDEN;
    }

    public boolean esRecurso() {
        return this == SOLDADOS || this == EQUIPO || this == GRITO;
    }

    @Override
    public String toString() {
        return descripcion + " - " + resumen;
    }
}
