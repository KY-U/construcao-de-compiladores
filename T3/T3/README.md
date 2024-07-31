# T3: Analisador Semântico (Parte 1)

Neste repositório encontra-se o terceiro trabalho da disciplina Construção de Compiladores, referente à primeira parte do desenvolvimento de um analisador semântico. Abaixo estão documentadas as instruções de execução do programa.

## Instruções de uso

O trabalho foi desenvolvido com a IDE NetBeans. Deste modo, para preservar sua estrutura original e facilitar seu posterior uso por outros usuários, espera-se que ele seja executado com o próprio NetBeans. Durante o desenvolvimento, foi utilizada a versão 13 do NetBeans e a versão 18.0.1.1 do Java. Espera-se que seja possível executá-lo em versões mais recentes de ambos. O programa foi desenvolvido no Windows 10 e suas instruções de uso também serão apresentadas neste SO. Além disso, também foi utilizado o Apache Maven, para gerenciamento do projeto (informações sobre sua instalação podem ser encontradas [aqui](https://www.devmedia.com.br/introducao-ao-maven/25128#2)), e, de forma integrada, a versão mais recente do ANTLR, para a geração da análise de acordo com as especificações do trabalho (maiores detalhes podem ser encontrados [aqui](https://www.antlr.org/)).

Para a execução e melhor compreensão do trabalho, são necessários:
- [O arquivo .rar do projeto](https://drive.google.com/file/d/1j_XNvRW7pPzo5fPz3hW8K-tbLwTsIF27/view?usp=sharing);
- [Os casos de teste disponibilizados pelo professor](https://drive.google.com/file/d/1Q2J-eIzQ199C4dzpZikBTZvXfYw5YIXv/view?usp=sharing), com suas respectivas saídas esperadas para posterior comparação;
- [Definição da gramática utilizada](https://drive.google.com/file/d/1Cv9m52E5r72jb3sLI04Jyqc29Cykn5RQ/view?usp=sharing). Esta gramática foi adaptada dentro das definições do ANTLR e pode ser visualizada no arquivo [t3Gram.g4](https://github.com/GuilhermeSGodoy/Construcao-Compiladores/blob/main/T3/src/main/antlr4/br/ufscar/dc/compiladores/t3/t3Gram.g4);
- [Descrição da gramática definida com o ANTLR](https://github.com/GuilhermeSGodoy/Construcao-Compiladores/blob/main/T2/README.md). Como não foram feitas alterações na gramática, maiores informações podem ser encontradas na descrição do trabalho anterior.

Após ser baixado e descompactado, o programa pode ser aberto no NetBeans para melhor visualização e manutenção.

![alt text](https://github.com/GuilhermeSGodoy/Construcao-Compiladores/blob/main/T1/doc-images/1.png)

Caso novas alterações sejam feitas, o programa deve ser construído novamente para que as mudanças sejam efetivadas.

![alt text](https://github.com/GuilhermeSGodoy/Construcao-Compiladores/blob/main/T1/doc-images/2.png)

Isto não é necessário para sua execução, entretanto. Para executá-lo, basta localizar o arquivo **t3-1.0-SNAPSHOT-jar-with-dependencies.jar** na pasta _target_. Por questões de conveniência, talvez seja necessário copiar este arquivo para um diretório de melhor acesso, considerando que será necessária a utilização de linhas de comando nos passos a seguir.

Com o arquivo em um diretório de fácil acesso, abra uma janela do _prompt de comandos_ do Windows e utilize o seguinte comando:

**java -jar (diretório do arquivo .jar) (diretório do caso de teste) (diretório do arquivo de saída)**

Onde:
- O diretório do arquivo .jar é a localização do arquivo **t3-1.0-SNAPSHOT-jar-with-dependencies.jar**;
- O diretório do caso de teste é a localização de um arquivo.txt que contém um algoritmo que será analisado pelo programa;
- O diretório do arquivo de saída é a localização do arquivo.txt onde será apresentado o resultado da análise. Caso o arquivo não exista ainda, ele será criado.

Um exemplo do comando acima utilizado para a execução do programa:

**java -jar C:\Compiladores\t3-1.0-SNAPSHOT-jar-with-dependencies.jar C:\Compiladores\teste.txt C:\Compiladores\saida.txt**

**Obs: é de extrema importância que sejam utilizados os arquivos apresentados acima como os casos de teste, pois eles estão adequados para a gramática estabelecida no programa. Caso necessário, pode ser criado um novo arquivo para testes, desde que obedeça a gramática da linguagem. Caso deseje testar novos casos em uma gramática diferente, todo o arquivo t3Gram.g4 e definições nas classes Java deverão ser ajustadas.**
