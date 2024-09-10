grammar Churras;

// Palavras chave da gramática, são palavras reservadas da gramática, executam uma função
PALAVRA_CHAVE: 'MERCADOS' | 'NOME' | 'ITEM' | 'MEDIDA' | 'QUANTIDADE' | 'PREÇO' | 'LISTA' | 'PROPRIEDADE' | 'PARTIU';

UNIDADE: 'UN' | 'KG' | 'L';

PROPRIEDADE: 'Raiz' | 'Nutella' ;

DELIM: ':';

// Identificadores INT e FLOAT
NUM_INT: ('0'..'9')+;

NUM_REAL: ('0'..'9')+ (',' ('0'..'9')+)?;

// Ignora espaços em branco
WS: ( ' ' | '\t' | '\r' | '\n') {skip();};

// Reconhecedor de variáveis, podem iniciar com qualquer letra ou "_"
IDENT: ('a'..'z'|'A'..'Z')+ (( ' ' )? ('a'..'z'|'A'..'Z'|'0'..'9')+)*;

// Símbolos não identificados param aqui
ERRO: .;

programa: 'MERCADOS' mercado+ 'LISTA' lista 'PARTIU';

mercado: 'NOME' DELIM IDENT item_mercado+;

item_mercado: 'ITEM' DELIM IDENT 'MEDIDA' DELIM quant = numero UNIDADE 'PREÇO' DELIM valor = numero;

numero: NUM_INT | NUM_REAL;

lista: 'NOME' DELIM IDENT 'PROPRIEDADE' DELIM PROPRIEDADE item_lista+;

item_lista: 'ITEM' DELIM IDENT 'QUANTIDADE' DELIM quant = numero UNIDADE;