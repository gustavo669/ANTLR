parser grammar ParserGrammar;

options {
    tokenVocab = LexerGrammar;
}

programa: declaracion* EOF;

// === Declaraciones ===
declaracion
    : estructuraTitan
    | estructuraAtaque
    | estructuraMuro
    | sentenciaOrden
    | asignacion
    | expresion SEMI
    ;

// === Asignación ===
asignacion
    : ID '=' expresion SEMI
    ;

// === Estructuras temáticas ===
estructuraTitan
    : TITAN LPAREN expresion RPAREN bloque (LEGION bloque)?
    ;

estructuraAtaque
    : ATAQUE LPAREN expresion RPAREN bloque
    ;

estructuraMuro
    : MURO LPAREN expresion SEMI expresion SEMI expresion RPAREN bloque
    ;

sentenciaOrden
    : ORDEN expresion SEMI
    ;

// === Bloques ===
bloque
    : '{' declaracion* '}'
    ;

// === Expresiones (precedencia y jerarquía) ===
expresion
    : expresion op=(MUL | DIV) expresion         #ExprMultiplicacion
    | expresion op=(ADD | SUB) expresion         #ExprSuma
    | expresion op=(MAYOR_QUE | MENOR_QUE | IGUALDAD | DESIGUALDAD) expresion #ExprComparacion
    | '(' expresion ')'                          #ExprParentesis
    | NUMERO                                     #ExprNumero
    | GRITO                                      #ExprString
    | ID                                         #ExprVariable
    ;
