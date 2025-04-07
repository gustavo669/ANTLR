package org.umg.analisis.lexico;

public class ExpresionesRegulares {
    // Expresión 1: Contraseña segura
    // - Mínimo 8 caracteres.
    // - Al menos 2 mayúsculas.
    // - Al menos 1 carácter especial (!@#$&*).
    // - Al menos 2 números.
    // - Al menos 3 minúsculas.
    public static final String EXP_REG_1 = "^(?=(?:.*[A-Z]){2,})(?=.*[!@#$&*])(?=(?:.*[0-9]){2,})(?=(?:.*[a-z]){3,}).{8,}$";

    // Ejemplo válido: "AbcDe1@3"
    // Ejemplo inválido: "abcd1234" (falta mayúscula y carácter especial)

    // Expresión 2: Identificadores válidos
    // - Entre 3 y 16 caracteres.
    // - Solo letras minúsculas, números, guiones bajos y medios.
    public static final String EXP_REG_2 = "^[a-z0-9_-]{3,16}$";

    // Ejemplo válido: "user_123"
    // Ejemplo inválido: "Us" (menos de 3 caracteres)

    // Expresión 3: Números enteros o decimales (positivos o negativos)
    // - Puede tener un signo negativo al inicio.
    // - Puede ser entero o decimal (pero no solo un punto).
    public static final String EXP_REG_3 = "^-?[0-9]+(\\.[0-9]+)?$";

    // Ejemplo válido: "-12.34"
    // Ejemplo inválido: ".123" (no hay número antes del punto)

    // Expresión 4: Palabras con letras y acentos
    // - Solo letras (mayúsculas y minúsculas) y letras con acentos.
    public static final String EXP_REG_4 = "^[a-zA-ZñÑáéíóúÁÉÍÓÚ]+$";

    // Ejemplo válido: "España"
    // Ejemplo inválido: "José123" (contiene números)

    // Expresión 5: Números con dos decimales exactos
    // - Un número seguido de un punto o coma.
    // - Exactamente dos ceros después del separador decimal.
    public static final String EXP_REG_5 = "^[0-9]+[.,]00$";

    // Ejemplo válido: "1500.00"
    // Ejemplo inválido: "15.5" (falta un cero)
}


