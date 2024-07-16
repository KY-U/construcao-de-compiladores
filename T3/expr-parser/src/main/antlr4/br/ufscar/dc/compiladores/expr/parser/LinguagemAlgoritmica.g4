grammar LinguagemAlgoritmica;

COMENTARIO : '{' ~('\n'|'\r')* '}' {skip();};
REAL: 'real';
ALGORITMO : 'algoritmo';
DECLARE : 'declare';
LITERAL : 'literal';
INTEIRO : 'inteiro';
LEIA : 'leia';
ESCREVA : 'escreva';
FIM_ALGORITMO : 'fim_algoritmo';
CADEIA : '"' ( ~["\r\n] | '""' )* '"';
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
MAIOR_IGUAL : '>=';
MENOR_IGUAL : '<=';
MAIOR : '>';
MENOR : '<';
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
SIMB_N_IDENT : '}' | '$' | '~';
CADEIA_N_FECHADA : '"' ~('\n'|'"')* '\n';
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

ERRO : .;

programa : declaracoes ALGORITMO corpo FIM_ALGORITMO EOF;
declaracoes : (decl_local_global)*;
decl_local_global : declaracao_local | declaracao_global;

declaracao_local : DECLARE variavel
                 | CONST IDENT DELIM tipo_basico IGUAL valor_constante
                 | TIPO IDENT DELIM tipo
                 ;

variavel : identificador (VIRGULA identificador)* DELIM tipo;
identificador : IDENT (PONTO IDENT)* dimensao;
dimensao : (ABRECOL exp_aritmetica FECHACOL)*;
tipo : registro | tipo_estendido;
tipo_basico : LITERAL | INTEIRO | REAL | LOGICO;
tipo_basico_ident : tipo_basico | IDENT;
tipo_estendido : (ELEVADO)? tipo_basico_ident;
valor_constante : CADEIA | NUM_INT | NUM_REAL | VERDADEIRO | FALSO;
registro : REGISTRO (variavel)* FIM_REGISTRO;
declaracao_global : PROCEDIMENTO IDENT ABREPAR (parametros)? FECHAPAR (declaracao_local)* (cmd)* FIM_PROCEDIMENTO
                  | FUNCAO IDENT ABREPAR (parametros)? FECHAPAR DELIM tipo_estendido (declaracao_local)* (cmd)* FIM_FUNCAO
                  ;
parametro : (VAR)? identificador (VIRGULA identificador)* DELIM tipo_estendido;
parametros : parametro (VIRGULA parametro)*;
corpo : (declaracao_local)* (cmd)*;
cmd : cmdLeia | cmdEscreva | cmdSe | cmdCaso | cmdPara | cmdEnquanto | cmdFaca | cmdAtribuicao | cmdChamada | cmdRetorne;
cmdLeia : LEIA ABREPAR (ELEVADO)? identificador (VIRGULA (ELEVADO)? identificador)* FECHAPAR;
cmdEscreva : ESCREVA ABREPAR expressao (VIRGULA expressao)* FECHAPAR;
cmdSe : SE expressao ENTAO (cmd)* (SENAO (cmd)*)? FIM_SE;
cmdCaso : CASO exp_aritmetica SEJA selecao (SENAO (cmd)*)? FIM_CASO;
cmdPara : PARA IDENT ATRIB exp_aritmetica ATE exp_aritmetica FACA (cmd)* FIM_PARA;
cmdEnquanto : ENQUANTO expressao FACA (cmd)* FIM_ENQUANTO;
cmdFaca : FACA (cmd)* ATE expressao;
cmdAtribuicao : (ELEVADO)? identificador ATRIB expressao;
cmdChamada : IDENT ABREPAR expressao (VIRGULA expressao)* FECHAPAR;
cmdRetorne : RETORNE expressao;
selecao : (item_selecao)*;
item_selecao : constantes DELIM (cmd)*;
constantes : numero_intervalo (VIRGULA numero_intervalo)*;
numero_intervalo : (op_unario)? NUM_INT (DOIS_PONTOS (op_unario)? NUM_INT)?;
op_unario : MENOS;
exp_aritmetica : termo (op1 termo)*;
termo : fator (op2 fator)*;
fator : parcela (op3 parcela)*;
op1 : MAIS | MENOS;
op2 : VEZES | DIV;
op3 : PORCENTO;
parcela : (op_unario)? parcela_unario | parcela_nao_unario;
parcela_unario : (ELEVADO)? identificador
               | IDENT ABREPAR expressao (VIRGULA expressao)* FECHAPAR
               | NUM_INT
               | NUM_REAL
               | ABREPAR expressao FECHAPAR
               ;
parcela_nao_unario : COMERCIAL identificador | CADEIA;
exp_relacional : exp_aritmetica (op_relacional exp_aritmetica)?;
op_relacional : IGUAL | DIFERENTE | MAIOR_IGUAL | MENOR_IGUAL | MAIOR | MENOR;
expressao : termo_logico (op_logico_1 termo_logico)*;
termo_logico : fator_logico (op_logico_2 fator_logico)*;
fator_logico : (NAO)? parcela_logica;
parcela_logica : ( VERDADEIRO | FALSO ) | exp_relacional;
op_logico_1 : OU;
op_logico_2 : E;