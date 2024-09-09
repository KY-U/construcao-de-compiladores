# T4 - Construção de Compiladores - Prof. Daniel Lucrédio

## Especificações:
O trabalho 4 (T4) da disciplina consiste em implementar uma segunda parte de um analisador semântico para a linguagem LA (Linguagem Algorítmica) desenvolvida pelo prof. Jander, no âmbito do DC/UFSCar.

### Entrada:

```
algoritmo
  declare
    x: literal
  leia(x)
  escreva(x)
fim_algoritmo
```

### Saída Produzida:

```
#include <stdio.h>
#include <stdlib.h>
int main() {
	char x[80];
	gets(x);
	printf("%s",x);
	return 0;
}

```
**IMPORTANTE:** o código gerado não precisa ser idêntico ao fornecido nos casos de teste, mas ele deve ser compilável usando GCC, e sua EXECUÇÃO deve ser a mesma que a dos casos de teste. O corretor automático irá compilar o código gerado (usando GCC), executá-lo e comparar a entrada/saída com o que é esperado.

**Juntando o analisador semântico com o gerador de código em um único executável**

A saída do executável final, que irá combinar analisador léxico+sintático+semântico+gerador, depende da entrada:
- Se a entrada tiver algum erro (léxico ou sintático ou semântico) a saída deve conter a descrição dos erros;
- Se a entrada não tiver nenhum erro, a saída deve conter o código gerado.

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
java -jar <path-ate-repositorio>/compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar "java -jar <path-até-linguagem-algoritmica>/target/linguagem-algoritmica-1.0-SNAPSHOT-jar-with-dependencies.jar" gcc <path-até-repositório>/T4/linguagem-algoritmica/corretor/temp/saidaProduzida/saida_t4 <path-ate-repositorio>/T1/casos-de-teste/casos-de-teste "802215, 801057, 790894" t4
