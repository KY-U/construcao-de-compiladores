# T4 - Construção de Compiladores - Prof. Daniel Lucrédio

## Especificações:
O trabalho 4 (T4) da disciplina consiste em implementar uma segunda parte de um analisador semântico para a linguagem LA (Linguagem Algorítmica) desenvolvida pelo prof. Jander, no âmbito do DC/UFSCar.

### Analisador semântico:

O analisador semântico deve detectar, além daqueles do T3, outros 5 tipos de erros:

- Identificador (variável, constante, procedimento, função, tipo) já declarado anteriormente no escopo.
    - O mesmo identificador não pode ser usado novamente no mesmo escopo mesmo que para categorias diferentes

- Identificador (variável, constante, procedimento, função) não declarado

- Incompatibilidade entre argumentos e parâmetros formais (número, ordem e tipo) na chamada de um procedimento ou uma função
    - A quantidade e tipo dos argumentos deve ser exata:
        ```
        endereço → ponteiro
        real → real
        inteiro → inteiro
        literal → literal
        logico → logico
        registro → registro (com mesmo nome de tipo)
        ```

- Atribuição não compatível com o tipo declarado, agora envolvendo ponteiros e registros
    - Atribuições possíveis
      ```
      ponteiro ← endereço
      (real | inteiro) ← (real | inteiro)
      literal ← literal
      logico ← logico
      ```
    - As mesmas restrições são válidas para expressões, por exemplo, ao tentar combinar um literal com um logico (como em literal + logico) deve dar tipo_indefinido e inviabilizar a atribuição
- Uso do comando 'retorne' em um escopo não permitido

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
java -jar <path-até-repositório>/T4/linguagem-algoritmica/target/linguagem-algoritmica-1.0-SNAPSHOT-jar-with-dependencies.jar <path-até-linguagem-algoritmica>/entrada.txt <path-até-linguagem-algoritmica>/saida.txt
```
### Executar com casos de teste:
Verificar Java 11.0.2 com:
```
java -version
``` 
Executar substituindo os devidos path:
```
java -jar <path-ate-repositorio>/compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar "java -jar <path-até-linguagem-algoritmica>/target/linguagem-algoritmica-1.0-SNAPSHOT-jar-with-dependencies.jar" gcc <path-até-repositório>/T4/linguagem-algoritmica/corretor/saidaProduzida/saida_t4 <path-ate-repositorio>/T1/casos-de-teste/casos-de-teste "802215, 801057, 790894" t4
