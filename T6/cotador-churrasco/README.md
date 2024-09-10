# T6 - Cotador de Churrasco Inteligente
### Compiladores 2024/1
### Alunos:
Leandro Baldini Nogueira, RA: 801057

Caio Ueda Sampaio, RA: 802215

Pedro Lealdini, RA: 790894

[**Vídeo:**](https://youtu.be/VM7kl3XPQ04)

### Descrição:
A linguagem tem como objetivo auxiliar na cotação de produtos destinados a um churrasco, com a ideia de selecionar os produtos mais baratos ou mais caros de uma gama de mercados:
- **Raiz**: Escolhe os produtos mais baratos.
- **Nutella**: Escolhe os produtos mais caros.

O programa gera um arquivo:
- **Nome da Lista**;
- **Propriedade**: Propriedade desejada da lista;
- **Lista de Mercados**:
  - **Nome do Mercado**;
  - **Propriedades**:
    - **Produto**: Nome do Produto;
    - **Medida**: Quantidade e Unidade de Medida ofertada por unidade do Produto na Loja;
    - **Valor Unitário**;
    - **Valor Total**: Valor Total do Produto;
  - **Total**: Valor Total da Compra na Loja;
- **Valor Total**: Valor Total da Lista de Compras.

### Regras Semânticas:
Mercado:
- Verifica se o mercado já foi declarado


Lista de ingredientes:
- Verifica se o item já foi declarado
- Verifica se o item existe em algum mercado
- Verifica se a unidade é compatível com o item do mercado

### Para Rodar:
```
java -jar C:\cotador-churrasco\target\cotador-churrasco-1.0-SNAPSHOT-jar-with-dependencies.jar C:\cotador-churrasco\casos_de_teste\gerador\2_demonstracao_cafe_da_manha.txt C:\cotador-churrasco\casos_de_teste\saida\saida.html
```

Deck de [Apresentação](https://www.canva.com/design/DAGQTU-0NtA/yCmPKApe_ET6tRb_7cgFug/edit?utm_content=DAGQTU-0NtA&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton)
