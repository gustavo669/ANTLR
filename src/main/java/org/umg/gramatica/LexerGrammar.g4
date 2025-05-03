lexer grammar LexerGrammar;

// ========================
// PALABRAS CLAVE TEMÁTICAS
// ========================
TITAN:       'titan';
LEGION:      'legion';
ORDEN:       'orden';
ATAQUE:      'ataque';
HUMANIDAD:   'humanidad';
MURO:        'muro';
RECONOCER:   'reconocer';
TROPAS:      'tropas';

// ========================
// OPERADORES
// ========================
MUL:         '*';
DIV:         '/';
ADD:         '+';
SUB:         '-';
MOD:         '%';

PUNTAZOS:    '++';
RETIRADA:    '--';

MAYOR_QUE:   '>';
MENOR_QUE:   '<';
IGUALDAD:    '==';
DESIGUALDAD: '!=';
MAYOR_IGUAL: '>=';
MENOR_IGUAL: '<=';

// ========================
// SÍMBOLOS
// ========================
LPAREN:      '(';
RPAREN:      ')';
LBRACE:      '{';
RBRACE:      '}';
SEMI:        ';';
COMA:        ',';
PUNTO:       '.';
ASIGNACION:  '=';

// ========================
// LITERALES
// ========================
NUMERO:      [0-9]+ ('.' [0-9]+)?;
GRITO:       '"' (~["\\] | '\\' .)* '"';  // Cadena con escapes
ID:          [a-zA-Z_][a-zA-Z0-9_]*;

// ========================
// COMENTARIOS
// ========================
INFORME:          '//' ~[\r\n]* -> skip;
INFORME_SECRETO:  '/*' .*? '*/' -> skip;

// ========================
// ESPACIOS
// ========================
ESPACIOS:   [ \t\r\n]+ -> skip;
