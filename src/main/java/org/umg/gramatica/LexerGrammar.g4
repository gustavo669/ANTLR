lexer grammar LexerGrammar;

// Palabras reservadas
IF      : 'if' ;
ELSE    : 'else' ;
FOR     : 'for' ;
PRINT   : 'print' ;
INT     : 'int' ;
BFHJK   : 'bfhjk' ;

// Identificadores (máx 15 caracteres, empiezan con letra)
IDENT   : [a-zA-Z] [a-zA-Z0-9]{0,14} ;

// Constantes enteras entre 0 y 100
INT_CONST : [0-9] | [1-9][0-9] | '100' ;

// Operadores aritméticos
PLUS  : '+' ;
MINUS : '-' ;
MULT  : '*' ;
DIV   : '/' ;

// Operador de asignación
ASSIGN  : ':=' ;

// Operadores relacionales
GE  : '>=' ;
LE  : '<=' ;
GT  : '>' ;
LT  : '<' ;
EQ  : '=' ;
NEQ : '<>' ;

// Símbolos especiales
LBRACE  : '{' ;
RBRACE  : '}' ;
LBRACK  : '[' ;
RBRACK  : ']' ;
LPAREN  : '(' ;
RPAREN  : ')' ;
COMMA   : ',' ;
SEMI    : ';' ;
DOTDOT  : '..' ;

// Cadenas con 'bfhjk'
STRING  : '"' ('b'|'f'|'h'|'j'|'k')+ '"' ;

// Espacios en blanco (se ignoran)
WS  : [ \t\r\n]+ -> skip ;