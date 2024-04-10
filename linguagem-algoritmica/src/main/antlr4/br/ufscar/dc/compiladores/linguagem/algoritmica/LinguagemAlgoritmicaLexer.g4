lexer grammar LinguagemAlgoritmicaLexer;

COMENTARIO: '{' ~'}'* '}';
REAL: 'real';
ALGORITMO : 'algoritmo';
DECLARE : 'declare';
LITERAL : 'literal';
INTEIRO : 'inteiro';
LEIA : 'leia';
ESCREVA : 'escreva';
FIM_ALGORITMO : 'fim_algoritmo';
CADEIA : '"' ~('"')* '"';
VIRGULA : ',';
MAIS : '+';
MENOS : '-';
VEZES : '*';
DIV : '/';
ATRIB : '<-';
NUM_INT	: ('+'|'-')?('0'..'9')+;
NUM_REAL	: ('+'|'-')?('0'..'9')+ ('.' ('0'..'9')+)?;
 
	 
IDENT : ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'0'..'9')*
	;
fragment
ESC_SEQ	: '\\\'';
WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {skip();}
    ;
OP_REL	:	'>' | '>=' | '<' | '<=' | '<>' | '='
	;
DELIM	:	':'
	;
ABREPAR :	'('
	;
FECHAPAR:	')'
	;