package br.ufscar.dc.compiladores.churras.gerador;

import br.ufscar.dc.compiladores.churras.gerador.TabelaDeSimbolos.TipoLc;
import br.ufscar.dc.compiladores.churras.gerador.calculadoras.InterfaceCalc;
import br.ufscar.dc.compiladores.churras.gerador.calculadoras.NutellaCalculator;
import br.ufscar.dc.compiladores.churras.gerador.calculadoras.RaizCalculator;
import br.ufscar.dc.compiladores.parser.ChurrasBaseVisitor;
import br.ufscar.dc.compiladores.parser.ChurrasParser.MercadoContext;
import br.ufscar.dc.compiladores.parser.ChurrasParser.Item_listaContext;
import br.ufscar.dc.compiladores.parser.ChurrasParser.ProgramaContext;
import br.ufscar.dc.compiladores.parser.ChurrasParser.Item_mercadoContext;
//import br.ufscar.dc.compiladores.parser.ChurrasParser;

public class ChurrasGerador extends ChurrasBaseVisitor<Void> {

    TabelaDeSimbolos tabela;
    StringBuilder saida;

    public ChurrasGerador() {
        saida = new StringBuilder();
        this.tabela = new TabelaDeSimbolos();
    }

    @Override
    public Void visitPrograma(ProgramaContext ctx) {
        // Adiciona o Início do HTML (até chegar na tabela)
        String nomeLista = ctx.lista().IDENT().getText();
        saida.append("<!DOCTYPE html>\n<html lang='pt'>\n<head>\n");
        saida.append("<meta charset='UTF-8'>\n<meta name='viewport' content='width=device-width, initial-scale=1.0'>\n");
        saida.append("<link rel='stylesheet' type='text/css' href='estilo.css'>\n"); // Referencia o arquivo CSS
        saida.append("<title>" + nomeLista + "</title>\n</head>\n<body>\n<h1>" + nomeLista + "</h1>\n");
    
        // Adiciona os mercados em cards
        for (MercadoContext mercado : ctx.mercado()) {
            visitMercado(mercado);
        }
    
        // Adiciona os items da lista na tabela de símbolos
        for (Item_listaContext itemLista : ctx.lista().item_lista()) {
            tabela.adicionar(itemLista.IDENT().getText(),
                    ChurrasSemanticoUtils.verificaTipo(itemLista.UNIDADE().getText()), null, null, itemLista.quant.getText());
        }
    
        // Adiciona o card para a lista de items comprados
        String propriedadeLista = ctx.lista().PROPRIEDADE().getText();
        saida.append("<h2>Lista de Itens Comprados (" + propriedadeLista + ")</h2>\n");

    
        // Adiciona a tabela de items comprados dentro do card
        InterfaceCalc nivelDoChurras = null;
        switch (propriedadeLista) {
            case "Raiz":
                nivelDoChurras = new RaizCalculator();
                break;
            case "Nutella":
                nivelDoChurras = new NutellaCalculator();
                break;
            default:
                break;
        }
    
        saida.append(nivelDoChurras.retornaListaDeCompras(tabela));
        saida.append("</tbody>\n</table>\n");
    
        // Adiciona o restante do HTML
        saida.append("</body>\n</html>");
        return null;
    }
    
    @Override
    public Void visitMercado(MercadoContext ctx) {
        String nomeMercado = ctx.IDENT().getText();
        TabelaDeSimbolos tabelaItems = new TabelaDeSimbolos();
        // Adiciona mercado e seus items na tabela
        saida.append("<div class='card'>\n<div class='card-header'>" + nomeMercado + "</div>\n");
        saida.append("<div class='card-content'>\n<ul>\n"); // Lista de items
    
        for (Item_mercadoContext item : ctx.item_mercado()) {
            tabelaItems.adicionar(item.IDENT().getText(),
                    ChurrasSemanticoUtils.verificaTipo(item.UNIDADE().getText()), null,
                    item.valor.getText(), item.quant.getText());
            saida.append("<li>" + item.IDENT().getText() + ": " +
                         item.quant.getText() + " " + item.UNIDADE().getText() +
                         " (" + item.valor.getText() + " R$)</li>\n");
        }
        saida.append("</ul>\n</div>\n</div>\n"); // Fecha o card-content e o card
        tabela.adicionar(nomeMercado, TipoLc.MERCADO, tabelaItems, null, null);
        return null;
    }
}


