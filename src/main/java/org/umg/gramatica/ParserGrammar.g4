parser grammar ParserGrammar;

options {
    tokenVocab = LexerGrammar;
}

programa: declaracion+ EOF;

declaracion
    : estructuraTitan
    | estructuraAtaque
    | estructuraMuro
    | sentenciaOrden
    | asignacion
    | expresion SEMI
    ;

asignacion
    : SCOUT '=' expresion SEMI
    ;

estructuraTitan
    : TITAN LPAREN expresion RPAREN bloque (LEGION bloque)?
    ;

estructuraAtaque
    : ATAQUE LPAREN expresion RPAREN bloque
    ;

estructuraMuro
    : MURO LPAREN expresion SEMI expresion SEMI expresion RPAREN bloque
    ;

sentenciaOrden: ORDEN expresion SEMI;

bloque
    : LBRACE declaracion* RBRACE
    | declaracion
    ;

expresion
    : expresion (MULT | DIV | ADD | SUB) expresion    # ExpresionBinaria
    | expresion (MAYOR_QUE | MENOR_QUE | IGUALDAD | DESIGUALDAD) expresion # ExpresionBinaria
    | LPAREN expresion RPAREN               # ExpresionParentesis
    | NUMERO                                 # ExpresionNumero
    | GRITO                                  # ExpresionString
    | SCOUT                                  # ExpresionIdentificador
    ;

