# T3 - Construção de Compiladores - Prof. Daniel Lucrédio

## Especificações:
O trabalho 3 (T3) da disciplina consiste em implementar parte de um analisador semântico para a linguagem LA (Linguagem Algorítmica) desenvolvida pelo prof. Jander, no âmbito do DC/UFSCar.

### Analisador semântico:

O analisador semântico deve detectar 4 tipos de erros:

- Identificador (variável, constante, procedimento, função, tipo) já declarado anteriormente no escopo.
    - O mesmo identificador não pode ser usado novamente no mesmo escopo mesmo que para categorias diferentes

- Tipo não declarado

- Identificador (variável, constante, procedimento, função) não declarado

- Atribuição não compatível com o tipo declarado
    - Atribuições possíveis:
        ```
        ponteiro ← endereço
        (real | inteiro) ← (real | inteiro)
        literal ← literal
        logico ← logico
        registro ← registro (com mesmo nome de tipo)
        ```

    - As mesmas restrições são válidas para expressões, por exemplo, ao tentar combinar um literal com um logico (como em literal + logico) deve dar tipo_indefinido e inviabilizar a atribuição

Ao encontrar um erro, o analisador **NÃO DEVERÁ** interromper sua execução. Ele deverá continuar reportando erros até o final do arquivo. Exemplo:

### Entrada
```
{ leitura de nome e idade com escrita de mensagem usando estes dados }

algoritmo
	declare
		nome: literal
	declare
		idade: inteir

	{ leitura de nome e idade do teclado }
	leia(nome)
	leia(idades)

	{ saída da mensagem na tela }
	escreva(nome, " tem ", idade, " anos.")

fim_algoritmo

```
### Saída produzida:
```
Linha 7: tipo inteir nao declarado
Linha 11: identificador idades nao declarado
Fim da compilacao
```
Na dúvida, utilize os casos de teste como guia. Caso uma verificação particular não esteja presente nos casos de teste, não será preciso implementar.

O analisador deve poder ser executado em linha de comando (windows, mac ou linux), com DOIS ARGUMENTOS OBRIGATORIAMENTE:
- Argumento 1: arquivo de entrada (caminho completo)
- Argumento 2: arquivo de saída (caminho completo)

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
java -jar <path-ate-repositorio>/compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar "java -jar <path-até-linguagem-algoritmica>/target/linguagem-algoritmica-1.0-SNAPSHOT-jar-with-dependencies.jar" gcc <path-até-repositório>/T3/linguagem-algoritmica/corretor/temp/saidaProduzida/saida_t3 <path-ate-repositorio>/T1/casos-de-teste/casos-de-teste "802215, 801057, 790894" t3
```