package br.ufscar.dc.compiladores.churras.gerador.calculadoras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import br.ufscar.dc.compiladores.churras.gerador.TabelaDeSimbolos;
import br.ufscar.dc.compiladores.churras.gerador.TabelaDeSimbolos.TipoLc;

/*
Calcula a lista de compras com base na propriedade "Raiz"
*/
public class RaizCalculator extends Calculator {

    @Override
    public String retornaListaDeCompras(TabelaDeSimbolos tabela) {

        // Pega os mercados da tabela de simbolos
        List<Mercado> listaDeMercados = tabela.getTabela().values().stream()
                .filter(entrada -> entrada.tipo.equals(TipoLc.MERCADO))
                .map(mercado -> new Mercado(mercado.nome,
                        mercado.items.getTabela().values()
                                .stream()
                                .map(Item::new)
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());

        // Extrai a lista de compras da tabela de simbolos
        List<Item> listaDeCompra = tabela.getTabela().values().stream()
                .filter(entrada -> !entrada.tipo.equals(TipoLc.MERCADO))
                .map(Item::new)
                .collect(Collectors.toList());

        List<Mercado> lista_compra_mercado = new ArrayList<>();
        Mercado mercado_escolhido = null;
        Item itemParaCompra = null;
        Float custoBeneficoAtual = 0.0f;

        // Itera sobre a lista de compra para procurar cada item no mercado
        for (Item item : listaDeCompra) {

            itemParaCompra = null;
            custoBeneficoAtual = 0.0f;
            mercado_escolhido = null;

            // Itera sobre mercados para verificar se contém o item
            for (Mercado mercado : listaDeMercados) {
                for (Item itemMercado : mercado.getItems()) {
                    // Verifica se o item esta presente no mercado e se o custo beneficio dele é
                    // melhor que o item separado para compra atual
                    if (itemMercado.equals(item) && itemMercado.getCustoBeneficio() > custoBeneficoAtual) {
                        // Armazena o item e os mercados que serão comprados
                        itemParaCompra = itemMercado;
                        custoBeneficoAtual = itemMercado.getCustoBeneficio();
                        mercado_escolhido = mercado;
                    }
                }
            }

            if (itemParaCompra != null) {
                // Calcula quantas unidades comprar daquele item para suprir a lista
                itemParaCompra.setQuantoComprar(item.getMedida());

                // Adiciona um new mercado com o item na lista de compra por mercado gerado no final, se não estiver na lista
                // Caso contrário, adiciona o item no mercado que já esta na lista
                if (lista_compra_mercado.contains(mercado_escolhido)) {
                    lista_compra_mercado.get(lista_compra_mercado.indexOf(mercado_escolhido))
                            .adicionarItem(itemParaCompra);
                } else {
                    lista_compra_mercado.add(
                            new Mercado(mercado_escolhido.getNome(), new ArrayList<>(Arrays.asList(itemParaCompra))));
                }

            }

        }

        // Retorna a pagina gerado pelo metodo baseado na lista a se comprar ordenada por mercado
        return super.retornaListaHtmlMercado(lista_compra_mercado);
    }
}
