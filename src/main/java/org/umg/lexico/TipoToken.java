package org.umg.lexico;

public enum TipoToken {

    ORDEN_MILITAR("Orden militar", "titan, legion, ataque, orden, humanidad"),


    SCOUT("Scout", "eren, mikasa, armin, levi"),

    SOLDADOS("Soldados", "10, 20, 100"),                    // Constantes enteras
    EQUIPO("Equipo de maniobras", "3.14, 0.5"),             // Constantes decimales


    GRITO("Grito de batalla", "\"¡Avancemos!\", \"¡Derriben al titán!\""),

    TACTICA_ATAQUE("Táctica de ataque", "+, -, *, /"),
    TACTICA_DEFENSA("Táctica defensiva", "==, !=, <, >"),
    ESTRATEGIA("Estrategia", "&&, ||, !"),
    ASIGNACION_ORDEN("Asignación de orden", "=, +=, -="),


    MURALLA("Muralla", "{, }, (, ), [, ]"),
    SEPARADOR("Separador de misiones", ", ; :"),


    INFORME("Informe de cuartel", "// Refuerzos necesarios"),
    INFORME_SECRETO("Informe clasificado", "/* Coordenadas */"),


    FIN_EXPEDICION("Fin de expedición", ""),                // Token EOF

    TITAN_DESCONOCIDO("Titán no identificado", "");         // Token no reconocido

    private final String descripcion;
    private final String ejemplos;

    TipoToken(String descripcion, String ejemplos) {
        this.descripcion = descripcion;
        this.ejemplos = ejemplos;
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
        return descripcion + (ejemplos.isEmpty() ? "" : " (" + ejemplos + ")");
    }
}
