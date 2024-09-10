package br.ufscar.dc.compiladores.churras.gerador.calculadoras;

import java.text.DecimalFormat;
import java.util.List;

import br.ufscar.dc.compiladores.churras.gerador.TabelaDeSimbolos;

public abstract class Calculator implements InterfaceCalc {

    @Override
    public String retornaListaDeCompras(TabelaDeSimbolos tabela) {
        return null;
    }

    // Produz o html da lista de compra que deve ser feita em cada mercado
    protected String retornaListaHtmlMercado(List<Mercado> lista_mercado) {
        StringBuilder listHtmlMercado = new StringBuilder();

        // Itera sobre os mercados da lista armazenando cada tabela como um mercado
        lista_mercado.forEach(mercado -> {
            listHtmlMercado.append("<table align=\"center\">\n<thead>\n<tr>\n<th>" + mercado.getNome()
                    + "</th>\n<th></th>\n<th></th>\n" +
                    "<th></th>\n<th></th>\n<th></th>\n</tr>\n<tr>\n<th>item</th>\n<th>Medida</th>\n<th>Quantidade</th>\n<th>Sobra</th>\n"
                    +
                    "<th>Valor Unitário</th>\n<th>Valor Total</th>\n</tr>\n</thead>\n<tbody>\n");

            // Iterador sobre os items do mercado, armazenando cada um deles em uma linha da tabela
            mercado.getItems().forEach(item -> {
                listHtmlMercado.append("<tr>\n" +
                        "<td>" + item.getNome() + "</td>\n" +
                        "<td>" + formatNumber(item.getMedida(), "0.0") + " " + item.getTipo() + "</td>\n" +
                        "<td>" + item.getQuantoComprar() + "</td>\n" +
                        "<td>" + formatNumber(item.getSobra(), "0.0") + " " + item.getTipo() + "</td>\n" +
                        "<td>R$ " + formatNumber(item.getPreco(), "0.00") + "</td>\n" +
                        "<td>R$ " + formatNumber(item.getQuantoComprar() * item.getPreco(), "0.00") + "</td>\n" +
                        "</tr>\n");
            });

            //Valor total a se gastar no mercado
            listHtmlMercado
                    .append("<tr>\n<th></th>\n<th></th>\n<th></th>\n<th></th>\n<th>Total</th>\n<th>R$  " + formatNumber(
                            mercado.getItems().stream()
                                    .mapToDouble(item -> item.getQuantoComprar() * item.getPreco()).sum(),
                            "0.00") + "</th>\n</tr>\n");
            listHtmlMercado.append("</tbody>\n</table>\n<br><br><br>\n");
        });

        //Valor total da compra geral
        Double valorTotal = lista_mercado.stream()
                .mapToDouble(mercado -> mercado.getItems().stream()
                        .mapToDouble(item -> item.getQuantoComprar() * item.getPreco())
                        .sum())
                .sum();

        listHtmlMercado.append("<table align=\"center\">\n<tr>\n<th>Valor Total</th>\n<th>R$ "
                + formatNumber(valorTotal, "0.00")
                + "</th>\n</tr>\n</table>\n");

        return listHtmlMercado.toString();
    }

    // Conforme a especificação, formata o número como desejado
    private String formatNumber(Number numero, String format) {
        DecimalFormat decimalFormat = new DecimalFormat(format);

        return decimalFormat.format(numero);
    }
}
