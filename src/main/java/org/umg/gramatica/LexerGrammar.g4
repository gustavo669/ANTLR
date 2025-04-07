lexer grammar LexerGrammar;

// ========================
// COMANDOS MILITARES (Palabras reservadas)
// ========================
TITAN:       'titan';       // Estructura de decisión (if)
LEGION:      'legion';      // Cláusula alternativa (else)
ORDEN:       'orden';       // Comando de despliegue (print)
ATAQUE:      'ataque';      // Ciclo de ataque (while)
HUMANIDAD:   'humanidad';   // Retorno al cuartel (return)
MURO:        'muro';        // Defensa iterativa (for)
RECONOCER:   'reconocer';   // Declaración de función
TROPAS:      'tropas';      // Declaración de variables

// ========================
// ARSENAL (Operadores)
// ========================
MULT:        '*';           // Garras (multiplicación)
DIV:         '/';           // Escudo (división)
ADD:         '+';           // Refuerzos (suma)
SUB:         '-';           // Bajas (resta)
MOD:         '%';           // Reservas (módulo)

// Estrategias combinadas
PUNTAZOS:    '++';          // Ataque rápido (incremento)
RETIRADA:    '--';          // Retroceso (decremento)

// ========================
// TÁCTICAS (Operadores de comparación)
// ========================
MAYOR_QUE:   '>';           // Más fuerte que
MENOR_QUE:   '<';           // Más débil que
IGUALDAD:    '==';          // Mismo titan
DESIGUALDAD: '!=';          // Titan diferente
MAYOR_IGUAL: '>=';          // No menos fuerte que
MENOR_IGUAL: '<=';          // No más fuerte que

// ========================
// SEÑALES ESTRATÉGICAS (Símbolos)
// ========================
LPAREN:      '(';           // Inicio de formación
RPAREN:      ')';           // Fin de formación
LBRACE:      '{';           // Inicio de muralla
RBRACE:      '}';           // Fin de muralla
SEMI:        ';';           // Fin de misión
COMA:        ',';           // Separador de unidades
PUNTO:       '.';           // Punto estratégico
ASIGNACION:  '=';           // Despliegue de fuerzas

// ========================
// SUMINISTROS (Literales)
// ========================
NUMERO:      [0-9]+ ('.' [0-9]+)?;  // Soldados/Equipo (enteros/decimales)
GRITO:       '"' .*? '"';            // Grito de batalla (cadena)
SCOUT:       [a-zA-Z_][a-zA-Z0-9_]*; // Identificador

// ========================
// COMUNICACIONES (Comentarios)
// ========================
INFORME:     '//' ~[\r\n]* -> skip;      // Informe de campo
INFORME_SECRETO: '/*' .*? '*/' -> skip;  // Informe clasificado

// ========================
// CAMUFLAJE (Espacios)
// ========================
CAMUFLAJE:   [ \t\r\n]+ -> skip;         // Espacios en blanco

// ========================
// ERRORES
// ========================
ERROR_TITAN: . ;
               // Titan desconocido