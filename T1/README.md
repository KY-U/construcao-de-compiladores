# T1 - Construção de Compiladores - Prof. Daniel Lucrédio

## Especificações:
 O trabalho 1 (T1) da disciplina consiste em implementar um analisador léxico para a linguagem LA (Linguagem Algorítmica) desenvolvida pelo prof. Jander, no âmbito do DC/UFSCar. O analisador léxico deve ler um programa-fonte e produzir uma lista de tokens identificados. Exemplo:
### Entrada
```
{ leitura de nome e idade com escrita de mensagem usando estes dados }
algoritmo
	declare
		nome: literal
	declare
		idade: inteiro

	{ leitura de nome e idade do teclado }
	leia(nome)
	leia(idade)

	{ saída da mensagem na tela }
	escreva(nome, " tem ", idade, " anos.")
fim_algoritmo
```
### Saída produzida:
```
<'algoritmo','algoritmo'>
<'declare','declare'>
<'nome',IDENT>
<':',':'>
<'literal','literal'>
<'declare','declare'>
<'idade',IDENT>
<':',':'>
<'inteiro','inteiro'>
<'leia','leia'>
<'(','('>
<'nome',IDENT>
<')',')'>
<'leia','leia'>
<'(','('>
<'idade',IDENT>
<')',')'>
<'escreva','escreva'>
<'(','('>
<'nome',IDENT>
<',',','>
<'" tem "',CADEIA>
<',',','>
<'idade',IDENT>
<',',','>
<'" anos."',CADEIA>
<')',')'>
<'fim_algoritmo','fim_algoritmo'>
```
Espaços em branco e comentários devem ser ignorados.

Em caso de erro léxico, o programa deve interromper a execução e reportar o erro, indicando o primeiro símbolo onde o erro ocorre. Exemplo:

### Entrada:
```
{ leitura de nome e idade com escrita de mensagem usando estes dados }

algoritmo
	declare
		nome~ literal
	declare
		idade: inteiro

	{ leitura de nome e idade do teclado }
	leia(nome)
	leia(idade)

	{ saída da mensagem na tela }
	escreva(nome, " tem ", idade, " anos.")

fim_algoritmo
```
### Saída produzida:
```
<'algoritmo','algoritmo'>
<'declare','declare'>
<'nome',IDENT>
Linha 5: ~ - simbolo nao identificado
```

### Dependências:
Java Framework:

    Junit
        Versão: 4.11.1

Gerador de parser para ler, processar, executar ou traduzir textos ou arquivos binários estruturados:

    ANTLR(antlr4) 
        Versão4.11.1

Plugins Maven:

    antlr4-maven-plugin 
        Versão4.11.1
    maven-assembly-plugin 
        Versão 3.1.0

Gerenciamento de Plugins:

    maven-clean-plugin
        Versão: 3.1.0

    maven-resources-plugin
        Versão: 3.0.2

    maven-compiler-plugin
        Versão: 3.8.0

    maven-surefire-plugin
        Versão: 2.22.1

    maven-jar-plugin
        Versão: 3.0.2

    maven-install-plugin
        Versão: 2.5.2

    maven-deploy-plugin
        Versão: 2.8.2

    maven-site-plugin
        Versão: 3.7.1

    maven-project-info-reports-plugin
        Versão: 3.0.0
### Buildar:
```
mvn package
```
### Executar:
```
java -jar <path-até-repositório>/T1/linguagem-algoritmica/target/linguagem-algoritmica-1.0-SNAPSHOT-jar-with-dependencies.jar <path-até-linguagem-algoritmica>/entrada.txt <path-até-linguagem-algoritmica>/saida.txt
```
### Executar com casos de teste:
Verificar Java 11.0.2 com:
```
java -version
``` 
Executar substituindo os devidos path:
```
java -jar <path-ate-repositorio>/compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar "java -jar <path-até-linguagem-algoritmica>/target/linguagem-algoritmica-1.0-SNAPSHOT-jar-with-dependencies.jar" gcc <path-até-repositório>/T1/linguagem-algoritmica/corretor/temp/saidaProduzida/saida_t1 <path-ate-repositorio>/T1/casos-de-teste/casos-de-teste "802215, 801057, 790894" t1
```
