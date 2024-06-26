lexer grammar LinguagemAlgoritmicaLexer;

COMENTARIO :   '{' ~('\n'|'\r')* '}' {skip();};
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
NUM_INT	: ('0'..'9')+;
NUM_REAL	: ('0'..'9')+ ('.' ('0'..'9')+)?;
MAIS : '+';
MENOS : '-';
VEZES : '*';
DIV : '/';
ATRIB : '<-';
PORCENTO : '%';
COMERCIAL : '&';
ELEVADO : '^';
REGISTRO : 'registro';
FIM_REGISTRO : 'fim_registro';
PONTO : '.';
IGUAL : '=';
DIFERENTE : '<>';
MAIOR : '>';
MENOR : '<';
MAIOR_IGUAL : '>=';
MENOR_IGUAL : '<=';
E : 'e';
NAO : 'nao';
OU : 'ou';
LOGICO : 'logico';
SE : 'se';
ENTAO : 'entao';
SENAO : 'senao';
FIM_SE : 'fim_se';
CASO : 'caso';
SEJA : 'seja';
FIM_CASO : 'fim_caso';
DOIS_PONTOS : '..';
PARA : 'para';
ATE : 'ate';
FACA : 'faca';
FIM_PARA : 'fim_para';
ENQUANTO : 'enquanto';
FIM_ENQUANTO : 'fim_enquanto';
PROCEDIMENTO : 'procedimento';
FIM_PROCEDIMENTO: 'fim_procedimento';
FUNCAO : 'funcao';
RETORNE : 'retorne';
FIM_FUNCAO : 'fim_funcao';
TIPO : 'tipo';
VAR : 'var';
CONST : 'constante';
VERDADEIRO : 'verdadeiro';
FALSO : 'falso';

CADEIA_NAO_FECHADA: '"' (ESC_SEQ | ~('\n'|'"'|'\\'))* '\n';
SIMB_N_IDENT : '}' | '$' | '~';
COMENTARIO_N_FECHADO : '{' ~'}'*;

IDENT : ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
	;
fragment
ESC_SEQ	: '\\\'';
WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {skip();}
    ;

DELIM	:	':';
ABRECOL :   '[';
FECHACOL:   ']';
ABREPAR :	'(';
FECHAPAR:	')';


ERRO: .;